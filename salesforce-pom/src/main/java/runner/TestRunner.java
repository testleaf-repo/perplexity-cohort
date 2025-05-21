package runner;

import io.cucumber.testng.CucumberOptions;
import pages.BasePage;

@CucumberOptions(features = "src/main/resources/features/salesforce/CreateOpportunity.feature", glue = {"stepDefinition"})
public class TestRunner extends BasePage{

}
