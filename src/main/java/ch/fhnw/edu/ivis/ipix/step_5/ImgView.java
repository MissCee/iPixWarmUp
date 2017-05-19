package ch.fhnw.edu.ivis.ipix.step_5;

import ch.fhnw.edu.ivis.ipix.step_2.Pixel;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public final class ImgView extends StackPane {

    public ImgView(PresentationModel model) {
        ImageView imageView = new ImageView(model.getImage());

        imageView.setOnMouseMoved(e -> {
            int x = (int) e.getX();
            int y = (int) e.getY();
            Color color = imageView.getImage().getPixelReader().getColor(x, y);
            double brightness = color.getBrightness();
            Pixel pixel = new Pixel(x, y, brightness);
            model.hoveredPixelProperty().setValue(pixel);
        });

        imageView.setOnMouseExited(e ->
                model.hoveredPixelProperty().setValue(Pixel.NONE)
        );

        getChildren().add(imageView);
    }

}
