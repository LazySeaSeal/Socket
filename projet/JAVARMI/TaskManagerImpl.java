import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class TaskManagerImpl extends UnicastRemoteObject implements TaskManager {
    private List<String> tasks;

    protected TaskManagerImpl() throws RemoteException {
        super();
        tasks = new ArrayList<>();
    }

    public void addTask(String task) throws RemoteException {
        tasks.add(task);
    }

    public void removeTask(String task) throws RemoteException {
        tasks.remove(task);
    }

    public List<String> getAllTasks() throws RemoteException {
        return tasks;
    }
}
