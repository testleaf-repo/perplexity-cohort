package testcases;

import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.AppLauncherPage;
import pages.BasePage;

public class TC003_CreateAccount extends BasePage {

    @BeforeTest
    public void setData() {
        dataSheetName = "CreateAccount";
    }

    @Test
    public void runCreateAccount() throws InterruptedException {

        Faker faker = new Faker();
        String accountName = faker.name().fullName();
		String phoneNumber = faker.phoneNumber().phoneNumber();
		String website = faker.internet().url();
        String contactFirstName = faker.name().firstName();
        String contactLastName = faker.name().lastName();
        String contactName = contactFirstName + " " + contactLastName;
        String contactEmail = faker.internet().emailAddress();
        String contactPhoneNumber = faker.phoneNumber().phoneNumber();
        String contactDepartment = "Sales";
		String industry = "Finance";


        new AppLauncherPage()
                .searchAndClickAccounts()
                .clickNewButton()
                .enterAccountName(accountName)
				.enterPhoneNumber(phoneNumber)
				.enterWebsite(website)
				.chooseIndustry(industry)
				.clickSaveButton()
				.verifyAccountName(accountName)
                .verifyContactSection(accountName)
                .clickNewContactButton(accountName)
                .enterContactFirstName(contactFirstName)
                .enterContactLastName(contactLastName)
                .clearContactPhone()
                .enterContactPhone(contactPhoneNumber)
                .enterContactEmail(contactEmail)
                .clickSaveButton()
                .verifyContact(contactName)
                .clickContactName(contactName)
                .editContact(contactName)
                .clearContactPhone()
                .enterContactPhone(contactPhoneNumber)
                .enterContactDepartment(contactDepartment)
                .clickSaveButton()
                .verifyContactPhone(contactPhoneNumber)
                .clickAccountName(accountName)
                .verifyContactSection(accountName);
    }
}
