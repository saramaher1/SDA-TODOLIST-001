package com.SaraSDA.ToDoListApp_V2;

import com.sun.source.util.TaskListener;

import java.util.Date;

import java.util.Scanner;

public class Display {


    TaskStore tO = new TaskStore();

    public void StartMenu() {


        System.out.println("Pick an option:");
        System.out.println("(1) Show Task List (by date or project)");
        System.out.println("(2) Add New Task");
        System.out.println("(3) Edit Task (update, mark as done, remove)");
        System.out.println("(4) Save and Quit\n");
        System.out.print("Please enter your choice [1-4]: ");
        System.out.println();
        System.out.println("What Do you want to do ?");
        Scanner in = new Scanner(System.in);
        int menuSelect;
        menuSelect = in.nextInt();

        switch (menuSelect) {
            case 1:
                ShowTaskMenu();
                break;
            case 2:
                addingTaskMenu();
                break;
            case 3:
                EditingTaskMenu();
                break;
            case 4:
                // here we should save our list in file
                break;
            default:System.out.println(" your choise is an unvalid option !! ");
                System.out.println(" ");
                goToStartMenu();
                break;
        }
    }

    String showtype = "Date";

    public void ShowTaskMenu() {


        System.out.println("Select the Way Of showing the Task ");
        System.out.println("(1) Show Tasks By Date ");
        System.out.println("(2) Show Tasks By Project ");
        int EditmenuSelect;
        Scanner input = new Scanner(System.in);
        EditmenuSelect = input.nextInt();


        switch (EditmenuSelect) {
            case 1:
                System.out.println("Here is Your Task Sorting by Due Date");
                showtype = "Date";
                tO.ShowTaskList(showtype);
                break;
            case 2:
                System.out.println("Here is Your Task Sorting by project");

                showtype = "project";
                tO.ShowTaskList(showtype);


                break;

        }

        goToStartMenu();

    }


    public void addingTaskMenu() {
        System.out.println("Here You can Enter Your Task!");

        System.out.println(" << Add title of your Task and Add Date >> ");
        System.out.println("Enter Task Title :");
        Scanner in = new Scanner(System.in);

        String TaskTitle = in.nextLine();
        System.out.println("<<  Enter DueDate for Your Task:  >>");
        String DueDate = in.nextLine();
        // here is adding the project

        Scanner inProject = new Scanner(System.in);
        String projectname = "project";
        System.out.println("<<  Select project for Your Task:  >>");
        System.out.println();
        System.out.println("(1).. Entertainment  ");
        System.out.println("(2).. Learning  ");
        System.out.println("(3)..Work  ");
        int projectCheck = inProject.nextInt();
        switch (projectCheck) {
            case 1:
                projectname = "Entertainment";
                break;
            case 2:
                projectname = "Learning";
                break;
            case 3:
                projectname = "Work";
                break;
        }


        // Here is additional Println()
        System.out.println("Loading...20%");
        System.out.println("Loading...80%");
        System.out.println("Loading...100%");
        System.out.println();
        System.out.println("  Your Task Have been Added Successfully ...");
        System.out.println();
        System.out.println("Your TaskTitle is : " + TaskTitle);
        System.out.println("Your DueDate is : " + DueDate);
        System.out.println("Your projectname is : " + projectname);

        // Here We Can add the Typed Title and Date to the TaskList in TaskStore
        tO.addTask(TaskTitle, DueDate, projectname);

        goToStartMenu();
    }

    public void goToStartMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("  <<  Back to Start Menu  >>");
        System.out.println("Press * to go to The Start Menu");
        String menuback;

        menuback = in.nextLine();
        switch (menuback) {
            case "*":
                StartMenu();
                break;
            case "#":
                // here it should to Exit from the app.
                break;
        }
    }



    public void EditingTaskMenu() {

        System.out.println("Here You Can Edit your Task:");
        System.out.println();
        System.out.println("What Do you want To Do ? ");
        System.out.println("Pick An Option :");
        System.out.println("(1) UpDate Task .");
        System.out.println("(2) Remove Task .");
        System.out.println("(3) Mark As Done.");


        int EditmenuSelect;
        Scanner input = new Scanner(System.in);
        EditmenuSelect = input.nextInt();

        switch (EditmenuSelect) {
            case 1:
                break;
            case 2:
                //here for removing task
                RemoveTaskMenu();

                break;
            case 3:

                MarkasDoneMenu();
                break;
            case 4:
                // here we should save our list in file
                break;


        }
        goToStartMenu();

    }


    public void RemoveTaskMenu() {
        System.out.println("Here You Can remove your Task:");
        System.out.println("Select task number to remove it");
        tO.removeTask();
        System.out.println("Loading...20%");
        System.out.println("Loading...80%");
        System.out.println("Loading...100%");
        System.out.println();
        System.out.println("  Your Task Have been Removed Successfully ...");
    }

    public void MarkasDoneMenu() {
        System.out.println("Select your Task To marked it as done ");
        tO.MarkAsDone();
        System.out.println("  Your task have been mareked as done Successfully ...");
    }
}