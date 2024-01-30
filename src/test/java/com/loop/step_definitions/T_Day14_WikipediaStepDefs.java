package com.loop.step_definitions;

import com.loop.pages.T_Day14_WikiSearchPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Keys;

public class T_Day14_WikipediaStepDefs {

    private static final Logger LOG = LogManager.getLogger();

    T_Day14_WikiSearchPage tDay14WikipediaStepDefs = new T_Day14_WikiSearchPage();

    String actual = "";

    @Given("user is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("wiki.url"));
        LOG.info("User is on Wikipedia home page");
    }

    @When("user types {string} in the wiki search box")
    public void user_types_steve_jobs_in_the_wiki_search_box(String user) {
        tDay14WikipediaStepDefs.searchBox.sendKeys(user + Keys.ENTER);
        LOG.info("User types Steve Jobs");
    }

    @When("user clicks wiki search button")
    public void user_clicks_wiki_search_button() {
        LOG.info("User clicks wiki search button");
    }

    @Then("user sees {string} is in the wiki title")
    public void user_sees_steve_jobs_is_in_the_wiki_title(String title) {
        actual = tDay14WikipediaStepDefs.wikiTitle.getText();
        Assert.assertEquals(title, actual);
        LOG.info("User verifies the wiki title");
    }

    @Then("user sees {string} is in the main header")
    public void user_sees_steve_jobs_is_in_the_main_header(String mainHeader) {
        actual = tDay14WikipediaStepDefs.mainHeader.getText();
        Assert.assertEquals(mainHeader, actual);
        LOG.info("User verifies the main header");
    }

    @Then("user sees {string} is in the image header")
    public void user_sees_steve_jobs_is_in_the_image_header(String imageHeader) {
        actual = tDay14WikipediaStepDefs.imageHeader.getText();
        Assert.assertEquals(imageHeader, actual);
        LOG.info("User verifies the image header");
    }
}
