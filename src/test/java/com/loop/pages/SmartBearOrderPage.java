package com.loop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartBearOrderPage extends SmartBearBasePage {
    @FindBy(id = "ctl00_MainContent_fmwOrder_ddlProduct")
    public WebElement productDropdown;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtQuantity")
    public WebElement quantityBar;
    @FindBy(xpath = "//input[@value='Calculate']")
    public WebElement calculateButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_txtName")
    public WebElement customerNameBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox2")
    public WebElement streetBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox3")
    public WebElement cityBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox4")
    public WebElement stateBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox5")
    public WebElement zipBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_0")
    public WebElement visaRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_1")
    public WebElement masterCardRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_cardList_2")
    public WebElement americanExpressRadioButton;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox6")
    public WebElement cardNumberBar;
    @FindBy(id = "ctl00_MainContent_fmwOrder_TextBox1")
    public WebElement expireDateBar;
    @FindBy(xpath = "//a[.='Process']")
    public WebElement processButton;
}