package sda;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The type Task store.
 */
public class TaskStore {
    /**
     * The Task list.
     */
    protected ArrayList<sda.Task> taskList = new ArrayList<>();

    public TaskStore(ArrayList<sda.Task> taskList) {
        this.taskList = taskList;
    }

    /**
     * Add task.
     *
     * @param taskTitle   the task title
     * @param DueDate     the due date
     * @param projectname the projectname
     */
    public void addTask(String taskTitle, Date DueDate, String projectname) {
        sda.Task T = new sda.Task(taskTitle, DueDate, projectname);
        taskList.add(T);
    }

    public int getTaskListSize() {
        return taskList.size();
    }

    /**
     * Remove selected task.
     *
     * @param removedTask the removed task// This method removed the selected task from the Menu:
     */

    public void removeSelectedTask(int removedTask) {
        taskList.remove(removedTask - 1);
    }

    /**
     * Mark as done.
     *
     * @param MarkedTask this method set the status = true , it means the task is done !!
     */

    public void MarkAsDone(int MarkedTask) throws NullPointerException {
        taskList.get(MarkedTask).setStatus(true);
        System.out.println("  Your task have been mareked as done Successfully ...");

    }

    /**
     * Show task list.
     * <p>
     * this method help us to get our task by show item date or project!!
     */


    public void getingTaskList(String showItem) {

        if (showItem.equals("Date")) {

            //here to show the Tasklist by date

            /**
             *
             //here to show the Tasklist by date
             */

            if (!taskList.isEmpty()) {

                for (int i = 0; i < taskList.size(); i++)
                    System.out.println("(" + (i + 1) + ")" + taskList.get(i).getTaskTitle() + "    " + taskList.get(i).getDueDate() + "\n");
            } else {
                System.out.println(" There is No Tasks For Date:( ");
                System.out.println();
            }


            /**
             *
             //here to show the Tasklist by project
             */
        } else if (showItem.equals("project")) {


            if (!taskList.isEmpty()) {
                String projectname;
                Scanner inProject = new Scanner(System.in);
                System.out.println("<<  Select project for Your Task you want to show :  >>");
                System.out.println();
                System.out.println("(1).. Entertainment  ");
                System.out.println("(2).. Learning  ");
                System.out.println("(3)..Work  ");
                int projectCheck = inProject.nextInt();
                switch (projectCheck) {
                    case 1:
                        projectname = "Entertainment";
                        System.out.println("The Tasks for Entertainment Project : ");
                        for (int i = 0; i < taskList.size(); i++) {
                            if (projectname == "Entertainment") {


                                System.out.println("(" + (i + 1) + ")" + taskList.get(i).getTaskTitle() + "\n");
                            } else {
                                System.out.println("There is no tasks for Entertanment project");

                            }
                        }
                        break;
                    case 2:
                        projectname = "Learning";
                        System.out.println("The Tasks for Learning Project : ");
                        for (int i = 0; i < taskList.size(); i++) {
                            if (projectname == "Learning") {


                                System.out.println("(" + (i + 1) + ")" + taskList.get(i).getTaskTitle() + "\n");
                            } else {
                                System.out.println("There is no tasks for Learning project");

                            }
                        }
                        break;
                    case 3:
                        projectname = "Work";
                        System.out.println("The Tasks for Work Project : ");

                        for (int i = 0; i < taskList.size(); i++) {
                            if (projectname == "Work") {

                                System.out.println("The Tasks for Work Project : ");
                                System.out.println("(" + (i + 1) + ")" + taskList.get(i).getTaskTitle() + "\n");
                            } else {
                                System.out.println("There is no tasks for Work project");

                            }
                            break;
                        }


                }


            }

        }
    }

    /**
     * //this is to show the tasks after choosing the project from the menu !
     */

    public void getTaskBySelectedProject(String projectName) {
        //System.out.println("The Tasks for the  " + projectName);
        for (int i = 0; i < taskList.size(); i++) {
            if (taskList.get(i).getProjectName() == projectName) {
                System.out.println("(" + (i + 1) + ")" + taskList.get(i).getTaskTitle() + "\n");
            } else {
                System.out.println("There is no tasks " + projectName);
            }
        }
    }

    public sda.Task getTaskbyId(int ID) {
        return taskList.get(ID);
    }
}



