import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private final List<Task> tasks;
    //Constructor
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    //Method to add a task
    public void addTask(Task task) {
        tasks.add(task);
    }
    // Method to remove a task by its index
    public void removeTask(int index) {
        if(index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            System.out.println("Task removed successful.");
        } else {
            System.out.println("Invalid task index.");
        }
    }
    // Method to remove task by its title
    public void removeTaskByTitle(String title) {
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getTitle().equalsIgnoreCase(title)){
                tasks.remove(i);
                System.out.println("Task removed successful.");
                return;
            }
        }
        System.out.println("Task with title " + title + " not found.");
    }
    // Method to editing a task by its title
    public void editByTask(String title, Task updateTask) {
        for(int i = 0; i < tasks.size(); i++) {
            if(tasks.get(i).getTitle().equalsIgnoreCase(title)) {
                tasks.set(i, updateTask);
                System.out.println("Task edit successful");
                return;
            }
        }
        System.out.println("Task with title " + title + " not found");
    }
    // Method to display task
    public void displayTask() {
        for(Task task: tasks) {
            System.out.println(task.getTitle());
            System.out.println(task.getDueDate());
        }
    }

    public boolean taskExist(String title) {
        for(Task task : tasks) {
            if(task.getTitle().equalsIgnoreCase(title)) {
                return true ;
            }
        }
        return false;
    }
}
