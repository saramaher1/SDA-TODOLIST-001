package com.SaraSDA.ToDoListApp_V2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        //Making list for adding tasks in it.

        ArrayList<Task> taskList=new ArrayList<Task>();


        System.out.println("       Welcome to your ToDoList :      ");
        System.out.println();

        // here we shoulde write how many task we have and how many task we'v done;
        Display d= new Display();
        d.StartMenu();

    }

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
