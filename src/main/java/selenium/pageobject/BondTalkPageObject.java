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

public class BondTalkPageObject {
	
		
	public static void goToPrivateBondTalk(){
		System.out.println("Login to BondTalk Deal vector");
		LoginPage.Goto();
		LoginPage.LoginAs(BondTalkWebElement.USERNAME).WithPassword(BondTalkWebElement.PASSWORD).Login();
		Assert.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to BondTalk Deal vector");
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.BONDTALK_TAB);    
		SeleniumHelper.Navigate(BasePageObject.baseurl + "/bwics");									// Going to bondTalk page
}
	
	public static String getBwicFilterCount(){
		WebDriver webdriver = SeleniumWebDriver.Instance();      
		String bwicFilterCount = webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_COUNT)).getText(); // Get Deal Filter Count
		System.out.println("Bwic Tab filter count is " + bwicFilterCount);
		return bwicFilterCount;
	}
	
	public static String getPrivateBwicFilterCount(){
		WebDriver webdriver = SeleniumWebDriver.Instance();      
		String bwicFilterCount = webdriver.findElement(By.xpath("//*[@id='bwic_board_container']/div/div[2]/ul/li[2]/a/span[2]")).getText(); // Get Deal Filter Count
		System.out.println("Bwic Tab filter count is " + bwicFilterCount);	
		return bwicFilterCount;
	}
	
	public static void clearAllFilter() {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CLEAR_ALL);
		webdriver.findElement(By.xpath(BondTalkWebElement.CLEAR_ALL)).click();
	}

	public static void editColumn(String editColumnSource){
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
		webdriver.findElement(By.xpath(BondTalkWebElement.SAVE_COLUMN)).click();
	}
	
		
	/* Applying Filters */
	
	public static void testClassFilter(){
		applyClassFilter();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		Assert.assertEquals("60", filterCount);
	}
	

	public static void applyClassFilter() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CLASS_FILTER);             // Wait for Class filter
		webdriver.findElement(By.xpath(BondTalkWebElement.CLASS_FILTER)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CLASS_RMBS)).click();  // Checked RMBS class
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();
		
	}

	public static void testDealFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyDealFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("4", filterCount);    
		}
		else{
			Assert.assertEquals("4", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyDealFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DEAL_NAME_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.DEAL_NAME_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.ABFC_04_M4)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.ABFC_04_M5)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.ABFC_05_M4)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.ABSHE_06_M2)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testNumericId(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyNumericIdFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("4", filterCount);    
		}
		else{
			Assert.assertEquals("4", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyNumericIdFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NUMERIC_ID_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.NUMERIC_ID_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.CUSIP_00084UAG7)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.CUSIP_004375DW8)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.CUSIP_004421TR4)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.CUSIP_00442UAN9)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();
	}
	
	public static void testOfaceFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyOfaceFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("107", filterCount);    
		}
		else{
			Assert.assertEquals("107", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyOfaceFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OFACE_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_1000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_4000)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testCfaceFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyCfaceFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("47", filterCount);    
		}
		else{
			Assert.assertEquals("89", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyCfaceFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CFACE_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_1000)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_4000)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testVintageFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyVintageFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("30", filterCount);    
		}
		else{
			Assert.assertEquals("276", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyVintageFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.VINTAGE_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_2010)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_2015)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testOrigRatingFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyOrigRatingFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("80", filterCount);    
		}
		else{
			Assert.assertEquals("229", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyOrigRatingFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ORIG_RATING_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_AAA)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_AA)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_BBB)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_UR)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testCurrRatingFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyCurrRatingFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("40", filterCount);    
		}
		else{
			Assert.assertEquals("261", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyCurrRatingFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURR_RATING_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_AAA)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_AA)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_BBB)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_UR)).click();    // Clicking on OK
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testCollatFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyCollatFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("55", filterCount);    
		}
		else{
			Assert.assertEquals("300", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyCollatFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.COLLAT_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_SELECT_ALL)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();
	}
	
	public static void horizontalScroll() throws InterruptedException{
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.HORIZONATAL_SCROLL);
		webdriver.findElement(By.xpath(BondTalkWebElement.HORIZONATAL_SCROLL)).click();                 // Wait for Deal filter
		Thread.sleep(2000);
	}
	
	public static void testDq60Filter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyDq60Filter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("43", filterCount);    
		}
		else{
			Assert.assertEquals("288", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyDq60Filter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DQ60_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_5)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_35)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testCdrFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyCdrFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("11", filterCount);    
		}
		else{
			Assert.assertEquals("256", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyCdrFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CDR_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_5)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_35)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testCprFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyCprFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("8", filterCount);    
		}
		else{
			Assert.assertEquals("253", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyCprFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CPR_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_5)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_35)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testWacFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyWacFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("8", filterCount);    
		}
		else{
			Assert.assertEquals("253", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyWacFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WAC_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.WAC_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.WAC_5)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.WAC_35)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testWalFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyWalFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("73", filterCount);    
		}
		else{
			Assert.assertEquals("290", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyWalFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WAL_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_5)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_35)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testFactorFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyFactorFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("92", filterCount);    
		}
		else{
			Assert.assertEquals("145", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyFactorFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.FACTOR_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.FACTOR_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.FACTOR_01)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.FACTOR_05)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testCouponFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyCouponFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("5", filterCount);    
		}
		else{
			Assert.assertEquals("198", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyCouponFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.COUPON_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.COUPON_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.COUPON_014)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.COUPON_019)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.COUPON_034)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.COUPON_035)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.COUPON_058)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testCreditEnhancementFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyCreditEnhancementFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("53", filterCount);    
		}
		else{
			Assert.assertEquals("202", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyCreditEnhancementFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CE_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.CE_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.CE_0)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.CE_01)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.CE_02)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CE_04)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CE_06)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testOgFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyOgFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("27", filterCount);    
		}
		else{
			Assert.assertEquals("93", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyOgFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OG_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.OG_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OG_10)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.OG_11)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.OG_12)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.OG_13)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.OG_14)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void testMmFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyMmFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("26", filterCount);    
		}
		else{
			Assert.assertEquals("92", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyMmFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MM_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.MM_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.MM_10)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.MM_11)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.MM_12)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MM_13)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MM_14)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();
	}
	
	public static void testLoansFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyLoansFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("19", filterCount);    
		}
		else{
			Assert.assertEquals("85", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyLoansFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.LOANS_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.LOANS_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.LOANS_10)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.LOANS_11)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.LOANS_12)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.LOANS_13)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.LOANS_14)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();
	}
	
	public static void testMvocFilter(Integer includeNullStatus){
		Integer nullStatus=includeNullStatus;
		applyMvocFilter(nullStatus);
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		BondTalkPageObject.clearAllFilter();
		if(includeNullStatus == 0){
			Assert.assertEquals("51", filterCount);    
		}
		else{
			Assert.assertEquals("282", filterCount);		// include NULL checked 
		}
	}
	
	public static void applyMvocFilter(Integer nullStatus) {   
		WebDriver webdriver = SeleniumWebDriver.Instance();   
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MVOC_FILTER);
		webdriver.findElement(By.xpath(BondTalkWebElement.MVOC_FILTER)).click();                 // Wait for Deal filter 
		if(nullStatus == 0){
			webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL)).click();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.MVOC_104)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.MVOC_108)).click();   // Check Mydeal
		webdriver.findElement(By.xpath(BondTalkWebElement.MVOC_109)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MVOC_110)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MVOC_112)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.FILTER_OK)).click();

	}
	
	public static void createClassSavedSearch(String saveSearchName) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		setClassSavedSearch();
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setClassSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CLASS_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CLASS_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ALL_CLASS_SS)).click();
	}
	
	public static void createDealsSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setDealsExcludeNullSavedSearch();
		}
		else {
			setDealsSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setDealsSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DEALS_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.DEALS_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ALL_DEAL_SS)).click();
	}
	
	public static void setDealsExcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DEALS_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.DEALS_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ALL_DEAL_SS)).click();
	}
	
	public static void createCurrencySavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setCurrencyExcludeNullSavedSearch();
		}
		else {
			setCurrencySavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setCurrencySavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CCY_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CCY_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CCY_USD_SS)).click();
	}
	
	public static void setCurrencyExcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CCY_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CCY_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CCY_USD_SS)).click();
	}
	
	public static void createOfaceSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setOfaceExcludeNullSavedSearch();
		}
		else {
			setOfaceSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
		
	public static void setOfaceSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OFACE_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_1000_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_4000_SS)).click();
	}
	
	public static void setOfaceExcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OFACE_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_1000_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_4000_SS)).click();
	}
	
	public static void createCfaceSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setCfaceExculdeNullSavedSearch();
		}
		else {
			setCfaceSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setCfaceSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CFACE_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_1000_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_4000_SS)).click();
	}
	
	public static void setCfaceExculdeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CFACE_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_1000_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CFACE_4000_SS)).click();
	}
	
	public static void createVintageSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setVintageEcludeNullSavedSearch();
		}
		else {
			setVintageSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setVintageSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.VINTAGE_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_2010_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_2015_SS)).click();
	}
	
	public static void setVintageEcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.VINTAGE_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_2010_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_2015_SS)).click();
	}
	
	public static void createOrigRatingSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setOrigRatingExcludeNullSavedSearch();
		}
		else {
			setOrigRatingSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setOrigRatingSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ORIG_RATING_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_AAA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_AA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_BBB_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_UR_SS)).click();
	}
	
	public static void setOrigRatingExcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ORIG_RATING_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_AAA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_AA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_BBB_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ORIG_RATING_UR_SS)).click();
	}
	
	public static void createCurrRatingSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setCurrRatingEcludeNullSavedSearch();
		}
		else {
			setCurrRatingSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setCurrRatingSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURR_RATING_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_AAA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_AA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_BBB_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_UR_SS)).click();
	}
	
	public static void setCurrRatingEcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CURR_RATING_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_AAA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_AA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_BBB_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CURR_RATING_UR_SS)).click();
	}
	
	public static void createManagerSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setManagerExcludeNullSavedSearch();
		}
		else {
			setManagerSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setManagerSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MGR_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_250_CAPITAL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_3I_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_4086_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_ACA_CAPITAL_SS)).click();
	}
	
	public static void setManagerExcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.MGR_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_250_CAPITAL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_3I_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_4086_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.MGR_ACA_CAPITAL_SS)).click();
	}
	
	public static void createCollatSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setCollatExcludeNullSavedSearch();
		}
		else {
			setCollatSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setCollatSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.COLLAT_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_ALTA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_PRIME_SS)).click();
	}
	
	public static void setCollatExcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.COLLAT_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_ALTA_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.COLLAT_PRIME_SS)).click();
	}
	
	public static void createDq60SavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setDq60ExcludeNullSavedSearch();
		}
		else {
			setDq60SavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setDq60SavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DQ60_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_5_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_35_SS)).click();
	}
	
	public static void setDq60ExcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DQ60_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_5_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.DQ60_35_SS)).click();
	}
	
	public static void createCdrSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setCdrEcludeNullSavedSearch();
		}
		else {
			setCdrSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setCdrSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CDR_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_5_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_35_SS)).click();
	}
	
	public static void setCdrEcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CDR_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_5_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CDR_35_SS)).click();
	}
	
	public static void createCprSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setCprExcludeNullSavedSearch();
		}
		else {
			setCprSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setCprSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CPR_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_5_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_35_SS)).click();
	}
	
	public static void setCprExcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CPR_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_5_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CPR_35_SS)).click();
	}
	
	public static void createWalSavedSearch(String saveSearchName, Integer includeNullStatus) throws InterruptedException {        /* creating Saved Searches */
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK);
		webdriver.findElement(By.xpath(BondTalkWebElement.NEW_SAVED_SEARCH_LINK)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SEARCH_NAME_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.SEARCH_NAME_INPUT)).sendKeys(saveSearchName);						// Entering Name
		if (includeNullStatus == 0){
			setWalExcludeNullSavedSearch();
		}
		else {
			setWalSavedSearch();
		}
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_FILTER)).click();			// Saving saved search
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_SUBMIT_SEARCH)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.OK_CLOSE_POPUP);
		webdriver.findElement(By.xpath(BondTalkWebElement.OK_CLOSE_POPUP)).click();    		 // Close confirmation popup
		Thread.sleep(1000);
	}
	
	public static void setWalSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WAL_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_5_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_35_SS)).click();
	}
	
	public static void setWalExcludeNullSavedSearch(){
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WAL_SS);
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.UNCHECK_INCLUDE_NULL_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_5_SS)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.WAL_35_SS)).click();
	}
	
	public static void goToSavedSearchesTab() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SAVED_SEARCHES_TAB);
		webdriver.findElement(By.xpath(BondTalkWebElement.SAVED_SEARCHES_TAB)).click();
		Thread.sleep(2000);
	}

	public static String alertFrequencyRealTime() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ALERT);		// Waiting for Edit Alert
		String AppliedFrequency = webdriver.findElement(By.xpath(BondTalkWebElement.ALERT)).getText();
