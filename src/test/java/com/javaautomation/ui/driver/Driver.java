package com.javaautomation.ui.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	public static WebDriver driver;
	private static final String URL_KEY = "https://www.service.nsw.gov.au/"; // you can get this from an external file
	private static final String BROWSER_NAME  = "CHROME";  //You can get this from an external file
	private static final String CHROME_DRIVER_PATH  = "src/test/resources/drivers/chromedriver.exe"; 

	public static void initializeDriver() {
		switch (BROWSER_NAME) {
			case "IE":
				// set the driver manager and initialize the respective browser
			case "FIREFOX":

			case "OPERA":

			case "EDGE":

			default:
				System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;
			}
		    driver.manage().deleteAllCookies();
			driver.get(URL_KEY);
  			driver.manage().window().maximize();
  			
  			System.out.println(" newDriver");
	}

	public static WebDriver getTestDriver() {
		return driver;
	}

	public static void shutDown() {
		if(null != driver) {
			System.out.println(" quit");
			driver.quit();
		}
	}

}
