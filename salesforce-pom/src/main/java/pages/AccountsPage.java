package pages;

import base.ProjectHooks;
import com.testleaf.constants.LocatorType;
import com.testleaf.web.element.Element;
import org.openqa.selenium.WebElement;

public class AccountsPage extends ProjectHooks {

    public AccountsPage clickNewButton() {
        getBrowser().locateLink(LocatorType.XPATH, "//a[@title='New']").click();
        return this;
    }

    public AccountsPage enterAccountName(String accountName) {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Account Name']/following::input[1]").type(accountName);
        return this;
    }

    public AccountsPage enterPhoneNumber(String phoneNumber) {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Phone']/following::input[1]").type(phoneNumber);
        return this;
    }

    public AccountsPage enterWebsite(String website) {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Website']/following::input[1]").type(website);
        return this;
    }

    public AccountsPage chooseIndustry(String industryType) {
        getBrowser().locateButton(LocatorType.XPATH, "//label[text()='Industry']/following::button[1]").click();
        getBrowser().locateButton(LocatorType.XPATH, "//lightning-base-combobox-item[@data-value='"+industryType+"']").click();
        return this;
    }

    public AccountsPage clickSaveButton() {
        getBrowser().locateButton(LocatorType.XPATH, "//button[@name='SaveEdit']").click();
        return this;
    }

    public AccountsPage verifyAccountName(String expectedAccountName) {
        String actualAccountName = getBrowser().locateElement(LocatorType.XPATH, "//lightning-formatted-text[text()='"+expectedAccountName+"']").getText();
        if(actualAccountName.contains(expectedAccountName)) {
            System.out.println("Account Name Verified: " + expectedAccountName);
        } else {
            System.out.println("Account Name Mismatch. Expected to contain: " + expectedAccountName + ", Found: " + actualAccountName);
        }
        return this;
    }

    public AccountsPage verifyContactSection(String accountName) {
        Element contactSection = getBrowser().locateElement(LocatorType.XPATH, "//lightning-formatted-text[text()='"+accountName+"']/following::span[@title='Contacts'][1]");
        assert contactSection.isDisplayed() : "Contact Section is not displayed";
        return this;
    }

    public AccountsPage clickNewContactButton(String accountName) {
        getBrowser().locateLink(LocatorType.XPATH, "//lightning-formatted-text[text()='"+accountName+"']/following::button[@name='NewContact'][1]").click();
        return this;
    }

    public AccountsPage enterContactFirstName(String firstName) {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='First Name']/following::input[1]").type(firstName);
        return this;
    }

    public AccountsPage enterContactLastName(String lastName) {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Last Name']/following::input[1]").type(lastName);
        return this;
    }

    public AccountsPage clearContactPhone() {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Phone']/following::input[1]").clear();
        return this;
    }

    public AccountsPage enterContactPhone(String phoneNumber) {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Phone']/following::input[1]").type(phoneNumber);
        return this;
    }

    public AccountsPage enterContactEmail(String email) {
        getBrowser().locateTextArea(LocatorType.XPATH, "//label[text()='Email']/following::input[1]").type(email);
        return this;
    }

    public AccountsPage verifyContact(String expectedContactName) {
        String actualContactName = getBrowser().locateElement(LocatorType.XPATH, "(//span[text()='"+expectedContactName+"'])[1]").getText();
        if(actualContactName.contains(expectedContactName)) {
            System.out.println("Contact Name Verified: " + expectedContactName);
        } else {
            System.out.println("Contact Name Mismatch. Expected to contain: " + expectedContactName + ", Found: " + actualContactName);
        }
        return this;
    }

    public ContactsPage clickContactName(String contactName) {
        getBrowser().locateLink(LocatorType.XPATH, "(//span[text()='"+contactName+"'])[1]").click();
        return new ContactsPage();
    }
}
