package ibf2022.paf.assessment.server.models;

import java.sql.Date;

// TODO: Task 4

public class Task {

    private int taskId;
    private String userId;
    private String desctiption;
    private int priority;
    private Date dueDate;
    public int getTaskId() {
        return taskId;
    }
    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }
    public String getDesctiption() {
        return desctiption;
    }
    public void setDesctiption(String desctiption) {
        this.desctiption = desctiption;
    }
    public int getPriority() {
        return priority;
    }
    public void setPriority(int priority) {
        this.priority = priority;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    @Override
    public String toString() {
        return "Task [taskId=" + taskId + ", userId=" + userId + ", desctiption=" + desctiption + ", priority="
                + priority + ", dueDate=" + dueDate + "]";
    }
}
