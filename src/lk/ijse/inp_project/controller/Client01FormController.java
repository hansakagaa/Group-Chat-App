package lk.ijse.inp_project.controller;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

/**
 * @author : hansakagaa
 **/
public class Client01FormController {
    @FXML
    private ImageView imgCamera;
    @FXML
    private ImageView imgSend;
    @FXML
    private JFXTextArea txtArea;
    @FXML
    private JFXTextField txtMessage;


    public void initialize(){
    }

    @FXML
    private void message_key_released(KeyEvent keyEvent) {
    }

    @FXML
    private void send_message_on_click(MouseEvent event) {
    }

    @FXML
    private void choose_image_on_click(MouseEvent event) {
    }
}
