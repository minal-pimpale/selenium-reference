package junit.tests;
import org.testng.annotations.Test;

import WebElement.ProfileWizardWebElement;
import junit.framework.Assert;
import selenium.pageobject.ProfileWizardPageObject;
import selenium.pageobject.DealCenterPageObject;
import selenium.pageobject.ProfileWizardOperations;
import selenium.utils.SeleniumWebDriver;

public class ProfileWizard{
	
	
	private ProfileWizardPageObject ProfileWizardObj;
	private DealCenterPageObject DealCenterPageObj;
	private ProfileWizardOperations ProfileWizardOperationsObj;
	
	
	ProfileWizard()
	{
		this.ProfileWizardObj = new ProfileWizardPageObject();
		this.DealCenterPageObj = new DealCenterPageObject();
		this.ProfileWizardOperationsObj = new ProfileWizardOperations();
	}
	
	@Test(priority=3)
	public void verifyWizardFlow_NavientRegSource() throws InterruptedException
	{	
		String username = "abc17@capital.com";
		String password = "aaa.111";
		String email_id = "abc17@capital.com"; 
		
		this.DealCenterPageObj.gotoUserAccount(username,password);
		Assert.assertEquals("Welcome To Navient's InvestorLink_abc17 user_abc_Individual Investor_4596875986797_Low",this.ProfileWizardObj.get_CompleteProfile());
		this.ProfileWizardOperationsObj.gotoNext(ProfileWizardWebElement.next_button);
		Assert.assertEquals("Add Your Navient Deals_Alphabet 2014-1_1,000_Alphabet 2014-1 CL A2 (63938EAE4)_1,000_Low",this.ProfileWizardObj.AddDeals_Navient());
		DealCenterPageObject.goTOOverviewPage();
		Assert.assertEquals("Forwarded BWICs from: abc17@capital.com_Great",this.ProfileWizardObj.SetUpBondtalk(email_id,"Outlook"));
		this.ProfileWizardOperationsObj.gotoNext(ProfileWizardWebElement.bondtalk_next_button);
		Assert.assertEquals("You're in! Let's get started_Great",this.ProfileWizardObj.ReferColleague());
		SeleniumWebDriver.CloseDriver();
	}
	
	@Test(priority=2)
	public  void verifyWizardFlow_NelnetRegSource() throws InterruptedException
	{
		String username = "user1@nelnet.com";
		String email_id = "user1@nelnet.com";
		String password = "minal@123";
		this.DealCenterPageObj.gotoUserAccount(username,password);
		Assert.assertEquals("Welcome To Nelnet's InvestorLink_user1 nelnet_nelnet_Institutional Investor_1234567890_Low",this.ProfileWizardObj.get_CompleteProfile());
		this.ProfileWizardOperationsObj.gotoNext(ProfileWizardWebElement.next_button);
		Assert.assertEquals("Add Your Nelnet Deals_Alphabet 2014-1_1,000_Good",this.ProfileWizardObj.AddDeals_Nelnet());
		DealCenterPageObject.goTOOverviewPage();
		Assert.assertEquals("Forwarded BWICs from: user1@nelnet.com_Great",this.ProfileWizardObj.SetUpBondtalk(email_id,"Outlook"));
		this.ProfileWizardOperationsObj.gotoNext(ProfileWizardWebElement.bondtalk_next_button);
		Assert.assertEquals("You're in! Let's get started_Great",this.ProfileWizardObj.ReferColleague());
		SeleniumWebDriver.CloseDriver();
	}
	
	@Test(priority=1)
	public void verifyWizardFlow_RegularUser() throws InterruptedException 
	{
		//Login Details 
		String username = "user1@test.com";
		String password = "minal@123";
		
		// Profile Details
		String full_name = "user1 test";
		String company_name = "test";
		int user_role_id = 4; 
		String ph_number = "1234567890";
		
		//Bondtalk Details
		String email_id = "user1@bloomberg.net";
		
		this.DealCenterPageObj.gotoUserAccount(username,password);
		Assert.assertEquals("Welcome To DealVector_user1 test_test_Advisor_1234567890_Low",this.ProfileWizardObj.set_CompleteProfile(full_name,company_name,user_role_id,ph_number));
		this.ProfileWizardOperationsObj.gotoNext(ProfileWizardWebElement.next_button);
		Assert.assertEquals("Add Your Deals_Alphabet 2014-1_Good",this.ProfileWizardObj.AddDeals_Regular());
		DealCenterPageObject.goTOOverviewPage();
		Assert.assertEquals("Forwarded BWICs from: user1@bloomberg.net_Great",this.ProfileWizardObj.SetUpBondtalk(email_id,"Bloomberg"));
		this.ProfileWizardOperationsObj.gotoNext(ProfileWizardWebElement.bondtalk_next_button);
		Assert.assertEquals("You're in! Let's get started_Great",this.ProfileWizardObj.ReferColleague());
		SeleniumWebDriver.CloseDriver();
	
	}
	

}
