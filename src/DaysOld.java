import days_old.CountDays;
import days_old.evaluate_exceptions.*;
import java.text.DateFormatSymbols;

import java.text.ParseException;
import java.util.Calendar;

/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 *
 * @author Danh Nguyen, ID: 1592873
 */
public class DaysOld {

    /**
     * Calculate how many days between today and the input date and print them out
     * @param birthday      {@code String} The start date
     */
    public static void days(String birthday) {
        // Initialize date objects
        Calendar today = Calendar.getInstance();
        Calendar b_day = Calendar.getInstance();

        // Assign date with dateParser. This function will throw exception if date
        // does not exist or invalid.
        try {
            b_day = CountDays.dateParser(birthday);
        } 
        catch (ParseException | InvalidDate e) {
            System.out.println("Date does not exist");
            return;
        }

        // Printing
        int result;
        String monthString1 = new DateFormatSymbols().getMonths()[b_day.get(Calendar.MONTH)];
        String monthString2 = new DateFormatSymbols().getMonths()[today.get(Calendar.MONTH)];

        System.out.print("Birthday: " + monthString1 + " " + b_day.get(Calendar.DAY_OF_MONTH)
        + " " + b_day.get(Calendar.YEAR) + "; today: " + monthString2 + " " + today.get(Calendar.DAY_OF_MONTH)
        + " " + today.get(Calendar.YEAR) + " -- ");

        // Calculate the days difference. If beginning date exceeds end date, exception is thrown,
        // If beginning date is too early (more info in README), exception is thrown
        try {
            CountDays c = new CountDays(b_day, Calendar.getInstance());
            result = c.countingDays();
            System.out.println("You are " + result + " days old.");
        } 
        catch (EndDateExceedsBeginDateException e) {
            System.out.println("Wrong Birthday! Birthday cannot be later than today.");
        } 
        catch (BeginningDateExceedsLimit beginningDateExceedsLimit) {
            System.out.println("Does not support dates earlier than October 15, 1582.");
        }

    }

    /**
     * Main entry
     * @param args          {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        days("2000-6-1");
        days("3000-1-1");           // This is a wrong birthday
        days("2001-30-51");         // This is invalid date
        days("500-12-31");          // This is too early
    }

}
