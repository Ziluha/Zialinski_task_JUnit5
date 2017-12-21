package com.reports.eventfiring;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener{
    public void beforeAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertAccept(WebDriver webDriver) {

    }

    public void afterAlertDismiss(WebDriver webDriver) {

    }

    public void beforeAlertDismiss(WebDriver webDriver) {

    }

    public void beforeNavigateTo(String s, WebDriver webDriver) {
        String errorMessage = "Navigating to " + s;
        System.out.println(errorMessage);
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        String errorMessage = "Navigated to " + s;
        System.out.println(errorMessage);
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        String errorMessage = "Navigating back from " + webDriver.getCurrentUrl();
        System.out.println(errorMessage);
    }

    public void afterNavigateBack(WebDriver webDriver) {
        String errorMessage = "Navigated back to " + webDriver.getCurrentUrl();
        System.out.println(errorMessage);
    }

    public void beforeNavigateForward(WebDriver webDriver) {
        String errorMessage = "Navigating forward from " + webDriver.getCurrentUrl();
        System.out.println(errorMessage);
    }

    public void afterNavigateForward(WebDriver webDriver) {
        String errorMessage = "Navigated forward to " + webDriver.getCurrentUrl();
        System.out.println(errorMessage);
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        String errorMessage = "Finding element by " + by.toString();
        System.out.println(errorMessage);
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        String errorMessage = "Element founded " + by.toString();
        System.out.println(errorMessage);
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        String errorMessage = "Clicking on " + webElement.toString();
        System.out.println(errorMessage);
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        String errorMessage = "Clicked on " + webElement.toString();
        System.out.println(errorMessage);
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        String errorMessage = "Changing value " + webElement.toString();
        System.out.println(errorMessage);
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        String errorMessage = "Value changed " + webElement.toString();
        System.out.println(errorMessage);
    }

    public void beforeScript(String s, WebDriver webDriver) {
        String errorMessage = "Before script " + s;
        System.out.println(errorMessage);
    }

    public void afterScript(String s, WebDriver webDriver) {
        String errorMessage = "Script is " + s;
        System.out.println(errorMessage);
    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        String errorMessage = "Exception occured at " + throwable.getMessage();
        System.out.println(errorMessage);
    }

}
