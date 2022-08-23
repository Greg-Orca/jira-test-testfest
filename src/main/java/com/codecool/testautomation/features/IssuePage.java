package com.codecool.testautomation.features;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

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

    @FindBy(id = "create-subtask")
    public WebElement createSubtaskButton;

    @FindBy(linkText = "subtask-test")
    public WebElement subtaskTest;

    @FindBy(id = "issues-subnavigation-title")
    public WebElement issueSubnavigationTitle;

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

    public void navigateToCreateSubtask(){
        waitUntilElementClickable(moreButton);
        moreButton.click();
        createSubtaskButton.click();
    }

    public boolean subtaskIsPresent(){
        return elementIsPresent(subtaskTest);
    }

    public void deleteSubtask(){
        subtaskTest.click();
        waitUntilElementClickable(moreButton);
        wait.until(ExpectedConditions.invisibilityOf(issueSubnavigationTitle));
        moreButton.click();
        waitUntilElementClickable(deleteIssueButton);
        deleteIssueButton.click();
        waitUntilElementClickable(deleteIssueConfirmButton);
        deleteIssueConfirmButton.click();
    }

}
