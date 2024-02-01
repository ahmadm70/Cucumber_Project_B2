package com.loop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html_reports/cucumber_report.html", "json:target/json_reports/cucumber_report.json",
                "rerun:target/rerun.txt", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/practice_features",
        glue = "com/loop/practice_step_definitions",
        dryRun = false,
        tags = "@wip",
        monochrome = true,
        publish = false
)

public class CukesRunner {
}