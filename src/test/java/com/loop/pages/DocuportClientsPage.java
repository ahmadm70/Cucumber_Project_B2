package com.loop.pages;

import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.*;

public class DocuportClientsPage extends DocuportBasePage {
    @FindBy(xpath = "//span//span[contains(.,'Create new client')]")
    public WebElement createNewClientButton;
    @FindBy(xpath = "//span[@class][contains(.,'Business')]")
    public WebElement businessClientDropdown;
    @FindBy(xpath = "//span[@class][contains(.,'Personal')]")
    public WebElement personalClientDropdown;
    @FindBy(xpath = "//label[contains(.,'Create new user')]")
    public WebElement createNewUserCheckbox;
    @FindBy(xpath = "//span[contains(.,'Save')]")
    public WebElement clientSaveButton;
    @FindBy(xpath = "//div[contains(.,'Must be at least 6 characters, including 1 uppercase and 1 number')]")
    public WebElement passwordTip;
    @FindBy(xpath = "//div[@class='d-flex align-start']//span[@class='body-1']")
    public WebElement validationMessage;
    @FindBy(xpath = "//span[contains(.,'Cancel')]")
    public WebElement cancelButton;

    public void fillInformation(String column, String information) {
        Driver.getDriver().findElement(By.xpath("//label[contains(.,'" + column + "')]//following-sibling::input")).sendKeys(information);
        if (column.equals("Advisor")) {
            Driver.getDriver().findElement(By.xpath("//div[@class='v-list-item__title'][contains(.,'" + information + "')]")).click();
        }
    }

    public void createClient(String userType, List<Map<String, String>> info) {
        createNewClientButton.click();
        BrowserUtilities.waitForClickable(businessClientDropdown, DocuportConstants.large);
        switch (userType.toLowerCase()) {
            case "business":
                businessClientDropdown.click();
                break;
            case "personal":
                personalClientDropdown.click();
                break;
        }
        BrowserUtilities.waitForClickable(createNewUserCheckbox, DocuportConstants.large);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", createNewUserCheckbox);
        BrowserUtilities.waitForVisibility(passwordTip, DocuportConstants.large);
        for (Map<String, String> each : info) {
            fillInformation(each.get("column"), each.get("information"));
        }
        clientSaveButton.click();
        BrowserUtilities.waitForVisibility(validationMessage, DocuportConstants.large);
        Assert.assertTrue(userType.toLowerCase() + " client creation failed!", validationMessage.isDisplayed());
        cancelButton.click();
    }
}