package org.example.ukol1.curve;

public interface Curve {

    double getX(double t);
    double getY(double t);

    default double getStartX() {
        return getX(0);
    }

    default double getStartY() {
        return getY(0);
    }
}
