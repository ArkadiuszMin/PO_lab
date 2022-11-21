package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public Map getAnimals(){
        return this.Animals;
    }

    public Vector2d upperLeftCorner(){
        return new Vector2d(0, 0);
    }

    public Vector2d lowerRightCorner(){
        return new Vector2d(width-1, height-1);
    }



    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d koniec = new Vector2d(width, height);
        Vector2d poczatek = new Vector2d(0, 0);
        if(!this.isOccupied(position) && position.follows(poczatek) && position.precedes(koniec)){
            return true;
        }
        throw new IllegalArgumentException("you can't move to " + position.toString());
    }

    @Override
    boolean checkIfIsOccupied(Vector2d position) {
        return false;
    }

    @Override
    Object checkIfObjectAt(Vector2d position) {
        return null;
    }
}
