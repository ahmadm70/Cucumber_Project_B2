package com.loop.pages;

import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportLoginPage extends DocuportBasePage {
    @FindBy(xpath = "//h1[contains(.,'Login')]")
    public WebElement loginText;
    @FindBy(id = "input-14")
    public WebElement usernameBar;
    @FindBy(id = "input-15")
    public WebElement passwordBar;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement continueButton;
    @FindBy(xpath = "//span//span[contains(.,'Batch1 Group2')]")
    public WebElement batch1Group2Button;
    @FindBy(xpath = "//span[contains(.,'Log out')]")
    public WebElement logoutButton;

    public DocuportLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    /**
     * Logins to Docuport
     *
     * @param username
     * @param password
     * @author Ahmad
     */
    public void loginDocuport(String username, String password) {
        BrowserUtilities.waitForVisibility(usernameBar, DocuportConstants.small);
        usernameBar.clear();
        usernameBar.sendKeys(username);
        passwordBar.clear();
        passwordBar.sendKeys(password);
        loginButton.click();
        if (continueButton.isDisplayed()) {
            continueButton.click();
        }
    }

    public void logoutDocuport() {
        batch1Group2Button.click();
        logoutButton.click();
    }
}