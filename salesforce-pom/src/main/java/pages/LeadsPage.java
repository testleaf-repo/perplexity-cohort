package pages;

import org.openqa.selenium.Keys;

import com.testleaf.constants.LocatorType;

import base.ProjectHooks;

public class LeadsPage extends ProjectHooks{

	public LeadsPage clickNewButton() {
		getBrowser().locateLink(LocatorType.XPATH, "//a[@title='New']").click();
		return this;
	}
	
	public LeadsPage chooseSalutation(String salutationType) {//salutationType ="Mr."
		getBrowser().locateButton(LocatorType.XPATH, "//label[text()='Salutation']/following::button[1]").click();
		getBrowser().locateButton(LocatorType.XPATH, "//lightning-base-combobox-item[@data-value='"+salutationType+"']").click();
		return this;
	}
	
	public LeadsPage enterFirstName(String firstName) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='First Name']/following::input[1]").type(firstName);
		return this;
	}
	
	public LeadsPage enterLastName(String lastName) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Last Name']/following::input[1]").type(lastName);
		return this;
	}
	
	public LeadsPage enterCompanyName(String companyName) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Company']/following::input[1]").type(companyName);
		return this;
	}
	
	public LeadsPage clickSaveButton() {
		getBrowser().locateButton(LocatorType.XPATH, "//button[@name='SaveEdit']").click();
		return this;
	}
	
	public LeadsPage verifySalutationType(String expectedSalutationType) {
		String actualSalutionType = getBrowser().locateElement(LocatorType.XPATH, "//lightning-formatted-name[@slot='primaryField']").getText();
		if(actualSalutionType.contains(expectedSalutationType)) {
			System.out.println("Salutation Type Verified: " + actualSalutionType);
        } else {
            System.out.println("Salutation Type Mismatch. Expected to contain: " + expectedSalutationType + ", Found: " + actualSalutionType);
        }
		return this;
	}
	
	public LeadsPage verifyfirstName(String expectedFirstName) {
		String actualFirstName = getBrowser().locateElement(LocatorType.XPATH, "//lightning-formatted-name[@slot='primaryField']").getText();
		if(actualFirstName.contains(expectedFirstName)) {
			System.out.println("First Name Verified: " + actualFirstName);
        } else {
            System.out.println("First Name Mismatch. Expected to contain: " + expectedFirstName + ", Found: " + actualFirstName);
        }
		return this;
	}
	
	public LeadsPage verifyLastName(String expectedLastName) {
		String actualLastName = getBrowser().locateElement(LocatorType.XPATH, "//lightning-formatted-name[@slot='primaryField']").getText();
		if(actualLastName.contains(expectedLastName)) {
			System.out.println("Last Name Verified: " + actualLastName);
        } else {
            System.out.println("Last Name Mismatch. Expected to contain: " + expectedLastName + ", Found: " + actualLastName);
        }
		return this;
	}
	
	public LeadsPage searchExistingLead(String leadName) {
		getBrowser().locateTextArea(LocatorType.XPATH, "//input[@placeholder='Search this list...']").type(leadName+Keys.ENTER);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}
	
	public LeadsPage clickEditButton() {
		getBrowser().locateButton(LocatorType.XPATH, "//table[@aria-label='Recently Viewed']/tbody/tr[1]/td[10]").click();
		getBrowser().locateLink(LocatorType.XPATH, "//a[@title='Edit']").click();
		return this;
	}
	
	public LeadsPage clickDeleteButton() {
		getBrowser().locateButton(LocatorType.XPATH, "//table[@aria-label='Recently Viewed']/tbody/tr[1]/td[10]").click();
		getBrowser().locateLink(LocatorType.XPATH, "//a[@title='Delete']").click();
		getBrowser().locateButton(LocatorType.XPATH, "//button[@title='Delete']").click();
		return this;
	}
	
	public LeadsPage clickFirstLeadName() {
		getBrowser().locateLink(LocatorType.XPATH, "//table[@aria-label='Recently Viewed']/tbody/tr[1]/th[1]//a").click();
		return this;
	}
}
