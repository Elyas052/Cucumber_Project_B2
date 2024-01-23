package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
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

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement cntBtn;

    @FindBy(xpath = "//div[@class='v-avatar primary']")
    public WebElement userIcon;

    @FindBy(xpath = "//span[contains(text(),'Log out')]")
    public WebElement logOut;

    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement continueButton;

    /**
     * Logins to Docuport with the provided username and password.
     *
     * @param username The username to log in with.
     * @param password The password to log in with.
     * @author Elyas
     */

    public void loginDocuport(String username, String password) {
        BrowserUtils.waitForVisibility(userNameInput, DocuportConstants.small);
        userNameInput.clear();
        userNameInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();

        // Check if the continued button is displayed and click it if true
        if (BrowserUtils.waitForVisibility(continueButton, DocuportConstants.small).isDisplayed()) {
            continueButton.click();
        }
    }

//    public void loginDocuport(String username, String password) {
//        BrowserUtils.waitForVisibility(userNameInput, DocuportConstants.small);
//        userNameInput.clear();
//        userNameInput.sendKeys(username);
//        passwordInput.clear();
//        passwordInput.sendKeys(password);
//        BrowserUtils.waitForClickable(loginButton, DocuportConstants.small);
//        BrowserUtils.clickWithJS(loginButton);
//        BrowserUtils.justWait(DocuportConstants.small);
//        if (continueButton.isDisplayed()) {
//            continueButton.click();
//        }
//    }

//    public void loginDocuport(String username, String password) {
//        BrowserUtils.waitForVisibility(userNameInput, DocuportConstants.small);
//        userNameInput.clear();
//        userNameInput.sendKeys(username);
//        userNameInput.clear();
//        userNameInput.sendKeys(password);
//        loginButton.click();
//        if (continueButton.isDisplayed()) {
//            continueButton.click();
//        }
//    }

    /**
     * Initializes the LoginPage by initializing the PageFactory.
     */
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
