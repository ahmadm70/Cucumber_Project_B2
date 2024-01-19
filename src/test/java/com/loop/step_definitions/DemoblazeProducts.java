package com.loop.step_definitions;

import com.loop.pages.DemoblazePage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.*;

public class DemoblazeProducts {
    DemoblazePage demoblazePage;
    WebDriverWait webDriverWait;

    @Given("user is on the home page")
    public void user_is_on_the_home_page() {
        demoblazePage = new DemoblazePage();
        webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        Driver.getDriver().get(ConfigurationReader.getProperty("demoblaze.url"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(demoblazePage.previousButton));
    }

    @Then("user should be able to see expected prices in following products")
    public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String, String>> products) {
        for (Map<String, String> each : products) {
            demoblazePage.clickCategory(each.get("Category"));
            String actualPrice = demoblazePage.getPrice(each.get("Product"));
            String expectedPrice = "$" + each.get("Expected price");
            Assert.assertEquals("Prices aren't matching!", actualPrice, expectedPrice);
        }
    }
    @Then("user should be able to see expected prices in following products \\(as List<List<String>>)")
    public void user_should_be_able_to_see_expected_prices_in_following_products_as_list_list_string(List<List<String>> list) {
        for (List<String> each : list) {
            demoblazePage.clickCategory(each.getFirst());
            String actualPrice = demoblazePage.getPrice(each.get(1));
            String expectedPrice = "$" + each.get(2);
            Assert.assertEquals("Prices aren't matching!", actualPrice, expectedPrice);
        }
    }
    @Then("User should be able to see the following names in their groups")
    public void user_should_be_able_to_see_the_following_names_in_their_groups(Map<String, List<String>> map){
        List<String> group1 = map.get("Group 1");
        System.out.println(group1);
        List<String> group2 = map.get("Group 2");
        System.out.println(group2);
        List<String> group3 = map.get("Group 3");
        System.out.println(group3);
    }
}