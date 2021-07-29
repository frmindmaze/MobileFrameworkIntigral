package com.intigral.stepdefs;

import com.intigral.appium.AppiumDriverUtil;
import com.intigral.appium.AppiumServer;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;

import java.io.IOException;

public class Hooks {

    @Before
    public void initialize() throws Exception {
        new AppiumDriverUtil().initiateRecording();

    }

    @After
    public void quit(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            byte[] screenshot = new AppiumDriverUtil().getDriver().getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        new AppiumDriverUtil().exitRecording(scenario.getName());

    }
}
