package com.loop.step_definitions;

import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.bouncycastle.est.LimitedSource;

import java.util.List;
import java.util.Map;

public class ProductStepDefs {

    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("product.url"));
    }

    @Then("User should be able to see expected prices in following products")
    public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String, String>> productDetails) {
        for (Map<String, String> productDetail : productDetails) {
            System.out.println("=============Product Detail===============");

        }
    }

}