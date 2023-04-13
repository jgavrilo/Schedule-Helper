package src.main.java.schedule_maker.model;
/** Appointment.java
 *
 *  This class represents an appointment with a name, location, start and end time, and day.
 *
 */
public class Appointment {

  // Instance variables to hold appointment information
  private String name;
  private String place;
  private String startTime;
  private String endTime;
  private String day;

  // ANCHOR: INIT
  // Default constructor sets all fields to "null"
  public Appointment() {
    name = "null";
    place = "null";
    startTime = "null";
    endTime = "null";
    day = "null";
  }

  // Constructor that sets all fields based on input values
  public Appointment(String na, String pl, String sT, String eT, String da) {
    name = na;
    place = pl;
    startTime = sT;
    endTime = eT;
    day = da;
  }

  // ANCHOR: SETTERS
  // Setter methods for all instance variables
  public void setName(String na) {
    name = na;
  }

  public void setPlace(String pl) {
    place = pl;
  }

  public void setDay(String da) {
    day = da;
  }

  public void setStartTime(String sT) {
    startTime = sT;
  }

  public void setEndTime(String eT) {
    endTime = eT;
  }

  // ANCHOR: GETTERS
  // Getter methods for all instance variables
  public String getName() {
    return name;
  }

  public String getPlace() {
    return place;
  }

  public String getStartTime() {
    return startTime;
  }

  public String getEndTime() {
    return endTime;
  }

  public String getDay() {
    return day;
  }

}
