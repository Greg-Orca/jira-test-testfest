package com.codecool.testautomation.features;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class LogInTest {
    static LogInPage lp;

    @BeforeAll
    public static void setUp(){
        lp = new LogInPage();
        lp.openUrl("https://jira-auto.codecool.metastage.net/login.jsp");
    }

    @AfterAll
    public static void tearDown(){
        quitDriver();
    }

    @Test
    public void logInSuccessful(){
        lp.fillUsernameAndPassword();
        lp.logIn();
//        lp.validateLogin();
//        Assertions.assertEquals("Auto Tester "+ LogIn.keyCode, lp.profileName.getText());
    }
}
