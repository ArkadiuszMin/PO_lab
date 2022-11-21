package agh.ics.oop;

import java.util.TreeSet;

public class MapBoundary implements IPositionChangeObserver {
    private ComparatorX comperatorX = new ComparatorX();
    private ComparatorY comperatorY = new ComparatorY();
    private Vector2d upperLeft;
    private Vector2d lowerRight;

    private TreeSet<Vector2d> arrayX = new TreeSet<>(comperatorX);
    private TreeSet<Vector2d> arrayY = new TreeSet<>(comperatorY);

    public void add(Vector2d vector){
        arrayX.add(vector);
        arrayY.add(vector);
    }

    public void remove(Vector2d vector){
        arrayX.remove(vector);
        arrayY.remove(vector);
    }
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        arrayX.remove(oldPosition);
        arrayY.remove(oldPosition);
        arrayX.add(newPosition);
        arrayY.add(newPosition);
    }

    public Vector2d getUpperLeft(){
        upperLeft = new Vector2d(arrayX.first().x, arrayY.first().y);
        return upperLeft;
    }

    public Vector2d getLowerRight(){
        lowerRight = new Vector2d(arrayX.last().x, arrayY.last().y);
        return lowerRight;
    }
}
