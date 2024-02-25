package partie2;
import java.io.*;
import java.net.*;
import java.util.Scanner;

class CustomCarClient {
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

            CustomCar myCar = new CustomCar("electric", "Tesla Model X");
            customOutput.writeObject(myCar);

            CustomCar modifiedCar = (CustomCar) customInput.readObject();
            System.out.println("Fuel quantity set by the server: " + modifiedCar.getFuel());
        } catch (Exception e) {
            System.err.println("Error: " + e);
        }
    }
}
