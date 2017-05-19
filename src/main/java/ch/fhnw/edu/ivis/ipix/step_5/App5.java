package ch.fhnw.edu.ivis.ipix.step_5;

import ch.fhnw.edu.ivis.ipix.step_2.StatusView;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Demonstrates how to use a slider for filtering pixels by brightness.
 *
 * @author Rahel Lüthy
 */
public final class App5 extends Application {

    private static final double WIDTH = 800;
    private static final double HEIGHT = 800;
    private static final String TITLE = App5.class.getSimpleName();

    @Override
    public void start(Stage stage) {
        PresentationModel model = new PresentationModel();

        FilterView filterView = new FilterView(model.filterThresholdProperty());

        ImgView imgView = new ImgView(model);
        SelectionOverlay selectionOverlay = new SelectionOverlay(model);
        StackPane imgWithSelection = new StackPane(imgView, selectionOverlay);

        StatusView statusView = new StatusView(model.hoveredPixelProperty());

        BorderPane container = new BorderPane();
        container.setPadding(new Insets(10));
        container.setTop(filterView);
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
