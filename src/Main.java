import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        System.out.println("hello!");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2020);
        System.out.println("day of year is: " + cal.getActualMaximum(Calendar.DAY_OF_YEAR));
    }
}
