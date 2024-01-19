package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DemoblazePage {
    public DemoblazePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void clickCategory(String category) {
        Driver.getDriver().findElement(By.xpath("//a[contains(.,'" + category + "')]")).click();
    }

    public String getPrice(String productName) {
        return Driver.getDriver().findElement(By.xpath("//a[contains(.,'" + productName + "')]/..//following-sibling::h5")).getText();
    }

    @FindBy(xpath = "//button[contains(.,'Previous')]")
    public WebElement previousButton;
}