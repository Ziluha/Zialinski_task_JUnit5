package com.driver;

import com.enums.Browsers;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverSingleton {
    private static DriverSingleton instance;
    private WebDriver driver;

    private DriverSingleton(){}

    public static DriverSingleton getInstance(){
        if(instance == null)
            instance = new DriverSingleton();
        return instance;
    }

    public WebDriver getDriver(){
        return driver;
    }

    public void initBrowser(Browsers.name browser){
        switch (browser){
            case Chrome:
                System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case Firefox:
                System.setProperty("webdriver.gecko.driver", "drivers/geckodriver.exe");
                driver = new FirefoxDriver();
                break;
        }
    }

    public void quitDriver(){
        driver.quit();
    }
}
