package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.BasePage;

public class TC006_DeleteOpportunity extends BasePage {

    @BeforeTest
    public void setData() {
        dataSheetName = "CreateLead";
    }

    @Test
    public void runDeleteOpportunity() {
        
    		new AppLauncherPage()
    		.searchAndClickOpportunities()
    		.searchExistingOpportunity("Jhon")
    		.clickDeleteButton();
    }
}
