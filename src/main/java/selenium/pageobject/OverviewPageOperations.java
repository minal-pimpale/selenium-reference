package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.LandingPageWebElement;

public class OverviewPageOperations {
	
	public void setWizardFullName(String name)
	{
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.full_name_text_box); 
		webdriver.findElement(By.xpath(LandingPageWebElement.full_name_text_box)).sendKeys(name);
	}
	
	public void setWizardCompany(String company)
	{
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.company); 
		webdriver.findElement(By.xpath(LandingPageWebElement.company)).sendKeys(company);
		
	}
	
	public void setWizardPrimaryRole(int primary_role)
	{
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		
		Select dropdown = new Select(webdriver.findElement(By.xpath(LandingPageWebElement.role_dropdown))); 
		dropdown.selectByIndex(primary_role);
		
	}
	
	public void setWizardPhoneNumber(String ph_number)
	{
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.phone_number); 
		webdriver.findElement(By.xpath(LandingPageWebElement.phone_number)).sendKeys(ph_number);
		
	}
	
	public void clickNextOnCompleteProfile()
	{
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.next_button); 
		webdriver.findElement(By.xpath(LandingPageWebElement.next_button)).click();
		
	}

}
