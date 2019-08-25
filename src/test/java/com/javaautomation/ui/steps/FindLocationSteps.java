package com.javaautomation.ui.steps;

import org.testng.Assert;

import com.javaautomation.ui.pages.FindLocationPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FindLocationSteps{
	
	private FindLocationPage locationPage;
	
	public FindLocationSteps() {
		locationPage = new FindLocationPage();
		
	}
	
@When("I search for locateText as {string}")
public void i_search_for_locateText_as(String searchString) {
	
	locationPage.setLocatorSearchText(searchString);
	locationPage.clickLocatorSearchBtn();
}

@Then("I can find {string} in the search results")
public void i_can_find_in_the_search_results(String centreName) {
    try {
		Assert.assertEquals(locationPage.isCenterNamePresent(centreName).toLowerCase(), centreName.toLowerCase());
	} catch (Exception e) {
		e.printStackTrace();
	}
}

}
