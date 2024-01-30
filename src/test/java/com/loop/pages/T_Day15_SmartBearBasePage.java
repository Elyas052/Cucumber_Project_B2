package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class T_Day15_SmartBearBasePage {
    public static WebElement getUsername() {
        return username;
    }

    public static WebElement getPassword() {
        return password;
    }

    public static WebElement getLoginButton() {
        return loginButton;
    }

    @FindBy(xpath = "//input[@type='text']")
    private static WebElement username;
    @FindBy(xpath = "//input[@type='password']")
    private static WebElement password;
    @FindBy(xpath = "//input[@type='submit']")
    private static WebElement loginButton;

    public T_Day15_SmartBearBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
