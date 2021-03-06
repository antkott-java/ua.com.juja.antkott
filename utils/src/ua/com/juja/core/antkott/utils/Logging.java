package ua.com.juja.core.antkott.utils;

import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.StreamHandler;

public class Logging {

    private static Logger LOGGER;
    private static boolean loggingInTest=false;

    static {
        System.setProperty("java.util.logging.SimpleFormatter.format",
                "[%1$tF %1$tT] [%4$-7s] %5$s %n");
        String className = Thread.currentThread().getStackTrace()[0].getClassName();
        LOGGER = Logger.getLogger(className);
        LOGGER.setUseParentHandlers(false);
        SimpleFormatter fmt = new SimpleFormatter();
        StreamHandler sh = new StreamHandler(System.out, fmt);
        LOGGER.addHandler(sh);
    }


    public static void logInfo(String message) {
        LOGGER.info(message);
    }

    public static void logTest(String message) {
        if (loggingInTest) {
            LOGGER.info(message);
        }
    }

}
