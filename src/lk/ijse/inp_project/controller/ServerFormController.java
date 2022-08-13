package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

/**
 * @author : hansakagaa
 **/
public class ServerFormController {
    @FXML
    public JFXTextArea txtArea;
    @FXML
    public JFXTextField txtPort;
    @FXML
    public JFXTextField txtHost;
    @FXML
    public JFXButton btnSubmit;

    @FXML
    public void port_submit_on_action(ActionEvent actionEvent) {

    }
}
