package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.ijse.inp_project.controller.bo.Server;

/**
 * @author : hansakagaa
 **/
public class ServerFormController {
    @FXML
    public static JFXTextArea txtArea;
    @FXML
    public JFXTextField txtPort;
    @FXML
    public JFXButton btnSubmit;
    @FXML
    public static Label lblUserSize;

    @FXML
    public void port_submit_on_action() {
        int PORT = Integer.parseInt(txtPort.getText());
        new Server(PORT);

        btnSubmit.setDisable(true);
    }
}
