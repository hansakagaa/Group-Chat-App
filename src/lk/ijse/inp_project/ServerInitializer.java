package lk.ijse.inp_project;

import lk.ijse.inp_project.util.ClientHandler;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * @author : hansakagaa
 **/

public class ServerInitializer{

    private static ArrayList<ClientHandler> clients = new ArrayList<ClientHandler>();

    public static void main(String[] args) {
        ServerSocket serverSocket;
        Socket socket;
        try {
            serverSocket = new ServerSocket(5000);
            while (true){
                System.out.println("Waiting");
                socket = serverSocket.accept();
                System.out.println("Connected");
                ClientHandler thread = new ClientHandler(socket,clients);
                clients.add(thread);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
