package app;

import java.util.List;
import java.util.Scanner;
import model.Priority;
import model.Task;
import service.TaskManager;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager();
        boolean running = true;

        while (running) {
            System.out.println("\n=== Task Manager ===");
            System.out.println("1. Add Task");
            System.out.println("2. View Tasks");
            System.out.println("3. Mark Task Done");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter task title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter task description: ");
                    String description = scanner.nextLine();

                    System.out.print("Enter priority (LOW, MEDIUM, HIGH): ");
                    String priorityInput = scanner.nextLine().toUpperCase();

                    try {
                        Priority priority = Priority.valueOf(priorityInput);
                        manager.addTask(title, description, priority);
                        System.out.println("Task added successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Invalid priority. Task not added.");
                    }
                    break;

                case 2:
                    List<Task> tasks = manager.viewTasks();

                    if (tasks.isEmpty()) {
                        System.out.println("No tasks available.");
                    } else {
                        System.out.println("\nTasks:");
                        for (Task task : tasks) {
                            System.out.println(task);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter task ID to mark as done: ");
                    int doneId = scanner.nextInt();
                    scanner.nextLine();

                    manager.markTaskDone(doneId);
                    System.out.println("Task updated if ID was found.");
                    break;

                case 4:
                    System.out.print("Enter task ID to delete: ");
                    int deleteId = scanner.nextInt();
                    scanner.nextLine();

                    manager.deleteTask(deleteId);
                    System.out.println("Task deleted if ID was found.");
                    break;

                case 5:
                    running = false;
                    System.out.println("Exiting Task Manager.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}