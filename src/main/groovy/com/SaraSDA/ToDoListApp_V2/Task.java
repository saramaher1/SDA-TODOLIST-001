package com.SaraSDA.ToDoListApp_V2;

import java.util.Date;

public class Task {

    private String TaskTitle;
    private String DueDate;
    private Boolean Status;
    private String ProjectName;


    public Boolean getStatus() {
        return Status;
    }
    public String getDueDate() {
        return DueDate;
    }
    public String getTaskTitle() {
        return TaskTitle;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public void setTaskTitle(String taskTitle) {
        TaskTitle = taskTitle;
    }


    public void setDueDate(String dueDate) {
        DueDate = dueDate;
    }


    public void setStatus(Boolean status) {
        Status = status;
    }

    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }


    public Task(String taskTitle, String dueDate, String projectName) {
        TaskTitle = taskTitle;
        DueDate = dueDate;
        ProjectName = projectName;
    }
    public Task(String taskTitle, String dueDate,Boolean status, String projectName) {
        TaskTitle = taskTitle;
        DueDate = dueDate;
        ProjectName = projectName;
        this.Status=status;
    }
    public Task(Boolean status) {
        Status = status;
    }
    public Task() {

    }
}


