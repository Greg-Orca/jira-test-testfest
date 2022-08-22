package com.codecool.testautomation.features;

import com.codecool.testautomation.utils.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    private Duration WAIT_DURATION = Duration.ofSeconds(5);
    private static String BASE_URL = System.getenv("BASE_URL");

    public BasePage(){
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, WAIT_DURATION);
        driver.manage().window().maximize();
    }

    public void waitUntilElementLoaded(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void openUrl(String url){
        driver.get(BASE_URL+url);
    }
}