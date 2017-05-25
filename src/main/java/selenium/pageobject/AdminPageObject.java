package selenium.pageobject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;

public class AdminPageObject {
	
	public static void goToAdminAccount(){
		System.out.println("Login to Admin Account");
		LoginPage.Goto();
		LoginPage.LoginAs("admin@dealvector.com").WithPassword("aaa.111").Login();
		Assert.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Admin Deal vector");
	}

	public static void goToSdcPage(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='exception_wrapper']/div[4]/table/tbody/tr[15]/td/a");
		webdriver.findElement(By.xpath("//*[@id='exception_wrapper']/div[4]/table/tbody/tr[15]/td/a")).click();
	}
	
	public static void createNewGroup(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/div/div/div/div/div[1]/div[1]/div/a");
		webdriver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/div[1]/div/a")).click();
	}
	


	public static void enterSdcName(String sdcName) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='sdc_name']");
		webdriver.findElement(By.xpath("//*[@id='sdc_name']")).sendKeys(sdcName);						// Entering SDC Name
		
	}

	public static void enterManagerName(String managerName) throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='sdc_man_name']");
		webdriver.findElement(By.xpath("//*[@id='sdc_man_name']")).sendKeys(managerName);						// Entering SDC manager Name
		Thread.sleep(2000);
		webdriver.findElement(By.className("ui-corner-all")).click();
	}

	public static void enterChildrenName(String childrenName) throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='sdc_members']");
		webdriver.findElement(By.xpath("//*[@id='sdc_members']")).sendKeys(childrenName);						// Entering SDC children Name
		Thread.sleep(3000);
		webdriver.findElement(By.xpath("//*[@id='ui-id-2']/li/*[1]")).click();
	}

	public static void enterLeadManagerName(String leadManagerName) throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='sdc_lead']");
		webdriver.findElement(By.xpath("//*[@id='sdc_lead']")).sendKeys(leadManagerName);						// Entering SDC Lead Name
		Thread.sleep(3000);
		webdriver.findElement(By.xpath("//*[@id='ui-id-3']/li/*[1]")).click();
	}

	public static void submitSDC() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='new_sdc_form']/p/button");
		webdriver.findElement(By.xpath("//*[@id='new_sdc_form']/p/button")).click();
		
	}

	public static String successText() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='update_sdc_form']/table[2]/tbody/tr[1]/th[1]");
		String successText= webdriver.findElement(By.xpath("//*[@id='update_sdc_form']/table[2]/tbody/tr[1]/th[1]")).getText();
		return successText;
		
	}

	public static void goToTabAgent() {
		// TODO Auto-generated method stub
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='exception_wrapper']/div[4]/table/tbody/tr[20]/td/a");
		webdriver.findElement(By.xpath("//*[@id='exception_wrapper']/div[4]/table/tbody/tr[20]/td/a")).click();
		System.out.println("tab agent");
	}
	
	public static void goToCorpValidationReq(){
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='exception_wrapper']/div[2]/table/tbody/tr[3]/td[1]/a");
		webdriver.findElement(By.xpath("//*[@id='exception_wrapper']/div[2]/table/tbody/tr[3]/td[1]/a")).click();
	}
}

