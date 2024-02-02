package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

/**
 * Driver class provides a singleton pattern for WebDriver initialization.
 * It uses ThreadLocal to handle multi-threading and ensures a single driver instance per thread.
 */
public class Driver {

    /**
     * Private constructor to prevent the instantiation of this class.
     */
    private Driver() {
    }

    /**
     * InheritableThreadLocal to manage WebDriver instances for each thread.
     */
    private static final InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();

    /**
     * Reusable method that returns the same driver instance every time called.
     * Uses a singleton pattern to create and manage WebDriver instances.
     *
     * @return WebDriver instance
     * @author Elyas
     */
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType.toLowerCase()) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
                    break;
                case "headless":
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless"); // enable headless mode
                    WebDriverManager.chromedriver().setup();
                    driverPool.set(new ChromeDriver(options));
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driverPool.set(new EdgeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driverPool.set(new SafariDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
                    break;
            }
        }
        return driverPool.get();
    }

    /**
     * Closes the WebDriver instance for the current thread.
     * Removes the driver instance from the ThreadLocal variable.
     *
     * @author Elyas
     */
    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
