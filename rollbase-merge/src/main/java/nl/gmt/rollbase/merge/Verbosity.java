package nl.gmt.rollbase.merge;

/**
 * Represents the verbosity level for logging output.
 * <p>
 * Controls how much information is displayed during tool execution:
 * <ul>
 *   <li>WARN - Only warnings and errors (default)</li>
 *   <li>INFO - Informational messages, warnings, and errors</li>
 *   <li>DEBUG - Detailed debugging information including all of the above</li>
 * </ul>
 */
public enum Verbosity {
    /**
     * Display only warnings and errors (default level).
     */
    WARN,
    
    /**
     * Display informational messages, warnings, and errors.
     */
    INFO,
    
    /**
     * Display detailed debugging information including all messages.
     */
    DEBUG
}
