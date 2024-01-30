/**
 * Page class for the login page of Docuport application.
 * Contains elements and methods related to the login functionality.
 * Use the @FindBy annotation from Selenium's PageFactory to locate web elements.
 * Includes usernameInput, passwordInput, loginButton, continueButton, and loginText elements.
 * Provides a method to log in to Docuport using the provided username and password.
 * Constructor initializes elements using PageFactory.
 * Author: Elyas
 */
package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends DocuportBasePage {

    // Username input element located by XPath
    @FindBy(xpath = "//input[@id='input-14']")
    public WebElement usernameInput;

    // Password input element located by XPath
    @FindBy(xpath = "//input[@id='input-15']")
    public WebElement passwordInput;

    // Login button element located by XPath
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    // Continue a button element located by XPath
    @FindBy(xpath = "//button[@type='submit']//span")
    public WebElement continueButton;

    // Login text element located by XPath
//    @FindBy(xpath = "Customize Toolbar...")
//    public WebElement loginText;

    /**
     * Logins to Docuport application.
     *
     * @param username The username to use for login.
     * @param password The password to use for login.
     */
    public void loginDocuport(String username, String password) {
        // Wait for visibility of username input field
        BrowserUtils.waitForVisibility(usernameInput, DocuportConstants.small);
        // Clear existing username input
        usernameInput.clear();
        // Enter the provided username
        usernameInput.sendKeys(username);
        // Clear existing password input
        passwordInput.clear();
        // Enter the provided password
        passwordInput.sendKeys(password);
        // Click on the login button
        loginButton.click();

        // Check if the continued button is displayed and click it if present
        if (BrowserUtils.waitForVisibility(continueButton, DocuportConstants.small).isDisplayed()) {
            continueButton.click();
        }
    }

    /**
     * Constructor to initialize elements using PageFactory.
     */
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
