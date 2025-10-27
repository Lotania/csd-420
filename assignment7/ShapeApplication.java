//Anthony Nguyen, CSD-420, 10/25/2025
//The purpose of the program is to **ATTEMPT TO**
//demonstrate the CSS capabilities of JavaFX

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ShapeApplication extends Application {

    @Override
    public void start(Stage primaryStage) {
        //StackPane required to hold the rectangle and the first circle
        StackPane stackedShapes = new StackPane();

        // Create the rectangle
        Rectangle rect = new Rectangle(80, 80, 60, 275);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.BLACK); // tried linking a css class; rectangle disappeared
        rect.setStrokeWidth(5.0);

        // Create the circle inside the rectangle
        Circle circ = new Circle(30);
        circ.getStyleClass().addAll("plaincircle", "circleborder");

        // Add the rectangle and inner circle to the StackPane
        // The first child added is at the bottom of the stack
        stackedShapes.getChildren().addAll(rect, circ);

        // Create the three circles, link css class and id
        Circle circle1 = new Circle(30);
        circle1.getStyleClass().addAll("plaincircle", "border");
        Circle circle2 = new Circle(30);
        circle2.setId("redcircle");
        circle2.getStyleClass().add("border");
        Circle circle3 = new Circle(30);
        circle3.setId("greencircle");
        circle3.getStyleClass().add("border");

        // Create the HBox to arrange all items inline
        HBox hbox = new HBox(0);
        hbox.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(stackedShapes, circle1, circle2, circle3);

        // scene and stage
        Scene scene = new Scene(hbox, 400, 300);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setTitle("Shapes Lined with CSS");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
