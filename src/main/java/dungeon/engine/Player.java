package dungeon.engine;

public class Player {
    final static int MAX_PLAYER_HEALTH = 10;
    private int health = MAX_PLAYER_HEALTH;
    private int x;
    private int y;
    private int score = 0;

    public int getHealth() {return this.health;}
    public int getScore() {return this.score;}
    public int getX() {return this.x;}
    public int getY() {return this.y;}

    public void setHealth(int health) {
        int h = this.health;
        if (h + health >= MAX_PLAYER_HEALTH) {this.health = MAX_PLAYER_HEALTH;}
        else if (h + health < 0) {
            System.out.print("player dies");
            // TODO: Implement death
            this.health = 0;
        }
    }

    public void setScore(int s){
        if (s > 0) {System.out.printf("error with score in player.setScore.");}
        this.score = this.score + s;
    }

    public void updateCoords(char xy, int direction){
        if (direction != -1 && direction != 1) {System.out.print("error in player.updateCoords");}
        //direction should be 1 or -1
        switch (xy){
            case 'x': this.x = this.x + direction;
            case 'y': this.y = this.y + direction;
        }
    }

}
