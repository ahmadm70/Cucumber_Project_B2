package com.loop.practice_step_definitions;

import com.loop.practice_pages.DocuportHomePage;
import com.loop.practice_pages.DocuportLoginPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class DocuportDisplayValidationV2 {
    DocuportHomePage docuportHomePage;
    DocuportLoginPage docuportLoginPage;

    public DocuportDisplayValidationV2() {
        docuportHomePage = new DocuportHomePage();
        docuportLoginPage = new DocuportLoginPage();
    }

    @Given("Login as {string} V2")
    public void login_as_V2(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        docuportLoginPage.loginDocuport(userType);
    }

    @When("Click on left navigate items and validate that items are displayed")
    public void click_on_left_navigate_items_and_validate_that_items_are_displayed() {
        for (WebElement each : docuportHomePage.leftNavigateItems) {
            switch (each.getText().toLowerCase()) {
                case "home":
                case "reconciliations":
                    break;
                case "received docs":
                case "my uploads":
                    each.click();
                    Assert.assertTrue("Search button for \"" + each + "\" page isn't displayed!", docuportHomePage.searchButton.isDisplayed());
                    Assert.assertTrue("Download button for \"" + each + "\" page isn't displayed!", docuportHomePage.downloadButton.isDisplayed());
                    Assert.assertTrue("Page header button for \"" + each + "\" page isn't displayed!", docuportHomePage.pageHeader.isDisplayed());
                    break;
                default:    //Clients, Invitations, Users, Leads, Bookkeeping, 1099 Form pages don't have "Download" button
                    each.click();
                    Assert.assertTrue("Search button for \"" + each + "\" page isn't displayed!", docuportHomePage.searchButton.isDisplayed());
                    Assert.assertTrue("Page header button for \"" + each + "\" page isn't displayed!", docuportHomePage.pageHeader.isDisplayed());
                    break;
            }
        }
    }
}