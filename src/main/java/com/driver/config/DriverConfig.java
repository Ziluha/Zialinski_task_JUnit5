package com.driver.config;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class DriverConfig {
    public void loadApp(WebDriver driver, String url){
        driver.manage().window().maximize();
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
