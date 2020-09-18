import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import days_old.*;
import days_old.evaluate_exceptions.*;

public class Main {

    public static int divByZero(int d) {
        return d/0;
    }

    public static void main(String[] args) throws EndDateExceedsBeginDateException, InvalidDate, BeginningDateExceedsLimit, ParseException {
        Calendar begin = Calendar.getInstance();
        begin.set(2300, Calendar.DECEMBER, 12);

        CountDays c = new CountDays(begin, Calendar.getInstance());
        System.out.println(c.countingDays());
    }
}