//		String selected = dropDown.getFirstSelectedOption().getText();
//		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='edit_alert_frequency_container']/form/div[1]/label");
//		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency_container']/form/div[1]/label")).click();			// real Time Radio button
//		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency_container']/form/div[5]/button[1]")).click();			// Saving the frequency
//		Thread.sleep(2000);
//		String AppliedFrequency = webdriver.findElement(By.xpath("//*[@id='alert_frequency_container']/span[2]/b")).getText();
		System.out.println("Applied Alert Frequency is " + AppliedFrequency);
		return AppliedFrequency;
	}
	
	public static String alertFrequencyThriceDaily() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='edit_alert_frequency']/a/b");		// Waiting for Edit Alert
		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency']/a/b")).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='edit_alert_frequency_container']/form/div[2]/label");
		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency_container']/form/div[2]/label")).click();			// 3*Daily Radio button
		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency_container']/form/div[5]/button[1]")).click();			// Saving the frequency
		Thread.sleep(2000);
		String AppliedFrequency = webdriver.findElement(By.xpath("//*[@id='alert_frequency_container']/span[2]/b")).getText();
		System.out.println("Applied Alert Frequency is " + AppliedFrequency);
		return AppliedFrequency;
	}
	
	public static String alertFrequencyDaily() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='edit_alert_frequency']/a/b");		// Waiting for Edit Alert
		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency']/a/b")).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='edit_alert_frequency_container']/form/div[3]/label");
		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency_container']/form/div[3]/label")).click();			// Daily Radio button
		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency_container']/form/div[5]/button[1]")).click();			// Saving the frequency
		Thread.sleep(2000);
		String AppliedFrequency = webdriver.findElement(By.xpath("//*[@id='alert_frequency_container']/span[2]/b")).getText();
		System.out.println("Applied Alert Frequency is " + AppliedFrequency);
		return AppliedFrequency;
	}
	
	public static Object alertFrequencyOff() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='edit_alert_frequency']/a/b");		// Waiting for Edit Alert
		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency']/a/b")).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='edit_alert_frequency_container']/form/div[4]/label");
		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency_container']/form/div[4]/label")).click();			// OFF Radio button
		webdriver.findElement(By.xpath("//*[@id='edit_alert_frequency_container']/form/div[5]/button[1]")).click();			// Saving the frequency
		Thread.sleep(2000);
		String AppliedFrequency = webdriver.findElement(By.xpath("//*[@id='alert_frequency_container']/span[2]/b")).getText();
		System.out.println("Applied Alert Frequency is " + AppliedFrequency);
		return AppliedFrequency;
	}
		
	public static void goToFreeTrialTab() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.linkText("Learn More")).click();
