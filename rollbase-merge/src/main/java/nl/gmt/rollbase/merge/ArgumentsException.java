package nl.gmt.rollbase.merge;

/**
 * Exception thrown when command-line arguments are invalid or incomplete.
 * <p>
 * This exception is used to signal issues with the arguments provided to the
 * Rollbase merge tool, such as missing required arguments, invalid argument values,
 * or unexpected argument combinations.
 * 
 * @author Rollbase Utils Contributors
 * @since 0.3
 */
public class ArgumentsException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new ArgumentsException with no detail message.
     */
    public ArgumentsException() {
        super();
    }

    /**
     * Constructs a new ArgumentsException with the specified detail message.
     *
     * @param message the detail message explaining the reason for the exception
     */
    public ArgumentsException(String message) {
        super(message);
    }

    /**
     * Constructs a new ArgumentsException with the specified detail message and cause.
     *
     * @param message the detail message
     * @param cause the cause of this exception
     */
    public ArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs a new ArgumentsException with the specified cause.
     *
     * @param cause the cause of this exception
     */
    public ArgumentsException(Throwable cause) {
        super(cause);
    }

    /**
     * Constructs a new ArgumentsException with the specified detail message, cause,
     * suppression enabled or disabled, and writable stack trace enabled or disabled.
     *
     * @param message the detail message
     * @param cause the cause
     * @param enableSuppression whether suppression is enabled
     * @param writableStackTrace whether the stack trace should be writable
     */
    public ArgumentsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
