package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void tests(){
        AbstractWorldMap map = new GrassField(10);
        Animal ship = new Animal(map, new Vector2d(2, 3));
        Animal cow = new Animal(map, new Vector2d(3, 4));
        Animal crab = new Animal(map, new Vector2d(6, 1));
        crab.addObserver(map);
        cow.addObserver(map);
        ship.addObserver(map);
        Vector2d shipvec = new Vector2d(2, 3);
        Vector2d cowvec = new Vector2d(3, 4);
        Vector2d crabvec = new Vector2d(6, 1);


        map.place(ship);
        map.place(cow);
        map.place(crab);
        assertTrue(map.isOccupied(shipvec));
        assertTrue(map.isOccupied(cowvec));
        assertTrue(map.isOccupied(crabvec));
        assertEquals(map.objectAt(shipvec), ship);
        assertEquals(map.objectAt(cowvec), cow);
        assertEquals(map.objectAt(crabvec), crab);
        assertTrue(map.place(new Animal(map, new Vector2d(7, 2))));
        assertTrue(map.isOccupied(new Vector2d(7, 2)));
        assertTrue(map.place(new Animal(map, new Vector2d(5, 1))));
        assertTrue(map.isOccupied(new Vector2d(5, 1)));
        assertThrows(IllegalArgumentException.class, () -> map.place(new Animal(map, shipvec)));
        assertThrows(IllegalArgumentException.class, () -> map.place(new Animal(map, crabvec)));
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(3, 3)));
        assertThrows(IllegalArgumentException.class, () -> map.canMoveTo(crabvec));
        assertTrue(map.canMoveTo(new Vector2d(5, -294)));

    }
}