package com.testleaf.web.element;

public interface TextArea extends Element {
    void type(String text);
    void clear();
    String getValue();
    void appendText(String text);
    void setText(String text);
}
