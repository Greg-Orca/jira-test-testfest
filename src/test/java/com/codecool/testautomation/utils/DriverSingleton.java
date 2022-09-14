package com.codecool.testautomation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSingleton {
    private static WebDriver driver = null;

    private DriverSingleton() {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        String PASSWORD = System.getProperty("PASSWORD");

        if (driver == null) {
            DesiredCapabilities capability = new DesiredCapabilities();
            String nodeURL = "https://selenium:CCAutoTest19.@seleniumhub.codecool.metastage.net/wd/hub";
            if ("firefox".equals(System.getProperty("BROWSER"))) {
                WebDriverManager.firefoxdriver().setup();
                capability.setBrowserName("firefox");
            } else {
                WebDriverManager.chromedriver().setup();
                capability.setBrowserName("chrome");
            }
            driver = new RemoteWebDriver(new URL(nodeURL), capability);
            capability.setPlatform(Platform.LINUX);
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

//        String browser = Utils.getEnvironmentVariable("BROWSER");
//        if (driver == null) {
//            switch (browser) {
//                case "CHROME" -> driver = new ChromeDriver();
//                case "SAFARI" -> driver = new SafariDriver();
//                case "FIREFOX" -> driver = new FirefoxDriver();
//            }
//
        return driver;
    }

    public static void quitDriver(){
            driver.quit();
            driver = null;
    }
}