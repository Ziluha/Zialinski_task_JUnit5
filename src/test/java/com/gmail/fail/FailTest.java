package com.gmail.fail;

import com.enums.Browsers;
import com.gmail.BaseTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import static org.junit.jupiter.api.Assertions.*;

public class FailTest extends BaseTest{
    @ParameterizedTest
    @EnumSource(Browsers.name.class)
    public void checkFail(Browsers.name browserName){
        initDriver(browserName);
        pages.getLoginPage().inputLogin("test.invalid.zel");
        pages.getLoginPage().submitLogin();
        assertTrue(pages.getPasswordPage().IsLoginApplied(),
                "Login was not applied");
    }
}
