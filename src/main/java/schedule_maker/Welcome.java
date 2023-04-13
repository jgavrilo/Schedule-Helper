package src.main.java.schedule_maker;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 * Welcome.java
 * This class contains the welcome method, which is responsible for greeting the user
 * and determining whether they are a returning or new user. It then processes user
 * input accordingly and returns the appropriate file name.
 */
public class Welcome {

    /**
     * Greets the user with a random welcome message and determines if they are a new or returning user.
     * Depending on the user's response, the method calls either newUser or returningUser to get the
     * appropriate file name.
     *
     * @param file     The file's name
     * @param name     The user's name
     * @param semester The semester the user wants to view
     * @param year     The year the user wants to view
     * @return The file name based on the user's input
     * @throws IOException If an input or output exception occurs
     */
    public static String welcome(String file, String name, String semester, String year) throws IOException {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int x = rand.nextInt(3);
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
        }//End of switch statement
        System.out.println("Are you a returning user? (yes/no)");
        String user = scan.nextLine();
        int User = 0;
        while (User != -1 && User != 1) {
            if ((user.equalsIgnoreCase("Yes")) || (user.charAt(0) == 'y') || (user.charAt(0) == 'Y'))
                User = 1;
            else if ((user.equalsIgnoreCase("No")) || (user.charAt(0) == 'n') || (user.charAt(0) == 'N'))
                User = -1;
            else
                Printers.IDidNotUnderstand();
        }//End of while loop
        file = "";
        if (User == -1)
            file = newUser(name, semester, year);
        if (User == 1)
            file = returningUser(file, name, semester, year);
        return file;
    }//End of welcome

    /**
     *  Creates a new user file based on the user's input.
     *
     *  @param name     The user's name
     *  @param semester The semester the user wants to view
     *  @param year     The year the user wants to view
     *  @return The file name based on the user's input
     *  @throws IOException If an input or output exception occurs
     */
    public static String newUser(String name, String semester, String year) throws IOException {
        String file = name + semester + year + ".txt";
        File f = new File(file);

        System.out.print("Welcome, " + name + "!");

        return file;
    }

    /**
     * Searches for an existing user file based on the user's input.
     *
     * @param file     The file's name
     * @param name     The user's name
     * @param semester The semester the user wants to view
     * @param year     The year the user wants to view
     * @return The file name based on the user's input
     */
    public static String returningUser(String file, String name, String semester, String year) {
        Scanner scan = new Scanner(System.in);
        File info = new File(name + semester + year);

        while (!(info.exists())) {
            Printers.IDidNotUnderstand();
            System.out.println("What's your name?");
            name = scan.nextLine();
            System.out.println("What semester is it?(Fall/Spring/Summer)?");
            semester = scan.nextLine();
            System.out.println("Year?");
            year = scan.nextLine();
            file = name + semester + year + ".txt";
            info = new File(file);
        }

        System.out.print("Welcome, " + name + "!");
        return file;
    }
}
