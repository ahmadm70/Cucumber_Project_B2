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
    @FindBy(xpath = "//span[contains(.,'Continue')]")
    public WebElement continueButton;
    @FindBy(xpath = "//button[contains(.,'Upload')]")
    public WebElement uploadButton;
    @FindBy(xpath = "//div[@role='listbox']//a")
    public List<WebElement> leftNavigateItems;
    @FindBy(xpath = "//span[contains(.,'Search')]//span")
    public WebElement searchButton;
    @FindBy(xpath = "//span[contains(.,'Download')]//span")
    public WebElement downloadButton;
    @FindBy(xpath = "//h1")
    public WebElement pageHeader;

    public void goToLink(String item) {
        Driver.getDriver().findElement(By.xpath("//span[contains(.,'" + item + "')]")).click();
    }

    public DocuportHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}