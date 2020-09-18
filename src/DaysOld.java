import days_old.CountDays;
import days_old.evaluate_exceptions.*;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */
public class DaysOld {

    /**
     * Calculate how many days between today and the date, and them out
     * @param birthday      {@code String} The start date
     */
    public static void days(String birthday) {
        Calendar b_day = Calendar.getInstance();
        try {
            b_day = CountDays.dateParser(birthday);
        } 
        catch (ParseException | InvalidDate e) {
            System.out.println("Date does not exist");
        }
        
        int result = 0;
        
        try {
            CountDays c = new CountDays(b_day, Calendar.getInstance());
            System.out.println(c.countingDays());
        } 
        catch (EndDateExceedsBeginDateException e) {
            System.out.println("Birthday cannot be later than today.");
        } 
        catch (BeginningDateExceedsLimit beginningDateExceedsLimit) {
            System.out.println("Does not support dates earlier than October 15, 1582.");
        }


    } // public static void days(String birthday)

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        days("2000-6-15");
        days("3000-1-1");           // This is a wrong birthday
        // days("2001-30-51");
        // Add your birthday
        // days("yyyy-MM-dd");
    }

}
