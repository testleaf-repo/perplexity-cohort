package com.testleaf.web.element;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SeButtonImpl extends SeElementImpl implements Button {
    
    public SeButtonImpl(WebElement element) {
        super(element);
    }

    @Override
    public void click() {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    @Override
    public void doubleClick() {
        wait.until(ExpectedConditions.elementToBeClickable(element));
        new Actions(driver).doubleClick(element).perform();
    }

    @Override
    public void rightClick() {
        wait.until(ExpectedConditions.visibilityOf(element));
        new Actions(driver).contextClick(element).perform();
    }
}
