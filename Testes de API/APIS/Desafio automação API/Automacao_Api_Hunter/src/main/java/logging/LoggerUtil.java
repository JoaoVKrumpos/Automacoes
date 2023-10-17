package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class LoggerUtil {

    private static final Logger logger = (Logger) LogManager.getLogger(LoggerUtil.class);

    public static void info(String message){
        logger.info(message);


    }

    public static void error(String message ,Throwable throwable){
        logger.error(message,throwable);
    }
}
