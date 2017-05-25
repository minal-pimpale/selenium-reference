package junit.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.pageobject.BondTalkPageObject;
import selenium.pageobject.MessageCentrePageObject;
import selenium.utils.SeleniumWebDriver;

/* Total 55 test cases*/

public class BondTalk {
	
	@Test(priority=1)
	public void testSuitePublicFilter() throws InterruptedException {
		BondTalkPageObject.goToPrivateBondTalk();
		BondTalkPageObject.testClassFilter();
		BondTalkPageObject.testDealFilter(1);
		BondTalkPageObject.testDealFilter(1);
		BondTalkPageObject.testNumericId(0);
		BondTalkPageObject.testNumericId(1);
		BondTalkPageObject.testOfaceFilter(0);
		BondTalkPageObject.testOfaceFilter(1);
		BondTalkPageObject.testCfaceFilter(0);
		BondTalkPageObject.testCfaceFilter(1);
		BondTalkPageObject.testVintageFilter(0);
		BondTalkPageObject.testVintageFilter(1);
		BondTalkPageObject.testOrigRatingFilter(0);
		BondTalkPageObject.testOrigRatingFilter(1);
		BondTalkPageObject.testCurrRatingFilter(0);
		BondTalkPageObject.testCurrRatingFilter(1);
		BondTalkPageObject.testCollatFilter(0);
		BondTalkPageObject.testCollatFilter(1);
		BondTalkPageObject.horizontalScroll();            // Horizontal scrolling on BondTalk Dashboard.
		BondTalkPageObject.testDq60Filter(0);
		BondTalkPageObject.testDq60Filter(1);
		BondTalkPageObject.testCdrFilter(0);
		BondTalkPageObject.testCdrFilter(1);
		BondTalkPageObject.testCprFilter(0);
		BondTalkPageObject.testCprFilter(1);
		BondTalkPageObject.testWacFilter(0);
		BondTalkPageObject.testWacFilter(1);
		BondTalkPageObject.testWalFilter(0);
		BondTalkPageObject.testWalFilter(1);
		BondTalkPageObject.editColumn("FromHeader");            // here columns are edited from edit pencil icon in headers extreme left corner
		BondTalkPageObject.testFactorFilter(0);
		BondTalkPageObject.testFactorFilter(1);
		BondTalkPageObject.testCouponFilter(0);
		BondTalkPageObject.testCouponFilter(1);
		BondTalkPageObject.testCreditEnhancementFilter(0);
		BondTalkPageObject.testCreditEnhancementFilter(1);
		BondTalkPageObject.horizontalScroll();            // Horizontal scrolling on BondTalk Dashboard.
		BondTalkPageObject.testOgFilter(0);
		BondTalkPageObject.testOgFilter(1);
		BondTalkPageObject.testMmFilter(0);
		BondTalkPageObject.testMmFilter(1);
		BondTalkPageObject.testLoansFilter(0);
		BondTalkPageObject.testLoansFilter(1);
		BondTalkPageObject.testMvocFilter(0);
		BondTalkPageObject.testMvocFilter(1);
		SeleniumWebDriver.CloseDriver();		
    }
	
	@Test(priority=2)
	public void testSuiteSavedSearch() throws InterruptedException {
		BondTalkPageObject.goToPrivateBondTalk();
		BondTalkPageObject.createClassSavedSearch("All Classes");
		BondTalkPageObject.createDealsSavedSearch("MY Deal And Related Deal", 1);
		BondTalkPageObject.createDealsSavedSearch("MY Deal And Related Deal", 1);
		BondTalkPageObject.createCurrencySavedSearch("Currency USD",1);
		BondTalkPageObject.createCurrencySavedSearch("Currency USD without Include NULL",0);
		BondTalkPageObject.createOfaceSavedSearch("Oface 1000-4000",1);
		BondTalkPageObject.createOfaceSavedSearch("Oface 1000-4000 without Include NULL",0);
		BondTalkPageObject.createCfaceSavedSearch("Cface 1000-4000",1);
		BondTalkPageObject.createCfaceSavedSearch("Cface 1000-4000 without Include NULL",0);
		BondTalkPageObject.createVintageSavedSearch("Vintage 2010-2015",1);
		BondTalkPageObject.createVintageSavedSearch("Vintage 2010-2015 without Include NULL",0);
		BondTalkPageObject.createOrigRatingSavedSearch("Original Rating AAA,AA,BBB,UR",1);
		BondTalkPageObject.createOrigRatingSavedSearch("Original Rating AAA,AA,BBB,UR without Include NULL",0);
		BondTalkPageObject.createCurrRatingSavedSearch("Current Rating AAA,AA,BBB,UR",1);
		BondTalkPageObject.createCurrRatingSavedSearch("Current Rating AAA,AA,BBB,UR without Include NULL",0);
		BondTalkPageObject.createManagerSavedSearch("Manager 250,3i,4086,Aca Cap",1);
		BondTalkPageObject.createManagerSavedSearch("Manager 250,3i,4086,Aca Cap without Include NULL",0);
		BondTalkPageObject.createCollatSavedSearch("Collat AltA,Prime",1);
		BondTalkPageObject.createCollatSavedSearch("Collat AltA,Prime without Include NULL",0);
		BondTalkPageObject.createDq60SavedSearch("DQ60 5-35",1);
		BondTalkPageObject.createDq60SavedSearch("DQ60 5-35 without Include NULL",0);
		BondTalkPageObject.createCdrSavedSearch("CDR 5-35",1);
		BondTalkPageObject.createCdrSavedSearch("CDR 5-35 without Include NULL",0);
		BondTalkPageObject.createCprSavedSearch("CPR 5-35",1);
		BondTalkPageObject.createCprSavedSearch("CPR 5-35 without Include NULL",0);
		BondTalkPageObject.createWalSavedSearch("WAL 5-35",1);
		BondTalkPageObject.createWalSavedSearch("WAL 5-35 without Include NULL",0);
		SeleniumWebDriver.CloseDriver();
		
	}
	
