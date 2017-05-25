package junit.tests;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.pageobject.AdminPageObject;
import selenium.pageobject.TabAgentAdminModuleOperations;
import selenium.utils.SeleniumWebDriver;

public class TabAgentAdminModule {
	
	public TabAgentAdminModuleOperations operationsobj ;
	
	public TabAgentAdminModule ()
	{
		this.operationsobj = new TabAgentAdminModuleOperations();
		
	}
//	@Test
	public void CreateElection() throws InterruptedException{
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String Company_Name = "Alphabet";
		String Company_Account_Name = "Alphabet Company Account";
		int company_id = 1 ; 
		int company_account_id = 1; 
		int issuer_id = 1;
		String Tabulation_Agent = "issuer@demo.com";
		String Election_Name = "BNY Augsta Election";
		String deadline = "2016-08-11";
		
		AdminPageObject.goToAdminAccount();
		AdminPageObject.goToTabAgent();
		
		operationsobj.AddCompany(Company_Name);
		operationsobj.AddCompanyAccount(Company_Account_Name,company_id );
		operationsobj.AddTabulationAgent(company_account_id,Tabulation_Agent);
		operationsobj.CreateElection(Election_Name,company_account_id,issuer_id,deadline);
		webdriver.close();
		
		
	}

}
