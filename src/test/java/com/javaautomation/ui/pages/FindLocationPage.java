package com.javaautomation.ui.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindLocationPage extends MenuPage{
	
	public FindLocationPage() {
		super();
		PageFactory.initElements(driver, this);
		fluentlyWaitFor(ExpectedConditions.visibilityOf(pageHeader));
	}
	
	
	
	@FindBy(id = "locatorTextSearch")
	WebElement locatorSearchText;
	
	@FindBy(css ="#locator > div > div > form > div > div.form__actions > button")
    WebElement locatorSearchBtn;
		
	@FindBy(css = "div.location > a")
	List<WebElement> resultList;
	
	@FindBy(css = "div.location:nth-child(1) > a")
	WebElement firstSearchElement;
	
	public String getLocatorSearchText() {
		return locatorSearchText.getText();
	}

	public void setLocatorSearchText(String locatorString) {
		this.locatorSearchText.sendKeys(locatorString);
	}
	
	public void clickLocatorSearchBtn() {
		this.locatorSearchBtn.click();
		fluentlyWaitFor(ExpectedConditions.visibilityOf(firstSearchElement));
		
	}
	
	public String isCenterNamePresent(String centreName) throws Exception {
		fluentlyWaitFor(ExpectedConditions.visibilityOf(firstSearchElement));
		WebElement searchElement =  getMatchingElement(resultList ,centreName);
		if(null != searchElement) {
			return searchElement.getText();
		}

		throw new Exception(" Could not find the search string : " + centreName);
	}

	
	
	

}
