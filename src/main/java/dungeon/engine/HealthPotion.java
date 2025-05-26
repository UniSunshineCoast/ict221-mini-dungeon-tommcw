package dungeon.engine;

/**
 * Activating this object should
 * Restore 4 HP (max HP = 10) on the player
 */
public class HealthPotion extends MazeItem implements java.io.Serializable{
    private static final int HP_MODIFIER = 4;

    public HealthPotion(){ // No-arg constructor
        this.setActive();
        this.setHpModifier(HP_MODIFIER);
        this.setScoreModifier(0);
        this.setMapSymbol("H");
    }

    @Override
    public void activate(Player p){
        if (this.checkActive()){ // The player shall not get the health twice
            p.setHealth(HP_MODIFIER);
            System.out.println("You have found a potion. You use it immediately");
        }
        else
            System.out.println("You hear the sound of scratching in the distance.");
        this.setNotActive();
        this.setMapSymbol(" ");
        p.setOverlapping(this.getMapSymbol());
        }
}