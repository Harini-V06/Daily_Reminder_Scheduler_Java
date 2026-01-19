import java.time.LocalDate;

public class Reminder {

    // Store reminder details
    private String title;       //Title
    private LocalDate date;     // Date
    private boolean isDone;     // Status: done or pending

    // Constructor for a new reminder (default)
    public Reminder(String title, LocalDate date) {
        this.title = title;
        this.date = date;
        this.isDone = false;
    }

    // Constructor for loading a reminder from file(parametrised)
    public Reminder(String title, LocalDate date, boolean isDone) {
        this.title = title;
        this.date = date;
        this.isDone = isDone;
    }

    // Getters becuase it is private 
    public String getTitle() { 
        return title; 
    }
    public LocalDate getDate() {
         return date; 
        }
    public boolean isDone() { 
        return isDone;
     }

    // Mark this reminder as done
    public void markDone() { isDone = true; }

    // String representation for displaying in console
    @Override
    public String toString() {
        return title + " | " + date + " | " + (isDone ? "DONE" : "PENDING");
    }

    // Convert reminder to a string format suitable for saving to file
    public String toFileString() {
        return title + "," + date + "," + isDone;
    }

    // Create a Reminder object from a string line from file
    public static Reminder fromFileString(String line) {
        String[] parts = line.split(",");            // Split by comma
        String title = parts[0];                     // First part: title
        LocalDate date = LocalDate.parse(parts[1]);  // Second part: date
        boolean isDone = Boolean.parseBoolean(parts[2]); // Third part: status
        return new Reminder(title, date, isDone);
    }
}
