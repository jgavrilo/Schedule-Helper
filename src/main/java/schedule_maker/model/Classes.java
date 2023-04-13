package src.main.java.schedule_maker.model;
/** Classes.java 
 * 
 *  This class represents a class with a name, professor, room number, start and end time, and days of the week.
 * 
 */

import java.util.Scanner;

import src.main.java.schedule_maker.Askers;
import src.main.java.schedule_maker.Printers;

import java.io.*;
public class Classes {
  
  // Instance variables to hold class information
  private String name;
  private String prof;
  private String room;
  private String startTime;
  private String endTime;
  private String days;
  
  // Default constructor sets all fields to "null"
  public Classes() {
    name = "null";
    prof = "null";
    room = "null";
    startTime = "null";
    endTime = "null";
    days = "null";
  }
  
  // Constructor that sets all fields based on input values
  public Classes(String na, String pr, String ro, String sT, String eT, String da) {
    name = na;
    prof = pr;
    room = ro;
    startTime = sT;
    endTime = eT;
    days = da;
  }
  
  // Method to read in class information from a scanner object
  public void reader(Scanner read) {
    name = read.nextLine();
    prof = read.nextLine();
    room = read.nextLine();
    startTime = read.nextLine();
    endTime = read.nextLine();
    days = read.nextLine();
  }
  
  // toString method to print out class information
  public String toString() {
    String str = "";
    str = name + " - " + prof + " - " + room + "\n";
    str += startTime + " - " + endTime + "\n";
    str += days;
    return str;
  }
  
  // Getter methods for all instance variables
  public String getName() {
    return name;
  }
  
  public String getProf() {
    return prof;
  }
  
  public String getRoom() {
    return room;
  }
  
  public String getStartTime() {
    return startTime;
  }
  
  public String getEndTime() {
    return endTime;
  }
  
  public String getDays() {
    return days;
  }
  
  // Setter methods for all instance variables
  public void setName(String na) {
    name = na;
  }
  
  public void setProf(String po) {
    prof = po;
  }
  
  public void setRoom(String ro) {
    room = ro;
  }
  
  public void setStartTime(String sT) {
    startTime = sT;
  }
  
  public void setEndTime(String eT) {
    endTime = eT;
  }
  
  public void setDays(String da) {
    days = da;
  }
  
  /**
   * Fills the Classes array with empty classes and then fills it from a file.
   * @param classes Array of Classes to be filled
   * @param count Number of Classes in the array
   * @param scan Scanner object to read from a file
   * @return The filled Classes array
   */
  public static Classes[] fills(Classes classes[], int count, Scanner scan) {
    for(int i = 0; i < count; i++)//Fills array with empty classes
      classes[i] = new Classes();
    
    for(int a = 0; a < count; a++)//Fills array from file
      classes[a].reader(scan);
    
    return classes;
  }

  /**
   * Allows the user to edit class information for a specific class.
   *
   * @param cl    An array of Classes objects
   * @param count The number of classes in the array
   * @return The updated array of Classes objects
   */
  public static Classes[] editClass(Classes[] cl, int count) {
    Scanner scan = new Scanner(System.in);
    int answer;

    do {
        int letter = 1;
        for (int i = 1; i <= count; i++) {
            System.out.println(letter++ + ") " + cl[i - 1].getName());
        }
        answer = scan.nextInt();
        scan.nextLine();
    } while (answer > count);

    System.out.println("What info would you like to change? \n A)Name \n B)Professor \n C)Room \n D)Times \n E)Days");
    String a;
    boolean loop = true;

    do {
        a = scan.nextLine();
        switch (a) {
            case "A":
            case "a":
                System.out.println("What would you like to change the name of the course to?");
                cl[answer - 1].setName(scan.nextLine());
                loop = false;
                break;
            case "B":
            case "b":
                System.out.println("What would you like to change the name of the professor to?");
                cl[answer - 1].setProf(scan.nextLine());
                loop = false;
                break;
            case "C":
            case "c":
                System.out.println("What would you like to change the room to?");
                cl[answer - 1].setRoom(scan.nextLine());
                loop = false;
                break;
            case "D":
            case "d":
                System.out.println("What would you like to change the start time to?");
                String sT = Askers.askTime();
                cl[answer - 1].setStartTime(sT);
                System.out.println("What would you like to change the end time to?");
                String eT = Askers.askTime();
                cl[answer - 1].setRoom(eT);
                loop = false;
                break;
            case "E":
            case "e":
                String d;
                String da = "";
                String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
                for (int i = 0; i <= 4; i++) {
                    System.out.println("Does this class meet " + daysOfWeek[i] + "?");
                    d = scan.nextLine();
                    if ((d.equalsIgnoreCase("Yes")) || (d.charAt(0) == 'y') || (d.charAt(0) == 'Y'))
                        da += daysOfWeek[i].charAt(0);
                    if ((d.equalsIgnoreCase("No")) || (d.charAt(0) == 'n') || (d.charAt(0) == 'N'))
                        da += "-";
                }
                cl[answer - 1].setDays(da);
                loop = false;
                break;
            default:
                Printers.IDidNotUnderstand();
                break;
        }
    } while (loop);

    return cl;
  }


