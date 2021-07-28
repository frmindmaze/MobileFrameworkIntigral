package com.intigral.appium;

import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

public class AppiumCapability {

    public DesiredCapabilities getCaps() throws IOException {
        AppiumParams params = new AppiumParams();
        Properties prop = new ConfigProperties().getProp();
        LoggerReport logger = new LoggerReport();
        try {
            logger.log().info("getting capabilities");
            org.openqa.selenium.remote.DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability(MobileCapabilityType.PLATFORM_NAME, params.getPlatformName());
            caps.setCapability(MobileCapabilityType.UDID, params.getUDID());
            caps.setCapability(MobileCapabilityType.DEVICE_NAME, params.getDeviceName());

            switch (params.getPlatformName()) {
                case "Android":
                    caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, prop.getProperty("androidAutomationName"));
                    caps.setCapability("appPackage", prop.getProperty("androidAppPackage"));
                    caps.setCapability("appActivity", prop.getProperty("androidAppActivity"));
                    caps.setCapability("systemPort", params.getSystemPort());
                    caps.setCapability("chromeDriverPort", params.getChromePort());
                    //String androidAppUrl = getClass().getResource(props.getProperty("androidAppLocation")).getFile();
                    String androidAppUrl = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
                            + File.separator + "resources" + File.separator + "mobileapps" + File.separator + prop.getProperty("Appname");
                    logger.log().info("appUrl is" + androidAppUrl);
                    caps.setCapability("app", androidAppUrl);
                    break;
                case "iOS":

            }
            return caps;
        } catch (Exception e) {
            e.printStackTrace();
            logger.log().fatal("Failed to load capabilities" + e.toString());
            throw e;
        }
    }
}
