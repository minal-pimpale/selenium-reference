package junit.tests;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium.utils.SeleniumWebDriver;
//@Listeners(junit.tests.EmailableReporter2.class)
public class LandingPageLogin {
	
	private LoginTest LoginTestObj; 
	
	LandingPageLogin(){
		
		this.LoginTestObj = new LoginTest();
		
	}
	@Test(priority=1)
	public void NavientLogin()
	{
		String username = "u1@navient.com"; 
		String password = "aaa.111"; 
				
		Assert.assertEquals("Add Your Navient Deals",LoginTestObj.login(username, password,"Navient"));
		Reporter.log("Navient login succesful");
		SeleniumWebDriver.QuitDriver();
	}

	@Test(priority=2)
	public void NelnetLogin()
	{
		String username = "u1@navient.com"; 
		String password = "aaa.111"; 
				
		Assert.assertEquals("Add Your Nelnet Deals",LoginTestObj.login(username, password,"Nelnet"));
		Reporter.log("Nelnet login succesful");
		SeleniumWebDriver.QuitDriver();
	}
	
//	public void BotoptionsLogin()
//	{
//		String username = "user1@botoptions.com"; 
//		String password = "aaa.111"; 
//		
//		Assert.assertEquals("",LoginTestObj.login(username, password,"Botoptions"));
//		Reporter.log("Botoptions login succesful");
//		SeleniumWebDriver.QuitDriver();
//		
//	}
	
	public void BotoptionsLogin_ExistingUser_ProfileInfoCompleted()
	{
		
	}
	
	public void BotoptionsLogin_ExistingUser_ProfileInfoNotCompleted()
	{
		
	}



}
