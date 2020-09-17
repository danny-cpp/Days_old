import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import days_old.*;

public class Main {

    public static int divByZero(int d) {
        return d/0;
    }

    public static void main(String[] args) throws EndDateExceedsBeginDateException {
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
        begin.set(2019, Calendar.FEBRUARY, 1);
        Calendar today = Calendar.getInstance();
        today.set(2019, Calendar.JANUARY, 1);
        CountDays a = new CountDays(begin, today);

    }
}
