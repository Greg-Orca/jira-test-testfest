package com.codecool.testautomation.utils;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSingleton {
    private static WebDriver driver = null;

    private DriverSingleton() throws MalformedURLException {
    }

    public static WebDriver getDriver() throws MalformedURLException {
        String wBrowser = System.getProperty("BROWSER");
        if (driver == null) {
//            WebDriverManager.chromedriver().setup();
    //        WebDriverManager.firefoxdriver().setup();

            DesiredCapabilities capability = new DesiredCapabilities();
            if (wBrowser.equals("CHROME")){
                capability.setBrowserName("chrome");
            }
            else if (wBrowser.equals("FIREFOX")){
                capability.setBrowserName("firefox");
            }
            capability.setPlatform(Platform.LINUX);

            driver = new RemoteWebDriver(
                    new URL("https://selenium:CCAutoTest19.@seleniumhub.codecool.metastage.net/wd/hub"), capability);

            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
        }
        return driver;
    }

    public static void quitDriver(){
            driver.quit();
            driver = null;
    }
}