package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import WebElement.LandingPageWebElement;
import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;

public class LoginPage extends BasePageObject{

	public static void Goto(){
		SeleniumHelper.Navigate(baseurl);
	//	SeleniumHelper.Link("login_trigger").Click();
		//	Wait the page to load after login
		SeleniumHelper.WaitForPageLoad(100);		
	} 

	public static LoginCommand LoginAs(String userName){
		LoginCommand loginCmd = new LoginCommand(userName);
		return loginCmd;
	}
	
	public static boolean IsLoginSuccessful(){
		//get the hidden element
		return SeleniumHelper.InputText("appVersion").IsPresent();
	}
	
	public static void Goto(String url)
	{
		SeleniumHelper.Navigate(url);
		SeleniumHelper.WaitForPageLoad(100);	
		
	}
	public static String GotoLandingPage(String url,String module)
	{
		String Landing_page_details = null; 
		String landing_page_text = null; 
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		if (module == "Navient" || module == "Nelnet" || module == "Botoptions")
		{
			SeleniumHelper.Navigate(url);
			SeleniumHelper.WaitForPageLoad(100);	
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.header_text);
			String header_text = webdriver.findElement(By.xpath(LandingPageWebElement.header_text)).getText(); 
			
			if (module!= "Botoptions")
			{
				SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.landing_page_text);
				landing_page_text = webdriver.findElement(By.xpath(LandingPageWebElement.landing_page_text)).getText(); 
			}
			
			Landing_page_details = header_text + "_" + landing_page_text ;
				
		}  
		
		else
		{
			SeleniumHelper.Navigate(url);
			SeleniumHelper.WaitForPageLoad(100);	
			
			SeleniumHelper.WaitForPresenceOfElementByXPath(LandingPageWebElement.Follow_CLO_header_text);
			Landing_page_details = webdriver.findElement(By.xpath(LandingPageWebElement.Follow_CLO_header_text)).getText(); 
			
		}
		
		System.out.println(Landing_page_details);
		return Landing_page_details;
	}
	
}


