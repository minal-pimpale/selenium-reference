package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.LandingPageWebElement;

public class ProfileTabOperations {
	
	public String VerifyValidationStatus() throws InterruptedException {
		
		RegistrationPageOperations.gotoProfileTab();
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.profile_status);
		String profile_status = webdriver.findElement(By.xpath(LandingPageWebElement.profile_status)).getText();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.dv_id_link);
		webdriver.findElement(By.xpath(LandingPageWebElement.dv_id_link)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.Logout);
		webdriver.findElement(By.xpath(LandingPageWebElement.Logout)).click();
		
		return profile_status;
		
		
	}

}
