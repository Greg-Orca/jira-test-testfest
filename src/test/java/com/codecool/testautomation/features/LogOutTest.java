package com.codecool.testautomation.features;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class LogOutTest {
    static LogInPage logInPage;
    static ProfilePage profilePage;

    @BeforeAll
    public static void setUp(){
        logInPage = new LogInPage();
        profilePage = new ProfilePage();
    }

    @AfterAll
    public static void tearDown(){
        quitDriver();
    }

    @Test
    public void logOutSuccessful(){
        logInPage.logInSuccessful();
        logInPage.logOutSuccessful();
        logInPage.openUrl("/secure/ViewProfile.jspa");
        Assertions.assertTrue(logInPage.warningMessageIsPresent());

    }
}
