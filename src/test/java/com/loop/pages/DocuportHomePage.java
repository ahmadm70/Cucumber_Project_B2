package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportHomePage {
    @FindBy(xpath = "//span[contains(.,'Home')]")
    public WebElement homeButton;
    @FindBy(xpath = "//span[contains(.,'Leads')]")
    public WebElement leadsButton;
    @FindBy(xpath = "//h3")
    public WebElement popUpForClient;
    public DocuportHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}