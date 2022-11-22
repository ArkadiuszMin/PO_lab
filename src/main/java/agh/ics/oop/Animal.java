package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Animal implements IMapElement{
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    private List<IPositionChangeObserver> Observers = new ArrayList<>();

    public void addObserver(IPositionChangeObserver observer){
        Observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        Observers.remove(observer);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for(IPositionChangeObserver observer : Observers){
            observer.positionChanged(oldPosition, newPosition);
        }
    }
    private IWorldMap map;
    public Animal(){}
    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
        addObserver((IPositionChangeObserver) map);
        this.position = initialPosition;
    }
    public MapDirection getDirection(){
        return this.direction;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    public String toString(){
        return switch(direction){
            case NORTH -> "^";
            case SOUTH -> "v";
            case WEST -> "<";
            case EAST -> ">";
        };
    }

    public String toImage(){
        return switch(direction){
            case NORTH -> "src/main/resources/up.png";
            case SOUTH -> "src/main/resources/down.png";
            case WEST -> "src/main/resources/left.png";
            case EAST -> "src/main/resources/right.png";
        };
    }

    public String toLabel(){
        return "Z " + this.getPosition().toString();
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        Vector2d moveTo = new Vector2d(-1, -1);
        switch(direction){
            case RIGHT:
                this.direction = this.direction.next();
                return;
            case LEFT: this.direction = this.direction.previous();
                return;
            case FORWARD:
                moveTo = this.position.add(this.direction.toUnitVector());
                break;
            case BACKWARD:
                moveTo = this.position.substract(this.direction.toUnitVector());
                break;
        }
        if(map.canMoveTo(moveTo)){
            positionChanged(this.position, moveTo);
            this.position = moveTo;
        }
    }
}
