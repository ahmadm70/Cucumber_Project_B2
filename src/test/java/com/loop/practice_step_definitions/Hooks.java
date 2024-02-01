package com.loop.practice_step_definitions;

import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    private static final Logger LOG = LogManager.getLogger();
    @Before
    public void setUp(Scenario scenario) {
        LOG.info(".....Start Automation.....");
        Driver.getDriver();
        BrowserUtilities.myScenario = scenario;
    }
    @After
    public void tearDown(Scenario scenario) {
        //Only takes screenshot when scenario is failed
        if (scenario.isFailed()) {
            final byte[] screenshots = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshots, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        LOG.info(".....End Automation.....");
    }
    //@AfterStep --> executes this body after every step
}