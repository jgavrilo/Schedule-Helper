package src.main.java.schedule_maker.flow;

import src.main.java.schedule_maker.model.Appointment;
import src.main.java.schedule_maker.model.Classes;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

/** Printers.java
 * 
 *  This class contains methods for printing various messages and filling class arrays.
 *  These methods are separated from the main program to keep the code organized and modular.
 * 
 */
public class Printers {

    /** ANCHOR: WELCOME
     *  Greets the user with a random welcome message.
     *
     *  @param file     The file's name
     *  @param name     The user's name
     *  @param semester The semester the user wants to view
     *  @param year     The year the user wants to view
     *  @throws IOException If an input or output exception occurs
     */
    public static void welcome(String file, String name, String semester, String year) throws IOException {
        Random rand = new Random();
        int x = rand.nextInt(4); // Change the argument to 4 to include all cases from 0 to 3

        switch (x) {
            case 0:
                System.out.println("Hello, welcome to Schedule Helper!");
                break;
            case 1:
                System.out.println("Are classes getting you down?");
                break;
            case 2:
                System.out.println("You know what they say, I don’t know what they say…");
                break;
            case 3:
                System.out.println("Don’t you wish the semester was over?");
                break;
        }
    }

    // ANCHOR: MAIN MENU
    /* Prints the main menu options. */
    public static void mainMenu() {
        System.out.println("What would you like to do today?");
        char let = 'A';
        System.out.println("MENU:");
        System.out.println(let++ + ") Add a class");
        System.out.println(let++ + ") Drop a class");
        System.out.println(let++ + ") Edit course info");
        System.out.println(let++ + ") View Schedule");
        System.out.println(let++ + ") Set up appointment");
        System.out.println(let++ + ") View appointments");
        System.out.println(let + ") Log out");
    }

    // ANCHOR: I DID NOT UNDERSTAND
    /* Prints an "I did not understand" message when an invalid command is entered. */
    public static void IDidNotUnderstand() {
        System.out.println("I did not understand the command you were trying to do"
                         + ", please try again");
    }

    /** ANCHOR: PRINT SCHEDULE
     *  Prints the user's schedule with class information for each day of the week.
     *
     *  @param cl    An array of Classes objects
     *  @param count The number of classes in the array
     */
    public static void printSchedule(Classes[] cl, int count) {
      String day;
      char d;
      String[] DoW = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};

      if (count == 0) {
          System.out.println("You have no classes listed, please make a class.");
      } else {
          System.out.println("You currently have " + count + " classes listed");

          for (int a = 0; a < 5; a++) {
            System.out.println("------------------------------------" + "\n" + DoW[a]);
            for (int i = 0; i <= count - 1; i++) {
                day = cl[i].getDays();
        
                for (int j = 0; j < day.length(); j++) {
                    d = day.charAt(j);
        
                    if (d == DoW[a].charAt(0)) {
                        System.out.println("\nClass: " + cl[i].getName());
                        System.out.println("Prof: " + cl[i].getProf());
                        System.out.println("Room: " + cl[i].getRoom());
                        System.out.println(cl[i].getStartTime() + " - " + cl[i].getEndTime() + "\n");
                    }
                }
            }
        }
        
      }
    }

    /** ANCHOR: VIEW APPOINTMENTS
     *  This method prints the list of appointments stored in the given Appointment array.
     *
     *  @param app   An array of Appointment objects to display.
     *  @param count The number of appointments in the array.
     *  @param f     The file containing the appointment information.
     */
    public static void viewApps(Appointment[] app, int count, File f) {
        System.out.println("These are the appointments you've already set up:");

        // Iterate through each appointment and display its information
        for (int i = 0; i <= count; i++) {
            System.out.println("Event: " + app[i].getName());
            System.out.println("Place: " + app[i].getPlace());
            System.out.print("Time: " + app[i].getStartTime() + " - ");
            System.out.println(app[i].getEndTime());
            System.out.println("This is happening on " + app[i].getDay());
            System.out.println("\n ------------------------------------------ \n");
        }
    }

    /** ANCHOR: PRINT APPOINTMENTS
     *  This method writes the appointment information to the specified file.
     *
     *  @param app   An array of Appointment objects to be written to the file.
     *  @param count The number of appointments in the array.
     *  @param f     The file where the appointment information will be stored.
     *  @throws IOException If there is an issue with writing to the file.
     */
    public static void printApps(Appointment[] app, int count, File f) throws IOException {
        PrintWriter output = new PrintWriter(f);

        // Iterate through each appointment and write its information to the file
        for (int i = 0; i < count; i++) {
            output.println(app[i].getName());
            output.println(app[i].getPlace());
            output.println(app[i].getStartTime());
            output.println(app[i].getEndTime());
            output.println(app[i].getDay());
        }
        output.close();
    }
}