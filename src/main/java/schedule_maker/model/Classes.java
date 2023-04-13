package src.main.java.schedule_maker.model;
/** Classes.java 
 * 
 *  This class represents a class with a name, professor, room number, start and end time, and days of the week.
 * 
 */
import java.util.Scanner;

public class Classes {
  
  // Instance variables to hold class information
  private String name;
  private String prof;
  private String room;
  private String startTime;
  private String endTime;
  private String days;
  
  // ANCHOR: INIT
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
  
  // ANCHOR: Reader
  // Method to read in class information from a scanner object
  public void reader(Scanner read) {
    name = read.nextLine();
    prof = read.nextLine();
    room = read.nextLine();
    startTime = read.nextLine();
    endTime = read.nextLine();
    days = read.nextLine();
  }
  
  // ANCHOR: toString
  // toString method to print out class information
  public String toString() {
    String str = "";
    str = name + " - " + prof + " - " + room + "\n";
    str += startTime + " - " + endTime + "\n";
    str += days;
    return str;
  }
  
  // ANCHOR: GETTERS
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
  
  // ANCHOR: SETTERS
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
  
  /** ANCHOR: Filler
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

}
