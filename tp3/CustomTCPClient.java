import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class CustomTCPClient {

    public static void main(String[] args) {
        final String CUSTOM_SERVER_ADDRESS = "localhost";
        final int CUSTOM_SERVER_PORT = 8081;

        try {
            // Connect to the server
            Socket customSocket = new Socket(CUSTOM_SERVER_ADDRESS, CUSTOM_SERVER_PORT);
            System.out.println("Connected to the custom server.");

            // Initialize input and output streams
            PrintWriter customOut = new PrintWriter(customSocket.getOutputStream(), true);
            BufferedReader customIn = new BufferedReader(new InputStreamReader(customSocket.getInputStream()));

            // Send a string to the server
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the string to reverse: ");
            String customMessage = scanner.nextLine();
            customOut.println(customMessage);
            System.out.println("Message sent to the custom server: " + customMessage);

            // Read the server's response
            String reversedCustomMessage = customIn.readLine();
            System.out.println("Reversed message received from the custom server: " + reversedCustomMessage);

            // Close streams and the connection
            customOut.close();
            customIn.close();
            customSocket.close();
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
