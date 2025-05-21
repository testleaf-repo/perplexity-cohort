package pages;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import base.ProjectHooks;

public class BasePage extends ProjectHooks{
	
	@BeforeMethod
	public void setup() {
		new LoginPage()
        .enterUsername("democsr")
        .enterPassword("crmsfa")
        .clickLogin()
        .clickCrmsfa()
        .clickLeadsTab();
	}
	
	@AfterMethod
	public void tearDown() {
		new HomePage()
		.clickOpentaps()
		.clickLogout();
	}

}
