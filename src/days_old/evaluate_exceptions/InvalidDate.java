package days_old.evaluate_exceptions;

/**
 * This exception will be thrown when the parsed string is not a valid date
 */
public class InvalidDate extends Exception{
    public InvalidDate(String message) {
        super(message);
    }
}
