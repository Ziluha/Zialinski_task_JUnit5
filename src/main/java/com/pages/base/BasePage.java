package com.pages.base;

import com.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public BasePage(WebDriver driver){
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(driver, this);
    }
}
