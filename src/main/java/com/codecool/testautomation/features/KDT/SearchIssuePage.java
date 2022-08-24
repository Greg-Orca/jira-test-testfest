package com.codecool.testautomation.features.KDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchIssuePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div/div/div/div/div/div/h2")
    public WebElement noIssueFoundMessage;

    public SearchIssuePage() {
    }

    public boolean noIssueFoundMessageIsPresent(){
        waitUntilElementLoaded(noIssueFoundMessage);
        return noIssueFoundMessage.isDisplayed();
    }
}
