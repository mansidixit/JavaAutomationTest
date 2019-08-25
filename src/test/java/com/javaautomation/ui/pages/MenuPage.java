package com.javaautomation.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {

	@FindBy(css = "body > div.dialog-off-canvas-main-canvas.servicensw-canvas > header.page-header > div > h1")
	WebElement pageHeader;
	
	public MenuPage() {
		super(30);
		PageFactory.initElements(driver, this);
	}


	@FindBy(css = "#block-global-header-menu > div.inline-nav > ul > li:nth-child(3) > a")
	WebElement findLocationLink;
	
	
	public void clickFindLocations() {
		findLocationLink.click();		
	}

}
