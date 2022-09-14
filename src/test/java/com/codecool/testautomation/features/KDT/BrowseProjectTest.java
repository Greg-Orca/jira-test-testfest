package com.codecool.testautomation.features.KDT;

import com.codecool.testautomation.pages.KDT.BrowseProjectPage;
import com.codecool.testautomation.pages.KDT.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.net.MalformedURLException;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class BrowseProjectTest {
    static final String PROJECTS_SOURCES = "/project_sources.csv";
    static BrowseProjectPage browseProjectPage;
    static LoginPage loginPage;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        browseProjectPage = new BrowseProjectPage();
        loginPage = new LoginPage();
        loginPage.logInSuccessful();
    }

    @AfterEach
    public static void tearDown(){
        quitDriver();
    }

    @Test
    public void browseProject(){
        browseProjectPage.openUrl("/secure/BrowseProjects.jspa");
        browseProjectPage.waitUntilElementLoaded(browseProjectPage.mtpLink);
        Assertions.assertTrue(browseProjectPage.mtpLink.isDisplayed());
    }

    @ParameterizedTest
    @CsvFileSource(resources = PROJECTS_SOURCES, numLinesToSkip = 1)
    public void findProjects(String projectName, String exceptedResult){
        browseProjectPage.openUrl("/secure/BrowseProjects.jspa");
        browseProjectPage.findProject(projectName);
        boolean isPresent = browseProjectPage.projectIsPresent(exceptedResult);
        Assertions.assertTrue(isPresent);
    }
}
