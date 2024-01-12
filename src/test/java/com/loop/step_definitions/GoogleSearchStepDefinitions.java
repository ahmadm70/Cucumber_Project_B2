package com.loop.step_definitions;

import com.loop.pages.GoogleSearchPage;
import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class GoogleSearchStepDefinitions {
    GoogleSearchPage googleSearchPage;
    WebDriverWait wait;
    @Given("user is on Google Search page")
    public void user_in_on_google_search_page() {
        googleSearchPage = new GoogleSearchPage();
        wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigurationReader.getProperty("google.url"));
        wait.until(ExpectedConditions.titleIs("Google"));
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
    @Then("user searchs for the following item")
    public void user_searchs_for_the_following_item(List<String> items) {
        items.forEach(each -> {
            googleSearchPage.searchBar.clear();
            googleSearchPage.searchBar.sendKeys(each + Keys.ENTER);
            Assert.assertEquals("Titles aren't matching!", each + " - Google Search", Driver.getDriver().getTitle());
        });
    }
}