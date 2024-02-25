import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CustomTCPServer {

    public static void main(String[] args) {
        final int MAX_CLIENTS = 10;
        ServerSocket customServerSocket = null;
        
        try {
            // Create the server on port 8081
            customServerSocket = new ServerSocket(8081);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                // Wait for a client connection
                Socket customClientSocket = customServerSocket.accept();
                System.out.println("New client connection: " + customClientSocket);

                // If the maximum number of clients is reached, close the connection with a message
                if (Thread.activeCount() > MAX_CLIENTS) {
                    PrintWriter out = new PrintWriter(customClientSocket.getOutputStream(), true);
                    out.println("Maximum number of clients reached. Please try again later.");
                    customClientSocket.close();
                    continue;
                }

                // Create a thread to handle the client's request
                Thread thread = new Thread(new CustomClientHandler(customClientSocket));
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // Close the server socket
            if (customServerSocket != null) {
                try {
                    customServerSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class CustomClientHandler implements Runnable {
        private final Socket customClientSocket;

        CustomClientHandler(Socket socket) {
            this.customClientSocket = socket;
        }

        @Override
        public void run() {
            try {
                // Initialize input and output streams
                BufferedReader in = new BufferedReader(new InputStreamReader(customClientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(customClientSocket.getOutputStream(), true);

                // Read the string sent b
