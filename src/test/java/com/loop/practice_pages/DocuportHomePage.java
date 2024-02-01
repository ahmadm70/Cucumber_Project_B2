package com.loop.practice_pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DocuportHomePage {
    @FindBy(xpath = "//span[contains(.,'Home')]")
    public WebElement homeButton;
    @FindBy(xpath = "//span[contains(.,'Leads')]")
    public WebElement leadsButton;
    @FindBy(xpath = "//h3")
    public WebElement popUpForClient;
    @FindBy(xpath = "//span[contains(.,'Continue')]")
    public WebElement continueButton;
    @FindBy(xpath = "//button[contains(.,'Upload')]")
    public WebElement uploadButton;
    @FindBy(xpath = "//span//span[contains(.,'Batch1 Group2')]")
    public WebElement batch1Group2Button;
    @FindBy(xpath = "//span[contains(.,'Log out')]")
    public WebElement logoutButton;
    @FindBy(xpath = "//div[@role='listbox']//a")
    public List<WebElement> leftNavigateItems;

    public void logoutDocuport() {
        batch1Group2Button.click();
        logoutButton.click();
    }

    public DocuportHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}