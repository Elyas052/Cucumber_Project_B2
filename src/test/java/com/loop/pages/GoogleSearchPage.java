/**
 * Page class for the Google Search page containing elements and methods related to search functionality.
 * Uses the @FindBy annotation from Selenium's PageFactory to locate web elements.
 * Includes searchBox, searchButton, and capital elements.
 * Constructor initializes elements using PageFactory.
 */
package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {

    // Search box element located by name attribute
    @FindBy(name = "q")
    public WebElement searchBox;

    // Search button element located by XPath
    @FindBy(xpath = "//input[@id='gbqfbb']/preceding-sibling::input")
    public WebElement searchButton;

    // Capital link element located by XPath
    @FindBy(xpath = "//a[@class='FLP8od']")
    public WebElement capital;

    /**
     * Constructor to initialize elements using PageFactory.
     */
    public GoogleSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
