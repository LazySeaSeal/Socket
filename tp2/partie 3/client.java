package PARTIE3;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CustomSocketClient {
    public static void main(String argv[]) {
        int customPort = 0;
        String customHost = "";
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Server name: ");
        customHost = keyboard.next();
        System.out.print("Server port: ");

        try {
            customPort = keyboard.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("The second parameter is not an integer.");
            System.exit(-1);
        }

        try {
            InetAddress address = InetAddress.getByName(customHost);
            Socket customSocket = new Socket(address, customPort);

            ObjectOutputStream customOutput = new ObjectOutputStream(customSocket.getOutputStream());
            ObjectInputStream customInput = new ObjectInputStream(customSocket.getInputStream());

            System.out.print("Enter the person's age: ");
            int age = keyboard.nextInt();
            keyboard.nextLine();
            System.out.print("Enter the person's name: ");
            String name = keyboard.nextLine();
            
            CustomPerson person = new CustomPerson(age, name, 0);
            customOutput.writeObject(person);
            customOutput.flush();

            int clientId = customInput.readInt();
            System.out.println("Client ID: " + clientId);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
