package nl.gmt.rollbase.logging;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.AppenderBase;
import org.apache.commons.lang3.Validate;

import java.io.PrintStream;

/**
 * A Logback appender that redirects log messages to System.out or System.err
 * based on the logging level threshold.
 */
public class RedirectAppender extends AppenderBase<ILoggingEvent> {
    private static Level level = Level.WARN;

    /**
     * Sets the minimum logging level for this appender.
     * 
     * @param level the minimum level to log
     */
    public static void setLevel(Level level) {
        Validate.notNull(level, "level");
        RedirectAppender.level = level;
    }

    @Override
    protected void append(ILoggingEvent event) {
        if (event.getLevel().toInt() >= level.toInt()) {
            PrintStream out;

            if (event.getLevel().toInt() >= Level.WARN.toInt()) {
                out = System.err;
            } else {
                out = System.out;
            }

            out.println(String.format("[%s] %s (%s)", 
                event.getLevel(), 
                event.getFormattedMessage(), 
                event.getLoggerName()));
        }
    }
}
