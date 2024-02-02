package com.loop.utilities;

import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * BrowserUtils class provides utility methods for handling browser-related actions in Selenium automation.
 */
public class BrowserUtils {

    public static Scenario myScenario;
    private static final Logger LOG = LogManager.getLogger();

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

    /**
     * Extracts the text content of WebElements and returns a List of Strings.
     * @param elements List of WebElements
     * @return List of Strings representing the text content of each WebElement
     */
    public static List<String> getElementsText(List<WebElement> elements) {
        List<String> elementsText = new ArrayList<>();
        for (WebElement element : elements) {
            elementsText.add(element.getText());
        }
        return elementsText;
    }

    /**
     * Uses Java Streams to extract the text content of WebElements and returns a List of Strings.
     * @param elements List of WebElements
     * @return List of Strings representing the text content of each WebElement
     */
    public static List<String> getElementsTextWithStream(List<WebElement> elements) {
        return elements.stream()
                .map(x -> x.getText())
                .collect(Collectors.toList());
    }

    /**
     * Uses Java Streams with method reference to extract the text content of WebElements and returns a List of Strings.
     * @param elements List of WebElements
     * @return List of Strings representing the text content of each WebElement
     */
    public static List<String> getElementsTextWithStream2(List<WebElement> elements) {
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * Waits for the page to be fully loaded by checking the document.readyState.
     * @param timeOutInSeconds Maximum time to wait for the page to load
     */
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            LOG.info("Waiting for page to load...");
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(timeOutInSeconds));
            wait.until(expectation);
        } catch (Throwable error) {
            LOG.info("Timeout waiting for Page Load Request to complete after " + timeOutInSeconds + " seconds");
        }
    }

    /**
     * Waits for a WebElement to become stale (no longer attached to the DOM).
     * @param element WebElement to wait for staleness
     */
    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            try {
                element.isDisplayed();
                break;
            } catch (StaleElementReferenceException st) {
                y++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (WebDriverException we) {
                y++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * Creates a new file at the specified filePath and writes the provided content into it.
     * @param filePath Path where the file should be created
     * @param content Content to be written into the file
     */
    public static void createFileWithContent(String filePath, String content) {
        File file = new File(filePath);

        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            try {
                fw.write(content);
            } catch (Exception e) {
                LOG.debug("Error during FileWriter append. " + e.getMessage(), e.getCause());
            } finally {
                try {
                    fw.close();
                } catch (Exception e) {
                    LOG.debug("Error during FileWriter close. " + e.getMessage(), e.getCause());
                }
            }
        } catch (IOException e) {
            LOG.debug(e.getMessage(), e.getCause());
        }
    }

}
