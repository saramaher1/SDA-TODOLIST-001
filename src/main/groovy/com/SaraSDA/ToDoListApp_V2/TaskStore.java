package com.SaraSDA.ToDoListApp_V2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.*;


public class TaskStore
{


    private ArrayList<Task> taskList = new ArrayList<>();

    public void addTask(String taskTitle, String DueDate, String projectname)
    {
        Task T = new Task(taskTitle, DueDate, projectname);
        taskList.add(T);
    }

    public void removeTask() {
        //here we should Show the Task Then the user Select the task That He Want to Remove
        for (int i = 0; i < taskList.size(); i++)
            System.out.println("(" + (i + 1) + ")" + taskList.get(i).getTaskTitle() + "\n");
        Scanner inremove = new Scanner(System.in);
        int removedTask = inremove.nextInt();

        taskList.remove(removedTask);

        //System.out.println(TaskList);
    }

    public void MarkAsDone() {
        for (int i = 0; i < taskList.size(); i++)
            System.out.println("(" + (i + 1) + ")" + taskList.get(i).getDueDate() + "\n");
        Scanner inDone = new Scanner(System.in);
        int MarkedTask = inDone.nextInt();

        taskList.get(MarkedTask).setStatus(true);
        System.out.println("  Your task have been mareked as done Successfully ...");

        //System.out.println(TaskList);
    }


    //here we should Select the Task and Update The name or the DueDate.
    public void UpdateTask(String taskTitle, String DueDate, String projectname) {
        Task T = new Task(taskTitle, DueDate, projectname);
        taskList.add(T);

    }



    public void ShowTaskList(String showItem) {

        if (showItem.equals("Date")) {

//here to show the Tasklist by date
            if (!taskList.isEmpty()) {

                for (int i = 0; i < taskList.size(); i++)
                    System.out.println("(" + (i + 1) + ")" + taskList.get(i).getDueDate() + "\n");
            } else {
                System.out.println(" There is No Tasks For Date:( ");
                System.out.println();
            }


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
                        for (int i = 0; i < taskList.size(); i++) {
                            if (projectname == "Entertainment") {

                                //System.out.println("The Tasks for Entertainment Project : ");
                                System.out.println("(" + (i + 1) + ")" + taskList.get(i).getTaskTitle() + "\n");
                            } else {
                                System.out.println("There is no tasks for Entertanment project");

                            }
                        }
                        break;
                    case 2:
                        projectname = "Learning";
                        for (int i = 0; i < taskList.size(); i++) {
                            if (projectname == "Learning") {

                                System.out.println("The Tasks for Learning Project : ");
                                System.out.println("(" + (i + 1) + ")" + taskList.get(i).getTaskTitle() + "\n");
                            } else {
                                System.out.println("There is no tasks for Learning project");

                            }
                        }
                        break;
                    case 3:
                        projectname = "Work";
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



// saving the task details in data file

    private static void saveTasks(ArrayList<Task> tasks) throws IOException {
        new FileWriter("./resources/data.txt", false).close();
        for(Task temp: tasks){
            String taskToSave=temp.getTaskTitle() + "," +
                    temp.getDueDate() + "," +
                    temp.getStatus().toString()+ "," +
                    temp.getProjectName();
            Files.write(Paths.get("./resources/data.txt"), taskToSave.getBytes(), StandardOpenOption.APPEND);
        }

        System.exit(0);
    }
    private static ArrayList<Task> getTasks() throws FileNotFoundException {
        ArrayList<Task> loadedTasks=new ArrayList<>();
        File myFile = new File("./resources/data.txt");
        Scanner readFile = new Scanner(myFile);
        while (readFile.hasNext()) {
            String line[] = readFile.nextLine().split(",");
            String title = line[0];
            String dueDate = line[1];
            boolean status = Boolean.parseBoolean(line[2]);
            String project = line[3];
            loadedTasks.add(new Task(title,dueDate,status,project));
        }
        return loadedTasks;
    }
}