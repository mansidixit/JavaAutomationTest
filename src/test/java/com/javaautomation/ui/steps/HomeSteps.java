package com.javaautomation.ui.steps;

import org.testng.Assert;

import com.javaautomation.ui.pages.HomePage;

import cucumber.api.java.en.Given;


public class HomeSteps{
	
	private HomePage homePage;
	
	
	public HomeSteps() {
		homePage = new HomePage();
	}

	
	
	@Given("I am on NSW Service Centre Site")
	public void i_am_on_NSW_Service_Centre_Site() {
		Assert.assertEquals(homePage.isLoaded(), true); 
	}
	
	@Given("I search and navigate to {string}")
	public void i_search_and_navigate_to(String searchString) {
		Assert.assertEquals(homePage.isLoaded(), true);
		try {
			homePage.searchAndNavigateTo(searchString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
