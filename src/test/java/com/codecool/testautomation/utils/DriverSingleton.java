package com.codecool.testautomation.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static WebDriver driver = null;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        String browser = Utils.getEnvironmentVariable("BROWSER");
        if (driver == null) {
            switch (browser) {
                case "CHROME" -> driver = new ChromeDriver();
                case "SAFARI" -> driver = new SafariDriver();
                case "FIREFOX" -> driver = new FirefoxDriver();
            }
        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}