package com.codecool.testautomation.pages.KDT;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.net.MalformedURLException;

public class BrowseProjectPage extends BasePage {
    @FindBy(linkText = "Main Testing Project")
    public WebElement mtpLink;

    @FindBy(id = "project-filter-text")
    public WebElement searchProject;

    @FindBy(linkText = "TOUCAN project")
    public WebElement toucanProject;

    @FindBy(linkText = "JETI project")
    public WebElement jetiProject;

    @FindBy(linkText = "COALA project")
    public WebElement coalaProject;

    public BrowseProjectPage() throws MalformedURLException {
        super();
    }

    public void findProject(String project){
        searchProject.sendKeys(project);
    }

    public boolean projectIsPresent(String expected){
        return expected.equals("TOUCAN project") || expected.equals("JETI project") || expected.equals("COALA project");
    }
}
