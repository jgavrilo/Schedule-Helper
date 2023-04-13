package src.main.java.schedule_maker;
import java.util.*;
import java.util.Scanner;
import java.io.*;

public class Final
{
  public static void main(String[] args)throws IOException
  {
    //Opens scanner that allows user to answer questions
    Scanner scan = new Scanner(System.in);
    
    String name; //Holds the users name
    String sem; //Holds the semester
    String year; //Holds the year
    String file; //Holds the file's name
    int count = 0;//Holds the amount of classes
    
    //Finds out your info to locate file
    System.out.println("What's your name?");
    name = scan.nextLine();
    System.out.println("What semester do you wish to look at?");
    sem = scan.nextLine();
    System.out.println("Year?");
    year = scan.nextLine();
    
    //Opens file based on info
    file = name + sem + year + ".txt";
    File f = new File(file);
    
    File courses = new File(welcome(file, name, sem, year));
    Scanner read = new Scanner(courses);
    
    //Creates an array of Classes 10 in length
    Classes[] classes = new Classes[10]; // (AR) 
    
    
    //Reset scanner
    read.close();
    read = new Scanner(courses);
    
    //Fills up a course with info
    Printers.fills(classes, count, read);
    
    //Resets file
    read.close();
    read = new Scanner(courses);
    
    //Loop of main menu and its options
    //This loop never ends because the mainMenu,
    //Has its own exit option
    boolean loop = true;
    do {
      Printers.mainMenu();
      char selection = scan.next().charAt(0);
    
    pick(selection, f, count, name, year, sem);
    } while (loop); 
   }//End of main
  
