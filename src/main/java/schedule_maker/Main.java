package src.main.java.schedule_maker;

import java.util.Scanner;

import src.main.java.schedule_maker.flow.Picker;
import src.main.java.schedule_maker.flow.Printers;
import src.main.java.schedule_maker.model.Classes;

import java.io.File;
import java.io.IOException;

/** Main.java
 *  ScheduleMaker is a Java program that allows users to manage their class schedules
 *  and appointments. Users can add, edit, delete, and view their class schedule, as well
 *  as create and view appointments. The program stores the class schedule and appointment
 *  information in text files for easy retrieval.
 *
 *  The program consists of several classes that handle different functionalities such as
 *  creating, editing, and displaying class schedules, managing appointments, and providing
 *  user interfaces for user interactions.
 */

public class Main {

    public static void main(String[] args) throws IOException {
        // Opens scanner that allows the user to answer questions
        Scanner scan = new Scanner(System.in);

        // Holds the user's name, semester, and year
        String name, sem, year;
        // Variable to hold the number of classes
        int count = 0;

        // Asks the user for their name, semester, and year
        System.out.println("What's your name?");
        name = scan.nextLine();
        System.out.println("What semester do you wish to look at?");
        sem = scan.nextLine();
        System.out.println("Year?");
        year = scan.nextLine();

        // Opens the file based on the user's input
        String file = name + sem + year + ".txt";
        File f = new File(file);

        // Check if the file exists
        if (f.exists()) {
          System.out.println("Welcome back, " + name + "! Your schedule for " + sem + " " + year + " has been loaded.");
        } else {
            System.out.println("You must be a new user. Creating a new schedule for " + sem + " " + year + ".");
            f.createNewFile();
        }
        
        // Calls the welcome() method and initializes the courses File object
        Printers.welcome(file, name, sem, year);
        Scanner read = new Scanner(file);

        // Creates an array of Classes with a length of 10
        Classes[] classes = new Classes[10];

        // Fills up the classes array with information from the file
        Classes.fills(classes, count, read);

        // Resets the file scanner
        read.close();
        read = new Scanner(file);

        // Loop for the main menu and its options
        // This loop never ends because the mainMenu has its own exit option
        boolean loop = true;
        do {
            Printers.mainMenu();
            char selection = scan.next().charAt(0);

            Picker.pick(selection, f, count, name, year, sem);
        } while (loop);
    }

}
