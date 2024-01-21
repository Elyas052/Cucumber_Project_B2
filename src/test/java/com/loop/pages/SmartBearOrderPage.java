package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearOrderPage extends SmartBearBasePage {

    public SmartBearOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement product;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement quantity;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")
    public WebElement pricePerUnit;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtDiscount']")
    public WebElement discount;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtTotal']")
    public WebElement total;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement calculateButton;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtName']")
    public WebElement customerName;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    public WebElement street;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    public WebElement state;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    public WebElement zip;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> card;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    public WebElement cardNumber;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    public WebElement expiration;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_InsertButton']")
    public WebElement processButton;

    @FindBy(xpath = "//input[@type='reset']")
    public WebElement resetButton;

    @FindBy(xpath = "//h2[contains(text(),'Order')]")
    public WebElement orderHeading;
}