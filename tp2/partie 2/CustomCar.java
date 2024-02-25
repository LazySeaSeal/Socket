package PARTIE2;
import java.io.*;

class CustomCar implements Serializable {
    private int fuelLevel;
    private String carModel;
    private String carType;
    private static int fuelCapacity = 300;

    CustomCar(String _carType, String _carModel) {
        carType = _carType;
        carModel = _carModel;
        fuelLevel = 0;
    }

    public void setFuel(int quantity) {
        int maxCapacity = fuelCapacity - fuelLevel;
        if (quantity < maxCapacity) {
            fuelLevel += quantity;
            System.out.println("Refueling completed without issues.");
        } else {
            fuelLevel = fuelCapacity;
            System.out.println((quantity - maxCapacity) + " liter(s) of fuel overflowed.");
        }
    }

    public int getFuel() {
        return fuelLevel;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }
}
