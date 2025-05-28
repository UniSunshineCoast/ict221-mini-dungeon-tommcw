package dungeon.engine;

public class EmptyCell extends MazeItem implements java.io.Serializable{

    public EmptyCell(){ // No-arg constructor
        this.setActive();
        this.setMapSymbol(" ");
    }

    @Override
    public void activate(Player p){
        System.out.println("You wander around in the dark.");
        p.setOverlapping(" ");
    }
}