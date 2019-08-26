

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.javaautomation.ui.driver.Driver;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features = "src/test/resources", glue = {"com.javaautomation.ui.steps" })
public class TestRunner extends AbstractTestNGCucumberTests {
	
	  @AfterClass
	    public void tearDown() {
	        Driver.shutDown();
	    
	    }
	  
	  @BeforeClass
	  public static void setUp() {
	        Driver.initializeDriver();
	    
	    }

}
