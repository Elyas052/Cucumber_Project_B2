package com.loop.step_definitions;

import com.loop.pages.LoginPage;
import com.loop.utilities.*;
import io.cucumber.java.en.*;

import java.util.Map;

import static com.loop.utilities.Driver.getDriver;
import static org.junit.Assert.assertTrue;

public class LoginStepDefs {

    // Create an instance of the LoginPage class for interaction
    LoginPage loginPage = new LoginPage();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.small);
        loginPage.userNameInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
        //assertTrue(3 == 4);
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.small);
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD_CLIENT);
    }

    @And("user clicks login button")
    public void user_clicks_login_button() {
        BrowserUtils.waitForVisibility(loginPage.loginButton, DocuportConstants.large).click();
    }

    @And("user click to continue button")
    public void userClickToContinueButton() {
        BrowserUtils.waitForClickable(loginPage.cntBtn, DocuportConstants.large);
        loginPage.cntBtn.click();
        BrowserUtils.justWait(5);
    }

    @And("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        BrowserUtils.justWait(10);
    }

    @And("user should click Batch1 Group1 button for Log out")
    public void userShouldClickBatchGroupButtonForLogOut() {
        BrowserUtils.waitForClickable(loginPage.userIcon, DocuportConstants.small).click();
        BrowserUtils.waitForClickable(loginPage.logOut, DocuportConstants.small).click();
    }

    @Then("user should see docuport home page")
    public void userShouldSeeDocuportHomePage() {
        System.out.println(getDriver().getTitle());
    }

    @When("user enters username for employee")
    public void user_enters_username_for_employee() {

    }

    @When("user enters password for employee")
    public void user_enters_password_for_employee() {

    }

    @Then("user should see the home page for employee")
    public void user_should_see_the_home_page_for_employee() {

    }

    @When("user enters username for advisor")
    public void user_enters_username_for_advisor() {

    }

    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {

    }

    @Then("user should see the home page for advisor")
    public void user_should_see_the_home_page_for_advisor() {

    }

    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {

    }

    @When("user enters password for supervisor")
    public void user_enters_password_for_supervisor() {

    }

    @Then("user should see the home page for supervisor")
    public void user_should_see_the_home_page_for_supervisor() {

    }

    @When("user enters credentials")
    public void user_enters_credentials(Map<String, String> credentials) {

//        for (Map.Entry<String, String> entry : credentials.entrySet()) {
//            String key = entry.getKey();
//            System.out.println(key);
//            String value = entry.getValue();
//            System.out.println("Value = " + value);
//            System.out.println("====================");
//        }

        loginPage.loginDocuport(credentials.get("username"), credentials.get("password"));
    }
}