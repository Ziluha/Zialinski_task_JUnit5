package com.gmail;


import com.driver.DriverSingleton;
import com.driver.config.DriverConfig;
import com.enums.Browsers;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.*;

public class BaseTest{
    protected WebDriver driver;
    private Browsers.name browserName;
    private DriverSingleton driverSingleton;
    private DriverConfig driverConfig;

    public BaseTest(Browsers.name browserName){
        this.browserName = browserName;
        driverSingleton = DriverSingleton.getInstance();
    }

    public void chooseDriverInstance(Browsers.name browserName){
        switch (browserName){
            case Firefox:
                driverSingleton.initBrowser(Browsers.name.Firefox);
                driver = driverSingleton.getDriver();
                break;
            case Chrome:
                driverSingleton.initBrowser(Browsers.name.Chrome);
                driver = driverSingleton.getDriver();
                break;
        }
    }

    @BeforeEach
    public void initTest(){
        chooseDriverInstance(browserName);
        driverConfig.loadApp(driver, "https://gmail.com");
    }

    @AfterEach
    public void endTest(){
        driverSingleton.quitDriver();
    }
}