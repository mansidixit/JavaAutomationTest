package com.javaautomation.ui.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends MenuPage {
	
	@FindBy(css = "div.home > header.home-hero")
	WebElement homePageLocator;
	
	@FindBy(css = "#homeAutosuggest > input")
	WebElement mainSearchText ;
	
	@FindBy(css = "form.form--hero-search-group  > div.form__actions > button")
	WebElement mainSearchBtn ;
	
	@FindBy(css = "div.search__result > h3 > a")
	List<WebElement> resultList;
	
	@FindBy(css = "div.search__result:nth-child(2) > h3 > a")
	WebElement firstSearchElement;
	
	@FindBy(css = "body > div.dialog-off-canvas-main-canvas.servicensw-canvas > header.page-header > div > nav > ol > li.breadcrumb__previous > a")
	WebElement numberPlatePage;
	
	public HomePage() {
		super();
		PageFactory.initElements(driver, this);
	}

	public boolean isLoaded() {
		
		return homePageLocator.isDisplayed();
	}
	
	public String getMainSearchText() {
		return mainSearchText.getText();
	}

	public void setMainSearchText(String searchText) {
		this.mainSearchText.sendKeys(searchText);
	}

	public void clickMainSearchBtn() {
		mainSearchBtn.click();
		
	}

	public void searchAndNavigateTo(String searchString) throws Exception {
		setMainSearchText(searchString);
		clickMainSearchBtn();
		clickTheResultLink(searchString);
	}

	public void clickTheResultLink(String searchString) throws Exception {
		
		fluentlyWaitFor(ExpectedConditions.visibilityOf(firstSearchElement));
		WebElement searchLink =  getMatchingElement(resultList ,searchString);
		if(null != searchLink) {
			searchLink.click();
			fluentlyWaitFor(ExpectedConditions.textToBePresentInElement(pageHeader, searchString));
			
		}else {
			throw new Exception("Could not find the search string");
		}
	}

	
	


	

	
	
}
