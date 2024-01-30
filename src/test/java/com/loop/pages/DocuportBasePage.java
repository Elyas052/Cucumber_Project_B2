/**
 * Base page class for Docuport application containing common elements and methods.
 * Extends the BrowserUtils class for utility functions and Driver class for WebDriver instance.
 * Use the @FindBy annotation from Selenium's PageFactory to locate the "Continue" button.
 * Provides methods to get element text, locate elements, and click buttons based on their names.
 * Constructor initializes elements using PageFactory.
 */
package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportBasePage {

    // "Continue" button element located using XPath
    @FindBy(xpath = "//span[.=' Continue ']")
    public WebElement continueButton;

    // Logger instance for logging
    private static final Logger LOG = LogManager.getLogger();

    /**
     * Method to retrieve the text of a web element based on its normalized text content.
     *
     * @param text - Normalized text content of the element.
     * @return - Text of the located element.
     */
    public String getElementText(String text) {
        String xpath = "//*[normalize-space()='" + text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath)).getText();
    }

    /**
     * Method to locate a web element based on its normalized text content.
     *
     * @param text - Normalized text content of the element.
     * @return - Located WebElement.
     */
    public WebElement getElement(String text) {
        String xpath = "//*[normalize-space()='" + text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    /**
     * Method to click a button based on its name.
     *
     * @param button - Name of the button to be clicked ("continue", "home", or "invitations").
     * @throws IllegalArgumentException if an unsupported button name is provided.
     */
    public void clickButton(String button) {
        switch (button.toLowerCase()) {
            case "continue":
                continueButton.click();
                break;
            case "home":
                WebElement homeButton = Driver.getDriver().findElement(By.xpath("//span[.='Home']"));
                BrowserUtils.waitForVisibility(homeButton, 5);
                BrowserUtils.clickWithJS(homeButton);
                break;
            case "invitations":
                WebElement invitationButton = Driver.getDriver().findElement(By.xpath("//span[.='Invitations']"));
                BrowserUtils.waitForVisibility(invitationButton, 5);
                BrowserUtils.clickWithJS(invitationButton);
                break;
            default:
                LOG.error("No such button '" + button + "' exists");
                throw new IllegalArgumentException();
        }
    }

    // Constructor to initialize elements using PageFactory
    public DocuportBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
