package com.driver;

import com.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverInitQuit {
    public WebDriver initDriver(Browsers.name browserName){
        switch (browserName){
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                return new ChromeDriver();
            case Firefox:
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                return new FirefoxDriver();
        }
        return null;
    }

    public void quitDriver(WebDriver driver){
        driver.quit();
    }
}
