import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final TaskManager taskManager = new TaskManager();
    static boolean validDate = false;
    public static void main(String[] args) {
        triggerTaskOperation();
        taskManager.displayTask();
        scanner.close();
    }


    private static void triggerTaskOperation() {
        boolean continueTrigger = true;
        while (continueTrigger) {
            System.out.println("Select an action");
            System.out.println("1. Add an task");
            System.out.println("2. Edit a task");
            System.out.println("3. Remove a task");
            System.out.println("4. Continue");
            System.out.print(": ");
            int action = Integer.parseInt(Main.scanner.nextLine());

            switch (action) {
                case 1:
                    addingTask();
                    break;
                case 2:
                    editTask();
                    break;
                case 3:
                    removeTask();
                    break;
                case 4:
                    continueTrigger = false;
                    break;
                default:
                    System.out.println("Invalid choice. Exiting...");
            }
        }
    }


    private static void addingTask() {
        System.out.println("Enter task details: ");
        System.out.print("Title: " );
        String title = Main.scanner.nextLine();
        System.out.print("Description: ");
        String description = Main.scanner.nextLine();

        String dueDate ;

        do {
            System.out.print("Date( DD-MM-YYYY ): ");
            dueDate = Main.scanner.nextLine();
            if(isValidDate(dueDate)) {
                validDate = true;
            } else {
                System.out.println("Invalid date, please repeat.");
            }
        } while (!validDate);

        int priority;
        do {
            System.out.println("Priority( 1 - High, 2 - Medium, 3 - Low): ");
            priority = Main.scanner.nextInt();
            Main.scanner.nextLine();
            if(priority < 1 || priority > 3) {
                System.out.println("Priority must be 1, 2 or 3 ");
            }
        } while (priority < 1 || priority > 3);



        Main.taskManager.addTask(new Task(title, description, dueDate, priority));
        Main.taskManager.displayTask();
    }
    private static void editTask() {
        System.out.println("Enter the title of the task you want to edit");
        String editTitle = Main.scanner.nextLine();

        if(!Main.taskManager.taskExist(editTitle)) {
            System.out.println("Task with title " + editTitle + " not found");
            Main.taskManager.displayTask();
            return;
        }

        System.out.println("Enter update task details: ");
        System.out.println("New Title: ");
        String newTitle = Main.scanner.nextLine();

        System.out.println("New Description: ");
        String newDescription = Main.scanner.nextLine();

        String newDate;

        do {
            System.out.print("Date( DD-MM-YYYY ): ");
            newDate = Main.scanner.nextLine();
            if(isValidDate(newDate)) {
                validDate = true;
            } else {
                System.out.println("Invalid date, please repeat.");
            }
        } while (!validDate);


        int newPriority ;
        do{
            System.out.println("New Priority( 1 - High, 2 - Medium, 3 - Low): ");
            newPriority = getIntInput();
            Main.scanner.nextLine();
            if(newPriority < 1 || newPriority > 3) {
                System.out.println("Priority must be 1, 2 or 3 ");
            }
        } while (newPriority < 1 || newPriority > 3);

        Task updateTask = new Task(newTitle, newDescription, newDate, newPriority);
        Main.taskManager.editByTask(editTitle, updateTask);
        Main.taskManager.displayTask();
    }
    private static void removeTask() {
        System.out.print("Enter the title of the task you want to remove: ");
        String removeTitle = Main.scanner.nextLine();
        Main.taskManager.removeTaskByTitle(removeTitle);
        Main.taskManager.displayTask();
    }
    private static boolean isValidDate(String date) {
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            dateFormat.setLenient(false);
            dateFormat.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
    private static int getIntInput () {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number. ");
            scanner.next();
        }
        return scanner.nextInt();
    }
}