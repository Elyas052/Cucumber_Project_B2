package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportWebTableUtils {

    /**
     * Returns any field from the table by index.
     *
     * @param driver       The WebDriver instance.
     * @param emailAddress The email address used to identify the row in the table.
     * @param field        The field name to retrieve from the table.
     * @author Elyas
     */
    public static String returnAnyField(WebDriver driver, String emailAddress, String field) {
        WebElement element = null;
        String xpath = "";
        switch (field.toLowerCase()) {
            case "full name":
                xpath = "//td[2][text()='" + emailAddress + "']/preceding-sibling::td//span[2]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "username":
                xpath = "//td[2][text()='" + emailAddress + "']/following-sibling::td[1]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "inviter":
                xpath = "//td[2][text()='" + emailAddress + "']/following-sibling::td[2]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "phone number":
                xpath = "//td[2][text()='" + emailAddress + "']/following-sibling::td[3]/span";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "role":
                xpath = "//td[2][text()='" + emailAddress + "']/following-sibling::td[4]/span/span";
                element = driver.findElement(By.xpath(xpath));
                break;
            default:
                throw new InputMismatchException("There is not such a role: " + field);
        }
        return element.getText().trim();
    }
}
