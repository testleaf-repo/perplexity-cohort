package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.BasePage;

public class TC005_EditOpportunity extends BasePage {

    @BeforeTest
    public void setData() {
        dataSheetName = "CreateLead";
    }

    @Test
    public void runEditOpportunity() {
        
    		new AppLauncherPage()
    		.searchAndClickOpportunities()
    		.searchExistingOpportunity("Walker")
    		.clickEditButton()
    		.enterOpportunityName("Jhon")
    		.clickSaveButton();
    }
}
