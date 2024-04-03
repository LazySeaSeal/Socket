import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            TaskManager taskManager = new TaskManagerImpl();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("TaskManager", taskManager);
            System.out.println("RMI Server is ready.");
        } catch (Exception e) {
            System.err.println("RMI Server exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
