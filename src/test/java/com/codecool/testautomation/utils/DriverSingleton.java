package com.codecool.testautomation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSingleton {
    private static RemoteWebDriver driver = null;

    private DriverSingleton() {
    }

    public static RemoteWebDriver getDriver() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        DesiredCapabilities capability = new DesiredCapabilities();
        chromeOptions.setCapability("browserVersion", "96.0");
        chromeOptions.setCapability("platformName", "Linux");
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.LINUX);
        driver = new RemoteWebDriver(
                new URL("http://172.21.0.6:5555"), chromeOptions);

//        String browser = Utils.getEnvironmentVariable("BROWSER");
//        if (driver == null) {
//            switch (browser) {
//                case "CHROME" -> driver = new ChromeDriver();
//                case "SAFARI" -> driver = new SafariDriver();
//                case "FIREFOX" -> driver = new FirefoxDriver();
//            }
//        }
        return driver;
    }

    public static void quitDriver(){
        driver.quit();
        driver = null;
    }
}