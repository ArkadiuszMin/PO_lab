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
        spawnerTrawki(this.number);
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        if(Zwierzaczki.containsKey(position)){
            return false;
        }
        if(position.follows(new Vector2d(0, 0))){
            for(Grass trawka: Trawka){
                if(trawka.isAt(position)){
                    Trawka.remove(trawka);
                    spawnerTrawki(1);
                    break;
                }
            }
            return true;
        }
        return false;
    }
    public Vector2d upperLeftCorner(){
        int x1 = Integer.MAX_VALUE;
        int y1 = Integer.MAX_VALUE;
        for(Vector2d key : Zwierzaczki.keySet()){
            if(key.x < x1){
                x1=key.x;
            }
            if(key.y < y1){
                y1=key.y;
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
        for(Vector2d key : Zwierzaczki.keySet()){
            if(key.x > x2){
                x2=key.x;
            }
            if(key.y > y2) {
                y2 = key.y;
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
                return (Grass)trawka;
            }
        }
        return null;
    }

    public void spawnerTrawki(int ilosc){
        int rozmiar = (int)(sqrt(this.number*10));
        for(int i=0; i<ilosc; i++){
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
