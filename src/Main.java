import java.util.Calendar;

import days_old.*;
import days_old.evaluate_exceptions.*;

public class Main {

    public static int divByZero(int d) {
        return d/0;
    }

    public static void main(String[] args) throws EndDateExceedsBeginDateException, BeginningDateExceedsLimit {
        // int[] myNumbers = {1, 2, 3};
        // try {
        //     System.out.println(myNumbers[10]); // error!
        // }
        // catch (Exception ArrayIndexOutOfBoundsException) {
        //     System.out.println("wrong, u fool!");
        // }


        // System.out.println("hello!");
        // System.out.println(divByZero(10));

        Calendar begin = Calendar.getInstance();
        begin.set(2019, Calendar.JANUARY, 1);
        Calendar today = Calendar.getInstance();
        today.set(2019, Calendar.FEBRUARY, 2);

        CountDays a = new CountDays(begin, today);
        System.out.println(a.countingDays());

        String s = "2000-1-1";
        String[] tokens = s.split("-");
        System.out.println(tokens[2]);
        Calendar d = CountDays.dateParser("2000-11");

    }
}
