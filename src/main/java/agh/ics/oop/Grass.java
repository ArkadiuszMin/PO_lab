package agh.ics.oop;

public class Grass {

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

    public String toString(){
        return "*";
    }
}
