package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

//@FXML
public class Controller {
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
}
