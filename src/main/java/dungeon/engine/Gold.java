package dungeon.engine;

public class Gold extends MazeItem{
    private static final int GOLD_MODIFIER = 5;

    public Gold(){
        this.setActive();
        this.setHpModifier(0);
        this.setScoreModifier(GOLD_MODIFIER);
    };
}
