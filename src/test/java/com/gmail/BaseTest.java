package com.gmail;

import com.driver.DriverSingleton;
import com.driver.config.DriverConfig;
import com.enums.Browsers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@ExtendWith(DriverParameterResolver.class)
public class BaseTest{
    protected WebDriver driver;
    private Browsers.name browserName;
    private DriverSingleton driverSingleton;
    private DriverConfig driverConfig;

    public BaseTest(Browsers.name browserName){
        //this.browserName = browserName;
        driverSingleton = new DriverSingleton();
        switch (browserName){
            case Chrome:
                this.driver = driverSingleton.initBrowser(browserName);
                break;
            case Firefox:
                this.driver = driverSingleton.initBrowser(browserName);
                break;
        }
    }

    @BeforeEach
    public void initTest(){
        driverConfig = new DriverConfig();
        //chooseDriverInstance(browserName);
        driverConfig.loadApp(driver, "https://gmail.com");
    }

    @AfterEach
    public void endTest(){
        driverSingleton.quitDriver(driver);
    }
}