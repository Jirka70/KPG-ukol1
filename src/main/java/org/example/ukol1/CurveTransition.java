package org.example.ukol1;

import com.sun.javafx.scene.NodeHelper;
import javafx.animation.Transition;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.util.Iterator;

public class CurveTransition extends Transition {

    private final double startX;
    private final double startY;
    private final double[] curve;
    private final Shape translatingShape;

    public CurveTransition(double[] curve, Circle translatingShape) {
        super();
        this.curve = curve;
        this.translatingShape = translatingShape;
        setCycleDuration(Duration.seconds(15));
        startX = curve[0];
        startY = curve[1];
    }

    @Override
    protected void interpolate(double frac) {
        int numberOfPoints = curve.length;
        int index = (int) (numberOfPoints / frac);
        System.out.println(index);

        //System.out.println(translatingShape.getTranslateX() + " " + translatingShape.getTranslateY());
        if (pointIterator.hasNext()) {
            double x = pointIterator.next();
            double y = pointIterator.next();
            //translatingShape.getTransforms().add(new Translate(x-translatingShape.getTranslateX(),y-translatingShape.getTranslateY()));
            //translatingShape.setTranslateX(1000 * frac);
            //translatingShape.setTranslateY(1000 * frac);
            //System.out.println(1000 * frac);
            translatingShape.setTranslateX(x - startX);
            translatingShape.setTranslateY(y - startY);

            //System.out.println((x - translatingShape.getTranslateX()) + " " + (y - translatingShape.getTranslateY()));

        } else {
            System.out.println("again");
            pointIterator = curve.getPoints().iterator();
        }
    }
}
