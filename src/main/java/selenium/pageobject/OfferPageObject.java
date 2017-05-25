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
import WebElement.OfferWebElement;

public class OfferPageObject {

	public static void goToOfferTab() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.OFFER_TAB);
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_TAB)).click();
		
	}

	public static void offerEditColumn(String editColumnSource){
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
		webdriver.findElement(By.xpath(OfferWebElement.SAVE_COLUMN)).click();
	}

	private static String getOfferFilterCount() {
		WebDriver webdriver = SeleniumWebDriver.Instance();      
		String offerFilterCount = webdriver.findElement(By.xpath(OfferWebElement.OFFER_FILTER_COUNT)).getText(); // Get Deal Filter Count
		System.out.println("Offer Tab filter count is " + offerFilterCount);
		return offerFilterCount;
	}
	
	public static void testClassFilter() throws InterruptedException {
		applyClassFilter();
		String offerFilterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		Assert.assertEquals("49", offerFilterCount);
		
	}


	private static void applyClassFilter() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.CLASS_FILTER);             // Wait for Class filter
		webdriver.findElement(By.xpath(OfferWebElement.CLASS_FILTER)).click();
		webdriver.findElement(By.xpath(OfferWebElement.CLASS_OTHER)).click();  // Checked RMBS class
		webdriver.findElement(By.xpath(OfferWebElement.CLASS_RMBS)).click();  // Checked RMBS class
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}


	public static void testDealFilter() {
		applyDealFilter();
		String offerFilterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		Assert.assertEquals("10", offerFilterCount);
		
	}


	private static void applyDealFilter() {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.DEAL_NAME_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.DEAL_NAME_FILTER)).click();                 // Wait for Deal filter 
		webdriver.findElement(By.xpath(OfferWebElement.ACAR_3C)).click();   
		webdriver.findElement(By.xpath(OfferWebElement.AESOP_3B)).click();   
		webdriver.findElement(By.xpath(OfferWebElement.AESOP_1B)).click();    
		webdriver.findElement(By.xpath(OfferWebElement.AESOP_1A)).click();    
		webdriver.findElement(By.xpath(OfferWebElement.AFIN_3A4)).click();    
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	
	public static void testNumericIdFilter(Integer includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyNumericIdFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("10", filterCount);    
		}
		else{
			Assert.assertEquals("10", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyNumericIdFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.NUMERIC_ID_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.NUMERIC_ID_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.CUSIP_02005AFL7)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.CUSIP_02529BAE3)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(OfferWebElement.CUSIP_03065MAC1)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(OfferWebElement.CUSIP_03065VAD9)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(OfferWebElement.CUSIP_05377RBC7)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testCurrencyFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyCurrencyFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("107", filterCount);    
		}
		else{
			Assert.assertEquals("107", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyCurrencyFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.CURRENCY_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.CURRENCY_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.USD_CURRENCY)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testOfaceFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyOfaceFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("34", filterCount);    
		}
		else{
			Assert.assertEquals("37", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyOfaceFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.OFACE_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.OFACE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.OFACE_1000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFACE_5000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testCfaceFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyCfaceFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("31", filterCount);    
		}
		else{
			Assert.assertEquals("36", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyCfaceFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.CFACE_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.CFACE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.CFACE_1000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.CFACE_5000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testOfferPriceFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyOfferPriceFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("73", filterCount);    
		}
		else{
			Assert.assertEquals("73", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyOfferPriceFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.OFFER_PRICE_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_PRICE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_PRICE_103_29)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_PRICE_104_12)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_PRICE_104_18)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_PRICE_104_20)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_PRICE_104_22)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testOfferSpreadFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyOfferSpreadFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("14", filterCount);    
		}
		else{
			Assert.assertEquals("17", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyOfferSpreadFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.OFFER_SPREAD_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_SPREAD_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_SPREAD_10)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_SPREAD_100)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_SPREAD_11)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_SPREAD_120)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_SPREAD_132)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testOfferYieldFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyOfferYieldFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("95", filterCount);    
		}
		else{
			Assert.assertEquals("95", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyOfferYieldFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.OFFER_YIELD_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_YIELD_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_YIELD_24)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_YIELD_25)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_YIELD_26)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_YIELD_27)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.OFFER_YIELD_28)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testAttachFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyAttachFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("14", filterCount);    
		}
		else{
			Assert.assertEquals("14", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyAttachFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.ATTACH_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.ATTACH_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.ATTACH_487)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.ATTACH_305)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.ATTACH_0)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.ATTACH_511)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.ATTACH_654)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testDetachFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyDetachFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("14", filterCount);    
		}
		else{
			Assert.assertEquals("14", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyDetachFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.DETACH_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.DETACH_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.DETACH_0)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.DETACH_541)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.DETACH_734)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.DETACH_831)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.DETACH_1189)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testNumDaysFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyNumDaysFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("111", filterCount);    
		}
		else{
			Assert.assertEquals("111", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyNumDaysFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.NUM_DAYS_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.NUM_DAYS_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.NUM_DAYS_1)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testVintageFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyVintageFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("20", filterCount);    
		}
		else{
			Assert.assertEquals("98", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyVintageFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.VINTAGE_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.VINTAGE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.VINTAGE_2011)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.VINTAGE_2015)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testOrigRatingFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyOrigRatingFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("27", filterCount);    
		}
		else{
			Assert.assertEquals("101", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyOrigRatingFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.ORIG_RATING_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.ORIG_RATING_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.ORIG_RATING_AA)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.ORIG_RATING_BBB)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.ORIG_RATING_C)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.ORIG_RATING_D)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testCurrRatingFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyCurrRatingFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("31", filterCount);    
		}
		else{
			Assert.assertEquals("105", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyCurrRatingFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.CURR_RATING_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.CURR_RATING_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.CURR_RATING_AA)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.CURR_RATING_BBB)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.CURR_RATING_C)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.CURR_RATING_D)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testManagerFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyManagerFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("16", filterCount);    
		}
		else{
			Assert.assertEquals("92", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyManagerFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.MANAGER_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.MANAGER_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.MANAGER_FCO)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.MANAGER_GOLUB)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.MANAGER_HSBC)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.MANAGER_LB)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.MANAGER_CHINA)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testCouponFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyCouponFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("18", filterCount);    
		}
		else{
			Assert.assertEquals("18", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyCouponFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.COUPON_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.COUPON_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.COUPON_22)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.COUPON_25)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.COUPON_275)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.COUPON_285)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.COUPON_35)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testCreditEnhancementFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyCreditEnhancementFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("29", filterCount);    
		}
		else{
			Assert.assertEquals("111", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyCreditEnhancementFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.CE_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.CE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.CE_0)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.CE_87)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.CE_115)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.CE_131)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testCollatFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyCollatFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("25", filterCount);    
		}
		else{
			Assert.assertEquals("111", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyCollatFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.COLLAT_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.COLLAT_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.COLLAT_ALT_A)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.COLLAT_BC)).click(); 
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}

	public static void testMvocFilter(int includeNullStatus) {
		Integer nullStatus=includeNullStatus;
		applyMvocFilter(nullStatus);
		String filterCount = OfferPageObject.getOfferFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("29", filterCount);    
		}
		else{
			Assert.assertEquals("111", filterCount);		// include NULL checked 
		}
		
	}

	private static void applyMvocFilter(Integer nullStatus) {
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(OfferWebElement.MVOC_FILTER);
		webdriver.findElement(By.xpath(OfferWebElement.MVOC_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(OfferWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(OfferWebElement.MVOC_1)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(OfferWebElement.FILTER_OK)).click();
		
	}
	
	
	
}
