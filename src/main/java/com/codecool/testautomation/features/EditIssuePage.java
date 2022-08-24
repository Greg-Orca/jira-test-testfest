package com.codecool.testautomation.features;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditIssuePage extends BasePage {

    @FindBy(id = "edit-issue")
    WebElement editButton;

    @FindBy(id = "summary")
    WebElement editSummaryField;

    @FindBy(id = "edit-issue-submit")
    WebElement editSubmitButton;

    @FindBy(id = "description")
    WebElement editDescriptionField;

    @FindBy(xpath = "//*[@id=\"aui-flag-container\"]/div/div")
    WebElement successfulEditMessage;

    @FindBy(xpath = "//*[@id=\"description-wiki-edit\"]/nav/div/div/ul/li[2]/button")
    WebElement descriptionSwitchToTextModeButton;

    @FindBy(xpath = "//*[@id=\"edit-issue-dialog\"]/footer/div/div/button")
    WebElement cancelEditIssueButton;

    public EditIssuePage() {
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
