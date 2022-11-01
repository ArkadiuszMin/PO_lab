package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine{
    private MoveDirection[] moveDirections;
    private List<Animal> Zwierzaczki = new ArrayList<>();

    public SimulationEngine(MoveDirection[] moveDirections, IWorldMap map, Vector2d[] vector2ds) {
        for(Vector2d vector2d : vector2ds){
            if(!map.isOccupied(vector2d)){
                Animal animal = new Animal(map, vector2d);
                map.place(animal);
                this.Zwierzaczki.add(animal);
            }
        }
        this.moveDirections = moveDirections;
    }

    @Override
    public void run() {
        int n = this.Zwierzaczki.size();
        for(int i = 0; i<this.moveDirections.length; i++){
            this.Zwierzaczki.get(i%n).move(this.moveDirections[i]);
        }
    }
}
