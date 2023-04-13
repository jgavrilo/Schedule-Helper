/** Printers.java
 * 
 *  This class contains methods for printing various messages and filling class arrays.
 *  These methods are separated from the main program to keep the code organized and modular.
 * 
 */
package src.main.java.schedule_maker;
import java.util.Scanner;

import src.main.java.schedule_maker.model.Appointment;
import src.main.java.schedule_maker.model.Classes;

import java.io.*;

public class Printers {

    /* Prints the main menu options. */
    public static void mainMenu() {
        Scanner scan = new Scanner(System.in);
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

    /* Prints an "I did not understand" message when an invalid command is entered. */
    public static void IDidNotUnderstand() {
        System.out.println("I did not understand the command you were trying to do"
                         + ", please try again");
    }

    /**
     * Prints the user's schedule with class information for each day of the week.
     *
     * @param cl    An array of Classes objects
     * @param count The number of classes in the array
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
              for (int i = 0; i < count; i++) {
                  day = cl[i].getDays();
                  d = day.charAt(a);

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

    /**
     * This method prints the list of appointments stored in the given Appointment array.
     *
     * @param app   An array of Appointment objects to display.
     * @param count The number of appointments in the array.
     * @param f     The file containing the appointment information.
     */
    public static void viewApps(Appointment[] app, int count, File f) {
        System.out.println("These are the appointments you've already set up:");

        // Iterate through each appointment and display its information
        for (int i = 0; i < count; i++) {
            System.out.println("Event: " + app[i].getName());
            System.out.println("Place: " + app[i].getPlace());
            System.out.print("Time: " + app[i].getStartTime() + " - ");
            System.out.println(app[i].getEndTime());
            System.out.println("This is happening on " + app[i].getDay());
            System.out.println("\n ------------------------------------------ \n");
        }
    }

    /**
     * This method writes the appointment information to the specified file.
     *
     * @param app   An array of Appointment objects to be written to the file.
     * @param count The number of appointments in the array.
     * @param f     The file where the appointment information will be stored.
     * @throws IOException If there is an issue with writing to the file.
     */
    public static void appPrint(Appointment[] app, int count, File f) throws IOException {
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