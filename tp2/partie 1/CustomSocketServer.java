package partie1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CustomSocketServer {
    public static void main(String args[]) {
        int customPort = 0;
        Scanner keyboard = new Scanner(System.in);

        // Enter the listening port
        System.out.print("Listening port: ");
        try {
            customPort = keyboard.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("The parameter is not an integer.");
            System.err.println("Usage: java CustomSocketServer server-port");
            System.exit(-1);
        }

        try {
            // Create a ServerSocket object bound to the specified port
            ServerSocket customServerSocket = new ServerSocket(customPort);

            // The server waits for an incoming connection
            Socket customSocket = customServerSocket.accept();

            // Create ObjectOutputStream and ObjectInputStream objects to send and receive objects through the socket
            ObjectOutputStream customOutput = new ObjectOutputStream(customSocket.getOutputStream());
            ObjectInputStream customInput = new ObjectInputStream(customSocket.getInputStream());

            // Read the string sent by the client through the input stream
            String receivedString = (String) customInput.readObject();
            System.out.println("Received: " + receivedString);

            // Display the client's IP address and port
            System.out.println("Received from: " + customSocket.getInetAddress() + ":" + customSocket.getPort());

            // Send a response to the client through the output stream
            customOutput.writeObject(new String("Received successfully"));

        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            keyboard.close();
        }
    }
}
