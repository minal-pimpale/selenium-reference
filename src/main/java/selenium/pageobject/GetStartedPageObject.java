package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;

public class GetStartedPageObject {

	public static String bulkUploadLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='bulkUploadTriggerLink']");
		webdriver.findElement(By.xpath("//*[@id='bulkUploadTriggerLink']")).click();						// Click on download template link on Navient get started page
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-1']/h3");
		String readOnlytext = webdriver.findElement(By.xpath("//*[@id='ui-id-1']/h3")).getText();			// Fetching "Read Only Access" text from info popup
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("/html/body/div[4]/div[1]/button/span[1]")).click();					// Closing popup
		System.out.println(readOnlytext + " Get Started Page");
		return readOnlytext;
		
	}
	
}
