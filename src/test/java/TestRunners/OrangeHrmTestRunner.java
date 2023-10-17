package TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C://Users//user//IdeaProjects//Cucumber-Project//src//test//Features//OrangeHRM.feature",
        glue = "StepsDefinitions"
)
public class OrangeHrmTestRunner {

}
