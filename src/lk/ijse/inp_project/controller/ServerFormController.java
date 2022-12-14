package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import lk.ijse.inp_project.dto.ClientDTO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author : hansakagaa
 **/
public class ServerFormController {
    @FXML
    private JFXTextArea txtArea;
    @FXML
    private JFXButton btnLogin;
    @FXML
    private JFXTextField txtPort;
    @FXML
    private JFXButton btnSubmit;
    @FXML
    public Label lblUserSize;

    @FXML
    private void port_submit_on_action() {
        int PORT = Integer.parseInt(txtPort.getText());
        ClientDTO.portNum = PORT;

//        new Server(PORT);

        btnSubmit.setDisable(true);
    }

    @FXML
    public void login_client_on_action(ActionEvent actionEvent) throws IOException {
        Parent root = FXMLLoader.load(this.getClass().getResource("/lk/ijse/inp_project/view/login-form.fxml"));
        Scene mainScene = new Scene(root);
        Stage primaryStage = new Stage();
        primaryStage.setScene(mainScene);
        primaryStage.centerOnScreen();
        primaryStage.show();
    }

}
