package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.LandingPageWebElement;

public class AdminOperations {
	
	public void validateCorporateValidationRequests() throws InterruptedException
	{
		 WebDriver webdriver = SeleniumWebDriver.Instance();
		 
		 AdminPageObject.goToAdminAccount();
		 AdminPageObject.goToCorpValidationReq();
		
		 SeleniumHelper.WaitForPageLoad(2000);
		 SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.approve_user);
		 webdriver.findElement(By.xpath(LandingPageWebElement.approve_user)).click();
		 
		 Thread.sleep(5000);
		 
//		 WebDriverWait wait = new WebDriverWait(webdriver, 5);
//       wait.until(ExpectedConditions.alertIsPresent());
//	
//		 Alert alert = webdriver.switchTo().alert();
//		 success_message = alert.getText();
//		 System.out.println(success_message);
		 
		 SeleniumWebDriver.CloseDriver();
	}

}
