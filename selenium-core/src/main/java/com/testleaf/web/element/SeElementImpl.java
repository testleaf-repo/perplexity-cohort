package com.testleaf.web.element;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeElementImpl implements Element {
    
    protected final WebElement element;
    protected final WebDriver driver;
    protected final WebDriverWait wait;
    protected final Actions actions;
    
    public SeElementImpl(WebElement element) {
        this.element = element;
        this.driver  = ((RemoteWebElement)element).getWrappedDriver();
        this.wait    = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
    }

    @Override
    public boolean isDisplayed() {
        return element.isDisplayed();
    }

    @Override
    public boolean isEnabled() {
        return element.isEnabled();
    }

    @Override
    public boolean isSelected() {
        return element.isSelected();
    }

    @Override
    public String getText() {
        return element.getText();
    }

    @Override
    public String getAttribute(String name) {
        return element.getAttribute(name);
    }

    @Override
    public void hover() {
        actions.moveToElement(element).perform();
    }
}
