package com.loop.practice_step_definitions;

import com.loop.practice_pages.DocuportHomePage;
import com.loop.practice_pages.DocuportLoginPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;

public class DocuportRowsFunctionality {
    DocuportHomePage docuportHomePage;
    DocuportLoginPage docuportLoginPage;

    public DocuportRowsFunctionality() {
        docuportHomePage = new DocuportHomePage();
        docuportLoginPage = new DocuportLoginPage();
    }

    @Given("user logs in as an {string}")
    public void user_logs_in_as_an(String userType) {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        docuportLoginPage.loginDocuport(userType);
    }

    @When("user clicks to {string}")
    public void user_clicks_to(String navigateItem) {
        docuportHomePage.goToLink(navigateItem);
    }

    @When("user validates that rows per page is {int} by default")
    public void user_validates_that_rows_per_page_is_by_default(int rowsByDefault) {
        docuportHomePage.validateRowsPerPage(rowsByDefault);
    }

    @When("user changes rows per page to {int}")
    public void user_changes_rows_per_page_to(int rowsPerPageNum) {
        docuportHomePage.changeRowsPerPage(rowsPerPageNum);
    }

    @Then("user validates that rows per page is {int} now")
    public void user_validates_that_rows_per_page_is_now(int rowsPerPageNow) {
        docuportHomePage.validateRowsPerPage(rowsPerPageNow);
    }
}