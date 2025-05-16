package dungeon.engine;

public class Ladder extends MazeItem{

    public Ladder(){ // No-arg constructor
        this.setActive();
        this.setMapSymbol("L");
    }

    @Override
    public void activate(Player p){
        System.out.println("You climb the ladder to the next level");
        this.setNotActive();
        p.setVictorious();
        p.setOverlapping("E");
    }
}