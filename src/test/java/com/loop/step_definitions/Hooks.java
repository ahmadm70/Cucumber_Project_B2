package com.loop.step_definitions;

import com.loop.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before
    public void setUp() {
        Driver.getDriver();
    }
    @After
    public void tearDown(Scenario scenario) {
        //Only takes screenshot when scenario is failed
        if (scenario.isFailed()) {
            final byte[] screenshots = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshots, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
    //@AfterStep --> executes this body after every step
}