package selenium.pageobject;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import WebElement.ProfileWizardWebElement;
import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import selenium.pageobject.ProfileWizardOperations;
import selenium.pageobject.DealCenterOperations;


public class ProfileWizardPageObject {

	private DealCenterOperations DealCenterOperationsObj;
	
	public ProfileWizardPageObject(){
		this.DealCenterOperationsObj = new DealCenterOperations();
	}
	public String get_CompleteProfile() {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
	
		String header_text = ProfileWizardOperations.VerifyText(ProfileWizardWebElement.complete_profile_tab_text);                     // verify text on complete profile tab for Navient user.
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.full_name);
		String full_name = webdriver.findElement(By.xpath(ProfileWizardWebElement.full_name)).getAttribute("value");
		System.out.println(full_name);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.company);
		String company = webdriver.findElement(By.xpath(ProfileWizardWebElement.company)).getAttribute("value");
		System.out.println(company);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.user_role);
		Select dealdropdown = new Select (webdriver.findElement(By.xpath(ProfileWizardWebElement.user_role)));
		String user_role = dealdropdown.getFirstSelectedOption().getText();
		System.out.println(user_role);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.phone_number);
		String ph_number = webdriver.findElement(By.xpath(ProfileWizardWebElement.phone_number)).getAttribute("value");
		System.out.println(ph_number);
		
		String profile_strength = ProfileWizardOperations.VerifyProfileStregth(ProfileWizardWebElement.profile_strength);
		
		String profile_details = header_text + "_" + full_name + "_" + company + "_" + user_role + "_" + ph_number + "_" + profile_strength;
		return profile_details;
		
	}
	
	public String set_CompleteProfile(String full_name,String company, int user_role, String ph_number) {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.full_name);
		webdriver.findElement(By.xpath(ProfileWizardWebElement.full_name)).sendKeys(full_name);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.company);
		webdriver.findElement(By.xpath(ProfileWizardWebElement.company)).sendKeys(company);
	
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.user_role);
		Select dealdropdown = new Select (webdriver.findElement(By.xpath(ProfileWizardWebElement.user_role)));
		dealdropdown.selectByIndex(user_role);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.phone_number);
		webdriver.findElement(By.xpath(ProfileWizardWebElement.phone_number)).sendKeys(ph_number);
		
		String profile_details = get_CompleteProfile();
		System.out.println(profile_details);
		return profile_details;

	
	}

	public String AddDeals_Navient() throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String ticker = "63938EAE4"; 
		String oface = "1000";
		String series_path = ProfileWizardWebElement.dealcenter_series_path;
		String header_text = ProfileWizardOperations.VerifyText(ProfileWizardWebElement.add_deals_tab_text);
		ProfileWizardOperations.AddDeals(oface);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.upload_more_deals); // to go to bulk upload 
		 webdriver.findElement(By.xpath(ProfileWizardWebElement.upload_more_deals)).click();
		 
		 
		ProfileWizardOperations.AddDeals_BulkUpload(ticker,oface);
		
		Thread.sleep(5000);
		String profile_strength = ProfileWizardOperations.VerifyProfileStregth(ProfileWizardWebElement.profile_strength);
		
		DealCenterPageObject.goToDealCentrePage();
		this.DealCenterOperationsObj.ExpandSeries(series_path);
		
		String deal1 = webdriver.findElement(By.xpath("//*[@id='deal_detail_347742']")).getText();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='deal_holding_amount_347742']/span[1]");
		String deal1_oface = webdriver.findElement(By.xpath("//*[@id='deal_holding_amount_347742']/span[1]")).getText();
		
		String deal2 = webdriver.findElement(By.xpath("//*[@id='deal_detail_347744']")).getText(); 
		String deal2_oface = webdriver.findElement(By.xpath("//*[@id='deal_holding_amount_347744']/span[1]")).getText();
		
		String deal_info = header_text + "_" + deal1 + "_" + deal1_oface + "_" + deal2 + "_" + deal2_oface + "_" + profile_strength;
		System.out.println(deal_info);
		return deal_info;
	}
	
	public String SetUpBondtalk(String email_id,String account_type) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Assert.assertEquals("Set Up BondTalk",ProfileWizardOperations.VerifyText(ProfileWizardWebElement.bondtalk_tab_text));
		webdriver.findElement(By.xpath(ProfileWizardWebElement.bwic_email_textbox)).sendKeys(email_id);
		webdriver.findElement(By.xpath(ProfileWizardWebElement.bwic_submit_button)).click();
		if (account_type == "Outlook")
		{
			Assert.assertEquals("Outlook instructions",ProfileWizardOperations.VerifyText(ProfileWizardWebElement.outlook_instructions));
		}
		else
		{
			Assert.assertEquals("Bloomberg instructions",ProfileWizardOperations.VerifyText(ProfileWizardWebElement.outlook_instructions));
		}
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.outlook_next_button);
		webdriver.findElement(By.xpath(ProfileWizardWebElement.outlook_next_button)).click();
		Assert.assertEquals("Congratulations!",ProfileWizardOperations.VerifyText(ProfileWizardWebElement.bondtalk_congratulations_text));
		
		Thread.sleep(5000);
		String profile_strength = ProfileWizardOperations.VerifyProfileStregth(ProfileWizardWebElement.profile_strength);
		
		String bontalk_success= ProfileWizardOperations.VerifyText(ProfileWizardWebElement.bondtalk_success_text) + "_" + profile_strength;
		return bontalk_success;
	}
	
	
	public String ReferColleague() throws InterruptedException {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Assert.assertEquals("Refer Colleagues",ProfileWizardOperations.VerifyText(ProfileWizardWebElement.refer_colleague_text));
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.open_invitation_button);
		webdriver.findElement(By.xpath(ProfileWizardWebElement.open_invitation_button)).click();
		
		webdriver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL +"\t");
		
		Thread.sleep(3000);
		String profile_strength = ProfileWizardOperations.VerifyProfileStregth(ProfileWizardWebElement.profile_strength);
		
		webdriver.findElement(By.xpath(ProfileWizardWebElement.finish_button)).click();
		
		
		String success_text = ProfileWizardOperations.VerifyText(ProfileWizardWebElement.final_screen_text) + "_" + profile_strength;	
		return success_text;
	}
	public String AddDeals_Nelnet() throws InterruptedException {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String ticker = "63938EAE4"; 
		String oface = "1000";
		String series_path = ProfileWizardWebElement.dealcenter_series_path_nelnet;
		String header_text = ProfileWizardOperations.VerifyText(ProfileWizardWebElement.add_deals_tab_text);
		
		ProfileWizardOperations.AddDeals_BulkUpload(ticker,oface);
		Thread.sleep(3000);
		String profile_strength = ProfileWizardOperations.VerifyProfileStregth(ProfileWizardWebElement.profile_strength);
		
		DealCenterPageObject.goToDealCentrePage();
		this.DealCenterOperationsObj.ExpandSeries(series_path);
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='deal_detail_347744']");
		String deal1 = webdriver.findElement(By.xpath("//*[@id='deal_detail_347744']")).getText();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='deal_holding_amount_347744']/span[1]");
		String deal1_oface = webdriver.findElement(By.xpath(("//*[@id='deal_holding_amount_347744']/span[1]"))).getText();
	
		
		String deal_info = header_text + "_" + deal1 + "_" + deal1_oface + "_" + profile_strength;
		System.out.println(deal_info);
		return deal_info;
		
	}
	public String AddDeals_Regular() throws InterruptedException {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		
		String ticker = "63938EAE4"; 
		int deal_role = 4; 
		String series_path = ProfileWizardWebElement.dealcenter_series_path_nelnet;
		String header_text = ProfileWizardOperations.VerifyText(ProfileWizardWebElement.add_deals_tab_text);
		
		ProfileWizardOperations.AddDeals_BulkUpload_Regular(ticker,deal_role);
		Thread.sleep(3000);
		String profile_strength = ProfileWizardOperations.VerifyProfileStregth(ProfileWizardWebElement.profile_strength);
		DealCenterPageObject.goToDealCentrePage();
		this.DealCenterOperationsObj.ExpandSeries(series_path);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='deal_detail_347744']");
		String deal1 = webdriver.findElement(By.xpath("//*[@id='deal_detail_347744']")).getText();
		
		String deal_info = header_text + "_" + deal1 + "_" + profile_strength ;
		System.out.println(deal_info);
		return deal_info;
	}
	

}
