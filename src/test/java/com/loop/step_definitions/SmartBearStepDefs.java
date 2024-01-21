package com.loop.step_definitions;

import com.loop.pages.SmartBearOrderPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;

public class SmartBearStepDefs {

    SmartBearOrderPage orderPage = new SmartBearOrderPage();

    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {

    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {

    }

    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer int1) {

    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {

    }

    @When("user enters street {string}")
    public void user_enters_street(String string) {

    }

    @When("user enters city {string}")
    public void user_enters_city(String string) {

    }

    @When("user enters state {string}")
    public void user_enters_state(String string) {

    }

    @When("user enters zip {string}")
    public void user_enters_zip(String string) {

    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {
        orderPage.card.stream()
                .filter(element -> element.getAttribute("value").equals(cardType))
                .findFirst()
                .ifPresent(WebElement::click);
    }

    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {

    }

    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String string) {

    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {

    }

    @Then("user should see {string} in the first row of the table")
    public void user_should_see_in_the_first_row_of_the_table(String string) {

    }
}