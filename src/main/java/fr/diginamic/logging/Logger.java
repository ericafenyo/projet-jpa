package fr.diginamic.logging;

import java.util.HashSet;
import java.util.Set;

/**
 * Abstract class defining a basic logger structure.
 */
public class Logger {
    private final Set<Handler> handlers = new HashSet<>();
    private String tag = "";

    private void addHandler(Handler handler) {
        this.handlers.add(handler);
    }

    // Singleton instance
    private static Logger INSTANCE;

    // Private constructor to prevent instantiation from outside
    private Logger(Class<?> clazz) {
        this.tag = clazz.getSimpleName();
        addHandler(new DefaultLogger());
    }

    /**
     * Get the singleton instance of the Logger.
     *
     * @return The Logger instance.
     */
    public static Logger getInstance(Class<?> clazz) {

        if (INSTANCE == null) {
            INSTANCE = new Logger(clazz);
        }
        return INSTANCE;
    }

    /**
     * Get the singleton instance of the Logger.
     * This logger logs to a text file
     *
     * @return The Logger instance.
     */
    public static Logger fileLogger(Class<?> clazz) {
        FileLogger handler = new FileLogger();
        Logger logger = new Logger(clazz);
        logger.addHandler(handler);
        if (INSTANCE == null) {
            INSTANCE = logger;
        }
        return INSTANCE;
    }


    /**
     * Logs a debug message.
     *
     * @param message The message to be logged.
     */
    void debug(String message) {
        handlers.forEach(handler -> handler.log(tag, Level.DEBUG, message));
    }

    /**
     * Logs an informational message.
     *
     * @param message The message to be logged.
     */
    void info(String message) {
        handlers.forEach(handler -> handler.log(tag, Level.INFO, message));
    }

    /**
     * Logs a warning message.
     *
     * @param message The message to be logged.
     */
    void warning(String message) {
        handlers.forEach(handler -> handler.log(tag, Level.WARNING, message));
    }

    /**
     * Logs an error message.
     *
     * @param message The message to be logged.
     */
    void error(String message) {
        handlers.forEach(handler -> handler.log(tag, Level.ERROR, message));
    }

    /**
     * Enum defining log levels.
     */
    public enum Level {DEBUG, INFO, WARNING, ERROR}

    interface Handler {
        /**
         * Abstract method for logging.
         *
         * @param tag     The log tag.
         * @param level   The log level.
         * @param message The message to be logged.
         */
        void log(String tag, Level level, String message);
    }

    private static class DefaultLogger implements Handler {

        @Override
        public void log(String tag, Level level, String message) {

        }
    }
}
