package com.intigral.appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.screenrecording.CanRecordScreen;
import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class AppiumDriverUtil {
    public static final long WAIT = 10;

    public Logger log() {
        return LogManager.getLogger(Thread.currentThread().getStackTrace()[1].getClassName());
    }


    //***To initiate the driver based on the capability set***//

    private static ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

    public AppiumDriver getDriver() {
        return driver.get();
    }

    public void setDriver(AppiumDriver setDriver) {
        driver.set(setDriver);
    }

    public void initializeDriver() throws Exception {
        AppiumDriver driver = null;
        AppiumParams params = new AppiumParams();
        ConfigProperties props = new ConfigProperties();

        if (driver == null) {
            try {
                log().info("initializing Appium driver");
                switch (params.getPlatformName()) {
                    case "Android":
                        driver = new AndroidDriver(new AppiumServer().getServer().getUrl(), new AppiumCapability().getCaps());
                        break;
                    case "iOS":
                        break;
                }
                if (driver == null) {
                    throw new Exception("driver not found");
                }
                log().info("Driver is initialized");
                this.driver.set(driver);
            } catch (IOException e) {
                e.printStackTrace();
                log().fatal("Driver initialization failed" + e.toString());
                throw e;
            }
        }

    }


//***To capture video while running scenarios ***//


    public void initiateRecording() {
        ((CanRecordScreen) new AppiumDriverUtil().getDriver()).startRecordingScreen();
    }

    public void exitRecording(String scenarioName) throws IOException {
        AppiumParams params = new AppiumParams();
        String media = ((CanRecordScreen) new AppiumDriverUtil().getDriver()).stopRecordingScreen();
        String dirPath = params.getPlatformName() + "_"
                + params.getDeviceName() + File.separator + "VideosRecordings";

        File videoFolder = new File(dirPath);

        synchronized (videoFolder) {
            if (!videoFolder.exists()) {
                videoFolder.mkdirs();
            }
        }
        FileOutputStream stream = null;
        try {
            stream = new FileOutputStream(videoFolder + File.separator + scenarioName + ".mp4");
            stream.write(Base64.decodeBase64(media));
            stream.close();
            log().info("video location: " + videoFolder + File.separator + scenarioName + ".mp4");
        } catch (Exception e) {
            log().error("error during video capture" + e.toString());
        } finally {
            if (stream != null) {
                stream.close();
            }
        }

    }
}