package ch.fhnw.edu.ivis.ipix.step_3;

import ch.fhnw.edu.ivis.ipix.step_2.Pixel;
import ch.fhnw.edu.ivis.ipix.step_2.PresentationModel;
import javafx.beans.property.ObjectProperty;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

public class SelectionOverlay extends Canvas {

    private static final Paint HOVERED_PIXEL_COLOR = Color.ORANGE;
    private static final int HOVERED_PIXEL_RADIUS = 5;

    public SelectionOverlay(PresentationModel model) {
        super(model.getImage().getWidth(), model.getImage().getHeight());

        GraphicsContext context = getGraphicsContext2D();

        ObjectProperty<Pixel> hoveredPixel = model.hoveredPixelProperty();
        hoveredPixel.addListener(listener ->
                updateOverlay(getWidth(), getHeight(), context, hoveredPixel.get())
        );

        updateOverlay(getWidth(), getHeight(), context, hoveredPixel.get());

        setMouseTransparent(true);
    }

    private static void updateOverlay(double width, double height, GraphicsContext context, Pixel pixel) {
        context.clearRect(0, 0, width, height);
        context.setFill(HOVERED_PIXEL_COLOR);

        // TODO: Paint a circle at the pixel location

    }

}
