package dungeon.engine;

/**
 * A Melee Mutant should, when activated
 * Add -2 HP and +2 to player score.
 * Also, the mutant is deactivated.
 */
public class MeleeMutant extends MazeItem{
    private static final int HP_MODIFIER = -2;
    private static final int SCORE_MODIFIER = 2;

    public MeleeMutant(){ // No-arg constructor
        this.setActive();
        this.setHpModifier(HP_MODIFIER);
        this.setScoreModifier(SCORE_MODIFIER);
        this.setMapSymbol("M");
    }

    public void activate(Player p){
        if (this.checkActive()) { // The player shall not encounter twice
            p.setHealth(HP_MODIFIER);
            p.setScore(SCORE_MODIFIER);
            System.out.println("You have slain a Melee Mutant.");
        }
        else{
            System.out.println("You see a dead Mutant.");
        }
        this.setNotActive();
        this.setMapSymbol(" ");
        p.setOverlapping(this.getMapSymbol());
    }
}