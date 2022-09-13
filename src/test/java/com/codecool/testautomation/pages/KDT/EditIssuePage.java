package com.codecool.testautomation.pages.KDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class EditIssuePage extends BasePage {

    @FindBy(id = "edit-issue")
    public WebElement editButton;

    @FindBy(id = "summary")
    public WebElement editSummaryField;

    @FindBy(id = "edit-issue-submit")
    public WebElement editSubmitButton;

    @FindBy(id = "description")
    public WebElement editDescriptionField;

    @FindBy(xpath = "//*[@id=\"aui-flag-container\"]/div/div")
    public WebElement successfulEditMessage;

    @FindBy(xpath = "//*[@id=\"description-wiki-edit\"]/nav/div/div/ul/li[2]/button")
    public WebElement descriptionSwitchToTextModeButton;

    @FindBy(xpath = "//*[@id=\"edit-issue-dialog\"]/footer/div/div/button")
    public WebElement cancelEditIssueButton;

    @FindBy(xpath = "//*[@id=\"aui-flag-container\"]/div/div/button")
    public WebElement closeSuccessfulMessage;

    public EditIssuePage() throws MalformedURLException {
        super();
    }

    public void openEditIssue(){
        waitUntilElementClickable(editButton);
        editButton.click();
    }

    public void editSummary(String summary){
        waitUntilElementLoaded(editSummaryField);
        editSummaryField.clear();
        editSummaryField.sendKeys(summary);
    }

    public void submitEdit(){
        editSubmitButton.click();
        waitUntilElementLoaded(successfulEditMessage);
        waitUntilElementClickable(closeSuccessfulMessage);
        closeSuccessfulMessage.click();
    }

    public void editDescription(String description){
        waitUntilElementClickable(descriptionSwitchToTextModeButton);
        descriptionSwitchToTextModeButton.click();
        editDescriptionField.clear();
        editDescriptionField.sendKeys(description);
    }

    public void cancelEdit(){
        cancelEditIssueButton.click();
        driver.switchTo().alert().accept();
    }
}