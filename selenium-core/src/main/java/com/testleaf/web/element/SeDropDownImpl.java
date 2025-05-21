package com.testleaf.web.element;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeDropDownImpl extends SeElementImpl implements DropDown {
    
    private final Select select;

    public SeDropDownImpl(WebElement element) {
        super(element);
        this.select = new Select(element);
    }

    @Override
    public void selectByVisibleText(String text) {
        select.selectByVisibleText(text);
    }

    @Override
    public void selectByValue(String value) {
        select.selectByValue(value);
    }

    @Override
    public void selectByIndex(int index) {
        select.selectByIndex(index);
    }

    @Override
    public String getFirstSelectedOption() {
        return select.getFirstSelectedOption().getText();
    }

    @Override
    public List<String> getAllOptions() {
        return select.getOptions().stream()
                     .map(WebElement::getText)
                     .collect(Collectors.toList());
    }

    @Override
    public boolean isMultiple() {
        return select.isMultiple();
    }

    @Override
    public void deselectAll() {
        if (select.isMultiple()) select.deselectAll();
    }

    @Override
    public void deselectByVisibleText(String text) {
        select.deselectByVisibleText(text);
    }

    @Override
    public void deselectByValue(String value) {
        select.deselectByValue(value);
    }

    @Override
    public void deselectByIndex(int index) {
        select.deselectByIndex(index);
    }
}
