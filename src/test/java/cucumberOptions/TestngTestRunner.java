package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/main/resources/features",glue="stepDefinition",monochrome=true)

public class TestngTestRunner extends AbstractTestNGCucumberTests {

}
