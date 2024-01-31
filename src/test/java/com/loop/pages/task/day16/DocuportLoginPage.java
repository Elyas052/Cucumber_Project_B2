package com.loop.pages.task.day16;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DocuportLoginPage {

    @FindBy(xpath = "//input[contains(@id, 'input') and contains(@type, 'test')]")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[contains(@id, 'input') and contains(@type, 'password')]")
    public WebElement userPasswordInput;

    @FindBy(xpath = "//span[contains(.,'Log in')]")
    public WebElement loginButton;

    public void login(String userType) {
        userNameInput.sendKeys(DocuportConstants.USERNAME_CLIENT, Keys.ENTER);
        userNameInput.sendKeys(DocuportConstants.PASSWORD, Keys.ENTER);
        BrowserUtils.justWait(10);
        BrowserUtils.clickWithJS(loginButton);
        BrowserUtils.justWait(10);
    }

    /**
     * Initializes the GoogleSearchPage by initializing the PageFactory.
     */
    public DocuportLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
