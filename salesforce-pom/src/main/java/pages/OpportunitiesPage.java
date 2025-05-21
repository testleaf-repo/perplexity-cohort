package pages;

import org.openqa.selenium.Keys;

import com.testleaf.constants.LocatorType;
import com.testleaf.web.element.Element;

import base.ProjectHooks;

public class OpportunitiesPage extends ProjectHooks{

	public OpportunitiesPage clickNewButton() {
	getBrowser().locateLink(LocatorType.XPATH, "//a[@title='New']").click();
	return this;
	}
	
	public OpportunitiesPage enterOpportunityName(String opportunityName) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Opportunity Name']/following::input[1]").setText(opportunityName);
		return this;
	}
	
	public OpportunitiesPage enterCloseDate(String closeDate) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Close Date']/following::input[1]").appendText(closeDate);
		return this;
	}
	
	public OpportunitiesPage chooseStage(String stage) {// stage= "Prospecting"
		getBrowser().clickJs(LocatorType.XPATH, "//label[text()='Stage']/following::button[1]");
		getBrowser().locateButton(LocatorType.XPATH, "//lightning-base-combobox-item[@data-value='"+stage+"']").click();
		return this;
	}
	
	public OpportunitiesPage clickSaveButton() {
		getBrowser().locateButton(LocatorType.XPATH , "//button[@name='SaveEdit']").click();
		return this;
	}
	
	public OpportunitiesPage verifyOpportunityName(String expectedOpportunityName) {
		String actualOpportunityName = getBrowser().locateElement(LocatorType.XPATH, "//lightning-formatted-text[@slot='primaryField']").getText();
		if(actualOpportunityName.contains(expectedOpportunityName)) {
			System.out.println("Opportunity Name Verified: " + actualOpportunityName);
        } else {
            System.out.println("Opportunity Name Mismatch. Expected to contain: " + expectedOpportunityName + ", Found: " + actualOpportunityName);
        }
		return this;
	}
	
	public OpportunitiesPage searchExistingOpportunity(String opportunityName) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//input[@placeholder='Search this list...']").type(opportunityName+Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public OpportunitiesPage clickEditButton() {
		getBrowser().locateButton(LocatorType.XPATH, "//table[@aria-label='Recently Viewed']/tbody/tr[1]/td[8]").click();
		getBrowser().locateLink(LocatorType.XPATH, "//a[@title='Edit']").click();
		return this;
	}
	
	public OpportunitiesPage clickDeleteButton() {
		getBrowser().locateButton(LocatorType.XPATH, "//table[@aria-label='Recently Viewed']/tbody/tr[1]/td[8]").click();
		getBrowser().locateLink(LocatorType.XPATH, "//a[@title='Delete']").click();
		getBrowser().locateButton(LocatorType.XPATH, "//button[@title='Delete']").click();
		return this;
	}
	
	public OpportunitiesPage clickFirstOpportunityName() {
		getBrowser().locateLink(LocatorType.XPATH, "//table[@aria-label='Recently Viewed']/tbody/tr[1]/th[1]//a").click();
		return this;
	}
}
