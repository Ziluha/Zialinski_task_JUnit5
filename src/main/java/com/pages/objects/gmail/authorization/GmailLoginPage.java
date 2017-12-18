package com.pages.objects.gmail.authorization;

import com.driver.DriverSingleton;
import com.pages.base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GmailLoginPage extends BasePage{
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(how = How.ID, using = "identifierId")
    private WebElement loginField;

    @FindBy(how = How.XPATH, using = "//div[@jsname='B34EJ']")
    private WebElement loginErrorLabel;

    @FindBy(how = How.ID, using = "identifierNext")
    private WebElement submitLoginButton;

    public GmailLoginPage(WebDriver driver){super(driver); this.driver = driver;}

    public void inputLogin(String login){
        loginField.click();
        loginField.sendKeys(login);
    }

    public void submitLogin(){
        submitLoginButton.click();
    }

    public boolean isLoginErrorLabelPresented(){
        try {
            wait = new WebDriverWait(driver, 10);
            return wait.until(elem -> loginErrorLabel.isDisplayed());
        }
        catch (NoSuchElementException ex){
            return false;
        }
    }
}
