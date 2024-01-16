package com.loop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBearLoginPage extends SmartBearBasePage {
    @FindBy(id = "ctl00_MainContent_username")
    public WebElement usernameBar;
    @FindBy(id = "ctl00_MainContent_password")
    public WebElement passwordBar;
    @FindBy(id = "ctl00_MainContent_login_button")
    public WebElement loginButton;

    public void login(String username, String password) {
        usernameBar.sendKeys(username);
        passwordBar.sendKeys(password);
        loginButton.click();
    }
}