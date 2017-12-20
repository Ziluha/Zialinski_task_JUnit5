package com.gmail.authorization;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import com.properties.PropertiesReading;
import org.junit.*;

public class AuthorizationTest extends BaseTest {
    private PagesFactory pages= new PagesFactory(driver);

    public AuthorizationTest(Browsers.name browserName){
        super(browserName);
    }

    @Test
    public void authWithValidData(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword(PropertiesReading.getCredentials().getProperty("validPassword"));
        pages.getPasswordPage().submitPassword();
        Assert.assertTrue("User was not logged in", pages.getInboxPage().isLoginSucceed());
    }

    @Test
    public void authWithInvalidLogin(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("invalidLogin"));
        pages.getLoginPage().submitLogin();
        Assert.assertTrue("Login Error Label is not presented",
                pages.getLoginPage().isLoginErrorLabelPresented());
    }

    @Test
    public void authWithInvalidPassword(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("validLogin"));
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword(PropertiesReading.getCredentials().getProperty("invalidPassword"));
        pages.getPasswordPage().submitPassword();
        Assert.assertTrue("Password Error Label is not presented",
                pages.getPasswordPage().isPasswordErrorLabelPresented());
    }
}
