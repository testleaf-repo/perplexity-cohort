package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.BasePage;

public class TC003_DeleteLead extends BasePage {

    @BeforeTest
    public void setData() {
        dataSheetName = "CreateLead";
    }

    @Test
    public void runDeleteLead() {
        
    		new AppLauncherPage()
    		.searchAndClickLeads()
    		.searchExistingLead("Arun")
    		.clickDeleteButton();
    }
}
