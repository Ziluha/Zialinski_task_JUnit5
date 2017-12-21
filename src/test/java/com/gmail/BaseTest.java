package com.gmail;

import com.driver.DriverInitQuit;
import com.driver.config.DriverConfig;
import com.enums.Browsers;
import com.pages.factory.PagesFactory;
import com.properties.PropertiesReading;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.provider.*;
import org.openqa.selenium.WebDriver;

import java.util.stream.Stream;

//@ExtendWith(DriverParameterResolver.class)
public class BaseTest {
    protected WebDriver driver;
    private DriverInitQuit driverInitQuit;
    private DriverConfig driverConfig;
    protected PagesFactory pages;

    @BeforeEach
    //@MethodSource("stringIntAndListProvider")
    public void initTest(/*Browsers.name browserName*/) {
        driverConfig = new DriverConfig();
        driverInitQuit = new DriverInitQuit();
        driver = driverInitQuit.initDriver(Browsers.name.Chrome);
        driverConfig.loadApp(driver, PropertiesReading.getURLs().getProperty("gmailURL"));
        pages = new PagesFactory(driver);
    }

    @AfterEach
    public void endTest() {
        driverInitQuit.quitDriver(driver);
    }
}