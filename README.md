# Daily Reminder Scheduler 
 
A Java console application to create, manage, and persist daily reminders — built to practice OOP, file I/O, and clean class design.
 
---
 
## What it does
 
- Add reminders with a date and description
- View today's reminders at a glance
- Browse all reminders
- Mark reminders as done
- Reminders persist to `reminders.txt` — they survive between runs
---
 
## How to run
 
**Requirements:** Java 17+ (tested on Java 21 LTS)
 
```bash
# Clone
git clone https://github.com/Harini-V06/Daily_Reminder_Scheduler_Java.git
cd Daily_Reminder_Scheduler_Java
 
# Compile
javac *.java
 
# Run
java Main
```
 
You'll see a console menu:
 
```
1. Add reminder
2. View today's reminders
3. View all reminders
4. Mark reminder as done
5. Exit
```
 
---
 
## Project structure
 
```
Daily_Reminder_Scheduler_Java/
├── Main.java             # Entry point and menu loop
├── Reminder.java         # Reminder model (date, text, status)
├── ReminderManager.java  # CRUD logic + file persistence
├── reminders.txt         # Auto-created on first run
└── README.md
```
 
---
 
## Concepts practised
 
- Object-oriented design: model / manager / main separation
- File I/O for persistence without a database
- Input validation and error handling
- Java `LocalDate` for date parsing and filtering
