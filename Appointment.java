import java.util.Scanner;

/* Appointment
Appointment.java
Jeremy Gavrilov
jgavrilo
Section 1*/

public class Appointment
{
  private String name;
  private String place;
  private String startTime;
  private String endTime;
  private String day;
    
  public Appointment()
  {
    name = "null";
    place = "null";
    startTime = "null";
    endTime = "null";
    day = "null";
  }
  
  public Appointment(String na, String pl, String sT,
                 String eT, String da)
  {
    name = na;
    place = pl;
    startTime = sT;
    endTime = eT;
    day = da;
  }
  
  public void setName(String na)
  {
    name = na;
  }

  public void setPlace(String pl)
  {
    place = pl;
  }
  
  public void setDay(String da)
  {
    day = da;
  }
  
  public void setStartTime(String sT)
  {
    startTime = sT;
  }
  
  public void setEndTime(String eT)
  {
    endTime = eT;
  }
  
  public String getName()
  {
    return name;
  }
  
  public String getPlace()
  {
    return place;
  }
  
  public String getStartTime()
  {
    return startTime;
  }
  
  public String getEndTime()
  {
    return endTime;
  }
  
  public String getDay()
  {
    return day;
  }
  
}
