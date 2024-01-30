package com.loop.step_definitions;

import com.loop.pages.ClientPage;
import com.loop.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;

import static org.assertj.core.api.SoftAssertions.assertSoftly;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ClientStepDefs {

    ClientPage clientPage = new ClientPage();
    LoginPage loginPage = new LoginPage();
    private Logger LOG = LogManager.getLogger();
    private SoftAssertions softAssertions = new SoftAssertions();

    @Then("user validates {string} text is displayed")
    public void user_validates_text_is_displayed(String text) {
        // assertTrue(loginPage.getElement(text).isDisplayed());
        String actual = loginPage.getElementText(text);
        // assertEquals("Actual text: " + actual + " does NOT match expected: " + text, actual, text);
        softAssertions.assertThat(actual).isEqualTo("Nadir");
    }

    @Then("user clicks {string} button")
    public void user_clicks_button(String button) {
        clientPage.clickButton(button);
    }

    @When("user validates all assertions")
    public void user_validates_all_assertions() {
        softAssertions.assertAll();
    }
}
