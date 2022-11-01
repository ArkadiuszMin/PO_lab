package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    private IWorldMap map;
    public Animal(){}
    public Animal(IWorldMap map){
        this.map = map;
    }

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map = map;
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
            this.position = moveTo;
        }
    }
}
