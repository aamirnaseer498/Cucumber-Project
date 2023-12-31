package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Login.feature",
        glue = "LoginStepDefinitions",
        plugin = {"pretty","html:test-report/index.html"})
public class LoginTestRunner {

}
