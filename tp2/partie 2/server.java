package PARTIE2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class CustomCarServer {
    public static void main(String args[]) {
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
            Socket customSocket = customServerSocket.accept();
            
            ObjectOutputStream customOutput = new ObjectOutputStream(customSocket.getOutputStream());
            ObjectInputStream customInput = new ObjectInputStream(customSocket.getInputStream());

            CustomCar clientCar = (CustomCar) customInput.readObject();

            System.out.print("Enter fuel quantity: ");
            int quantity = keyboard.nextInt();
            clientCar.setFuel(quantity);

            customOutput.writeObject(clientCar);
        } catch (Exception e) {
            System.err.println("Error: " + e);
        } finally {
            keyboard.close();
        }
    }
}
