package com.loop.practice_pages;

import com.loop.utilities.BrowserUtilities;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportLoginPage {
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
    public void loginDocuport(String username, String password) {
        BrowserUtilities.waitForClickable(loginButton, DocuportConstants.small);
        usernameBar.clear();
        usernameBar.sendKeys(username);
        passwordBar.clear();
        passwordBar.sendKeys(password);
        loginButton.click();
    }

    public void loginDocuport(String userType) {
        switch (userType.toLowerCase()) {
            case "advisor":
                loginDocuport(DocuportConstants.USERNAME_FOR_ADVISOR, DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            case "client":
                loginDocuport(DocuportConstants.USERNAME_FOR_CLIENT, DocuportConstants.PASSWORD_FOR_LOGIN);
                BrowserUtilities.waitForClickable(continueButton, DocuportConstants.large);
                continueButton.click();
                BrowserUtilities.justWait(2000);
                break;
            case "employee":
                loginDocuport(DocuportConstants.USERNAME_FOR_EMPLOYEE, DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
            case "supervisor":
                loginDocuport(DocuportConstants.USERNAME_FOR_SUPERVISOR, DocuportConstants.PASSWORD_FOR_LOGIN);
                break;
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