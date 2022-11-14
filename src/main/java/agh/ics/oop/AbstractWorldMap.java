package agh.ics.oop;

import java.util.*;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Vector2d, Animal> Zwierzaczki = new HashMap<>();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d NewPosition){
        Animal temp = Zwierzaczki.get(oldPosition);
        Zwierzaczki.remove(oldPosition);
        Zwierzaczki.put(NewPosition, temp);
    }

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
            this.Zwierzaczki.put(animal.getPosition(), animal);
            return true;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        if(Zwierzaczki.containsKey(position)){
            return true;
        }
        return checkIfIsOccupied(position);
    }
    @Override
    public Object objectAt(Vector2d position) {
        if(Zwierzaczki.containsKey(position)){
            return Zwierzaczki.get(position);
        }
        return checkIfObjectAt(position);
    }
}
