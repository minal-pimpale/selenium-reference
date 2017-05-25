package selenium.pageobject;

import java.awt.event.WindowFocusListener;
import java.sql.Savepoint;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.BondTalkWebElement;
import WebElement.MarketWebElement;
import WebElement.OfferWebElement;

public class MarketPageObject {
	
	public static void goToMarketTab() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.MARKET_TAB);
		webdriver.findElement(By.xpath(MarketWebElement.MARKET_TAB)).click();
		
	}

	public static void MarketEditColumn(String editColumnSource) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String editColumnSourceType = editColumnSource;
		if(editColumnSourceType == "FromHeader"){
			SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.EDIT_COLUMN_HEADER);
			webdriver.findElement(By.xpath(BondTalkWebElement.EDIT_COLUMN_HEADER)).click();
		}
		else{
			SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.EDIT_COLUMN_AT_TOP);
			webdriver.findElement(By.xpath(BondTalkWebElement.EDIT_COLUMN_AT_TOP)).click();
		}
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SELECT_ALL_COLUMN);
		webdriver.findElement(By.xpath(BondTalkWebElement.SELECT_ALL_COLUMN)).click();
		webdriver.findElement(By.xpath(MarketWebElement.SAVE_COLUMN)).click();
		
	}

	private static String getMarketFilterCount() {
		WebDriver webdriver = SeleniumWebDriver.Instance();      
		String marketFilterCount = webdriver.findElement(By.xpath(MarketWebElement.MARKET_FILTER_COUNT)).getText(); 
		System.out.println("Market Tab filter count is " + marketFilterCount);
		return marketFilterCount;
	}
	
	public static void testClassFilter() throws InterruptedException {
		applyClassFilter();
		String marketFilterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		Assert.assertEquals("51", marketFilterCount);
		
	}

	private static void applyClassFilter() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.CLASS_FILTER);            
		webdriver.findElement(By.xpath(MarketWebElement.CLASS_FILTER)).click();
		webdriver.findElement(By.xpath(MarketWebElement.CLASS_CMBS)).click(); 
		webdriver.findElement(By.xpath(MarketWebElement.CLASS_RMBS)).click(); 
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
		
	}

	public static void testDealFilter() throws InterruptedException {
		applyDealFilter();
		String marketFilterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		Assert.assertEquals("10", marketFilterCount);
		
	}

	private static void applyDealFilter() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.DEAL_NAME_FILTER);             
		webdriver.findElement(By.xpath(MarketWebElement.DEAL_NAME_FILTER)).click();
		webdriver.findElement(By.xpath(MarketWebElement.ANCHC_B1)).click();  
		webdriver.findElement(By.xpath(MarketWebElement.APID_D2)).click();  
		webdriver.findElement(By.xpath(MarketWebElement.ARES_E)).click(); 
		webdriver.findElement(By.xpath(MarketWebElement.ATCLO_B)).click(); 
		webdriver.findElement(By.xpath(MarketWebElement.BABSN_D1)).click(); 
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}

	public static void testNumericIdFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyNumericIdFilter(nullStatus);
		String filterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("10", filterCount);    
		}
		else{
			Assert.assertEquals("10", filterCount);		
		}
		
	}

	private static void applyNumericIdFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.NUMERIC_ID_FILTER);
		webdriver.findElement(By.xpath(MarketWebElement.NUMERIC_ID_FILTER)).click();                 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(MarketWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(MarketWebElement.CUSIP_03329KAG8)).click();  
		webdriver.findElement(By.xpath(MarketWebElement.CUSIP_04015FAC5)).click();  
		webdriver.findElement(By.xpath(MarketWebElement.CUSIP_04941GAC2)).click();  
		webdriver.findElement(By.xpath(MarketWebElement.CUSIP_05531WAC0)).click();  
		webdriver.findElement(By.xpath(MarketWebElement.CUSIP_05533DCM6)).click();  
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}

	public static void testCurrencyFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyCurrencyFilter(nullStatus);
		String filterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("48", filterCount);    
		}
		else{
			Assert.assertEquals("48", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyCurrencyFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.CURRENCY_FILTER);
		webdriver.findElement(By.xpath(MarketWebElement.CURRENCY_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(MarketWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(MarketWebElement.USD_CURRENCY)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}

	
	public static void testBidOfaceFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyBidOfaceFilter(nullStatus);
		String filterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("36", filterCount);    
		}
		else{
			Assert.assertEquals("39", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyBidOfaceFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.BID_OFACE_FILTER);
		webdriver.findElement(By.xpath(MarketWebElement.BID_OFACE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(MarketWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(MarketWebElement.BID_OFACE_1000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.BID_OFACE_5000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}

	public static void testOfferOfaceFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyOfferOfaceFilter(nullStatus);
		String filterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("36", filterCount);    
		}
		else{
			Assert.assertEquals("39", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyOfferOfaceFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.OFFER_OFACE_FILTER);
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_OFACE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(MarketWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_OFACE_1000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_OFACE_5000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}
	
	public static void testBidPriceFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyBidPriceFilter(nullStatus);
		String filterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("15", filterCount);    
		}
		else{
			Assert.assertEquals("15", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyBidPriceFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.BID_PRICE_FILTER);
		webdriver.findElement(By.xpath(MarketWebElement.BID_PRICE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(MarketWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(MarketWebElement.BID_PRICE_100_12)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.BID_PRICE_101_12)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.BID_PRICE_102_12)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.BID_PRICE_103_12)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.BID_PRICE_104_12)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}
	
	public static void testOfferPriceFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyOfferPriceFilter(nullStatus);
		String filterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("36", filterCount);    
		}
		else{
			Assert.assertEquals("39", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyOfferPriceFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.OFFER_PRICE_FILTER);
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_PRICE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(MarketWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_PRICE_100_625)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_PRICE_100_07)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_PRICE_100_125)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_PRICE_100_25)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_PRICE_100_375)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}

	
	
	public static void testBidSpreadFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyBidSpreadFilter(nullStatus);
		String filterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("15", filterCount);    
		}
		else{
			Assert.assertEquals("15", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyBidSpreadFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.BID_SPREAD_FILTER);
		webdriver.findElement(By.xpath(MarketWebElement.BID_SPREAD_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(MarketWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(MarketWebElement.BID_SPREAD_101)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.BID_SPREAD_102)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.BID_SPREAD_103)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.BID_SPREAD_104)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.BID_SPREAD_105)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}
	
	
	public static void testOfferSpreadFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyOfferSpreadFilter(nullStatus);
		String filterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("18", filterCount);    
		}
		else{
			Assert.assertEquals("21", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyOfferSpreadFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.OFFER_SPREAD_FILTER);
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_SPREAD_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(MarketWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_SPREAD_103)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_SPREAD_112)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_SPREAD_116)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_SPREAD_168)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_SPREAD_183)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}

	
	public static void testOfferYieldFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyOfferYieldFilter(nullStatus);
		String filterCount = MarketPageObject.getMarketFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("15", filterCount);    
		}
		else{
			Assert.assertEquals("18", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyOfferYieldFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(MarketWebElement.OFFER_YIELD_FILTER);
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_YIELD_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(MarketWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_YIELD_10_3)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_YIELD_2_6)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_YIELD_2_7)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_YIELD_2_8)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.OFFER_YIELD_3_5)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(MarketWebElement.FILTER_OK)).click();
		
	}
	
}
