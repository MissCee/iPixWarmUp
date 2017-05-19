package ch.fhnw.edu.ivis.ipix.step_4;

import ch.fhnw.edu.ivis.ipix.step_2.Pixel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

public final class PresentationModel {

    private static final String IMG_URL = "brain.png";

    private final Image image = new Image(IMG_URL);
    private final ObjectProperty<Pixel> hoveredPixel = new SimpleObjectProperty<>(Pixel.NONE);
    private final ObservableList<Pixel> mouseTrail = FXCollections.observableArrayList();

    public Image getImage() {
        return image;
    }

    public ObjectProperty<Pixel> hoveredPixelProperty() {
        return hoveredPixel;
    }

    public ObservableList<Pixel> getMouseTrail() {
        return mouseTrail;
    }

}
