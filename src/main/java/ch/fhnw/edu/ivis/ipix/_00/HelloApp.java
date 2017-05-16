package ch.fhnw.edu.ivis.ipix._00;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public final class HelloApp extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 800;
    private static final String TITLE = "JavaFX Hello World";

    public void start(Stage stage) {
        Circle circle = new Circle(100, Color.ORANGE);
        Button button = new Button("Click Me");

        button.setOnAction(e -> System.out.println("Clicked"));

        Pane container = new StackPane(circle, button);

        Scene scene = new Scene(container);
        stage.setScene(scene);

        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.setTitle(TITLE);
        stage.show();
    }

    public static void main(String... args) {
        launch(args);
    }

}