	@Test(priority=3)
	public void bondTalkDownloadExcel() throws InterruptedException {
		BondTalkPageObject.goToPrivateBondTalk();
		BondTalkPageObject.applyBdpColumns();
		BondTalkPageObject.downloadExcelClass();
		BondTalkPageObject.downloadExcelDeal();
		BondTalkPageObject.downloadExcelDealWoNull();
		BondTalkPageObject.downloadExcelCurrency();
		BondTalkPageObject.downloadExcelCurrencyWoNull();
		BondTalkPageObject.downloadExcelOface();
		BondTalkPageObject.downloadExcelOfaceWoNull();
		BondTalkPageObject.downloadExcelCface();
		BondTalkPageObject.downloadExcelCfaceWoNull();
		BondTalkPageObject.downloadExcelVintage();
		BondTalkPageObject.downloadExcelVintageWoNull();
		BondTalkPageObject.downloadExcelOrigRating();
		BondTalkPageObject.downloadExcelOrigRatingWoNull();
		BondTalkPageObject.downloadExcelCurrRating();
		BondTalkPageObject.downloadExcelCurrRatingWoNull();
		BondTalkPageObject.downloadExcelManager();
		BondTalkPageObject.downloadExcelManagerWoNull();
		BondTalkPageObject.downloadExcelCollat();
		BondTalkPageObject.downloadExcelCollatWoNull();
		BondTalkPageObject.downloadExcelDq60();
		BondTalkPageObject.downloadExcelDq60WoNull();
		BondTalkPageObject.downloadExcelCdr();
		BondTalkPageObject.downloadExcelCdrWoNull();
		BondTalkPageObject.downloadExcelCpr();
		BondTalkPageObject.downloadExcelCprWoNull();
		BondTalkPageObject.downloadExcelWal();
		BondTalkPageObject.downloadExcelWalWoNull();
		BondTalkPageObject.downloadExcelNumericId(0);
		BondTalkPageObject.downloadExcelNumericId(1);
		BondTalkPageObject.horizontalScroll();            // Horizontal scrolling on BondTalk Dashboard.
		BondTalkPageObject.downloadExcelWac(0);
		BondTalkPageObject.downloadExcelWac(1);
		BondTalkPageObject.editColumn("FromTop");              // here columns are edited "Columns" popup at top
		BondTalkPageObject.downloadExcelFactor(0);
		BondTalkPageObject.downloadExcelFactor(1);
		BondTalkPageObject.downloadExcelCoupon(0);
		BondTalkPageObject.downloadExcelCoupon(1);
		BondTalkPageObject.downloadExcelCreditEnhancement(0);
		BondTalkPageObject.downloadExcelCreditEnhancement(1);
		BondTalkPageObject.horizontalScroll();            // Horizontal scrolling on BondTalk Dashboard.
		BondTalkPageObject.downloadExcelOg(0);
		BondTalkPageObject.downloadExcelOg(1);
		BondTalkPageObject.downloadExcelMm(0);
		BondTalkPageObject.downloadExcelMm(1);
		BondTalkPageObject.downloadExcelLoans(0);
		BondTalkPageObject.downloadExcelLoans(1);
		BondTalkPageObject.downloadExcelMvoc(0);
		BondTalkPageObject.downloadExcelMvoc(1);
		SeleniumWebDriver.CloseDriver();
		
	}
	
	@Test(priority=4)
	public static void filterFromDropdown() throws InterruptedException{
		BondTalkPageObject.goToPrivateBondTalk();
		BondTalkPageObject.allClassFilterFromDropdown();
		BondTalkPageObject.currencyFilterFromDropdown();
		BondTalkPageObject.ofaceFilterFromDropdown();
		BondTalkPageObject.vintageFilterFromDropdown();
		BondTalkPageObject.goToBondTalkTab();
	}
	
