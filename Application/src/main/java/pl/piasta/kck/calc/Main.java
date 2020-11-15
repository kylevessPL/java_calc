package pl.piasta.kck.calc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        VBox root = FXMLLoader.load(getClass().getResource("/resources/fxml/main.fxml"));
        primaryStage.setTitle("Calculator");
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/resources/icons/favicon.png")));
        primaryStage.setScene(new Scene(root));
        primaryStage.setMinWidth(970);
        primaryStage.setMinHeight(510);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
