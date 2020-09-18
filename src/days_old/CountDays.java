package days_old;

import days_old.evaluate_exceptions.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * This class main goal is to find the days difference between 2 date.
 */
public class CountDays extends DaysEvaluatorCollection {

    /**
     * Constructor requires 2 date in form of Calendar object. End date cannot be earlier than beginning date.
     * Beginning date cannot be earlier than October 15, 1582 (not supported non-Gregorian calendar).
     *
     * @param start Calendar start date
     * @param end   Calendar end date
     * @throws EndDateExceedsBeginDateException End date cannot be earlier than beginning date
     * @throws BeginningDateExceedsLimit The beginning date cannot be earlier than October 15, 1582
     */
    public CountDays(Calendar start, Calendar end) throws EndDateExceedsBeginDateException, BeginningDateExceedsLimit {
        super(start, end);

        // Check the beginning date if it satisfies the condition
        Calendar begin_limiter = Calendar.getInstance();
        begin_limiter.set(1582, Calendar.OCTOBER, 15);
        int start_check = new DaysEvaluatorCollection(begin_limiter, start).countingDaysCache();
        if (start_check < 0) {
            throw new BeginningDateExceedsLimit("The beginning date cannot be earlier than October 15, 1582");
        }

        // Check the end date if it satisfies the condition. Also, the main result is cached
        days_counted = countingDaysCache();
        if (days_counted < 0) {
            throw new EndDateExceedsBeginDateException("End date cannot be earlier than beginning date");
        }
    }

    /**
     * Report the number of days between 2 date
     *
     * @return Days difference
     */
    @Override
    public int countingDays() {
        return super.countingDays();
    }

    /**
     * Parsing the input string of the following format to a calendar object
     * @param s Input date in the format "yyyy-MM-dd". Date parse must be A.D.
     * @return
     * @throws InvalidDate     Input date does not exist
     * @throws ParseException  Meaningless string
     */
    public static Calendar dateParser(String s) throws InvalidDate, ParseException {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String[] tmp = s.split("-");

        // If the user input a negative year
        try {
            Integer.parseInt(tmp[0]);
        }
        catch (Exception NumberFormatException) {
            throw new InvalidDate("Cannot accept B.C. date");
        }

        // Set the date
        cal.setTime(sdf.parse(s));

        // Check the validity of the month
        if (!( Integer.parseInt(tmp[1]) >= 1 && Integer.parseInt(tmp[1]) <= 12)) {
            throw new InvalidDate("Date does not exist");
        }

        // Check the validity of the day, remember we can have either 30, 31, 28, or 29 days
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]) - 1, 1);
        int max_day = cal2.getActualMaximum(Calendar.DAY_OF_MONTH);
        if (Integer.parseInt(tmp[2]) < 1 || Integer.parseInt(tmp[2]) > max_day) {
            throw new InvalidDate("Date does not exist");
        }

        // Finalize
        cal2.set(Integer.parseInt(tmp[0]), Integer.parseInt(tmp[1]) - 1, Integer.parseInt(tmp[2]));

        return cal2;
    }
}
