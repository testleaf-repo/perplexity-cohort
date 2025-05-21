// src/main/java/com/testleaf/web/element/PwElementImpl.java
package com.testleaf.web.element;

import com.microsoft.playwright.Locator;

public class PwElementImpl implements Element {

    protected final Locator locator;

    public PwElementImpl(Locator locator) {
        this.locator = locator;
    }

    @Override
    public boolean isDisplayed() {
        return locator.isVisible();
    }

    @Override
    public boolean isEnabled() {
        return locator.isEnabled();
    }

    @Override
    public boolean isSelected() {
        return locator.isChecked();
    }

    @Override
    public String getText() {
        return locator.textContent();
    }

    @Override
    public String getAttribute(String attribute) {
        return locator.getAttribute(attribute);
    }

    @Override
    public void hover() {
        locator.hover();
    }
}
