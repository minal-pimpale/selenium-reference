package junit.tests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium.pageobject.ElectionPageObject;
import selenium.pageobject.ElectionOperations;
import WebElement.ElectionWebElement;
import selenium.utils.SeleniumWebDriver;


@Listeners(junit.tests.EmailableReporter2.class)
public class Election extends BaseTest {
	

	private ElectionOperations  ElectionOperationsObj;
	private ElectionPageObject  ElectionPageObjectObj;
	private ElectionWebElement  ElectionWebElementObj;
	public Election()
	{
		this.ElectionOperationsObj = new ElectionOperations();
		this.ElectionPageObjectObj = new ElectionPageObject();
		this.ElectionWebElementObj = new ElectionWebElement();
		
	}

	@Test(priority=1)
	public void verifyNavientActiveElectionDeatilsDvadmin() throws InterruptedException {
		ElectionPageObject.goToDvAdminElectionUser();
		Assert.assertEquals("Navient_BNY Election_2017-01-23_01-Dec", ElectionPageObject.verifyNavientElectionDetails());
		Assert.assertEquals("Alphabet 2015-2_250,000,000_22.4%_100%_1.72%_0%", ElectionPageObject.verifyAlpha2015_2Details());
		Assert.assertEquals("Alphabet 2015-2 CL A1 (63939GAA6)_150,000,000_21.33%_100%_1.4%_0%", ElectionPageObject.verifyAlpha2015_2A1Details());
		Assert.assertEquals("Alphabet 2015-2 CL A2 (63939GAB4)_100,000,000_24%_100%_2.2%_0%", ElectionPageObject.verifyAlpha2015_2A2Details());
		Assert.assertEquals("Alphabet 2016-1_400,000,000_22.3%_100%_0.3%_0%", ElectionPageObject.verifyAlpha2016_1Details());
		Assert.assertEquals("Alphabet 2016-1 CL A1 (63939DAA3)_200,000,000_24.75%_100%_0.27%_0%", ElectionPageObject.verifyAlpha2016_1A1Details());
		Assert.assertEquals("Alphabet 2016-1 CL A2 (63939DAB1)_200,000,000_19.85%_100%_0.33%_0%", ElectionPageObject.verifyAlpha2016_1A2Details());
		SeleniumWebDriver.CloseDriver();
}
	
	@Test(priority=2)
	public void verifyNavientActiveElectionDeatilsTabagent() throws InterruptedException {
		ElectionPageObject.goToTabagentElectionUser();
		Assert.assertEquals("Navient_BNY Election_2017-01-23_01-Dec", ElectionPageObject.verifyNavientElectionDetails());
		Assert.assertEquals("Alphabet 2015-2_250,000,000_22.4%_100%_1.72%_0%", ElectionPageObject.verifyAlpha2015_2Details());
		Assert.assertEquals("Alphabet 2015-2 CL A1 (63939GAA6)_150,000,000_21.33%_100%_1.4%_0%", ElectionPageObject.verifyAlpha2015_2A1Details());
		Assert.assertEquals("Alphabet 2015-2 CL A2 (63939GAB4)_100,000,000_24%_100%_2.2%_0%", ElectionPageObject.verifyAlpha2015_2A2Details());
		Assert.assertEquals("Alphabet 2016-1_400,000,000_22.3%_100%_0.3%_0%", ElectionPageObject.verifyAlpha2016_1Details());
		Assert.assertEquals("Alphabet 2016-1 CL A1 (63939DAA3)_200,000,000_24.75%_100%_0.27%_0%", ElectionPageObject.verifyAlpha2016_1A1Details());
		Assert.assertEquals("Alphabet 2016-1 CL A2 (63939DAB1)_200,000,000_19.85%_100%_0.33%_0%", ElectionPageObject.verifyAlpha2016_1A2Details());
		SeleniumWebDriver.CloseDriver();
}
	
