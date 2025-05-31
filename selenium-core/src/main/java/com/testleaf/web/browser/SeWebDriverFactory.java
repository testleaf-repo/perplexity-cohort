package com.testleaf.web.browser;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.testleaf.constants.BrowserType;

public class SeWebDriverFactory implements WebDriverFactory {

    @Override
//    public WebDriver createDriver(BrowserType browserType, Capabilities capabilities) {
//        switch (browserType) {
//            case CHROME:
//                ChromeOptions chromeOptions = new ChromeOptions();
//                if (capabilities != null) {
//                    chromeOptions.merge(capabilities);
//                }
//                return new ChromeDriver(chromeOptions);
//            case FIREFOX:
//                FirefoxOptions firefoxOptions = new FirefoxOptions();
//                if (capabilities != null) {
//                    firefoxOptions.merge(capabilities);
//                }
//                return new FirefoxDriver(firefoxOptions);
//            default:
//                throw new IllegalArgumentException("Unsupported BrowserType: " + browserType);
//        }
//    }
    
    public WebDriver createDriver(BrowserType browserType, Capabilities capabilities) {
    	boolean useRemote;
        switch (browserType) {
            case CHROME:
                ChromeOptions chromeOptions = new ChromeOptions();
                if (capabilities != null) {
                	chromeOptions.merge(capabilities);                    
                }
                useRemote = Boolean.parseBoolean(System.getProperty("remote"));
                if (useRemote) {
                    try {
                    	DesiredCapabilities dc = new DesiredCapabilities();
                    	dc.setBrowserName("chrome");
                    	chromeOptions.merge(dc);
                        return new RemoteWebDriver(new URL("http://20.244.33.62:32000/wd/hub"), chromeOptions);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid Selenium Grid URL", e);
                    }
                } else {
                    return new ChromeDriver(chromeOptions);
                }

            case FIREFOX:
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (capabilities != null) {
                    firefoxOptions.merge(capabilities);
                }
                useRemote = Boolean.parseBoolean(System.getProperty("remote"));
                if (useRemote) {
                    try {
                    	DesiredCapabilities dc = new DesiredCapabilities();
                    	dc.setBrowserName("chrome");
                    	firefoxOptions.merge(dc);
                        return new RemoteWebDriver(new URL("http://20.244.33.62:32000/wd/hub"), firefoxOptions);
                    } catch (MalformedURLException e) {
                        throw new RuntimeException("Invalid Selenium Grid URL", e);
                    }
                } else {
                    return new FirefoxDriver(firefoxOptions);
                }

            default:
                throw new IllegalArgumentException("Unsupported BrowserType: " + browserType);
        }
    }


 
}
