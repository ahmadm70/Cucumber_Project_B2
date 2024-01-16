package com.loop.step_definitions;

import com.loop.pages.SmartBearLoginPage;
import com.loop.pages.SmartBearOrderPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import com.loop.utilities.GeneralConstants;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SmartBearOrder {
    SmartBearLoginPage smartBearLoginPage;
    SmartBearOrderPage smartBearOrderPage;
    WebDriverWait webDriverWait;
    Select select;

    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        smartBearLoginPage = new SmartBearLoginPage();
        smartBearOrderPage = new SmartBearOrderPage();
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigurationReader.getProperty("smartbear.url"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(smartBearLoginPage.loginButton));
        smartBearLoginPage.login(GeneralConstants.SMART_BEAR_SOFTWARE_USERNAME, GeneralConstants.SMART_BEAR_SOFTWARE_PASSWORD);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(smartBearOrderPage.orderLink));
        smartBearOrderPage.orderLink.click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(smartBearOrderPage.processButton));
    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) {
        select = new Select(smartBearOrderPage.productDropdown);
        select.selectByVisibleText(productType);
    }

    @When("user enters quantity {int}")
    public void user_enters_quantity(int quantity) {
        smartBearOrderPage.quantityBar.clear();
        smartBearOrderPage.quantityBar.sendKeys("" + quantity);
        smartBearOrderPage.calculateButton.click();
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String customerName) {
        smartBearOrderPage.customerNameBar.sendKeys(customerName);
    }

    @When("user enters street {string}")
    public void user_enters_street(String street) {
        smartBearOrderPage.streetBar.sendKeys(street);
    }

    @When("user enters city {string}")
    public void user_enters_city(String city) {
        smartBearOrderPage.cityBar.sendKeys(city);
    }

    @When("user enters state {string}")
    public void user_enters_state(String state) {
        smartBearOrderPage.stateBar.sendKeys(state);
    }

    @When("user enters zip {string}")
    public void user_enters_zip(String zip) {
        smartBearOrderPage.zipBar.sendKeys(zip);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {
        switch (cardType) {
            case "Visa":
                smartBearOrderPage.visaRadioButton.click();
                break;
            case "MasterCard":
                smartBearOrderPage.masterCardRadioButton.click();
                break;
            case "American Express":
                smartBearOrderPage.americanExpressRadioButton.click();
        }
    }

    @When("user enters credit car number {string}")
    public void user_enters_credit_car_number(String cardNumber) {
        smartBearOrderPage.cardNumberBar.sendKeys(cardNumber);
    }

    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String expirationDate) {
        smartBearOrderPage.expireDateBar.sendKeys(expirationDate);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {
        smartBearOrderPage.processButton.click();
    }

    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String name) {
        smartBearOrderPage.viewAllOrdersLink.click();
        Assert.assertEquals("Names aren't matching!", smartBearOrderPage.recentAddedNameToTable.getText(), name);
    }
}