package com.codecool.testautomation.features;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class CreateIssueTest {
    static CreateIssuePage createIssuePage;
    static LogInPage logInPage;
    static IssuePage issuePage;

    @BeforeAll
    public static void setUp(){
        createIssuePage = new CreateIssuePage();
        issuePage = new IssuePage();
        logInPage = new LogInPage();
        logInPage.logInSuccessful();
    }

    @AfterAll
    public static void tearDown(){
        quitDriver();
    }

    @Test
    public void createIssueSuccessful(){
        String project = "mtp";
        String type = "bug";
        String summary = "new issue test";
        createIssuePage.navigateCreate();
        createIssuePage.fillIssue(project,type ,summary);
        createIssuePage.createIssue();
        createIssuePage.navigateToNewIssue();
        String actualResult = issuePage.getSummaryValue();
        Assertions.assertEquals(summary,actualResult);
        issuePage.deleteIssue();
    }

    @Test
    public void createIssueEmptySummaryUnsuccessful(){
        String project = "mtp";
        String type = "bug";
        String summary = "";
        createIssuePage.navigateCreate();
        createIssuePage.fillIssue(project,type ,summary);
        createIssuePage.createIssue();
        Assertions.assertTrue(createIssuePage.summaryErrorMessageIsPresent());
    }
}
