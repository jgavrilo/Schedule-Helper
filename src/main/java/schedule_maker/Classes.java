package src.main.java.schedule_maker;
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
  
}
