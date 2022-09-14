package com.codecool.testautomation.pages.KDT;

import com.codecool.testautomation.utils.DriverSingleton;
import com.codecool.testautomation.utils.Utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.time.Duration;

public abstract class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;
    private final Duration WAIT_DURATION = Duration.ofSeconds(3);
//    private static String BASE_URL = Utils.getEnvironmentVariable("BASE_URL");
    private static String BASE_URL = System.getenv("BASE_URL");

    public BasePage() throws MalformedURLException {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, WAIT_DURATION);
        driver.manage().window().maximize();
    }

    public void waitUntilElementLoaded(WebElement webElement) {
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void waitUntilElementClickable(WebElement webElement){
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void openUrl(String url){
        driver.get(BASE_URL+url);
    }

    public boolean elementIsPresent(WebElement webElement){
       waitUntilElementLoaded(webElement);
       return webElement.isDisplayed();
    }

}