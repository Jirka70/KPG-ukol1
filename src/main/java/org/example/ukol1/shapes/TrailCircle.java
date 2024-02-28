package org.example.ukol1.shapes;

import javafx.scene.paint.Color;
import javafx.scene.shape.*;

public class TrailCircle implements TrailShape {
    private static final int MAX_PATH_LENGTH = 255;
    private final Circle circle;
    private final Path trail = new Path();

    public TrailCircle(double x, double y, double radius) {
        circle = new Circle(x,y,radius);
        trail.setFill(Color.BLUE);
        trail.getElements().add(new MoveTo(x,y));
        trail.setStrokeWidth(5);
    }
    @Override
    public Shape getShape() {
        return circle;
    }

    @Override
    public Path getTrail() {
        return trail;
    }

    private int getTrailLength() {
        return trail.getElements().size();
    }
}
