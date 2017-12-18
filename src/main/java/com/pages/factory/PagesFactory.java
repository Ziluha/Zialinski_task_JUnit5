package com.pages.factory;

import com.driver.DriverSingleton;
import com.pages.objects.gmail.authorization.*;
import com.pages.objects.gmail.mail.*;
import org.openqa.selenium.WebDriver;

public class PagesFactory {
    public GmailLoginPage getLoginPage(WebDriver driver){
        return new GmailLoginPage(driver);
    }

    public GmailPasswordPage getPasswordPage(WebDriver driver){
        return new GmailPasswordPage(driver);
    }

    public GmailInboxPage getInboxPage(WebDriver driver){
        return new GmailInboxPage(driver);
    }

    public GmailDraftsPage getDraftsPage(WebDriver driver){
        return new GmailDraftsPage(driver);
    }
}
