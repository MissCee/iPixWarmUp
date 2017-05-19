package ch.fhnw.edu.ivis.ipix.step_3;

import ch.fhnw.edu.ivis.ipix.step_2.ImgView;
import ch.fhnw.edu.ivis.ipix.step_2.PresentationModel;
import ch.fhnw.edu.ivis.ipix.step_2.StatusView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Demonstrates how to overlay a {@link javafx.scene.canvas.Canvas} on top of an image.
 * Paints the current mouse position as a colored circle.
 *
 * @author Rahel Lüthy
 */
public final class App3 extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 800;
    private static final String TITLE = App3.class.getSimpleName();

    @Override
    public void start(Stage stage) {
        PresentationModel model = new PresentationModel();

        ImgView imgView = new ImgView(model);
        SelectionOverlay selectionOverlay = new SelectionOverlay(model);
        StackPane imgWithSelection = new StackPane(imgView, selectionOverlay);

        StatusView statusView = new StatusView(model.hoveredPixelProperty());

        BorderPane container = new BorderPane();
        container.setPadding(new Insets(10));
        container.setCenter(imgWithSelection);
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
