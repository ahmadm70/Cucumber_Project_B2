package com.loop.practice_step_definitions;

import com.loop.practice_pages.Wikipedia;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WikipediaSearch {
    Wikipedia wikipediaHomePage;
    WebDriverWait webDriverWait;

    @Given("user is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        wikipediaHomePage = new Wikipedia();
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigurationReader.getProperty("wikipedia.url"));
        webDriverWait.until(ExpectedConditions.titleIs("Wikipedia, the free encyclopedia"));
    }

    @When("user types {string} in the wiki search box")
    public void user_types_steve_jobs_in_the_wiki_search_box(String str) {
        wikipediaHomePage.searchBar.sendKeys(str);
    }

    @When("user clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        wikipediaHomePage.searchButton.click();
    }

    @Then("user sees {string} is in the wiki title")
    public void user_sees_steve_jobs_is_in_the_wiki_title(String str) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(wikipediaHomePage.topButton));
        Assert.assertEquals("Titles aren't matching!", Driver.getDriver().getTitle(), str + " - Wikipedia");
    }

    @Then("user sees {string} is in the main header")
    public void user_sees_steve_jobs_is_in_the_main_header(String str) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(wikipediaHomePage.topButton));
        Assert.assertEquals("Main headers aren't matching!", wikipediaHomePage.mainHeader.getText(), str);
    }

    @Then("user sees {string} is in the image header")
    public void user_sees_steve_jobs_is_in_the_image_header(String str) {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(wikipediaHomePage.topButton));
        Assert.assertEquals("Titles aren't matching!", wikipediaHomePage.imageHeader.getText(), str);
    }
}