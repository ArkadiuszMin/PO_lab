package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class RectangularMap implements IWorldMap{
    private final int width;
    private final int height;

    private List<Animal> Zwierzaczki = new ArrayList<Animal>();

    public List<Animal> getZwierzaczki(){
        return this.Zwierzaczki;
    }

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    public String toString(){
        Vector2d koniec = new Vector2d(width, height);
        Vector2d poczatek = new Vector2d(0, 0);
        MapVisualizer mapVisualizer = new MapVisualizer(this);
        return mapVisualizer.draw(poczatek, koniec);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        Vector2d koniec = new Vector2d(width, height);
        Vector2d poczatek = new Vector2d(0, 0);
        if(!this.isOccupied(position) && position.follows(poczatek) && position.precedes(koniec)){
            return true;
        }
        return false;
    }

    @Override
    public boolean place(Animal animal) {
        if(!this.isOccupied(animal.getPosition())){
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
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : this.Zwierzaczki) {
            if(animal.isAt(position)){
                return animal;
            }
        }
        return null;
    }
}
