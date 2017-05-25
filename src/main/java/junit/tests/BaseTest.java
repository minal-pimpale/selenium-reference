package junit.tests;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import selenium.utils.SeleniumWebDriver;

//@Listeners(junit.tests.EmailableReporter2.class) 
public class BaseTest {

	protected final static String  baseServiceurl = "http://test.dealvector.com/";
	
/*	@Before
	public void Initialize() {
		SeleniumWebDriver.InitializeDriver();
	}
	
//	@After
	public void Finalize() {
		SeleniumWebDriver.CloseDriver();
	}
*/
	
	@BeforeSuite
		public void Initialize() {
		
		SeleniumWebDriver.InitializeDriver();
	}
	
	@AfterSuite
	public void Finalize() {
		
		SeleniumWebDriver.CloseDriver();
	}

}
