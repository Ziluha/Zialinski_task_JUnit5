package com.pages.base;

import com.driver.DriverSingleton;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class BasePage {
    public BasePage(){
        DriverSingleton.getInstance().getDriver().manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        PageFactory.initElements(DriverSingleton.getInstance().getDriver(), this);
    }
}
