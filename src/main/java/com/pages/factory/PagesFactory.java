package com.pages.factory;

import com.driver.DriverSingleton;
import com.pages.objects.gmail.authorization.*;
import com.pages.objects.gmail.mail.*;
import org.openqa.selenium.WebDriver;

public class PagesFactory {
    public GmailLoginPage getLoginPage(){
        return new GmailLoginPage();
    }

    public GmailPasswordPage getPasswordPage(){
        return new GmailPasswordPage();
    }

    public GmailInboxPage getInboxPage(){
        return new GmailInboxPage();
    }

    public GmailDraftsPage getDraftsPage(){
        return new GmailDraftsPage();
    }
}
