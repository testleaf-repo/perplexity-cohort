package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.BasePage;

public class TC002_EditLead extends BasePage {

    @BeforeTest
    public void setData() {
        dataSheetName = "CreateLead";
    }

    @Test
    public void runEditLead() {
        
    		new AppLauncherPage()
    		.searchAndClickLeads()
    		.searchExistingLead("Gokul")
    		.clickEditButton()
    		.enterFirstName("Arun")
    		.enterLastName("Sundar")
    		.clickSaveButton()
    		.searchExistingLead("Arun")
    		.clickFirstLeadName()
    		.verifyfirstName("Arun")
    		.verifyLastName("Sundar");
    }
}
