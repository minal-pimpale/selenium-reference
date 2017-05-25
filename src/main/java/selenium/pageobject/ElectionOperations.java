package selenium.pageobject;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;





import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.ElectionWebElement;

public class ElectionOperations {
	
	private ElectionPageObject  ElectionPageObjectObj;
	
	public ElectionOperations()
	{
		this.ElectionPageObjectObj = new ElectionPageObject();
		
	}


	public static void expandNavientElection() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_EXPAND_ELECTION);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_EXPAND_ELECTION)).click();
		
	}
	
	public static void expandAlpha2015_2() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_EXPAND_ALPHA2015_2);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_EXPAND_ALPHA2015_2)).click();
		
	}
	
	public static void expandAlpha2016_1() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_TO_EXPAND_ALPHA2016_1);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_TO_EXPAND_ALPHA2016_1)).click();
		
	}
	
	public void goToVoteByCustodian(String voteByCustodian_xpath) throws InterruptedException {
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(voteByCustodian_xpath);
		webdriver.findElement(By.xpath(voteByCustodian_xpath)).click();
		Thread.sleep(3000);
	}
	
	public static void expandCustodian(String Custodian_xpath) throws InterruptedException {
		
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(Custodian_xpath);
		webdriver.findElement(By.xpath(Custodian_xpath)).click();
		Thread.sleep(1000);
	}
	
	public static void collapseCustodian(String Custodian_xpath) throws InterruptedException {
		
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(Custodian_xpath);
		webdriver.findElement(By.xpath(Custodian_xpath)).click();
		Thread.sleep(1000);
	}
	
	public static void expandSubCustodian(String SubCustodian_xpath) throws InterruptedException {
		
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(SubCustodian_xpath);
		webdriver.findElement(By.xpath(SubCustodian_xpath)).click();
		Thread.sleep(1000);
	}
	
	public static void expandDeals(String deal_xpath) throws InterruptedException {
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(deal_xpath);
		webdriver.findElement(By.xpath(deal_xpath)).click();
		Thread.sleep(1000);		
	}
	
	// ----------------------------------------Sharad Hadd Samapt ------------------------------------------//
	
	public void gotoVotingTab(String vote_xpath)
	{
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(vote_xpath);
		webdriver.findElement(By.xpath(vote_xpath)).click();
		
	}

	public void expandSeries(String series_xpath) {
		
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(series_xpath);
		webdriver.findElement(By.xpath(series_xpath)).click();
		
	}
	
	public void expandDeal(String deal_xpath){
		
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(deal_xpath);
		webdriver.findElement(By.xpath(deal_xpath)).click();
	}

	public String CountBallot(String ballot_id) {
		// TODO Auto-generated method stub
		
		this.expandSeries(ElectionWebElement.XPATH_EXPAND_SERIES_2015_2);
		this.expandDeal(ElectionWebElement.XPATH_EXPAND_DEAL_2015_2A1);
		this.expandDeal(ElectionWebElement.XPATH_EXPAND_DEAL_2015_2A2);
		 System.out.println("Details before Count Ballot:");
		 String ballot1_details1 = this.ElectionPageObjectObj.VerifyBallotDetails_7CT6();
		 String ballot_details2 = this.ElectionPageObjectObj.VerifyBallotDetails_7CT6_A2();
		 String before_count_ballot_details = ballot1_details1 + "_" + ballot_details2;
		 
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_COUNT_BALLOT_LINK);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_COUNT_BALLOT_LINK)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_COUNT_BALLOT_BOX);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_COUNT_BALLOT_BOX)).sendKeys(ballot_id);   //enter ballot id 
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_COUNT_POPULATE_BALLOT_BUTTON)).click();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_COUNT_BALLOT_BUTTON);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_COUNT_BALLOT_BUTTON)).click();
		
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_COUNT_BALLOT_MESSAGE);
		String count_ballot_message = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_COUNT_BALLOT_MESSAGE)).getText();
		System.out.println(count_ballot_message);
		SeleniumHelper.WaitForPresenceOfElementByXPath(ElectionWebElement.XPATH_CLOSE_BUTTON);
		webdriver.findElement(By.xpath(ElectionWebElement.XPATH_CLOSE_BUTTON)).click();
		
		System.out.println("Verify details After Count Ballot:");
		this.expandSeries(ElectionWebElement.XPATH_EXPAND_SERIES_2015_2);
		this.expandDeal(ElectionWebElement.XPATH_EXPAND_DEAL_2015_2A1);
		this.expandDeal(ElectionWebElement.XPATH_EXPAND_DEAL_2015_2A2);
		String ballot_details3 = this.ElectionPageObjectObj.VerifyBallotDetails_7CT6();
		String ballot_details4 = this.ElectionPageObjectObj.VerifyBallotDetails_7CT6_A2();
		String after_count_ballot_details = ballot_details3 + "_" + ballot_details4;
		
		if(before_count_ballot_details != after_count_ballot_details)
		{
			return(count_ballot_message);
		}
		else
		{
			System.out.println("Failed to count ballot");
			return null;
			
		}
		
	}


	public void gotoMissingVotesTab(String XPATH_TO_MISSING_VOTE_TAB) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver webdriver =  SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(XPATH_TO_MISSING_VOTE_TAB);
		webdriver.findElement(By.xpath(XPATH_TO_MISSING_VOTE_TAB)).click();
		Thread.sleep(3000);
	}


	public static String verifyDetailsBeforeShowResolved() {
		// TODO Auto-generated method stub
		
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String Alphabet_2016_1_A1 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_Name)).getText();
		String Alphabet_2016_1_A1_DC_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_DEALCENTER_OFACE)).getText();
		String Alphabet_2016_1_A1_Received_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_Received_OFACE)).getText();
		String Alphabet_2016_1_A1_Pending_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_Pending_OFACE)).getText();
		String Alphabet_2016_1_A1_Unvoted_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_Unvoted_OFACE)).getText();
		
		String Alphabet_2016_1_A2 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_Name)).getText();
		String Alphabet_2016_1_A2_DC_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_DEALCENTER_OFACE)).getText();
		String Alphabet_2016_1_A2_Received_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_Received_OFACE)).getText();
		String Alphabet_2016_1_A2_Pending_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_Pending_OFACE)).getText();
		String Alphabet_2016_1_A2_Unvoted_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_Unvoted_OFACE)).getText();
		
		String Alphabet_2016_1_A1_Series1 = Alphabet_2016_1_A1 + "_" + Alphabet_2016_1_A1_DC_Oface + "_" + Alphabet_2016_1_A1_Received_Oface + "_" + Alphabet_2016_1_A1_Pending_Oface + "_" + Alphabet_2016_1_A1_Unvoted_Oface;
		String Alphabet_2016_1_A2_Series1 = Alphabet_2016_1_A2 + "_" + Alphabet_2016_1_A2_DC_Oface + "_" + Alphabet_2016_1_A2_Received_Oface + "_" + Alphabet_2016_1_A2_Pending_Oface + "_" + Alphabet_2016_1_A2_Unvoted_Oface;
		
		String  Alphabet_2016_1 = Alphabet_2016_1_A1_Series1 + "_" + Alphabet_2016_1_A2_Series1;
		System.out.println(Alphabet_2016_1);
		return Alphabet_2016_1; 
	}


	public static String verifyDetailsAfterShowResolved() {
		// TODO Auto-generated method stub
		

		WebDriver webdriver = SeleniumWebDriver.Instance();
		String Alphabet_2015_1_A1 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_Name)).getText();
		String Alphabet_2015_1_A1_DC_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_DEALCENTER_OFACE)).getText();
		String Alphabet_2015_1_A1_Received_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_Received_OFACE)).getText();
		String Alphabet_2015_1_A1_Pending_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_Pending_OFACE)).getText();
		String Alphabet_2015_1_A1_Unvoted_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_Unvoted_OFACE)).getText();
		String Alphabet_2015_1_A1_Resolve_Note = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series1_Resolve_Note)).getText();
		
		String Alphabet_2015_1_A2 = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_Name)).getText();
		String Alphabet_2015_1_A2_DC_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_DEALCENTER_OFACE)).getText();
		String Alphabet_2015_1_A2_Received_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_Received_OFACE)).getText();
		String Alphabet_2015_1_A2_Pending_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_Pending_OFACE)).getText();
		String Alphabet_2015_1_A2_Unvoted_Oface = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_Unvoted_OFACE)).getText();
		String Alphabet_2015_1_A2_Resolve_Note = webdriver.findElement(By.xpath(ElectionWebElement.XPATH_Series2_Resolve_Note)).getText();
		
		String Alphabet_2015_1_A1_Series1 = Alphabet_2015_1_A1 + "_" + Alphabet_2015_1_A1_DC_Oface + "_" + Alphabet_2015_1_A1_Received_Oface + "_" + Alphabet_2015_1_A1_Pending_Oface + "_" + Alphabet_2015_1_A1_Unvoted_Oface + "_" + Alphabet_2015_1_A1_Resolve_Note;
		String Alphabet_2015_1_A2_Series1 = Alphabet_2015_1_A2 + "_" + Alphabet_2015_1_A2_DC_Oface + "_" + Alphabet_2015_1_A2_Received_Oface + "_" + Alphabet_2015_1_A2_Pending_Oface + "_" + Alphabet_2015_1_A2_Unvoted_Oface + "_" + Alphabet_2015_1_A2_Resolve_Note;
		
		String  Alphabet_2015_1 = Alphabet_2015_1_A1_Series1 + "_" + Alphabet_2015_1_A2_Series1;
		System.out.println(Alphabet_2015_1);
		return Alphabet_2015_1; 
		
	}


	
}

