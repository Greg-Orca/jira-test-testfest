package com.codecool.testautomation.features;

import org.junit.jupiter.api.*;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class EditIssueTest {
    static LogInPage logInPage;
    static EditIssuePage editIssuePage;
    static IssuePage issuePage;

    @BeforeAll
    public static void setUp() {
        logInPage = new LogInPage();
        editIssuePage = new EditIssuePage();
        issuePage = new IssuePage();
    }

    @BeforeEach
    public void setUpEach(){
        logInPage.logInSuccessful();
        issuePage.openUrl("/projects/MTP/issues/MTP-2020");
    }

    @AfterEach
    public void restore(){
        String summary = "Happy Path";
        String description = "";
        editIssuePage.openEditIssue();
        editIssuePage.editSummary(summary);
        editIssuePage.editDescription(description);
        editIssuePage.submitEdit();
    }

    @AfterAll
    public static void tearDown(){
        quitDriver();
    }

    @Test
    public void editExistingIssueSuccessful(){
        String summary = "Happy Path Edit";
        editIssuePage.openEditIssue();
        editIssuePage.editSummary(summary);
        editIssuePage.submitEdit();
        String actualValue = issuePage.getSummaryValue();
        Assertions.assertEquals(summary,actualValue);
    }

    @Test
    public void addNewFieldToIssueSuccessful(){
        String description = "new description";
        editIssuePage.openEditIssue();
        editIssuePage.editDescription(description);
        editIssuePage.submitEdit();
        String actualDescription = issuePage.getDescriptionValue();
        Assertions.assertEquals(description,actualDescription);
    }
}
