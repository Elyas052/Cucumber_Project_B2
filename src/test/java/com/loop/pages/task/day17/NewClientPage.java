package com.loop.pages.task.day17;

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class NewClientPage {
    @FindBy(xpath = "//label[.='Username or email']/following-sibling::input")
    public WebElement loginInput;
    @FindBy(xpath = "//label[.='Password']/following-sibling::input")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;
    @FindBy(xpath = "//button[@type='submit']/span")
    public WebElement continueButton;
    @FindBy(xpath = "//span[.='BG']")
    public WebElement batchButton;
    @FindBy(xpath = "//span[.='Log out']")
    public WebElement logOut;
    @FindBy(xpath = "//div[@class='v-list-item__title']")
    List<WebElement> allModules;
    @FindBy(xpath = "//span[.='Home']")
    public WebElement home;
    @FindBy(xpath = "//span[.='Clients']")
    public WebElement clients;
    @FindBy(xpath = "//span[.='Users']")
    public WebElement users;
    @FindBy(xpath = "//span[@class ='v-btn__content']/span[.='Create new client']")
    public WebElement newClientButton;
    @FindBy(xpath = "//span[.='Personal']")
    public WebElement personalAccount;
    @FindBy(xpath = "//label[.='First name']/following-sibling::input")
    public WebElement userFirstName;
    @FindBy(xpath = "//label[.='Last name']/following-sibling::input")
    public WebElement userLastName;
    @FindBy(xpath = "//div [@class='v-input--selection-controls__ripple']")
    public WebElement newUserCheckbox;
    @FindBy(xpath = "//label[.='Email address']/following-sibling::input")
    public WebElement emailAddress;
    @FindBy(xpath = "//label[.='Advisor']/following-sibling::input")
    public WebElement advisorChoose;
    @FindBy(xpath = "//div[contains(text(),'advisor advisor')]")
    public WebElement batch1Gr1;
    @FindBy(xpath = "//label[.='Phone number']/following-sibling::input")
    public WebElement phoneNumber;
    @FindBy(xpath = "//label[.='Password']/following-sibling::input")
    public WebElement passwordNew;
    @FindBy(xpath = "//label[.='Confirm password']/following-sibling::input")
    public WebElement confirmationPassword;
    @FindBy(xpath = "//button[@class='text-none body-2 font-weight-medium v-btn v-btn--has-bg theme--light v-size--default success']")
    public WebElement saveButton;
    @FindBy(xpath = "//button[@class='mr-3 mb-1 mb-sm-0 v-btn v-btn--has-bg theme--light v-size--large']")
    public WebElement searchFilterButton;
    @FindBy(xpath = "//button[@class='v-app-bar__nav-icon v-btn v-btn--icon v-btn--round theme--light v-size--default']")
    public WebElement menuButton;
    @FindBy(xpath = "(//td[@class='text-start'])[2]")
    public WebElement resultEmail;
    @FindBy(xpath = "//label[.='Email address']/following-sibling::input")
    public WebElement searchEmail;
    @FindBy(xpath = "//button[@class='text-none body-2 font-weight-medium v-btn v-btn--has-bg theme--light v-size--default primary']")
    public WebElement searchButton;

    public void personalClient(String firstName, String lastName, String email, String phone, String password, String confirmPassword) {
        newClientButton.click();
        personalAccount.click();
        userFirstName.sendKeys(firstName);
        userLastName.sendKeys(lastName);
        newUserCheckbox.click();
        emailAddress.sendKeys(email);
        advisorChoose.click();
        batch1Gr1.click();
        phoneNumber.sendKeys(phone);
        passwordNew.sendKeys(password);
        confirmationPassword.sendKeys(confirmPassword);
        saveButton.click();
    }

    public void searchUser(String email) {
        BrowserUtils.justWait(10);
        users.click();
        searchFilterButton.click();
        BrowserUtils.justWait(5);
        searchEmail.sendKeys(email);
        searchButton.click();
        BrowserUtils.justWait(15);
    }

    public List<String> actual() {
        List<String> one = new ArrayList<>();
        for (WebElement each : allModules) {
            one.add(each.getText());
        }
        return one;
    }

    /**
     * logins to docuport
     *
     * @param username
     * @param password
     * @author alex
     */

    public void loginDocuport(String username, String password) {
        BrowserUtils.waitForVisibility(loginInput, DocuportConstants.small);
        // loginInput.clear();
        loginInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        BrowserUtils.justWait(5);
        if (BrowserUtils.waitForVisibility(continueButton, DocuportConstants.small).isEnabled()) {
            continueButton.click();
        }
        BrowserUtils.justWait(5);
    }

    public void loginDocuport2(String username, String password) {
        BrowserUtils.waitForVisibility(loginInput, DocuportConstants.small);
        // loginInput.clear();
        loginInput.sendKeys(username);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        loginButton.click();
        BrowserUtils.justWait(2);
    }

    public void logOutDocuport() {
        BrowserUtils.waitForVisibility(batchButton, 10);
        batchButton.click();
        logOut.click();
    }

    public NewClientPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
}
