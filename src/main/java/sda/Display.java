package sda;

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
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The type sda.main.Display.
 */
public class Display {

    TaskStore taskStore ;

    /**
     * Instantiates a new Display.
     *
     * @param taskStore the task store
     */
    public Display(TaskStore taskStore){
        this.taskStore=taskStore;
    }

    /**
     * Start menu. here is the Start menu that Start when the programm is run at the :
     *     // the user can select what he want to do in his ToDolist!
     */

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
                ShowingTaskMenu();
                break;
            case 2:
                addingTaskMenu();
                break;
            case 3:
                EditingTaskMenu();
                break;
            case 4:
                if(FileHandler.trySaveTasks(taskStore.taskList))
                {
                    System.exit(0);
                }else{
                    System.exit(1);
                };
                break;
            default:
                System.out.println(" your choise is an unvalid option !! ");
                System.out.println(" ");
                backToStartMenu();
                break;
        }
    }


    /**
     * The Showtype.
     */
    String showtype = "Date";

    /**
     //this method is showing how can we show the Task
     // we can sort our Task by dueDate and The projectname.
     // the user can select which type he want to show his task
     */

    public void ShowingTaskMenu() {
        System.out.println("Select the Way Of showing the Task ");
        System.out.println("(1) Show Tasks By Date ");
        System.out.println("(2) Show Tasks By Project ");
        int EditmenuSelect;
        Scanner input = new Scanner(System.in);
        EditmenuSelect = input.nextInt();
        // the user should select which way he want to show his tasks:
        // 1: showing task by DueDate.
        // 2: showing tasks by Project
        switch (EditmenuSelect) {
            case 1:
                System.out.println("Here is Your Task Sorting by Due Date");
                showtype = "Date";
                taskStore.getingTaskList(showtype);
                break;
            case 2:
                System.out.println("Here is Your Task Sorting by project");
                showtype = "project";
                taskStore.getingTaskList(showtype);
                break;
        }
        // after finishinh its time to goback to start Menu:)
        backToStartMenu();
    }

    /**
     // this menu is showing after select (2) Option in the Start menu :
     // the user should inter TaskTitle and Duedate for task
     // Also the user should select the Projectname for his Task!
     */

    public void addingTaskMenu() {
        System.out.println("Here You can Enter Your Task!");
        System.out.println(" << Add title of your Task and Add Date >> ");
        System.out.println("Enter Task Title :");
        Scanner in = new Scanner(System.in);
        String TaskTitle = in.nextLine();
        System.out.println("<<  Enter DueDate for Your Task:  >>");
        System.out.println("<<  Please Enter Date with ( dd-mm-yyyy) format  >>");
        String DueDate = in.nextLine();

        /**
         // here is adding the project
         // the user should select the projectname By typing the number for the project so its added as
         // a project name for his task!
         */
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


        /**
         // Here is additional Println()
         // you can skip it.
         */
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
        //convert the String Date to DateType by using SimplyDateFormat
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");

        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd-MM-yyyy").parse(DueDate);
        } catch (ParseException e) {
            e.printStackTrace();

            System.out.println("Try To Type The Date With dd-mm-yyyy Format !!");

        }

        taskStore.addTask(TaskTitle, date1, projectname);
        // after Finishing the add method We should go back To the Startmenu!
        backToStartMenu();
    }

    /**
     * Back to start menu.
     */
// this method take you back to the Start menu !
    public void backToStartMenu() {
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

    /**
     // this menu is showing when the user select the (3) option in The Start menu So The user Can select what
     // to Edit the tasks select 1 to  update  ,2 to  Edit ,3 to Remove
     */

    public void EditingTaskMenu() {
        System.out.println("Here You Can Edit your Task:");
        System.out.println();
        System.out.println("What Do you want To Do ? ");
        System.out.println("Pick An Option :");
        System.out.println("(1) UpDate Task .");
        System.out.println("(2) Remove Task .");
        System.out.println("(3) Mark As Done.");
        int EditMenuSelect;
        Scanner input = new Scanner(System.in);
        EditMenuSelect = input.nextInt();
        switch (EditMenuSelect) {
            case 1:
                // updating your task:
                updatingTask();
                break;
            case 2:
                // removing task
                removeTaskMenu();
                break;
            case 3:
                // for makeyour task as done!
                MarkasDoneMenu();
                break;
        }
        backToStartMenu();
    }

    /**
     // in updaing Task the user should select the task
     // the method remove the task from the array list using the another method
     // removedselectedTas(String selectedTask)
     // and the user can add new task instead of the old task!
     */
    public void updatingTask() {

        System.out.println("Select task to update!");
        showingTaskToEdit();
        Scanner inupdate = new Scanner(System.in);
        int updatedTaskNumber = inupdate.nextInt();
        taskStore.removeSelectedTask(updatedTaskNumber);
        System.out.println("here you can edit your task!");
        addingTaskMenu();
    }

    /**
     // in this method you can see our Tasks in the program:
     */

    public void showingTaskToEdit() {
        for (int i = 0; i < taskStore.taskList.size(); i++)
            System.out.println("(" + (i + 1) + ")" + taskStore.taskList.get(i).getTaskTitle() + "\n");
    }


    /**
     // Menu for selecting task to delete the tasks
     // it shows the tasks and the user should select which task he want to remove
     */

    public void removeTaskMenu() {
        System.out.println("Here You Can remove your Task:");
        System.out.println("Select task number to remove it");
        showingTaskToEdit();
        Scanner inremove = new Scanner(System.in);
        int removedTask = inremove.nextInt();
        taskStore.removeSelectedTask(removedTask);
        // here is an addintional PrintLn
        System.out.println("Loading...20%");
        System.out.println("Loading...80%");
        System.out.println("Loading...100%");
        System.out.println();
        System.out.println("  Your Task Have been Removed Successfully ...");
    }

    /**
     * Markas done menu.
     */
    public void MarkasDoneMenu() {
        System.out.println("Select your Task To marked it as done ");
        showingTaskToEdit();
        Scanner inDone = new Scanner(System.in);
        int MarkedTask = inDone.nextInt();
        taskStore.MarkAsDone(MarkedTask);
        System.out.println("  Your task have been mareked as done Successfully ...");
    }

    /**
     * Save and quit menu.
     */
    public void SaveAndQuitMenu() {
        System.out.println("bye");
    }

    /**
     * Showing done tasks.
     */
    public void showingDoneTasks() {
        for (int i = 0; i < taskStore.taskList.size(); i++) {
            if (taskStore.taskList.get(i).getStatus() == true) {
                System.out.println("(" + (i + 1) + ")" + taskStore.taskList.get(i).getTaskTitle() + "Marked As Done" + "\n");

            } else {
                System.out.println("(" + (i + 1) + ")" + taskStore.taskList.get(i).getTaskTitle() + "Need To Do it !!" + "\n");
            }
        }
    }
}
