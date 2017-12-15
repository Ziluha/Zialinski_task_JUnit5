package com.pages.base;

import com.driver.DriverSingleton;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(DriverSingleton.getInstance().getDriver(), this);
    }
}
