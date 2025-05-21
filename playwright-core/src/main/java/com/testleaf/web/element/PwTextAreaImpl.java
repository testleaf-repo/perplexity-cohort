package com.testleaf.web.element;

import com.microsoft.playwright.Locator;

public class PwTextAreaImpl extends PwElementImpl implements TextArea {
    public PwTextAreaImpl(Locator locator) {
        super(locator);
    }

    @Override
    public void type(String text) {
        locator.fill(text);
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
    public void appendText(String text) {
        locator.fill(locator.inputValue() + text);
    }

    @Override
    public void setText(String text) {
        locator.fill(text);
    }
}
