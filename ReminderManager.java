import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

public class ReminderManager {
    private ArrayList<Reminder> reminders = new ArrayList<>();
    private final String FILE_NAME = "reminders.txt";

    public ReminderManager() {
        loadFromFile();
    }

    public void addReminder(String title, LocalDate date) {
        reminders.add(new Reminder(title, date));
        System.out.println("Reminder added!");
        saveToFile();
    }

    public void viewTodayReminders() {
        LocalDate today = LocalDate.now();
        boolean found = false;
        for (int i = 0; i < reminders.size(); i++) {
            Reminder r = reminders.get(i);
            if (r.getDate().equals(today)) {
                System.out.println((i + 1) + ". " + r);
                found = true;
            }
        }
        if (!found) System.out.println("No reminders for today.");
    }

    public void markReminderDone(int userIndex) {
        int index = userIndex - 1;
        if (index >= 0 && index < reminders.size()) {
            reminders.get(index).markDone();
            System.out.println("Reminder marked as done!");
            saveToFile();
        } else {
            System.out.println("Invalid index.");
        }
    }

    public void viewAllReminders() {
        for (int i = 0; i < reminders.size(); i++) {
            System.out.println((i + 1) + ". " + reminders.get(i));
        }
    }

    private void saveToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Reminder r : reminders) {
                writer.println(r.toFileString());
            }
        } catch (IOException e) {
            System.out.println("Error saving reminders: " + e.getMessage());
        }
    }

    private void loadFromFile() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                reminders.add(Reminder.fromFileString(line));
            }
        } catch (IOException e) {
            System.out.println("Error loading reminders: " + e.getMessage());
        }
    }
}

