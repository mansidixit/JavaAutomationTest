package com.javaautomation.ui.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.javaautomation.ui.driver.Driver;


public abstract class BasePage {
	protected  WebDriver driver;
 	private int timeout;
 	private int pollingTime;
 	
 	protected String browserName;
 	
  	public BasePage (int timeout) {
  		driver = Driver.getTestDriver();
  		if(null!= driver) {
  			this.timeout=timeout;
  	 		pollingTime=50;
  		}
  		
 	}
  	
   public BasePage (WebDriver driver, int timeout, int pollingTime) {
 		this(timeout);
 		this.pollingTime=pollingTime;
 	}
 	
 
	public void fluentlyWaitFor(ExpectedCondition<?> expectedCondition) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(timeout))
				.pollingEvery(Duration.ofMillis(pollingTime))
				.ignoring(NoSuchElementException.class);		
		wait.until(expectedCondition);
	}
	
	
	public  WebElement getMatchingElement(List<WebElement> resultList, String searchString) {
		for(int i=0 ; i< resultList.size() ; i++) {
			WebElement searchElement = resultList.get(i);
			if(searchString.equalsIgnoreCase(searchElement.getText())){
			 return searchElement;	
			}
		}
		return null;
	}
	
	public void shutDown() {
		if(Driver.getTestDriver()!= null)
			Driver.shutDown();
	}


}
