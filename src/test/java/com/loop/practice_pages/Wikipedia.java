package com.loop.practice_pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Wikipedia {
    @FindBy(id = "searchInput")
    public WebElement searchBar;
    @FindBy(xpath = "//button[contains(.,'Search')]")
    public WebElement searchButton;
    @FindBy(xpath = "//div[@class='vector-toc-text'][contains(.,'Top')]")
    public WebElement topButton;
    @FindBy(xpath = "//span[@class='mw-page-title-main']")
    public WebElement mainHeader;
    @FindBy(xpath = "//div[@class='fn']")
    public WebElement imageHeader;

    public Wikipedia() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}