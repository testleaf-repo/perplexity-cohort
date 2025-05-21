package com.testleaf.web.browser;

import com.testleaf.constants.LocatorType;
import com.testleaf.web.element.*;

public interface Browser {
    // Core browser lifecycle
    void navigateTo(String url);
    void maximize();
    void closeBrowser();
    String getTitle();
    void acceptAlert();
    void dismissAlert();
    String getAlertText();
    default void executeScriprt(String script, Object... args) {
    	
    }
    
    default void clickJs(LocatorType locatorType, String locator) {
    	
    }

    // Element lookup
    Element   locateElement(LocatorType by, String locator);
    Button    locateButton( LocatorType by, String locator);
    Edit      locateEdit(   LocatorType by, String locator);
    Link      locateLink(   LocatorType by, String locator);
    DropDown  locateDropDown(LocatorType by, String locator);
    CheckBox  locateCheckBox(LocatorType by, String locator);
    RadioButton locateRadioButton(LocatorType by, String locator);
    TextArea  locateTextArea(LocatorType by, String locator);
}
