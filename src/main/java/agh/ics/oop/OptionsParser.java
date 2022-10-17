package agh.ics.oop;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        int counter = 0;
        for (String i: args){
            if(i.equals("f") || i.equals("forward") || i.equals("b") || i.equals("backward") || i.equals("l") || i.equals("left") || i.equals("r") || i.equals("right")){
                counter+=1;
            }
        }
        MoveDirection[] Directions = new MoveDirection[counter];
        counter = 0;
        for(String i: args){
            switch(i){
                case "f", "forward":
                    Directions[counter] = MoveDirection.FORWARD;
                    counter+=1;
                    break;
                case "b", "backward":
                    Directions[counter] = MoveDirection.BACKWARD;
                    counter+=1;
                    break;
                case "l", "left":
                    Directions[counter] = MoveDirection.LEFT;
                    counter+=1;
                    break;
                case "r", "right":
                    Directions[counter] = MoveDirection.RIGHT;
                    counter+=1;
                    break;
                default: break;
            }
        }
        return Directions;
    }
}