//		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='bwic_board_container']/div/div[3]/ul/li[4]/a/span");		//  Waiting for Free trail tab
//		webdriver.findElement(By.xpath("//*[@id='bwic_board_container']/div/div[3]/ul/li[4]/a/span")).click();	
	}

	public static String requestFreeTrialLink(String link_ID) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementById(link_ID);
		webdriver.findElement(By.id(link_ID)).click();										// Clicking on Request trial link
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/div[2]");  				// Waiting for confirmation popup to come
		String popupText = webdriver.findElement(By.xpath("/html/body/div[2]")).getText();  
		System.out.println("Text1 is " + popupText);
		webdriver.findElement(By.xpath("/html/body/div[2]")).click();						// closing confir popup
		return popupText;
	}

	public static void scrollDownToId(String id) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.id(id)).sendKeys(Keys.PAGE_DOWN); 
	}

	public static void scrollUpToId(String id) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.id(id)).sendKeys(Keys.PAGE_UP); 
	}	

	public static void scrollDownToXpath(String xpath) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.id(xpath)).sendKeys(Keys.PAGE_DOWN); 
	}

	public static void scrollUpToXpath(String xpath) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.id(xpath)).sendKeys(Keys.PAGE_UP); 
	}

	public static void applyBdpColumns() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.EDIT_BDP_COLUMN);
		webdriver.findElement(By.xpath(BondTalkWebElement.EDIT_BDP_COLUMN)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.BDP_CLOSE);
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_CLOSE)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.EDIT_BDP_COLUMN)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.BDP_COL1);
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL1)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL2)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL3)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL4)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL5)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL6)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL7)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL8)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL9)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL10)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL11)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL12)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL13)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL14)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL15)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL16)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL17)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL18)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL19)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL20)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL21)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL22)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL23)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL24)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL25)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL26)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_COL27)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.BDP_SAVE)).click();
	}
	
	public static void downloadExcelClass() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountClassSsTabLink();
		BondTalkOperations.clickOnClassSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}

	public static void downloadExcelDeal() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountDealSsTabLink();
		BondTalkOperations.clickOnDealSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelDealWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountDealWoNullSsTabLink();
		BondTalkOperations.clickOnDealWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCurrency() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCurrencySsTabLink();
		BondTalkOperations.clickOnCurrencySsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCurrencyWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCurrencyWoNullSsTabLink();
		BondTalkOperations.clickOnCurrencyWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelOface() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountOfaceSsTabLink();
		BondTalkOperations.clickOnOfaceSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelOfaceWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountOfaceWoNullSsTabLink();
		BondTalkOperations.clickOnOfaceWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCface() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCfaceSsTabLink();
		BondTalkOperations.clickOnCfaceSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCfaceWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCfaceWoNullSsTabLink();
		BondTalkOperations.clickOnCfaceWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelVintage() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountVintageSsTabLink();
		BondTalkOperations.clickOnVintageSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelVintageWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountVintageWoNullSsTabLink();
		BondTalkOperations.clickOnVintageWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
		
	public static void downloadExcelOrigRating() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountOrigRatingSsTabLink();
		BondTalkOperations.clickOnOrigRatingSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelOrigRatingWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountOrigRatingWoNullSsTabLink();
		BondTalkOperations.clickOnOrigRatingWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
		
	public static void downloadExcelCurrRating() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCurrRatingSsTabLink();
		BondTalkOperations.clickOnCurrRatingSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCurrRatingWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCurrRatingWoNullSsTabLink();
		BondTalkOperations.clickOnCurrRatingWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
		
	public static void downloadExcelManager() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountManagerSsTabLink();
		BondTalkOperations.clickOnManagerSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelManagerWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountManagerWoNullSsTabLink();
		BondTalkOperations.clickOnManagerWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
		
	public static void downloadExcelCollat() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCollatSsTabLink();
		BondTalkOperations.clickOnCollatSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCollatWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCollatWoNullSsTabLink();
		BondTalkOperations.clickOnCollatWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
		
	public static void downloadExcelDq60() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountDq60SsTabLink();
		BondTalkOperations.clickOnDq60SsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelDq60WoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountDq60WoNullSsTabLink();
		BondTalkOperations.clickOnDq60WoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCdr() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCdrSsTabLink();
		BondTalkOperations.clickOnCdrSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCdrWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCdrWoNullSsTabLink();
		BondTalkOperations.clickOnCdrWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
		
	public static void downloadExcelCpr() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCprSsTabLink();
		BondTalkOperations.clickOnCprSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCprWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountCprWoNullSsTabLink();
		BondTalkOperations.clickOnCprWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelWal() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountWalSsTabLink();
		BondTalkOperations.clickOnWalSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelWalWoNull() throws InterruptedException {
		goToSavedSearchesTab();
		String ssTabCount = BondTalkOperations.getCountWalWoNullSsTabLink();
		BondTalkOperations.clickOnWalWoNullSsTabLink();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		if (ssTabCount == filterCount){
			System.out.println("Saved search and bwic Count is matching");
		}
		else{
			System.out.println("Saved search and bwic Count is  NOT  matching");
		}
		System.out.println("Saved search count is " + ssTabCount);
		System.out.println("Saved search count is " + filterCount);
		BondTalkOperations.clickOnDownloadLink();
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelNumericId(Integer includeNUllStatus) throws InterruptedException {
		clearAllFilter();
		Integer nullStatus = includeNUllStatus;
		applyNumericIdFilter(nullStatus);
		BondTalkOperations.clickOnDownloadLink();
		Thread.sleep(2000);
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelFactor(Integer includeNUllStatus) throws InterruptedException {
		clearAllFilter();
		Integer nullStatus = includeNUllStatus;
		applyFactorFilter(nullStatus);
		BondTalkOperations.clickOnDownloadLink();
		Thread.sleep(2000);
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCoupon(Integer includeNUllStatus) throws InterruptedException {
		clearAllFilter();
		Integer nullStatus = includeNUllStatus;
		applyCouponFilter(nullStatus);
		BondTalkOperations.clickOnDownloadLink();
		Thread.sleep(2000);
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelCreditEnhancement(Integer includeNUllStatus) throws InterruptedException {
		clearAllFilter();
		Integer nullStatus = includeNUllStatus;
		applyCreditEnhancementFilter(nullStatus);
		BondTalkOperations.clickOnDownloadLink();
		Thread.sleep(2000);
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelWac(Integer includeNUllStatus) throws InterruptedException {
		clearAllFilter();
		Integer nullStatus = includeNUllStatus;
		applyWacFilter(nullStatus);
		BondTalkOperations.clickOnDownloadLink();
		Thread.sleep(2000);
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelOg(Integer includeNUllStatus) throws InterruptedException {
		clearAllFilter();
		Integer nullStatus = includeNUllStatus;
		applyOgFilter(nullStatus);
		BondTalkOperations.clickOnDownloadLink();
		Thread.sleep(2000);
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelMm(Integer includeNUllStatus) throws InterruptedException {
		clearAllFilter();
		Integer nullStatus = includeNUllStatus;
		applyMmFilter(nullStatus);
		BondTalkOperations.clickOnDownloadLink();
		Thread.sleep(2000);
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelLoans(Integer includeNUllStatus) throws InterruptedException {
		clearAllFilter();
		Integer nullStatus = includeNUllStatus;
		applyLoansFilter(nullStatus);
		BondTalkOperations.clickOnDownloadLink();
		Thread.sleep(2000);
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void downloadExcelMvoc(Integer includeNUllStatus) throws InterruptedException {
		clearAllFilter();
		Integer nullStatus = includeNUllStatus;
		applyMvocFilter(nullStatus);
		BondTalkOperations.clickOnDownloadLink();
		Thread.sleep(2000);
		System.out.println("Excel Downloaded Successfully");
	}
	
	public static void allClassFilterFromDropdown() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Thread.sleep(3000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.SAVED_SEARCHES_DROPDOWN);
		webdriver.findElement(By.xpath(BondTalkWebElement.SAVED_SEARCHES_DROPDOWN)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CLASS_SS_DROPDOWN)).click();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		Assert.assertEquals("300", filterCount);   
		
	}
	
	public static void currencyFilterFromDropdown() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Thread.sleep(3000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.APPLIED_SAVED_SEARCHES_DROPDOWN);
		webdriver.findElement(By.xpath(BondTalkWebElement.APPLIED_SAVED_SEARCHES_DROPDOWN)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.CURRENCY_SS_DROPDOWN)).click();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		Assert.assertEquals("295", filterCount);  
		
	}

	public static void ofaceFilterFromDropdown() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Thread.sleep(3000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.APPLIED_SAVED_SEARCHES_DROPDOWN);
		webdriver.findElement(By.xpath(BondTalkWebElement.APPLIED_SAVED_SEARCHES_DROPDOWN)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.OFACE_SS_DROPDOWN)).click();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		Assert.assertEquals("107", filterCount); 
	}
	
	public static void vintageFilterFromDropdown() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Thread.sleep(3000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.APPLIED_SAVED_SEARCHES_DROPDOWN);
		webdriver.findElement(By.xpath(BondTalkWebElement.APPLIED_SAVED_SEARCHES_DROPDOWN)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.VINTAGE_SS_DROPDOWN)).click();
		String filterCount = BondTalkPageObject.getBwicFilterCount();
		Assert.assertEquals("30", filterCount); 
	}

	public static void addNote94987UAL7(String addNoteText1,String addNoteText2,String addNoteText3) throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ADD_NOTE);
		webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE)).click();
		Thread.sleep(2000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ADD_NOTE_INPUT_BOX);
		webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_INPUT_BOX)).sendKeys(addNoteText1);
		webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_BUTTON)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ADD_NOTE_INPUT_BOX1);
		webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_INPUT_BOX1)).sendKeys(addNoteText2);
		webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_BUTTON1)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ADD_NOTE_INPUT_BOX1);
		webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_INPUT_BOX1)).sendKeys(addNoteText3);
		webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_BUTTON1)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_CLOSE)).click();
			
		}

	public static void deleteNote() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ADDED_NOTE);
		webdriver.findElement(By.xpath(BondTalkWebElement.ADDED_NOTE)).click();
		Thread.sleep(2000);
		String addNoteText1 = webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_TEXT1)).getText();
		System.out.println("First Note text is  --- " + addNoteText1);
		Assert.assertEquals("This is my First Add Note", addNoteText1); 
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.DELETE_FIRST_NOTE);
		webdriver.findElement(By.xpath(BondTalkWebElement.DELETE_FIRST_NOTE)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_CLOSE)).click();
		
	}

	public static void verifyAddNotePriceHistory() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.EXPAND_COLLAPSE_DEAL_WFMLT);
		webdriver.findElement(By.xpath(BondTalkWebElement.EXPAND_COLLAPSE_DEAL_WFMLT)).click();
		Thread.sleep(1000);
		webdriver.findElement(By.xpath(BondTalkWebElement.GO_TO_PRICE_HISTORY_TAB)).click();
		Thread.sleep(1000);
		String addNotePriceHistText2 = webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_PRICE_HIST_TEXT2)).getText();
		System.out.println("First Note text is  --- " + addNotePriceHistText2);
		Assert.assertEquals("This is my Second Add Note", addNotePriceHistText2); 
		webdriver.findElement(By.xpath(BondTalkWebElement.DELETE_NOTE_PRICE_HISTORY2)).click();
		Thread.sleep(1000);
	}

	public static void verifyThirdAddNote() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.xpath(BondTalkWebElement.EXPAND_COLLAPSE_DEAL_WFMLT)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.ADDED_NOTE);
		webdriver.findElement(By.xpath(BondTalkWebElement.ADDED_NOTE)).click();
		Thread.sleep(1000);
		String addNotePriceHistText3 = webdriver.findElement(By.xpath(BondTalkWebElement.ADD_NOTE_TEXT3)).getText();
		System.out.println("First Note text is  --- " + addNotePriceHistText3);
		Assert.assertEquals("This is my Third Add Note", addNotePriceHistText3); 
		
	}

	public static void verifyDealDetail() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WFMLT_2011_RR2);
		webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_2011_RR2)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WFMLT_2011_SHORT_NAME);
		Assert.assertEquals("WFMLT 2011-RR2 3A2", webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_2011_SHORT_NAME)).getText()); 
		Assert.assertEquals("WFMLT 2011-RR2 3A2", webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_2011_DEAL_NAME)).getText());
		Assert.assertEquals("94987UAL7", webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_2011_CUSIP)).getText());
		Assert.assertEquals("RMBS", webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_2011_ASSET_CLASS)).getText());
		Assert.assertEquals("China Development Bank", webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_2011_MANAGER)).getText());
		webdriver.findElement(By.xpath(BondTalkWebElement.DEAL_DETAIL_CLOSE)).click();
		
	}

	public static void verifyCorelogicInfo() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.EXPAND_COLLAPSE_DEAL_WFMLT);
		webdriver.findElement(By.xpath(BondTalkWebElement.EXPAND_COLLAPSE_DEAL_WFMLT)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CORELOGIC_DQ60);
		Assert.assertEquals("6.633%", webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_DQ60)).getText());
		Assert.assertEquals("2.391%", webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_FACTOR)).getText());
		Assert.assertEquals("2.153%", webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_CPR)).getText());
		Assert.assertEquals("38.295", webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_UPB)).getText());
		Assert.assertEquals("2.559%", webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_CDR)).getText());
