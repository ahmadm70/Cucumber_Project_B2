package com.loop.practice_step_definitions;

import com.loop.pages.DocuportClientsPage;
import com.loop.practice_pages.DocuportLoginPage;
import com.loop.utilities.*;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class DocuportClientCreate {
    DocuportLoginPage docuportLoginPage;
    DocuportClientsPage docuportClientsPage;
    WebDriverWait webDriverWait;
    private String fullName;
    private String email;
    private String password;

    public DocuportClientCreate() {
        docuportLoginPage = new DocuportLoginPage();
        docuportClientsPage = new DocuportClientsPage();
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(DocuportConstants.large));
    }

    @Given("User logs in as an advisor and clicks on the {string} link")
    public void user_logs_in_as_an_advisor_and_clicks_on_the_link(String link) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        BrowserUtilities.waitForClickable(docuportLoginPage.loginButton, DocuportConstants.large);
        docuportLoginPage.loginDocuport(DocuportConstants.USERNAME_FOR_ADVISOR, DocuportConstants.PASSWORD_FOR_LOGIN);
        BrowserUtilities.waitForClickable(docuportClientsPage.uploadButton, DocuportConstants.large);
        docuportClientsPage.goToLink(link);
        BrowserUtilities.waitForVisibility(docuportClientsPage.footerTotalResults, DocuportConstants.large);
    }

    @When("User creates a new {string} client with the following data:")
    public void user_creates_a_new_client_with_the_following_data(String userType, List<Map<String, String>> info) {
        docuportClientsPage.createClient(userType, info);
        switch (userType.toLowerCase()) {
            case "business":
                fullName = info.get(1).get("information") + " " + info.get(2).get("information");
                email = info.get(3).get("information");
                password = info.get(6).get("information");
                break;
            case "personal":
                fullName = info.get(0).get("information") + " " + info.get(1).get("information");
                email = info.get(2).get("information");
                password = info.get(5).get("information");
        }
    }

    @When("User validates the new {string} client and logs out as an advisor")
    public void user_validates_the_new_client_and_logs_out_as_an_advisor(String userType) {
        DatabaseUtilities.createConnection();
        DatabaseUtilities.runQuery("select * from document.clients where email_address = '" + email + "';");
        Assert.assertEquals(userType.toLowerCase() + " client validation failed!", 1, DatabaseUtilities.getRowCount());
        docuportLoginPage.logoutDocuport();
        BrowserUtilities.waitForClickable(docuportLoginPage.loginButton, DocuportConstants.large);
    }

    @Then("Users should be able to log in as the new {string} client")
    public void users_should_be_able_to_log_in_as_the_new_client(String userType) {
        docuportLoginPage.loginDocuport(email, password);
        BrowserUtilities.waitForClickable(docuportClientsPage.termsAndConditionsLink, DocuportConstants.large);
        Assert.assertTrue("Login as a new " + userType.toLowerCase() + " client failed!", docuportClientsPage.termsAndConditionsLink.isDisplayed());
        docuportLoginPage.logoutDocuport(fullName);
        DatabaseUtilities.runQuery("delete from document.clients where email_address = '" + email + "';");
        DatabaseUtilities.runQuery("delete from document.users where email_address = '" + email + "';");
        DatabaseUtilities.destroy();
    }
}