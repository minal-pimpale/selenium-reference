package junit.tests;




import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.pageobject.*;
import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.*; 

public class LoginTest extends BaseTest{

//	 @Test
	public void test_login_to_dealvector() {
				
		System.out.println("Login1 to Deal vector");
		LoginPage.Goto();
		LoginPage.LoginAs("member1@ship1.com").WithPassword("S@1lg@4r6").Login();
		Assert.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged1 on to Deal vector");
	}	
	
	public String login(String username,String password,String module)
	{
		String login_success_text = null; 
		switch(module)
		{	
			case "Navient" : 
				LoginPage.GotoLandingPage(BasePageObject.baseurl + "/navient",module);
				break; 
			
			case "Nelnet":
				LoginPage.GotoLandingPage(BasePageObject.baseurl + "/nelnet",module);
				break; 
				
			case "Botoptions" :
				LoginPage.GotoLandingPage(BasePageObject.baseurl + "/botoptions",module);
				break;
				
			default:
				LoginPage.Goto();
				LoginPage.LoginAs(username).WithPassword(password).Login();
				Assert.assertTrue(LoginPage.IsLoginSuccessful());
				System.out.println("Logged on to Deal vector");
				Assert.assertTrue(LoginPage.IsLoginSuccessful());
			
		}
							
		    LoginOperations.gotoLoginPage();
			
			//page will open in new tab so switch the tab 
			WebDriver webdriver = SeleniumWebDriver.Instance();
			
			LoginPage.LoginAs(username).WithPassword(password).Login();
			Assert.assertTrue(LoginPage.IsLoginSuccessful());
			
			// verify after logging from navient , it is showing navient specific data 
			SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.login_successful_text);
			login_success_text = webdriver.findElement(By.xpath(LandingPageWebElement.login_successful_text)).getText();
			
			return login_success_text;
	}
	
	
	
		
	}

