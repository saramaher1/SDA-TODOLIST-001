package sda;

import java.util.Date;

/**
 * The type Task.
 */
public class Task {

    private String TaskTitle;
    private Date DueDate;
    private Boolean Status;
    private String ProjectName;


    /**
     * Gets status.
     *
     * @return the status
     */
    public Boolean getStatus() {
        return Status;
    }

    /**
     * Gets due date.
     *
     * @return the due date
     */
    public Date getDueDate() {
        return DueDate;
    }

    /**
     * Gets task title.
     *
     * @return the task title
     */
    public String getTaskTitle() {
        return TaskTitle;
    }

    /**
     * Gets project name.
     *
     * @return the project name
     */
    public String getProjectName() {
        return ProjectName;
    }

    /**
     * Sets task title.
     *
     * @param taskTitle the task title
     */
    public void setTaskTitle(String taskTitle) {
        TaskTitle = taskTitle;
    }


    /**
     * Sets due date.
     *
     * @param dueDate the due date
     */
    public void setDueDate(Date dueDate) {
        DueDate = dueDate;
    }


    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Boolean status) {
        Status = status;
    }

    /**
     * Sets project name.
     *
     * @param projectName the project name
     */
    public void setProjectName(String projectName) {
        ProjectName = projectName;
    }


    /**
     * Instantiates a new Task.
     *
     * @param taskTitle   the task title
     * @param dueDate     the due date
     * @param projectName the project name
     */
    public Task(String taskTitle, Date dueDate, String projectName) {
        TaskTitle = taskTitle;
        DueDate = dueDate;
        ProjectName = projectName;
    }



    public Task(String taskTitle, Date dueDate, Boolean status, String projectName) {
        TaskTitle = taskTitle;
        DueDate = dueDate;
        ProjectName = projectName;
        this.Status=status;
    }

    /**
     * Instantiates a new Task.
     *
     * @param status the status
     */
    public Task(Boolean status) {
        Status = status;
    }

    /**
     * Instantiates a new Task.
     */
    public Task() {

    }
}


