package ch.fhnw.edu.ivis.ipix.step_2;

import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;

public final class ImgView extends StackPane {

    public ImgView(PresentationModel model) {
        ImageView imageView = new ImageView(model.getImage());

        // TODO: Update model whenever mouse is moved

        getChildren().add(imageView);
    }

}
