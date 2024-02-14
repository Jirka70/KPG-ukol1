package org.example.ukol1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private static final double WIDTH = 800;
    private static final double HEIGHT = 600;
    private final Pane mainPane = new Pane();
    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
        stage.setScene(scene);
        stage.setTitle("KPG - úkol č.1 A22B0106P");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}