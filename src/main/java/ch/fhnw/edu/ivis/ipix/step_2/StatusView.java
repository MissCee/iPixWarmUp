package ch.fhnw.edu.ivis.ipix.step_2;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public final class StatusView extends VBox {

    public StatusView(ObservableValue<Pixel> pixel) {

        Label label = new Label();

        // TODO: Update label whenever pixel changes

        getChildren().add(label);
    }

    private static String formatPixelInfo(Pixel pixel) {
        if (Pixel.NONE.equals(pixel)) {
            return "–";
        } else {
            return String.format(
                    "Pixel Position: %.0f / %.0f \t Pixel Brightness: %.2f",
                    pixel.getX(),
                    pixel.getY(),
                    pixel.getBrightness());
        }
    }

}
