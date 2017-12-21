package com.gmail.authorization;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationTest extends BaseTest{
    @ParameterizedTest
    public void authWithValidData(){
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("Test1234Test");
        pages.getPasswordPage().submitPassword();
        assertTrue( pages.getInboxPage().isLoginSucceed(),
                "User was not logged in");
    }

    @Test
    public void authWithInvalidLogin(){
        pages.getLoginPage().inputLogin("test.invalid.zel");
        pages.getLoginPage().submitLogin();
        assertTrue(pages.getLoginPage().isLoginErrorLabelPresented(),
                "Login Error Label is not presented");
    }

    @Test
    public void authWithInvalidPassword(){
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("InvalidPassword");
        pages.getPasswordPage().submitPassword();
        assertTrue(pages.getPasswordPage().isPasswordErrorLabelPresented(),
                "Password Error Label is not presented");
    }
}
