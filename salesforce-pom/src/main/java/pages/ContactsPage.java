package pages;

import base.ProjectHooks;
import com.testleaf.constants.LocatorType;

public class ContactsPage extends ProjectHooks {

    public ContactsPage editContact(String contactName) {
        getBrowser().locateLink(LocatorType.XPATH, "(//lightning-formatted-name[text()='" + contactName + "']/following::lightning-button-menu)[1]").click();
        getBrowser().locateLink(LocatorType.XPATH, "(//lightning-menu-item/following::a/span[text()='Edit'])[1]").click();
        return this;
    }

    public ContactsPage clearContactPhone() {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Phone']/following::input[1]").clear();
        return this;
    }

    public ContactsPage enterContactPhone(String phoneNumber) {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Phone']/following::input[1]").type(phoneNumber);
        return this;
    }

    public ContactsPage enterContactDepartment(String department){
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Department']/following::input[1]").type(department);
        return this;
    }

    public ContactsPage clickSaveButton() {
        getBrowser().locateButton(LocatorType.XPATH, "//button[@name='SaveEdit']").click();
        return this;
    }

    public ContactsPage verifyContactPhone(String expectedContactPhone) {
        String actualContactPhone = getBrowser().locateElement(LocatorType.XPATH, "(//p[text()='Account Name']/following::lightning-formatted-phone/a)[1]").getText();
        if(actualContactPhone.contains(expectedContactPhone)) {
            System.out.println("Contact Phone Verified: " + expectedContactPhone);
        } else {
            System.out.println("Contact Phone Mismatch. Expected to contain: " + expectedContactPhone + ", Found: " + actualContactPhone);
        }
        return this;
    }

    public AccountsPage clickAccountName(String accountName) throws InterruptedException {
        getBrowser().locateLink(LocatorType.XPATH, "(//p[text()='Account Name']/following::span[contains(text(),'"+accountName+"')])[1]").click();
        return new AccountsPage();
    }
}
