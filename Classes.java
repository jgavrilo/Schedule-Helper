/* Classes
Classes.java
Jeremy Gavrilov
jgavrilo
Section 1*/

import java.util.Scanner;

public class Classes
{
  private String name;
  private String prof;
  private String room;
  private String startTime;
  private String endTime;
  private String days;
  
  public Classes()
  {
    name = "null";
    prof = "null";
    room = "null";
    startTime = "null";
    endTime = "null";
    days = "null";
  }
  
  public Classes(String na, String pr, String ro, String sT,
                 String eT, String da)
  {
    name = na;
    prof = pr;
    room = ro;
    startTime = sT;
    endTime = eT;
    days = da;
  }
  
  public void reader(Scanner read)
  {
    name = read.nextLine();
    prof = read.nextLine();
    room = read.nextLine();
    startTime = read.nextLine();
    endTime = read.nextLine();
    days = read.nextLine();
  }
  
  public String toString()
  {
    String str = "";
    str = name + " - " + prof + " - " + room + "\n";
    str += startTime + " - " + endTime + "\n";
    str += days;
    
    return str;
  }
  
  
//Get and set Methods//  
  public String getName()
  {
    return name;
  }
  
  public String getProf()
  {
    return prof;
  }
  
  public String getRoom()
  {
    return room;
  }
  
  public String getStartTime()
  {
    return startTime;
  }
  
  public String getEndTime()
  {
    return endTime;
  }
  
  public String getDays()
  {
    return days;
  }
  
  
  public void setName(String na)
  {
    name = na;
  }
  
  public void setProf(String po)
  {
    prof = po;
  }
  
  public void setRoom(String ro)
  {
    room = ro;
  }
  
  public void setStartTime(String sT)
  {
    startTime = sT;
  }
  
  public void setEndTime(String eT)
  {
    endTime = eT;
  }
  
  public void setDays(String da)
  {
    days = da;
  }
  
}
