package com.testleaf.web.element;

/**
 * A marker interface for any element that can be selected or deselected.
 */
public interface Selectable extends Element {
    void select();
    void deselect();
    boolean isSelected();
}
