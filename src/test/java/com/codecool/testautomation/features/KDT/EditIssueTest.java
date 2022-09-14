package com.codecool.testautomation.features.KDT;

import com.codecool.testautomation.pages.KDT.EditIssuePage;
import com.codecool.testautomation.pages.KDT.IssuePage;
import com.codecool.testautomation.pages.KDT.LoginPage;
import org.junit.jupiter.api.*;

import java.net.MalformedURLException;

import static com.codecool.testautomation.utils.DriverSingleton.quitDriver;

public class EditIssueTest {
    static LoginPage loginPage;
    static EditIssuePage editIssuePage;
    static IssuePage issuePage;
    private final String SUMMARY = "Happy Path";
    private final String SUMMARY_EDIT = "Happy Path Edit";
    private final String DESCRIPTION = "new description";

    @BeforeAll
    public static void setUp() throws MalformedURLException {
        loginPage = new LoginPage();
        editIssuePage = new EditIssuePage();
        issuePage = new IssuePage();
    }

    @BeforeEach
    public void setUpEach(){
        loginPage.logInSuccessful();
        issuePage.openUrl("/projects/MTP/issues/MTP-2020");
    }

    @AfterEach
    public void restore() {
        String description = "";
        editIssuePage.openEditIssue();
        editIssuePage.editSummary(SUMMARY);
        editIssuePage.editDescription(description);
        editIssuePage.submitEdit();
        editIssuePage.getResult();
    }

    @AfterAll
    public void tearDown(){
        quitDriver();
    }

    @Test
    public void editExistingIssueSuccessful(){

        editIssuePage.openEditIssue();
        editIssuePage.editSummary(SUMMARY_EDIT);
        editIssuePage.submitEdit();
        String actualSummary = issuePage.getSummaryValue();
        Assertions.assertEquals(SUMMARY_EDIT,actualSummary);
    }

    @Test
    public void addNewFieldToIssueSuccessful(){
        editIssuePage.openEditIssue();
        editIssuePage.editDescription(DESCRIPTION);
        editIssuePage.submitEdit();
        String actualDescription = issuePage.getDescriptionValue();
        Assertions.assertEquals(DESCRIPTION,actualDescription);
    }

    @Test
    public void editIssueCancelSuccessful(){
        editIssuePage.openEditIssue();
        editIssuePage.editSummary(SUMMARY_EDIT);
        editIssuePage.cancelEdit();
        String actualSummary = issuePage.getSummaryValue();
        Assertions.assertEquals(SUMMARY,actualSummary);
    }
}
