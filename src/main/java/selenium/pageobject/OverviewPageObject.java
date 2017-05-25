package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;

public class OverviewPageObject {
	
	public static void goToOverviewPage() {
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='gNav']/ul/li[2]/a/span");
		SeleniumHelper.Navigate("http://test.dealvector.com/overview");
		
	}
	
	public static String addDealRecentActivity() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='dealRecommendationContainer']/div/div/div[2]/div[3]/div/div[2]/div[1]/div/div/div[5]/div/div[1]");
		
		//"//*[@id='dealTableBody']/tr[1]/td/table/tbody/tr[1]/td[5]"
		
		Actions action = new Actions(webdriver);
		WebElement we = webdriver.findElement(By.xpath("//*[@id='dealRecommendationContainer']/div/div/div[2]/div[3]/div/div[2]/div[1]/div/div/div[5]/div/div[1]"));
		action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("//*[@id='dealRecommendationContainer']/div/div/div[2]/div[3]/div/div[2]/div[1]/div/div/div[5]/div/div[1]/button/b"))).click().build().perform(); // Click on Add Deal in "Recent Activity"
		
	
							
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-1']/h3");  
		String readOnlytext = webdriver.findElement(By.xpath("//*[@id='ui-id-1']/h3")).getText();			// Fetching "Read Only Access" text from info popup
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();					// Closing popup 
		System.out.println(readOnlytext + " Recent Activity Tab");
		return readOnlytext;
		
	}
	

	public static String addDealMostAffiliations() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='most_added']");  
		webdriver.findElement(By.xpath("//*[@id='most_added']")).click();															// Click on  "Most Affiliation Tab"
		
		Actions action = new Actions(webdriver);
		WebElement we = webdriver.findElement(By.xpath("//*[@id='dealTableBody']/tr[2]/td/table/tbody/tr[1]/td[5]"));
		action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("//*[@id='deal_follow_347747']"))).click().build().perform();   // Click on Add Deal in "Most Affiliation Tab"
		
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-1']/h3");  
		String readOnlytext = webdriver.findElement(By.xpath("//*[@id='ui-id-1']/h3")).getText();			// Fetching "Read Only Access" text from info popup
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();					// Closing popup 
		System.out.println(readOnlytext + " Most Affiliation Tab");
		return readOnlytext;
	}


	public static String addDealMarketSurveillance() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Thread.sleep(3000);  
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/div[1]/div[2]/div[2]/a");
		webdriver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/a")).click();						// Click on Add Deal in "Market Surveillance"
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-1']/h3");  
		String readOnlytext = webdriver.findElement(By.xpath("//*[@id='ui-id-1']/h3")).getText();			// Fetching "Read Only Access" text from info popup
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();					// Closing popup 
		System.out.println(readOnlytext + " Market Surveillance");
		return readOnlytext;
	}

	public static String addDealRecentActivityRecommended() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='dealTableBody']/tr[1]/td/table/tbody/tr[1]/td[5]");
		Actions action = new Actions(webdriver); 
		WebElement we = webdriver.findElement(By.xpath("//*[@id='dealTableBody']/tr[1]/td/table/tbody/tr[1]/td[5]"));
		action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("//*[@id='deal_follow_347745']"))).click().build().perform();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-1']/h3");  
		String readOnlytext = webdriver.findElement(By.xpath("//*[@id='ui-id-1']/h3")).getText();			// Fetching "Read Only Access" text from info popup
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();					// Closing popup 
		System.out.println(readOnlytext + " Recommended Recent Activity");
		return readOnlytext;
	}

	public static String addDealMostAffiliationsRecommended() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='most_added']");  
		webdriver.findElement(By.xpath("//*[@id='most_added']")).click();								// Click on  "Most Affiliation Tab"
		
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='dealTableBody']/tr[2]/td/table/tbody/tr[1]/td[5]");  
		Actions action = new Actions(webdriver);														
		WebElement we = webdriver.findElement(By.xpath("//*[@id='dealTableBody']/tr[2]/td/table/tbody/tr[1]/td[5]"));   
		action.moveToElement(we).moveToElement(webdriver.findElement(By.xpath("//*[@id='deal_follow_347748']"))).click().build().perform();     // hover and Click on Add Deal in "Recent Activity"
		
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-1']/h3");  
		String readOnlytext = webdriver.findElement(By.xpath("//*[@id='ui-id-1']/h3")).getText();			// Fetching "Read Only Access" text from info popup
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();					// Closing popup 
		System.out.println(readOnlytext + " Recommended Market Surveillance");
		return readOnlytext;
	}

}



