package com.codecool.testautomation.features.KDT;

import com.codecool.testautomation.pages.KDT.IssuePage;
import com.codecool.testautomation.pages.KDT.LoginPage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import java.net.MalformedURLException;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class BrowseIssueTest {
    static final String ISSUES_SOURCES = "/issues_sources.csv";
    static IssuePage issuePage;
    static LoginPage loginPage;

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        issuePage = new IssuePage();
        loginPage = new LoginPage();
        loginPage.logInSuccessful();
    }

    @AfterEach
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void searchIssueSuccessful(){
        String summary = "Happy Path";
        issuePage.navigateToSearchIssuePage();
        issuePage.searchForIssue(summary);
        String result = issuePage.getSummaryValue();
        Assertions.assertEquals(summary,result);
    }

    @ParameterizedTest
    @CsvFileSource(resources = ISSUES_SOURCES, numLinesToSkip = 1)
    public void findIssues(String issueUrl,String expectedResult){
        issuePage.openUrl(issueUrl);
        String actualResult = issuePage.getIssueKeyVal();
        Assertions.assertEquals(expectedResult,actualResult);
    }
}