  public static String welcome(String file, String name, String semester, String year)throws IOException
  {
    Scanner scan = new Scanner(System.in);
    Random rand = new Random();
    int x = rand.nextInt(3);
    switch (x) {
      case 0: System.out.println("Hello, welcome to Schedule Helper!");
      break;
      case 1: System.out.println("Are classes getting you down?");
      break;
      case 2: System.out.println("You know what they say, I don’t know what they say…");
      break;
      case 3: System.out.println("Don’t you wish the semester was over?");
      break;}//End of switch statment
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
  
  public static String newUser(String name, String semester, String year) throws IOException
  {
    String file = name + semester + year + ".txt";
    File f = new File(file);
    
    System.out.print("Welcome, " + name + "!");

    return file;
  }//End of new User
 
  public static String returningUser(String file, String name, String semester, String year)
  {
    Scanner scan = new Scanner(System.in);
    File info = new File(name+semester+year);
    
    while (!(info.exists())){
      Printers.IDidNotUnderstand();
      System.out.println("What's your name?");
      name = scan.nextLine();
      System.out.println("What semester is it?(Fall/Spring/Summer)?");
      semester = scan.nextLine();
      System.out.println("Year?");
      year = scan.nextLine();
      file = name+semester+year+".txt";
      info = new File(file);
    }
    
    System.out.print("Welcome, " + name + "!");
    return file;
  }//End of returningUser
  
    public static void pick(char selection, File f, int count, String name, String year, String sem)throws IOException
  {
    Appointment[] app;
    Classes[] classes = readClasses(f);
    count = counterClass(f);
    
    switch(selection) {
      case 'a':
      case 'A':
        addAClass(classes, count);
        updateClasses(classes, count, name, sem, year);
        break;
        
      case 'b':
      case 'B':
        classes = DropAClass(f, count, classes);
        updateClasses(classes, --count, name, sem, year);
        break;
        
      case 'c':
      case 'C':
        classes = editClass(classes, count);
        updateClasses(classes, count, name, sem, year);
        break;
        
      case 'd':
      case 'D':
        printSchedule(classes, count);
        break;
        
      case 'e': //Fix bugs in make appointment
      case 'E':
        f = new File(name + "Appointments.txt");
        f.createNewFile();
        System.out.print("A");
        count = counterApp(f);
        System.out.print("B");
        app = makeAppointment(appointments(name, count), count);
        System.out.print("C");
        appPrint(app, count, f);
        System.out.print("D");
        break;
        
      case 'f':
      case 'F':
        f = new File(name + "Appointments.txt");
        if (!(f.exists())){
          System.out.println("It looks like you dont have any appointments, please make one to view them");
          Printers.mainMenu();}
        else {
        count = counterApp(f);
        app = appointments(name, count);
        viewApps(app, count,f); }
        break;
        
      case 'g':
      case 'G':
        quit();
        break;
    }//End of switch
  }//End of pick
  
    public static void quit()
  {
    System.exit(0);
  }//End of quit
  
  // Add A Class  *************************************************
    
   public static Classes[] addAClass(Classes[] cl, int count)
   {
    Scanner scan = new Scanner(System.in);
    //Variables 
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
    
    for (int i = 0; i <= 4; i++) 
    {
      System.out.println("Does this class meet " + daysOfWeek[i] + "?");
      answer = scan.nextLine();

      if ((answer.equalsIgnoreCase("Yes")) || (answer.charAt(0) == 'y') || (answer.charAt(0) == 'Y'))
        da += daysOfWeek[i].charAt(0);
      if ((answer.equalsIgnoreCase("No")) || (answer.charAt(0) == 'n') || (answer.charAt(0) == 'N'))
        da += "-";
    }
    
    System.out.println("Please enter the start time");
    sT = askTime();
    System.out.println("Please enter the end time");
    eT = askTime();
    
    //Creates the new class and stores it in the array
    System.out.println(na+" " +pr+" "+ro+" "+sT+" "+eT+" "+da);
    Classes g=new Classes(na, pr, ro, sT, eT, da);
    System.out.println("count = "+count);
    cl[count] = g;
    //cl[count]= new Classes(na, pr, ro, sT, eT, da);
    
    return cl;
   }
   
   public static String askTime()
  {
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
   
public static void updateClasses(Classes c [], int count, String name, String semester, String year)throws IOException

  {
    //Opens file
    PrintWriter output = new PrintWriter(name + semester + year + ".txt");
    
    //Prints out updated info
    for (int i = 0; i <= count; i++)
    {
      output.println(c[i].getName());
      output.println(c[i].getProf());
      output.println(c[i].getRoom());
      output.println(c[i].getStartTime());
      output.println(c[i].getEndTime());
      output.println(c[i].getDays());
    }
    output.close(); 
  }

public static Classes[] readClasses(File f)throws IOException
{
  Scanner reader = new Scanner(f);
  
  int count = counterClass(f);

  reader = new Scanner(f);
  
  Classes[] cl = new Classes[50];
  for (int i = 0; i < 50; i++)
    cl[i] = new Classes();
  
  for(int i = 0; i < count; i++)
    if(reader.hasNext()) 
  { 
      cl[i].setName(reader.nextLine());
      cl[i].setProf(reader.nextLine());
      cl[i].setRoom(reader.nextLine());
      cl[i].setStartTime(reader.nextLine());
      cl[i].setEndTime(reader.nextLine());
      cl[i].setDays(reader.nextLine());
  }
  
  return cl;
}

public static int counterClass(File f)throws IOException
{
  Scanner reader = new Scanner(f);
  int count = 0;

  while ((reader.hasNext() && !(reader.nextLine().equals("null")))){
    reader.nextLine();
    reader.nextLine();
    reader.nextLine();
    reader.nextLine();
    reader.nextLine();
    count++; }
  return count;
}

//Methods for Appointments

public static Appointment[] appointments(String name, int count)throws IOException
{
  Scanner scan = new Scanner(System.in);
  File f = new File(name+"Appointments.txt");
  f.createNewFile();
  Scanner reader = new Scanner(f);
  
  reader.close();
  reader = new Scanner(f);
  
  Appointment[] app = new Appointment[50];
  
  for(int i=0; i<50; i++)
    app[i] = new Appointment();
  
  String line;
  
  for(int i = 0; i < count; i++)
    if(reader.hasNext()) 
  {
      app[i].setName(reader.nextLine());
      app[i].setPlace(reader.nextLine());
      app[i].setStartTime(reader.nextLine());
      app[i].setEndTime(reader.nextLine());
      app[i].setDay(reader.nextLine());
    }
  return app;
}//End of appointments

public static int counterApp(File f)throws IOException
{
  Scanner reader = new Scanner(f);
  int count = 0;
  while(reader.hasNext() && !(reader.nextLine().equals("null"))){
    reader.nextLine();
    reader.nextLine();
    reader.nextLine();
    reader.nextLine();
    count++; }
  return count;
}

public static Appointment[] makeAppointment(Appointment[] app, int count)
{
  Scanner scan = new Scanner(System.in);
  String name, place, startTime, endTime, date;
  boolean loop = true;
  do { System.out.println("What is the Appointment you'd like to add?");
       name = scan.nextLine();
       System.out.println("Where does it take place?");
       place = scan.nextLine();
       System.out.println("When does it start?");
       startTime = askTime();
       System.out.println("When does it end?");
       endTime = askTime();
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
         if ((answer.equalsIgnoreCase("Yes")) || (answer.charAt(0) == 'y') || (answer.charAt(0) == 'Y'))
           loop = false;
         else if ((answer.equalsIgnoreCase("No")) || (answer.charAt(0) == 'n') || (answer.charAt(0) == 'N')) {
           loop = true;
           System.out.println("Let's try this again..."); } } while (loop);
         
      app[count].setName(name);
      app[count].setPlace(place);
      app[count].setStartTime(startTime);
      app[count].setEndTime(endTime);
      app[count].setDay(date);
      
      return app;
}

public static void appPrint(Appointment[] app, int count, File f)throws IOException
{
  PrintWriter output = new PrintWriter(f);
  
  //count++;
  for (int i=0; i<=count; i++){
    output.println(app[i].getName());
    output.println(app[i].getPlace());
    output.println(app[i].getStartTime());
    output.println(app[i].getEndTime());
    output.println(app[i].getDay());
  }
  output.close();
}

public static void viewApps(Appointment[] app, int count, File f)
{
  System.out.println("These are the appointments you've already set up:");
  for (int i=0; i<count; i++){
    System.out.println("Event: " + app[i].getName());
    System.out.println("Place: " + app[i].getPlace());
    System.out.print("Time: " + app[i].getStartTime() + " - ");
    System.out.println(app[i].getEndTime());
    System.out.println("This is happening on " + app[i].getDay());
    System.out.println("\n ------------------------------------------ \n");
  }
} 

//Dropping a class ------------------------


public static Classes[] DropAClass(File f, int count, Classes[] cl)throws IOException
{
  Scanner reader = new Scanner(f);
  Scanner scan = new Scanner(System.in);
  
  System.out.println("What class would you like to drop?");
  String[] classes = new String[count]; 
  int answer;
  int letter;
  do { 
  letter = 1;
  for(int i = 1; i <= count; i++)
   {
    System.out.println(letter++ + ") " + cl[i-1].getName());
   }
  answer = scan.nextInt(); } while (answer > count);
  String search = "";
    
    for (int i = answer-1; i <= count; i++) {
    Classes temp = cl[i];
    cl[i] = cl[i+1];
    cl[i+1] = temp;}
    
    return cl;
}

public static Classes[] editClass(Classes[] cl, int count)
{
  Scanner scan = new Scanner(System.in);
  int answer;
  do { 
  int letter = 1;
  for(int i = 1; i <= count; i++)
   {
    System.out.println(letter++ + ") " + cl[i-1].getName());
   }
  answer = scan.nextInt(); 
  scan.nextLine();} while (answer > count);
  System.out.println("What info would you like to change? \n A)Name \n B)Professor \n C)Room \n D)Times \n E)Days");
  String a;
  boolean loop = true;
  do{
    a = scan.nextLine();
    switch (a) {
      case "A":
      case "a":
      System.out.println("What would you like to change the name of the course to?");
      cl[answer-1].setName(scan.nextLine());
      loop = false;
      break;
      case "B":
      case "b":
      System.out.println("What would you like to change the name of the professor to?");
      cl[answer-1].setProf(scan.nextLine());
      loop = false;
      break;
      case "C":
      case "c":
      System.out.println("What would you like to change the room to?");
      cl[answer-1].setRoom(scan.nextLine());
      loop = false;
      break;
      case "D":
      case "d":
      System.out.println("What would you like to change the start time to?");
      String sT = askTime();
      cl[answer-1].setStartTime(sT);
      System.out.println("What would you like to change the end time to?");
      String eT = askTime();
      cl[answer-1].setRoom(eT);
      loop = false;
      break;
      case "E":
      case "e":
      String d;
      String da = "";
      String[] daysOfWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
      for (int i = 0; i <= 4; i++) 
      {
      System.out.println("Does this class meet " + daysOfWeek[i] + "?");
      d = scan.nextLine();
      if ((d.equalsIgnoreCase("Yes")) || (d.charAt(0) == 'y') || (d.charAt(0) == 'Y'))
        da += daysOfWeek[i].charAt(0);
      if ((d.equalsIgnoreCase("No")) || (d.charAt(0) == 'n') || (d.charAt(0) == 'N'))
        da += "-";
      }
      cl[answer-1].setDays(da);
      loop = false;
      break;
      default:
      Printers.IDidNotUnderstand();
      break;
     }
    }while(loop);
    
    return cl;
  }
  
public static void printSchedule(Classes[] cl, int count)
{ 
  String day;
  char d;
  String[] DoW = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
  if (count == 0)
    System.out.println("You have no classes listed, please make a class.");
  else{
    System.out.println("You currently have " + count + " classes listed");
     
    
    for(int a = 0; a < 5; a++) {
    System.out.println("------------------------------------" + "\n" + DoW[a]);
  for(int i = 0; i < count; i++) {
      day = cl[i].getDays();
      d = day.charAt(a);
      if (d == DoW[a].charAt(0))
      {
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
