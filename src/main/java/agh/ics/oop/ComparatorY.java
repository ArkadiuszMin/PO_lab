package agh.ics.oop;

import java.util.Comparator;

public class ComparatorY implements Comparator<Vector2d> {

    public int compare(Vector2d vec1, Vector2d vec2){
        if(vec1.y == vec2.y){
            if(vec1.x > vec2.x){
                return 1;
            }
            else{
                return -1;
            }
        }
        else if(vec1.y > vec2.y){
            return 1;
        }
        else{
            return -1;
        }
    }
}
