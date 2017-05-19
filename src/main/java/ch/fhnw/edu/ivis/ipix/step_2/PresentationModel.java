package ch.fhnw.edu.ivis.ipix.step_2;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.image.Image;

public final class PresentationModel {

    private static final String IMG_URL = "brain.png";

    private final Image image = new Image(IMG_URL);
    private final ObjectProperty<Pixel> hoveredPixel = new SimpleObjectProperty<>(Pixel.NONE);

    public Image getImage() {
        return image;
    }

    public ObjectProperty<Pixel> hoveredPixelProperty() {
        return hoveredPixel;
    }

}
