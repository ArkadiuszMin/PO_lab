package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.Vector;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

class SimulationEngineTest {

    @Test
    void testSimulation() {
        String[] args = {"f","b","r","l","f","f","r","r","f","f","f","f","f","f","f","f"};
        MoveDirection[] directions = new OptionsParser().parse(args);
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
        assertEquals(map.getZwierzaczki().get(1).getPosition(), new Vector2d(3,5));
        assertEquals(map.getZwierzaczki().get(0).getPosition(), new Vector2d(2,0));
    }
}