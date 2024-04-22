import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ColorPicker extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Creates sliders for red, green, blue, and opacity
        Slider redSlider = createSlider(0, 255, 0);
        Slider greenSlider = createSlider(0, 255, 0);
        Slider blueSlider = createSlider(0, 255, 0);
        Slider opacitySlider = createSlider(0, 100, 100);

        // Creates a text object to display the selected color
        Text text = new Text("Sample Text");
        text.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 24));

        // Creates a GridPane for the sliders and text
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(10));

        // Adds sliders and text to the GridPane
        gridPane.addRow(0, new Label("Red:"), redSlider);
        gridPane.addRow(1, new Label("Green:"), greenSlider);
        gridPane.addRow(2, new Label("Blue:"), blueSlider);
        gridPane.addRow(3, new Label("Opacity:"), opacitySlider);
        gridPane.add(text, 0, 4, 2, 1);

        // Sets up event handlers for the sliders
        redSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(text, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));
        greenSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(text, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));
        blueSlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(text, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));
        opacitySlider.valueProperty().addListener((observable, oldValue, newValue) -> updateColor(text, redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue(), opacitySlider.getValue()));

        // Sets up scene
        Scene scene = new Scene(gridPane, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Color Picker");
        primaryStage.show();
    }

    // Utility method to create a slider with min, max, and initial value
    private Slider createSlider(double min, double max, double initialValue) {
        Slider slider = new Slider(min, max, initialValue);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);
        slider.setMajorTickUnit((max - min) / 10);
        slider.setMinorTickCount(5);
        return slider;
    }

    // Utility method to update color of the text based on slider
    private void updateColor(Text text, double red, double green, double blue, double opacity) {
        double opacityValue = opacity / 100.0;
        Color color = Color.rgb((int) red, (int) green, (int) blue, opacityValue);
        text.setFill(color);
    }

    public static void main(String[] args) {
        launch(args);
    }
}