package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.BasePage;

public class TC004_CreateOpportunity extends BasePage {

    @BeforeTest
    public void setData() {
        dataSheetName = "CreateLead";
    }

    @Test
    public void runCreateOpportunity() {
        
    		new AppLauncherPage()
    		.searchAndClickOpportunities()
    		.clickNewButton()
    		.enterOpportunityName("Walker")
    		.enterCloseDate("21/05/2025")
    		.chooseStage("Qualification")
    		.clickSaveButton()
    		.verifyOpportunityName("Walker");
    		
    }
}
