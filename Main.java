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

public class Main extends Application {
    @FXML
    private TextArea testText;
    @FXML
    private Label speedLabel;

    boolean shiftHeld = false;
    long startTime = 0L;
    long endTime = 0L;
    long timePassed = 0L;
    int keysPressed = 0;

    boolean mistakeMade = false;
    String testString = "Peter Piper picked a peck of pickled peppers";
    String userString = "";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Touch Typing System");
        primaryStage.setScene(new Scene(root, 300, 275));
        root.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
            //if the user is still entering the test string
            if (mistakeMade) {
                System.out.println("error");
                java.awt.Toolkit.getDefaultToolkit().beep();
            }
            if (keysPressed < testString.length() || mistakeMade) {
                if (startTime == 0L) {
                    startTime = System.currentTimeMillis();
                }
                timePassed = System.currentTimeMillis() - startTime;
                if (event.getCode() == KeyCode.BACK_SPACE) {
                    System.out.println(keysPressed != 0);
                    if (keysPressed != 0) {
                        --keysPressed;
                        userString = userString.substring(0, userString.length()-1);
                    }
                    if (userString.charAt(keysPressed-1) == testString.charAt(keysPressed-1)) {
                        mistakeMade = false;
                    }
                } else if (event.isShiftDown() && event.getCode() != KeyCode.SHIFT) {
                    userString += event.getText().toUpperCase();
                    if (event.getText().toUpperCase().equals(((Character)testString.charAt(keysPressed)).toString())) {
                        System.out.println("Yes");
                        mistakeMade = false;
                    }
                    else {
                        mistakeMade = true;
                    }
                    ++keysPressed;
                } else if (event.getCode() != KeyCode.SHIFT) {
                    userString += event.getText();
                    if (event.getText().equals(((Character)testString.charAt(keysPressed)).toString())) {
                        System.out.println("Yes");
                        mistakeMade = false;
                    }
                    else {
                        mistakeMade = true;
                    }
                    ++keysPressed;
                }

                System.out.println(testString);
                System.out.println(userString);
            }
            if (keysPressed == testString.length() && !mistakeMade) {
                if (endTime == 0L) endTime = System.currentTimeMillis();
                String fin = ((Integer) ((Float) ((((float) keysPressed / ((float)(endTime - startTime) / 1000f)) * 60f) / 4.5f)).intValue()).toString();
                System.out.printf("Task successful at a rate of %s WPM\n", fin);
            }
        });
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    // Controller

}
