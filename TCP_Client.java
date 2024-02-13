import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String[] args) {
            Socket socket = new Socket("localhost", 9876);
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(socket.getOutputStream(), true);
            String message = "HELLO WORLD";
            outToServer.println(message);
            String responseMessage = inFromServer.readLine();
            System.out.println("Response from server" + responseMessage);
            socket.close();
        
    }
}
