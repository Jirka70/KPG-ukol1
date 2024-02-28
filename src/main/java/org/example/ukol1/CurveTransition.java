package org.example.ukol1;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Shape;
import javafx.util.Duration;
import org.example.ukol1.curve.Curve;
import org.example.ukol1.shapes.TrailShape;

import java.util.ArrayList;
import java.util.List;

public class CurveTransition extends Transition {
    private final double startX;
    private final double startY;
    private final Curve curve;
    private final TrailShape trailShape;
    private final Shape translatingShape;
    private final List<Line> trail = new ArrayList<>();
    private final Pane pane;

    public CurveTransition(Curve curve, TrailShape trailShape, Pane pane) {
        super();
        this.curve = curve;
        this.trailShape = trailShape;
        this.pane = pane;

        translatingShape = trailShape.getShape();

        startX = curve.getStartX();
        startY = curve.getStartY();

        setCycleDuration(Duration.seconds(10));
        setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double frac) {
        double x = curve.getX(frac);
        double y = curve.getY(frac);
        translatingShape.setTranslateX(x - startX);
        translatingShape.setTranslateY(y - startY);
        Line newLine;
        if (trail.isEmpty()) {
            newLine = new Line(x,y,x,y);
        } else {
            Line lastLine = trail.get(trail.size()-1);
            newLine = new Line(x,y,lastLine.getStartX(),lastLine.getStartY());
        }
        trail.add(newLine);
        pane.getChildren().add(newLine);
        if (trail.size() > 255) {
            pane.getChildren().remove(trail.remove(0));
        }
    }
}
