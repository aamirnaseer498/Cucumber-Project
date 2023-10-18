package PageObjects;

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
    WebDriverWait driverWait;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver,this);
        driverWait= new WebDriverWait(webDriver, Duration.ofSeconds(10));
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
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Email")));
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("Password")));
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLogin(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
        loginButton.click();
    }

    public void clickLogout(){
        driverWait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout")));
        logoutLink.click();
    }

}
