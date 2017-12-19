package com.gmail;

import com.enums.Browsers;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;

import java.util.*;

public class DriverParameterResolver implements ParameterResolver {
    public static Browsers.name[] BROWSERS = {
                 Browsers.name.Chrome,
                Browsers.name.Firefox
    };

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return true;
    }

    @Override
    public Browsers.name resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        Browsers.name browser = null;
        if (parameterContext.getParameter().getType() == BaseTest.class) {
            browser = BROWSERS[0];
        }
        return BROWSERS[0];
    }
}
