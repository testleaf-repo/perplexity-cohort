package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.AppLauncherPage;
import pages.BasePage;

public class TC007_CreateServiceTerritory extends BasePage {

    @BeforeTest
    public void setData() {
        dataSheetName = "CreateLead";
    }

    @Test
    public void runServiceTerritory() {
        
    		new AppLauncherPage()
    		.searchAndClickServiceTerritories()
    		.clickNewButton()
    		.enterServiceTerritoryName("Sekar")
    		.chooseOperatingHours()
    		.clickActiveCheckbox()
    		.enterCity("Chennai")
    		.enterState("TamilNadu")
    		.enterCountry("India")
    		.clickSaveButton()
    		.verifyServiceTerritoryName("Sekar");
    }
}
