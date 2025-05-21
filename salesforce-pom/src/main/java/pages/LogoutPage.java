package pages;

import com.testleaf.constants.LocatorType;

import base.ProjectHooks;

public class LogoutPage extends ProjectHooks{
	public LogoutPage clickViewProfile() {
		getBrowser().locateButton(LocatorType.XPATH, "//span[@data-aura-class='oneUserProfileCardTrigger']//button").click();
		return this;
	}
	
	public void clickLogOut() {
		getBrowser().locateLink(LocatorType.LINK_TEXT, "Log Out").click();
	}
}
