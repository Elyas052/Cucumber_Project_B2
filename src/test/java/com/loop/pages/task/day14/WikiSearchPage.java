package com.loop.pages.task.day14;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikiSearchPage {

    @FindBy(xpath = "//input[@id='searchInput']")
    public WebElement searchBox;

    @FindBy(xpath = "//h1[@id='firstHeading']")
    public WebElement wikiTitle;

    @FindBy(xpath = "//span[@class='mw-page-title-main']")
    public WebElement mainHeader;

    @FindBy(xpath = "//div[@style='display:inline-block']")
    public WebElement imageHeader;


    /**
     * Initializes the GoogleSearchPage by initializing the PageFactory.
     */
    public WikiSearchPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
