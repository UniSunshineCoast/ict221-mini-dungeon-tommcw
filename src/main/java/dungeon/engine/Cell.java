package dungeon.engine;

import javafx.scene.layout.StackPane;

public class Cell extends StackPane {
    public String contents = " ";
    public MazeItem mazeObject = null;

    public String getContents() {
        return this.contents;
    }

    public void setContents(String s) {
        this.contents = s;
    }

    public MazeItem getMazeObject(){
        return this.mazeObject;
    }

    public void setMazeObject(MazeItem m){
        this.mazeObject = m;
    }
}
