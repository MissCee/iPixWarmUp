package ch.fhnw.edu.ivis.ipix.step_2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Demonstrates how two views can access a shared {@link PresentationModel}.
 * Uses a custom {@link Pixel} class to encapsulate each (x, y, brightness) triplet.
 * Stores the currently hovered pixel in a {@link javafx.beans.value.ObservableValue}.
 *
 * @author Rahel Lüthy
 */
public final class App2 extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 800;
    private static final String TITLE = App2.class.getSimpleName();

    @Override
    public void start(Stage stage) {
        PresentationModel model = new PresentationModel();

        ImgView imgView = new ImgView(model);
        StatusView statusView = new StatusView(model.hoveredPixelProperty());

        BorderPane container = new BorderPane();
        container.setPadding(new Insets(10));
        container.setCenter(imgView);
        container.setBottom(statusView);

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
