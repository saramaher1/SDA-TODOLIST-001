package sda;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * The type File handler.
 */
public  class FileHandler {

    /**
     * Gets tasks.
     *
     * @return the tasks
     * @throws FileNotFoundException the file not found exception
     */
    public static ArrayList<Task> getTasks() throws FileNotFoundException {
        ArrayList<Task> loadedTasks = new ArrayList<>();
        File myFile = new File("./resources/data.txt");
        Scanner readFile = new Scanner(myFile);
        while (readFile.hasNext()) {
            String line[] = readFile.nextLine().split(",");
            String title = line[0];
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            Date dueDate = null;
            try {
                dueDate = formatter.parse(line[1]);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            boolean status = Boolean.parseBoolean(line[2]);
            String project = line[3];
            loadedTasks.add(new Task(title, dueDate, status, project));
        }
        return loadedTasks;
    }

    // saving the task details in data file

    /**
     * Try save tasks boolean.
     *
     * @param tasks the tasks
     * @return the boolean
     */
    public static boolean trySaveTasks(ArrayList<Task> tasks) {
        try {
            new PrintWriter("./resources/data.txt").close();
            new FileWriter("./resources/data.txt", false).close();

            for (Task temp : tasks) {
                String taskToSave = temp.getTaskTitle() + "," +
                        temp.getDueDate() + "," +
                        temp.getStatus().toString() + "," +
                        temp.getProjectName()  + "\n";
                Files.write(Paths.get("./resources/data.txt"), taskToSave.getBytes(), StandardOpenOption.APPEND);
            }

            return true;
        }catch(IOException ex){
            System.out.println("Ooops! a problem happened while saving your file, Please make sure your file exists or not used by a different application!");
            return false;
        }
    }

}
