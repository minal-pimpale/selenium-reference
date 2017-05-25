package selenium.pageobject;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.*;

public class LoginOperations {
	
		public static void gotoLoginPage() {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(LoginWebElement.login_link); 
		webdriver.findElement(By.xpath(LoginWebElement.login_link)).click();
		
		//switch browser tabs 
		SeleniumHelper.WaitForPageLoad(3000);
		ArrayList<String> tabs2 = new ArrayList<String> (webdriver.getWindowHandles());
	    webdriver.switchTo().window(tabs2.get(1)); 
		
		
	}

}
