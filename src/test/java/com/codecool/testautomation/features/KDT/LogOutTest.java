package com.codecool.testautomation.features.KDT;

import com.codecool.testautomation.pages.KDT.LoginPage;
import com.codecool.testautomation.pages.KDT.ProfilePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class LogOutTest {
    static LoginPage loginPage;
    static ProfilePage profilePage;

    @BeforeAll
    public static void setUp(){
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }

    @AfterAll
    public static void tearDown(){
        quitDriver();
    }

    @Test
    public void logOutSuccessful(){
        loginPage.logInSuccessful();
        loginPage.logOutSuccessful();
        loginPage.openUrl("/secure/ViewProfile.jspa");
        Assertions.assertTrue(loginPage.warningMessageIsPresent());
    }
}
