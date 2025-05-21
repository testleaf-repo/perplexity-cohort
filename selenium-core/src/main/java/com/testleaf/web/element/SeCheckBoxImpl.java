package com.testleaf.web.element;

import org.openqa.selenium.WebElement;

public class SeCheckBoxImpl extends SeElementImpl implements CheckBox {

    public SeCheckBoxImpl(WebElement element) {
        super(element);
    }

    @Override
    public void check() {
        if (!element.isSelected()) {
            element.click();
        }
    }

    @Override
    public void uncheck() {
        if (element.isSelected()) {
            element.click();
        }
    }

    @Override
    public boolean isChecked() {
        return element.isSelected();
    }

    @Override
    public void toggle() {
        element.click();
    }
}
