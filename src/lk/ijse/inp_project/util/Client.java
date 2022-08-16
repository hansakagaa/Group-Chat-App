package lk.ijse.inp_project.util;

import lk.ijse.inp_project.controller.ServerFormController;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : hansakagaa
 **/
public class Client {
    String userName;
    String message;
    private final DataOutputStream dataOutputStream;
    private final DataInputStream dataInputStream;

    public DataOutputStream getDataOutputStream(){
        return dataOutputStream;
    }

    Client(String userName, DataInputStream dataInputStream, DataOutputStream dataOutputStream){
        this.userName = userName;
        this.dataOutputStream = dataOutputStream;
        this.dataInputStream = dataInputStream;

        startClient();
    }

    private void startClient() {
        new Thread(() ->{
            try {
                while(true) {
                    message = dataInputStream.readUTF();
                    List<Client> users = Server.clients;
                    for (Client user : users) {
                        DataOutputStream dataOutputStream = user.getDataOutputStream();
                        dataOutputStream.writeUTF(message);
                    }
                }
            } catch (IOException E) {
                System.out.println(E.getMessage());

                closeAll(dataInputStream, dataOutputStream);

                Server.clients = Server.clients.stream().filter(e -> {
                    if(!(e == this)) {
//                        ServerFormController.txtArea.appendText("\nDisconnected : " + userName);
                        System.out.println("Client : "+ "\nDisconnected : " + userName);
                        try {
                            e.getDataOutputStream().writeUTF(userName);
                        } catch (IOException er) {
                            System.out.println(er.getMessage());
                        }
                    }
                    return !(e == this);
                }).collect(Collectors.toList());

                ServerFormController.lblUserSize.setText("Current User : "+ Server.clients.size());
            }
        }).start();
    }

    private void closeAll(DataInputStream dataInputStream, DataOutputStream dataOutputStream){
        try {
            if (dataInputStream != null) {
                dataInputStream.close();
            }
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
