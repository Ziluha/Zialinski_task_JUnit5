package com.gmail.fail;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.Assert;
import org.junit.Test;

public class FailTest extends BaseTest{
    private PagesFactory pages= new PagesFactory();

    public FailTest(Browsers.name browserName) {
        super(browserName);
    }

    @Test
    public void checkFail(){
        pages.getLoginPage().inputLogin("test.invalid.zel");
        pages.getLoginPage().submitLogin();
        Assert.assertTrue("Login was not applied",
                pages.getPasswordPage().IsLoginApplied());
    }
}
