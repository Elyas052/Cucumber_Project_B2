package com.loop.utilities;

import io.cucumber.java.Scenario;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * BrowserUtils class provides utility methods for handling browser-related actions in Selenium automation.
 */
public class BrowserUtils {

    public static Scenario myScenario;

    /**
     * Takes a screenshot and attaches it to the Cucumber scenario.
     */
    public static void takeScreenshot() {
        try {
            myScenario.log("Current url is: " + Driver.getDriver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        } catch (WebDriverException wbd) {
            wbd.getMessage();
        } catch (ClassCastException cce) {
            cce.getMessage();
        }
    }

    /**
     * Switches to a window by the expected URL and validates the title.
     *
     * @param driver        WebDriver instance
     * @param expectedUrl   Expected URL
     * @param expectedTitle Expected title
     */
    public static void switchWindowAndValidate(WebDriver driver, String expectedUrl, String expectedTitle) {
        expectedTitle = expectedTitle.toLowerCase();
        expectedUrl = expectedUrl.toLowerCase();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String each : windowHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }
        }
        assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    /**
     * Switches to a new window by the exact title or returns to the original window if not found.
     *
     * @param driver      WebDriver instance
     * @param targetTitle Title of the target window
     */
    public static void switchToWindow(WebDriver driver, String targetTitle) {
        String origin = driver.getWindowHandle();
        for (String handle : driver.getWindowHandles()) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains(targetTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    /**
     * Validates the title of the current page.
     *
     * @param driver        WebDriver instance
     * @param expectedTitle Expected title
     */
    public static void validateTitle(WebDriver driver, String expectedTitle) {
        assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * Clicks a link by the given page name on the Loop Practice page.
     *
     * @param nameOfPage Name of the page link to click
     */
    public static void loopLinkClick(String nameOfPage) {
        WebElement element = Driver.getDriver().findElement(By.xpath("//a[.='" + nameOfPage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    /**
     * Moves the mouse to the given element to trigger a hover action.
     *
     * @param element WebElement to hover over
     */
    public static void hover(WebElement element) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(element).perform();
    }

    /**
     * Scrolls down to a web element using JavaScript.
     *
     * @param element WebElement to scroll to
     * @author Elyas
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * Clicks on a web element using JavaScript.
     *
     * @param element WebElement to click
     * @author Elyas
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].click();", element);
    }

    /**
     * Performs a double click action on a web element using WebDriver actions.
     *
     * @param element WebElement to double-click
     * @author Elyas
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.getDriver()).doubleClick(element).build().perform();
    }

    /**
     * Waits for the provided web element to be visible on the page.
     *
     * @param element         WebElement to wait for
     * @param timeToWaitInSec Time to wait in seconds
     * @return Visible WebElement after waiting
     * @author Elyas
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Waits for the provided web element to be invisible on the page.
     *
     * @param element         WebElement to wait for
     * @param timeToWaitInSec Time to wait in seconds
     * @author Elyas
     */
    public static void waitForInVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeToWaitInSec));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * Waits for the provided web element to be clickable.
     *
     * @param element WebElement to wait for
     * @param timeout Time to wait in seconds
     * @return Clickable WebElement after waiting
     * @author Elyas
     */
    public static WebElement waitForClickable(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Pauses the execution for the specified number of seconds.
     *
     * @param seconds Number of seconds to wait
     * @author Elyas
     */
    public static void justWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
