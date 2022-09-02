package com.codecool.testautomation.features.KDT;

import com.codecool.testautomation.pages.KDT.CreateIssuePage;
import com.codecool.testautomation.pages.KDT.IssuePage;
import com.codecool.testautomation.pages.KDT.LoginPage;
import com.codecool.testautomation.pages.KDT.SearchIssuePage;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class CreateIssueTest {
    static final String CREATE_ISSUE_WITH_TYPES = "/create_issue_with_types.csv";
    static final String CREATE_ISSUE_SUBTASK = "/create_issue_subtask.csv";
    static CreateIssuePage createIssuePage;
    static LoginPage loginPage;
    static IssuePage issuePage;
    static SearchIssuePage searchIssuePage;


    @BeforeEach
    public void SetUp(){
        createIssuePage = new CreateIssuePage();
        issuePage = new IssuePage();
        searchIssuePage = new SearchIssuePage();
        loginPage = new LoginPage();
        loginPage.logInSuccessful();
    }

    @AfterEach
    public void tearDown(){
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