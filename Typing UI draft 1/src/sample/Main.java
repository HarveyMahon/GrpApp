package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    //@Override
    public static int charactersTyped;
    public static double accuracy;
    public Parent root;

    public void start(Stage primaryStage) throws Exception{
        root = FXMLLoader.load(getClass().getResource("TextSelection.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();

        Scoring.calcScore(4,10);

    }



    public static void main(String[] args) {
        launch(args);
    }
}
