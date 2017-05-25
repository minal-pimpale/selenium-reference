package selenium.pageobject;

import java.util.ArrayList;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;


import WebElement.LandingPageWebElement;
import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import selenium.pageobject.BasePageObject;
import selenium.pageobject.OverviewPageOperations;

public class RegistrationPageObject {
	
		private LandingPageWebElement LandingPageWebElementObj;
		private OverviewPageOperations OverviewPageOperationsObj; 
	
		public RegistrationPageObject()
		{
			this.LandingPageWebElementObj = new LandingPageWebElement();
			this.OverviewPageOperationsObj = new OverviewPageOperations(); 
			
		}
		
		public String Register(String username,String password)
		{
			WebDriver webdriver = SeleniumWebDriver.Instance();
			SeleniumHelper.WaitForPresenceOfElementByXPath(this.LandingPageWebElementObj.UsernameTextbox);
			webdriver.findElement(By.xpath(this.LandingPageWebElementObj.UsernameTextbox)).sendKeys(username);
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(this.LandingPageWebElementObj.PasswordTextbox);
			webdriver.findElement(By.xpath(this.LandingPageWebElementObj.PasswordTextbox)).sendKeys(password);
			if(username != "user1@botoptions.com")
			{
				webdriver.findElement(By.xpath(this.LandingPageWebElementObj.RegisterButton + "/input[7]")).click();
			}
			else
			{
				webdriver.findElement(By.xpath(this.LandingPageWebElementObj.RegisterButton + "/button")).click();
				
			}
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.complete_profile_text);
			String registration_success_text = webdriver.findElement(By.xpath(LandingPageWebElement.complete_profile_text)).getText();
			return registration_success_text;
			
		}
		
		//in case of registration from Follow CLO Manager landing page 
		public String Register(String username,String password,String manager)
		{
			WebDriver webdriver = SeleniumWebDriver.Instance();
			SeleniumHelper.WaitForPresenceOfElementByXPath(this.LandingPageWebElementObj.UsernameTextbox);
			webdriver.findElement(By.xpath(this.LandingPageWebElementObj.UsernameTextbox)).sendKeys(username);
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(this.LandingPageWebElementObj.PasswordTextbox);
			webdriver.findElement(By.xpath(this.LandingPageWebElementObj.PasswordTextbox)).sendKeys(password);
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(this.LandingPageWebElementObj.manager);
			webdriver.findElement(By.xpath(this.LandingPageWebElementObj.manager)).click();
			
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(this.LandingPageWebElementObj.Follow_CLO_RegisterButton);
			Actions a = new Actions(webdriver);
			a.moveToElement(webdriver.findElement(By.xpath(this.LandingPageWebElementObj.Follow_CLO_RegisterButton))).doubleClick().build().perform();;
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.complete_profile_text);
			String registration_success_text = webdriver.findElement(By.xpath(LandingPageWebElement.complete_profile_text)).getText();
			return registration_success_text;
	
			
		}
		public void ValidateEmailAddress() throws InterruptedException {
			
			// TODO Auto-generated method stub
			LoginPage.Goto(BasePageObject.rabbit_mq_cron); //might have to 
			LoginPage.Goto(BasePageObject.scan_mail_log);
			
			WebDriver webdriver = SeleniumWebDriver.Instance();
			SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.email_validation_mail);
			
			webdriver.findElement(By.xpath(LandingPageWebElement.email_validation_mail)).click();
			SeleniumHelper.WaitForPageLoad(100);
			
			ArrayList<String> tabs2 = new ArrayList<String> (webdriver.getWindowHandles());
		    webdriver.switchTo().window(tabs2.get(1));
			
		    Thread.sleep(2000);
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.email_validation_link);
			webdriver.findElement(By.xpath(LandingPageWebElement.email_validation_link)).click();
			
		}
		public String CompleteProfile(String module,String name, String company,int role, String phone_number )
		{
			
			String registration_details = ""; 
			
			this.OverviewPageOperationsObj.setWizardFullName(name);
			this.OverviewPageOperationsObj.setWizardCompany(company);
			this.OverviewPageOperationsObj.setWizardPrimaryRole(role);
			this.OverviewPageOperationsObj.setWizardPhoneNumber(phone_number);
			
			this.OverviewPageOperationsObj.clickNextOnCompleteProfile();
			if (module!= "Botoptions")
			{
					registration_details= this.getRegistrationSuccessText(); 
			}
			else 
			{
					registration_details= this.getQIBScreenText(); 
			}
	
			return registration_details;
		}
	
		private String getQIBScreenText() 
		{
			WebDriver webdriver = SeleniumWebDriver.Instance();
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.qib_screen_text_1);
			String qib_text_1 = webdriver.findElement(By.xpath(LandingPageWebElement.qib_screen_text_1)).getText();
			String qib_text_2 = webdriver.findElement(By.xpath(LandingPageWebElement.qib_screen_text_2)).getText();
			
			String qib_screen_text = qib_text_1 + "_" + qib_text_2; 
			
			return qib_screen_text;
		}
		
		public String getRegistrationSuccessText()
		{
			WebDriver webdriver = SeleniumWebDriver.Instance();
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.registration_success_text);
			String registration_success_text = webdriver.findElement(By.xpath(LandingPageWebElement.registration_success_text)).getText();
			String registered_user_email = webdriver.findElement(By.xpath(LandingPageWebElement.registered_user_email_address)).getText();
			
			String registration_details = registration_success_text + "_" + registered_user_email;		
			return registration_details;
		}
	
		public String selectQIBStatus(String qib_location)
		{ 
			WebDriver webdriver = SeleniumWebDriver.Instance();
			
			switch(qib_location)
			{
				case "usa":
					SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.qib_usa_loaction);
					webdriver.findElement(By.xpath(LandingPageWebElement.qib_usa_loaction)).click();
					
					webdriver.findElement(By.xpath(LandingPageWebElement.usa_location_condition_1)).click();
					webdriver.findElement(By.xpath(LandingPageWebElement.usa_location_condition_2)).click();
					webdriver.findElement(By.xpath(LandingPageWebElement.usa_location_condition_3)).click();
					
					webdriver.findElement(By.xpath(LandingPageWebElement.qib_next_button)).click();
					break; 
					
				case "EU":
					
				case "ROW":
					
			}
			
			String registration_details = this.getRegistrationSuccessText(); 
			return registration_details ; 
		}


}
