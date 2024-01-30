package com.loop.step_definitions;

import com.loop.pages.*;
import com.loop.utilities.*;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Map;

import static com.loop.pages.T_Day15_SmartBearOrderPage.*;
import static com.loop.utilities.SmartBearSoftConstants.*;
import static org.junit.Assert.assertEquals;

public class T_Day15_SmartBearStepDefs {

    private static final Logger LOG = LogManager.getLogger();

    @Given("user is already logged in and navigated to order page")
    public void loggedAndNavigatedToOrderPage() {
        PageFactory.initElements(Driver.getDriver(), new T_Day15_SmartBearOrderPage());
        logIn();
        orderPage();
        LOG.info("The user is on the SmartBear page");
    }

    @When("user selects product type {string}")
    public void selectProductType(String productType) {
        new Select(getProductDropDownList()).selectByVisibleText(productType);
    }

    @When("user enters")
    public void enterAllInformation(Map<String, String> objects) {
        getQuantityBox().sendKeys(Keys.BACK_SPACE);
        getQuantityBox().sendKeys(objects.get(QUANTITY));

        // Only Address Information
        getAddressInformation().get(0).sendKeys(objects.get(CUSTOMER_NAME));
        getAddressInformation().get(1).sendKeys(objects.get(STREET));
        getAddressInformation().get(2).sendKeys(objects.get(CITY));
        getAddressInformation().get(3).sendKeys(objects.get(STATE));
        getAddressInformation().get(4).sendKeys(objects.get(ZIP));

        // Card Information
        getCardNumber().sendKeys(objects.get(CREDIT_CARD_NUMBER));
        getExpireDate().sendKeys(objects.get(EXPIRATION_DATE));
        LOG.info("User fill out the order form");
    }

    @When("user selects credit card type {string}")
    public void selectCardType(String cardType) {
        BrowserUtils.waitForClickable(cardPaymentSystem(cardType), MEDIUM).click();
    }

    @When("user enters process order button")
    public void clickProcess() {
        BrowserUtils.waitForClickable(getProcessButton(), LARGE).click();
    }

    @Then("user should see {string} in the first row of the table")
    public void firstRowInAllView(String first) {
        BrowserUtils.waitForClickable(getViewAllOrders(), MEDIUM).click();
        assertEquals(getFirstNameInTable().getText(), first);
        LOG.info("User verifies order add on the list");
    }
}
