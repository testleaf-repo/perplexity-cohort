package com.testleaf.web.browser;

import java.nio.file.Paths;
import java.util.Map;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.RequestOptions;
import com.testleaf.constants.BrowserType;
import com.testleaf.constants.LocatorType;
import com.testleaf.web.api.ResponseAPI;
import com.testleaf.web.api.APIClient;
import com.testleaf.web.api.PwResponseImpl;
import com.testleaf.web.element.*;

/**
 * Playwright-based implementation of Browser + APIClient
 */
public class PwBrowserImpl implements Browser, APIClient {

    private Playwright playwright;
    private com.microsoft.playwright.Browser pwBrowser;
    private BrowserContext context;
    private Page page;

    public PwBrowserImpl(BrowserType browserType) {
        playwright = Playwright.create();
        switch (browserType) {
            case CHROME:
                pwBrowser = playwright.chromium()
                    .launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                break;
            case FIREFOX:
                pwBrowser = playwright.firefox()
                    .launch(new com.microsoft.playwright.BrowserType.LaunchOptions().setHeadless(false));
                break;
            default:
                throw new IllegalArgumentException("Unsupported BrowserType: " + browserType);
        }
        context = pwBrowser.newContext();
        page = context.newPage();
    }

    @Override
    public void navigateTo(String url) {
        page.navigate(url);
    }

    @Override
    public void maximize() {
        page.setViewportSize(1920, 1080);
    }

    @Override
    public void closeBrowser() {
        if (context != null)  context.close();
        if (pwBrowser != null) pwBrowser.close();
        if (playwright != null) playwright.close();
    }

    @Override
    public String getTitle() {
        return page.title();
    }

    @Override
    public void acceptAlert() {
        page.onDialog(d -> d.accept());
    }

    @Override
    public void dismissAlert() {
        page.onDialog(d -> d.dismiss());
    }

    @Override
    public String getAlertText() {
        final String[] text = {null};
        page.onDialog(d -> { text[0] = d.message(); d.dismiss(); });
        return text[0];
    }

    private String buildSelector(LocatorType by, String locator) {
        switch (by) {
            case ID:        return "#" + locator;
            case NAME:      return "[name='" + locator + "']";
            case CLASS:     return "." + locator;
            case LINK_TEXT: return "text=\"" + locator + "\"";
            case XPATH:     return "xpath=" + locator;
            default:        throw new IllegalArgumentException("Unsupported LocatorType: " + by);
        }
    }

    // Element lookups
    @Override public Element    locateElement(LocatorType by, String locator)    {
        return new PwElementImpl(page.locator(buildSelector(by, locator)).first());
    }
    @Override public Button     locateButton(LocatorType by, String locator)     {
        return new PwButtonImpl(page.locator(buildSelector(by, locator)).first());
    }
    @Override public Edit       locateEdit(LocatorType by, String locator)       {
        return new PwEditImpl(page.locator(buildSelector(by, locator)).first());
    }
    @Override public Link       locateLink(LocatorType by, String locator)       {
        return new PwLinkImpl(page.locator(buildSelector(by, locator)).first());
    }
    @Override public DropDown   locateDropDown(LocatorType by, String locator)   {
        return new PwDropDownImpl(page.locator(buildSelector(by, locator)).first());
    }
    @Override public CheckBox   locateCheckBox(LocatorType by, String locator)   {
        return new PwCheckBoxImpl(page.locator(buildSelector(by, locator)).first());
    }
    @Override public RadioButton locateRadioButton(LocatorType by, String locator){
        return new PwRadioButtonImpl(page.locator(buildSelector(by, locator)).first());
    }
    @Override public TextArea   locateTextArea(LocatorType by, String locator)   {
        return new PwTextAreaImpl(page.locator(buildSelector(by, locator)).first());
    }

    // APIClient methods with bearer token
    @Override
    public ResponseAPI get(String endPoint, String token) {
        APIResponse resp = page.request()
            .get(endPoint, RequestOptions.create()
                .setHeader("Authorization", "Bearer " + token)
                .setHeader("Content-Type", "application/json"));
        return new PwResponseImpl(resp);
    }

    @Override
    public ResponseAPI post(String endPoint, String token, Object body) {
        APIResponse resp = page.request()
            .post(endPoint, RequestOptions.create()
                .setHeader("Authorization", "Bearer " + token)
                .setHeader("Content-Type", "application/json")
                .setData(body));
        return new PwResponseImpl(resp);
    }

    @Override
    public ResponseAPI put(String endPoint, String token, Object body) {
        APIResponse resp = page.request()
            .put(endPoint, RequestOptions.create()
                .setHeader("Authorization", "Bearer " + token)
                .setHeader("Content-Type", "application/json")
                .setData(body));
        return new PwResponseImpl(resp);
    }

    @Override
    public ResponseAPI delete(String endPoint, String token) {
        APIResponse resp = page.request()
            .delete(endPoint, RequestOptions.create()
                .setHeader("Authorization", "Bearer " + token)
                .setHeader("Content-Type", "application/json"));
        return new PwResponseImpl(resp);
    }
}
