/**
 * Page class for the Product Page of the application.
 * Provides methods for interacting with product-related functionalities.
 * Includes clickCategory and getProductPrice methods.
 * Uses XPath locators to identify elements such as category links and product prices.
 * Constructor initializes elements using PageFactory.
 */
package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {

    /**
     * Clicks on the specified category link.
     *
     * @param category The name of the category to click.
     */
    public void clickCategory(String category) {
        // Using XPath to find the category link and click on it
        Driver.getDriver().findElement(By.xpath("//a[contains(.,'" + category + "')]")).click();
    }

    /**
     * Retrieves the price of the specified product.
     *
     * @param product The name of the product to get the price for.
     * @return The price of the specified product (excluding currency symbol).
     */
    public String getProductPrice(String product) {
        // Using XPath to find the parent element of the product and retrieve its price
        String actualPrice = Driver.getDriver().findElement(By.xpath("//a[normalize-space(.)='" + product + "']/../../h5")).getText();
        // Trimming the currency symbol from the retrieved price
        return actualPrice.substring(1);
    }

    /**
     * Constructor to initialize elements using PageFactory.
     */
    public ProductPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
