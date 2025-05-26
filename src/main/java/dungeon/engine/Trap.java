package dungeon.engine;

/** A Trap should add -2 HP on activation,
 * and should remain active
 */
public class Trap extends MazeItem implements java.io.Serializable{
    private static final int HP_MODIFIER = -2;

    public Trap(){ // No-arg constructor
        this.setActive();
        this.setHpModifier(HP_MODIFIER);
        this.setScoreModifier(0);
        this.setMapSymbol("T");
    }

    @Override
    public void activate(Player p){
        System.out.println("You stood on a trap. OUCH!");
        p.setHealth(HP_MODIFIER);
        p.setOverlapping(this.getMapSymbol());
    }
}