package com.testleaf.web.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeTextAreaImpl extends SeElementImpl implements TextArea {

    public SeTextAreaImpl(WebElement element) {
        super(element);
    }

    @Override
    public void type(String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(text);
    }

    @Override
    public void appendText(String text) {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    @Override
    public void clear() {
        wait.until(ExpectedConditions.visibilityOf(element));
        element.clear();
    }

    @Override
    public String getValue() {
        return element.getAttribute("value");
    }

    @Override
    public void setText(String text) {
        type(text);
    }
}
