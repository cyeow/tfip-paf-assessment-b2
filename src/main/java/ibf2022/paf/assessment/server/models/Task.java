package ibf2022.paf.assessment.server.models;

import java.time.LocalDate;

// TODO: Task 4

public class Task {

    private Integer taskId;
    private String description;
    private Integer priority;
    private LocalDate dueDate;

    public Task() {
    }

    public Task(String description, Integer priority, LocalDate dueDate) {
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public Task(Integer taskId, String description, Integer priority, LocalDate dueDate) {
        this.taskId = taskId;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
    }

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", description=" + description + ", priority=" + priority + ", dueDate="
                + dueDate + "]";
    }

}
