package com.testleaf.web.element;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.MouseButton;

public class PwButtonImpl extends PwElementImpl implements Button {

    public PwButtonImpl(Locator locator) {
        super(locator);
    }

    @Override
    public void click() {
        locator.click();
    }

    @Override
    public void doubleClick() {
        locator.dblclick();
    }

    @Override
    public void rightClick() {
        locator.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));
    }
}
