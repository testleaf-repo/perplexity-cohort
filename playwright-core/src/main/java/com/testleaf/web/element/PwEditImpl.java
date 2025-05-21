package com.testleaf.web.element;

import com.microsoft.playwright.Locator;

public class PwEditImpl extends PwElementImpl implements Edit {

    public PwEditImpl(Locator locator) {
        super(locator);
    }

    @Override
    public void type(String text) {
        // replace existing
        locator.fill(text);
    }

    @Override
    public void appendText(String text) {
        locator.type(text);
    }

    @Override
    public void clear() {
        locator.fill("");
    }

    @Override
    public String getValue() {
        return locator.inputValue();
    }

    @Override
    public void pressEnter() {
        locator.press("Enter");
    }
}
