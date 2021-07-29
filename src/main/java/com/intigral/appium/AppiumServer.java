package com.intigral.appium;

import java.io.File;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServerHasNotBeenStartedLocallyException;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

public class AppiumServer {

    //***setting up and initiating the Appium server ***//


    private static ThreadLocal<AppiumDriverLocalService> server = new ThreadLocal<>();
    AppiumDriverUtil logger = new AppiumDriverUtil();

    public AppiumDriverLocalService getServer(){
        return server.get();
    }

    public void startServer(){
        logger.log().info("starting appium server");
        AppiumDriverLocalService server = WindowsGetAppiumService();
        server.start();
        if(server == null || !server.isRunning()){
            logger.log().fatal("Appium server failed to start");
            throw new AppiumServerHasNotBeenStartedLocallyException("Appium server failed to start");
        }
        this.server.set(server);
        logger.log().info("Appium server started");
    }

    public AppiumDriverLocalService getAppiumServerDefault() {
        return AppiumDriverLocalService.buildDefaultService();
    }

    public AppiumDriverLocalService WindowsGetAppiumService() {
        AppiumParams params = new AppiumParams();
        return AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                .usingAnyFreePort()
                .withArgument(GeneralServerFlag.SESSION_OVERRIDE)
                .withLogFile(new File(params.getPlatformName() + "_"
                        + params.getDeviceName() + File.separator + "Server.log")));
    }

}
