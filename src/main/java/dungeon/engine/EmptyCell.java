package dungeon.engine;

public class EmptyCell extends MazeItem{

    public EmptyCell(){ // No-arg constructor
        this.setActive();
        this.setMapSymbol(" ");
    }

    @Override
    public void activate(Player p){
        System.out.println("emptycelltext");
        p.setOverlapping(" ");
    }
}