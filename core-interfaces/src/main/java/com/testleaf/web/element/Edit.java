package com.testleaf.web.element;

public interface Edit extends Element {
    void type(String text);
    void clear();
    String getValue();
    void pressEnter();
    void appendText(String text);
}
