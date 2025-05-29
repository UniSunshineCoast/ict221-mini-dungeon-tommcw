package dungeon.gui;

import dungeon.engine.Cell;
import dungeon.engine.GameEngine;
import dungeon.engine.MazeItem;
import dungeon.engine.Player;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.io.InputStream;

public class Controller {
    @FXML
    private GridPane gridPane;

    GameEngine engine;
    Player thePlayer;

    @FXML
    public void handleButtonClickW(){
        System.out.println("Pressed W");
        engine.handleUserInput("W", thePlayer, engine.getSize());
        updateGui(thePlayer);
    }

    @FXML
    public void handleButtonClickA(){
        System.out.println("Pressed A");
        engine.handleUserInput("A", thePlayer, engine.getSize());
        updateGui(thePlayer);
    }

    @FXML
    public void handleButtonClickS(){
        System.out.println("Pressed S");
        engine.handleUserInput("S", thePlayer, engine.getSize());
        updateGui(thePlayer);
    }

    @FXML
    public void handleButtonClickD(){
        System.out.println("Pressed D");
        engine.handleUserInput("D", thePlayer, engine.getSize());
        updateGui(thePlayer);
    }

    @FXML
    public void initialize() {
        int mapSize = 10;
        engine = new GameEngine(mapSize);
        thePlayer = new Player();
        thePlayer.setY(mapSize - 1);
        engine.populateMap(thePlayer.getX(), thePlayer.getY(), thePlayer);
        gridPane.setStyle("-fx-background-color: #FFF8DC"); // Colour Cornsilk
        updateGui(thePlayer);
    }

    private void updateGui(Player p) {
        //Clear old GUI grid pane
        gridPane.getChildren().clear();

        //Loop through map board and add each cell into grid pane
        for(int i = 0; i < engine.getSize(); i++) {
            for (int j = 0; j < engine.getSize(); j++) {
                if (i == p.getX() && j == p.getY()) {
                    ImageView playerImage = createImageView("/player.png");
                    gridPane.add(playerImage, i, j);
                }
                else {
                    Cell cell = engine.getMap()[i][j];
                    MazeItem myItem = cell.getMazeObject();
                    ImageView imageView = selectAndCreateNode(myItem);
                    gridPane.add(imageView, i, j);}
            }
        }
        //gridPane.setGridLinesVisible(true);
    }

    /**
     * This method is a helper method to make select and creation more readable.
    */
    public ImageView createImageView(String imageName){
        InputStream imageStream = getClass().getResourceAsStream(imageName);
        if (imageStream == null) {
            System.out.println("Error loading image.");
            return new ImageView();
        }
        ImageView myView = new ImageView(new Image(imageStream));
        // Set desired size of icons
        myView.setFitWidth(60);
        myView.setFitHeight(60);
        myView.setPreserveRatio(true);
        return myView;
    }

    /**
     * This method takes any maze item and locates
     * its corresponding icon in an imageview.
     */
    public ImageView selectAndCreateNode(MazeItem item) {
        switch (item.getMapSymbol()) {
            case "E":
                return createImageView("/entry.png");
            case "G":
                return createImageView("/gold.png");
            case "L":
                return createImageView("/ladder.png");
            case "M":
                return createImageView("/melee.png");
            case "P":
                return createImageView("/player.png");
            case "H":
                return createImageView("/potion.png");
            case "R":
                return createImageView("/ranged.png");
            case "T":
                return createImageView("/trap.png");
            case " ":
                return createImageView("/empty.png");
            default:
                return new ImageView();
        }
    }

}