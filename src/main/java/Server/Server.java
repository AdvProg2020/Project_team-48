package Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket serverSocket;
    private DataInputStream input ;
    private DataOutputStream output;

    public Server() {
        try {
            serverSocket = new ServerSocket(1111);
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            Socket socket = null;
            try {
                socket = serverSocket.accept();
                input = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
                output = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
                Thread client = new ClientHandler(input, output, socket);
                client.start();

            } catch (IOException e) {
                try {
                    socket.close();
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
                e.printStackTrace();
            }



        }

    }
}
