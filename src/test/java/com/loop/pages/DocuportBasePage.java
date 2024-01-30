package com.loop.pages;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.BufferedWriter;

public class DocuportBasePage {

    private static final Logger LOG = LogManager.getLogger();

    @FindBy(xpath = "//span[.=' Continue ']")
    public WebElement continueButton;

    public String getElementText(String text){
        String xpath = "//*[normalize-space()='"+ text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath)).getText();
    }

    public WebElement getElement(String text){
        String xpath = "//*[normalize-space()='"+ text + "']";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public void clickButton(String button){
        switch (button.toLowerCase()) {
            case "continue":
                continueButton.click();
                break;
            case "home":
                WebElement homeButton = Driver.getDriver().findElement(By.xpath("//span[.='Home']"));
                BrowserUtils.waitForVisibility(homeButton,5);
                BrowserUtils.clickWithJS(homeButton);
                //homeButton.click();
                break;
            case "invitations":
                WebElement invitationButton = Driver.getDriver().findElement(By.xpath("//span[.='Invitations']"));
                BrowserUtils.waitForVisibility(invitationButton,5);
                BrowserUtils.clickWithJS(invitationButton);
                //invitationButton.click();
                break;
            default:
                LOG.error("No such " + button + "exists");
                throw new IllegalArgumentException();
        }
    }

    public DocuportBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
