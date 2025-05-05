package dungeon.engine;

public abstract class MazeItem {
    private boolean active;
    private String  mapSymbol;
    private int hpModifier;
    private int scoreModifier;

    public void setActive(){this.active = true;}
    public void setNotActive(){this.active = false;}
    public boolean checkActive(){return this.active;}
    public void setHpModifier(int m){this.hpModifier = m;}
    public void setScoreModifier(int s){this.scoreModifier = s;}
}
