package stepDefinition;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AppLauncherPage;
import pages.LeadsPage;
import pages.WelcomePage;

public class LeadSteps {
	AppLauncherPage appLauncherPage = new AppLauncherPage();
	LeadsPage leadsPage = new LeadsPage();
	

	@When("The user navigates to the leads tab")
    public void user_navigates_to_leads_tab() {
		appLauncherPage.searchAndClickLeads();
	}
	
	@When("The user clicks on the new button for leads")
    public void user_clicks_on_new_button() {
		leadsPage.clickNewButton();
	}
	
	 @When("The user enters the lead details:")
	 public void user_enters_lead_details(DataTable dataTable) {
		 Map<String, String> data = dataTable.asMap();
		 leadsPage.chooseSalutation(data.get("Salutation"));
		 leadsPage.enterFirstName(data.get("FirstName"));
		 leadsPage.enterLastName(data.get("LastName"));
		 leadsPage.enterCompanyName(data.get("Company"));
	 }
	 
	 @When("The user clicks the save button for leads")
	 public void user_clicks_the_save_button() {
		 leadsPage.clickSaveButton();
	 }
	 
	 @Then("A new lead should be created with frist name {string} last name {string}")
	    public void verify_lead_creation(String expectedFirstName, String expectedLastName) {
		 leadsPage.verifyfirstName(expectedFirstName);
		 leadsPage.verifyLastName(expectedLastName);
	 }
	
}
