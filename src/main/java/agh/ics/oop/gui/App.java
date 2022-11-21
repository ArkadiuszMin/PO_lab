package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.List;

import static java.lang.System.out;

public class App extends Application {

    private AbstractWorldMap map = new GrassField(10);

    @Override
    public void init() throws Exception {
        super.init();

        Parameters parameters = getParameters();
        String[] args = parameters.getRaw().toArray(new String[0]);
        
        try {
            MoveDirection[] directions = new OptionsParser().parse(args);
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();
            out.print(map.toString());

        }
        catch (IllegalArgumentException ex){
            out.println(ex.getMessage());
        }
    }
    Vector2d upperLeft = map.upperLeftCorner();
    Vector2d lowerRight = map.lowerRightCorner();
    GridPane gridPane = new GridPane();
    Label label = new Label("Zwierzak");
    Scene scene = new Scene(gridPane, 400, 400);
    public void start(Stage primaryStage){
        int size = 20;
        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().add(new ColumnConstraints(size));
        gridPane.getRowConstraints().add(new RowConstraints(size));
        Label xylabel = new Label("y/x");
        GridPane.setHalignment(xylabel, HPos.CENTER);
        gridPane.add(xylabel, 0,0, 1, 1);

        System.out.println(upperLeft.toString());
        System.out.println(lowerRight.toString());

        for(int i = lowerRight.y; i>= upperLeft.y; i--){
            gridPane.getRowConstraints().add(new RowConstraints(size));
            Label numberLabel = new Label(Integer.toString(i));

            gridPane.add(numberLabel, 0, lowerRight.y + 1 - i, 1, 1);
            GridPane.setHalignment(numberLabel, HPos.CENTER);
        }

        for(int i = upperLeft.x; i<=lowerRight.x; i++){
            gridPane.getColumnConstraints().add(new ColumnConstraints(size));
            Label numberLabel = new Label(Integer.toString(i));

            gridPane.add(numberLabel, i + 1 - upperLeft.x,0, 1, 1);
            GridPane.setHalignment(numberLabel, HPos.CENTER);
        }

        for(int i = upperLeft.x; i<= lowerRight.x; i++){
            for(int j= lowerRight.y; j >= upperLeft.y; j--){
                if(map.isOccupied(new Vector2d(i, j))){
                    Label element = new Label(map.objectAt(new Vector2d(i, j)).toString());
                    gridPane.add(element, 1 + i - upperLeft.x, 1 + lowerRight.y - j, 1, 1);
                    GridPane.setHalignment(element, HPos.CENTER);
                }
            }
        }


        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
