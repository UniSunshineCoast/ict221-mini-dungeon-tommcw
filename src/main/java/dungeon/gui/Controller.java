package dungeon.gui;

import dungeon.engine.Cell;
import dungeon.engine.GameEngine;
import dungeon.engine.MazeItem;
import dungeon.engine.Player;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class Controller {
    @FXML
    private GridPane gridPane;

    GameEngine engine;

    @FXML
    public void initialize() {
        engine = new GameEngine(10);
        Player thePlayer = new Player();
        engine.populateMap(0, engine.getSize() - 1, thePlayer);

        gridPane.setStyle("-fx-background-color: #FFF8DC"); // Colour Cornsilk
        updateGui();
    }

    private void updateGui() {
        //Clear old GUI grid pane
        gridPane.getChildren().clear();

        //Loop through map board and add each cell into grid pane
        for(int i = 0; i < engine.getSize(); i++) {
            for (int j = 0; j < engine.getSize(); j++) {
                Cell cell = engine.getMap()[i][j];
                MazeItem myItem = cell.getMazeObject();
                Node node = selectAndCreateNode(myItem);
                gridPane.add(node, j, i);
            }
        }
        gridPane.setGridLinesVisible(true);
    }

    public Node selectAndCreateNode(MazeItem item) {
        switch (item.getMapSymbol()) {
            case "G":
                Circle gold = new Circle(10);
                gold.setFill(Color.GREEN);
                return gold;
            case "L":
                Circle ladder = new Circle(10);
                ladder.setFill(Color.GREEN);
                return ladder;
            case "M":
                Rectangle melee = new Rectangle(15,15);
                melee.setFill(Color.BLUE);
                return melee;
            case "R":
                Rectangle empty = new Rectangle(15,4);
                empty.setFill(Color.BLUE);
                return empty;
            default:
                return new Circle(20);
        }
    }

}
