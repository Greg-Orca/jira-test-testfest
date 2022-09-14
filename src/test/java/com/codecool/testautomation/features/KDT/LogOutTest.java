package com.codecool.testautomation.features.KDT;

import com.codecool.testautomation.pages.KDT.LoginPage;
import com.codecool.testautomation.pages.KDT.ProfilePage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class LogOutTest {
    static LoginPage loginPage;
    static ProfilePage profilePage;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
    }

    @AfterEach
    public void tearDown(){
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
