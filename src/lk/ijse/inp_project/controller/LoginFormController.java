package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

/**
 * @author : hansakagaa
 **/
public class LoginFormController {
    @FXML
    private AnchorPane root;
    @FXML
    private Label lblHost;
    @FXML
    private Label lblPort;
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private void login_on_action(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/inp_project/view/client-form.fxml"));
        Scene subScene = new Scene(root);
        Stage primaryStage = (Stage) this.root.getScene().getWindow();
        primaryStage.setTitle(txtUserName.getText());
        primaryStage.setScene(subScene);
        primaryStage.centerOnScreen();
    }

    @FXML
    private void playMouseEnterAnimation(MouseEvent event) {
        if (event.getSource() instanceof JFXButton){
            JFXButton button = (JFXButton) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), button);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

        }
        if (event.getSource() instanceof JFXTextField){
            JFXTextField field = (JFXTextField) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), field);
            scaleT.setToX(1.2);
            scaleT.setToY(1.2);
            scaleT.play();

        }
    }

    @FXML
    private void playMouseExitAnimation(MouseEvent event) {
        if (event.getSource() instanceof JFXButton){
            JFXButton button = (JFXButton) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), button);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();
            button.setEffect(null);
        }
        if (event.getSource() instanceof JFXTextField){
            JFXTextField field = (JFXTextField) event.getSource();
            ScaleTransition scaleT = new ScaleTransition(Duration.millis(200), field);
            scaleT.setToX(1);
            scaleT.setToY(1);
            scaleT.play();

            field.setEffect(null);
        }
    }
}
