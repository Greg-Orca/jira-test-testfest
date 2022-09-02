package com.codecool.testautomation.features.KDT;

import com.codecool.testautomation.pages.KDT.LoginPage;
import com.codecool.testautomation.pages.KDT.ProfilePage;
import com.codecool.testautomation.utils.Utils;
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

    }

    @BeforeEach
    public void setUpEach(){
        loginPage.openUrl("/login.jsp");
    }

    @AfterAll
    public static void tearDown(){
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
    void loginUnsuccessful(String username, String password, String expected){
        String passwordNonNull = Utils.nullToEmptyString(password);
        String usernameNonNull = Utils.nullToEmptyString(username);
        System.out.println(username);
        loginPage.fillUsernameAndPassword(usernameNonNull,passwordNonNull);
        loginPage.logIn();
        String actual = loginPage.logInErrorMessage.getText();
        Assertions.assertEquals(expected, actual);
        //restore user token, avoid captcha
        loginPage.logInSuccessful();
        loginPage.logOutSuccessful();
    }
}