	@Test(priority=3)
	public void verifyNavientActiveElectionDeatilsIssuer() throws InterruptedException {
		ElectionPageObject.goToIssuersElectionUser();
		Assert.assertEquals("Navient_BNY Election_2017-01-23_01-Dec", ElectionPageObject.verifyNavientElectionDetails());
		Assert.assertEquals("Alphabet 2015-2_250,000,000_22.4%_100%_1.72%_0%", ElectionPageObject.verifyAlpha2015_2Details());
		Assert.assertEquals("Alphabet 2015-2 CL A1 (63939GAA6)_150,000,000_21.33%_100%_1.4%_0%", ElectionPageObject.verifyAlpha2015_2A1Details());
		Assert.assertEquals("Alphabet 2015-2 CL A2 (63939GAB4)_100,000,000_24%_100%_2.2%_0%", ElectionPageObject.verifyAlpha2015_2A2Details());
		Assert.assertEquals("Alphabet 2016-1_400,000,000_22.3%_100%_0.3%_0%", ElectionPageObject.verifyAlpha2016_1Details());
		Assert.assertEquals("Alphabet 2016-1 CL A1 (63939DAA3)_200,000,000_24.75%_100%_0.27%_0%", ElectionPageObject.verifyAlpha2016_1A1Details());
		Assert.assertEquals("Alphabet 2016-1 CL A2 (63939DAB1)_200,000,000_19.85%_100%_0.33%_0%", ElectionPageObject.verifyAlpha2016_1A2Details());
		SeleniumWebDriver.CloseDriver();
}

	@Test(priority=4)
	public void verifyVotebyCustodianDetailsDvAdmin() throws InterruptedException {
		ElectionPageObject.goToDvAdminElectionUser();
		this.ElectionOperationsObj.gotoVotingTab(ElectionWebElement.XPATH_TO_NAVIENT_VOTE_BUTTON);
		this.ElectionOperationsObj.goToVoteByCustodian(ElectionWebElement.XPATH_TO_VOTE_BY_CUSTODIAN);
		Assert.assertEquals("ALASKA_BAML_BBH_BNP_BNY_CITI_COMERICA_JPM_MS_SSB", ElectionPageObject.verifyAllCustodianPresent());
		Assert.assertEquals("ALASKA_9/28/15_6,000,000_0_(0%)_6,000,000_4,000,000_2,000,000_(33%)_0", ElectionPageObject.verifyAlaskaFirmDetails());
		Assert.assertEquals("2223 - ALASKA USA FEDERAL..._9/28/15_6,000,000_0(0%)6,000,000_4,000,000_2,000,000_(33%)_0", ElectionPageObject.verifyAlaska2223Details());
		Assert.assertEquals("Alphabet 2015-2 CL A1 (63..._9/28/15_5,900,000_0_(0%)_5,900,000_2,000,000_3,900,000_(66%)_0", ElectionPageObject.verifyAlaska2223A1Details());
		Assert.assertEquals("DV5510_user1 n..._7CT6_0_(0%)_2,000,000_0", ElectionPageObject.verifyAlaska2223A1zvOnZb4Details());
		Assert.assertEquals("Alphabet 2015-2 CL A2 (63..._9/28/15_100,000_0_(0%)_100,000_2,000,000_-1,900,000_(-1900%)_0", ElectionPageObject.verifyAlaska2223A2Details());
		Assert.assertEquals("DV5510_user1 n..._7CT6_0_(0%)_2,000,000_0", ElectionPageObject.verifyAlaska2223A2zvOnZb4Details());
		SeleniumWebDriver.CloseDriver();
}


	// ---------------------------------------- Sharad Hadd Samapt ------------------------------------------//
	
