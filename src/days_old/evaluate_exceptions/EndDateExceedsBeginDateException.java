package days_old.evaluate_exceptions;

/**
 * Exception thrown when the end date is earlier than the beginning date when construct CountDays object
 */
public class EndDateExceedsBeginDateException extends Exception {
    public EndDateExceedsBeginDateException(String message) {
        super(message);
    }
}
