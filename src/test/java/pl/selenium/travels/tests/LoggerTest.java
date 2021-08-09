package pl.selenium.travels.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerTest {

    public static void main(String[] args) {
        Logger logger = LogManager.getLogger();
        logger.info("Info");
        logger.error("Error");
        logger.warn("Warn");
        logger.debug("Debug");
        logger.fatal("Fatal");
        logger.fatal("Trace");

    }
}
