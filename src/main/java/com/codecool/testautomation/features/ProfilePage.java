package com.codecool.testautomation.features;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{
    @FindBy(id = "up-d-username")
    public WebElement profileUsername;

    public ProfilePage() {}

    public String getProfileUsername() {
        return profileUsername.getText();
    }
}
