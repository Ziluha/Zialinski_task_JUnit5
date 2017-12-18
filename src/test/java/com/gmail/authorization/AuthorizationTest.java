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
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("Test1234Test");
        pages.getPasswordPage().submitPassword();
        assertTrue(pages.getInboxPage().isLoginSucceed(),"User was not logged in");
    }
    @Test
    public void authWithInvalidLogin(){
        pages.getLoginPage().inputLogin("test.invalid.zel");
        pages.getLoginPage().submitLogin();
        assertTrue( pages.getLoginPage().isLoginErrorLabelPresented(),
                "Login Error Lable is not presented");
    }

    @Test
    public void authWithInvalidPassword(){
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("InvalidPassword");
        pages.getPasswordPage().submitPassword();
        assertTrue(pages.getPasswordPage().isPasswordErrorLabelPresented(),
                "Password Error Lable is not presented" );
    }
}
