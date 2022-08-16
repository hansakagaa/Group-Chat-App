package lk.ijse.inp_project.util;

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
        System.out.println(PORT);

        clients = new ArrayList<>();

        System.out.println("29");
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("32");
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

                ServerFormController.lblUserSize.setText("Current User : "+ Server.clients.size());
            }
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
