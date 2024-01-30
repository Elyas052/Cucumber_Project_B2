package com.loop.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SmartBearSoftConstants {

    public static final String USERNAME = "Tester";
    public static final String PASSWORD = "test";
    public static final String FAMILY_ALBUM = "FamilyAlbum";
    public static final String SUCCESS_MESSAGE = "New order has been successfully added.";

    public static final int EXTRA_SMALL = 3;
    public static final int SMALL = 5;
    public static final int MEDIUM = 7;
    public static final int LARGE = 10;
    public static final int EXTRA_LARGE = 20;

    public static final String QUANTITY = "quantity";
    public static final String CUSTOMER_NAME = "customer name";
    public static final String STREET = "street";
    public static final String CITY = "city";
    public static final String STATE = "state";
    public static final String ZIP = "zip";

    public static final String CREDIT_CARD_NUMBER = "credit car number";
    public static final String EXPIRATION_DATE = "expiration date";

    public static Faker faker = new Faker();

    public static void fillAddressInformation(List<WebElement> elements) {
        List<String> data = new ArrayList<>(Arrays.asList(faker.name().fullName(),
                faker.address().streetAddress(), faker.address().cityName(), faker.address().state(),
                faker.address().zipCode().split("-")[0]));
        for (int i = 0; i < data.size(); i++) {
            elements.get(i).sendKeys(data.get(i));
        }
    }

    public static WebElement cardPaymentSystem (String systemType) {
        WebElement PaymentSystem = Driver.getDriver().findElement(By.xpath("//h3[.='Payment Information']//following-sibling::ol//*/*[.='" + systemType + "']/input"));
        return PaymentSystem;
    }

    public static Faker getFaker() {
        return new Faker();
    }

    public static String formatExpirationDate() {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/yy");
        return sdf.format(faker.date().birthday());
    }
}
