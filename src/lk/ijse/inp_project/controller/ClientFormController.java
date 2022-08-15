package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import lk.ijse.inp_project.dto.ClientDTO;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author : hansakagaa
 **/
public class ClientFormController {
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

    public static Thread thread;
    Socket socket;
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    String message;

    public void initialize(){
        imgSend.setVisible(false);

//
        ClientDTO.hostName = "localhost";
        ClientDTO.portNum = 5000;
//

        try {
            socket = new Socket(ClientDTO.hostName, ClientDTO.portNum);
            dataOutputStream = new DataOutputStream(socket.getOutputStream());
            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream.writeUTF(ClientDTO.userName);

            thread = new Thread(() ->{
                try {
                    while (socket.isConnected()){
                        message = dataInputStream.readUTF();
                        txtArea.appendText("\n"+ message);
                    }
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            });

            thread.start();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    private void send_message_on_click() throws IOException {
        dataOutputStream.writeUTF(ClientDTO.userName+" : "+txtMessage.getText());

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
