package com.javaautomation.hook;

import com.javaautomation.ui.driver.Driver;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class HookSteps {

	
@Before
public void beforeEachTest() {
	Driver.initializeDriver();
 }

@After
public void afterEachTest() {
	Driver.shutDown();
 }
}
