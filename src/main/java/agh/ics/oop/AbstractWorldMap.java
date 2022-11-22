package agh.ics.oop;

import java.util.*;

abstract public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {

    protected Map<Vector2d, Animal> Animals = new HashMap<>();

    protected MapBoundary mapBoundary = new MapBoundary();

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d NewPosition){
        Animal temp = Animals.get(oldPosition);
        Animals.remove(oldPosition);
        Animals.put(NewPosition, temp);
        mapBoundary.positionChanged(oldPosition, NewPosition);
    }

    @Override
    public String toString(){
        Vector2d begin = upperLeftCorner();
        Vector2d end = lowerRightCorner();
        System.out.println(begin.toString());
        System.out.println(end.toString());
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(begin, end);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        return false;
    }

    public abstract Vector2d upperLeftCorner();
    public abstract Vector2d lowerRightCorner();

    abstract boolean checkIfIsOccupied(Vector2d position);

    abstract Object checkIfObjectAt(Vector2d position);

    @Override
    public boolean place(Animal animal) {
        if(this.canMoveTo(animal.getPosition())){
            System.out.println("test dla place worldmap");
            this.Animals.put(animal.getPosition(), animal);
            mapBoundary.add(animal.getPosition());
            return true;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        if(Animals.containsKey(position)){
            return true;
        }
        return checkIfIsOccupied(position);
    }
    @Override
    public Object objectAt(Vector2d position) {
        if(Animals.containsKey(position)){
            return Animals.get(position);
        }
        return checkIfObjectAt(position);
    }
}
