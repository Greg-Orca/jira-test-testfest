package com.codecool.testautomation.features;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class BrowseIssueTest {
    static final String ISSUES_SOURCES = "/issues_sources.csv";
    static IssuePage issuePage;
    static LogInPage logInPage;

    @BeforeAll
    public static void setUp(){
        issuePage = new IssuePage();
        logInPage = new LogInPage();
        logInPage.logInSuccessful();
    }

    @AfterAll
    public static void tearDown(){
        quitDriver();
    }

    @ParameterizedTest
    @CsvFileSource(resources = ISSUES_SOURCES, numLinesToSkip = 1)
    public void findIssues(String issueUrl,String expectedResult){
        issuePage.openUrl(issueUrl);
        String actualResult = issuePage.getIssueKeyVal();
        Assertions.assertEquals(expectedResult,actualResult);
    }
}
