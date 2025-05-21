package pages;

import com.testleaf.constants.LocatorType;

import base.ProjectHooks;

public class ServiceTerritoriesPage extends ProjectHooks{

	public ServiceTerritoriesPage clickNewButton() {
		getBrowser().locateLink(LocatorType.XPATH, "//div[contains(@aria-label,'Service Territories')]//a[@title='New']").click();
		return this;
	}
	
	public ServiceTerritoriesPage enterServiceTerritoryName(String serviceTerritoryName) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Name']/following::input[1]").setText(serviceTerritoryName);
		return this;
	}
	
	public ServiceTerritoriesPage chooseOperatingHours() {
		getBrowser().locateButton(LocatorType.XPATH, "//label[text()='Operating Hours']/following::input[1]").click();
		getBrowser().locateButton(LocatorType.XPATH, "//lightning-icon[@icon-name='standard:operating_hours']/ancestor::li").click();
		return this;
	}
	
	public ServiceTerritoriesPage clickActiveCheckbox() {
		getBrowser().locateCheckBox(LocatorType.XPATH, "//span[text()='Active' and @part='label']/following::input[1]").check();
		return this;
	}
	
	public ServiceTerritoriesPage enterCity(String city) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='City']/following::input[1]").setText(city);
		return this;
	}
	
	public ServiceTerritoriesPage enterState(String state) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='State/Province']/following::input[1]").setText(state);
		return this;
	}
	
	public ServiceTerritoriesPage enterCountry(String country) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Country']/following::input[1]").setText(country);
		return this;
	}
	
	public ServiceTerritoriesPage clickSaveButton() {
		getBrowser().locateButton(LocatorType.XPATH, "//button[@name='SaveEdit']").click();
		return this;
	}
	
	public ServiceTerritoriesPage verifyServiceTerritoryName(String expectedServiceTerritoryName) {
		String actualServiceTerritoryName = getBrowser().locateElement(LocatorType.XPATH, "//lightning-formatted-text[@slot='primaryField']").getText();
		if(actualServiceTerritoryName.contains(expectedServiceTerritoryName)) {
			System.out.println("Opportunity Name Verified: " + actualServiceTerritoryName);
        } else {
            System.out.println("Opportunity Name Mismatch. Expected to contain: " + expectedServiceTerritoryName + ", Found: " + actualServiceTerritoryName);
        }
		return this;
	}
}
