package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

abstract public class AbstractWorldMap implements IWorldMap {

    protected List<Animal> Zwierzaczki = new ArrayList<Animal>();

    @Override
    public String toString(){
        Vector2d poczatek = upperLeftCorner();
        Vector2d koniec = lowerRightCorner();
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(poczatek, koniec);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return false;
    }

    abstract Vector2d upperLeftCorner();
    abstract Vector2d lowerRightCorner();

    abstract boolean checkIfIsOccupied(Vector2d position);

    abstract Object checkIfObjectAt(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            this.Zwierzaczki.add(animal);
            return true;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : this.Zwierzaczki){
            if(animal.isAt(position)){
                return true;
            }
        }
        return checkIfIsOccupied(position);
    }
    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : this.Zwierzaczki) {
            if(animal.isAt(position)){
                return animal;
            }
        }
        return checkIfObjectAt(position);
    }
}
