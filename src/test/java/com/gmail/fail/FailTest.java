package com.gmail.fail;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import com.properties.PropertiesReading;
import org.junit.*;

public class FailTest extends BaseTest {
    private PagesFactory pages= new PagesFactory(driver);

    public FailTest(Browsers.name browserName) {
        super(browserName);
    }

    @Test
    public void checkFail(){
        pages.getLoginPage().inputLogin(PropertiesReading.getCredentials().getProperty("invalidLogin"));
        pages.getLoginPage().submitLogin();
        Assert.assertTrue("Login was not applied",
                pages.getPasswordPage().IsLoginApplied());
    }
}
