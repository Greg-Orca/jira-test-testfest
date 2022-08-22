package com.codecool.testautomation.features;

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

    public CreateIssuePage() {
    }

    public void navigateCreate(){
        waitUntilElementClickable(createButton);
        createButton.click();
    }

    public void fillIssue(String project, String type, String summary){
        selectDropdown(projectSelect,project);
        selectDropdown(issueTypeSelect,type);
        waitUntilElementClickable(summaryField);
        summaryField.sendKeys(summary);

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

    public boolean typeIsPresent(String expected){
        System.out.println(issueTypeSelect.getAttribute("value") + expected);
        return issueTypeSelect.getAttribute("value").equals(expected);
    }
}
