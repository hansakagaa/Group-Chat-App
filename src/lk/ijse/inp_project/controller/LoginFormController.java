package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.ScaleTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

/**
 * @author : hansakagaa
 **/
public class LoginFormController {
    @FXML
    private JFXTextField txtUserName;

    @FXML
    private void login_on_action(ActionEvent actionEvent) {
    }

    @FXML
    public void playMouseEnterAnimation(MouseEvent event) {
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
    public void playMouseExitAnimation(MouseEvent event) {
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
