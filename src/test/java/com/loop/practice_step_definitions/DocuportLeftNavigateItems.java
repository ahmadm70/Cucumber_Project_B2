package com.loop.practice_step_definitions;

import com.loop.practice_pages.DocuportHomePage;
import com.loop.practice_pages.DocuportLoginPage;
import com.loop.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class DocuportLeftNavigateItems {
    DocuportLoginPage docuportLoginPage;
    DocuportHomePage docuportHomePage;
    WebDriverWait webDriverWait;

    @Given("User navigates to Docuport webpage")
    public void user_navigates_to_docuport_webpage() {
        docuportLoginPage = new DocuportLoginPage();
        docuportHomePage = new DocuportHomePage();
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(docuportLoginPage.loginButton));
    }

    @When("User logs in as {string}")
    public void user_logs_in_as(String userType) {
        switch (userType.toLowerCase()) {
            case "advisor":
                docuportLoginPage.loginDocuport(DocuportConstants.USERNAME_FOR_ADVISOR, DocuportConstants.PASSWORD_FOR_LOGIN);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(docuportHomePage.uploadButton));
                break;
            case "client":
                docuportLoginPage.loginDocuport(DocuportConstants.USERNAME_FOR_CLIENT, DocuportConstants.PASSWORD_FOR_LOGIN);
                BrowserUtilities.justWait(3000);
                docuportHomePage.continueButton.click();
                webDriverWait.until(ExpectedConditions.elementToBeClickable(docuportHomePage.uploadButton));
                break;
            case "employee":
                docuportLoginPage.loginDocuport(DocuportConstants.USERNAME_FOR_EMPLOYEE, DocuportConstants.PASSWORD_FOR_LOGIN);
                webDriverWait.until(ExpectedConditions.elementToBeClickable(docuportHomePage.uploadButton));
                break;
            case "supervisor":
                docuportLoginPage.loginDocuport(DocuportConstants.USERNAME_FOR_SUPERVISOR, DocuportConstants.PASSWORD_FOR_LOGIN);
                webDriverWait.until(ExpectedConditions.visibilityOf(docuportHomePage.homeButton));
                break;
        }
    }

    @Then("These {string} should be at the left navigation bar")
    public void these_should_be_at_the_left_navigation_bar(String items) {
        List<String> itemsList = Arrays.asList(items.split(", "));
        for (int i = 0; i < itemsList.size(); i++) {
            Assert.assertEquals("Left navigation items aren't matching!", itemsList.get(i), docuportHomePage.leftNavigateItems.get(i).getText());
        }
    }
}