package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebElement.LandingPageWebElement;
import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;

public class RegistrationPageOperations {

	public static void gotoProfileTab() {
		// TODO Auto-generated method stub
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.dv_id_link);
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.xpath(LandingPageWebElement.dv_id_link)).click();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.profile_tab_link);
		webdriver.findElement(By.xpath(LandingPageWebElement.profile_tab_link)).click();
		
		
	}

}
