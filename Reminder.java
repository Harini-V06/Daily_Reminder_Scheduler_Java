import java.time.LocalDate;

public class Reminder {
    private String title;
    private LocalDate date;
    private boolean isDone;

    public Reminder(String title, LocalDate date) {
        this.title = title;
        this.date = date;
        this.isDone = false;
    }

    public Reminder(String title, LocalDate date, boolean isDone) {
        this.title = title;
        this.date = date;
        this.isDone = isDone;
    }

    public String getTitle() { return title; }
    public LocalDate getDate() { return date; }
    public boolean isDone() { return isDone; }
    public void markDone() { isDone = true; }

    @Override
    public String toString() {
        return title + " | " + date + " | " + (isDone ? "DONE" : "PENDING");
    }

    // --- Methods for file handling ---
    public String toFileString() {
        return title + "," + date + "," + isDone;
    }

    public static Reminder fromFileString(String line) {
        String[] parts = line.split(",");
        String title = parts[0];
        LocalDate date = LocalDate.parse(parts[1]);
        boolean isDone = Boolean.parseBoolean(parts[2]);
        return new Reminder(title, date, isDone);
    }
}
