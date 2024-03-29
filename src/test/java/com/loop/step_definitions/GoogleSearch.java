package com.loop.step_definitions;

import com.loop.pages.GoogleSearchPage;
import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class GoogleSearch {
    private static final Logger LOG = LogManager.getLogger();
    GoogleSearchPage googleSearchPage;
    WebDriverWait wait;

    @Given("user is on Google Search page")
    public void user_in_on_google_search_page() {
        googleSearchPage = new GoogleSearchPage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        wait.until(ExpectedConditions.titleIs("Google"));
        LOG.info(".....User is on Google Search page.....");
    }

    @When("user types Loop Academy in the Google Search box and clicks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clicks_enter() {
        googleSearchPage.searchBar.sendKeys("Loop Academy");
        googleSearchPage.googleSearchButton.click();
        wait.until(ExpectedConditions.titleIs("Loop Academy - Google Search"));
        //BrowserUtilities.takeScreenshot();
    }

    @Then("user should see Loop Academy - Google Search in title")
    public void user_should_see_loop_academy_google_search_in_title() {
        Assert.assertEquals("Titles aren't matching!", "Loop Academy - Google Search", Driver.getDriver().getTitle());
        //BrowserUtilities.validateTitle(Driver.getDriver(), "Loop Academy - Google Search");
    }

    @When("user types {string} in the Google Search box and clicks enter")
    public void user_types_in_the_google_search_box_and_clicks_enter(String string) {
        googleSearchPage.searchBar.sendKeys(string);
        googleSearchPage.googleSearchButton.click();
        wait.until(ExpectedConditions.titleIs(string + " - Google Search"));
        //BrowserUtilities.takeScreenshot();
    }

    @Then("user should see {string} in title")
    public void user_should_see_in_title(String string) {
        Assert.assertEquals("Titles aren't matching!", Driver.getDriver().getTitle(), string);
    }

    @Then("user searches for the following item")
    public void user_searches_for_the_following_item(List<Map<String, String>> items) {
//        items.forEach(each -> {
//            googleSearchPage.searchBar.clear();
//            googleSearchPage.searchBar.sendKeys(each + Keys.ENTER);
//            Assert.assertEquals("Titles aren't matching!", each + " - Google Search", Driver.getDriver().getTitle());
//        });
        for (Map<String, String> each : items) {
            System.out.println(each.get("loop academy"));
            googleSearchPage.searchBar.clear();
            googleSearchPage.searchBar.sendKeys(each.get("loop academy") + Keys.ENTER);
        }
    }

    @When("user searches for the {string}")
    public void user_searches_for_the(String country) {
        googleSearchPage.searchBar.sendKeys("Capital of " + country + Keys.ENTER);
        BrowserUtilities.justWait(DocuportConstants.small);
    }

    @Then("user should see the {string} in the result")
    public void user_should_see_the_in_the_result(String capital) {
        Assert.assertEquals("Results aren't matching!", googleSearchPage.capitalResult.getText(), capital);
    }
}