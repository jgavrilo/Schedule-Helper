package src.main.java.schedule_maker.flow;

import java.util.Scanner;

/** AskTime.java
 * 
 *  This class contains utility methods for asking user input for specific data types.
 * 
 */
public class AskTime {

    /** ANCHOR: ASK TIME
     *  Prompts the user for a time input in the format of hour, minute, and AM/PM.
     *
     *  @return A string representation of the time entered by the user
     */
    public static String askTime() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Hour:");
        String hour = scan.nextLine();
        System.out.println("Min:");
        String min = scan.nextLine();
        System.out.println("AM/PM?");
        String AMPM = scan.nextLine();
        String time = hour + ":" + min + " " + AMPM;
        return time;
    }
}
