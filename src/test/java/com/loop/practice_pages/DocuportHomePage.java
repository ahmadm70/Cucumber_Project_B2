package com.loop.practice_pages;

import com.loop.utilities.Driver;
import org.junit.Assert;
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
    @FindBy(xpath = "//div[@class='v-select__selection v-select__selection--comma']")
    public WebElement rowsPerPageNumber;
    @FindBy(xpath = "//div[@role='listbox'][@tabindex='-1']")
    public List<WebElement> rowsPerPageOptions;

    public void goToLink(String item) {
        Driver.getDriver().findElement(By.xpath("//span[contains(.,'" + item + "')]")).click();
    }

    public void changeRowsPerPage(int rows) {
        switch (rows) {
            case 5:
            case 10:
            case 15:
            case 50:
                rowsPerPageNumber.click();
                String rowsPerPagePath = "//div[@role='listbox'][@tabindex='-1']/div[.='" + rows + "']";
                Driver.getDriver().findElement(By.xpath(rowsPerPagePath)).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid rows per page value. Options: 5, 10, 15, 50");
        }
    }

    public void validateRowsPerPage(int rowsPerPage) {
        Assert.assertEquals("Rows per page isn't matching the expected value!", "" + rowsPerPage, rowsPerPageNumber.getText());
    }

    public DocuportHomePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}