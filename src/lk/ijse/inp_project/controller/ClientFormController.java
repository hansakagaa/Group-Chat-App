package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * @author : hansakagaa
 **/
public class ClientFormController {
    @FXML
    private ImageView imgCamera;
    @FXML
    private ImageView imgSend;
    @FXML
    private JFXTextArea txtArea;
    @FXML
    private JFXTextField txtMessage;

    final int PORT = 10000;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    String message = "";

    public void initialize(){
        new Thread(() -> {
            try {
                socket = new Socket("localhost",PORT);

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                while (!message.equals("Bye")){
                    message = dataInputStream.readUTF();
                    txtArea.appendText("\n" + message);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    @FXML
    private void send_message_on_click(MouseEvent event) throws IOException {
        dataOutputStream.writeUTF(txtMessage.getText().trim());
        dataOutputStream.flush();
    }

    @FXML
    private void choose_image_on_click(MouseEvent event) {
    }

    @FXML
    private void message_key_released(KeyEvent keyEvent) {
    }
}
