package com.testleaf.web.browser;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.testleaf.constants.LocatorType;
import com.testleaf.web.element.Button;
import com.testleaf.web.element.CheckBox;
import com.testleaf.web.element.DropDown;
import com.testleaf.web.element.Edit;
import com.testleaf.web.element.Element;
import com.testleaf.web.element.Link;
import com.testleaf.web.element.RadioButton;
import com.testleaf.web.element.SeButtonImpl;
import com.testleaf.web.element.SeCheckBoxImpl;
import com.testleaf.web.element.SeDropDownImpl;
import com.testleaf.web.element.SeEditImpl;
import com.testleaf.web.element.SeElementImpl;
import com.testleaf.web.element.SeLinkImpl;
import com.testleaf.web.element.SeRadioButtonImpl;
import com.testleaf.web.element.SeTextAreaImpl;
import com.testleaf.web.element.TextArea;


public class SeBrowserImpl implements Browser {

	protected WebDriver driver;

	public SeBrowserImpl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void navigateTo(String url) {
		this.driver.get(url);
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Override
	public void maximize() {
		this.driver.manage().window().maximize();
	}

	@Override
	public void closeBrowser() {
		this.driver.close();
	}

	private WebElement findElement(LocatorType locatorType, String locator) {
		switch (locatorType) {
		case ID:
			return this.driver.findElement(By.id(locator));
		case NAME:
			return this.driver.findElement(By.name(locator));
		case CLASS:
			return this.driver.findElement(By.className(locator));
		case LINK_TEXT:
			return this.driver.findElement(By.linkText(locator));
		case XPATH:
			return this.driver.findElement(By.xpath(locator));
		default:
			throw new IllegalArgumentException("Unsupported Locator Type :" + locatorType);
		}
	}

	@Override
	public Element locateElement(LocatorType locatorType, String element) {
		return new SeElementImpl(findElement(locatorType, element));
	}

	@Override
	public Edit locateEdit(LocatorType locatorType, String element) {
		return new SeEditImpl(findElement(locatorType, element));
	}

	@Override
	public Button locateButton(LocatorType locatorType, String element) {
		return new SeButtonImpl(findElement(locatorType, element));
	}

	@Override
	public Link locateLink(LocatorType locatorType, String element) {
		return new SeLinkImpl(findElement(locatorType, element));

	}
	
	@Override
	public String getTitle() {
		return driver.getTitle();
	}

    @Override
    public void acceptAlert() {
        Alert a = driver.switchTo().alert();
        a.accept();
    }

    @Override
    public void dismissAlert() {
        Alert a = driver.switchTo().alert();
        a.dismiss();
    }

    @Override
    public String getAlertText() {
        Alert a = driver.switchTo().alert();
        return a.getText();
    }

    @Override
    public DropDown locateDropDown(LocatorType by, String locator) {
        return new SeDropDownImpl(findElement(by, locator));
    }

    @Override
    public CheckBox locateCheckBox(LocatorType by, String locator) {
        return new SeCheckBoxImpl(findElement(by, locator));
    }

    @Override
    public RadioButton locateRadioButton(LocatorType by, String locator) {
        return new SeRadioButtonImpl(findElement(by, locator));
    }

    @Override
    public TextArea locateTextArea(LocatorType by, String locator) {
        return new SeTextAreaImpl(findElement(by, locator));
    }

	@Override
	public void executeScriprt(String script, Object... args) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		if(args != null)
        js.executeScript(script,args);
		else js.executeScript(script);
	}
	
	public void clickJs(LocatorType locatorType, String locator) {
		executeScriprt("arguments[0].click()", findElement(locatorType, locator));
	}




}
