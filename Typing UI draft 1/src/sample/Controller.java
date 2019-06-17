package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Controller {

    public Button ButEasy;

    Label lbltextOutput;

    private void thing() {
        lbltextOutput.setText("hello world");
    }

    public void logInChanfe() {

    }

    void handleButtonAction(ActionEvent event) {
        if(event.getSource()==ButEasy)
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
            Parent root1 = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            stage.setTitle("Second Window");
            stage.setScene(new Scene(root1));
            stage.show();
        }catch(Exception e){
            System.out.println("Can't Load new window");
        }
    }
}
