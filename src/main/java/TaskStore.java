package com.SaraSDA.ToDoListApp_V2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;


/**
 * The type Task store.
 */
public class TaskStore {


    /**
     * The Task list.
     */
    protected ArrayList<Task> taskList = new ArrayList<>();

    /**
     * Add task.
     *
     * @param taskTitle   the task title
     * @param DueDate     the due date
     * @param projectname the projectname
     */
    public void addTask(String taskTitle, Date DueDate, String projectname) {
        Task T = new Task(taskTitle, DueDate, projectname);
        taskList.add(T);
    }

    public int getTaskListSize()
    {
        return taskList.size();
    }

    /**
     * Remove selected task.
     *
     * @param removedTask the removed task
     */
// This method removed the selected task from the Menu:
    public void removeSelectedTask(int removedTask) {
        taskList.remove(removedTask);
    }

    /**
     * Mark as done.
     *
     * @param MarkedTask the marked task
     */
    public void MarkAsDone(int MarkedTask) {
        taskList.get(MarkedTask).setStatus(true);
        System.out.println("  Your task have been mareked as done Successfully ...");

    }




    /**
     * Show task list.
     *
     * @param showItem the show item
     */
    // this
    public void getingTaskList(String showItem) {

        if (showItem.equals("Date")) {

            //showing the tasks by dueDate:

            if (!taskList.isEmpty()) {

                for (int i = 0; i < taskList.size(); i++)
                    System.out.println("(" + (i + 1) + ")" + taskList.get(i).getDueDate() + "\n");
            } else {
                System.out.println(" There is No Tasks For Date:( ");
                System.out.println();
            }
        // showing the tasks by project :
            // the user should select which project want to show the tasks.


        } else if (showItem.equals("project")) {

 // selecting the project :
            // 1- Entertainment
            // 2- learning
            // 3-Work
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
                    // showing the tasks for each project
                    case 1:
                        projectname = "Entertainment";
                        for (int i = 0; i < taskList.size(); i++) {
                            if (projectname == "Entertainment") {
                              getTaskBySelectedProject(projectname);
                            }
                        }
                        break;
                    case 2:
                        projectname = "Learning";
                        for (int i = 0; i < taskList.size(); i++) {
                            if (projectname == "Learning") {

                                getTaskBySelectedProject(projectname);
                            }
                        }
                        break;
                    case 3:
                        projectname = "Work";
                        for (int i = 0; i < taskList.size(); i++) {
                            if (projectname == "Work") {

                               getTaskBySelectedProject(projectname);

                            }
                            break;
                        }


                }

            }

        }}

        //this is to show the tasks after choosing the project from the menue !
 public void getTaskBySelectedProject(String projectName){
     System.out.println("The Tasks for the  "+projectName);
     for (int i = 0; i < taskList.size(); i++) {
        if (projectName != null ) {
             System.out.println("(" + (i + 1) + ")" + taskList.get(i).getTaskTitle() + "\n");
         } else {
             System.out.println("There is no tasks "+projectName);

         }

     }

        }



// saving the task details in data file

    private static void saveTasks(ArrayList<Task> tasks) throws IOException {
        new FileWriter("./resources/data.txt", false).close();
        for (Task temp : tasks) {
            String taskToSave = temp.getTaskTitle() + "," +
                    temp.getDueDate() + "," +
                    temp.getStatus().toString() + "," +
                    temp.getProjectName();
            Files.write(Paths.get("./resources/data.txt"), taskToSave.getBytes(), StandardOpenOption.APPEND);
        }

        System.exit(0);
    }


    public Task getTaskbyId(int ID){

        return taskList.get(ID);
    }
}