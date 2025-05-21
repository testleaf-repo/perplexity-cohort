package com.testleaf.web.element;

public interface Element {
    boolean isDisplayed();
    boolean isEnabled();
    boolean isSelected();
    String getText();
    String getAttribute(String name);
    void hover();
}
