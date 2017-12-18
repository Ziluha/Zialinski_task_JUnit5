package com.gmail.fail;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class FailTest extends BaseTest{
    private PagesFactory pages= new PagesFactory();

    public FailTest() {
        super(Browsers.name.Chrome);
    }

    @Test
    public void checkFail(){
        pages.getLoginPage(driver).inputLogin("test.invalid.zel");
        pages.getLoginPage(driver).submitLogin();
        assertTrue(pages.getPasswordPage(driver).IsLoginApplied(),
                "Login was not applied");
    }
}
