package src.main.java.schedule_maker;
/** Appointment.java
 *
 *  This class represents an appointment with a name, location, start and end time, and day.
 *
 */
import java.util.Scanner;
import java.io.*;

public class Appointment {

  // Instance variables to hold appointment information
  private String name;
  private String place;
  private String startTime;
  private String endTime;
  private String day;

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

  /**
   * This method creates a new appointment and adds it to the array of appointments.
   *
   * @param app   An array of Appointment objects.
   * @param count The current number of appointments in the array.
   * @return The updated array of Appointment objects with the new appointment added.
   */
  public static Appointment[] makeAppointment(Appointment[] app, int count) {
    Scanner scan = new Scanner(System.in);
    String name, place, startTime, endTime, date;
    boolean loop = true;

    do {
        System.out.println("What is the Appointment you'd like to add?");
        name = scan.nextLine();
        System.out.println("Where does it take place?");
        place = scan.nextLine();
        System.out.println("When does it start?");
        startTime = Askers.askTime();
        System.out.println("When does it end?");
        endTime = Askers.askTime();
        System.out.println("What day does it take place on? (please enter in xx/xx/xxxx form");
        String month, day, year;
        System.out.println("Month?");
        month = scan.nextLine();
        System.out.println("Day?");
        day = scan.nextLine();
        System.out.println("Year?");
        year = scan.nextLine();
        date = month + "/" + day + "/" + year;

        System.out.println("Just to double check, you entered this information:");
        System.out.println(name + "\n" + place + "\n" + startTime + "\n" + endTime + "\n" + date);
        System.out.println("Is this correct?");
        String answer = scan.nextLine();

        if ((answer.equalsIgnoreCase("Yes")) || (answer.charAt(0) == 'y') || (answer.charAt(0) == 'Y')) {
            loop = false;
        } else if ((answer.equalsIgnoreCase("No")) || (answer.charAt(0) == 'n') || (answer.charAt(0) == 'N')) {
            loop = true;
            System.out.println("Let's try this again...");
        }
    } while (loop);

    app[count].setName(name);
    app[count].setPlace(place);
    app[count].setStartTime(startTime);
    app[count].setEndTime(endTime);
    app[count].setDay(date);

    return app;
  }

  /**
   * This method reads appointment data from a file and stores it in an array of Appointment objects.
   *
   * @param name  The name of the user.
   * @param count The current number of appointments in the array.
   * @return An array of Appointment objects containing the appointment data from the file.
   * @throws IOException If there is an issue with file input/output.
   */
  public static Appointment[] appointments(String name, int count) throws IOException {
    Scanner scan = new Scanner(System.in);
    File f = new File(name + "Appointments.txt");
    f.createNewFile();
    Scanner reader = new Scanner(f);

    reader.close();
    reader = new Scanner(f);

    Appointment[] app = new Appointment[50];

    for (int i = 0; i < 50; i++) {
        app[i] = new Appointment();
    }

    String line;

    for (int i = 0; i < count; i++) {
        if (reader.hasNext()) {
            app[i].setName(reader.nextLine());
            app[i].setPlace(reader.nextLine());
            app[i].setStartTime(reader.nextLine());
            app[i].setEndTime(reader.nextLine());
            app[i].setDay(reader.nextLine());
        }
    }
    return app;
  } //End of appointments

  /**
  * This method counts the number of appointments in a file.
  *
  * @param f The file containing appointment data.
  * @return The number of appointments in the file.
  * @throws IOException If there is an issue with file input/output.
  */
  public static int counterApp(File f) throws IOException {
    Scanner reader = new Scanner(f);
    int count = 0;

    while (reader.hasNext() && !(reader.nextLine().equals("null"))) {
        reader.nextLine();
        reader.nextLine();
        reader.nextLine();
        reader.nextLine();
        count++;
    }
    return count;
  }

}
