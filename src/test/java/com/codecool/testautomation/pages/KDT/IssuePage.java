package com.codecool.testautomation.pages.KDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

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

    @FindBy(id = "key-val")
    public WebElement issueKeyVal;

    @FindBy(id = "find_link")
    public WebElement issueMenuButton;

    @FindBy(id = "issues_new_search_link_lnk")
    public WebElement issueMenuSearchButton;

    @FindBy(id = "searcher-query")
    public WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[1]/form/div[1]/div[1]/div[1]/div[1]/div/div[1]/ul/li[7]/button")
    public WebElement searchIssueButton;

    @FindBy(id = "description-val")
    public WebElement descriptionValue;

    public IssuePage() throws MalformedURLException {
        super();
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

    public String getIssueKeyVal(){
        waitUntilElementLoaded(issueKeyVal);
        return issueKeyVal.getText();
    }

    public void navigateToSearchIssuePage(){
        waitUntilElementClickable(issueMenuButton);
        issueMenuButton.click();
        waitUntilElementClickable(issueMenuSearchButton);
        issueMenuSearchButton.click();
    }

    public void searchForIssue(String summary){
        waitUntilElementLoaded(searchBar);
        searchBar.sendKeys(summary);
        searchIssueButton.click();
    }

    public String getDescriptionValue(){
        waitUntilElementLoaded(descriptionValue);
        return descriptionValue.getText();
    }

}
