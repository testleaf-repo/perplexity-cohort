package com.testleaf.web.element;

import com.microsoft.playwright.Locator;

public class PwCheckBoxImpl extends PwElementImpl implements CheckBox {
    public PwCheckBoxImpl(Locator locator) {
        super(locator);
    }

    @Override
    public void check() {
        if (!locator.isChecked()) locator.check();
    }

    @Override
    public void uncheck() {
        if (locator.isChecked()) locator.uncheck();
    }

    @Override
    public boolean isChecked() {
        return locator.isChecked();
    }

    @Override
    public void toggle() {
        if (locator.isChecked()) locator.uncheck();
        else locator.check();
    }
}