//		Assert.assertEquals("6.633", webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_TRUSTEE)).getText());
		Assert.assertEquals("2.152%", webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_WAC)).getText());
		Assert.assertEquals("22.702%", webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_SEVERITY)).getText());	
		System.out.println(webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_TEXT)).getText());
		Assert.assertEquals(MessageCentrePageObject.retTrue(), 
				MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_TEXT)).getText(),
				"This sample of WFMLT 2011-RR2 3A2 deal metrics is from the comprehensive"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), 
				MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(BondTalkWebElement.CORELOGIC_TEXT)).getText(),
				"To view additional collateral information for WFMLT 2011-RR2 3A2, contact Adam Laughery at CoreLogic - he will respond ASAP."));
	}

	public static void reportIssueIncorrectDate() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE_CORRECT_DATE);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_CORRECT_DATE)).sendKeys("2017/12/26");
		Thread.sleep(1000);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_SUBMIT_BUTTON_CORRECT_DATE)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CONFIRM_TEXT_CORRECT_DATE);
		Assert.assertEquals("Your issue has been reported. We will work on it.", webdriver.findElement(By.xpath(BondTalkWebElement.CONFIRM_TEXT_CORRECT_DATE)).getText());
		webdriver.findElement(By.xpath(BondTalkWebElement.CONFIRM_TEXT_CORRECT_DATE_OK)).click();
	}

	public static void reportIssueSplitList() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE_SPLIT_LIST_RADIO);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_SPLIT_LIST_RADIO)).click();
		Assert.assertEquals("List: 07-17 a (10:00 AM)", webdriver.findElement(By.xpath(BondTalkWebElement.LIST_A)).getText());
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_SPLIT_LIST_INPUT)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_SPLIST_LIST1)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_SPLIST_LIST2)).click();
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_SPLIT_LIST_RADIO)).click();                         /// clicking again to close the dropdown so that submit button can be clicked.
		Thread.sleep(1000);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_SUBMIT_BUTTON_SPLIT)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CONFIRM_TEXT_SPLIT);
		Assert.assertEquals("Your issue has been reported. We will work on it.", webdriver.findElement(By.xpath(BondTalkWebElement.CONFIRM_TEXT_SPLIT)).getText());
		webdriver.findElement(By.xpath(BondTalkWebElement.CONFIRM_TEXT_SPLIT_OK)).click();
		
	}

	public static void reportIssueMissingData() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE_MISSING_DATA_RADIO);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_MISSING_DATA_RADIO)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE_MISSING_DATA_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_MISSING_DATA_INPUT)).sendKeys("What a awesome scraper you have have created.");
		Thread.sleep(1000);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_SUBMIT_BUTTON_MISSING_DATA)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CONFIRM_TEXT_MISSING_DATA);
		Assert.assertEquals("Your issue has been reported. We will work on it.", webdriver.findElement(By.xpath(BondTalkWebElement.CONFIRM_TEXT_MISSING_DATA)).getText());
		webdriver.findElement(By.xpath(BondTalkWebElement.CONFIRM_TEXT_MISSING_DATA_OK)).click();
		
	}

	public static void reportIssueOther() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE_OTHER_RADIO);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_OTHER_RADIO)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.REPORT_ISSUE_OTHER_INPUT);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_ISSUE_OTHER_INPUT)).sendKeys("Ohh.. Yeah That was a nice scraper i have created.");
		Thread.sleep(1000);
		webdriver.findElement(By.xpath(BondTalkWebElement.REPORT_SUBMIT_BUTTON_OTHER)).click();
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CONFIRM_TEXT_OTHER);
		Assert.assertEquals("Your issue has been reported. We will work on it.", webdriver.findElement(By.xpath(BondTalkWebElement.CONFIRM_TEXT_OTHER)).getText());
		webdriver.findElement(By.xpath(BondTalkWebElement.CONFIRM_TEXT_OTHER_OK)).click();
		
		
	}

	public static void verifyBrokers() {
//		String compareTo = "CapStoneConnexionMeridianNexusStormPort";
		String currentBrokers="";
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.BROKER_CAPSTONE);
		currentBrokers = currentBrokers.concat(webdriver.findElement(By.xpath(BondTalkWebElement.BROKER_CAPSTONE)).getText());
		currentBrokers = currentBrokers.concat(webdriver.findElement(By.xpath(BondTalkWebElement.BROKER_CONNECXION)).getText());
		currentBrokers = currentBrokers.concat(webdriver.findElement(By.xpath(BondTalkWebElement.BROKER_MERIDIAN)).getText());
		currentBrokers = currentBrokers.concat(webdriver.findElement(By.xpath(BondTalkWebElement.BROKER_NEXUS)).getText());
		currentBrokers = currentBrokers.concat(webdriver.findElement(By.xpath(BondTalkWebElement.BROKER_STORMPORT)).getText());
		
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(currentBrokers,"CapStone"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(currentBrokers,"Connexion"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(currentBrokers,"Meridian"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(currentBrokers,"Nexus"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(currentBrokers,"StormPort"));
		
		
//		Assert.assertEquals("Your Brokers did not match", compareTo, currentBrokers);
	}
	
	public static void verifyPriceTalkPopUpHeader() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WFMLT_PRICETALK_CELL);
		Assert.assertEquals("LM60S", webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_PRICETALK_CELL)).getText());
		webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_PRICETALK_CELL)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WFMLT_PRICETALK_HEADER);
		Assert.assertEquals("Px Talk for WFMLT 2011-RR2 3A2", webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_PRICETALK_HEADER)).getText());
						
	}
	
	public static void verifyCoverDetails() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.WFMLT_COVER);
		Assert.assertEquals("Cover (latest):",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_COVER)).getText());
		Assert.assertEquals("Nexus:",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_COVER_BROKER)).getText());
		Assert.assertEquals("LM60S",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_COVER_PRICE)).getText());
	}
	
	public static void verifyPriceTalkDetails() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		Assert.assertEquals("Meridian:",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_Px_TALK_BROKER_MERIDIAN)).getText());
		Assert.assertEquals("LM60S",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_Px_TALK_MERIDIAN)).getText());
		
		Assert.assertEquals("StormPort:",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_Px_TALK_BROKER_STORMPORT)).getText());
		Assert.assertEquals("LM70S",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_Px_TALK_STORMPORT)).getText());
		
		Assert.assertEquals("Connexion:",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_Px_TALK_BROKER_CONNEXION)).getText());
		Assert.assertEquals("90H",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_Px_TALK_CONNEXION)).getText());
		
		Assert.assertEquals("CapStone:",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_Px_TALK_BROKER_CAPSTONE)).getText());
		Assert.assertEquals("92H",webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_Px_TALK_CAPSTONE)).getText());
		webdriver.findElement(By.xpath(BondTalkWebElement.WFMLT_Px_TALK_POPUP_CLOSE)).click();
		
	}

	public static String verifyPSTTimezone() throws InterruptedException {
		BondTalkOperations.applyPSTTimeZone();
		String AuctionEventTimeStamp = BondTalkOperations.getAuctionEventTimeStamp();
		System.out.println("Showing AE time stamp for PST is  =  " +  AuctionEventTimeStamp);
		return AuctionEventTimeStamp;
		
	}

	public static String verifyESTTimezone() throws InterruptedException {
		BondTalkOperations.applyESTTimeZone();
		String AuctionEventTimeStamp = BondTalkOperations.getAuctionEventTimeStamp();
		System.out.println("Showing AE time stamp for EST is  =  " +  AuctionEventTimeStamp);
		return AuctionEventTimeStamp;
	}

	public static String verifyGMTTimezone() throws InterruptedException {
		BondTalkOperations.applyGMTTimeZone();
		String AuctionEventTimeStamp = BondTalkOperations.getAuctionEventTimeStamp();
		System.out.println("Showing AE time stamp for EST is  =  " +  AuctionEventTimeStamp);
		return AuctionEventTimeStamp;
	}

	public static void verifySourceBwicDetails() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.CAPSTONE_SOURCE_BWIC);
		webdriver.findElement(By.xpath(BondTalkWebElement.CAPSTONE_SOURCE_BWIC)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(BondTalkWebElement.BROKER_NAME);
		Assert.assertEquals("alfredj@CapStone.com", webdriver.findElement(By.xpath(BondTalkWebElement.BROKER_EMAIL)).getText());
		Assert.assertEquals("Alfred jonnes [CapStone]", webdriver.findElement(By.xpath(BondTalkWebElement.BROKER_NAME)).getText());
		
	}

	public static void goToBondTalkTab() throws InterruptedException {
		SeleniumHelper.Navigate(BasePageObject.baseurl +"/bwics");
		Thread.sleep(5000);
		
	}
	
}
