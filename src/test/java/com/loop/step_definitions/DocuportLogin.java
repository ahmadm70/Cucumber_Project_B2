package com.loop.step_definitions;

import com.loop.pages.DocuportClientsPage;
import com.loop.pages.DocuportLoginPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Map;

public class DocuportLogin {
    DocuportLoginPage docuportLoginPage;
    DocuportClientsPage docuportClientsPage;
    WebDriverWait webDriverWait;
    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        docuportLoginPage = new DocuportLoginPage();
        docuportClientsPage = new DocuportClientsPage();
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(DocuportConstants.large));
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(docuportLoginPage.loginButton));
    }
    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {
        docuportLoginPage.usernameBar.sendKeys(DocuportConstants.USERNAME_FOR_ADVISOR);
    }
    @When("user enters username for client")
    public void user_enters_username_for_client() {
        docuportLoginPage.usernameBar.sendKeys(DocuportConstants.USERNAME_FOR_CLIENT);
    }
    @When("user enters username for employee")
    public void user_enters_username_for_employee() {
        docuportLoginPage.usernameBar.sendKeys(DocuportConstants.USERNAME_FOR_EMPLOYEE);
    }
    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {
        docuportLoginPage.usernameBar.sendKeys(DocuportConstants.USERNAME_FOR_SUPERVISOR);
    }
    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        docuportLoginPage.passwordBar.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
    }
    @When("user enters password for client")
    public void user_enters_password_for_client() {
        docuportLoginPage.passwordBar.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
    }
    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        docuportLoginPage.passwordBar.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
    }
    @When("user enters password for supervisor")
    public void user_enters_password_for_supervisor() {
        docuportLoginPage.passwordBar.sendKeys(DocuportConstants.PASSWORD_FOR_LOGIN);
    }
    @When("user clicks to login button")
    public void user_clicks_to_login_button() {
        docuportLoginPage.loginButton.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(docuportClientsPage.uploadButton));
    }
    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {
        Assert.assertTrue("You couldn't log in as an ADVISOR!", docuportClientsPage.uploadButton.isDisplayed());
    }
    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        Assert.assertEquals("You couldn't log in as a CLIENT!", "Choose account", docuportClientsPage.continueButton.getText());
    }
    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {
        Assert.assertTrue("You couldn't log in as an EMPLOYEE!", docuportClientsPage.uploadButton.isDisplayed());
    }
    @Then("user should see the home page for supervisor")
    public void user_should_see_the_home_page_for_supervisor() {
        Assert.assertTrue("You couldn't log in as an SUPERVISOR!", docuportClientsPage.uploadButton.isDisplayed());
    }
    @When("user enters credentials")
    public void user_enters_credentials(Map<String, String> map) {
//        for (Map.Entry<String, String> entry : map.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
        docuportLoginPage.loginDocuport(map.get("username"), map.get("password"));
    }
}