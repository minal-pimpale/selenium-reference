package junit.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import selenium.pageobject.BondTalkPageObject;
import selenium.pageobject.MessageCentrePageObject;
import selenium.pageobject.OfferPageObject;
import selenium.pageobject.MarketPageObject;
import selenium.utils.SeleniumWebDriver;

public class Market {
	
	@Test(priority=1)
	public void testMarketFilter() throws InterruptedException {
		BondTalkPageObject.goToPrivateBondTalk();
		MarketPageObject.goToMarketTab();
		MarketPageObject.MarketEditColumn("FromHeader");
		MarketPageObject.testClassFilter();
		MarketPageObject.testDealFilter();
		MarketPageObject.testNumericIdFilter(0);
		MarketPageObject.testNumericIdFilter(1);
		MarketPageObject.testCurrencyFilter(0);
		MarketPageObject.testCurrencyFilter(1);
		MarketPageObject.testBidOfaceFilter(0);
		MarketPageObject.testBidOfaceFilter(1);
		MarketPageObject.testOfferOfaceFilter(0);
		MarketPageObject.testOfferOfaceFilter(1);
		MarketPageObject.testBidPriceFilter(0);
		MarketPageObject.testBidPriceFilter(1);
		MarketPageObject.testOfferPriceFilter(0);
		MarketPageObject.testOfferPriceFilter(1);
		MarketPageObject.testBidSpreadFilter(0);
		MarketPageObject.testBidSpreadFilter(1);
		MarketPageObject.testOfferSpreadFilter(0);
		MarketPageObject.testOfferSpreadFilter(1);
		MarketPageObject.testOfferYieldFilter(0);
		MarketPageObject.testOfferYieldFilter(1);
//		MarketPageObject.testAttachFilter(0);
//		MarketPageObject.testAttachFilter(1);
//		MarketPageObject.testDetachFilter(0);
//		MarketPageObject.testDetachFilter(1);
//		MarketPageObject.testNumDaysFilter(0);
//		MarketPageObject.testNumDaysFilter(1);
//		MarketPageObject.testVintageFilter(0);
//		MarketPageObject.testVintageFilter(1);
//		MarketPageObject.testOrigRatingFilter(0);
//		MarketPageObject.testOrigRatingFilter(1);
//		MarketPageObject.testCurrRatingFilter(0);
//		MarketPageObject.testCurrRatingFilter(1);
//		MarketPageObject.testManagerFilter(0);
//		MarketPageObject.testManagerFilter(1);
//		MarketPageObject.testCouponFilter(0);
//		MarketPageObject.testCouponFilter(1);
//		MarketPageObject.testCreditEnhancementFilter(0);
//		MarketPageObject.testCreditEnhancementFilter(1);
//		MarketPageObject.testCollatFilter(0);
//		MarketPageObject.testCollatFilter(1);
//		MarketPageObject.testMvocFilter(0);
//		MarketPageObject.testMvocFilter(1);
		SeleniumWebDriver.CloseDriver();		
    }

}
