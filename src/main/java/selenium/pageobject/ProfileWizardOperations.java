package selenium.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import WebElement.ProfileWizardWebElement;
import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;

public class ProfileWizardOperations {

	public void gotoNext(String next_button_xpath) {
		// TODO Auto-generated method stub
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(next_button_xpath);
		webdriver.findElement(By.xpath(next_button_xpath)).click();
		
	}

	public static void AddDeals(String oface) throws InterruptedException {
		// TODO Auto-generated method stub
		 WebDriver webdriver = SeleniumWebDriver.Instance();
		 SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.expand_vintage);
		 webdriver.findElement(By.xpath(ProfileWizardWebElement.expand_vintage)).click();
		 SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.expand_series);
		 webdriver.findElement(By.xpath(ProfileWizardWebElement.expand_series)).click();
		 SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.select_deal);
		 webdriver.findElement(By.xpath(ProfileWizardWebElement.select_deal)).click();
		 webdriver.findElement(By.xpath(ProfileWizardWebElement.oface_value)).sendKeys(oface);
		 Thread.sleep(3000);
		 SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.add_deal_button);
		 webdriver.findElement(By.xpath(ProfileWizardWebElement.add_deal_button)).click();
		 Assert.assertEquals("Congratulations!", VerifyText(ProfileWizardWebElement.Congratulations_text));
		 System.out.println("deals added successfully");
		 
		 
		
		 
		
	}
	
	public static void AddDeals_BulkUpload(String ticker,String oface)
	{
		 WebDriver webdriver = SeleniumWebDriver.Instance();
		 SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.bulk_upload);
		 webdriver.findElement(By.xpath(ProfileWizardWebElement.bulk_upload)).click();
		 SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.ticker_bulk_upload);
		 Actions action = new Actions(webdriver);
		 WebElement ticker_textbox = webdriver.findElement(By.xpath(ProfileWizardWebElement.ticker_bulk_upload));
		 action.moveToElement(ticker_textbox).click().sendKeys(ticker).build().perform();
		 
		 WebElement oface_textbox = webdriver.findElement(By.xpath(ProfileWizardWebElement.oface_bulk_upload));
		 action.moveToElement(oface_textbox).click().sendKeys(oface).build().perform();
		 webdriver.findElement(By.xpath(ProfileWizardWebElement.add_deal_button)).click();
		 Assert.assertEquals("Congratulations!", VerifyText(ProfileWizardWebElement.Congratulations_text));
		 System.out.println("bulk upload deal added successfully");
		
	}

	public static String VerifyText(String xpath) {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(xpath);
		String text = webdriver.findElement(By.xpath(xpath)).getText();
		System.out.println(text);
		return text;
	}

	public static void AddDeals_BulkUpload_Regular(String ticker, int deal_role) {
	
		WebDriver webdriver = SeleniumWebDriver.Instance();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.deal_role_dropdown);
		Select deal_role_dropdown = new Select(webdriver.findElement(By.xpath(ProfileWizardWebElement.deal_role_dropdown)));
		deal_role_dropdown.selectByIndex(deal_role);
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ProfileWizardWebElement.bulk_upload_textbox);
		Actions action = new Actions(webdriver);
		action.moveToElement(webdriver.findElement(By.xpath(ProfileWizardWebElement.bulk_upload_textbox))).click().sendKeys(ticker).build().perform();
		
		webdriver.findElement(By.xpath(ProfileWizardWebElement.deal_submit_button)).click();
		Assert.assertEquals("Congratulations!", VerifyText(ProfileWizardWebElement.Congratulations_text));
	}

	public static String VerifyProfileStregth(String profile_strength_xpath) {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(profile_strength_xpath);
		String profile_strength = webdriver.findElement(By.xpath(profile_strength_xpath)).getText();
		System.out.println(profile_strength);
		return profile_strength;
	}

}
