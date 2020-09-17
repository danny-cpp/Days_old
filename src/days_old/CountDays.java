package days_old;

import java.util.Calendar;

/**
 * Counting days between 2 dates package
 *
 * @author Danh Nguyen
 */
public class CountDays {

    // The core of this class is 2 calendar object
    Calendar start = Calendar.getInstance();
    Calendar end = Calendar.getInstance();

    /**
     * Constructor requires 2 date in form of Calendar object
     *
     * @param start Calendar start date
     * @param end   Calendar end date
     */
    CountDays(Calendar start, Calendar end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Find the number of days in a year (only valid after  October 15, 1582)
     *
     * @param year The year to check
     * @return Either 365, or 366 days
     */
    private static int getYearsDay(int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);

        return cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    }

    /**
     * Calculate the number of days left in the year of a particular date
     *
     * @param moment Calendar date object
     * @return       The number of days left in that year
     */
    private static int daysLeft(Calendar moment) {

        int total_day = getYearsDay(moment.get(Calendar.YEAR));
        int day_of_year = moment.get(Calendar.DAY_OF_YEAR);

        return total_day - day_of_year;
    }

    /**
     * Calculate the total days of years between the dates, exclude the 2 end point years
     * themselves.
     *
     * @return Total days between 2 years (exclude the end point years)
     */
    private int daysBetween() {
        int total_day = 0;
        int start_year = start.get(Calendar.YEAR);

        int end_year = end.get(Calendar.YEAR);
        for (int i = start_year + 1; i < end.get(Calendar.YEAR); i++) {
            total_day += getYearsDay(i);
        }

        return total_day;
    }

    public static void main(String[] args) {
        Calendar test = Calendar.getInstance();
        test.set(2020, 0, 31);

        System.out.println(CountDays.daysLeft(test));
    }
}