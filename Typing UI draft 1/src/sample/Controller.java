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
    public void FirstKeyTyped() {
        if (!FirstPressedYet) {
            FirstPressedYet = true;
            Timeline clock = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    if (!finishedTask) {
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
                    }
                }
            }));
            clock.setCycleCount(Timeline.INDEFINITE);
            clock.play();
        }
    }
}
