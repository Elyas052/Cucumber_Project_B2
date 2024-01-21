package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PizzaOrderWebTableUtils {

    /**
     * Returns the value of a specific field for a given name in the pizza order web table.
     *
     * @param driver The WebDriver instance.
     * @param name   The name associated with the row in the web table.
     * @param field  The field for which the value needs to be retrieved (e.g., "Pizza Type", "Amount", etc.).
     * @return The text value of the specified field.
     * @author Elyas
     */
    public static String returnAnyFieldValue(WebDriver driver, String name, String field) {
        String index = "";

        // Determine the index based on the specified field
        if (field.equalsIgnoreCase("Pizza Type")) {
            index = "[1]";
        } else if (field.equalsIgnoreCase("Amount")) {
            index = "[2]";
        } else if (field.equalsIgnoreCase("Date")) {
            index = "[3]";
        } else if (field.equalsIgnoreCase("Street")) {
            index = "[4]";
        } else if (field.equalsIgnoreCase("City")) {
            index = "[5]";
        } else if (field.equalsIgnoreCase("State")) {
            index = "[6]";
        } else if (field.equalsIgnoreCase("Zip")) {
            index = "[7]";
        } else if (field.equalsIgnoreCase("Card")) {
            index = "[8]";
        } else if (field.equalsIgnoreCase("Card Number")) {
            index = "[9]";
        } else if (field.equalsIgnoreCase("Exp")) {
            index = "[10]";
        } else {
            System.out.println("There is not such a field: " + field);
        }

        // Find the WebElement using XPath and return its trimmed text value
        WebElement element = driver.findElement(By.xpath("//td[.='" + name + "']//following-sibling::td" + index));
        return element.getText().trim();
    }
}
