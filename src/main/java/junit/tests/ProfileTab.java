package junit.tests;

import org.junit.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium.pageobject.AdminOperations;
import selenium.pageobject.ProfileTabOperations;

public class ProfileTab {
	
	private LoginTest LoginTestObj; 
	private ProfileTabOperations ProfileTabOperationsObj; 
	private AdminOperations AdminOperationsObj; 
	
	ProfileTab()
	{
		this.LoginTestObj = new LoginTest(); 
		this.ProfileTabOperationsObj = new ProfileTabOperations(); 
		this.AdminOperationsObj = new AdminOperations(); 
	}
	

	@Test
	public void verifyValidationStatus() throws InterruptedException
	{
		String username = "u1@navient.com"; 
		String password = "aaa.111"; 
		//validation status before aprroval from admin
		
		LoginTestObj.login(username, password,"Homepage"); 
		Assert.assertEquals("Status: Pending",ProfileTabOperationsObj.VerifyValidationStatus());
		
		
		AdminOperationsObj.validateCorporateValidationRequests();
		
		//validation status after aprroval from admin
		LoginTestObj.login(username, password,"Homepage"); 
		Assert.assertEquals("Status: Validated",ProfileTabOperationsObj.VerifyValidationStatus());
		
		
	}
}
