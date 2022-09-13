package com.codecool.testautomation.pages.KDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class ProfilePage extends BasePage{
    @FindBy(id = "up-d-username")
    public WebElement profileUsername;

    public ProfilePage() throws MalformedURLException {
        super();
    }

    public String getProfileUsername() {
        waitUntilElementLoaded(profileUsername);
        return profileUsername.getText();
    }
}
