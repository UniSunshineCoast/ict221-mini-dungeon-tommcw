package dungeon.engine;
import java.util.Random;

/**
 * A Ranged Mutant should attack from 2 tiles away
 * in a straight line up/down or left/right,
 * with a 50% chance to give -2HP. No hp loss from
 * entering its cell to encounter. Adds +2 score for encountering.
 */
public class RangedMutant extends MazeItem implements java.io.Serializable{
    private static final int HP_MODIFIER_RANGED = -2;
    private static final int SCORE_MODIFIER = 2;

    public RangedMutant(){ // No-arg constructor
        this.setActive();
        this.setHpModifier(HP_MODIFIER_RANGED); // Only does damage ranged
        this.setScoreModifier(SCORE_MODIFIER);
        this.setMapSymbol("R");
    }

    @Override
    public void activate(Player p){ // Melee encounter
        if (this.checkActive()) { // The player shall not encounter twice
            p.setScore(SCORE_MODIFIER);
            System.out.println("You have slain a Ranged Mutant");
        }
        else{
            System.out.println("You see a dead Mutant.");
        }
        this.setNotActive();
        this.setMapSymbol(" ");
        p.setOverlapping(this.getMapSymbol());
    }

    public void activateRanged(Player p){
        if (this.checkActive()) {
            Random random = new Random();
            if (random.nextBoolean()) p.setHealth(HP_MODIFIER_RANGED);
        }
    }
}