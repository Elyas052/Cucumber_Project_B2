package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    /**
     * Creating the private constructor so this class's object is not reachable from the outside.
     */
    private Driver() {
    }

    /**
     * Making driver instance private.
     * Static - run before everything else and also used in static method.
     */
    private static WebDriver driver;

    /**
     Reusable method that will return the same driver instance every time called.
     */

    /**
     * Singleton pattern.
     *
     * @return driver
     * @author Elyas
     */
    public static WebDriver getDriver() {
        if (driver == null) {
            // For read browser from ConfigurationReader.getProperty
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    /**
     * Closing driver.
     *
     * @author Elyas
     */
    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}