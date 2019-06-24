package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Timer;
import java.util.TimerTask;

//@FXML
public class Controller{
    boolean FirstPressedYet = false;
    boolean finishedTask = false;
    Timer timer = new Timer();
    @FXML
    TextArea txtAreaInput;
    @FXML
    Label lblTime;
    @FXML
    Label lblWords;
    @FXML
    Label lblErrors;
    @FXML
    Label lblTextOutput;
    @FXML
    public void handleButtonActionTextSelection(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setTitle("Typing page");
        stage.setScene(new Scene(root1));
        String text = "";
        //setting the string values for the user to type
        String butPressed = ((Button)event.getSource()).getText();
        if (butPressed.equals("Easy"))
            text = Selection.textSelection("Easy");
        else if (butPressed.equals("Medium"))
            text = Selection.textSelection("Medium");
        else if (butPressed.equals("Hard"))
            text = Selection.textSelection("Hard");
        else if (butPressed.equals("Very Hard"))
            text = Selection.textSelection("VHard");
        ((Label)root1.getChildrenUnmodifiable().get(5)).setText(text);
        stage.show();
    }
    @FXML
    public void newTick() {

    }
    @FXML
    public void KeyTyped() {
        if (!FirstPressedYet) {
            FirstPressedYet = true;
            Timeline clock = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    if (!finishedTask) {
                        //outputting how much time is left on the clock
                        String mins = lblTime.getText().substring(11, 12);
                        String secs = lblTime.getText().substring(13);
                        int minNum = Integer.parseInt(mins);
                        int secsNum = Integer.parseInt(secs);
                        if (minNum == 1) {
                            secsNum += 60;
                            --minNum;
                        }
                        --secsNum;
                        if (minNum == 0 && secsNum == 0) {
                            finishedTask = true;
                        }
                        mins = Integer.toString(minNum);
                        secs = Integer.toString(secsNum);
                        String newTime = mins + ":" + secs;
                        lblTime.setText("Time Left: " + newTime);
                        //outputting the typing speed of the user
                        lblWords.setText("Typing Speed (WPM):" + Speed.speedCalc(txtAreaInput.getText().length(), 60 - secsNum));
                    }
                    else {
                        txtAreaInput.setDisable(true);
                    }
                }
            }));
            clock.setCycleCount(Timeline.INDEFINITE);
            clock.play();
        }
        //telling the user how many typos they have made
        String target = lblTextOutput.getText();
        String current = txtAreaInput.getText();
        int errors = 0;
        for (int i = 0; i < current.length(); ++i) {
            if (current.charAt(i) != target.charAt(i)) {
                ++errors;
            }
        }
        if (current.length() > 0) {
            if (current.charAt(current.length() - 1) != target.charAt(current.length() - 1)) {
                java.awt.Toolkit.getDefaultToolkit().beep();
                System.out.println(current.charAt(current.length() - 1));
                System.out.println(target.charAt(current.length() - 1));
                System.out.println();
            }
        }
        lblErrors.setText("Typos: " + errors);
    }
}