	@Test(priority=5)
	public static void addNote() throws InterruptedException{
		BondTalkPageObject.addNote94987UAL7("This is my First Add Note", "This is my Second Add Note","This is my Third Add Note");
		BondTalkPageObject.deleteNote();
		BondTalkPageObject.verifyAddNotePriceHistory();
		BondTalkPageObject.verifyThirdAddNote();
		BondTalkPageObject.goToBondTalkTab();
	}
	
	@Test(priority=6)
	public static void dealDetails() throws InterruptedException{
		BondTalkPageObject.verifyDealDetail();
		BondTalkPageObject.goToBondTalkTab();
	}
	
	@Test(priority=7)
	public static void corelogicAdditionalInfo() throws InterruptedException{
		BondTalkPageObject.verifyCorelogicInfo();
		BondTalkPageObject.goToBondTalkTab();
	}
	
	@Test(priority=8)
	public static void reportIssue() throws InterruptedException{
		BondTalkPageObject.reportIssueIncorrectDate();
		BondTalkPageObject.reportIssueSplitList();
		BondTalkPageObject.reportIssueMissingData();
		BondTalkPageObject.reportIssueOther();
		BondTalkPageObject.goToBondTalkTab();
	}
	
	@Test(priority=9)
	public static void checkBrokers() throws InterruptedException{
		BondTalkPageObject.verifyBrokers();		
		BondTalkPageObject.goToBondTalkTab();
	}
	
	@Test(priority=10)
	public void checkPriceTalkPopupDetails() throws InterruptedException {
		BondTalkPageObject.verifyPriceTalkPopUpHeader();
		BondTalkPageObject.verifyCoverDetails();
		BondTalkPageObject.verifyPriceTalkDetails();
		BondTalkPageObject.goToBondTalkTab();
	
	}
	
	@Test(priority=11)
	public void verifyTimezoneChanges() throws InterruptedException {
		Assert.assertEquals("07:00 AM", BondTalkPageObject.verifyPSTTimezone());
		Assert.assertEquals("10:00 AM", BondTalkPageObject.verifyESTTimezone());
		Assert.assertEquals("02:00 PM", BondTalkPageObject.verifyGMTTimezone());
		Assert.assertEquals("10:00 AM", BondTalkPageObject.verifyESTTimezone());
		BondTalkPageObject.goToBondTalkTab();
	
	}
	
//	@Test(priority=12)
	public void defaultSavedSearch() throws InterruptedException {
		BondTalkPageObject.goToSavedSearchesTab();
		BondTalkPageObject.verifySourceBwicDetails();
		SeleniumWebDriver.CloseDriver();
	
	}
	
//	@Test(priority=13)
//	public void verifySourceBwicsCapstone() throws InterruptedException {
//		BondTalkPageObject.goToPrivateBondTalk();
//		BondTalkPageObject.verifySourceBwicDetails();
//		SeleniumWebDriver.CloseDriver();
//	
//	}
	
	
	
	
	
	
	
//	@Test
	public void testRequestFreeTrial() throws InterruptedException {
		BondTalkPageObject.goToPrivateBondTalk();
		BondTalkPageObject.goToFreeTrialTab();
		String popupText1=BondTalkPageObject.requestFreeTrialLink("request_bodtalk_trial");
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(popupText1,"Thank you for your interest"));
//		Assert.assertNotNull(BondTalkPageObject.requestFreeTrialLink("request_bodtalk_trial"), CoreMatchers..anything("Thank you for your interest"));
//		assertThat(BondTalkPageObject.requestFreeTrialLink("request_bodtalk_trial"), CoreMatchers.containsString("Thank you for your interest"));
		BondTalkPageObject.scrollDownToId("bt_request_link");
		String popupText2=BondTalkPageObject.requestFreeTrialLink("bt_request_link");
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(popupText2,"Thank you for your interest"));
//		assertThat(BondTalkPageObject.requestFreeTrialLink("bt_request_link"), CoreMatchers.containsString("Thank you for your interest"));
		SeleniumWebDriver.CloseDriver();
			
	}
	

//	@Test(priority=4)
	public void testBwicAlertConfig() throws InterruptedException {
		BondTalkPageObject.goToPrivateBondTalk();
		BondTalkPageObject.goToSavedSearchesTab();
		BondTalkPageObject.alertFrequencyRealTime();
		//Assert.assertEquals(actual, expected);
//		Assert.assertEquals("Real Time", BondTalkPageObject.alertFrequencyRealTime());
//		Assert.assertEquals("3x Daily", BondTalkPageObject.alertFrequencyThriceDaily());
//		Assert.assertEquals("Daily", BondTalkPageObject.alertFrequencyDaily());
//		Assert.assertEquals("Off", BondTalkPageObject.alertFrequencyOff());
		SeleniumWebDriver.CloseDriver();
	}
	
			
}


