package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.TabAgentAdminWebElement;

public class TabAgentAdminModuleOperations {
	
	
	public TabAgentAdminWebElement tabagentadminelementobj; 
	
	public TabAgentAdminModuleOperations()
	{
		
		this.tabagentadminelementobj = new TabAgentAdminWebElement();
	}

	public void AddCompany(String company_Name) {
		// TODO Auto-generated method stub
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String company_button_xpath = tabagentadminelementobj.getCompany_button();
		String company_input_box_xpath = tabagentadminelementobj.getCompany_input_box();
		String company_add_bttn_xpath = tabagentadminelementobj.getCompany_add_button();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(company_button_xpath);
		webdriver.findElement(By.xpath(company_button_xpath)).click(); 
        SeleniumHelper.WaitForPresenceOfElementByXPath(company_input_box_xpath);
		webdriver.findElement(By.xpath(company_input_box_xpath)).sendKeys(company_Name);
		SeleniumHelper.WaitForPresenceOfElementByXPath(company_button_xpath);
		webdriver.findElement(By.xpath(company_add_bttn_xpath)).click();;
		
		
		
	}
	
	public void AddCompanyAccount(String company_Account_Name, int company_id) {
		// TODO Auto-generated method stub
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String company_account_bttn_xpath = tabagentadminelementobj.getCompany_account_button();
		String company_account_input_box_xpath = tabagentadminelementobj.getCompany_account_input_box();
		String company_dropdown_xpath = tabagentadminelementobj.getCompany_dropdown();
		String company_accnt_add_bttn_xpath = tabagentadminelementobj.getCompany_account_add_button();
		
		webdriver.navigate().refresh();
		SeleniumHelper.WaitForPresenceOfElementByXPath(company_account_bttn_xpath);
		System.out.println(company_account_bttn_xpath);
		webdriver.findElement(By.xpath(company_account_bttn_xpath)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(company_account_input_box_xpath);
		System.out.println(company_account_input_box_xpath);
		webdriver.findElement(By.xpath(company_account_input_box_xpath)).sendKeys(company_Account_Name);
		Select company_dropdown = new Select(webdriver.findElement(By.xpath(company_dropdown_xpath)));
		company_dropdown.selectByIndex(company_id);
		SeleniumHelper.WaitForPresenceOfElementByXPath(company_accnt_add_bttn_xpath);
		webdriver.findElement(By.xpath(company_accnt_add_bttn_xpath)).click();
	}


	public void AddTabulationAgent(int company_account_id,String tabulation_Agent) throws InterruptedException {
		// TODO Auto-generated method stub
		String tabulation_agent_bttn_xpath = tabagentadminelementobj.getTabulation_agent_button();
		String company_account_dropdown_xpath = tabagentadminelementobj.getCompany_account_dropdown();
		String user_textbox_xpath = tabagentadminelementobj.getUser_dropdown();
		String add_button = tabagentadminelementobj.getTabulation_agent_add_button();
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.navigate().refresh();
		SeleniumHelper.WaitForPresenceOfElementByXPath(tabulation_agent_bttn_xpath);
		webdriver.findElement(By.xpath(tabulation_agent_bttn_xpath)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(company_account_dropdown_xpath);
		Select company_account_dropdpwn = new Select(webdriver.findElement(By.xpath(company_account_dropdown_xpath)));
		company_account_dropdpwn.selectByIndex(company_account_id);
		SeleniumHelper.WaitForPresenceOfElementByXPath(user_textbox_xpath);
		System.out.println(user_textbox_xpath);
		webdriver.findElement(By.xpath(user_textbox_xpath)).sendKeys(tabulation_Agent);
		Thread.sleep(2000);
		webdriver.findElement(By.xpath("//*[@id='ui-id-1']/li/*[1]")).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(add_button);
		webdriver.findElement(By.xpath(add_button)).click();
		
	}

	public void CreateElection(String election_Name, int company_account_id,
			int issuer_id, String deadline) throws InterruptedException 
	{
		String eletion_button_xpath = tabagentadminelementobj.getElection_button();
		String election_name_xpath = tabagentadminelementobj.getElection_name_textbox();
		String company_account_dropdown_xpath = tabagentadminelementobj.getElection_company_account_dropdown();
		String issuer_dropdown_xpath = tabagentadminelementobj.getElection_issuer_dropdown();
		String deadline_xpath = tabagentadminelementobj.getElection_deadline();
		String add_button = tabagentadminelementobj.getElection_add_button();
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.navigate().refresh();
		SeleniumHelper.WaitForPresenceOfElementByXPath(eletion_button_xpath);
		webdriver.findElement(By.xpath(eletion_button_xpath)).click();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(election_name_xpath);
		webdriver.findElement(By.xpath(election_name_xpath)).sendKeys(election_Name);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(company_account_dropdown_xpath);
		Select company_account_dropdown = new Select(webdriver.findElement(By.xpath(company_account_dropdown_xpath)));
		company_account_dropdown.selectByIndex(company_account_id);
		
		Select issuer_dropdown = new Select (webdriver.findElement(By.xpath(issuer_dropdown_xpath)));
		issuer_dropdown.selectByIndex(issuer_id);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(deadline_xpath);
		webdriver.findElement(By.xpath(deadline_xpath)).sendKeys(deadline);
		webdriver.findElement(By.xpath(election_name_xpath)).click();           // as not able to pick date from date picker ,clicking on election name again and then clicking on add.
		
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(add_button);
		webdriver.findElement(By.xpath(add_button)).click();
		
		
	}




}
