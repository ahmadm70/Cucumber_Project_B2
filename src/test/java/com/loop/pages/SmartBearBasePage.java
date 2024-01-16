package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearBasePage {
    public SmartBearBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement viewAllOrdersLink;
    @FindBy(xpath = "//a[.='Order']")
    public WebElement orderLink;
    @FindBy(xpath = "//td//td/following-sibling::td")
    public WebElement recentAddedNameToTable;
}