package junit.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import selenium.pageobject.AdminPageObject;
import selenium.pageobject.DealCenterPageObject;
import selenium.pageobject.OverviewPageObject;
import selenium.utils.SeleniumWebDriver;
/* Total 37 test cases*/
//@Listeners(junit.tests.EmailableReporter2.class)
public class DealCenter {
	
	private DealCenterPageObject dealcenterpageobj; 
	public DealCenter()
	 {
		 this.dealcenterpageobj = new DealCenterPageObject();
	 }
	
//	@Test(priority=1)	
//	public void SharedDealCenter() throws InterruptedException{
//		AdminPageObject.goToAdminAccount();
//		AdminPageObject.goToSdcPage();
//		AdminPageObject.createNewGroup();
//		AdminPageObject.enterSdcName("Automated SDC");
//		AdminPageObject.enterManagerName("abc2@capital.com");
//		AdminPageObject.enterChildrenName("abc3@capital.com");
//		AdminPageObject.enterChildrenName("abc4@capital.com");
//		AdminPageObject.enterChildrenName("abc5@capital.com");
//		AdminPageObject.enterLeadManagerName("abc1@capital.com");
//		AdminPageObject.submitSDC();
//		Assert.assertEquals("Privileges", AdminPageObject.successText());
//		SeleniumWebDriver.CloseDriver();
//	}
//	
//	@Test(priority=2)
//	public void VerifyChildrenAccount() throws InterruptedException{
//		DealCenterPageObject.goToChildrenAccount();
//		DealCenterPageObject.goToDealCentrePage();
//		Assert.assertEquals("5,000,000_24%", DealCenterPageObject.totalOfaceSeries2014Holdings());
//		Assert.assertEquals("3,000,000_25%", DealCenterPageObject.totalOfaceSeries2014HoldingsA1());
//		Assert.assertEquals("2,000,000_22%", DealCenterPageObject.totalOfaceSeries2014HoldingsA2());
//		Assert.assertEquals("3,400,000_19%", DealCenterPageObject.totalOfaceSeries2016Holdings());
//		Assert.assertEquals("1,900,000_21%", DealCenterPageObject.totalOfaceSeries2016HoldingsA1());
//		Assert.assertEquals("1,500,000_17%", DealCenterPageObject.totalOfaceSeries2016HoldingsA2());
//		Assert.assertEquals("CHAIT 2013-A6 A6 (161571GA6)--Mgr./Issuer |", DealCenterPageObject.dealInfoCHAIT());
//		Assert.assertEquals("DCENT 2014-A1 A1 (254683BG9)--Mgr./Issuer |", DealCenterPageObject.dealInfoDCENT());
//		Assert.assertEquals("ABS, CDO | Edit", DealCenterPageObject.assetClassInfo());
//		SeleniumWebDriver.CloseDriver();
//
//	}
//	
//	@Test(priority=3)
//	public void VerifyLeadManagerAccount() throws InterruptedException{
//		DealCenterPageObject.goToLeadMangerAccount();
//		DealCenterPageObject.goToDealCentrePage();
//		Assert.assertEquals("5,000,000_24%", DealCenterPageObject.totalOfaceSeries2014Holdings());
//		Assert.assertEquals("3,000,000_25%", DealCenterPageObject.totalOfaceSeries2014HoldingsA1());
//		Assert.assertEquals("2,000,000_22%", DealCenterPageObject.totalOfaceSeries2014HoldingsA2());
//		Assert.assertEquals("3,400,000_19%", DealCenterPageObject.totalOfaceSeries2016Holdings());
//		Assert.assertEquals("1,900,000_21%", DealCenterPageObject.totalOfaceSeries2016HoldingsA1());
//		Assert.assertEquals("1,500,000_17%", DealCenterPageObject.totalOfaceSeries2016HoldingsA2());
//		Assert.assertEquals("CHAIT 2013-A6 A6 (161571GA6)--Mgr./Issuer |", DealCenterPageObject.dealInfoCHAIT());
//		Assert.assertEquals("DCENT 2014-A1 A1 (254683BG9)--Mgr./Issuer |", DealCenterPageObject.dealInfoDCENT());
//		Assert.assertEquals("ABS, CDO | Edit", DealCenterPageObject.assetClassInfo());
//		SeleniumWebDriver.CloseDriver();
//
//	}
//	
//	@Test(priority=4)
//	public void VerifyManagerAccount() throws InterruptedException{
//		DealCenterPageObject.goToMangerAccount();
//		DealCenterPageObject.goToDealCentrePage();
//		Assert.assertEquals("5,000,000_24%", DealCenterPageObject.totalOfaceSeries2014Holdings());
//		Assert.assertEquals("3,000,000_25%", DealCenterPageObject.totalOfaceSeries2014HoldingsA1());
//		Assert.assertEquals("2,000,000_22%", DealCenterPageObject.totalOfaceSeries2014HoldingsA2());
//		Assert.assertEquals("3,400,000_19%", DealCenterPageObject.totalOfaceSeries2016Holdings());
//		Assert.assertEquals("1,900,000_21%", DealCenterPageObject.totalOfaceSeries2016HoldingsA1());
//		Assert.assertEquals("1,500,000_17%", DealCenterPageObject.totalOfaceSeries2016HoldingsA2());
//		Assert.assertEquals("CHAIT 2013-A6 A6 (161571GA6)--Mgr./Issuer |", DealCenterPageObject.dealInfoCHAIT());
//		Assert.assertEquals("DCENT 2014-A1 A1 (254683BG9)--Mgr./Issuer |", DealCenterPageObject.dealInfoDCENT());
//		Assert.assertEquals("ABS, CDO | Edit", DealCenterPageObject.assetClassInfo());
//		SeleniumWebDriver.CloseDriver();
//
//	}
//	
//	
//	@Test(priority=5)
//	public void childrenAccountAddDealFlow	() throws InterruptedException{
//		DealCenterPageObject.goToChildrenAccount();
//		
//		//Assert.assertEquals("Read-Only Access", OverviewPageObject.addDealRecentActivity());
//		//System.out.println("Recent Activity");    ---> Bug fix is required.
//		//Assert.assertEquals("Read-Only Access", OverviewPageObject.addDealMostAffiliations());
//		//System.out.println("Most Affiliation Tab");  ---> Bug fix is required
//		//Assert.assertEquals("Read-Only Access", OverviewPageObject.addDealMarketSurveillance());
//		DealCenterPageObject.goToDealCentrePage();
//		Assert.assertEquals("Read-Only Access", DealCenterPageObject.addDealButton());
//		Assert.assertEquals("Read-Only Access", DealCenterPageObject.followAssetClass());
//		Assert.assertEquals("Read-Only Access", DealCenterPageObject.editDealRole());
//		DealCenterPageObject.goToRecommendedPage();
//		Assert.assertEquals("Read-Only Access", OverviewPageObject.addDealRecentActivityRecommended());
//		Assert.assertEquals("Read-Only Access", OverviewPageObject.addDealMostAffiliationsRecommended());
//		SeleniumWebDriver.CloseDriver();
//		
//	}
//	
///*	
//	
//	@Test(priority=6)
//	public void generateBallot() throws InterruptedException {
//		DealCenterPageObject.goToInvestorsAccount();
//		DealCenterPageObject.goToDealCentrePage();
//		DealCenterPageObject.completeBallot();
//		SeleniumWebDriver.CloseDriver();
//
//	}
//	
//	@Test(priority=7)
//	public void populateBallotInInvestorsAccount() throws InterruptedException {
//		DealCenterPageObject.goToInvestorsAccount();
//		DealCenterPageObject.goToDealCentrePage();
//		Assert.assertEquals("Vote for Maturity Extension.--Deadline: Nov 4th, 2016", DealCenterPageObject.goToSeriesPage());
//		DealCenterPageObject.goToCompleteBallotPage();
//		DealCenterPageObject.selectCustodian();
//		Assert.assertEquals("3,200,000", DealCenterPageObject.getHoldingsForA1());
//		Assert.assertEquals("6,000,000", DealCenterPageObject.getHoldingsForA2());
//		Assert.assertEquals("Richard Hedge Fund", DealCenterPageObject.getBeneficialOwnerName());
//		Assert.assertEquals("Richard Denero", DealCenterPageObject.getSignedByName());
//		Assert.assertEquals("Richard Title", DealCenterPageObject.getSignedByTitle());
//		SeleniumWebDriver.CloseDriver();
//
//	}
//	
////	@Test(priority=4)
//	public void editBallot() throws InterruptedException {
//		System.out.println("Running Sdit Ballot Test Case");
//		DealCenterPageObject.goToInvestorsAccount();
//		DealCenterPageObject.goToDealCentrePage();
//		DealCenterPageObject.goToSeriesPage();
//		DealCenterPageObject.goToCompleteBallotPage();
//		DealCenterPageObject.selectCustodian();
////		DealCenterPageObject.getHoldingsForA1();
////		DealCenterPageObject.getHoldingsForA2();
////		DealCenterPageObject.getBeneficialOwnerName();
////		DealCenterPageObject.getSignedByName();
////		DealCenterPageObject.getSignedByTitle();
//		DealCenterPageObject.clickOnGenerateBallot();
//		Assert.assertEquals("Step 2 of 2:", DealCenterPageObject.getConfirmationText());
//		DealCenterPageObject.clickOnEditBallot();
////		SeleniumWebDriver.CloseDriver();
//
//	} 
//	*/
	@Test(priority=8)
	public void AddDealFlow() throws InterruptedException{
		
		this.dealcenterpageobj.gotoAddDealUserAccount(); 
		DealCenterPageObject.goToDealCentrePage();
		
		Assert.assertEquals("SVHE 2007-OPT3 M9 (83612KAP6)_Inst. Investor |",this.dealcenterpageobj.AddDealasInstInvestor());
		Assert.assertEquals("WFHET 2006-3 B3 (9497EBAM1)_Ind. Investor |",this.dealcenterpageobj.AddDealasIndInvestor());
		Assert.assertEquals("SASC 2007-BC3 M8 (86363WAW9)_Advisor |",this.dealcenterpageobj.AddDealasAdvisor());
		Assert.assertEquals("SASC 2005-NC2 M10 (86359DCW5)_Broker/Dealer |", this.dealcenterpageobj.AddDealasBroker());
		Assert.assertEquals("SARM 2007-7 M3 (86364DAY6)_Trustee |",this.dealcenterpageobj.AddDealasTrustee());
		Assert.assertEquals("SAMI 2006-AR8 B9 (86361WAV3)_Mgr./Issuer |",this.dealcenterpageobj.AddDealasIssuer());
		Assert.assertEquals("SAMI 2006-AR7 B7 (86361HBA1)_Underwriter |",this.dealcenterpageobj.AddDealasUnderwriter());
		Assert.assertEquals("SABR 2007-BR5 B1 (81379EAK8)_Custodian |",this.dealcenterpageobj.AddDealasCustodian());
		Assert.assertEquals("SABR 2007-BR4 B3 (81378EAM5)_Watching |",this.dealcenterpageobj.AddDealasWatching());
		Assert.assertEquals("ALESCO PREFERRED FUNDING IV LTD_Lawyer_Investor",this.dealcenterpageobj.AddDealasLawyer_Investor()); 
		Assert.assertEquals("ALESCO PREFERRED FUNDING IV LTD CL A2 (01448QAB6)_Lawyer_Broker",this.dealcenterpageobj.AddDealasLawyer_Broker());
		Assert.assertEquals("ALESCO PREFERRED FUNDING IV LTD CL A3 (01448QAC4)_Lawyer_Principal/Manager", this.dealcenterpageobj.AddDealasLawyer_PrincipleManager());
		Assert.assertEquals("ALESCO PREFERRED FUNDING IV LTD CL B1 (01448QAD2)_Lawyer_Financial Advisor",this.dealcenterpageobj.AddDealasLawyer_FinancialAdvisor());
		Assert.assertEquals("ALESCO PREFERRED FUNDING IV LTD_Lawyer_Analyst (Buy Side)",this.dealcenterpageobj.AddDealasLawyer_Analyst_BuySide());
		Assert.assertEquals("ALESCO PREFERRED FUNDING IV LTD CL B3 (01448QAF7)_Lawyer_Analyst (Sell Side)",this.dealcenterpageobj.AddDealasLawyer_Analyst_SellSide());
		Assert.assertEquals("ALESCO PREFERRED FUNDING IV LTD CL COM1 (01448RAA6)_Lawyer_Trustee",this.dealcenterpageobj.AddDealasLawyer_Trustee());
		Assert.assertEquals("ALESCO PREFERRED FUNDING IV LTD CL COM2 (01448RAB4)_Lawyer_Issuer",this.dealcenterpageobj.AddDealasLawyer_Issuer());
		Assert.assertEquals("ALESCO PREFERRED FUNDING IV LTD CL COM3 (01448RAC2)_Lawyer_Underwriter",this.dealcenterpageobj.AddDealasLawyer_Underwriter());
		SeleniumWebDriver.CloseDriver();
		
		
	}
	
	
}























