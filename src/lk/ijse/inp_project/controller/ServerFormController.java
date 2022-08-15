package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import lk.ijse.inp_project.bo.Server;

/**
 * @author : hansakagaa
 **/
public class ServerFormController {
    @FXML
    public static JFXTextArea txtArea;
    @FXML
    private JFXTextField txtPort;
    @FXML
    private JFXButton btnSubmit;
    @FXML
    public static Label lblUserSize;

    @FXML
    private void port_submit_on_action() {
        int PORT = Integer.parseInt(txtPort.getText());
        String message = "Server start";
        txtArea.appendText(message.trim());
        new Server(PORT);

        btnSubmit.setDisable(true);
    }
//
//    public void setAppendText(String message){
//        System.out.println(message);
//        txtArea.appendText(message.trim());
//    }
}
