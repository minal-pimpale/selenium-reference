package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.ElectionWebElement;

public class ElectionPageObject {


	public static void goToDvAdminElectionUser() {
		
		System.out.println("Login to Deal vector");
		
//		SeleniumWebDriver.InitializeIEDriver();
		
		LoginPage.Goto();
		LoginPage.LoginAs(ElectionWebElement.USERNAME_DVADMIN).WithPassword(ElectionWebElement.PASSWORD_DVADMIN).Login();
//		Assert.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector");
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ELECTION_TAB);
		SeleniumHelper.Navigate(BasePageObject.baseurl + "/election");								// Going to Election page
		
	}

	public static String verifyNavientElectionDetails() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_NAVIENT_ISSUER);
		String IssuerName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_NAVIENT_ISSUER)).getText();
		String ElectionName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_NAVIENT_ELECTION_NAME)).getText();
		String ElectionRecordDate = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_NAVIENT_RECORD_DATE)).getText(); 
		String DueDate = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_NAVIENT_DUEDATE)).getText();
		String NavientElectionDetails = IssuerName + "_" + ElectionName + "_" + ElectionRecordDate + "_" + DueDate;
		System.out.println(NavientElectionDetails);
		return NavientElectionDetails;
	}

	public static String verifyAlpha2015_2Details() {
	WebDriver webdriver = SeleniumWebDriver.Instance();
	ElectionOperations.expandNavientElection();
	SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALPHA2015_2_SERIES_NAME);
	String SeriesName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_SERIES_NAME)).getText();
	String TotalOface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_TOTAL_OFACE)).getText();
	String PercentReg = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_PERCENT_REG)).getText();
	String Threshold = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_THRESHOLD)).getText();
	String PercentYes = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_PERCENT_YES)).getText();
	String PercentNo = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_PERCENT_NO)).getText();
	String Alpha2015_2Details = SeriesName + "_" + TotalOface + "_" + PercentReg + "_" + Threshold + "_" + PercentYes + "_" + PercentNo;
	System.out.println(Alpha2015_2Details);
	return Alpha2015_2Details;
	}

	public static String verifyAlpha2015_2A1Details() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		ElectionOperations.expandAlpha2015_2();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A1_DEAL_NAME);
		String DealName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A1_DEAL_NAME)).getText();
		String TotalOface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A1_TOTAL_OFACE)).getText();
		String PercentReg = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A1_PERCENT_REG)).getText();
		String Threshold = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A1_THRESHOLD)).getText();
		String PercentYes = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A1_PERCENT_YES)).getText();
		String PercentNo = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A1_PERCENT_NO)).getText();
		String Alpha2015_2_A1Details = DealName + "_" + TotalOface + "_" + PercentReg + "_" + Threshold + "_" + PercentYes + "_" + PercentNo;
		System.out.println(Alpha2015_2_A1Details);
		return Alpha2015_2_A1Details;
	}

	public static String verifyAlpha2015_2A2Details() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A2_DEAL_NAME);
		String DealName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A2_DEAL_NAME)).getText();
		String TotalOface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A2_TOTAL_OFACE)).getText();
		String PercentReg = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A2_PERCENT_REG)).getText();
		String Threshold = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A2_THRESHOLD)).getText();
		String PercentYes = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A2_PERCENT_YES)).getText();
		String PercentNo = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2015_2_A2_PERCENT_NO)).getText();
		String Alpha2015_2_A2Details = DealName + "_" + TotalOface + "_" + PercentReg + "_" + Threshold + "_" + PercentYes + "_" + PercentNo;
		System.out.println(Alpha2015_2_A2Details);
		return Alpha2015_2_A2Details;
	}

	public static String verifyAlpha2016_1Details() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALPHA2016_1_SERIES_NAME);
		String SeriesName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_SERIES_NAME)).getText();
		String TotalOface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_TOTAL_OFACE)).getText();
		String PercentReg = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_PERCENT_REG)).getText();
		String Threshold = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_THRESHOLD)).getText();
		String PercentYes = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_PERCENT_YES)).getText();
		String PercentNo = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_PERCENT_NO)).getText();
		String Alpha2016_1Details = SeriesName + "_" + TotalOface + "_" + PercentReg + "_" + Threshold + "_" + PercentYes + "_" + PercentNo;
		System.out.println(Alpha2016_1Details);
		return Alpha2016_1Details;
	}

	public static String verifyAlpha2016_1A1Details() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		ElectionOperations.expandAlpha2016_1();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A1_DEAL_NAME);
		String SeriesName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A1_DEAL_NAME)).getText();
		String TotalOface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A1_TOTAL_OFACE)).getText();
		String PercentReg = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A1_PERCENT_REG)).getText();
		String Threshold = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A1_THRESHOLD)).getText();
		String PercentYes = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A1_PERCENT_YES)).getText();
		String PercentNo = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A1_PERCENT_NO)).getText();
		String Alpha2016_1_A1Details = SeriesName + "_" + TotalOface + "_" + PercentReg + "_" + Threshold + "_" + PercentYes + "_" + PercentNo;
		System.out.println(Alpha2016_1_A1Details);
		return Alpha2016_1_A1Details;
	}

	public static String verifyAlpha2016_1A2Details() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A2_DEAL_NAME);
		String SeriesName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A2_DEAL_NAME)).getText();
		String TotalOface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A2_TOTAL_OFACE)).getText();
		String PercentReg = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A2_PERCENT_REG)).getText();
		String Threshold = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A2_THRESHOLD)).getText();
		String PercentYes = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A2_PERCENT_YES)).getText();
		String PercentNo = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALPHA2016_1_A2_PERCENT_NO)).getText();
		String Alpha2016_1_A2Details = SeriesName + "_" + TotalOface + "_" + PercentReg + "_" + Threshold + "_" + PercentYes + "_" + PercentNo;
		System.out.println(Alpha2016_1_A2Details);
		return Alpha2016_1_A2Details;
	}

	public static void goToTabagentElectionUser() {
		System.out.println("Login to Deal vector");
		LoginPage.Goto();
		LoginPage.LoginAs(ElectionWebElement.USERNAME_TABAGENT).WithPassword(ElectionWebElement.PASSWORD_TABAGENT).Login();
//		Assert.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector");
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ELECTION_TAB);
		SeleniumHelper.Navigate(BasePageObject.baseurl + "/election");								// Going to Election page
		
	}

	public static void goToIssuersElectionUser() {
		System.out.println("Login to Deal vector");
		LoginPage.Goto();
		LoginPage.LoginAs(ElectionWebElement.USERNAME_ISSUER).WithPassword(ElectionWebElement.PASSWORD_ISSUER).Login();
//		Assert.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector");
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ELECTION_TAB);
		SeleniumHelper.Navigate(BasePageObject.baseurl + "/election");								// Going to Election page
				
	}
	
	public static String verifyAllCustodianPresent() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALASKA_CUSTODIAN);
		String Alaska = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_CUSTODIAN)).getText();
		String Baml = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_BAML_CUSTODIAN)).getText();
		String Bbh = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_BBH_CUSTODIAN)).getText();
		String Bnp = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_BNP_CUSTODIAN)).getText();
		String Bny = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_BNY_CUSTODIAN)).getText();
		String Citi = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_CITI_CUSTODIAN)).getText();
		String Comercia = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_COMERICA_CUSTODIAN)).getText();
		String Jpm = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_JPM_CUSTODIAN)).getText();
		String Ms = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_MS_CUSTODIAN)).getText();
		String Ssb = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_SSB_CUSTODIAN)).getText();
		String AllCustodianPresentDetails = Alaska + "_" + Baml + "_" + Bbh + "_" + Bnp + "_" + Bny + "_" + Citi + "_" + Comercia + "_" + Jpm + "_" + Ms + "_" + Ssb;
		System.out.println(AllCustodianPresentDetails);
		Thread.sleep(1000);
		return AllCustodianPresentDetails;
	}
	
	public static String verifyAlaskaFirmDetails() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALASKA_CUSTODIAN);
		String ALASKA = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_CUSTODIAN)).getText();
		String SPR = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_SPR_DATE)).getText();
		String Custodied = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_CUSTODIED_OFACE)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_YES_RCVD)).getText();
		String Yes_Rcvd_PERCENTAGE = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Short = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_YES_SHORT)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_YES_PND)).getText();
		String Yes_Net_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_YES_NET_PND)).getText();
		String Yes_Net_Pnd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_YES_NET_PND_PERCENTAGE)).getText();
		String No_Total = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_NO_TOTAL)).getText();
		String AlaskaFirmDetails = ALASKA + "_" + SPR + "_" + Custodied + "_" + Yes_Rcvd + "_" + Yes_Rcvd_PERCENTAGE + "_" + Yes_Short + "_" + Yes_Pnd + "_" + Yes_Net_Pnd + "_" + Yes_Net_Pnd_Percentage + "_" + No_Total;
		System.out.println(AlaskaFirmDetails);
		Thread.sleep(1000);
		return AlaskaFirmDetails;
	}

	public static String verifyAlaska2223Details() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		ElectionOperations.expandCustodian(ElectionWebElement.XPATH_TO_EXPAND_ALASKA);
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement. XPATH_TO_ALASKA_223);
		String Alaska2223 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223)).getText();
		String Alaska2223_SPR = webdriver.findElement(By.xpath(ElectionWebElement. XPATH_TO_ALASKA_223_SPR)).getText();
		String Custodied = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_CUSTODIED_OFACE)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Short = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_YES_SHORT)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_YES_PND)).getText();
		String Yes_Net_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_YES_NET_PND)).getText();
		String Yes_Net_Pnd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_YES_NET_PND_PERCENTAGE)).getText();
		String No_Total = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_NO_TOTAL)).getText();
		String Alaska2223Details = Alaska2223 + "_" + Alaska2223_SPR + "_" + Custodied + "_" + Yes_Rcvd + Yes_Rcvd_Percentage + Yes_Short + "_" + Yes_Pnd + "_" + Yes_Net_Pnd + "_" + Yes_Net_Pnd_Percentage + "_" + No_Total;
		System.out.println(Alaska2223Details);
		Thread.sleep(1000);
		return Alaska2223Details;
	}
	
	public static String verifyAlaska2223A1Details() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		ElectionOperations.expandSubCustodian(ElectionWebElement.XPATH_TO_EXPAND_ALASKA_223);
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALASKA_223_A1);
		String Alaska2223A1 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1)).getText();
		String Custodied = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_CUSTODIED_OFACE)).getText();
		String SPR = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_SPR)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Short = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_YES_SHORT )).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_YES_PND)).getText();
		String Yes_Net_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_YES_NET_PND)).getText();
		String Yes_Net_Pnd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_YES_NET_PND_PERCENTAGE)).getText();
		String No_Total = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_NO_TOTAL)).getText();
		String Alaska2223A1Details = Alaska2223A1 + "_" + SPR + "_" + Custodied + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" + Yes_Short + "_" + Yes_Pnd + "_" + Yes_Net_Pnd + "_" + Yes_Net_Pnd_Percentage + "_" + No_Total;
		System.out.println(Alaska2223A1Details);
		Thread.sleep(1000);
		return Alaska2223A1Details;
	}
	
	public static String verifyAlaska2223A1zvOnZb4Details() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		ElectionOperations.expandDeals(ElectionWebElement.XPATH_TO_EXPAND_ALASKA_223_A1);
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_7CT6_DVID);
		String Alaska2223A1zvOnZb4DVID = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_7CT6_DVID)).getText();
		String BenOwnerName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_7CT6_BEN_OWN_NAME)).getText();
		String baallotId = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_7CT6)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_7CT6_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_7CT6_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_7CT6_YES_PND)).getText();
		String No_Total = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A1_7CT6_NO_TOTAL)).getText();
		String Alaska2223A1ballotDetails = Alaska2223A1zvOnZb4DVID + "_" + BenOwnerName + "_" + baallotId + "_" + Yes_Rcvd + "_"+ Yes_Rcvd_Percentage + "_" + Yes_Pnd + "_" + No_Total;
		System.out.println(Alaska2223A1ballotDetails);
		Thread.sleep(1000);
		return Alaska2223A1ballotDetails;
	}
	
	
	public static String verifyAlaska2223A2Details() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_ALASKA_223_A2);
		String Alaska2223A2 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2)).getText();
		String SPR = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_SPR)).getText();
		String Custodied = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_CUSTODIED_OFACE)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_YES_RCVD_PERCENTAGE)).getText();
	    String Yes_Short= webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_YES_SHORT)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_YES_PND)).getText();
		String Yes_Net_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_YES_NET_PND)).getText();
		String Yes_Net_Pnd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_YES_NET_PND_PERENTAGE)).getText();
		String No_Total = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_NO_TOTAL)).getText();
		String Alaska2223A2Details = Alaska2223A2 + "_" + SPR + "_" + Custodied + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" + Yes_Short + "_" + Yes_Pnd + "_" + Yes_Net_Pnd + "_" + Yes_Net_Pnd_Percentage + "_" + No_Total;
		System.out.println(Alaska2223A2Details);
		Thread.sleep(1000);
		return Alaska2223A2Details;
	}
	
	public static String verifyAlaska2223A2zvOnZb4Details() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		ElectionOperations.expandDeals(ElectionWebElement.XPATH_TO_EXPAND_ALASKA_223_A2);
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_EXPAND_ALASKA_223_A2);
		String Alaska2223A2zvOnZb4DVID = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_7CT6_DVID)).getText();
		String BenOwnerName = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_7CT6_BEN_OWN_NAME)).getText();
		String baallotId = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_7CT6)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_7CT6_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_7CT6_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_ALASKA_223_A2_7CT6_YES_PND)).getText();
		String No_Total = webdriver.findElement(By.xpath(ElectionWebElement. XPATH_TO_ALASKA_223_A2_7CT6_NO_TOTAL)).getText();
		String Alaska2223A12ballotDetails = Alaska2223A2zvOnZb4DVID + "_" + BenOwnerName + "_" + baallotId + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" + Yes_Pnd + "_" + No_Total;
		System.out.println(Alaska2223A12ballotDetails);
		Thread.sleep(1000);
		return Alaska2223A12ballotDetails;
	}
	
	// ---------------------------------------- Sharad Hadd Samapt ------------------------------------------//
	
	public String VerifyElectionDetails() {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_ISSUER_NAME);
		 String Issuer_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_ISSUER_NAME)).getText();
		 String Election_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_ELECTION_NAME)).getText();
		 String Election_Deadline = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_ELECTION_DEADLINE)).getText();
		 
		 String Election_Info = Issuer_Name + "_" + Election_Name + "_" + Election_Deadline;
		 System.out.println(Election_Info);
		 return Election_Info; 
	}

	public String VerifySeriesDetails_2015_2() {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String Series_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_SERIES_NAME)).getText();
		String Total_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_TOTAL_OFACE)).getText();
		String Reg_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_REG)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage =  webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Short = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_YES_SHORT)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_YES_PND)).getText();
		String Net_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_YES_NET_PND)).getText();
		String Net_Pnd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_NET_PND_PERCENTAGE)).getText();
		
		String Series_Details = Series_Name + "_" + Total_Oface + "_" + Reg_Percentage + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" + Yes_Short + "_" + Yes_Pnd + "_" + Net_Pnd  + "_" + Net_Pnd_Percentage;
		System.out.println(Series_Details);
		return Series_Details; 
	}

	public String VerifySeriesDetails_2016_1() {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String Series_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2016_1_SERIES_NAME)).getText();
		String Total_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2016_1_TOTAL_OFACE)).getText();
		String Reg_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2016_1_REG)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2016_1_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2016_1_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Short = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2016_1_YES_SHORT)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2016_1_YES_PND)).getText();
		String Net_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2016_1_NET_PND)).getText();
		String Net_Pnd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2016_1_NET_PND_PERCENTAGE)).getText();
		
		String Series_Details = Series_Name + "_" + Total_Oface + "_" + Reg_Percentage + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" + Yes_Short + "_" + Yes_Pnd + "_" + Net_Pnd  + "_" + Net_Pnd_Percentage;
		System.out.println(Series_Details);
		return Series_Details; 
	}

	public String VerifyDealDetails_2015_2A1() {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String Deal_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A1_DEAL_NAME)).getText();
		String Total_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A1_TOTAL_OFACE)).getText();
		String Reg_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A1_REG)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A1_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A1_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Short = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A1_YES_SHORT)).getText() ; 
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A1_YES_PND)).getText();
		String Net_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A1_NET_PND )).getText();
		String Net_Pnd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A1_NET_PND_PERCENTAGE )).getText();
		
		String Deal_Details = Deal_Name + "_" + Total_Oface + "_" + Reg_Percentage + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" +  Yes_Short + "_" + Yes_Pnd + "_" + Net_Pnd + "_" + Net_Pnd_Percentage;
		System.out.println(Deal_Details);
		return Deal_Details; 
		
	}

	public String VerifyDealDetails_2015_2A2() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String Deal_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A2_DEAL_NAME)).getText();
		String Total_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A2_TOTAL_OFACE)).getText();
		String Reg_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A2_REG)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A2_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A2_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Short = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A2_YES_SHORT)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A2_YES_PND)).getText();
		String Net_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A2_NET_PND)).getText();
		String Net_Pnd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_2015_2_A2_NET_PND_PERCENTAGE )).getText();
		
		String Deal_Details = Deal_Name + "_" + Total_Oface + "_" + Reg_Percentage + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" +  Yes_Short + "_" + Yes_Pnd + "_" + Net_Pnd + "_" + Net_Pnd_Percentage;
		System.out.println(Deal_Details);
		return Deal_Details; 
		
	}


	public String VerifyBallotDetails_7CT6(){
		
			WebDriver webdriver = SeleniumWebDriver.Instance();

			String DV_Id = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_DV_ID )).getText();
			String Beneficial_Owner_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_BENEFICIAL_OWNER_NAME)).getText();
			String Ballot_Code= webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_BALLOT_ID)).getText();
			String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_YES_RCVD)).getText();
			String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_YES_RCVD_PERCENTAGE)).getText();
			String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_YES_PND)).getText();
			
			String Ballot_Details =  DV_Id + "_" + Beneficial_Owner_Name + "_" + Ballot_Code + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" + Yes_Pnd ;
			System.out.println(Ballot_Details);		
			return Ballot_Details;
		
		
	}

	public String VerifyBallotDetails_8DW7(){
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String DV_Id = webdriver.findElement(By.xpath(ElectionWebElement. XPATH_8DW7_DV_ID)).getText();
		String Beneficial_Owner_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_8DW7_BENEFICIAL_OWNER_NAME)).getText();
		String Ballot_Code= webdriver.findElement(By.xpath(ElectionWebElement.XPATH_8DW7_BALLOT_ID)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_8DW7_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_8DW7_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_8DW7_YES_PND)).getText();
		
		String Ballot_Details =  DV_Id + "_" + Beneficial_Owner_Name + "_" + Ballot_Code + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" + Yes_Pnd ;
		System.out.println(Ballot_Details);	
		return Ballot_Details;
	}
	
	public String VerifyBallotDetails_7CT6_A2(){
		
		WebDriver webdriver = SeleniumWebDriver.Instance();

		String DV_Id = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_A2_DV_ID)).getText();
		String Beneficial_Owner_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_A2_BENEFICIAL_OWNER_NAME)).getText();
		String Ballot_Code= webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_A2_BALLOT_ID)).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_A2_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_A2_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_A2_YES_PND )).getText();
	
		
		String Ballot_Details =  DV_Id + "_" + Beneficial_Owner_Name + "_" + Ballot_Code + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" + Yes_Pnd ;
		System.out.println(Ballot_Details);		
		return Ballot_Details;
	
	
   }

	public String VerifyBallotDetails_9FY8(){
		
		WebDriver webdriver = SeleniumWebDriver.Instance();

		String DV_Id = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_NA_9FY8_DV_ID )).getText();
		String Beneficial_Owner_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_9FY8_BENEFICIAL_OWNER_NAME)).getText();
		String Ballot_Code= webdriver.findElement(By.xpath(ElectionWebElement.XPATH_9FY8_BALLOT_ID )).getText();
		String Yes_Rcvd = webdriver.findElement(By.xpath(ElectionWebElement. XPATH_9FY8_YES_RCVD)).getText();
		String Yes_Rcvd_Percentage = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_9FY8_YES_RCVD_PERCENTAGE)).getText();
		String Yes_Pnd = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_9FY8_YES_PND )).getText();
				
		String Ballot_Details =  DV_Id + "_" + Beneficial_Owner_Name + "_" + Ballot_Code + "_" + Yes_Rcvd + "_" + Yes_Rcvd_Percentage + "_" + Yes_Pnd  ;
		System.out.println(Ballot_Details);		
		return Ballot_Details;
		
	}

	public String VerifyDVDetails(String DV_ID_Xpath) {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.xpath(DV_ID_Xpath)).click();   // click on DV ID 
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_DV_NAME);
		String Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_DV_NAME)).getText();
		String Email =webdriver.findElement(By.xpath(ElectionWebElement.XPATH_DV_EMAIL)).getText();
		
		String DV_Details = Name + "_" + Email; 
		System.out.println(DV_Details);
		return DV_Details;
	}

	public String VerifyNAUserDetails(){
		
		String DV_Details = null; 
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_NA_9FY8_DV_ID);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_NA_9FY8_DV_ID )).click();   // click on DV ID 
		String Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_DV_NAME)).getText();
		System.out.println("->"+Name+"<-");
		String Email =webdriver.findElement(By.xpath(ElectionWebElement.XPATH_DV_EMAIL)).getText();
		System.out.println(Email);
		if (Name.isEmpty()  & Email.isEmpty())
		{
			DV_Details = "passed"; 
			
		}
		else 
		{
			DV_Details = "failed"; 
		}
		System.out.println(DV_Details);
		return DV_Details;
		
	}

	public String VerifyBallotDetails() throws InterruptedException {
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_DV_ID )).click(); 
		Thread.sleep(3000);
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_7CT6_BALLOT_ID);
		 webdriver.findElement(By.xpath(ElectionWebElement.XPATH_7CT6_BALLOT_ID)).click();
		 Thread.sleep(3000);
		 SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_BALLOT_SERIES_NAME_A1);
		 String Series_1 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_BALLOT_SERIES_NAME_A1)).getText();
		 String Series_2 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_BALLOT_SERIES_NAME_A2)).getText();
		 String Oface_1 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_BALLOT_SERIES_OFACE_A1)).getText();
		 String Oface_2 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_BALLOT_SERIES_OFACE_A2)).getText();
		 String Beneficial_Owner = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_BALLOT_BENEFICIAL_OWNER)).getText();
		 String Signed_Name = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_BALLOT_SIGNED_NAME)).getText();
		 String Signed_Title = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_BALLOT_SIGNED_TITLE)).getText();
		 String DTC_Participant = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_BALLOT_DTC_PARTICIPANT_ID)).getText();
		 webdriver.findElement(By.xpath(ElectionWebElement.XPATH_BALLOT_CLOSE_BUTTON)).click();
		 
		 String Ballot_Details =  Series_1 + "_" + Oface_1 + "_"+ Series_2 + "_" + Oface_2 + "_" + Beneficial_Owner + "_" + Signed_Name + "_" + Signed_Title + "_" + DTC_Participant;
		  return Ballot_Details; 
	}

	public String VerifyAllMembers() {
		// TODO Auto-generated method stub
		 WebDriver webdriver = SeleniumWebDriver.Instance();
		 String Member1 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER1)).getText();
		 String Member2 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER2)).getText();
		 String Member3 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER3)).getText();
		 String Member4 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER4)).getText();
		 String Member5 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER5)).getText();
				 
		 String Member_Details = Member1 + "_" + Member2 + "_" + Member3 + "_" + Member4 + "_" + Member5  ; 
		 System.out.println("VerifyAllMembers passed");
		 return(Member_Details);
		 
	}

	public String VerifyUserFilter(String user) {
		// TODO Auto-generated method stub
	    WebDriver webdriver = SeleniumWebDriver.Instance();
	    SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_FILTER_INPUT_BOX);
	    webdriver.findElement(By.xpath(ElectionWebElement.XPATH_FILTER_INPUT_BOX)).sendKeys(user);   // enter member's name 
	    //verify member's name 
	     String Member_details  = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER1)).getText();
	     System.out.println("VerifyUserFilter passed");
		 return(Member_details);
	}

	public String VerifyDealFilter(String deal_name) {
		// TODO Auto-generated method stub
		 WebDriver webdriver = SeleniumWebDriver.Instance();
		 Select filter_dropdown = new Select(webdriver.findElement(By.xpath(ElectionWebElement.XPATH_FILTER_dropdown)));
		 filter_dropdown.selectByValue("deal");
		 SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_FILTER_INPUT_BOX);
		 webdriver.findElement(By.xpath(ElectionWebElement.XPATH_FILTER_INPUT_BOX)).sendKeys(deal_name);
		 
		 String Member1 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER1)).getText();
		 String Member2 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER2_deal_filter)).getText();
		 String Member3 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER3_deal_filter)).getText();
		 String Member4 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER4_deal_filter)).getText();
		 String Member5 = webdriver.findElement(By.xpath(ElectionWebElement.MEMBER5_deal_filter)).getText();		 
		 String Member_Details = Member1 + "_" + Member2 + "_" + Member3 + "_" + Member4 + "_" + Member5;
		 
		 //reset filter 
		 filter_dropdown.selectByValue("user");
		 System.out.println("VerifyDealFilter passed");
		 return (Member_Details);
	}

	public void VerifyResolveOption() {
		// TODO Auto-generated method stub
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_Alphabet2015_A1_Resolve_Checkbox);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Alphabet2015_A1_Resolve_Checkbox)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_Alphabet2015_A1_Resolve_Note);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Alphabet2015_A1_Resolve_Note)).sendKeys("Resolved by Jim ");
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_Alphabet2015_A2_Resolve_Checkbox);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Alphabet2015_A2_Resolve_Checkbox)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_Alphabet2015_A2_Resolve_Note);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Alphabet2015_A2_Resolve_Note)).sendKeys("Resolved by Noah ");
		
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Resolve_Button)).click();
		
	}

	public String VerifyShowResolved() throws InterruptedException {
		
		// verify details before show resolved option 
		String result;
		Thread.sleep(5000);
		String details_before = ElectionOperations.verifyDetailsBeforeShowResolved();
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_SHOW_RESOLVED_CHECKBOX);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_SHOW_RESOLVED_CHECKBOX)).click();
		Thread.sleep(5000);
		String details_after = ElectionOperations.verifyDetailsAfterShowResolved();
		
		if (details_before != details_after)
		{
		    result = "passed";
			System.out.println("passed");
		}
		else 
		{
			result = "Failed";
			System.out.println("Failed");
		}
		
		
		return result;
	}

	public String VerifyDealLevelDetails() throws InterruptedException {
		// TODO Auto-generated method stub
		
		Thread.sleep(5000);
		String deal_level_details = ElectionOperations.verifyDetailsBeforeShowResolved();
		return deal_level_details;
	}
	
		
	
}
