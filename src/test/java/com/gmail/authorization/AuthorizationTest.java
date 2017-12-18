package com.gmail.authorization;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationTest extends BaseTest{
    private PagesFactory pages= new PagesFactory();

    public AuthorizationTest(){
        super(Browsers.name.Chrome);
    }

    @Test
    public void authWithValidData(){
        pages.getLoginPage(driver).inputLogin("test.task.zel");
        pages.getLoginPage(driver).submitLogin();
        pages.getPasswordPage(driver).inputPassword("Test1234Test");
        pages.getPasswordPage(driver).submitPassword();
        assertTrue( pages.getInboxPage(driver).isLoginSucceed(),
                "User was not logged in");
    }

    @Test
    public void authWithInvalidLogin(){
        pages.getLoginPage(driver).inputLogin("test.invalid.zel");
        pages.getLoginPage(driver).submitLogin();
        assertTrue(pages.getLoginPage(driver).isLoginErrorLabelPresented(),
                "Login Error Label is not presented");
    }

    @Test
    public void authWithInvalidPassword(){
        pages.getLoginPage(driver).inputLogin("test.task.zel");
        pages.getLoginPage(driver).submitLogin();
        pages.getPasswordPage(driver).inputPassword("InvalidPassword");
        pages.getPasswordPage(driver).submitPassword();
        assertTrue(pages.getPasswordPage(driver).isPasswordErrorLabelPresented(),
                "Password Error Label is not presented");
    }
}
