//Authorship: Ben Ashkenazi

package application;

import java.time.LocalDate;

public class Task {
    private String project;
    private String category;
    private String priority;
    private String taskName;
    private String description;
    private LocalDate finishDate;

    public Task(String project, String category, String priority, String taskName, String description, LocalDate finishDate) {
        this.project = project;
        this.category = category;
        this.priority = priority;
        this.taskName = taskName;
        this.description = description;
        this.finishDate = finishDate;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
    }

    @Override
    public String toString() {
        return "Task :" +
                "Project: " + project +
                ", Category: " + category +
                ", Priority: " + priority +
                ", Task Name: " + taskName +
                ", Description: " + description +
                ", Finish Date: " + finishDate;
    }
}
