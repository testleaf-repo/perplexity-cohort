package com.testleaf.drivers.manager;

import com.testleaf.constants.BrowserType;
import com.testleaf.constants.LocatorType;
import com.testleaf.web.api.APIClient;
import com.testleaf.web.api.RAAPIClientImpl;
import com.testleaf.web.api.ResponseAPI;
import com.testleaf.web.browser.Browser;
import com.testleaf.web.browser.BrowserFactory;
import com.testleaf.web.browser.SeBrowserFactory;
import com.testleaf.web.element.*;

public class SeBrowserAPIImpl implements Browser, APIClient {

    private final Browser browser;
    private final RAAPIClientImpl apiClient;

    public SeBrowserAPIImpl(BrowserType browserType) {
        BrowserFactory seFactory = new SeBrowserFactory();
        this.browser   = seFactory.createBrowser(browserType);
        this.apiClient = new RAAPIClientImpl();
    }

    @Override
    public void navigateTo(String url) {
        browser.navigateTo(url);
    }

    @Override
    public void maximize() {
        browser.maximize();
    }

    @Override
    public void closeBrowser() {
        browser.closeBrowser();
    }

    @Override
    public String getTitle() {
        return browser.getTitle();
    }

    @Override
    public void acceptAlert() {
        browser.acceptAlert();
    }

    @Override
    public void dismissAlert() {
        browser.dismissAlert();
    }

    @Override
    public String getAlertText() {
        return browser.getAlertText();
    }

    @Override
    public Element locateElement(LocatorType by, String locator) {
        return browser.locateElement(by, locator);
    }

    @Override
    public Edit locateEdit(LocatorType by, String locator) {
        return browser.locateEdit(by, locator);
    }

    @Override
    public Button locateButton(LocatorType by, String locator) {
        return browser.locateButton(by, locator);
    }

    @Override
    public Link locateLink(LocatorType by, String locator) {
        return browser.locateLink(by, locator);
    }

    @Override
    public DropDown locateDropDown(LocatorType by, String locator) {
        return browser.locateDropDown(by, locator);
    }

    @Override
    public CheckBox locateCheckBox(LocatorType by, String locator) {
        return browser.locateCheckBox(by, locator);
    }

    @Override
    public RadioButton locateRadioButton(LocatorType by, String locator) {
        return browser.locateRadioButton(by, locator);
    }

    @Override
    public TextArea locateTextArea(LocatorType by, String locator) {
        return browser.locateTextArea(by, locator);
    }

    // --- APIClient methods with token overloads ---
    @Override
    public ResponseAPI get(String endpoint, String token) {
        return apiClient.get(endpoint, token);
    }

    @Override
    public ResponseAPI post(String endpoint, String token, Object body) {
        return apiClient.post(endpoint, token, body);
    }

    @Override
    public ResponseAPI put(String endpoint, String token, Object body) {
        return apiClient.put(endpoint, token, body);
    }

    @Override
    public ResponseAPI delete(String endpoint, String token) {
        return apiClient.delete(endpoint, token);
    }
}
