package homework_3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private final ServerSocket serverSocket;

    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    public void startServer(){

        try {

            while (!serverSocket.isClosed()){

                Socket socket = serverSocket.accept();
                System.out.println("New Client");
                ClientHandler clientHandler = new ClientHandler(socket);

                Thread thread = new Thread(clientHandler);
                thread.start();

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {

        ServerSocket socket = new ServerSocket(1234);
        Server server = new Server(socket);
        server.startServer();
    }
}