package com.loop.step_definitions.task.day17;

import com.loop.pages.task.day17.NewClientPage;
import com.loop.utilities.BrowserUtils;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class LoginStepDefs {
    NewClientPage loginPage = new NewClientPage();

    @Given("user is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
        BrowserUtils.takeScreenshot();
    }

    @When("user enters username for client")
    public void user_enters_username_for_client() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.large);
        loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_CLIENT);
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {
        loginPage.loginButton.click();
    }

    @Then("user should see the home page for client")
    public void user_should_see_the_home_page_for_client() {
        BrowserUtils.waitForClickable(loginPage.continueButton, DocuportConstants.large);
        loginPage.continueButton.click();
        BrowserUtils.takeScreenshot();
    }

    @Then("user should click batch and group button")
    public void user_should_click_batch_and_group_button() {
        BrowserUtils.waitForClickable(loginPage.batchButton, 10);
        loginPage.batchButton.click();
    }

    @Then("user clicks log out button")
    public void user_clicks_log_out_button() {
        BrowserUtils.waitForClickable(loginPage.logOut, DocuportConstants.large);
        loginPage.logOut.click();
    }

    @Then("user should see login page")
    public void user_should_see_login_page() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.large);
        BrowserUtils.takeScreenshot();
    }

    // Scenario for Employee
    @When("user enters username for employee")
    public void userEntersUsernameForEmployee() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.large);
        loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
    }

    @When("user enters password for employee")
    public void userEntersPasswordForEmployee() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @Then("user should see the home page for employee")
    public void userShouldSeeTheHomePageForEmployee() {
        BrowserUtils.waitForClickable(loginPage.batchButton, DocuportConstants.large);
    }

    // Scenario for Supervisor
    @When("user enters username for supervisor")
    public void user_enters_username_for_supervisor() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.large);
        loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
    }

    @When("user enters password for asupervisor")
    public void user_enters_password_for_asupervisor() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @Then("user should see the home page for supervisor")
    public void user_should_see_the_home_page_for_supervisor() {
        BrowserUtils.waitForClickable(loginPage.batchButton, DocuportConstants.large);
    }

    // Scenario for Advisor
    @When("user enters username for adviser")
    public void user_enters_username_for_adviser() {
        BrowserUtils.waitForClickable(loginPage.loginButton, DocuportConstants.large);
        loginPage.loginInput.sendKeys(DocuportConstants.USERNAME_ADVISOR);
    }

    @When("user enters password for adviser")
    public void user_enters_password_for_adviser() {
        loginPage.passwordInput.sendKeys(DocuportConstants.PASSWORD);
    }

    @Then("user should see the home page for adviser")
    public void user_should_see_the_home_page_for_adviser() {
        BrowserUtils.waitForClickable(loginPage.batchButton, DocuportConstants.large);
    }

    @When("user enters credentials")
    public void user_enters_credentials(Map<String, String> credentials) {
        loginPage.loginDocuport(credentials.get("username"), credentials.get("password"));
    }

    @Then("user should see the clients home page")
    public void user_should_see_the_clients_home_page() {
        BrowserUtils.waitForClickable(loginPage.batchButton, 5);
        BrowserUtils.takeScreenshot();
    }

    @Then("user enters credentials for login")
    public void user_enters_credentials_for_login(Map<String, String> credentials) {
        loginPage.loginDocuport(credentials.get("user"), credentials.get("password"));
    }

    @When("user verify left navigation items")
    public void user_verify_left_navigation_items(Map<String, List<String>> userItems) {
        BrowserUtils.waitForVisibility(loginPage.batchButton, 10);
        assertEquals(userItems.get("user"), loginPage.actual());
        BrowserUtils.justWait(5);
        loginPage.logOutDocuport();
    }

    @Then("user enters again credentials for login")
    public void user_enters_again_credentials_for_login(Map<String, String> userInfo) {
        loginPage.loginDocuport2(userInfo.get("user"), userInfo.get("password"));
    }

    @Then("user come to Clients tab")
    public void user_come_to_clients_tab() {
        BrowserUtils.waitForVisibility(loginPage.clients, 10);
        loginPage.clients.click();
    }

    @Then("user enter information for new personal")
    public void user_enter_information_for_new_personal(Map<String, String> userInfo) {
        loginPage.personalClient(userInfo.get("First name"), userInfo.get("Last name"),
                userInfo.get("Email"), userInfo.get("Phone"), userInfo.get("Password"),
                userInfo.get("Password"));
    }

    @Then("user validate that new client {string} created")
    public void user_validate_that_new_client_created(String email) {
        BrowserUtils.justWait(10);
        loginPage.searchUser(email);
        BrowserUtils.justWait(10);
        assertEquals(email, loginPage.resultEmail.getText());
        System.out.println("loginPage.resultEmail.getText() = " + loginPage.resultEmail.getText());
    }

    @Then("user logout and login as a new person")
    public void user_logout_and_login_as_a_new_person(Map<String, String> newClient) {
        loginPage.logOutDocuport();
        loginPage.loginDocuport2(newClient.get("user"), newClient.get("password"));
    }
}
