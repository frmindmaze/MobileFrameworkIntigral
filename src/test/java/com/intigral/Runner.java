package com.intigral;

import com.intigral.appium.AppiumDriverUtil;
import com.intigral.appium.AppiumParams;
import com.intigral.appium.AppiumServer;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.apache.logging.log4j.ThreadContext;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import static io.cucumber.junit.CucumberOptions.SnippetType.CAMELCASE;


@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty"
                , "html:target/cucumber/report.html"
                , "summary"
                , "de.monochromata.cucumber.report.PrettyReports:target/cucumber-html-reports"}
        ,features = {"src/test/resources/features"}
        ,glue = {"com.intigral.stepdefs"}
        ,snippets = CAMELCASE
        ,dryRun=false
        ,monochrome=true
        ,strict=true
        ,tags = "@test"

)

public class Runner {

    @BeforeClass
    public static void initialize() throws Exception {
        AppiumParams params = new AppiumParams();
        params.initializeAppiumParams();
        ThreadContext.put("ROUTINGKEY", params.getPlatformName() + "_"
                + params.getDeviceName());
        new AppiumServer().startServer();
        new AppiumDriverUtil().initializeDriver();
    }

    @AfterClass
    public static void quit(){
        AppiumDriverUtil driverManager = new AppiumDriverUtil();
        if(driverManager.getDriver() != null){
            driverManager.getDriver().quit();
            driverManager.setDriver(null);
        }
        AppiumServer serverManager = new AppiumServer();
        if(serverManager.getServer() != null){
            serverManager.getServer().stop();
        }
    }
}