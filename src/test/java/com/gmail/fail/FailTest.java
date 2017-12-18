package com.gmail.fail;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FailTest extends BaseTest{
    private PagesFactory pages= new PagesFactory();

    public FailTest() {
        super(Browsers.name.Firefox);
    }

    @Test
    public void checkFail(){
        pages.getLoginPage().inputLogin("test.invalid.zel");
        pages.getLoginPage().submitLogin();
        assertTrue(pages.getPasswordPage().IsLoginApplied(),
                "Login was not applied");
    }
}
