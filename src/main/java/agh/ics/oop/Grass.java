package agh.ics.oop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Grass implements IMapElement{

    private Vector2d position;

    public Grass(Vector2d vector2d){
        this.position = vector2d;
    }

    public Vector2d getPosition() {
        return this.position;
    }

    public boolean isAt(Vector2d  vector2d){
        return vector2d.equals(this.position);
    }
    @Override
    public String toImage(){
        return "src/main/resources/grass.png";
    }

    public String toLabel(){
        return "Trawka";
    }

    public String toString(){
        return "*";
    }
}
