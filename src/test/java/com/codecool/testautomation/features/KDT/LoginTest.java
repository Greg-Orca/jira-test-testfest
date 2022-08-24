package com.codecool.testautomation.features.KDT;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class LoginTest {
    static LoginPage loginPage;
    static ProfilePage profilePage;
    private static final String FAIL_TEST_DATA_SOURCE = "/login_fail.csv";

    @BeforeAll
    public static void setUp(){
        loginPage = new LoginPage();
        profilePage = new ProfilePage();
        loginPage.openUrl("/login.jsp");
    }

    @AfterAll
    public static void tearDown(){
        loginPage.logInSuccessful();
        quitDriver();
    }

    @Test
    public void loginSuccessful(){
        String username = loginPage.USER_NAME;
        String password = loginPage.PASSWORD;
        loginPage.fillUsernameAndPassword(username, password);
        loginPage.logIn();
        loginPage.navigateProfile();
        Assertions.assertEquals(username,profilePage.getProfileUsername());
    }

    @ParameterizedTest
    @CsvFileSource(resources = FAIL_TEST_DATA_SOURCE, numLinesToSkip = 1)
    void loginFail(String username, String password, String expected){
//        if (username==null){
//            username = "";
//        }
//        else if (password==null){
//            password = "";
//        }
        System.out.println(username);
        loginPage.fillUsernameAndPassword(username,password);
        loginPage.logIn();
        String actual = loginPage.logInErrorMessage.getText();
        Assertions.assertEquals(expected, actual);

    }

}
