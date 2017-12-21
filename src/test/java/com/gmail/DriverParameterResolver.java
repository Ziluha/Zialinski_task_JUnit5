package com.gmail;

import com.enums.Browsers;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.ParameterResolutionException;
import org.junit.jupiter.api.extension.ParameterResolver;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class DriverParameterResolver implements ParameterResolver {
    static Stream<Arguments> browser() {
        return Stream.of(
                Arguments.of(Browsers.name.Chrome),
                Arguments.of(Browsers.name.Firefox)
        );
    }

    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return true;
    }

    @Override
    public Stream<Arguments> resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        /*Browsers.name browser = null;
        if (parameterContext.getParameter().getType() == Browsers.name.class) {
            browser = BROWSERS[0];
        }*/
        return browser();
    }
}
