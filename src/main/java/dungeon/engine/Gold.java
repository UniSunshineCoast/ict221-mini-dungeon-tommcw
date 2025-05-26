package dungeon.engine;

/**
 * Each time a player enters a cell containing a Gold object the
 * Gold.activate() method should execute regardless of whether
 * the player has entered that cell before.
 */
public class Gold extends MazeItem implements java.io.Serializable{
    private static final int GOLD_MODIFIER = 2;

    public Gold(){ // No-arg constructor
        this.setActive();
        this.setHpModifier(0);
        this.setScoreModifier(GOLD_MODIFIER);
        this.setMapSymbol("G");
    }

    @Override
    public void activate(Player p){
        if (this.checkActive()){ // The player shall not get the gold twice
            p.setScore(GOLD_MODIFIER);
            System.out.printf("You pick up %d Gold.%n", GOLD_MODIFIER);
        }
        else
            System.out.println("How do we get out of here?");
        this.setNotActive();
        this.setMapSymbol(" ");
        p.setOverlapping(this.getMapSymbol());
    }
}