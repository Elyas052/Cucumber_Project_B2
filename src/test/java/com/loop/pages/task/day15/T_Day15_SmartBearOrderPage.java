package com.loop.pages.task.day15;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import com.loop.utilities.SmartBearSoftConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class T_Day15_SmartBearOrderPage extends T_Day15_SmartBearLoginPage {
    public static WebElement getOrderButton() {
        return orderButton;
    }

    public static WebElement getProductDropDownList() {
        return productDropDownList;
    }

    public static WebElement getQuantityBox() {
        return quantityBox;
    }

    public static List<WebElement> getAddressInformation() {
        return addressInformation;
    }

    public static WebElement getCardNumber() {
        return cardNumber;
    }

    public static WebElement getExpireDate() {
        return expireDate;
    }

    public static WebElement getProcessButton() {
        return processButton;
    }

    @FindBy(xpath = "//a[.='Order']")
    private static WebElement orderButton;
    @FindBy(xpath = "//h3[.='Product Information']//following-sibling::ol//li[1]//select")
    private static WebElement productDropDownList;
    @FindBy(xpath = "//h3[.='Product Information']//following-sibling::ol//li[2]/input")
    private static WebElement quantityBox;
    @FindBy(xpath = "//input[@value='Calculate']")
    private static WebElement calculateButton;
    @FindBy(xpath = "//h3[.='Address Information']//following-sibling::ol[1]//li//input")
    private static List<WebElement> addressInformation;
    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox6']")
    private static WebElement cardNumber;
    @FindBy(xpath = "//input[@name='ctl00$MainContent$fmwOrder$TextBox1']")
    private static WebElement expireDate;
    @FindBy(xpath = "//a[.='Process']")
    private static WebElement processButton;

    public static void orderPage() {
        if (getOrderButton().isDisplayed()) {
            BrowserUtils.waitForClickable(getOrderButton(), SmartBearSoftConstants.MEDIUM).click();
        }
    }

    public T_Day15_SmartBearOrderPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
