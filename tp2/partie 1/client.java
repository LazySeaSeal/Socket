package partie1;
import java.io.*;
import java.net.*;
import java.util.Scanner;

class CustomSocketClient {
    public static void main(String args[]) {
        int customPort = 0;
        String customHost = "";
        Scanner keyboard = new Scanner(System.in);

        // Server name + port
        System.out.print("Enter the server name: ");
        customHost = keyboard.next();
        System.out.print("Enter the server port: ");
        
        try {
            customPort = keyboard.nextInt();
        } catch (NumberFormatException e) {
            System.err.println("The second parameter is not an integer.");
            System.exit(-1);
        }

        // Connect to the server
        try {
            // Request the server address
            InetAddress address = InetAddress.getByName(customHost);

            // Create the client socket
            Socket customSocket = new Socket(address, customPor
