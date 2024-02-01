package com.loop.step_definitions;

import com.loop.pages.DocuportClientsPage;
import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.Assert.*;

public class ClientSoftAssertions {
    DocuportClientsPage docuportClientsPage;
    DocuportLoginPage docuportLoginPage;
    WebDriverWait webDriverWait;
    private Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();

    @Given("User is on docuport login page")
    public void user_is_on_docuport_login_page() {
        docuportClientsPage = new DocuportClientsPage();
        docuportLoginPage = new DocuportLoginPage();
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(docuportLoginPage.loginButton));
    }

    @Then("User validates {string} text is displayed")
    public void user_validates_text_is_displayed(String loginText) {
        //assertEquals("Results aren't matching!", docuportLoginPage.getElementText(loginText), loginText);
        softAssertions.assertThat(docuportLoginPage.getElementText(loginText)).isEqualTo(loginText);
    }

//    @When("User enters credentials")
//    public void user_enters_credentials(io.cucumber.datatable.DataTable dataTable) {
//    }
//
//    @When("User validates {string} text is displayed")
//    public void user_validates_text_is_displayed(String string) {
//    }
//
//    @Then("User chooses account from dropdown")
//    public void user_chooses_account_from_dropdown() {
//    }
//
//    @Then("User clicks {string} button")
//    public void user_clicks_button(String string) {
//    }
}