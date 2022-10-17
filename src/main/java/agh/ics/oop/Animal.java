package agh.ics.oop;

public class Animal {
    private MapDirection direction = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2, 2);

    public MapDirection getDirection(){
        return this.direction;
    }

    public String toString(){
        return "pozycja: (" + this.position.x + ", " + this.position.y + "). Orientacja: " + this.direction;
    }

    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }

    public void move(MoveDirection direction){
        switch(direction){
            case RIGHT:
                this.direction = this.direction.next();
                break;
            case LEFT: this.direction = this.direction.previous();
                break;
            case FORWARD:
                if(this.position.add(this.direction.toUnitVector()).follows(new Vector2d(0, 0)) && this.position.add(this.direction.toUnitVector()).precedes(new Vector2d(4, 4))){
                    this.position = this.position.add(this.direction.toUnitVector());
                }
                break;
            case BACKWARD:
                if(this.position.substract(this.direction.toUnitVector()).follows(new Vector2d(0, 0)) && this.position.substract(this.direction.toUnitVector()).precedes(new Vector2d(4, 4))){
                    this.position = this.position.substract(this.direction.toUnitVector());
                }
                break;
        }
    }
}
