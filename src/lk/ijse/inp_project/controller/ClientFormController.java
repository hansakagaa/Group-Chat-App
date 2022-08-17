package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author : hansakagaa
 **/
public class ClientFormController extends Thread {
    @FXML
    public AnchorPane root;
    @FXML
    public ImageView imgCamera;
    @FXML
    private ImageView imgSend;
    @FXML
    private JFXTextArea txtArea;
    @FXML
    private JFXTextField txtMessage;

    Socket socket;
    BufferedReader bufferedReader;
    PrintWriter printWriter;

    String message;

    public void initialize(){
        imgSend.setVisible(false);
        try {
            socket = new Socket("localhost", 5000);
            System.out.println("Connect With Server");

            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
            printWriter = new PrintWriter(socket.getOutputStream(), true);

            this.start();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void send_message_on_click() throws IOException {
        printWriter.println(LoginFormController.userName+" : "+txtMessage.getText());
        printWriter.flush();

        txtMessage.clear();
        txtMessage.requestFocus();
    }

    @FXML
    private void choose_image_on_click() {
    }

    @FXML
    private void message_key_released() {
        if (!txtMessage.getText().isEmpty()){
            imgSend.setVisible(true);
        }
    }
}
