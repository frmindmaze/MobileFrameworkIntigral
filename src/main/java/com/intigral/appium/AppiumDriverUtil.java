package com.intigral.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


import java.io.IOException;

public class AppiumDriverUtil {

        private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();
        LoggerReport logger = new LoggerReport();

        public AppiumDriver getDriver(){
            return driver.get();
        }

        public void setDriver(AppiumDriver setDriver){
            driver.set(setDriver);
        }

        public void initializeDriver() throws Exception {
            AppiumDriver driver = null;
            AppiumParams params = new AppiumParams();
            ConfigProperties props = new ConfigProperties();

            if(driver == null){
                try{
                    logger.log().info("initializing Appium driver");
                    switch(params.getPlatformName()){
                        case "Android":
                            driver = new AndroidDriver(new AppiumServer().getServer().getUrl(), new AppiumCapability().getCaps());
                            break;
                        case "iOS":
                            break;
                    }
                    if(driver == null){
                        throw new Exception("driver not found");
                    }
                    logger.log().info("Driver is initialized");
                    this.driver.set(driver);
                } catch (IOException e) {
                    e.printStackTrace();
                    logger.log().fatal("Driver initialization failed" + e.toString());
                    throw e;
                }
            }

        }

    }