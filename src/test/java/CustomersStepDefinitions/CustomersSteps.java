package CustomersStepDefinitions;

import PageObjects.AddCustomerPage;
import PageObjects.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CustomersSteps {

    WebDriver webDriver;

    LoginPage loginPage;
    AddCustomerPage addCustomerPage;

    @Given("Launch chrome browser")
    public void launchChromeBrowser() {
        webDriver= new ChromeDriver();
        webDriver.manage().window().maximize();
        loginPage= new LoginPage(webDriver);
        addCustomerPage= new AddCustomerPage(webDriver);
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

    @And("Dashboard is available now")
    public void dashboardIsAvailableNow() {
        if (webDriver.getTitle().equals("Dashboard / nopCommerce administration")){
            System.out.println("Login successful, now Dashboard is opened");
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue("Login failed! please try again",false);
        }
    }

    @When("Click on Customers menu")
    public void clickOnCustomersMenu() {
        addCustomerPage.clickOnCustomersMenuLink();
        System.out.println("Clicked on Customers Menu Link");
    }

    @Then("Click on Customers menu item")
    public void clickOnCustomersMenuItem() {
        addCustomerPage.clickOnCustomersMenuItemLink();
        System.out.println("Clicked on Customers Menu Item Link");
    }

    @Then("Click on Add new button")
    public void clickOnAddNewButton() {
        addCustomerPage.clickOnAddNewButton();
        System.out.println("Clicked on Add New customer button");
    }

    @And("Add new customer is available now")
    public void addNewCustomerIsAvailableNow() {
        if (webDriver.getTitle().equals("Add a new customer / nopCommerce administration")){
            System.out.println("Now form for Add New Customer is opened");
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue("Add new customer form not available due to some reason",false);
        }
    }

    @When("Enter customer info")
    public void enterCustomerInfo() {
        String email= generateString() + "@mailinator.com";
        addCustomerPage.enterEmail(email);
        String password= generatePassword();
        addCustomerPage.enterPassword(password);
        addCustomerPage.enterFirstName(generateString());
        addCustomerPage.enterLastName(generateString());
        addCustomerPage.selectGender("Male");
        addCustomerPage.enterDateOfBirth("09/19/1994");
        addCustomerPage.enterCompanyName(generateString());
        addCustomerPage.isTaxExempt();
        addCustomerPage.selectNewsLetter("Test store 2");
        addCustomerPage.selectCustomerRoles("Guest");
        addCustomerPage.selectManagerOfVendor("Vendor 1");
        addCustomerPage.isActive();
        addCustomerPage.enterAdminComment("This is a new user");
    }

    @Then("Click on Save button")
    public void clickOnSaveButton() {
        addCustomerPage.submitCustomer();
    }

    @Then("Confirmation message {string} will appear")
    public void confirmationMessageWillAppear(String message) {
        String confirmation= webDriver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissable']")).getText();
        if (confirmation.contains(message)){
            System.out.println(message);
            Assert.assertTrue(true);
        }else {
            Assert.assertTrue("Customer creation got failed, please try again",false);
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
        System.out.println("Browser closed");
    }

    public String generateString(){
        return RandomStringUtils.randomAlphabetic(5);
    }

    public String generatePassword(){
        return RandomStringUtils.randomNumeric(8);
    }

}
