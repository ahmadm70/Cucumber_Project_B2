package com.loop.pages;

import com.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DocuportBasePage {
    WebDriverWait webDriverWait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    private static final Logger LOG = LogManager.getLogger();
    @FindBy(xpath = "//span//span[contains(.,'Upload')]")
    public WebElement uploadButton;
    @FindBy(xpath = "//h1[contains(.,'Clients')]")
    public WebElement clientsHeaderText;
    @FindBy(xpath = "//h3")
    public WebElement continueButton;
    @FindBy(xpath = "//div[@class='v-data-footer__pagination']")
    public WebElement footerTotalResults;
    @FindBy(xpath = "//a[contains(.,'Terms and conditions')]")
    public WebElement termsAndConditionsLink;

    public void goToLink(String item) {
        Driver.getDriver().findElement(By.xpath("//span[contains(.,'" + item + "')]")).click();
    }

    public String getElementText(String path) {
        return Driver.getDriver().findElement(By.xpath("/*[normalize-space()='" + path + "']")).getText();
    }

    public WebElement getElement(String path) {
        return Driver.getDriver().findElement(By.xpath("/*[normalize-space()='" + path + "']"));
    }

    public DocuportBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}