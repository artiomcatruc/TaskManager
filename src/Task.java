import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Task {
    private String title;
    private String description;
    private LocalDate dueDate;
    private int priority;

    public Task(String title, String description, String dueDate, int priority)  {
        this.title = title;
        this.description = description;
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            this.dueDate = LocalDate.parse(dueDate, dateFormatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid due date format. Please use DD-MM-YYYY.");
        }
        this.priority = priority;

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        try {
            this.dueDate = LocalDate.parse(dueDate, dateFormatter);
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid due date format. Please use DD-MM-YYYY.");
        }
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
