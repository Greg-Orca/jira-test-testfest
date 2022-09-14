package com.codecool.testautomation.pages.KDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class SearchIssuePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div/div/div/div/div/h2")
    public WebElement noIssueFoundMessage;

    public SearchIssuePage() throws MalformedURLException {
    }

    public boolean noIssueFoundMessageIsPresent(){
        waitUntilElementLoaded(noIssueFoundMessage);
        return noIssueFoundMessage.isDisplayed();
    }
}
