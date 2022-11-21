package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moveDirections;
    private List<Animal> Animals = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] vector2ds) {
        for(Vector2d vector2d : vector2ds){
            if(map.canMoveTo(vector2d)){
                Animal animal = new Animal(map, vector2d);
                map.place(animal);
                this.Animals.add(animal);
            }
            else{
                if(map.objectAt(vector2d) instanceof Grass){
                    Animal animal = new Animal(map, vector2d);
                    map.place(animal);
                    this.Animals.add(animal);
                }
            }
        }
        this.moveDirections = moveDirections;
    }

    @Override
    public void run() {
        int n = this.Animals.size();
        for(int i = 0; i<this.moveDirections.length; i++){
            this.Animals.get(i%n).move(this.moveDirections[i]);
        }
    }
}