    /**
     * Drops a class from the user's schedule and updates the Classes array.
     *
     * @param f     The file containing the class information
     * @param count The number of classes in the user's schedule
     * @param cl    The array of Classes objects
     * @return The updated Classes array after dropping the selected class
     * @throws IOException If an I/O error occurs while reading the file
     */
    public static Classes[] dropAClass(File f, int count, Classes[] cl) throws IOException {
      Scanner reader = new Scanner(f);
      Scanner scan = new Scanner(System.in);

      System.out.println("What class would you like to drop?");
      String[] classes = new String[count];
      int answer;
      int letter;
      do {
          letter = 1;
          for (int i = 1; i <= count; i++) {
              System.out.println(letter++ + ") " + cl[i - 1].getName());
          }
          answer = scan.nextInt();
      } while (answer > count);
      String search = "";

      for (int i = answer - 1; i <= count; i++) {
          Classes temp = cl[i];
          cl[i] = cl[i + 1];
          cl[i + 1] = temp;
      }

      return cl;
  }

  /**
   * Adds a new class to the array of Classes.
   *
   * @param cl    The array of Classes objects.
   * @param count The current number of classes in the array.
   * @return The updated array of Classes objects.
   */
  public static Classes[] addAClass(Classes[] cl, int count) {
    Scanner scan = new Scanner(System.in);
    // Variables
    String na;
    String pr;
    String ro;
    String sT;
    String eT;
    String da = "";
    String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
    String answer;

    System.out.println("What’s the class name?");
    na = scan.nextLine();

    System.out.println("Professor?");
    pr = scan.nextLine();

    System.out.println("Location/Room?");
    ro = scan.nextLine();

    for (int i = 0; i <= 4; i++) {
        System.out.println("Does this class meet " + daysOfWeek[i] + "?");
        answer = scan.nextLine();

        if ((answer.equalsIgnoreCase("Yes")) || (answer.charAt(0) == 'y') || (answer.charAt(0) == 'Y'))
            da += daysOfWeek[i].charAt(0);
        if ((answer.equalsIgnoreCase("No")) || (answer.charAt(0) == 'n') || (answer.charAt(0) == 'N'))
            da += "-";
    }

    System.out.println("Please enter the start time");
    sT = Askers.askTime();
    System.out.println("Please enter the end time");
    eT = Askers.askTime();

    // Creates the new class and stores it in the array
    System.out.println(na + " " + pr + " " + ro + " " + sT + " " + eT + " " + da);
    Classes g = new Classes(na, pr, ro, sT, eT, da);
    System.out.println("count = " + count);
    cl[count] = g;

    return cl;
  }

  /**
  * Updates the Classes data in a file.
  *
  * @param c       The array of Classes objects.
  * @param count   The current number of classes in the array.
  * @param name    The name of the user.
  * @param semester The current semester.
  * @param year     The current year.
  * @throws IOException If there is an issue with file input/output.
  */
  public static void updateClasses(Classes c[], int count, String name, String semester, String year) throws IOException {
    // Opens file
    PrintWriter output = new PrintWriter(name + semester + year + ".txt");

    // Prints out updated info
    for (int i = 0; i <= count; i++) {
        output.println(c[i].getName());
        output.println(c[i].getProf());
        output.println(c[i].getRoom());
        output.println(c[i].getStartTime());
        output.println(c[i].getEndTime());
        output.println(c[i].getDays());
    }
    output.close();
  }

  /**
   * Reads classes data from a file and stores it in an array of Classes objects.
   *
   * @param f The file containing the classes data.
   * @return An array of Classes objects containing the classes data from the file.
   * @throws IOException If there is an issue with file input/output.
   */
  public static Classes[] readClasses(File f) throws IOException {
    Scanner reader = new Scanner(f);

    int count = counterClass(f);

    reader = new Scanner(f);

    Classes[] cl = new Classes[50];
    for (int i = 0; i < 50; i++)
        cl[i] = new Classes();

    for (int i = 0; i < count; i++)
        if (reader.hasNext()) {
            cl[i].setName(reader.nextLine());
            cl[i].setProf(reader.nextLine());
            cl[i].setRoom(reader.nextLine());
            cl[i].setStartTime(reader.nextLine());
            cl[i].setEndTime(reader.nextLine());
            cl[i].setDays(reader.nextLine());
        }

    return cl;
  }

  /**
   * Counts the number of classes in a given file.
   *
   * @param f The file containing the classes data.
   * @return The number of classes in the file.
   * @throws IOException If there is an issue with file input/output.
   */
  public static int counterClass(File f) throws IOException {
    Scanner reader = new Scanner(f);
    int count = 0;

    while ((reader.hasNext() && !(reader.nextLine().equals("null")))) {
        reader.nextLine();
        reader.nextLine();
        reader.nextLine();
        reader.nextLine();
        reader.nextLine();
        count++;
    }
    return count;
  }

}
