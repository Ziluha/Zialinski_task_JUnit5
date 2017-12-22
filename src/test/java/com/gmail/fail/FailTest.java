package com.gmail.fail;

import com.enums.Browsers;
import com.gmail.BaseTest;
import com.pages.factory.PagesFactory;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class FailTest extends BaseTest{
    /*@ParameterizedTest
    @EnumSource(Browsers.name.class)
    public void checkFail(Browsers.name browserName){
        initDriver(browserName);
        pages.getLoginPage().inputLogin("test.invalid.zel");
        pages.getLoginPage().submitLogin();
        assertTrue(pages.getPasswordPage().IsLoginApplied(),
                "Login was not applied");
    }
*/
    @TestFactory
    Stream<DynamicTest> dynamicTestsFromStream() {
        return Stream.of(Browsers.name.Chrome, Browsers.name.Firefox)
                .map(browserName -> dynamicTest("Test "+browserName,
                        ()->{
                            initDriver(browserName);
                            pages.getLoginPage().inputLogin("test.invalid.zel");
                            pages.getLoginPage().submitLogin();
                            assertTrue(pages.getPasswordPage().IsLoginApplied(),
                                    "Login was not applied");
                        }));
    }

}
