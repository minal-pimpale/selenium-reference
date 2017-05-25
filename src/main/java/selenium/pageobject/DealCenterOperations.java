package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.DealCenterWebElement;

public class DealCenterOperations {
	
	public DealCenterWebElement dealCenterWebElementObj;

	public DealCenterOperations()
	{
		this.dealCenterWebElementObj = new DealCenterWebElement();
	}
	public void SearchDeal(String local_ticker) throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String ticker = local_ticker;
		String search_deals_btn_xpath = this.dealCenterWebElementObj.getSearch_Deals_BUTTON();
		String add_searchbox_xpath = this.dealCenterWebElementObj.getADDDEAL_SEARCH_BOX();
		String search_button_xpath = this.dealCenterWebElementObj.getSEARCH_BUTTON();
		
		webdriver.navigate().refresh();
		SeleniumHelper.WaitForPresenceOfElementByXPath(search_deals_btn_xpath);                      //click on Add button on deal center page
		webdriver.findElement(By.xpath(search_deals_btn_xpath)).click();	
		SeleniumHelper.WaitForPresenceOfElementByXPath(add_searchbox_xpath);                // enter ticker in search box 
		webdriver.findElement(By.xpath(add_searchbox_xpath)).sendKeys(ticker);
		webdriver.findElement(By.xpath(search_button_xpath)).click();                       // click on search button
		
	}
	
	public void AddDeal(int deal_role) throws InterruptedException{
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		
		String select_deal_xpath = this.dealCenterWebElementObj.getSELECT_DEAL_CHKBOX();
		String submit_btn_xpath = this.dealCenterWebElementObj.getSUBMIT_BUTTON();
		String select_dropdown_deal_role = this.dealCenterWebElementObj.getSELECT_DEAL_ROLE();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(select_deal_xpath);      // select deal checkbox 
		webdriver.findElement(By.xpath(select_deal_xpath)).click(); 
		
		Select deal_role_dropdown = new Select(webdriver.findElement(By.xpath(select_dropdown_deal_role)));     //select deal role 
		deal_role_dropdown.selectByIndex(deal_role);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(submit_btn_xpath);      // add deal to user account 
		webdriver.findElement(By.xpath(submit_btn_xpath)).click();
		
	}
	
	public void AddDealwithSubRole(int deal_role,int deal_sub_role){
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		
		String select_deal_xpath = this.dealCenterWebElementObj.getSELECT_DEAL_CHKBOX();
		String submit_btn_xpath = this.dealCenterWebElementObj.getSUBMIT_BUTTON();
		String select_dropdown_deal_role = this.dealCenterWebElementObj.getSELECT_DEAL_ROLE();
		String select_dropdown_deal_sub_role = this.dealCenterWebElementObj.getSELECT_DEAL_SUB_ROLE();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(select_deal_xpath);      // select deal checkbox 
		webdriver.findElement(By.xpath(select_deal_xpath)).click(); 
		
		Select deal_role_dropdown = new Select(webdriver.findElement(By.xpath(select_dropdown_deal_role)));     //select deal role 
		deal_role_dropdown.selectByIndex(deal_role);
		
		Select deal_sub_role_dropdpown = new Select (webdriver.findElement(By.xpath(select_dropdown_deal_sub_role))); //select deal sub role 
		deal_sub_role_dropdpown.selectByIndex(deal_sub_role);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(submit_btn_xpath);      // add deal to user account 
		webdriver.findElement(By.xpath(submit_btn_xpath)).click();
		
		
	}
	
	public void ExpandSeries(String series_path)
	{		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(series_path);
 		webdriver.findElement(By.xpath(series_path)).click();           // click on expand series
	}
	
	public String GetDealName(String deal_xpath)
	{
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(deal_xpath);
		String deal_name = webdriver.findElement(By.xpath(deal_xpath)).getText();
		return deal_name; 
	}
	
	public String GetRole(String role_xpath)
	{
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(role_xpath);
		String role = webdriver.findElement(By.xpath(role_xpath)).getText();
		return role; 
	}
	
	public String GetDealRole()
	{	
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(this.dealCenterWebElementObj.getEDIT_DEAL_ROLE());
 		Select dealroledropdown = new Select(webdriver.findElement(By.xpath(this.dealCenterWebElementObj.getEDIT_DEAL_ROLE()))); 
 		String dealrole = dealroledropdown.getFirstSelectedOption().getText();
 		return dealrole;
		
	}

	public String GetDealSubRole()
	{
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(this.dealCenterWebElementObj.getEDIT_DEAL_SUB_ROLE());
 		Select subroledropdown = new Select (webdriver.findElement(By.xpath(this.dealCenterWebElementObj.getEDIT_DEAL_SUB_ROLE())));
 		String dealsubrole = subroledropdown.getFirstSelectedOption().getText();
 		return dealsubrole;
	}
	
	public void EditDealRole(String Edit_link_xpath)
	{
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(Edit_link_xpath); 
		webdriver.findElement(By.xpath(Edit_link_xpath)).click(); 
	}
}
