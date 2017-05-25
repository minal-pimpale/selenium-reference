package junit.tests;

import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import WebElement.LandingPageWebElement;
import selenium.pageobject.*;
import selenium.utils.SeleniumWebDriver;
//@Listeners(junit.tests.EmailableReporter2.class)
public class LandingPageRegistration extends BasePageObject {
	
	private RegistrationPageObject RegistrationPageObj;
	private LandingPageWebElement LandingPageWebElementObj;
	private LoginTest LoginTestObj;
	
	public LandingPageRegistration()
	{
		this.RegistrationPageObj = new RegistrationPageObject();
		this.LandingPageWebElementObj = new LandingPageWebElement();
		this.LoginTestObj = new LoginTest();
	}
	
       @Test(priority=1)
		public void NavientRegistration() throws InterruptedException
		{
			String username = "u1@navient.com";
			String password = "aaa.111";
			String name = "u1 navient"; 
			String company = "Navient"; 
			int role = 3; 
			String number = "112233445667"; 
			
			Assert.assertEquals("Navient_Navient urges Navient Investors to register to facilitate:",LoginPage.GotoLandingPage(BasePageObject.baseurl + "/navient","Navient"));
			Reporter.log("Navient Landing Page text verified");
			
			Assert.assertEquals("Welcome To Navient's InvestorLink",RegistrationPageObj.Register(username,password));
			Reporter.log("User registered successfully from Navient Landing Page");
			
			Assert.assertEquals("One more step_u1@navient.com",RegistrationPageObj.CompleteProfile("Navient",name,company,role,number));
			
			RegistrationPageObj.ValidateEmailAddress();
			Assert.assertTrue(LoginPage.IsLoginSuccessful());
			
			  
			SeleniumWebDriver.QuitDriver();
			
		}

     @Test(priority=2)
     public void NelnetRegistration() throws InterruptedException
     {
	       String username = "u1@nelnet.com";
	       String password = "aaa.111";
	       String name = "u1 nelnet"; 
	       String company = "Nelnet"; 
	       int role = 4; 
	       String number = "234567123"; 
	
	       	Assert.assertEquals("Nelnet_Nelnet urges Nelnet Investors to register to facilitate:",LoginPage.GotoLandingPage(BasePageObject.baseurl + "/nelnet","Nelnet"));
	       	Reporter.log("Nelnet Landing Page text verified");
	     
	        Assert.assertEquals("Welcome To Nelnet's InvestorLink",RegistrationPageObj.Register(username,password));
	        Reporter.log("User registered successfully from Nelnet Landing Page");
	        
	        Assert.assertEquals("One more step_u1@nelnet.com",RegistrationPageObj.CompleteProfile("Nelnet",name,company,role,number));
	     
	        RegistrationPageObj.ValidateEmailAddress();
			Assert.assertTrue(LoginPage.IsLoginSuccessful());
			
			  
			SeleniumWebDriver.QuitDriver();    
	       	
    }	
     
     @Test(priority=3)
     public void FollowCLOManagerRegistration() throws InterruptedException
    {
	     String username = "u1@followclo.com";
	     String password = "aaa.111";
	     String manager =  this.LandingPageWebElementObj.manager; 
	     
	     String name = "u1 followclo"; 
	     String company = "FollowCLO"; 
	     int role = 6; 
	     String number = "234567123";
	
	     Assert.assertEquals("Select the managers below to easily \"Follow\" all of their deals in your DealVector Deal Center. You will become eligible for notifications of activity related to any of those transactions.", LoginPage.GotoLandingPage(BasePageObject.baseurl + "/followclomanager","FollowCLOManager"));
	     Reporter.log("Follow CLO Manager Landing Page text verified");
	    
	     Assert.assertEquals("Welcome To DealVector",RegistrationPageObj.Register(username,password,manager));
	     Reporter.log("User registered successfully from Follow CLO Manager Landing Page");
	     
	     Assert.assertEquals("One more step_u1@followclo.com",RegistrationPageObj.CompleteProfile("FollowCLOManager",name,company,role,number));
	     
	     RegistrationPageObj.ValidateEmailAddress();
		 Assert.assertTrue(LoginPage.IsLoginSuccessful());
		 
		 DealCenterPageObject.goToDealCentrePage();
		 SeleniumWebDriver.QuitDriver();
			
		 //Assert.assertEquals("Status: Pending",RegistrationPageObj.VerifyValidationStatus());    
	  }
     
     @Test(priority=4)
     public void BotoptionsRegistration() throws InterruptedException
     {
    	 String username = "user1@botoptions.com"; 
    	 String password = "aaa.111";
    	 
    	 
    	 String name = "user1 botoptions"; 
    	 String company = "Botoptions";
    	 int role = 5; 
    	 String phone_number = "1222343423";
    	 String qib_location = "usa";
    	 
    	 Assert.assertEquals("BotOptions: New 3, 5, 7 year bond offering_null",LoginPage.GotoLandingPage(BasePageObject.baseurl + "/Botoptions","Botoptions"));
    	 Assert.assertEquals("Welcome To BotOptions Deal Room",RegistrationPageObj.Register(username, password));
    	 Assert.assertEquals("Please Answer the following_I am based in:",RegistrationPageObj.CompleteProfile("Botoptions", name, company, role, phone_number));
    	 Assert.assertEquals("One more step_user1@botoptions.com",RegistrationPageObj.selectQIBStatus(qib_location));
    	 
    	 RegistrationPageObj.ValidateEmailAddress();
 		 Assert.assertTrue(LoginPage.IsLoginSuccessful());
    	 
    	 SeleniumWebDriver.QuitDriver();
     }



}



