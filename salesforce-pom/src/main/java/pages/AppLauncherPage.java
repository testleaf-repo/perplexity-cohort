package pages;

import com.testleaf.constants.LocatorType;

import base.ProjectHooks;

public class AppLauncherPage extends ProjectHooks{

	public OpportunitiesPage searchAndClickOpportunities() {
		getBrowser().locateEdit(LocatorType.XPATH, "//input[@placeholder='Search apps or items...']").appendText("Opportunities");
		getBrowser().locateLink(LocatorType.XPATH, "//a[@data-label='Opportunities']/ancestor::li").click();
		return new OpportunitiesPage();
	}
	
	public LeadsPage searchAndClickLeads() {
		getBrowser().locateEdit(LocatorType.XPATH, "//input[@placeholder='Search apps or items...']").appendText("Leads");
		getBrowser().locateLink(LocatorType.XPATH, "//a[@data-label='Leads']/ancestor::li").click();
		return new LeadsPage();
	}

	public AccountsPage searchAndClickAccounts() {
		getBrowser().locateEdit(LocatorType.XPATH, "//input[@placeholder='Search apps or items...']").appendText("Accounts");
		getBrowser().locateLink(LocatorType.XPATH, "//a[@data-label='Accounts']/ancestor::li").click();
		return new AccountsPage();
	}
	
}
