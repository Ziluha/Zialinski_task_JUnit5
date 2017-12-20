package com.reports.eventfiring;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener{
   /* private void debugLogExtent(String debugInfo){
        if(test != null)
            test.debug(debugInfo);
    }

    private void infoLogExtent(String info){
        if(test != null)
            test.info(info);
    }

    private void exceptionLogExtent(String exception){
        if(test != null)
            test.error(exception);
    }*/

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
        //debugLogExtent(errorMessage);
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {
        String errorMessage = "Navigated to " + s;
        System.out.println(errorMessage);
        //infoLogExtent(errorMessage);
    }

    public void beforeNavigateBack(WebDriver webDriver) {
        String errorMessage = "Before beforeNavigateBack " + webDriver.getCurrentUrl();
        System.out.println(errorMessage);
       // debugLogExtent(errorMessage);
    }

    public void afterNavigateBack(WebDriver webDriver) {
        String errorMessage = "After navigateback to " + webDriver.getCurrentUrl();
        System.out.println(errorMessage);
       // infoLogExtent(errorMessage);
    }

    public void beforeNavigateForward(WebDriver webDriver) {
        String errorMessage = "Before beforeNavigateForward " + webDriver.getCurrentUrl();
        System.out.println(errorMessage);
       // debugLogExtent(errorMessage);
    }

    public void afterNavigateForward(WebDriver webDriver) {
        String errorMessage = "AfterNavigateForward to " + webDriver.getCurrentUrl();
        System.out.println(errorMessage);
        //infoLogExtent(errorMessage);
    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        String errorMessage = "Finding element by " + by.toString();
        System.out.println(errorMessage);
        //debugLogExtent(errorMessage);
    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        String errorMessage = "Find happened using method " + by.toString();
        System.out.println(errorMessage);
        //infoLogExtent(errorMessage);
    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        String errorMessage = "About to click on the " + webElement.toString();
        System.out.println(errorMessage);
        //debugLogExtent(errorMessage);
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        String errorMessage = "Clicked on " + webElement.toString();
        System.out.println(errorMessage);
        //infoLogExtent(errorMessage);
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        String errorMessage = "Before changing of value" + webElement.toString();
        System.out.println(errorMessage);
        //debugLogExtent(errorMessage);
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        String errorMessage = "Value changed " + webElement.toString();
        System.out.println(errorMessage);
        //infoLogExtent(errorMessage);
    }

    public void beforeScript(String s, WebDriver webDriver) {
        String errorMessage = "Before beforeScript " + s;
        System.out.println(errorMessage);
        //debugLogExtent(errorMessage);
    }

    public void afterScript(String s, WebDriver webDriver) {
        String errorMessage = "AfterScript, Script is " + s;
        System.out.println(errorMessage);
        //infoLogExtent(errorMessage);
    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        String errorMessage = "Exception occured at " + throwable.getMessage();
        System.out.println(errorMessage);
        //exceptionLogExtent(errorMessage);
    }

}
