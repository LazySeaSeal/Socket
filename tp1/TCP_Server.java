import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {

            ServerSocket serverSocket = new ServerSocket(9876);
            System.out.println("Server TCP waiting");
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected" + clientSocket.getInetAddress());
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(clientSocket.getOutputStream());
            String clientMessage = inFromClient.readLine();
            System.out.println("MSG RECIVED from client" + clientMessage);
            String responseMessage = "MSG recived";
            outToClient.writeBytes(responseMessage + '\n');
            serverSocket.close();
    }
}
