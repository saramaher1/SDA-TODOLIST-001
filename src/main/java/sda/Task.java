package sda;

import java.util.Date;

/**
 * The type Task.
 */
public class Task {

    private String taskTitle;
    private Date dueDate;
    private Boolean status;
    private String projectName;


    /**
     * Gets status.
     *
     * @return the status
     */
    public Boolean getStatus() {
        return status;
    }

    /**
     * Gets due date.
     *
     * @return the due date
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * Gets task title.
     *
     * @return the task title
     */
    public String getTaskTitle() {
        return taskTitle;
    }

    /**
     * Gets project name.
     *
     * @return the project name
     */
    public String getProjectName() {
        return projectName;
    }

    /**
     * Sets task title.
     *
     * @param taskTitle the task title
     */
    public void setTaskTitle(String taskTitle) {
        this.taskTitle = taskTitle;
    }


    /**
     * Sets due date.
     *
     * @param dueDate the due date
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }


    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Boolean status) {
        this.status = status;
    }

    /**
     * Sets project name.
     *
     * @param projectName the project name
     */
    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }


    /**
     * Instantiates a new Task.
     *
     * @param taskTitle   the task title
     * @param dueDate     the due date
     * @param projectName the project name
     */
    public Task(String taskTitle, Date dueDate, String projectName) {
        this.taskTitle = taskTitle;
        this.dueDate = dueDate;
        this.projectName = projectName;
        status =false;
    }



    public Task(String taskTitle, Date dueDate, Boolean status, String projectName) {
        this.taskTitle = taskTitle;
        this.dueDate = dueDate;
        this.projectName = projectName;
        this.status =status;
    }

    /**
     * Instantiates a new Task.
     *
     * @param status the status
     */
    public Task(Boolean status) {
        this.status = status;
    }

    /**
     * Instantiates a new Task.
     */
    public Task() {

    }
}


