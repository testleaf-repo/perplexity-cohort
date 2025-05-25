package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.ProjectHooks;

public class BasePage extends ProjectHooks{
	
	@BeforeMethod
	public void setup() {
		new LoginPage()
        .enterUsername("rameshkrishnan.ganesan696@agentforce.com")
        .enterPassword("testleaf@1234")
        .clickLogin()
        .clickAppLauncher()
        .clickViewAllButton();
	}
	
	@AfterMethod
	public void tearDown() {
		new LogoutPage()
		.clickViewProfile()
		.clickLogOut();
	}

}
