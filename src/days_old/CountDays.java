package days_old;

import java.util.Calendar;

class MyException extends Exception {

}

/**
 *
 */
public class CountDays extends DaysEvaluatorCollection {

    /**
     * Constructor requires 2 date in form of Calendar object
     *
     * @param start Calendar start date
     * @param end   Calendar end date
     */
    public CountDays(Calendar start, Calendar end) throws EndDateExceedsBeginDateException {
        super(start, end);
        days_counted = countingDaysCache();
        if (days_counted < 0) {
            throw new EndDateExceedsBeginDateException("sth");
        }
    }

}
