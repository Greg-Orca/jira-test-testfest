package com.codecool.testautomation.pages.KDT;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateIssuePage extends BasePage {

    @FindBy(linkText = "Create")
    public WebElement createButton;

    @FindBy(id = "project-field")
    public WebElement projectSelect;

    @FindBy(id = "issuetype-field")
    public WebElement issueTypeSelect;

    @FindBy(id = "summary")
    public WebElement summaryField;

    @FindBy(id = "create-issue-submit")
    public WebElement createIssueButton;

    @FindBy(xpath = "//*[@id=\"aui-flag-container\"]/div/div/a")
    public WebElement successfulMessage;

    @FindBy(xpath = "//*[@id=\"dialog-form\"]/div/div[2]/div[1]/div")
    public WebElement summaryErrorMessage;

    @FindBy(xpath = "//*[@id=\"create-issue-dialog\"]/footer/div/div/button")
    public WebElement cancelIssueButton;

    @FindBy(xpath = "//*[@id=\"create-issue-dialog\"]/header/h2")
    public WebElement issueTitle;

    public CreateIssuePage() {
    }

    public void navigateCreate(){
        waitUntilElementClickable(createButton);
        createButton.click();
    }

    public void fillIssue(String project, String type, String summary){
        selectDropdown(projectSelect,project);
        selectDropdown(issueTypeSelect,type);
        issueTitle.click();
        waitUntilElementClickable(summaryField);
        summaryField.sendKeys(summary);
        issueTitle.click();
    }

    public void createIssue(){
        waitUntilElementClickable(createIssueButton);
        createIssueButton.click();
    }

    public void navigateToNewIssue(){
        waitUntilElementClickable(successfulMessage);
        successfulMessage.click();
    }

    public void selectDropdown(WebElement webElement, String text){
        String os = System.getProperty("os.name");
        waitUntilElementClickable(webElement);
        if (os.equals("Mac OS X")){
            webElement.sendKeys(Keys.COMMAND,"a",Keys.DELETE);
        }
        else {
            webElement.sendKeys(Keys.CONTROL,"a",Keys.DELETE);
        }
        webElement.sendKeys(text);
        webElement.sendKeys(Keys.ENTER);
    }

    public boolean summaryErrorMessageIsPresent(){
        waitUntilElementLoaded(summaryErrorMessage);
        return summaryErrorMessage.isDisplayed();
    }

    public void cancelCreateIssue(){
        waitUntilElementClickable(cancelIssueButton);
        cancelIssueButton.click();
        driver.switchTo().alert().accept();
    }

    public String typeIsPresent(){
        return issueTypeSelect.getAttribute("value");
    }

    public void createSubtask(String summary){
        waitUntilElementLoaded(summaryField);
        summaryField.sendKeys(summary);
        createIssueButton.click();
    }
}
