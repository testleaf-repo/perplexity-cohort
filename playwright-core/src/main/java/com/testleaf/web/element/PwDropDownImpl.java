package com.testleaf.web.element;

import java.util.List;
import java.util.stream.Collectors;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.options.SelectOption;

public class PwDropDownImpl extends PwElementImpl implements DropDown {
    public PwDropDownImpl(Locator locator) {
        super(locator);
    }

    @Override
    public void selectByVisibleText(String text) {
    	locator.selectOption(new SelectOption().setLabel(text));
    }

    @Override
    public void selectByValue(String value) {
        locator.selectOption(new SelectOption().setValue(value));
    }

    @Override
    public void selectByIndex(int index) {
        locator.selectOption(new SelectOption().setIndex(index));
    }

    @Override
    public String getFirstSelectedOption() {
        return locator.elementHandles()
            .stream()
            .filter(h -> h.isChecked())
            .findFirst()
            .map(h -> h.textContent())
            .orElse("");
    }

    @Override
    public List<String> getAllOptions() {
        return locator.locator("option")
            .allTextContents();
    }

    @Override
    public boolean isMultiple() {
        return Boolean.parseBoolean(locator.getAttribute("multiple"));
    }

    @Override
    public void deselectAll() {
        if (isMultiple()) locator.selectOption((String[]) null);
    }

    @Override
    public void deselectByVisibleText(String text) {
        selectByVisibleText(text); deselectAll();
    }

    @Override
    public void deselectByValue(String value) {
        selectByValue(value); deselectAll();
    }

    @Override
    public void deselectByIndex(int index) {
        selectByIndex(index); deselectAll();
    }
}
