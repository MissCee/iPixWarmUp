package ch.fhnw.edu.ivis.ipix.step_1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelReader;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Demonstrates how to use an {@link ImageView} and access
 * pixel information through a {@link PixelReader}.
 * Logs x, y, and brightness of hovered pixels to the console.
 *
 * @author Rahel Lüthy
 */
public final class App1 extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 800;
    private static final String TITLE = App1.class.getSimpleName();

    private static final String IMG_URL = "brain.png";

    @Override
    public void start(Stage stage) {
        Image image = new Image(IMG_URL);
        ImageView imageView = new ImageView(image);

        // TODO: Log x, y, brightness to console whenever a pixel is hovered

        Pane container = new StackPane(imageView);
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
