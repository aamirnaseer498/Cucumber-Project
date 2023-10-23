package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Customers.feature",
        glue = "CustomersStepDefinitions",
        plugin = {"pretty","html:test-report/index.html"})
public class CustomersTestRunner {

}
