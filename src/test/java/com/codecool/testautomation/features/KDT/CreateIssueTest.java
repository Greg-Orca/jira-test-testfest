package com.codecool.testautomation.features.KDT;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class CreateIssueTest {
    static final String CREATE_ISSUE_WITH_TYPES = "/create_issue_with_types.csv";
    static final String CREATE_ISSUE_SUBTASK = "/create_issue_subtask.csv";
    static CreateIssuePage createIssuePage;
    static LoginPage loginPage;
    static IssuePage issuePage;
    static SearchIssuePage searchIssuePage;

    @BeforeAll
    public static void setUp(){
        createIssuePage = new CreateIssuePage();
        issuePage = new IssuePage();
        loginPage = new LoginPage();
        searchIssuePage = new SearchIssuePage();
        loginPage.logInSuccessful();
    }

    @AfterAll
    public static void tearDown(){
//        quitDriver();
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

    @Test
    public void cancelIssueSuccessful(){
        String project = "mtp";
        String type = "bug";
        String summary = "new issue test";
        createIssuePage.navigateCreate();
        createIssuePage.fillIssue(project,type ,summary);
        createIssuePage.cancelCreateIssue();
        createIssuePage.openUrl("/issues/?jql=project%20%3D%20MTP%20AND%20text%20~%20%27new%20issue%20test%27");
        Assertions.assertTrue(searchIssuePage.noIssueFoundMessageIsPresent());
    }

    @ParameterizedTest
    @CsvFileSource(resources = CREATE_ISSUE_WITH_TYPES, numLinesToSkip = 1)
    public void specificIssuesHaveIssueTypes(String project,String type,String expected){
        createIssuePage.navigateCreate();
        createIssuePage.fillIssue(project,type,"...");
        Assertions.assertTrue(createIssuePage.typeIsPresent(expected));
        createIssuePage.cancelCreateIssue();
    }

    @ParameterizedTest
    @CsvFileSource(resources = CREATE_ISSUE_SUBTASK, numLinesToSkip = 1)
    public void createIssueWithSubtask(String url,String subtaskName, String expected){
        issuePage.openUrl(url);
        issuePage.navigateToCreateSubtask();
        createIssuePage.createSubtask(subtaskName);
        boolean result= expected.equals("true") && issuePage.subtaskIsPresent();
        Assertions.assertTrue(result);
        issuePage.deleteSubtask();
    }
}
