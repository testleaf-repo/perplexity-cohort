package pages;

import com.testleaf.constants.LocatorType;
import base.ProjectHooks;

public class WelcomePage extends ProjectHooks {
	public WelcomePage clickAppLauncher(){
		getBrowser().locateButton(LocatorType.XPATH, "//div[@class='slds-icon-waffle']").click();
		return this;
	}
	
	public AppLauncherPage clickViewAllButton() {
		getBrowser().locateButton(LocatorType.XPATH,"//button[text()='View All']").click();
		return new AppLauncherPage();
	}
	
	
}
