package com.loop.pages;

import com.loop.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class T_Day16_DopucortBasePage {
    T_Day16_DocuportLoginPage day16DocuportLoginPage = new T_Day16_DocuportLoginPage();




    public T_Day16_DopucortBasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void logoutMethod() {

    }
}
