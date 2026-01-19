import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ReminderManager manager = new ReminderManager();

        try (Scanner sc = new Scanner(System.in)) {  // FIX: Scanner auto-closed
            while (true) {
                System.out.println("\n--- Reminder Scheduler ---");
                System.out.println("1. Add Reminder");
                System.out.println("2. View Today's Reminders");
                System.out.println("3. View All Reminders");
                System.out.println("4. Mark Reminder as Done");
                System.out.println("5. Exit");

                System.out.print("Choose: ");
                int choice;
                try {
                    choice = Integer.parseInt(sc.nextLine()); // safer input
                } catch (Exception e) {
                    System.out.println("Invalid input. Enter a number 1-5.");
                    continue;
                }

                switch (choice) {
                    case 1:
                        System.out.print("Enter reminder title: ");
                        String title = sc.nextLine();
                        System.out.print("Enter date (YYYY-MM-DD): ");
                        try {
                            LocalDate date = LocalDate.parse(sc.nextLine());
                            manager.addReminder(title, date);
                        } catch (Exception e) {
                            System.out.println("Invalid date format!");
                        }
                        break;

                    case 2:
                        manager.viewTodayReminders();
                        break;

                    case 3:
                        manager.viewAllReminders();
                        break;

                    case 4:
                        manager.viewAllReminders();
                        System.out.print("Enter reminder index: ");
                        try {
                            int index = Integer.parseInt(sc.nextLine());
                            manager.markReminderDone(index);
                        } catch (Exception e) {
                            System.out.println("Invalid index!");
                        }
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        return;

                    default:
                        System.out.println("Invalid choice");
                }
            }
        }
    }
}
