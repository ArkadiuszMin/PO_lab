package agh.ics.oop.gui;

import agh.ics.oop.*;

import java.util.ArrayList;
import java.util.List;


    public class SimulationEngineDraw implements IEngine, Runnable{

        int moveDelay;
        private List<IRenderObserver> observers = new ArrayList<>();
        private MoveDirection[] moveDirections;
        private List<Animal> Animals = new ArrayList<>();

        public SimulationEngineDraw(IWorldMap map, Vector2d[] vector2ds, int delay) {
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
            moveDelay = delay;
        }

        public SimulationEngineDraw(MoveDirection[] directions, IWorldMap map, Vector2d[] vector2ds, int delay){
            this(map, vector2ds, delay);
            setDirections(directions);
        }

        public void setDirections(MoveDirection[] directions){
            this.moveDirections = directions;
        }

        public void addObserver(IRenderObserver observer){
            observers.add(observer);
        }

        public void removeObserver(IRenderObserver observer){
            observers.remove(observer);
        }

        public void render(){
            for (IRenderObserver observer: observers){
                observer.render();
            }
        }

        @Override
        public void run() {
            int n = this.Animals.size();
            for(int i = 0; i<this.moveDirections.length; i++){
                this.Animals.get(i%n).move(this.moveDirections[i]);
                render();
                try {
                    Thread.sleep(moveDelay);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
}
