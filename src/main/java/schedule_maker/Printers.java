/** Printers.java
 * 
 *  This class contains methods for printing various messages and filling class arrays.
 *  These methods are separated from the main program to keep the code organized and modular.
 * 
 */
package src.main.java.schedule_maker;
import java.util.Scanner;

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