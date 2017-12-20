package com.gmail;


import com.driver.DriverInitQuit;
import com.driver.config.DriverConfig;
import com.enums.Browsers;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public abstract class BaseTest {
    protected WebDriver driver;
    private DriverInitQuit driverInitQuit;
    private DriverConfig driverConfig;

    public BaseTest(Browsers.name browserName){
        driverInitQuit = new DriverInitQuit();
        this.driver = driverInitQuit.initDriver(browserName);
    }

    @Parameterized.Parameters
    public static Collection<Object> data() {
        Object[][] data = new Object[][]{
                { Browsers.name.Chrome},
                {Browsers.name.Firefox}};
        return Arrays.asList(data);
    }

    @Before
    public void initTest(){
        driverConfig = new DriverConfig();
        driverConfig.loadApp(driver, "https://gmail.com");
    }

    @After
    public void endTest(){
        driverInitQuit.quitDriver(driver);
    }
}