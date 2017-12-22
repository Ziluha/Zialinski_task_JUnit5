package com.gmail;

import com.driver.DriverInitQuit;
import com.driver.config.DriverConfig;
import com.enums.Browsers;
import com.pages.factory.PagesFactory;
import com.properties.PropertiesReading;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected DriverInitQuit driverInitQuit;
    protected DriverConfig driverConfig;
    protected PagesFactory pages;

    protected void initDriver(Browsers.name browserName){
        driverConfig = new DriverConfig();
        driverInitQuit = new DriverInitQuit();
        driver = driverInitQuit.initDriver(browserName);
        driverConfig.loadApp(driver, PropertiesReading.getURLs().getProperty("gmailURL"));
        pages = new PagesFactory(driver);
    }

    @AfterEach
    public void endTest() {
        driverInitQuit.quitDriver(driver);
    }
}