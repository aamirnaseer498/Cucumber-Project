package LoginStepDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class LoginSteps {

    WebDriver webDriver;
    LoginPage loginPage;
    Logger logger;
    Properties configProperties;
    String browser;

    @Before
    public void setup(){
        configProperties= new Properties();
        try {
            FileInputStream configFile= new FileInputStream("config.properties");
            configProperties.load(configFile);
            browser= configProperties.getProperty("browser");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logger=Logger.getLogger("nopCommerce");
        PropertyConfigurator.configure("log4j.properties");
    }

    @Given("Launch browser")
    public void launchChromeBrowser() {
        if (browser.equalsIgnoreCase("chrome")){
            webDriver= new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            webDriver= new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("edge")) {
            webDriver= new EdgeDriver();
        }
        webDriver.manage().window().maximize();
        loginPage= new LoginPage(webDriver);
        System.out.println("Browser opened");
        logger.info("Browser opened");
    }

    @When("Open URL {string}")
    public void openURL(String url) {
        webDriver.get(url);
        System.out.println("Application launched");
        logger.info("Application launched");
    }

    @Then("Enter email as {string} and password as {string}")
    public void enterEmailAsAndPasswordAs(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        System.out.println("Email and password is entered");
        logger.info("Email and password is entered");
    }

    @Then("Click on login button")
    public void clickOnLoginButton() {
        loginPage.clickLogin();
        System.out.println("Clicked on login");
        logger.info("Clicked on login");
    }

    @Then("Page title should be {string}")
    public void pageTitleShouldBe(String title) {
        if (webDriver.getPageSource().contains("Login was unsuccessful")){
            webDriver.close();
            Assert.assertTrue(false);
        }else {
            Assert.assertEquals(title,webDriver.getTitle());
            System.out.println("Current Title: " + webDriver.getTitle());
        }
    }

    @When("Click on Logout link")
    public void clickOnLogoutLink() {
        loginPage.clickLogout();
        System.out.println("Clicked on logout");
        logger.info("Clicked on logout");
    }

    @And("Close browser")
    public void closeBrowser() {
        webDriver.close();
        System.out.println("Browser closed");
        logger.info("Browser closed");
    }

}
