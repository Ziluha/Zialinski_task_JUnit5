package com.gmail;


import com.driver.DriverSingleton;
import com.driver.config.DriverConfig;
import com.enums.Browsers;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
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
        chooseDriverInstance(browserName);
        driverConfig.loadApp(driver, "https://gmail.com");
    }

    @After
    public void endTest(){
        driverSingleton.quitDriver();
    }
}