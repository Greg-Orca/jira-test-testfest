package com.codecool.testautomation.features.KDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    @FindBy(id = "up-d-username")
    public WebElement profileUsername;

    public ProfilePage() {}

    public String getProfileUsername() {
        waitUntilElementLoaded(profileUsername);
        return profileUsername.getText();
    }
}
