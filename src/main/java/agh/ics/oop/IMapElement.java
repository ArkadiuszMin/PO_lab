package agh.ics.oop;

import java.io.FileInputStream;

public interface IMapElement {
    boolean isAt(Vector2d position);

    String toString();

    String toImage();

    String toLabel();


}
