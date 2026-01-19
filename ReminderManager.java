import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

public class ReminderManager {

    private ArrayList<Reminder> reminders = new ArrayList<>(); // Stores all reminders
    private final String FILE_NAME = "reminders.txt";           // File for persistence

    // Constructor loads reminders from file when program starts
    public ReminderManager() {
        loadFromFile();
    }

    // Add a new reminder and save to file
    public void addReminder(String title, LocalDate date) {
        reminders.add(new Reminder(title, date)); // Add to list
        System.out.println("Reminder added!");
        saveToFile();                             // Save changes
    }

    // View reminders scheduled for today
    public void viewTodayReminders() {
        LocalDate today = LocalDate.now();
        boolean found = false;
        for (int i = 0; i < reminders.size(); i++) {
            Reminder r = reminders.get(i);
            if (r.getDate().equals(today)) {
                System.out.println((i + 1) + ". " + r); // Display with 1-based index
                found = true;
            }
        }
        if (!found) System.out.println("No reminders for today.");
    }

    // Mark a reminder as done using  index from user
    public void markReminderDone(int userIndex) {
        int index = userIndex - 1; // Convert to 0-based index for ArrayList
        if (index >= 0 && index < reminders.size()) {
            reminders.get(index).markDone();
            System.out.println("Reminder marked as done!");
            saveToFile(); // Save changes
        } else {
            System.out.println("Invalid index.");
        }
    }

    // View all reminders
    public void viewAllReminders() {
        for (int i = 0; i < reminders.size(); i++) {
            System.out.println((i + 1) + ". " + reminders.get(i)); // 1-based index
        }
    }

    //  File Handling 

    // Save all reminders to file
    //text to file 
    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Reminder r : reminders) {
                writer.println(r.toFileString()); // Each reminder on a new line
            }
        } catch (IOException e) {
            System.out.println("Error saving reminders: " + e.getMessage());
        }
    }

    // Load reminders from file into memory
    //file to text
    // Reads this "Submit Assignment,2026-01-19,false" and breaks into smaller parts like title,date etc so program can read
    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return; // No file yet, nothing to load

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reminders.add(Reminder.fromFileString(line)); // Convert line to Reminder
            }
        } catch (IOException e) {
            System.out.println("Error loading reminders: " + e.getMessage());
        }
    }
}
