package com.codecool.testautomation.pages.KDT;

import com.codecool.testautomation.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

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

    @FindBy(linkText = "Log in again.")
    public WebElement logInAgainLink;

    public final String USER_NAME = Utils.getEnvironmentVariable("USER_NAME");
    public final String PASSWORD = Utils.getEnvironmentVariable("PASSWORD");

    public LoginPage() {}

    public void logInSuccessful(){
        openUrl("/login.jsp");
        usernameField.sendKeys(USER_NAME);
        passwordField.sendKeys(PASSWORD);
        logInButton.click();
    }

    public void fillUsernameAndPassword(String username, String password){
        waitUntilElementLoaded(usernameField);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }


    public void logIn(){
        logInButton.click();
    }

    public void navigateProfile(){
        waitUntilElementClickable(profilePicture);
        profilePicture.click();
        profileButton.click();
    }

    public void logOutSuccessful(){
        waitUntilElementClickable(profilePicture);
        profilePicture.click();
        logOutButton.click();
    }

    public boolean warningMessageIsPresent(){
        waitUntilElementLoaded(warningMessageBox);
        return warningMessageBox.isDisplayed();
    }

    public void navigateLoginAfterLogout(){
        waitUntilElementLoaded(logInAgainLink);
        logInAgainLink.click();
    }
}
