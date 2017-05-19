package ch.fhnw.edu.ivis.ipix.step_4;

import ch.fhnw.edu.ivis.ipix.step_2.StatusView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Demonstrates how to display a mouse trail by tracking multiple pixels in an
 * {@link javafx.collections.ObservableList}.
 *
 * @author Rahel Lüthy
 */
public final class App4 extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 800;
    private static final String TITLE = App4.class.getSimpleName();

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
