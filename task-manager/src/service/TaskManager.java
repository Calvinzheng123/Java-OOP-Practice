package service;

import java.util.ArrayList;
import java.util.List;

import model.Task;
import model.Priority;

public class TaskManager {
    private List<Task> tasks;
    private int nextId;
    
    public TaskManager() {
        this.tasks = new ArrayList<>();
        this.nextId = 1;
    }
    //methods to add
    //add task, view task, delete task, mark task as done
    public void addTask(String title, String description, Priority priority) {
        Task newTask = new Task(nextId, title, description, priority);
        tasks.add(newTask);
        nextId++;
    }
    public List<Task> viewTasks() {
        return tasks;
    }
    public void deleteTask(int id) {
        tasks.removeIf(task -> task.getId() == id);
    }
    public void markTaskDone(int id) {
        for (Task task : tasks) {
            if (task.getId() == id) {
                task.markDone();
            }
        }
    }
}
