package PageObjects;

import Utilities.WaitHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver webDriver;
    WaitHelper waitHelper;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        waitHelper= new WaitHelper(webDriver);
    }

    @FindBy (id = "Email")
    @CacheLookup
    WebElement emailField;

    @FindBy (id = "Password")
    @CacheLookup
    WebElement passwordField;

    @FindBy (xpath = "//button[@type='submit']")
    @CacheLookup
    WebElement loginButton;

    @FindBy (linkText = "Logout")
    @CacheLookup
    WebElement logoutLink;

    public void enterEmail(String email) {
        waitHelper.waitForElement(emailField,60);
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        waitHelper.waitForElement(passwordField,60);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        waitHelper.waitForElement(loginButton,60);
        loginButton.click();
    }

    public void clickLogout(){
        waitHelper.waitForElement(logoutLink,60);
        logoutLink.click();
    }

}
