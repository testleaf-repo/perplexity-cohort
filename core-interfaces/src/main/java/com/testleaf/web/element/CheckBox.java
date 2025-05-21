package com.testleaf.web.element;

public interface CheckBox extends Element {
    void check();
    void uncheck();
    boolean isChecked();
    void toggle();
}
