package model;

public class Task {
    private int id;
    private String title;
    private String description;
    private Status status; 
    private Priority priority;
    //title, description, id, status, priority
    public Task(int id, String title, String description, Priority priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status.TODO;
        this.priority = priority;
    }
    public int getId() {
        return id;
    }
    public Status getStatus() {
        return status;
    }
    public Priority getPriority() {
        return priority;
    }
    public void markDone() {
        this.status = Status.DONE;
    }
    public String getTitle() {
        return title;
    }
    @Override
    public String toString() {
        return "Task ID: " + id +
               " | Title: " + title +
               " | Status: " + status +
               " | Priority: " + priority;
    }
}
