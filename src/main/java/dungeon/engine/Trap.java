package dungeon.engine;

/** A Trap should add -2 HP on activation,
 * and should remain active
 */
public class Trap extends MazeItem{
    private static final int HP_MODIFIER = -2;

    public Trap(){ // No-arg constructor
        this.setActive();
        this.setHpModifier(HP_MODIFIER);
        this.setScoreModifier(0);
    }

    public void activate(Player p){
        p.setHealth(HP_MODIFIER);
    }
}