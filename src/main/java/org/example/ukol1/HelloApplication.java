package org.example.ukol1;


import javafx.animation.Animation;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.example.ukol1.curve.Curve;
import org.example.ukol1.curve.LissajousCurve;
import org.example.ukol1.shapes.TrailCircle;
import org.example.ukol1.shapes.TrailShape;

public class HelloApplication extends Application {
    private static final double WIDTH = 800;
    private static final double HEIGHT = 800;
    private final Pane mainPane = new Pane();
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("KPG - úkol č.1 A22B0106P");
        stage.show();

        Curve lissajous = new LissajousCurve(3,2,200,300,WIDTH/2,HEIGHT/2);
        TrailShape translatingShape = new TrailCircle(lissajous.getStartX(), lissajous.getStartY(),5);

        CurveTransition curveTransition = new CurveTransition(lissajous,translatingShape,mainPane);
        curveTransition.setCycleCount(Animation.INDEFINITE);
        curveTransition.play();

        mainPane.getChildren().addAll(translatingShape.getShape(), translatingShape.getTrail());
    }

    public static void main(String[] args) {
        launch();
    }
}