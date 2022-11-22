package agh.ics.oop.gui;

import agh.ics.oop.IMapElement;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static java.lang.System.out;

public class GuiElementBox {
    private Image image;

    private Label label;

    private IMapElement element;

    private VBox vbox = new VBox(4);

    public GuiElementBox(IMapElement mapelement){
        try{

            Image image = new Image(new FileInputStream(mapelement.toImage()));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(20);
            imageView.setFitWidth(20);
            Label label = new Label(mapelement.toLabel());
            vbox.getChildren().add(imageView);
            vbox.getChildren().add(label);
            vbox.setAlignment(Pos.CENTER);
        }
        catch(FileNotFoundException ex){
            throw new RuntimeException(ex);
        }
    }

    public VBox getVbox(){
        return vbox;
    }
}
