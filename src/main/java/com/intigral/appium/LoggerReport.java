package com.intigral.appium;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
public class LoggerReport{

    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    }
}
