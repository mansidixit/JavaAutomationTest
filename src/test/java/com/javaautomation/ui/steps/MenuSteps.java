package com.javaautomation.ui.steps;

import com.javaautomation.ui.pages.MenuPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class MenuSteps{
	
	MenuPage menuPage;
	
	public MenuSteps() {
		menuPage = new MenuPage();
	}
	

	@Given("I navigate to {string}")
	public void i_navigate_to(String string) {
	   
	}
	
	@When("I click {string}")
	public void i_click(String string) {
		if(string.equalsIgnoreCase("find locations")) {
			menuPage.clickFindLocations();
		}
	}

}
