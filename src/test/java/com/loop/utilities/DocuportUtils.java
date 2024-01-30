package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtils {

    /**
     * Logins to the Docuport application with the specified role.
     *
     * @param driver WebDriver instance initialized in the test base
     * @param role   Role of the user (e.g., "client", "supervisor", "advisor", "employee")
     * @throws InterruptedException   Thrown if the thread is interrupted during sleep
     * @throws InputMismatchException Thrown if an invalid role is provided
     * @author Elyas
     */
    public static void login(WebDriver driver, String role) throws InterruptedException, InputMismatchException {
        // Navigate to the Docuport application
        Driver.getDriver().get(ConfigurationReader.getProperty("env"));

        // Locate username, password, and login button elements
        WebElement username = Driver.getDriver().findElement(By.xpath("//label[.='Username or email']//following-sibling::input"));
        WebElement password = Driver.getDriver().findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));

        // Fill in credentials based on the specified role
        switch (role.toLowerCase()) {
            case "client":
                username.sendKeys(DocuportConstants.USERNAME_CLIENT);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "supervisor":
                username.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "advisor":
                username.sendKeys(DocuportConstants.USERNAME_ADVISOR);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            case "employee":
                username.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
                password.sendKeys(DocuportConstants.PASSWORD);
                break;
            default:
                throw new InputMismatchException("There is no such role: " + role);
        }

        // Click the login button
        loginButton.click();

        // Additional steps for a client role
        if (role.toLowerCase().equals("client")) {
            Thread.sleep(3000);
            WebElement cont = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
            cont.click();
            Thread.sleep(3000);
        }
    }

    /**
     * Logs out from the Docuport application.
     *
     * @param driver WebDriver instance
     * @author Elyas
     */
    public static void logOut(WebDriver driver) {
        // Manage timeouts
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Locate user icon and click
        WebElement userIcon = Driver.getDriver().findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();

        // Manage timeouts
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        // Locate the log-out button and click
        WebElement logOut = Driver.getDriver().findElement(By.xpath("//span[contains(text(),'Log out')]"));
        logOut.click();

        // Manage timeouts
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }
}