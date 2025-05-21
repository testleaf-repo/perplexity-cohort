package com.testleaf.web.element;

import com.microsoft.playwright.Locator;

public class PwRadioButtonImpl extends PwElementImpl implements RadioButton {
    public PwRadioButtonImpl(Locator locator) {
        super(locator);
    }

    @Override
    public void select() {
        if (!locator.isChecked()) locator.check();
    }

    @Override
    public boolean isSelected() {
        return locator.isChecked();
    }
}
