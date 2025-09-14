//Anthony Nguyen, CSD-420 Assignment M1, 09/14/2025
//The purpose of this program is to demonstrate the functionality of JavaFX
//using images from a local subfolder.

//import javafx packages for displaying proper sized images in the scene
import javafx.application.Application;
import javafx.geometry.Insets;//positioning
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

//import necessary libraries for image and folder retrieval
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ImageDisplay extends Application {

    //set the name of the folder path
    private static final String IMAGE_FOLDER_PATH = "/csd-420/AssignmentCards";
    private final ImageView[] imageViews = new ImageView[4];
    //both name and array marked final to prevent unecessary changes

    public static void main(String[] args) {
        launch(args);//main method will launch the override scene
    }

    @Override
    public void start(Stage primaryStage) {
        //set the grid, with horizontal and vertical gaps between columns and rows
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));

        //set image size and placement
        for (int i = 0; i < imageViews.length; i++) {
            imageViews[i] = new ImageView();
            imageViews[i].setFitWidth(200);
            imageViews[i].setFitHeight(150);
            imageViews[i].setPreserveRatio(true);
            gridPane.add(imageViews[i], i % 2, i / 2);
        }

        // Create the refresh button with a lambda expression for its action handler
        Button refreshButton = new Button("Refresh Images");
        refreshButton.setOnAction(e -> refreshImages());

        // Set up the root layout
        VBox root = new VBox(20);
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(gridPane, refreshButton);

        // Set up the scene and stage
        Scene scene = new Scene(root, 450, 400);
        primaryStage.setTitle("Random Image Viewer");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Initial image load
        refreshImages();
    }

    private void refreshImages() {
        try {
            // obtain path of folder
            List<File> imageFiles = getImageFiles(IMAGE_FOLDER_PATH);

            //check for any images in folder
            if (imageFiles.size() < 4) {
                System.err.println("Not enough images in the folder. Found: " + imageFiles.size());
                return;
            }

            // Shuffle the list and select the first four
            Collections.shuffle(imageFiles);
            for (int i = 0; i < 4; i++) {
                File file = imageFiles.get(i);
                try {
                    // Load the image from the file path
                    Image image = new Image(new FileInputStream(file));
                    imageViews[i].setImage(image); // Update the ImageView with the new image
                } catch (FileNotFoundException e) {
                    System.err.println("Could not find file: " + file.getAbsolutePath());
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            System.err.println("An error occurred during image refresh: " + e.getMessage());
            e.printStackTrace();
        }
    }

    //check the path for the proper folder, then check the folder for the name
    private List<File> getImageFiles(String folderPath) throws Exception {
        Path dirPath = Paths.get(folderPath);
        if (!Files.exists(dirPath) || !Files.isDirectory(dirPath)) {
            throw new FileNotFoundException("Image folder not found: " + folderPath);
        }
        try (Stream<Path> paths = Files.list(dirPath)) {//attempt to read the path of the folder
            return paths
                    .filter(Files::isRegularFile)
                    .map(Path::toFile)
                    .filter(file -> isImageFile(file.getName()))
                    .collect(Collectors.toList());
        }
    }

    private boolean isImageFile(String fileName) {//check for proper extension
        String name = fileName.toLowerCase();
        return name.endsWith(".jpg") || name.endsWith(".jpeg") || name.endsWith(".png") || name.endsWith(".gif");
    }
}
//could not use lambda expressions except on refresh for errors