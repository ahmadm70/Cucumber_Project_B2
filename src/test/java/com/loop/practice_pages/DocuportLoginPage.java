package com.loop.practice_pages;

import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportLoginPage {
    @FindBy(xpath = "//h1[contains(.,'Login')]")
    public WebElement loginText;
    @FindBy(xpath = "//label[contains(.,'Username or email')]/following-sibling::input")
    public WebElement usernameBar;
    @FindBy(xpath = "//label[contains(.,'Password')]/following-sibling::input")
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

    public void logoutDocuport(String fullName) {
        Driver.getDriver().findElement(By.xpath("//span//span[contains(.,'" + fullName + "')]")).click();
        logoutButton.click();
    }
}