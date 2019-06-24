package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

//@FXML
public class Controller{
    boolean FirstPressedYet = false;
    boolean finishedTask = false;
    Timer timer = new Timer();
    @FXML
    Button butCert;
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
        String butPressed = ((Button)event.getSource()).getText();
        stage.setTitle(butPressed);
        stage.setScene(new Scene(root1));
        String text = "";
        //setting the string values for the user to type
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
                        if (secs.length() == 1) secs = "0" + secs;
                        String newTime = mins + ":" + secs;
                        lblTime.setText("Time Left: " + newTime);
                        //outputting the typing speed of the user
                        lblWords.setText("Typing Speed (WPM):" + Speed.speedCalc(txtAreaInput.getText().length(), 60 - secsNum));
                    }
                    else {
                        txtAreaInput.setDisable(true);
                        butCert.setDisable(false);
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
            }
        }
        lblErrors.setText("Typos: " + errors);
    }

    public void trialEnd() {
        //getting the user's names
        TextInputDialog dialog = new TextInputDialog("Name here");
        dialog.setTitle("Username");
        dialog.setHeaderText("You did great!");
        dialog.setContentText("Please enter your name:");

        Optional<String> result = dialog.showAndWait();
        int howManyErrors = Integer.parseInt(lblErrors.getText().substring(7));
        int accuracy = 100 - Math.round(((float)howManyErrors/(float)txtAreaInput.getText().length()))*100;
        String difficulty = ((Stage)(lblTextOutput.getScene()).getWindow()).getTitle();
        String speed = lblWords.getText().substring(19);
        //create certificate
        try {
            //difficulty, name, score
            System.out.println(accuracy + "%");
            Certificate.createCertificate(difficulty, result.get(), Integer.parseInt(speed));
            Process p = Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler Certificate.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        //calc score
        int score = Scoring.calcScore(txtAreaInput.getText().length(), accuracy);
        System.out.println(score);
    }
}
