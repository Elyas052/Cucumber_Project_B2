package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class LoginPage {

    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='input-15']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(xpath = "//span[.=' Continue ']")
    public WebElement cntBtn;

    @FindBy(xpath = "//div[@class='v-avatar primary']")
    public WebElement userIcon;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    public WebElement logOut;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
