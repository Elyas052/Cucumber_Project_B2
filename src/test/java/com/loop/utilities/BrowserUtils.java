package com.loop.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.assertTrue;

public class BrowserUtils {

    public static Scenario myScenario;

    /**
     * Takes a screenshot and attaches it to the current scenario.
     */
    public static void takeScreenshot() {
        try {
            // Log the current URL before taking the screenshot
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());

            // Capture screenshot as bytes and attach it to the scenario
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        } catch (WebDriverException wbd) {
            wbd.getMessage();
        } catch (ClassCastException cce) {
            cce.getMessage();
        }
    }

    /**
     * Validates if a driver switched to the expected URL and title.
     *
     * @param driver        The WebDriver instance.
     * @param expectedUrl   The expected URL to validate.
     * @param expectedTitle The expected title to validate.
     * @author Elyas
     * Implements assertion.
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        // Convert expectedTitle and expectedUrl to lowercase for case-insensitive comparison
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Iterate through each window handle
        for (String each : windowHandles) {
            driver.switchTo().window(each);

            // Check if the current URL contains the expected URL
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }

        // Assert that the current title contains the expected title
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * Utility methods for handling window operations and link clicks.
     * @author: Elyas
     */

    /**
     * Switches to the new window by the exact title.
     * Return to the original window if the window with the given title is not found.
     *
     * @param driver      The WebDriver instance.
     * @param targetTitle The title of the target window to switch to.
     */
    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        // If the window with the given title is not found, switch back to the original window
        driver.switchTo().window(origin);
    }

    /**
     * Validates the title of the current window.
     *
     * @param driver        The WebDriver instance.
     * @param expectedTitle The expected title to validate.
     */
    public static void validateTitle(WebDriver driver, String expectedTitle) {
        // Assertion to check if the current window's title contains the expected title
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * Clicks any link on the Loop Practice page.
     *
     * @param nameOfPage The name of the page link to be clicked.
     */
    public static void loopLinkClick(String nameOfPage) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        // Wait until the element is clickable and then click it
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Moves the mouse to give an element.
     *
     * @param element Element on which to hover.
     * @author Elyas
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls down to an element using JavaScript.
     *
     * @param element Element to scroll to.
     * @author Elyas
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Clicks on an element using JavaScript.
     *
     * @param element Element to click.
     * @author Elyas
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Performs double click action on an element.
     *
     * @param element Element to double-click.
     * @author Elyas
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Waits for the provided element to be visible on the page.
     *
     * @param element         Element to wait for visibility.
     * @param timeToWaitInSec Time to wait in seconds.
     * @return WebElement representing the visible element.
     * @author Elyas
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the provided element to be clickable.
     *
     * @param element Element to wait for click-ability.
     * @param timeout Timeout in seconds.
     * @return WebElement representing the clickable element.
     * @author Elyas
     */
    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Performs a pause.
     *
     * @param seconds Number of seconds to pause.
     * @author Elyas
     */
    public static void justWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convert seconds to milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}