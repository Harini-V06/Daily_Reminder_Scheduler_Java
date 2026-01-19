import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        ReminderManager manager = new ReminderManager(); // Create manager to handle reminders

        // Use try-with-resources to automatically close Scanner 
        try (Scanner sc = new Scanner(System.in)) {
            while (true) {

                // Console Menu 
                System.out.println("\n Reminder Scheduler");
                System.out.println("1. Add Reminder");
                System.out.println("2. View Today's Reminders");
                System.out.println("3. View All Reminders");
                System.out.println("4. Mark Reminder as Done");
                System.out.println("5. Exit");

                System.out.print("Choose: ");

                // Get user choice safely
                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine()); // Read line and parse to int
                } catch (Exception e) {
                    System.out.println("Invalid input. Enter a number 1-5.");
                    continue; // Try again
                }

                switch (choice) {
                    case 1: // Add Reminder
                        System.out.print("Enter reminder title: ");
                        String title = sc.nextLine();

                        System.out.print("Enter date (YYYY-MM-DD): ");
                        try {
                            LocalDate date = LocalDate.parse(sc.nextLine()); // Parse date string
                            manager.addReminder(title, date);               // Add reminder
                        } catch (Exception e) {
                            System.out.println("Invalid date format!");
                        }
                        break;

                    case 2: // View today's reminders
                        manager.viewTodayReminders();
                        break;

                    case 3: // View all reminders
                        manager.viewAllReminders();
                        break;

                    case 4: // Mark reminder done
                        manager.viewAllReminders();                     // Show list
                        System.out.print("Enter reminder index: ");
                        try {
                            int index = Integer.parseInt(sc.nextLine()); 
                            manager.markReminderDone(index);            // Mark done
                        } catch (Exception e) {
                            System.out.println("Invalid index!");
                        }
                        break;

                    case 5: // Exit program
                        System.out.println("Exiting...");
                        return;

                    default: // Invalid menu choice
                        System.out.println("Invalid choice");
                }
            }
        }
    }
}
