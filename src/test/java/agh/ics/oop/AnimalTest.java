package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AnimalTest {
    @Test
    void tests(){
        Animal elephant = new Animal();
        assertEquals(MapDirection.NORTH, elephant.getDirection());
        assertTrue(elephant.isAt(new Vector2d(2, 2)));
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        assertTrue(elephant.isAt(new Vector2d(2, 4)));
        elephant.move(MoveDirection.FORWARD);
        assertTrue(elephant.isAt(new Vector2d(2, 4)));
        elephant.move(MoveDirection.LEFT);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        assertTrue(elephant.isAt(new Vector2d(0, 4)));
        assertEquals(MapDirection.WEST, elephant.getDirection());
        elephant.move(MoveDirection.BACKWARD);
        elephant.move(MoveDirection.BACKWARD);
        elephant.move(MoveDirection.RIGHT);
        assertTrue(elephant.isAt(new Vector2d(2, 4)));
        assertEquals(MapDirection.NORTH, elephant.getDirection());
        elephant.move(MoveDirection.RIGHT);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        assertTrue(elephant.isAt(new Vector2d(4, 4)));
        assertEquals(MapDirection.EAST, elephant.getDirection());
        elephant.move(MoveDirection.LEFT);
        elephant.move(MoveDirection.LEFT);
        elephant.move(MoveDirection.LEFT);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        assertTrue(elephant.isAt(new Vector2d(4, 2)));
        assertEquals(MapDirection.SOUTH, elephant.getDirection());
        elephant.move(MoveDirection.RIGHT);
        elephant.move(MoveDirection.RIGHT);
        elephant.move(MoveDirection.BACKWARD);
        elephant.move(MoveDirection.BACKWARD);
        elephant.move(MoveDirection.BACKWARD);
        elephant.move(MoveDirection.BACKWARD);
        assertTrue(elephant.isAt(new Vector2d(4, 0)));
        assertEquals(MapDirection.NORTH, elephant.getDirection());
        elephant.move(MoveDirection.LEFT);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.FORWARD);
        elephant.move(MoveDirection.RIGHT);
        elephant.move(MoveDirection.RIGHT);
        assertTrue(elephant.isAt(new Vector2d(0, 0)));
        assertEquals(MapDirection.EAST, elephant.getDirection());

        String[] directionsString = new String[] {"f", "b", "wow", "yooo", "left", "l", "sup_bro", "r", "t", "f", "backward", "right"};
        MoveDirection[] directionsGood = OptionsParser.parse(directionsString);
        assertEquals(MoveDirection.FORWARD, directionsGood[0]);
        assertEquals(MoveDirection.BACKWARD, directionsGood[1]);
        assertEquals(MoveDirection.LEFT, directionsGood[2]);
        assertEquals(MoveDirection.LEFT, directionsGood[3]);
        assertEquals(MoveDirection.RIGHT, directionsGood[4]);
        assertEquals(MoveDirection.FORWARD, directionsGood[5]);
        assertEquals(MoveDirection.BACKWARD, directionsGood[6]);
        assertEquals(MoveDirection.RIGHT, directionsGood[7]);

        elephant.move(directionsGood[0]);
        assertTrue(elephant.isAt(new Vector2d(1, 0)));
        elephant.move(directionsGood[1]);
        assertTrue(elephant.isAt(new Vector2d(0, 0)));
        elephant.move(directionsGood[2]);
        assertEquals(MapDirection.NORTH, elephant.getDirection());
        elephant.move(directionsGood[3]);
        assertEquals(MapDirection.WEST, elephant.getDirection());
        elephant.move(directionsGood[4]);
        assertEquals(MapDirection.NORTH, elephant.getDirection());
        elephant.move(directionsGood[5]);
        assertTrue(elephant.isAt(new Vector2d(0, 1)));
        elephant.move(directionsGood[6]);
        assertTrue(elephant.isAt(new Vector2d(0, 0)));
        elephant.move(directionsGood[7]);
        assertEquals(MapDirection.EAST, elephant.getDirection());











    }


}