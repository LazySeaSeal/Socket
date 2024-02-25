package PARTIE3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CustomSocketServer {
    private static int customClientIdCounter = 0;

    public static void main(String argv[]) {
        int customPort = 0;
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Listening port: ");
        try {
            customPort = keyboard.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("The parameter is not an integer.");
            System.exit(-1);
        }

        try {
            ServerSocket customServerSocket = new ServerSocket(customPort);
            System.out.println("Server started on port " + customPort);
            
            while (true) {
                Socket customSocket = customServerSocket.accept();
                System.out.println("New connection accepted.");
                
                ObjectOutputStream customOutput = new ObjectOutputStream(customSocket.getOutputStream());
                ObjectInputStream customInput = new ObjectInputStream(customSocket.getInputStream());
                
                CustomPerson person = (CustomPerson) customInput.readObject();
                int customClientId = generateCustomClientId();
                person.setCustomId(customClientId);
                
                customOutput.writeInt(customClientId);
                customOutput.flush();
                
                System.out.println("Message received from: " + customSocket.getInetAddress() + ":" + customSocket.getPort());
            }
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }

    private static synchronized int generateCustomClientId() {
        return ++customClientIdCounter;
    }
}
