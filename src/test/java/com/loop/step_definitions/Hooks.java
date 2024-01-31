package com.loop.step_definitions;


/**
 * Hooks class containing setup and teardown methods for Cucumber scenarios.
 * Implements @Before, @After, and @AfterStep annotations for setup, teardown, and taking screenshots after each step.
 * Use BrowserUtils.myScenario to share the scenario information across methods.
 * Implement logging for the start and end of automation.
 */

import com.loop.utilities.BrowserUtils;
import com.loop.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    private static final Logger LOG = LogManager.getLogger();

    /**
     * Setup method executed before each scenario.
     *
     * @param scenario The Cucumber scenario object.
     */
    @Before
    public void setUp(Scenario scenario) {
        // Initializes the WebDriver and sets the scenario for screenshot attachment
        Driver.getDriver();
        BrowserUtils.myScenario = scenario;
        LOG.info("..........START AUTOMATION.........LOOP ACADEMY");
    }

    /**
     * Teardown method executed after each scenario.
     *
     * @param scenario The Cucumber scenario object.
     */
    @After
    public void tearDown(Scenario scenario) {
        // Takes a screenshot and attaches it to the report if the scenario failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        // Closes the WebDriver
        // Driver.closeDriver();
        LOG.info("..........END AUTOMATION.........LOOP ACADEMY");
    }

    /**
     * Screenshot method executed after each step.
     * Takes a screenshot and attaches it to the report.
     *
     * @param scenario The Cucumber scenario object.
     */
    @AfterStep
    public void screenShot(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", scenario.getName());
    }
}
