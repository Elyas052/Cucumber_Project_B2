package com.loop.pages.task.day15;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import com.loop.utilities.SmartBearSoftConstants;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearLoginPage extends SmartBearBasePage {
    public static void logIn() {
        Driver.getDriver().get(ConfigurationReader.getProperty("smart.bear"));
        getUsername().sendKeys(SmartBearSoftConstants.USERNAME);
        getPassword().sendKeys(SmartBearSoftConstants.PASSWORD);
        BrowserUtils.waitForClickable(getLoginButton(), SmartBearSoftConstants.LARGE).click();
    }

    public static WebElement getViewAllOrders() {
        return viewAllOrders;
    }

    public static WebElement getFirstNameInTable() {
        return firstNameInTable;
    }

    @FindBy(xpath = "//ul/li/a[.='View all orders']")
    private static WebElement viewAllOrders;

    @FindBy(xpath = "//table[@class='SampleTable']/*/tr[2]/td[2]")
    private static WebElement firstNameInTable;
    @FindBy(xpath = "//table[@class='SampleTable']//tr//following-sibling::tr")
    private static List<WebElement> dataTable;

    public SmartBearLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
