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

//
    public static List<Client> clients;
    public static DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    String userName;
//

    public void initialize(){
        System.out.println(5000);

        clients = new ArrayList<>();

        System.out.println("29");
        try {
            ServerSocket serverSocket = new ServerSocket(5000);
            Socket socket;
            while (!serverSocket.isClosed()){
                System.out.println("34");
                socket = serverSocket.accept();
//        ServerFormController.txtArea.appendText("Start Server..!\n");
                System.out.println("Start Server..!\n");
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("39");
                userName = dataInputStream.readUTF();
                Client client = new Client(userName, dataInputStream, dataOutputStream);

//                ServerFormController.txtArea.appendText("\nConnected : " + userName);
                System.out.println("\nConnected : " + userName);

                clients.add(client);
                System.out.println("47");
                List<Client> users = Server.clients;
                for (Client user : users) {
                    DataOutputStream dataOutputStream = user.getDataOutputStream();
                    dataOutputStream.writeUTF(userName);
                    System.out.println("52");
                }
//                ServerFormController.lblUserSize.setText("Current User : "+ Server.clients.size());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }


    }

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
//
    public void setAppendText(String message){
        txtArea.setText(message);
    }
//
    public void setText(){
        try {
            txtArea.setText(Server.message);
        }catch (NullPointerException e){
            System.out.println("catch : "+e.getMessage());
        }

    }
}
