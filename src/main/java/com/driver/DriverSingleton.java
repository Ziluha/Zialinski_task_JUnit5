package com.driver;

import com.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    /*private static DriverSingleton instance;
    private WebDriver driver;

    private DriverSingleton(){}

    public static synchronized DriverSingleton getInstance(){
        if(instance == null)
            instance = new DriverSingleton();
        return instance;
    }

    public WebDriver getDriver(){
        return driver;
    }*/

    public WebDriver initBrowser(Browsers.name browserName){
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
