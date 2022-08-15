package lk.ijse.inp_project.controller.bo;

import lk.ijse.inp_project.controller.ServerFormController;

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
public class Server {
    public static List<Client> clients;
    public static DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;
    String userName;
    Socket socket;

    public Server(int PORT){
        clients = new ArrayList<>();

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            while (!serverSocket.isClosed()){
                socket = serverSocket.accept();

                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());

                userName = dataInputStream.readUTF();
                Client client = new Client(userName, dataInputStream, dataOutputStream);

                ServerFormController.txtArea.appendText("\nConnected : " + userName);
                clients.add(client);

                List<Client> users = Server.clients;
                for (Client user : users) {
                    DataOutputStream dataOutputStream = user.getDataOutputStream();
                    dataOutputStream.writeUTF(userName);
                }

                ServerFormController.lblUserSize.setText("Current User : "+ Server.clients.size());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
