package agh.ics.oop;
import static java.lang.System.out;


public class World {
    public static void main(String[] args){
       Animal elephant = new Animal();
       MoveDirection[] Directions = OptionsParser.parse(args);
       for(MoveDirection arg: Directions){
           elephant.move(arg);
       }



    }
}
