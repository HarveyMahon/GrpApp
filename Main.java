package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.util.Date;
import java.util.Timer;

public class Main extends Application {
    @FXML
    private TextArea testText;
    @FXML
    private Label speedLabel;

    boolean shiftHeld = false;
    long startTime = 0L;
    long timePassed = 0L;
    long keysPressed = 0L;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        //this calculates the speed of the typer and outputs it to the console, this is fully functional and calculates words per minute
        root.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            if (startTime == 0L) {
                startTime = System.currentTimeMillis();
            }
            timePassed = System.currentTimeMillis() - startTime;
            if (event.getCode() == KeyCode.BACK_SPACE) {
                --keysPressed;
            }
            else if (event.isShiftDown() && event.getCode() != KeyCode.SHIFT) {
                ++keysPressed;
            }
            else if (event.getCode() != KeyCode.SHIFT){
                ++keysPressed;
            }
            System.out.println(timePassed);
            System.out.println(keysPressed);
            String fin = ((Float)((((float)keysPressed/((float)timePassed/1000f))*60f)/4.5f)).toString();
            System.out.println(fin);
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Controller

}