	@Test(priority=5)
	public void verifyVotebyDealDetailsDvAdmin() throws InterruptedException{
		
		ElectionPageObject.goToDvAdminElectionUser();
		this.ElectionOperationsObj.gotoVotingTab(ElectionWebElement.XPATH_TO_NAVIENT_VOTE_BUTTON);
		
		Assert.assertEquals("Navient_BNY Election_12/01/2017",this.ElectionPageObjectObj.VerifyElectionDetails());
		Assert.assertEquals("Alphabet 2015-2_250,000,000_22.4%_300,000_(0%)_249,700,000_4,000,000_245,700,000_(98%)",this.ElectionPageObjectObj.VerifySeriesDetails_2015_2());
		Assert.assertEquals("Alphabet 2016-1_400,000,000_22.3%_470,000_(0%)_399,530,000_720,000_398,810,000_(100%)",this.ElectionPageObjectObj.VerifySeriesDetails_2016_1());
		
		this.ElectionOperationsObj.expandSeries(ElectionWebElement.XPATH_EXPAND_SERIES_2015_2);
		Assert.assertEquals("Alphabet 2015-2 CL A1(63939GAA6)_21.33%_150,000,000_100,000_(0%)_149,900,000_149,900,000_147,900,000_(99%)",this.ElectionPageObjectObj.VerifyDealDetails_2015_2A1());
		Assert.assertEquals("Alphabet 2015-2 CL A2(63939GAB4)_24%_100,000,000_200,000_(0%)_99,800,000_2,000,000_97,800,000_(98%)",this.ElectionPageObjectObj.VerifyDealDetails_2015_2A2());
		
		this.ElectionOperationsObj.expandDeal(ElectionWebElement.XPATH_EXPAND_DEAL_2015_2A1);
		this.ElectionOperationsObj.expandDeal(ElectionWebElement.XPATH_EXPAND_DEAL_2015_2A2);
		
		Assert.assertEquals("DV 5510_user1 n..._7CT6_0_(0%)_2,000,000",this.ElectionPageObjectObj.VerifyBallotDetails_7CT6());
		Assert.assertEquals("DV 5510_test1 user_8DW7_100,000_(0%)_0",this.ElectionPageObjectObj.VerifyBallotDetails_8DW7());
		Assert.assertEquals("DV 5510_user1 n..._7CT6_0_(0%)_2,000,000",this.ElectionPageObjectObj.VerifyBallotDetails_7CT6_A2());
		Assert.assertEquals("NA_user1 e..._9FY8_200,000_(0%)_0",this.ElectionPageObjectObj.VerifyBallotDetails_9FY8());
		
		
		Assert.assertEquals("user1 navient_user1@navient.com",this.ElectionPageObjectObj.VerifyDVDetails(ElectionWebElement.XPATH_7CT6_DV_ID ));
		Assert.assertEquals("Alphabet 2015-2 CL A1_2,000,000_Alphabet 2015-2 CL A2_2,000,000_2223 owner_user1 navient_2223 title_2223",this.ElectionPageObjectObj.VerifyBallotDetails());
		Assert.assertEquals("passed", this.ElectionPageObjectObj.VerifyNAUserDetails());
		
		SeleniumWebDriver.CloseDriver();
	}
	
	@Test(priority=6)
	public void VerifyCountBallot()
	{
		String ballot_id = "7CT6" ;
		ElectionPageObject.goToDvAdminElectionUser();
		this.ElectionOperationsObj.gotoVotingTab(ElectionWebElement.XPATH_TO_NAVIENT_VOTE_BUTTON);
		Assert.assertEquals("Congratulations. The ballot has been counted.",this.ElectionOperationsObj.CountBallot(ballot_id));
		SeleniumWebDriver.CloseDriver();
	}
	
	@Test(priority=7)
	public void verifyMissingVotesDetailsDvAdmin() throws InterruptedException
	{
		String user = "user1 navient";
		String deal_name = "Alphabet 2015-2 CL A2";
		ElectionPageObject.goToDvAdminElectionUser();
		this.ElectionOperationsObj.gotoVotingTab(ElectionWebElement.XPATH_TO_NAVIENT_VOTE_BUTTON);
		this.ElectionOperationsObj.gotoMissingVotesTab(ElectionWebElement.XPATH_TO_MISSING_VOTE_TAB);
		Assert.assertEquals("Navient_BNY Election_12/01/2017",this.ElectionPageObjectObj.VerifyElectionDetails());
		Reporter.log("Election details");
		Assert.assertEquals("Mike Manning_Mark Johnson_abc3 user_abc4 user_abc6 user",this.ElectionPageObjectObj.VerifyAllMembers());
		Reporter.log("Verify All members details ");
		Assert.assertEquals("user1 navient",this.ElectionPageObjectObj.VerifyUserFilter(user));
		Assert.assertEquals("Mike Manning_Mark Johnson_abc13 user_abc18 user_user1 navient",this.ElectionPageObjectObj.VerifyDealFilter(deal_name));
		Assert.assertEquals("Smart Funds_mmanning@smartfunds.com",this.ElectionPageObjectObj.VerifyDVDetails(ElectionWebElement.XPATH_DV_ID));
		this.ElectionPageObjectObj.VerifyResolveOption();
		Assert.assertEquals("Alphabet 2016-1 CL A1 (63..._Alphabet 2016-1 CL A1 (63..._-_-_40,000,000_Alphabet 2016-1 CL A2 (63..._30,000,000_-_-_30,000,000",this.ElectionPageObjectObj.VerifyDealLevelDetails());
		Assert.assertEquals("passed",this.ElectionPageObjectObj.VerifyShowResolved());
		SeleniumWebDriver.CloseDriver();	
		
	}
	
	
}
