package ch.fhnw.edu.ivis.ipix.step_5;

import ch.fhnw.edu.ivis.ipix.step_2.Pixel;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SelectionOverlay extends Canvas {

    private static final Paint HOVERED_PIXEL_COLOR = Color.ORANGE;
    private static final int HOVERED_PIXEL_RADIUS = 5;
    private static final Paint FILTERED_PIXELS_COLOR = Color.YELLOW;

    public SelectionOverlay(PresentationModel model) {
        super(model.getImage().getWidth(), model.getImage().getHeight());

        GraphicsContext context = getGraphicsContext2D();

        model.hoveredPixelProperty().addListener(listener ->
                updateOverlay(getWidth(), getHeight(), context, model)
        );

        model.filterThresholdProperty().addListener((observable, oldValue, newValue) -> {
            updateOverlay(getWidth(), getHeight(), context, model);
        });

        updateOverlay(getWidth(), getHeight(), context, model);

        setMouseTransparent(true);
    }

    private static void updateOverlay(double width, double height, GraphicsContext context, PresentationModel model) {
        context.clearRect(0, 0, width, height);
        updateHoveredPixel(context, model.hoveredPixelProperty().get());
        updateFilteredPixels(context, model);
    }

    private static void updateHoveredPixel(GraphicsContext context, Pixel pixel) {
        context.setFill(HOVERED_PIXEL_COLOR);
        double circleX = pixel.getX() - HOVERED_PIXEL_RADIUS;
        double circleY = pixel.getY() - HOVERED_PIXEL_RADIUS;
        double circleDiameter = 2 * HOVERED_PIXEL_RADIUS;
        context.fillOval(circleX, circleY, circleDiameter, circleDiameter);
    }

    private static void updateFilteredPixels(GraphicsContext context, PresentationModel model) {
        context.setFill(FILTERED_PIXELS_COLOR);

        double threshold = model.filterThresholdProperty().get();

        // TODO: Paint pixels for which brightness is < threshold

    }

}
