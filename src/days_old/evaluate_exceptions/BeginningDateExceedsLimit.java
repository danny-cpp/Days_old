package days_old.evaluate_exceptions;

/**
 * This exception is thrown when the beginning date is earlier than October 15, 1582.
 */
public class BeginningDateExceedsLimit extends Exception {
    public BeginningDateExceedsLimit(String message) {
        super(message);
    }
}
