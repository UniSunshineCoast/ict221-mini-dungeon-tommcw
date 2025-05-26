package dungeon.engine;

public class Player implements java.io.Serializable{
    final static int MAX_PLAYER_HEALTH = 10;
    private int health = MAX_PLAYER_HEALTH;
    private int x; // Players current x co-ord
    private int y; // y co-ord
    private int score = 0;
    private boolean victorious = false;
    private String overlapping = "E";

    public int getHealth() {return this.health;}
    public int getScore() {return this.score;}
    public int getX() {return this.x;}
    public void setX(int n){this.x = n;}
    public void setY(int n){this.y = n;}
    public int getY() {return this.y;}
    public void setVictorious(){victorious = true;}
    public void setNotVictorious(){victorious = false;}
    public boolean getVictorious(){return victorious;}
    public String getOverlapping() {return overlapping;}
    public void setOverlapping(String s){
        this.overlapping = s;
    }

    public void setHealth(int health) {
        int h = this.health;
        if (h + health >= MAX_PLAYER_HEALTH) {this.health = MAX_PLAYER_HEALTH;}
        else if (h + health < 1) {
            System.out.println("You have been slain.");
            this.health = 0;
        }
        else
            this.health = this.health + health;
    }

    public void setScore(int s){
        if (s < 0) {System.out.printf("error with score in player.setScore.");}
        else
            this.score = this.score + s;
    }

    public void updateCoords(char xy, int direction){
        if (direction != -1 && direction != 1) {System.out.print("error in player.updateCoords");}
        //direction should be 1 or -1
        switch (xy){
            case 'x': this.x = this.x + direction; break;
            case 'y': this.y = this.y + direction; break;
        }
    }
}