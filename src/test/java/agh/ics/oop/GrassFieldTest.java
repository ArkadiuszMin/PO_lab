package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrassFieldTest {

    @Test
    void tests(){
        IWorldMap map = new GrassField(10);
        Animal owca = new Animal(map, new Vector2d(2, 3));
        Animal krowa = new Animal(map, new Vector2d(3, 4));
        Animal krab = new Animal(map, new Vector2d(6, 1));
        Vector2d owcavec = new Vector2d(2, 3);
        Vector2d krowavec = new Vector2d(3, 4);
        Vector2d krabvec = new Vector2d(6, 1);


        map.place(owca);
        map.place(krowa);
        map.place(krab);
        assertTrue(map.isOccupied(owcavec));
        assertTrue(map.isOccupied(krowavec));
        assertTrue(map.isOccupied(krabvec));
        assertEquals(map.objectAt(owcavec), owca);
        assertEquals(map.objectAt(krowavec), krowa);
        assertEquals(map.objectAt(krabvec), krab);
        assertTrue(map.place(new Animal(map, new Vector2d(7, 2))));
        assertTrue(map.isOccupied(new Vector2d(7, 2)));
        assertTrue(map.place(new Animal(map, new Vector2d(5, 1))));
        assertTrue(map.isOccupied(new Vector2d(5, 1)));
        assertFalse(map.place(new Animal(map, owcavec)));
        assertFalse(map.place(new Animal(map, krabvec)));
        assertTrue(map.canMoveTo(new Vector2d(2, 2)));
        assertTrue(map.canMoveTo(new Vector2d(3, 3)));
        assertFalse(map.canMoveTo(krabvec));
        assertFalse(map.canMoveTo(new Vector2d(5, -294)));

    }
}