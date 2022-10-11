package agh.ics.oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Vector2dTest {

    @Test
    void testToString() {
        Vector2d test = new Vector2d(2, 1);
        assertEquals("(2,1)", test.toString());
    }

    @Test
    void precedes() {
        Vector2d ten = new Vector2d(4, 2);
        Vector2d tamten = new Vector2d(6, 9);
        assertTrue(ten.precedes(tamten));
    }

    @Test
    void follows() {
        Vector2d ten = new Vector2d(6, 9);
        Vector2d tamten = new Vector2d(4, 2);
        assertTrue(ten.follows(tamten));
    }

    @Test
    void upperRight() {
        Vector2d ten = new Vector2d(6, 2); //NIE DZiALA
        Vector2d tamten = new Vector2d(4, 9);
        Vector2d wynik = new Vector2d(6, 9);
        assertEquals(wynik, ten.upperRight(tamten));
    }

    @Test
    void lowerLeft() {
        Vector2d ten = new Vector2d(6, 2);     //NIE DZIALA
        Vector2d tamten = new Vector2d(4, 9);
        Vector2d wynik = new Vector2d(4, 2);
        assertEquals(wynik, ten.lowerLeft(tamten));
    }

    @Test
    void add() {
        Vector2d ten = new Vector2d(6, 9);
        Vector2d tamten = new Vector2d(4, 2);
        Vector2d wynik = new Vector2d(10, 11);
        assertEquals(wynik, ten.add(tamten));

    }

    @Test
    void substract() {
        Vector2d ten = new Vector2d(6, 9);
        Vector2d tamten = new Vector2d(4, 2);
        Vector2d wynik = new Vector2d(2, 7);
        assertEquals(wynik, ten.substract(tamten));
    }

    @Test
    void testEquals() {
        Vector2d ten = new Vector2d(6, 9);
        Vector2d tamten = new Vector2d(6, 9);
        assertTrue(ten.equals(tamten));
    }

    @Test
    void opposite() {
        Vector2d ten = new Vector2d(6, 9);
        Vector2d tamten = new Vector2d(-6, -9);
        assertEquals(ten, tamten.opposite());
    }
}