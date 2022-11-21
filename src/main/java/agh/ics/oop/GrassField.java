package agh.ics.oop;

import java.util.*;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{

    private int number;

    private Map<Vector2d, Grass> Grasses = new HashMap<>();

    public GrassField(int number){
        this.number = number;
        grassSpawner(this.number);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(Animals.containsKey(position)){
            throw new IllegalArgumentException("you can't move to " + position.toString());
        }
        if(Grasses.containsKey(position)){
            Grasses.remove(position);
            mapBoundary.remove(position);
            grassSpawner(1);
        }
        return true;
    }
    public Vector2d upperLeftCorner(){
        return mapBoundary.getUpperLeft();
    }

    public Vector2d lowerRightCorner(){
        return mapBoundary.getLowerRight();
    }

    @Override
    boolean checkIfIsOccupied(Vector2d position) {
        if(Grasses.containsKey(position)){
            return true;
        }
        return false;
    }

    @Override
    Object checkIfObjectAt(Vector2d position) {
        if(Grasses.containsKey(position)){
            return Grasses.get(position);
        }
        return null;
    }

    public void grassSpawner(int quantity){
        int rozmiar = (int)(sqrt(this.number*10));
        for(int i=0; i<quantity; i++){
            int x = (int)(Math.random()*rozmiar);
            int y = (int)(Math.random()*rozmiar);
            while(isOccupied(new Vector2d(x, y))){
                x = (int)(Math.random()*rozmiar);
                y = (int)(Math.random()*rozmiar);
            }
            Grasses.put(new Vector2d(x,y), new Grass(new Vector2d(x,y)));
            mapBoundary.add(new Vector2d(x, y));
        }
    }


}
