package ch.fhnw.edu.ivis.ipix.step_5;

import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public final class FilterView extends HBox {

    public FilterView(DoubleProperty threshold) {

        Slider slider = new Slider(0, 1, 0);
        slider.setMajorTickUnit(0.1);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.valueProperty().bindBidirectional(threshold);

        Label currentValueLabel = new Label();
        currentValueLabel.textProperty().bind(Bindings.format("%.2f", threshold));

        HBox.setHgrow(slider, Priority.ALWAYS);

        getChildren().addAll(
                new Label("Brightness: "),
                slider,
                currentValueLabel
        );
    }

}