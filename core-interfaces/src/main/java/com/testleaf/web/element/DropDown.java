package com.testleaf.web.element;

import java.util.List;

public interface DropDown extends Element {
    void selectByVisibleText(String text);
    void selectByValue(String value);
    void selectByIndex(int index);
    String getFirstSelectedOption();
    List<String> getAllOptions();
    boolean isMultiple();
    void deselectAll();         
    void deselectByVisibleText(String text);
    void deselectByValue(String value);
    void deselectByIndex(int index);
}
