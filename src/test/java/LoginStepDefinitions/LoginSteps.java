package LoginStepDefinitions;

import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {

    WebDriver webDriver;
    LoginPage loginPage;

    @Given("Launch chrome browser")
    public void launchChromeBrowser() {
        webDriver= new ChromeDriver();
        webDriver.manage().window().maximize();
        loginPage= new LoginPage(webDriver);
        System.out.println("Browser opened");
    }

    @When("Open URL {string}")
    public void openURL(String url) {
        webDriver.get(url);
        System.out.println("Application launched");
    }

    @Then("Enter email as {string} and password as {string}")
    public void enterEmailAsAndPasswordAs(String email, String password) {
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        System.out.println("Email and password is entered");
    }

    @Then("Click on login button")
    public void clickOnLoginButton() {
        loginPage.clickLogin();
        System.out.println("Clicked on login");
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
    }

    @And("Close browser")
    public void closeBrowser() {
        webDriver.close();
    }

}
