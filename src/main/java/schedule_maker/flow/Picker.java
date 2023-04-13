package src.main.java.schedule_maker.flow;

import src.main.java.schedule_maker.manager.AppointmentManager;
import src.main.java.schedule_maker.manager.ClassesManager;
import src.main.java.schedule_maker.model.Appointment;
import src.main.java.schedule_maker.model.Classes;

import java.io.File;
import java.io.IOException;

/** Picker.java 
 * 
 *  The Picker class contains a method for executing different operations
 *  based on the user's selection. These operations include adding, dropping,
 *  editing classes, printing schedules, managing appointments, and quitting the program.
 *
 */
public class Picker {

    /** ANCHOR: PICK
     *  Executes the operation based on the user's selection.
     *
     *  @param selection The character representing the user's choice.
     *  @param f         The file object.
     *  @param count     The number of classes or appointments.
     *  @param name      The user's name.
     *  @param year      The year of the schedule.
     *  @param sem       The semester of the schedule.
     *  @throws IOException If an input or output exception occurs.
     */
    public static void pick(char selection, File f, int count, String name, String year, String sem) throws IOException {
        Appointment[] app;
        Classes[] classes = ClassesManager.readClasses(f);
        count = ClassesManager.counterClass(f);

        switch (selection) {
            case 'a':
            case 'A':
                ClassesManager.addAClass(classes, count);
                ClassesManager.updateClasses(classes, count, name, sem, year);
                break;

            case 'b':
            case 'B':
                classes = ClassesManager.dropAClass(f, count, classes);
                ClassesManager.updateClasses(classes, --count, name, sem, year);
                break;

            case 'c':
            case 'C':
                classes = ClassesManager.editClass(classes, count);
                ClassesManager.updateClasses(classes, count, name, sem, year);
                break;

            case 'd':
            case 'D':
                Printers.printSchedule(classes, count);
                break;

            // TODO: There are bugs invloving the storage of appointments
            case 'e':
            case 'E':
                String fileName = name + "Appointments.txt";
                count = AppointmentManager.counterApp(new File(fileName));
                app = AppointmentManager.makeAppointment(AppointmentManager.appointments(name, count), count, fileName);
                Printers.printApps(app, count, new File(fileName));
                break;

            case 'f':
            case 'F':
                f = new File(name + "Appointments.txt");
                if (!(f.exists())) {
                    System.out.println("It looks like you dont have any appointments, please make one to view them");
                } else {
                    count = AppointmentManager.counterApp(f);
                    app = AppointmentManager.appointments(name, count);
                    Printers.viewApps(app, count, f);
                }
                break;

            case 'g':
            case 'G':
                Quit.quit();
                break;
        }
    }
}

