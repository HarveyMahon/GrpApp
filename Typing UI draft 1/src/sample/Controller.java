package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

//@FXML
public class Controller {

    public Button ButEasy;


    public static boolean pressedVHard;
    public static boolean pressedHard;
    public static boolean pressedMedium;
    public static boolean pressedEasy;
    public Label lblTextOutput;

    /*Label lbltextOutput;

    private void thing() {
        lbltextOutput.setText("hello world");
    }

    public void logInChanfe() {

    }
    */
    @FXML
    public void handleButtonActionTextSelection(ActionEvent event) {
        if(event.getSource()==ButEasy){
            pressedEasy=true;
        }

            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
                Parent root1 = (Parent) fxmlLoader.load();
                Stage stage = new Stage();
                stage.setTitle("Typing page");
                stage.setScene(new Scene(root1));
                stage.show();
            } catch (Exception e) {
                System.out.println("Can't Load new window");
            }
        Selection.textSelection(true);
        }


}
