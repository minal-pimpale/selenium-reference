package junit.tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.pageobject.BondTalkPageObject;
import selenium.pageobject.MessageCentrePageObject;
import selenium.pageobject.OfferPageObject;
import selenium.utils.SeleniumWebDriver;

public class Offer {
	
	
	@Test(priority=1)
	public void testOfferFilter() throws InterruptedException {
		BondTalkPageObject.goToPrivateBondTalk();
		OfferPageObject.goToOfferTab();
		OfferPageObject.offerEditColumn("FromHeader");
		OfferPageObject.testClassFilter();
		OfferPageObject.testDealFilter();
		OfferPageObject.testNumericIdFilter(0);
		OfferPageObject.testNumericIdFilter(1);
		OfferPageObject.testCurrencyFilter(0);
		OfferPageObject.testCurrencyFilter(1);
		OfferPageObject.testOfaceFilter(0);
		OfferPageObject.testOfaceFilter(1);
		OfferPageObject.testCfaceFilter(0);
		OfferPageObject.testCfaceFilter(1);
		OfferPageObject.testOfferPriceFilter(0);
		OfferPageObject.testOfferPriceFilter(1);
		OfferPageObject.testOfferSpreadFilter(0);
		OfferPageObject.testOfferSpreadFilter(1);
		OfferPageObject.testOfferYieldFilter(0);
		OfferPageObject.testOfferYieldFilter(1);
		OfferPageObject.testAttachFilter(0);
		OfferPageObject.testAttachFilter(1);
		OfferPageObject.testDetachFilter(0);
		OfferPageObject.testDetachFilter(1);
		OfferPageObject.testNumDaysFilter(0);
		OfferPageObject.testNumDaysFilter(1);
		OfferPageObject.testVintageFilter(0);
		OfferPageObject.testVintageFilter(1);
		OfferPageObject.testOrigRatingFilter(0);
		OfferPageObject.testOrigRatingFilter(1);
		OfferPageObject.testCurrRatingFilter(0);
		OfferPageObject.testCurrRatingFilter(1);
		OfferPageObject.testManagerFilter(0);
		OfferPageObject.testManagerFilter(1);
		OfferPageObject.testCouponFilter(0);
		OfferPageObject.testCouponFilter(1);
		OfferPageObject.testCreditEnhancementFilter(0);
		OfferPageObject.testCreditEnhancementFilter(1);
		OfferPageObject.testCollatFilter(0);
		OfferPageObject.testCollatFilter(1);
		OfferPageObject.testMvocFilter(0);
		OfferPageObject.testMvocFilter(1);
		SeleniumWebDriver.CloseDriver();		
    }
	
//	@Test(priority=2)
	public void testOfferDownloadExcel() throws InterruptedException {
		BondTalkPageObject.goToPrivateBondTalk();
		SeleniumWebDriver.CloseDriver();		
    }

}
