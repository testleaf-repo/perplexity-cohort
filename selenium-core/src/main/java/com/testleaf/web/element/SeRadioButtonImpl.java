package com.testleaf.web.element;

import org.openqa.selenium.WebElement;

public class SeRadioButtonImpl extends SeElementImpl implements RadioButton {

    public SeRadioButtonImpl(WebElement element) {
        super(element);
    }

    @Override
    public void select() {
        if (!element.isSelected()) {
            element.click();
        }
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }
}
