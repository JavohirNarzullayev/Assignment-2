package Controller;

import Service.Sound;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    public static void main(String[] args) {
            launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("View/PhotoView.fxml")));
        primaryStage.setTitle("Phliker");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("images/1.png"));
        primaryStage.show();
        new Sound();
    }
}
