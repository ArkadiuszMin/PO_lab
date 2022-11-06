package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{

    private int number;

    private List<Grass> Trawka = new ArrayList<>();

    public GrassField(int number){
        this.number = number;
        spawnerTrawki();
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        for(Animal zwierzak: Zwierzaczki){
            if(zwierzak.isAt(position)){
                return false;
            }
        }
        if(position.follows(new Vector2d(0, 0))){
            return true;
        }
        return false;
    }
    public Vector2d upperLeftCorner(){
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        for(Animal zwierzak: Zwierzaczki){
            if(zwierzak.getPosition().x < x1){
                x1=zwierzak.getPosition().x;
            }
            if(zwierzak.getPosition().y < y1){
                y1=zwierzak.getPosition().y;
            }
        }
        for(Grass trawka: Trawka){
            if(trawka.getPosition().x < x1){
                x1=trawka.getPosition().x;
            }
            if(trawka.getPosition().y < y1){
                y1=trawka.getPosition().y;
            }
        }
        return new Vector2d(x1, y1);
    }

    public Vector2d lowerRightCorner(){
        int x2 = Integer.MIN_VALUE;
        int y2 = Integer.MIN_VALUE;
        for(Animal zwierzak: Zwierzaczki){
            if(zwierzak.getPosition().x > x2){
                x2=zwierzak.getPosition().x;
            }
            if(zwierzak.getPosition().y > y2) {
                y2 = zwierzak.getPosition().y;
            }
        }
        for(Grass trawka: Trawka){
            if(trawka.getPosition().x > x2){
                x2=trawka.getPosition().x;
            }
            if(trawka.getPosition().y > y2) {
                y2 = trawka.getPosition().y;
            }
        }
        return new Vector2d(x2, y2);
    }

    @Override
    boolean checkIfIsOccupied(Vector2d position) {
        for(Grass trawka: Trawka){
            if(trawka.isAt(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    Object checkIfObjectAt(Vector2d position) {
        for(Grass trawka: Trawka){
            if(trawka.isAt(position)){
                return trawka;
            }
        }
        return null;
    }

    public void spawnerTrawki(){
        int rozmiar = (int)(sqrt(this.number*10));
        for(int i=0; i<this.number; i++){
            int x = (int)(Math.random()*rozmiar);
            int y = (int)(Math.random()*rozmiar);
            while(isOccupied(new Vector2d(x, y))){
                x = (int)(Math.random()*rozmiar);
                y = (int)(Math.random()*rozmiar);
            }
            Trawka.add(new Grass(new Vector2d(x,y)));
        }
    }


}
