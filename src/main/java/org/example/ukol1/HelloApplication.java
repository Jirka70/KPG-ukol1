package org.example.ukol1;


import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    private static final double WIDTH = 1500;
    private static final double HEIGHT = 800;
    private static final double PERIOD = 2*Math.PI;
    private final Pane mainPane = new Pane();
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("KPG - úkol č.1 A22B0106P");
        stage.show();
        double[] lissajousCurve = generateLissajousCurve(3,2);
        //mainPane.getChildren().add(lissajousCurve);
        Circle animatingCircle = new Circle(lissajousCurve[0],lissajousCurve[1],5);
        mainPane.getChildren().add(animatingCircle);
        /*PathTransition pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.seconds(7));
        pathTransition.setPath(lissajousCurve);
        pathTransition.setNode(animatingCircle);
        pathTransition.setCycleCount(PathTransition.INDEFINITE);
        pathTransition.setAutoReverse(true);


        pathTransition.play();*/
        CurveTransition curveTransition = new CurveTransition(lissajousCurve,animatingCircle);
        curveTransition.setCycleCount(Animation.INDEFINITE);
        curveTransition.play();


    }

    private double[] generateLissajousCurve(double x, double y) {
        final int A = 200;
        final int B = 300;
        double step = 0.001;
        List<Double> points = new ArrayList<>();
        for (double t = 0; t < PERIOD; t+=step) {
            double curveX = A * Math.cos(x*t) + WIDTH/2;
            double curveY = B * Math.sin(y*t) + HEIGHT/2;

            points.add(curveX);
            points.add(curveY);
        }
        double[] polygonPoints = new double[points.size()];
        for (int i = 0; i < points.size(); i++) {
            polygonPoints[i] = points.get(i);
        }

        return polygonPoints;
    }


    public static void main(String[] args) {
        launch();
    }
}