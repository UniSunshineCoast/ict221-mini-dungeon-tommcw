package dungeon.engine;

import javafx.scene.text.Text;
import java.util.Random;
import java.util.Scanner;

public class GameEngine implements java.io.Serializable {
    private int difficulty = 3;
    private int currentLevel = 1;
    private Cell[][] map;

    /**
     * Constructor for the Game Engine.
     */
    public GameEngine(int mapDimensions) {
        clearMap(mapDimensions);
    }

    public void clearMap(int size){
        map = new Cell[size][size];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell();
                cell.setMazeObject(new EmptyCell());
                Text text = new Text(i + "," + j);
                cell.getChildren().add(text);
                map[i][j] = cell;
            }
        }

        map[0][0].setStyle("-fx-background-color: #7baaa4");
        map[size-1][size-1].setStyle("-fx-background-color: #7baaa4");

    }
    /**
     * Methods to access the game difficulty. Set, Raise and Get.
     */
    public void setDifficulty(int difficulty) {this.difficulty = difficulty;
    }

    public void raiseDifficulty(){
        if (this.difficulty < 8){
            // Do not allow the difficulty to go past 10
            this.setDifficulty(this.difficulty + 2);
        } else {this.setDifficulty(10);}
    }

    public int getDifficulty() {
        return difficulty;
    }

    public int getLevel(){return this.currentLevel;}
    public void raiseLevel(){this.currentLevel++;}
    /**
     * The size of the current game.
     */
    public int getSize() {return map.length;}

    /**
     * The map of the current game.
     *
     * @return the map, which is a 2d array.
     */
    public Cell[][] getMap() {return map;}

    /**
     * Print map to the console for text based game.
     */
    public void printMap() {
        for (int j = 0; j < this.getSize(); j++) {
            for (int i = 0; i < this.getSize(); i++) {
                System.out.print(this.getMap()[i][j].getContents() + " ");
            } // Added spacer for readability
            System.out.print("\n");
        }
    }

    /**
     * Puts objects on the map
     */
    public void populateCell(MazeItem m){
        int size = this.getSize();
        Random rand = new Random();
        int a = rand.nextInt(size);
        int b = rand.nextInt(size);
        for (int i = 0; i < 100; i++){
            if (i > 95){
                System.out.println("Error: Map size to small to populate.");
                break;
            }
            if (this.getMap()[a][b].getContents() != " "){
                a = rand.nextInt(size); // If the cell is occupied
                b = rand.nextInt(size); // try to find another.
                continue;
            }
            this.getMap()[a][b].setMazeObject(m);
            this.getMap()[a][b].setContents(m.getMapSymbol());
            break;
        }
    }

    public void populateMap(int ex, int ey, Player p){
        final int numberGold = 5;
        final int numberHealthPotions = 2;
        final int numberTraps = 5;
        final int numberMeleeM = 3;
        // Add the Entry
        if (p.getVictorious()){
            this.getMap()[p.getX()][p.getY()].setMazeObject(new Entry());
            this.getMap()[ex][ey].setContents("E");
            p.setNotVictorious();
        }
        else {
            this.getMap()[ex][ey].setMazeObject(new Entry());
            this.getMap()[ex][ey].setContents("E");

        }
        // Add the Ladder
        this.populateCell(new Ladder());
        // Add Gold, Potions, Traps and Mutants
        for (int i = 0; i < numberGold; i++){
            this.populateCell(new Gold());
        }
        for (int i = 0; i < numberHealthPotions; i++){
            this.populateCell(new HealthPotion());
        }
        for (int i = 0; i < numberMeleeM; i++){
            this.populateCell(new MeleeMutant());
        }
        for (int i = 0; i < numberTraps; i++){
            this.populateCell(new Trap());
        }
        for (int i = 0; i < this.getDifficulty(); i++){
            this.populateCell(new RangedMutant());
        }
        // Add the player
        p.setOverlapping(this.getMap()[p.getX()][p.getY()].getContents());
        this.getMap()[p.getX()][p.getY()].setContents("P");
    }

    public void processMovement(Player p){
        // Store the overlapped symbol on the player for later.
        p.setOverlapping(this.getMap()[p.getX()][p.getY()].getContents());
        // Make sure the player can see where they are.
        this.getMap()[p.getX()][p.getY()].setContents("P");
        // Enforce the consequences of the move.
        if (this.getMap()[p.getX()][p.getY()].getMazeObject() != null){
            this.getMap()[p.getX()][p.getY()].getMazeObject().activate(p);
        }
    }
    /**
     * Plays one text-based game only
     */
    public int playTextGame(int mapSize){

        Player thePlayer = new Player();
        Scanner input = new Scanner(System.in);  // use the other scanner later
        System.out.println("Please enter difficulty: 0-10");
        this.setDifficulty(input.nextInt());

        System.out.printf("The size of map is %d * %d\n", this.getSize(), this.getSize());
        thePlayer.setY(mapSize - 1);
        this.populateMap(0, this.getSize() - 1, thePlayer);
        for (int steps = 100; steps > 0; steps--){
            if (thePlayer.getHealth() == 0) break; // TODO: death
            if (thePlayer.getVictorious()) {
                this.raiseLevel();
                this.raiseDifficulty();// if Level 1 is completed.
                this.clearMap(mapSize);
                this.populateMap(thePlayer.getX(), thePlayer.getY(), thePlayer);
                thePlayer.setNotVictorious();
            }

            // Do not allow player to visit level 3.
            if (this.getLevel() > 2) break; // TODO: scoreboard

            // Output player stats and map
            System.out.printf("Player X,Y: %d,%d%n",thePlayer.getX(),thePlayer.getY());
            System.out.printf("Player HP: %d",thePlayer.getHealth());
            System.out.printf(" Score: %d",thePlayer.getScore());
            System.out.printf(" Current Level: %d%n", this.getLevel());
            System.out.printf(" Current Difficulty: %d%n", this.getDifficulty());
            this.printMap();
            System.out.println("Please enter the direction to go (WASD)");

            //Handle user input
            switch (input.next()){
                case "w","W":
                    // Check the move is allowed
                    if (thePlayer.getY() < 1) {System.out.println("You hit a wall");}
                    else { // Set any overlapped item back
                        this.getMap()[thePlayer.getX()][thePlayer.getY()].setContents(thePlayer.getOverlapping());
                        // Move the player
                        thePlayer.updateCoords('y', -1);
                        this.processMovement(thePlayer);
                    }
                    break;
                case "a","A":
                    if (thePlayer.getX() < 1) {System.out.println("You hit a wall");}
                    else {
                        this.getMap()[thePlayer.getX()][thePlayer.getY()].setContents(thePlayer.getOverlapping());
                        thePlayer.updateCoords('x', -1);
                        this.processMovement(thePlayer);
                    }
                    break;
                case "s","S":
                    if (thePlayer.getY() > mapSize - 2) {System.out.println("You hit a wall");}
                    else {
                        this.getMap()[thePlayer.getX()][thePlayer.getY()].setContents(thePlayer.getOverlapping());
                        thePlayer.updateCoords('y', 1);
                        this.processMovement(thePlayer);
                    }
                    break;
                case "d","D":
                    if (thePlayer.getX() > mapSize - 2) {System.out.println("You hit a wall");}
                    else {
                        this.getMap()[thePlayer.getX()][thePlayer.getY()].setContents(thePlayer.getOverlapping());
                        thePlayer.updateCoords('x', 1);
                        this.processMovement(thePlayer);
                    }
                    break;
                default:
                    System.out.println("Invalid move: try WASD");
            }
        }
        System.out.println("Your journey is over.");
        System.out.printf("Your Score was: %d", thePlayer.getScore());
        return thePlayer.getScore();
    }

    public static void main(String[] args) {
        final int mapSize = 10;
        GameEngine engine = new GameEngine(mapSize);
        System.out.println(engine.playTextGame(mapSize));
}}