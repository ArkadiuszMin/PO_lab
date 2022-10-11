package agh.ics.oop;
import static java.lang.System.out;


public class World {

    public static Direction[] change(String[] args){
        Direction[] changed = new Direction[args.length];
        for(int i = 0; i<args.length; i++){
            switch(args[i]){
                case "f":
                    changed[i]=Direction.FORWARD;
                    break;
                case "b":
                    changed[i]=Direction.BACKWARD;
                    break;
                case "r":
                    changed[i] = Direction.RIGHT;
                    break;
                case "l":
                    changed[i]=Direction.LEFT;
                    break;
                default:
                    changed[i] = Direction.OTHER;
            }
        }
        return changed;
    }
    public static void run(Direction[] pets){
        for(int i=0; i<pets.length; i++){
            switch (pets[i]){
                case FORWARD:
                    out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    out.println("Zwierzak idzie do tyłu");
                    break;
                case RIGHT:
                    out.println("Zwierzak skręca w prawo");
                    break;
                case LEFT:
                    out.println("Zwierzak skręca w lewo");
                    break;
            }
        }
    }
    public static void main(String[] args){
        out.println("Start");
        Direction[] kierunki = change(args);
        run(kierunki);
        out.println("Stop");
        Vector2d position1 = new Vector2d(1,2);
        System.out.println(position1);
        Vector2d position2 = new Vector2d(-2,1);
        System.out.println(position2);
        System.out.println(position1.add(position2));
        MapDirection test = MapDirection.EAST;
        out.println(test.toString());
        out.println(test.next());
        out.println(test.previous());
        out.println(test.toUnitVector());
    }
}
