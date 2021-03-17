package sda;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * The type Main.
 */
public class main {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        try {
            Display d = new Display();
            ArrayList<Task> taskList = d.getTasks();

            //Making list for adding tasks in it.
            System.out.println("       Welcome to your ToDoList :      ");
            System.out.println();
            // here we shoulde write how many task we have and how many task we'v done;
            d.StartMenu();
        }
        catch(Exception ex){
            System.out.println("Oops! Something went wrong, please close the console and runt it again!");
        }
    }




    /**
     * Read from file boolean.
     *
     * @param filename the filename
     * @return the boolean
     */
    public boolean readFromFile(String filename) {
        ArrayList<Task> taskList;
        boolean status = false;

        try {
            if (!Files.isReadable(Paths.get(filename))) {
                //  Messages.showMessage("The data file, i.e., " + filename + " does not exists", true);
                return false;
            }

            FileInputStream fileInputStream = new FileInputStream(filename);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            taskList = (ArrayList<Task>) objectInputStream.readObject();

            objectInputStream.close();
            fileInputStream.close();
            return true;

        } catch (Exception e) {
            //Messages.showMessage(e.getMessage(),true);
            return false;
        }
    }

    // saving my Tasks into file:

    /**
     * Save to file boolean.
     *
     * @param filename the filename
     * @return the boolean
     */
    public boolean saveToFile(String filename) {
        ArrayList<Task> taskList = new ArrayList<>();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filename);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(taskList);

            objectOutputStream.close();
            fileOutputStream.close();
            return true;

        } catch (Exception e) {
            //   Messages.showMessage(e.getMessage(),true);
            return false;

//test
            //test

        }
    }

}
