package com.gmail.authorization;

import com.enums.Browsers;
import com.gmail.BaseTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

public class AuthorizationTest extends BaseTest{
    @ParameterizedTest
    @EnumSource(Browsers.name.class)
    @DisplayName("Authorization with valid data")
    public void authWithValidData(Browsers.name browserName){
        initDriver(browserName);
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("Test1234Test");
        pages.getPasswordPage().submitPassword();
        assertTrue( pages.getInboxPage().isLoginSucceed(),
                "User was not logged in");
    }

    @ParameterizedTest
    @EnumSource(Browsers.name.class)
    @DisplayName("Authorization with invalid login")
    public void authWithInvalidLogin(Browsers.name browserName){
        initDriver(browserName);
        pages.getLoginPage().inputLogin("test.invalid.zel");
        pages.getLoginPage().submitLogin();
        assertTrue(pages.getLoginPage().isLoginErrorLabelPresented(),
                "Login Error Label is not presented");
    }

    @ParameterizedTest
    @EnumSource(Browsers.name.class)
    @DisplayName("Authorization with invalid password")
    public void authWithInvalidPassword(Browsers.name browserName){
        initDriver(browserName);
        pages.getLoginPage().inputLogin("test.task.zel");
        pages.getLoginPage().submitLogin();
        pages.getPasswordPage().inputPassword("InvalidPassword");
        pages.getPasswordPage().submitPassword();
        assertTrue(pages.getPasswordPage().isPasswordErrorLabelPresented(),
                "Password Error Label is not presented");
    }
}
