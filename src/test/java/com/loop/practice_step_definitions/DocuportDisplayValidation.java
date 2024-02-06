package com.loop.practice_step_definitions;

import com.loop.practice_pages.DocuportHomePage;
import com.loop.practice_pages.DocuportLoginPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class DocuportDisplayValidation {
    DocuportHomePage docuportHomePage;
    DocuportLoginPage docuportLoginPage;

    public DocuportDisplayValidation() {
        docuportHomePage = new DocuportHomePage();
        docuportLoginPage = new DocuportLoginPage();
    }

    @Given("Login as {string}")
    public void login_as(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        docuportLoginPage.loginDocuport(userType);
    }

    @When("Click on {string}")
    public void click_on(String navigateItem) {
        docuportHomePage.goToLink(navigateItem);
    }

    @Then("Validate that items are displayed")
    public void validate_that_items_are_displayed() {
        Assert.assertTrue("Search button isn't displayed!", docuportHomePage.searchButton.isDisplayed());
        Assert.assertTrue("Download button isn't displayed!", docuportHomePage.downloadButton.isDisplayed());
        Assert.assertTrue("Page header isn't displayed!", docuportHomePage.pageHeader.isDisplayed());
    }
}