package org.example.ukol1;

import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;
import javafx.util.Duration;

public class CurveTransition extends Transition {
    private final double startX;
    private final double startY;
    private final double[] curve;
    private final Shape translatingShape;

    public CurveTransition(double[] curve, Circle translatingShape) {
        super();
        this.curve = curve;
        this.translatingShape = translatingShape;
        setCycleDuration(Duration.seconds(10));
        setInterpolator(Interpolator.LINEAR);
        startX = curve[0];
        startY = curve[1];
    }

    @Override
    protected void interpolate(double frac) {
        int numberOfPoints = curve.length;
        int index = (int) (numberOfPoints * frac);
        double x, y;
        if (frac == 1) {
            x = numberOfPoints - 2;
            y = numberOfPoints - 1;
        } else {
            x = index % 2 == 0 ? curve[index] : curve[index - 1];
            y = index % 2 == 0 ? curve[index + 1] : curve[index];
        }

        translatingShape.setTranslateX(x - startX);
        translatingShape.setTranslateY(y - startY);
    }
}
