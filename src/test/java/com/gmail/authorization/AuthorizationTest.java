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
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("Test1234Test");
        pages.getPasswordPage().submitPassword();
        Assert.assertTrue("User was not logged in", pages.getInboxPage().isLoginSucceed());
    }

    @Test
    public void authWithInvalidLogin(){
        pages.getLoginPage().inputLogin("test.invalid.zel");
        pages.getLoginPage().submitLogin();
        Assert.assertTrue("Login Error Label is not presented",
                pages.getLoginPage().isLoginErrorLabelPresented());
    }

    @Test
    public void authWithInvalidPassword(){
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("InvalidPassword");
        pages.getPasswordPage().submitPassword();
        Assert.assertTrue("Password Error Label is not presented",
                pages.getPasswordPage().isPasswordErrorLabelPresented());
    }
}
