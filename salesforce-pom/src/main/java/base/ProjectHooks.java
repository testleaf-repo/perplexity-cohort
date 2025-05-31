package base;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.testleaf.constants.BrowserTestEngine;
import com.testleaf.constants.BrowserType;
import com.testleaf.drivers.manager.DriverManager;
import com.testleaf.web.browser.Browser;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utility.ReadExcel;

public class ProjectHooks extends AbstractTestNGCucumberTests{

    public String leadID;
    public String dataSheetName;

    private static ThreadLocal<Browser> browser = new ThreadLocal<>();

    public static Browser getBrowser() {
        return browser.get();
    }

    @BeforeMethod
    @Parameters({"browserEngine", "browserType"})
    public void preCondition(@Optional("SELENIUM") String browserEngineParam, @Optional("CHROME") String browserTypeParam) {
    	System.setProperty("remote", "true"); // set the property to true for run in remote machine
        BrowserTestEngine browserEngine = BrowserTestEngine.valueOf(browserEngineParam.toUpperCase());
        BrowserType browserType = BrowserType.valueOf(browserTypeParam.toUpperCase());

        // Get the browser instance from DriverManager
        Browser br = DriverManager.getBrowser(browserEngine, browserType);
        browser.set(br);

        // Navigate to the URL and maximize
        getBrowser().navigateTo("https://login.salesforce.com/");
        getBrowser().maximize();
    }

    @AfterMethod
    public void postCondition() {
        // Close the browser
        getBrowser().closeBrowser();
    }

    @DataProvider(name = "fetchData")
    public String[][] fetchData() throws IOException {
        return ReadExcel.readExcel(dataSheetName);
    }
}
