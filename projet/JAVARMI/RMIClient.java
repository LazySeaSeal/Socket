import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;

public class RMIClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            TaskManager taskManager = (TaskManager) registry.lookup("TaskManager");

            // Add a task
            taskManager.addTask("Complete Project");

            // Remove a task
            taskManager.removeTask("Prepare Presentation");

            // Get all tasks
            List<String> allTasks = taskManager.getAllTasks();
            System.out.println("All tasks:");
            for (String task : allTasks) {
                System.out.println(task);
            }
        } catch (Exception e) {
            System.err.println("RMI Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
