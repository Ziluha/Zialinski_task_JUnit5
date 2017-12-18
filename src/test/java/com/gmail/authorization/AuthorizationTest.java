package com.gmail.authorization;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.Assert;
import org.junit.Test;

public class AuthorizationTest extends BaseTest{
    private PagesFactory pages= new PagesFactory();

    public AuthorizationTest(Browsers.name browserName){
        super(browserName);
    }

    @Test
    public void authWithValidData(){
        pages.getLoginPage(driver).inputLogin("test.task.zel");
        pages.getLoginPage(driver).submitLogin();
        pages.getPasswordPage(driver).inputPassword("Test1234Test");
        pages.getPasswordPage(driver).submitPassword();
        Assert.assertTrue("User was not logged in", pages.getInboxPage(driver).isLoginSucceed());
    }

    @Test
    public void authWithInvalidLogin(){
        pages.getLoginPage(driver).inputLogin("test.invalid.zel");
        pages.getLoginPage(driver).submitLogin();
        Assert.assertTrue("Login Error Label is not presented",
                pages.getLoginPage(driver).isLoginErrorLabelPresented());
    }

    @Test
    public void authWithInvalidPassword(){
        pages.getLoginPage(driver).inputLogin("test.task.zel");
        pages.getLoginPage(driver).submitLogin();
        pages.getPasswordPage(driver).inputPassword("InvalidPassword");
        pages.getPasswordPage(driver).submitPassword();
        Assert.assertTrue("Password Error Label is not presented",
                pages.getPasswordPage(driver).isPasswordErrorLabelPresented());
    }
}
