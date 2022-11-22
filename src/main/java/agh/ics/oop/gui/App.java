package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Platform;

import java.util.List;

import static java.lang.System.out;

public class App extends Application implements IRenderObserver {

    private AbstractWorldMap map = new GrassField(10);

    private GridPane gridPane = new GridPane();



    private SimulationEngineDraw engine;

    private Thread threadEngine;

    private int moveDelay = 300;
    private int size = 50;


    @Override
    public void init() throws Exception {
        super.init();

        Parameters parameters = getParameters();
        String[] args = parameters.getRaw().toArray(new String[0]);
        
        try {
            Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
            engine = new SimulationEngineDraw(map, positions, moveDelay);
            engine.addObserver(this);
            System.out.println("test dla inita");
        }
        catch (IllegalArgumentException ex){
            out.println(ex.getMessage());
        }
    }

    public void render(){
        Platform.runLater(() -> {
            System.out.println("dupa");
            gridPane.getChildren().clear();
            gridPane.getRowConstraints().clear();
            gridPane.getColumnConstraints().clear();
            gridPane.setGridLinesVisible(false);
            draw();
        });

    }
    public void draw(){
        gridPane.setGridLinesVisible(true);
        gridPane.getColumnConstraints().add(new ColumnConstraints(size));
        gridPane.getRowConstraints().add(new RowConstraints(size));
        Label xylabel = new Label("y/x");
        GridPane.setHalignment(xylabel, HPos.CENTER);
        gridPane.add(xylabel, 0,0, 1, 1);
        Vector2d upperLeft = map.upperLeftCorner();
        Vector2d lowerRight = map.lowerRightCorner();
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
                    GuiElementBox image = new GuiElementBox((IMapElement) map.objectAt(new Vector2d(i, j)));
                    VBox element = image.getVbox();
                    //Label element = new Label(map.objectAt(new Vector2d(i, j)).toString());
                    gridPane.add(element, 1 + i - upperLeft.x, 1 + lowerRight.y - j, 1, 1);
                    GridPane.setHalignment(element, HPos.CENTER);
                    /*Label element = new Label(map.objectAt(new Vector2d(i, j)).toString());
                    gridPane.add(element, 1 + i - upperLeft.x, 1 + lowerRight.y - j, 1, 1);
                    GridPane.setHalignment(element, HPos.CENTER);*/
                }
            }
        }
    }



    public void start(Stage primaryStage){

        VBox controler = new VBox();
        TextField textField = new TextField();
        Button button = new Button("Move");

        button.setOnAction((event) -> {
            String[] moves = textField.getCharacters().toString().split(" ");
            MoveDirection[] directions = new OptionsParser().parse(moves);
            engine.setDirections(directions);
            threadEngine = new Thread(engine);
            threadEngine.start();
        });

        controler.getChildren().addAll(textField, button);
        controler.getChildren().add(gridPane);



        Scene scene = new Scene(controler, 700, 700);

        draw();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
