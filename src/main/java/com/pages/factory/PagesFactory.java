package com.pages.factory;

import com.pages.objects.gmail.authorization.*;
import com.pages.objects.gmail.mail.*;
import org.openqa.selenium.WebDriver;

public class PagesFactory {
    private WebDriver driver;
    public PagesFactory(WebDriver driver){
        this.driver = driver;
    }
    public GmailLoginPage getLoginPage(){
        return new GmailLoginPage(driver);
    }

    public GmailPasswordPage getPasswordPage(){
        return new GmailPasswordPage(driver);
    }

    public GmailInboxPage getInboxPage(){
        return new GmailInboxPage(driver);
    }

    public GmailDraftsPage getDraftsPage(){
        return new GmailDraftsPage(driver);
    }
}
