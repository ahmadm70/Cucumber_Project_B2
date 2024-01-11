package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportLoginPage {
    @FindBy(xpath = "//h1[contains(.,'Login')]")
    public WebElement loginText;
    @FindBy(id = "input-14")
    public WebElement usernameBar;
    @FindBy(id = "input-15")
    public WebElement passwordBar;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    public DocuportLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}