package stepDefinition;

import java.util.Map;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AppLauncherPage;
import pages.OpportunitiesPage;

public class OpportunitiesSteps {
	AppLauncherPage appLauncherPage = new AppLauncherPage();
	OpportunitiesPage opportunitiesPage = new OpportunitiesPage();
	
	@When("The user navigates to the opportunity tab")
	public void the_user_navigates_to_the_opportunity_tab() {
	    appLauncherPage.searchAndClickOpportunities();
	}
	
	@When("The user clicks on the new button for opportunity")
    public void user_clicks_on_new_button() {
		opportunitiesPage.clickNewButton();
	}
	
	@When("The user enters the opportunity details:")
	public void the_user_enters_the_opportunity_details(DataTable dataTable) {
		Map<String, String> data = dataTable.asMap();
		opportunitiesPage.enterOpportunityName(data.get("OpportunityName"));
		opportunitiesPage.enterCloseDate(data.get("CloseDate"));
		opportunitiesPage.chooseStage(data.get("Stage"));
	}
	
	 @When("The user clicks the save button for opportunity")
	 public void user_clicks_the_save_button() {
		 opportunitiesPage.clickSaveButton();
	 }
	@Then("A new opportunity should be created with opportunity name {string}")
	public void a_new_opportunity_should_be_created_with_opportunity_name(String expectedOpportunityName) {
		opportunitiesPage.verifyOpportunityName(expectedOpportunityName);
	}
	
}
