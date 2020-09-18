package days_old;

import java.util.Calendar;

/**
 * Calendar and days manipulator package. Not intended to be used out of package. Please construct and
 * use CountDays object instead.
 *
 * @author Danh Nguyen
 */
public class DaysEvaluatorCollection {

    // The core of this class is 2 calendar object
    protected Calendar start;
    protected Calendar end;
    protected int days_counted = 0;

    /**
     * Constructor requires 2 date in form of Calendar object
     *
     * @param start Calendar start date
     * @param end   Calendar end date
     */
    DaysEvaluatorCollection(Calendar start, Calendar end) {
        this.start = start;
        this.end = end;
        this.days_counted = countingDaysCache();
    }

    /**
     * Report the already-cached result
     *
     * @return Numbers of days between 2 dates
     */
    public int countingDays() {
        days_counted = countingDaysCache();
        return days_counted;
    }

    /**
     * Find the number of days in a year (only valid after October 15, 1582)
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

        for (int i = start_year + 1; i < end.get(Calendar.YEAR); i++) {
            total_day += getYearsDay(i);
        }

        return total_day;
    }

    /**
     * Count all the days between 2 dates, including the end point day. This function
     * actually cannot be called by the user. The output of this function will be cached
     * and used for error handling.<br><br>
     *
     * To access the total days, please use countDays().
     *
     * @return Total number of days
     */
    protected int countingDaysCache() {

        int start_year = start.get(Calendar.YEAR);
        int end_year = end.get(Calendar.YEAR);
        // If start_year is later than end_year, we don't support this
        if (start_year > end_year) {
            return -1;
        }

        // If they are the same year we find days-left difference
        if (start_year == end_year) {
            return end.get(Calendar.DAY_OF_YEAR) - start.get(Calendar.DAY_OF_YEAR);
        }

        // Else we add these up
        return daysLeft(start) + daysBetween() + end.get(Calendar.DAY_OF_YEAR);
    }

    public static void main(String[] args) {
        Calendar begin = Calendar.getInstance();
        begin.set(2019, Calendar.JANUARY, 1);
        Calendar today = Calendar.getInstance();
        today.set(2019, Calendar.FEBRUARY, 2);

        DaysEvaluatorCollection c = new DaysEvaluatorCollection(begin, today);

        System.out.println(c.countingDays());


    }
}
