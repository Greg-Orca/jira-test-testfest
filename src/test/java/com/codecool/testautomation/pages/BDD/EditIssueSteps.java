package com.codecool.testautomation.pages.BDD;

import com.codecool.testautomation.pages.KDT.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditIssueSteps extends BasePage {
    final String BASE_URL = "https://jira-auto.codecool.metastage.net";
    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

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

    @FindBy(id = "summary-val")
    public WebElement summaryValue;



    @When("user edit an issue summary to {string}")
    public void editIssue(String summary){
        driver.get(BASE_URL+"/projects/MTP/issues/MTP-2020");
        editButton.click();
        editSummaryField.clear();
        editSummaryField.sendKeys(summary);
        editSubmitButton.click();
    }

    @Then("issue is renamed to {string}")
    public void validateIssueIsRenamed(String summary){
        successfulEditMessage.isDisplayed();
        Assertions.assertEquals(summary,summaryValue.getText());

    }

    @And("user restore the issue to {string}")
    public void restoreIssuer(String summary){
        editButton.click();
        editSummaryField.clear();
        editSummaryField.sendKeys(summary);
        editSubmitButton.click();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
