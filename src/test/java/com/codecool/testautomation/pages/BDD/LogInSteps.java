package com.codecool.testautomation.pages.BDD;

import com.codecool.testautomation.pages.KDT.BasePage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInSteps extends BasePage {
    final String BASE_URL = "https://jira-auto.codecool.metastage.net";
    final String USER_NAME = System.getenv("USER_NAME");
    final String PASSWORD = System.getenv("PASSWORD");

    @FindBy(id = "login-form-username")
    public WebElement usernameField;

    @FindBy(id = "login-form-password")
    public WebElement passwordField;

    @FindBy(id = "login-form-submit")
    public WebElement logInButton;

    @FindBy(id = "header-details-user-fullname")
    public WebElement profilePicture;

    @FindBy(id = "view_profile")
    public WebElement profileButton;

    @FindBy(id = "up-user-title-name")
    public WebElement profileName;

    @FindBy(css = "p:nth-child(1)")
    public WebElement logInErrorMessage;

    @FindBy(id = "log_out")
    public WebElement logOutButton;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div[1]/div[1]")
    public WebElement warningMessageBox;

    @FindBy(id = "up-d-username")
    public WebElement profileUsername;


    @Given("user is on login page")
    public void userIsOnLoginPage(){
        driver.get(BASE_URL+"/login.jsp");
    }

    @When("user enters username and password")
    public void enterUsernamePassword(){
        usernameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);

    }

    @When("user enters {string} and {string}")
    public void enterUsernamePassword(String username, String password){
        if(username.equals("valid")){
            usernameField.sendKeys(USER_NAME);
        }
        else {
            usernameField.sendKeys("invalidun");
        }
        if(password.equals("valid")){
            passwordField.sendKeys(PASSWORD);
        }
        else {
            passwordField.sendKeys("invalidpw");
        }

    }
    @And("click login")
    public void clickLogin(){
        logInButton.click();
    }

    @Then("user profile page is visible")
    public void profilePageCheck(){
        profilePicture.click();
        profileButton.click();
        Assertions.assertEquals(USER_NAME,profileUsername.getText());
    }

    @Then("user profile page is not visible")
    public void profileNotVisible(){
        driver.get(BASE_URL+"/secure/ViewProfile.jspa");
        wait.until(ExpectedConditions.visibilityOf(warningMessageBox));
        Assertions.assertTrue(warningMessageBox.isDisplayed());
    }

    @And("restore user login")
    public void restoreUserLogin(){
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        logInButton.click();
    }

    @And("user is logged in")
    public void userLoginSuccessful(){
        driver.get(BASE_URL+"/login.jsp");
        usernameField.clear();
        passwordField.clear();
        usernameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        logInButton.click();
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
