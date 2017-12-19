package com.gmail.fail;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FailTest extends BaseTest{
    private PagesFactory pages= new PagesFactory();

    public FailTest(Browsers.name browserName) {
        super(browserName);
    }

    @Test
    public void checkFail(){
        pages.getLoginPage(driver).inputLogin("test.invalid.zel");
        pages.getLoginPage(driver).submitLogin();
        assertTrue(pages.getPasswordPage(driver).IsLoginApplied(),
                "Login was not applied");
    }
}
