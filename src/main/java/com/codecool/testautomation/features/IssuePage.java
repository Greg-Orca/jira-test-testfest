package com.codecool.testautomation.features;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IssuePage extends BasePage{

    @FindBy(id = "summary-val")
    public WebElement summaryValue;

    @FindBy(id = "opsbar-operations_more")
    public WebElement moreButton;

    @FindBy(id = "delete-issue")
    public WebElement deleteIssueButton;

    @FindBy(id = "delete-issue-submit")
    public WebElement deleteIssueConfirmButton;

    @FindBy(id = "aui-flag-container")
    public WebElement popupFlagContainer;

    public IssuePage() {
    }

    public String getSummaryValue(){
        waitUntilElementLoaded(summaryValue);
        return summaryValue.getText();
    }

    public void deleteIssue(){
        waitUntilElementClickable(moreButton);
        moreButton.click();
        waitUntilElementClickable(deleteIssueButton);
        deleteIssueButton.click();
        waitUntilElementClickable(deleteIssueConfirmButton);
        deleteIssueConfirmButton.click();
        waitUntilElementLoaded(popupFlagContainer);
        System.out.println(popupFlagContainer.getText());
    }
}
