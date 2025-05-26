package dungeon.engine;

public class Entry extends MazeItem implements java.io.Serializable{

    public Entry(){ // No-arg constructor
        this.setActive();
        this.setMapSymbol("E");
    }

    @Override
    public void activate(Player p){
        if (this.checkActive())
            System.out.println("This is where you entered.");
        else
            System.out.println("Seems like you have seen this entry before.");
        this.setNotActive();
        p.setOverlapping(this.getMapSymbol());
    }
}