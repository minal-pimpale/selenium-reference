package selenium.pageobject;

import java.sql.Savepoint;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.BondTalkWebElement;
import WebElement.MessageCenterWebElement;

public class BondTalkOperations {

	public static void clickOnDownloadLink() throws InterruptedException{
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DOWNLOAD_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.DOWNLOAD_LINK)).click();
		Thread.sleep(2000);
	}
	
	public static void clickOnClassSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CLASS_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CLASS_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountClassSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CLASS_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CLASS_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
	
	public static void clickOnDealSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MYDEAL_RELDEAL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.MYDEAL_RELDEAL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountDealSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MYDEAL_RELDEAL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.MYDEAL_RELDEAL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnDealWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MYDEAL_RELDEAL_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.MYDEAL_RELDEAL_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountDealWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MYDEAL_RELDEAL_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.MYDEAL_RELDEAL_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
	
	public static void clickOnCurrencySsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURRENCY_USD_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CURRENCY_USD_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCurrencySsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURRENCY_USD_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CURRENCY_USD_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnCurrencyWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURRENCY_USD_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CURRENCY_USD_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCurrencyWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURRENCY_USD_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CURRENCY_USD_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
	
	public static void clickOnOfaceSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OFACE_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountOfaceSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OFACE_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnOfaceWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OFACE_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountOfaceWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OFACE_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
	
	public static void clickOnCfaceSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CFACE_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCfaceSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CFACE_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnCfaceWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CFACE_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCfaceWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CFACE_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
	
	public static void clickOnVintageSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.VINTAGE_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountVintageSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.VINTAGE_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnVintageWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.VINTAGE_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountVintageWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.VINTAGE_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
	
	public static void clickOnOrigRatingSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ORIG_RATING_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountOrigRatingSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ORIG_RATING_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnOrigRatingWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ORIG_RATING_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountOrigRatingWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ORIG_RATING_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
	
	public static void clickOnCurrRatingSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURR_RATING_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCurrRatingSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURR_RATING_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnCurrRatingWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURR_RATING_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCurrRatingWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURR_RATING_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
		
	public static void clickOnManagerSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MANAGER_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.MANAGER_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountManagerSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MANAGER_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.MANAGER_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnManagerWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MANAGER_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.MANAGER_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountManagerWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MANAGER_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.MANAGER_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
	
	public static void clickOnCollatSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.COLLAT_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCollatSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.COLLAT_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnCollatWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.COLLAT_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCollatWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.COLLAT_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
	
	public static void clickOnDq60SsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DQ60_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountDq60SsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DQ60_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnDq60WoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DQ60_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountDq60WoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DQ60_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}
		
	public static void clickOnCdrSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CDR_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCdrSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CDR_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CDR_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnCdrWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CDR_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCdrWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CDR_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CDR_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnCprSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CPR_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCprSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CPR_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CPR_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnCprWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CPR_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountCprWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CPR_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.CPR_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnWalSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WAL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountWalSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WAL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.WAL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void clickOnWalWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WAL_WO_NULL_SSTAB_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_WO_NULL_SSTAB_LINK)).click();
		Thread.sleep(1500);
	}
	
	public static String getCountWalWoNullSsTabLink() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WAL_WO_NULL_SSTAB_LINK_COUNT);
		String classSsTabCount = webdriver.findElement(By.xpath(BondTalkWebElement.WAL_WO_NULL_SSTAB_LINK_COUNT)).getText();
		return classSsTabCount;
	}

	public static void applyPSTTimeZone() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.BONDTALK_TIMEZONE_DROPDOWN);
		webdriver.findElement(By.xpath(BondTalkWebElement.BONDTALK_TIMEZONE_DROPDOWN)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.PST_TIMEZONE);
		webdriver.findElement(By.xpath(BondTalkWebElement.PST_TIMEZONE)).click();
		System.out.println("Applying PST Time Zone ");
		Thread.sleep(7000);
		
	}

	public static String getAuctionEventTimeStamp() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.AUCTION_EVENT_TIMESTAMP);
		String AuctionEventTimeStamp = webdriver.findElement(By.xpath(BondTalkWebElement.AUCTION_EVENT_TIMESTAMP)).getText();
		System.out.println("Auction Event time stamp is =  " +  AuctionEventTimeStamp);
		return AuctionEventTimeStamp;
	}

	public static void applyESTTimeZone() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.BONDTALK_TIMEZONE_DROPDOWN);
		webdriver.findElement(By.xpath(BondTalkWebElement.BONDTALK_TIMEZONE_DROPDOWN)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.EST_TIMEZONE);
		webdriver.findElement(By.xpath(BondTalkWebElement.EST_TIMEZONE)).click();
		System.out.println("Applying EST Time Zone ");
		Thread.sleep(7000);
		
	}

	public static void applyGMTTimeZone() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.BONDTALK_TIMEZONE_DROPDOWN);
		webdriver.findElement(By.xpath(BondTalkWebElement.BONDTALK_TIMEZONE_DROPDOWN)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.GMT_TIMEZONE);
		webdriver.findElement(By.xpath(BondTalkWebElement.GMT_TIMEZONE)).click();
		System.out.println("Applying GMT Time Zone ");
		Thread.sleep(7000);
		
	}

}
