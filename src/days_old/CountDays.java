package days_old;

import days_old.evaluate_exceptions.BeginningDateExceedsLimit;
import days_old.evaluate_exceptions.EndDateExceedsBeginDateException;

import java.util.Calendar;

/**
 * This class main goal is to find the days difference between 2 date. Come along with that is a string-to-date parser,
 * and an automatic unit tester. The suite contains 3 main functions:
 */
public class CountDays extends DaysEvaluatorCollection {

    /**
     * Constructor requires 2 date in form of Calendar object. End date cannot be earlier than beginning date.
     * Beginning date cannot be earlier than October 15, 1582 (not supported non-Gregorian calendar).
     *
     * @param start Calendar start date
     * @param end   Calendar end date
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


    public static Calendar dateParser(String s) {
        // It is extremely important to verify the legitimacy of the input. Is it a meaningful date?

        // If it can't parse to 3 pieces, it fails
        String[] tmp = s.split("-");
        if (tmp.length != 3) {
            System.out.println("invalid");
        }
        return Calendar.getInstance();
    }
}
