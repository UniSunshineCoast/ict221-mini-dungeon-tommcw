package dungeon.engine;

/**
 * Each time a player enters a cell containing a Gold object the
 * Gold.activate() method should execute regardless of whether
 * the player has entered that cell before.
 */
public class Gold extends MazeItem{
    private static final int GOLD_MODIFIER = 5;

    public Gold(){ // No-arg constructor
        this.setActive();
        this.setHpModifier(0);
        this.setScoreModifier(GOLD_MODIFIER);
    }

    public void activate(Player p){
        if (this.checkActive()) // The player shall not get the gold twice
            p.setScore(GOLD_MODIFIER);
        this.setNotActive();
    }
}