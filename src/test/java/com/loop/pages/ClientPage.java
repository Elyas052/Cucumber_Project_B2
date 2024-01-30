/**
 * Page Object class for the ClientPage.
 * Extends DocuportBasePage, which contains common elements and functionalities for all pages.
 * Use the @FindBy annotation from Selenium's PageFactory to locate the "Choose account" text element.
 * The constructor initializes the elements of this page using the PageFactory's initElements method.
 */
package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPage extends DocuportBasePage {

    // "Choose account" text element located using XPath
    @FindBy(xpath = "//h3[.='Choose account']")
    public WebElement chooseAccountText;

    // Constructor to initialize elements using PageFactory
    public ClientPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
