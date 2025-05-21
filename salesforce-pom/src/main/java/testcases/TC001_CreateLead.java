package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.BasePage;

public class TC001_CreateLead extends BasePage {

    @BeforeTest
    public void setData() {
        dataSheetName = "CreateLead";
    }

    @Test
    public void runCreateLead() {
        
    		new AppLauncherPage()
    		.searchAndClickLeads()
    		.clickNewButton()
    		.chooseSalutation("Mr.")
    		.enterFirstName("Gokul")
    		.enterLastName("Sekar")
    		.enterCompanyName("TestLeaf")
    		.clickSaveButton()
    		.verifySalutationType("Mr.")
    		.verifyfirstName("Gokul")
    		.verifyLastName("Sekar");
    }
}
