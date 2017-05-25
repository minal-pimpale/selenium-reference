package selenium.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;



import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.DealCenterWebElement;
import WebElement.LoginWebElement;
import selenium.pageobject.*;

public class DealCenterPageObject {
	
	private DealCenterWebElement dealCenterWebElementObj ; 
	private DealCenterOperations dealcenteroperationsobj; 
	private LoginWebElement LoginWebElementObj;
	
	public DealCenterPageObject()
	{
		this.dealCenterWebElementObj = new DealCenterWebElement();
		this.dealcenteroperationsobj = new DealCenterOperations ();
		this.LoginWebElementObj = new LoginWebElement();
	}
	
	public static void goToChildrenAccount() {
		System.out.println("************************************************************************************************");
		System.out.println("Login to Children Account (abc4@capital.com)");
		LoginPage.Goto();
		LoginPage.LoginAs("abc4@capital.com").WithPassword("aaa.111").Login();
		AssertJUnit.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector account (abc4@capital.com)");
		
	}

	public static void goToDealCentrePage() {
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/header/div/div/div/div[1]/ul/li[2]/a/span");
		SeleniumHelper.Navigate(BasePageObject.baseurl + "/dealcenter");
		
	}

	public static String totalOfaceSeries2014Holdings() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[1]/td[4]/table/tbody/tr/td[1]/div");
		String totalOface2014Holding= webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[1]/td[4]/table/tbody/tr/td[1]/div")).getText();        //getting holding for series 2014-1
		String totalOface2014Percentage= webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[1]/td[4]/table/tbody/tr/td[2]/span")).getText();		//getting %age for series 2014-1
		System.out.println("Series 2014 Holding  " + totalOface2014Holding);
		System.out.println("Series 2014 Percentage  " + totalOface2014Percentage);
		String holdingInfo = totalOface2014Holding + "_" + totalOface2014Percentage;
		System.out.println(holdingInfo);
		return holdingInfo;
		
	}


	public static String totalOfaceSeries2014HoldingsA1() {
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[1]/td[1]/a")).click();						// clicking on 2014 series (+) expand button once
//		SeleniumHelper.WaitForPresenceOfElementById("deal_detail_347742");
//		String classA1Name= webdriver.findElement(By.id("deal_detail_347742")).getText();   
//		System.out.println("name  " + classA1Name);
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='deal_holding_amount_347742']/span");
		String classA1Holding= webdriver.findElement(By.xpath("//*[@id='deal_holding_amount_347742']/span")).getText();   							// getting holding for A1
		String classA1Percentage= webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[2]/td[4]/table/tbody/tr/td[2]")).getText(); 			// getting percentage for A1
		System.out.println("Series 2014 A1 Holdings  " + classA1Holding);
		System.out.println("Series 2014 A1 Percentages  " + classA1Percentage);
		String A1holdingInfo = classA1Holding + "_" + classA1Percentage;
		System.out.println(A1holdingInfo);
		return A1holdingInfo;
		
		
	}

	public static String totalOfaceSeries2014HoldingsA2() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		//*[@id='deal_holding_amount_347744']/span
		String classA2Holding= webdriver.findElement(By.xpath("//*[@id='deal_holding_amount_347744']/span")).getText();   							// getting holding for A2
		String classA2Percentage= webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[3]/td[4]/table/tbody/tr/td[2]")).getText(); 			// getting percentage for A2
		System.out.println("Series 2014 A2 Holdings  " + classA2Holding);
		System.out.println("Series 2014 A2 Percentages  " + classA2Percentage);
		String A2holdingInfo = classA2Holding + "_" + classA2Percentage;
		System.out.println(A2holdingInfo);
		return A2holdingInfo;
	}

	public static String totalOfaceSeries2016Holdings() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String totalOface2016Holding= webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[4]/td[4]/table/tbody/tr/td[1]/div")).getText();        //getting holding for series 2016-1
		String totalOface2016Percentage= webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[4]/td[4]/table/tbody/tr/td[2]/span")).getText();		//getting %age for series 2016-1
		System.out.println("Series 2016 Holding  " + totalOface2016Holding);
		System.out.println("Series 2016 Percentage  " + totalOface2016Percentage);
		String holdingInfo = totalOface2016Holding + "_" + totalOface2016Percentage;
		System.out.println(holdingInfo);
		return holdingInfo;
	}

	public static String totalOfaceSeries2016HoldingsA1() {
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[4]/td[1]/a")).click();						// clicking on 2016 series (+) expand button once
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='deal_holding_amount_347753']/span");
		String classA1Holding= webdriver.findElement(By.xpath("//*[@id='deal_holding_amount_347753']/span")).getText();   							// getting holding for A1
		String classA1Percentage= webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[5]/td[4]/table/tbody/tr/td[2]")).getText(); 			// getting percentage for A1
		System.out.println("Series 2016 A1 Holdings  " + classA1Holding);
		System.out.println("Series 2016 A1 Percentages  " + classA1Percentage);
		String A1holdingInfo = classA1Holding + "_" + classA1Percentage;
		System.out.println(A1holdingInfo);
		return A1holdingInfo;
	}

	public static String totalOfaceSeries2016HoldingsA2() {
		WebDriver webdriver = SeleniumWebDriver.Instance();  
		String classA2Holding= webdriver.findElement(By.xpath("//*[@id='deal_holding_amount_347754']/span")).getText();   							// getting holding for A2
		String classA2Percentage= webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[6]/td[4]/table/tbody/tr/td[2]")).getText(); 			// getting percentage for A2
		System.out.println("Series 2016 A2 Holdings  " + classA2Holding);
		System.out.println("Series 2016 A2 Percentages  " + classA2Percentage);
		String A2holdingInfo = classA2Holding + "_" + classA2Percentage;
		System.out.println(A2holdingInfo);
		return A2holdingInfo;
	}


	public static String dealInfoCHAIT() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String dealName = webdriver.findElement(By.xpath("//*[@id='deal_detail_347660']")).getText();
		String roleName = webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[7]/td[5]/span")).getText();
		String dealInfo = dealName + "--" + roleName;
		System.out.println("Chait deal name is  " + dealName);
		System.out.println("Chait role name is  " + roleName);
		System.out.println("Deal Info is  " + dealInfo);
		return dealInfo;
		
	}

	public static String dealInfoDCENT() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String dealName = webdriver.findElement(By.xpath("//*[@id='deal_detail_347656']")).getText();
		String roleName = webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div/table/tbody/tr[8]/td[5]/span")).getText();
		String dealInfo = dealName + "--" + roleName;
		System.out.println("DCENT deal name is  " + dealName);
		System.out.println("DCENT role name is  " + roleName);
		System.out.println("Deal Info is  " + dealInfo);
		return dealInfo;
	}

	public static String assetClassInfo() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		String AssetClassFollowed = webdriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/section[2]/p[1]/b")).getText();
		System.out.println("Asset Class Followed is  " + AssetClassFollowed);
		return AssetClassFollowed;
		
	}

	public static void goToLeadMangerAccount() {
		System.out.println("************************************************************************************************");
		System.out.println("Login to Lead Managers Account (abc1@capital.com)");
		LoginPage.Goto();
		LoginPage.LoginAs("abc1@capital.com").WithPassword("aaa.111").Login();
		AssertJUnit.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector account (abc1@capital.com)");
		
	}

	public static void goToMangerAccount() {
		System.out.println("************************************************************************************************");
		System.out.println("Login to Managers Account (abc2@capital.com)");
		LoginPage.Goto();
		LoginPage.LoginAs("abc2@capital.com").WithPassword("aaa.111").Login();
		AssertJUnit.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector account (abc2@capital.com)");
		
	}

	public static String addDealButton() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='add_deal_link']/b");  
		webdriver.findElement(By.xpath("//*[@id='add_deal_link']/b")).click();						// Click on Add Deal Button in Deal Centre Page
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-1']/h3");  
		String readOnlytext = webdriver.findElement(By.xpath("//*[@id='ui-id-1']/h3")).getText();			// Fetching "Read Only Access" text from info popup
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();					// Closing popup  
		System.out.println(readOnlytext + " Deal Centre (Add Deal Button)");
		return readOnlytext;
	}

	public static String followAssetClass() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='show_acf_container']");		// click on Edit link 
		webdriver.findElement(By.xpath("//*[@id='show_acf_container']")).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/div[1]/div/div/div[1]/div/section[2]/div/form/ul/li[3]/label");  
		webdriver.findElement(By.xpath("/html/body/div[1]/div/div/div[1]/div/section[2]/div/form/ul/li[3]/label")).click();						// select asset class checkbox to follow asset class
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/div/div/div/div[1]/div/section[2]/div/form/button");  
		webdriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/section[2]/div/form/button")).click();						// Click on "Save Changes" Button to follow asset class
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-1']/h3");  
		String readOnlytext = webdriver.findElement(By.xpath("//*[@id='ui-id-1']/h3")).getText();			// Fetching "Read Only Access" text from info popup
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();					// Closing popup  
		System.out.println(readOnlytext + " Follow Asset Class");
		return readOnlytext;
	}

	public static String editDealRole() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='edit_347660']/b");  
		webdriver.findElement(By.xpath("//*[@id='edit_347660']/b")).click();						// Click on "Edit" deal role of CHAIT 2013-A6 deal
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-1']/h3");  
		String readOnlytext = webdriver.findElement(By.xpath("//*[@id='ui-id-1']/h3")).getText();			// Fetching "Read Only Access" text from info popup
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("/html/body/div[3]/div[1]/button")).click();					// Closing popup  
		System.out.println(readOnlytext + " Deal Centre (Edit Deal Role )");
		return readOnlytext;
	}

	public static void goToRecommendedPage() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/a/b");  
		webdriver.findElement(By.xpath("/html/body/div/div/div/div[1]/div/div[1]/div[2]/a/b")).click();	
		
	}

	public static void goToInvestorsAccount() {
		System.out.println("************************************************************************************************");
		System.out.println("Login to Investors Account (abc18@capital.com)");
		LoginPage.Goto();
		LoginPage.LoginAs("abc18@capital.com").WithPassword("aaa.111").Login();
		AssertJUnit.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Investors account (abc18@capital.com)");
		
	}



	public static void completeBallot() throws InterruptedException {
	   AssertJUnit.assertEquals("Alphabet 2015-2 - BNY Election--Deadline: Dec 1st, 2017", goToSeriesPage());
	   goToCompleteBallotPage();
	   selectCustodian();
	   putHoldingsForA1();
	   putHoldingsForA2();	
	   putBeneficialOwnerName();	
	   putSignedByName();
	   putSignedByTitle();
	   clickOnGenerateBallot();
	   AssertJUnit.assertEquals("Step 2 of 2:", getConfirmationText());
	}
	

	public static String goToSeriesPage() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='dealcenter_content_wrapper']/div[1]/table/tbody/tr[2]/td[3]/a/span[2]");   //  click on Action required link
		webdriver.findElement(By.xpath("//*[@id='dealcenter_content_wrapper']/div[1]/table/tbody/tr[2]/td[3]/a/span[2]")).click();	
		Thread.sleep(1000);
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='votes']/div[2]/div/div[1]/div/div/div[1]/h1/span[1]");
		String NameOfAction = webdriver.findElement(By.xpath("//*[@id='votes']/div[2]/div/div[1]/div/div/div[1]/h1/span[1]")).getText();  
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='votes']/div[2]/div/div[1]/div/div/div[1]/h1/span[3]");
		String DeadlineOfAction = webdriver.findElement(By.xpath("//*[@id='votes']/div[2]/div/div[1]/div/div/div[1]/h1/span[3]")).getText();  
		String ActionInfo = NameOfAction + "--" + DeadlineOfAction;
		System.out.println("Name of Action is -->  " + NameOfAction);
		System.out.println("Deadline for the Action is -->  " + DeadlineOfAction);
		System.out.println("Action Info is -->  " + ActionInfo);
		return ActionInfo;
	}
	
	public static void goToCompleteBallotPage() {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='votes']/div[2]/div/div[1]/div/div/div[1]/div[2]/div/button");                        // click on Complete Ballot button
		webdriver.findElement(By.xpath("//*[@id='votes']/div[2]/div/div[1]/div/div/div[1]/div[2]/div/button")).click();	
		
	}
	
	public static void selectCustodian() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='selectCustodian']/div/div/span[1]");                                                 // click on custodian dropdown
		Thread.sleep(1500);
		webdriver.findElement(By.xpath("//*[@id='selectCustodian']/div/div/span[1]")).click();	
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-select-choices-row-0-0']/a/div");  
		Thread.sleep(1500);
		webdriver.findElement(By.xpath("//*[@id='ui-select-choices-row-0-0']/a/div")).click();                                                          // Choose 5-Goldman Sachs & Co
		Thread.sleep(2500);
	}
	
	
	public static void putHoldingsForA1() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='oface_347742']");		// holding for 63938EAD6
		int abc = 3200000;
		webdriver.findElement(By.xpath("//*[@id='oface_347742']")).sendKeys(""+ abc);		
		Thread.sleep(500);
		
	}
	
	public static String getHoldingsForA1() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='oface_347742']");		// holding for 63938EAD6
		String HoldingsForA1 = webdriver.findElement(By.xpath("//*[@id='oface_347742']")).getAttribute("value");		
		System.out.println("Holdings For A1  is -->  " + HoldingsForA1);
		return HoldingsForA1;
	}
	
	
	public static void putHoldingsForA2() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='oface_347744']");                       // holding for 63938EAD6
		int abc = 6000000;
		webdriver.findElement(By.xpath("//*[@id='oface_347744']")).sendKeys(""+ abc);	
		Thread.sleep(500);
	
	}
	
	public static String getHoldingsForA2() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='oface_347744']");                       // holding for 63938EAD6
		String HoldingsForA2 = webdriver.findElement(By.xpath("//*[@id='oface_347744']")).getAttribute("value");	
		System.out.println("Holdings For A2 is -->  " + HoldingsForA2);
		return HoldingsForA2;
	
	}
	
	public static void putBeneficialOwnerName() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[1]/div/label");                       // put Beneficial OwnerName
		webdriver.findElement(By.xpath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[1]/div/label")).click();
		webdriver.findElement(By.xpath("//*[@id='beneficial_owner_firm']")).sendKeys("Richard Hedge Fund");	
		
	}
	
	public static String getBeneficialOwnerName() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[1]/div/label");                       // put Beneficial OwnerName
		webdriver.findElement(By.xpath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[1]/div/label")).click();
		String BeneficialOwnerName = webdriver.findElement(By.xpath("//*[@id='beneficial_owner_firm']")).getAttribute("value");	
		System.out.println("Beneficial Owner Name is -->  " + BeneficialOwnerName);
		return BeneficialOwnerName;
	}
	
	public static void putSignedByName() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[2]/div/label");                       // put Signed By Name
		Thread.sleep(1500);
		webdriver.findElement(By.xpath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[2]/div/label")).click();	
		webdriver.findElement(By.xpath("//*[@id='beneficial_or_registered_owner_name']")).sendKeys("Richard Denero");	
	}
	
	public static String getSignedByName() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[2]/div/label");                       // put Signed By Name
		webdriver.findElement(By.xpath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[2]/div/label")).click();	
		String SignedByName = webdriver.findElement(By.xpath("//*[@id='beneficial_or_registered_owner_name']")).getAttribute("value");	
		System.out.println("Signed By Name is -->  " + SignedByName);
		return SignedByName;
		
	}
	
	public static void putSignedByTitle() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[3]/div/label");                       // put Title
		Thread.sleep(1500);
		webdriver.findElement(By.xpath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[3]/div/label")).click();
		webdriver.findElement(By.xpath("//*[@id='beneficial_or_registered_owner_title']")).sendKeys("Richard Title");	
		
	}
	
	public static String getSignedByTitle() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[3]/div/label");                       // put Title
		Thread.sleep(1500);
		webdriver.findElement(By.xpath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[3]/form/div[3]/div[3]/div/label")).click();
		String SignedByTitle = webdriver.findElement(By.xpath("//*[@id='beneficial_or_registered_owner_title']")).getAttribute("value");	
		System.out.println("Signed BY Title is " + SignedByTitle);
		return SignedByTitle;
	}
	
	public static void clickOnGenerateBallot() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[4]/button/b");                       // generate ballot
		webdriver.findElement(By.xpath("//*[@id='ballot']/div[3]/div[1]/div[1]/div/div/div[4]/button/b")).click();
		                       
	}
	
	public static String getConfirmationText() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='generated_ballot']/div/div/div/div/div/div[1]/span");                       // getting Step 2 of 2: text on pdf page
		Thread.sleep(500);
		String ConfirmationTextOnGenerateBallotPage = webdriver.findElement(By.xpath("//*[@id='generated_ballot']/div/div/div/div/div/div[1]/span")).getText();  
		System.out.println("Confirmation Text On Generate Ballot Page  is -->  " + ConfirmationTextOnGenerateBallotPage);
        return ConfirmationTextOnGenerateBallotPage;
		
	}

	public static void clickOnEditBallot() {
		WebDriver webdriver = SeleniumWebDriver.Instance(); 
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='generated_ballot']/div/div/div/div/div/div[3]/button[2]");                       // click On Edit Ballot
		webdriver.findElement(By.xpath("//*[@id='generated_ballot']/div/div/div/div/div/div[3]/button[2]")).click();
		
	}

	public void gotoAddDealUserAccount() {
		// TODO Auto-generated method stub
		System.out.println("************************************************************************************************");
		System.out.println("Login to Add Deal User's Account (abc17@capital.com)");
		LoginPage.Goto();
		LoginPage.LoginAs(this.dealCenterWebElementObj.getUSERNAME()).
		WithPassword(this.dealCenterWebElementObj.getPASSWORD()).Login();
		AssertJUnit.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector account (abc17@capital.com)");
	}
	
	public String AddDealasInstInvestor() throws InterruptedException{
	
		String Local_Ticker = "83612KAP6";
		int deal_role = 1;
		String deal_xpath = this.dealCenterWebElementObj.getXPATH_InstInv_Deal();
		String role_xpath = this.dealCenterWebElementObj.getXPATH_DEAL_ROLE_Inst_INVESTOR();
		
		this.dealcenteroperationsobj.SearchDeal(Local_Ticker);
		this.dealcenteroperationsobj.AddDeal(deal_role);
		
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		String role = this.dealcenteroperationsobj.GetRole(role_xpath);
		
		System.out.println(deal_name);
		System.out.println(role);
		String deal_info = deal_name + "_" + role;
		return deal_info; 
	}
	
	public String AddDealasIndInvestor() throws InterruptedException {
		
		String Local_Ticker = "WFHET 2006-3 B3";
		int deal_role = 2;
		String deal_xpath = this.dealCenterWebElementObj.getXPATH_IndInv_Deal();
		String role_xpath = this.dealCenterWebElementObj.getXPATH_DEAL_ROLE_Ind_INVESTOR();
		
		this.dealcenteroperationsobj.SearchDeal(Local_Ticker);
		this.dealcenteroperationsobj.AddDeal(deal_role);
		
		
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		String role = this.dealcenteroperationsobj.GetRole(role_xpath);
		System.out.println(deal_name);
		System.out.println(role);
		String deal_info = deal_name + "_" + role;
		return deal_info; 
		
	}
	
	public String AddDealasAdvisor() throws InterruptedException{
		
		String Local_Ticker = "86363WAW9";
		int deal_role = 4;
		String deal_xpath = this.dealCenterWebElementObj.getXPATH_Advisor_Deal();
		String role_xpath = this.dealCenterWebElementObj.getXPATH_Deal_ROLE_OTHER();
		
		this.dealcenteroperationsobj.SearchDeal(Local_Ticker);
		this.dealcenteroperationsobj.AddDeal(deal_role);
		
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		String role = this.dealcenteroperationsobj.GetRole(role_xpath);
		System.out.println(deal_name);
		System.out.println(role);
		String deal_info = deal_name + "_" + role;
		return deal_info;
					
	}
	
	public String AddDealasBroker() throws InterruptedException{
		
		String Local_Ticker = "SASC 2005-NC2 M10";
		int deal_role = 5;
		String deal_xpath = this.dealCenterWebElementObj.getXPATH_Broker_Deal();
		String role_xpath = this.dealCenterWebElementObj.getXPATH_Deal_ROLE_OTHER();
		
		this.dealcenteroperationsobj.SearchDeal(Local_Ticker);
		this.dealcenteroperationsobj.AddDeal(deal_role);
		
		
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		String role = this.dealcenteroperationsobj.GetRole(role_xpath);
		System.out.println(deal_name);
		System.out.println(role);
		String deal_info = deal_name + "_" + role;
		return deal_info;
		
		
		
	}
	
	public String AddDealasTrustee() throws InterruptedException{
		
		String Local_ticker = "86364DAY6";
		int deal_role = 6; 
		String deal_xpath = this.dealCenterWebElementObj.getXPATH_Trustee_Deal();
		String role_xpath = this.dealCenterWebElementObj.getXPATH_Deal_ROLE_OTHER();
		
		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
		this.dealcenteroperationsobj.AddDeal(deal_role);
		
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		String role = this.dealcenteroperationsobj.GetRole(role_xpath);
		System.out.println(deal_name);
		System.out.println(role);
		String deal_info = deal_name + "_" + role;
		return deal_info;
	
	}
	
      public String AddDealasIssuer() throws InterruptedException{
		
		String Local_ticker = "86361WAV3";
		int deal_role = 7; 
		String deal_xpath = this.dealCenterWebElementObj.getXPATH_Issuer_Deal();
		String role_xpath = this.dealCenterWebElementObj.getXPATH_Deal_ROLE_OTHER();
		
		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
		this.dealcenteroperationsobj.AddDeal(deal_role);
		
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		String role = this.dealcenteroperationsobj.GetRole(role_xpath);
		System.out.println(deal_name);
		System.out.println(role);
		String deal_info = deal_name + "_" + role;
		return deal_info;
	
	}
	
    public String AddDealasUnderwriter() throws InterruptedException{
		
		String Local_ticker = "86361HBA1";
		int deal_role = 8; 
		String deal_xpath = this.dealCenterWebElementObj.getXPATH_Underwriter_Deal();
		String role_xpath = this.dealCenterWebElementObj.getXPATH_Deal_ROLE_OTHER();
		
		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
		this.dealcenteroperationsobj.AddDeal(deal_role);
		
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		String role = this.dealcenteroperationsobj.GetRole(role_xpath);
		System.out.println(deal_name);
		System.out.println(role);
		String deal_info = deal_name + "_" + role;
		return deal_info;
	
	}
    
    public String AddDealasCustodian() throws InterruptedException{
		
		String Local_ticker = "81379EAK8";
		int deal_role = 9; 
		String deal_xpath = this.dealCenterWebElementObj.getXPATH_Custodian_Deal();
		String role_xpath = this.dealCenterWebElementObj.getXPATH_Deal_ROLE_OTHER();
		
		
		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
		this.dealcenteroperationsobj.AddDeal(deal_role);
		
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		String role = this.dealcenteroperationsobj.GetRole(role_xpath);
		System.out.println(deal_name);
		System.out.println(role);
		String deal_info = deal_name + "_" + role;
		return deal_info;
	
	}
    
     public String AddDealasWatching() throws InterruptedException{
		
		String Local_ticker = "81378EAM5";
		int deal_role = 10; 
		String deal_xpath = this.dealCenterWebElementObj.getXPATH_Other_Deal();
		String role_xpath = this.dealCenterWebElementObj.getXPATH_Deal_ROLE_OTHER();
		
		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
		this.dealcenteroperationsobj.AddDeal(deal_role);
		
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		String role = this.dealcenteroperationsobj.GetRole(role_xpath);
		System.out.println(deal_name);
		System.out.println(role);
		String deal_info = deal_name + "_" + role;
		return deal_info;
	
	}

	public String AddDealasLawyer_Investor() throws InterruptedException {
		// TODO Auto-generated method stub
		
 		String Local_ticker = "01448QAA8";
 		int deal_role = 3;
 		int deal_sub_role = 1; 
 		String deal_xpath = this.dealCenterWebElementObj.getXPATH_ALESCO_A1_01448QAA8();
 		String edit_link_xpath = this.dealCenterWebElementObj.getEdit_link_xpath_ALESCO_A1_01448QAA8();
 		
 		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
 		this.dealcenteroperationsobj.AddDealwithSubRole(deal_role, deal_sub_role);
 		
 		this.dealcenteroperationsobj.ExpandSeries(this.dealCenterWebElementObj.getEXPAND_ALESCO_SERIES());
 		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		System.out.println(deal_name);
		this.dealcenteroperationsobj.EditDealRole(edit_link_xpath); //click on edit link
 		
 		String dealrole = this.dealcenteroperationsobj.GetDealRole();
 		System.out.println(dealrole);																// get deal role 
 		
 		String dealsubrole = this.dealcenteroperationsobj.GetDealSubRole();
 		System.out.println(dealsubrole);															// get deal sub role 
 		
 		String deal_info = deal_name + "_" + dealrole + "_" + dealsubrole;
 		System.out.println(deal_info);
 		
 		return deal_info; 
 		
 		
	}

	public String AddDealasLawyer_Broker() throws InterruptedException {
		// TODO Auto-generated method stub
		String Local_ticker = "01448QAB6";
 		int deal_role = 3;
 		int deal_sub_role = 2;
 		String deal_xpath = this.dealCenterWebElementObj.getXPATH_ALESCO_A2_01448QAB6();
 		String edit_link_xpath = this.dealCenterWebElementObj.getEdit_link_xpath_ALESCO_A2_01448QAB6();
 				
 		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
 		this.dealcenteroperationsobj.AddDealwithSubRole(deal_role, deal_sub_role);
 		Thread.sleep(3000);
 		this.dealcenteroperationsobj.ExpandSeries(this.dealCenterWebElementObj.getEXPAND_ALESCO_SERIES());
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		System.out.println(deal_name);
		Thread.sleep(3000);
		this.dealcenteroperationsobj.EditDealRole(edit_link_xpath);     // click on edit link 
		
		String dealrole = this.dealcenteroperationsobj.GetDealRole();
 		System.out.println(dealrole);																// get deal role 
 		
 		String dealsubrole = this.dealcenteroperationsobj.GetDealSubRole();
 		System.out.println(dealsubrole);																// get deal sub role 
 		
 		String deal_info = deal_name + "_" + dealrole + "_" + dealsubrole;
 		System.out.println(deal_info);
 		
 		return deal_info; 
		
	}

	public String AddDealasLawyer_PrincipleManager() throws InterruptedException {
		// TODO Auto-generated method stub
		String Local_ticker = "01448QAC4" ; 
		int deal_role = 3;
 		int deal_sub_role = 3;
 		String deal_xpath = this.dealCenterWebElementObj.getXPATH_ALESCO_A3_01448QAC4();
 		String edit_link_xpath = this.dealCenterWebElementObj.getEdit_link_xpath_ALESCO_A3_01448QAC4();
 		
 		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
 		this.dealcenteroperationsobj.AddDealwithSubRole(deal_role, deal_sub_role);
 		Thread.sleep(3000);
 		this.dealcenteroperationsobj.ExpandSeries(this.dealCenterWebElementObj.getEXPAND_ALESCO_SERIES());
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		System.out.println(deal_name);
		Thread.sleep(3000);
		this.dealcenteroperationsobj.EditDealRole(edit_link_xpath);     // click on edit link 
		
		String dealrole = this.dealcenteroperationsobj.GetDealRole();
 		System.out.println(dealrole);																// get deal role 
 		
 		String dealsubrole = this.dealcenteroperationsobj.GetDealSubRole();
 		System.out.println(dealsubrole);																// get deal sub role 
 		
 		String deal_info = deal_name + "_" + dealrole + "_" + dealsubrole;
 		System.out.println(deal_info);
 		
 		return deal_info; 
 	
	}

	public String AddDealasLawyer_FinancialAdvisor() throws InterruptedException {
		// TODO Auto-generated method stub
		String Local_ticker = "01448QAD2" ; 
		int deal_role = 3;
 		int deal_sub_role = 4;
 		String deal_xpath = this.dealCenterWebElementObj.getXPATH_ALESCO_B1_01448QAD2();
 		String edit_link_xpath = this.dealCenterWebElementObj.getEdit_link_xpath_ALESCO_B1_01448QAD2();
 		
 		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
 		this.dealcenteroperationsobj.AddDealwithSubRole(deal_role, deal_sub_role);
 		Thread.sleep(3000);
 		this.dealcenteroperationsobj.ExpandSeries(this.dealCenterWebElementObj.getEXPAND_ALESCO_SERIES());
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		System.out.println(deal_name);
		Thread.sleep(3000);
		this.dealcenteroperationsobj.EditDealRole(edit_link_xpath);     // click on edit link 
		
		String dealrole = this.dealcenteroperationsobj.GetDealRole();
 		System.out.println(dealrole);																// get deal role 
 		
 		String dealsubrole = this.dealcenteroperationsobj.GetDealSubRole();
 		System.out.println(dealsubrole);																// get deal sub role 
 		
 		String deal_info = deal_name + "_" + dealrole + "_" + dealsubrole;
 		System.out.println(deal_info);
 		
 		return deal_info; 
	}

	public String AddDealasLawyer_Analyst_BuySide() throws InterruptedException {
		// TODO Auto-generated method stub
		String Local_ticker = "01448QAE0" ; 
		int deal_role = 3;
 		int deal_sub_role = 5;
 		String deal_xpath = this.dealCenterWebElementObj.getXPATH_ALESCO_B2_01448QAE0();
 		String edit_link_xpath = this.dealCenterWebElementObj.getEdit_link_xpath_ALESCO_B2_01448QAE0();
 		
 		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
 		this.dealcenteroperationsobj.AddDealwithSubRole(deal_role, deal_sub_role);
 		Thread.sleep(3000);
 		this.dealcenteroperationsobj.ExpandSeries(this.dealCenterWebElementObj.getEXPAND_ALESCO_SERIES());
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		System.out.println(deal_name);
		Thread.sleep(3000);
		this.dealcenteroperationsobj.EditDealRole(edit_link_xpath);     // click on edit link 
		
		String dealrole = this.dealcenteroperationsobj.GetDealRole();
 		System.out.println(dealrole);																// get deal role 
 		
 		String dealsubrole = this.dealcenteroperationsobj.GetDealSubRole();
 		System.out.println(dealsubrole);																// get deal sub role 
 		
 		String deal_info = deal_name + "_" + dealrole + "_" + dealsubrole;
 		System.out.println(deal_info);
 		
 		return deal_info; 
		
	}

	public String AddDealasLawyer_Analyst_SellSide() throws InterruptedException {
		// TODO Auto-generated method stub
		String Local_ticker = "01448QAF7" ; 
		int deal_role = 3;
 		int deal_sub_role = 6;
 		String deal_xpath = this.dealCenterWebElementObj.getXPATH_ALESCO_B3_01448QAF7();
 		String edit_link_xpath = this.dealCenterWebElementObj.getEdit_link_xpath_ALESCO_B3_01448QAF7();
 		
 		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
 		this.dealcenteroperationsobj.AddDealwithSubRole(deal_role, deal_sub_role);
 		Thread.sleep(3000);
 		this.dealcenteroperationsobj.ExpandSeries(this.dealCenterWebElementObj.getEXPAND_ALESCO_SERIES());
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		System.out.println(deal_name);
		Thread.sleep(3000);
		this.dealcenteroperationsobj.EditDealRole(edit_link_xpath);     // click on edit link 
		
		String dealrole = this.dealcenteroperationsobj.GetDealRole();
 		System.out.println(dealrole);																// get deal role 
 		
 		String dealsubrole = this.dealcenteroperationsobj.GetDealSubRole();
 		System.out.println(dealsubrole);																// get deal sub role 
 		
 		String deal_info = deal_name + "_" + dealrole + "_" + dealsubrole;
 		System.out.println(deal_info);
 		
 		return deal_info; 
	}

	public String AddDealasLawyer_Trustee() throws InterruptedException {
		
		String Local_ticker = "01448RAA6" ; 
		int deal_role = 3;
 		int deal_sub_role = 7;
 		String deal_xpath = this.dealCenterWebElementObj.getXPATH_ALESCO_M1_01448RAA6();
 		String edit_link_xpath = this.dealCenterWebElementObj.getEdit_link_xpath_ALESCO_M1_01448RAA6();
 		
 		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
 		this.dealcenteroperationsobj.AddDealwithSubRole(deal_role, deal_sub_role);
 		Thread.sleep(3000);
 		this.dealcenteroperationsobj.ExpandSeries(this.dealCenterWebElementObj.getEXPAND_ALESCO_SERIES());
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		System.out.println(deal_name);
		Thread.sleep(3000);
		this.dealcenteroperationsobj.EditDealRole(edit_link_xpath);     // click on edit link 
		
		String dealrole = this.dealcenteroperationsobj.GetDealRole();
 		System.out.println(dealrole);																// get deal role 
 		
 		String dealsubrole = this.dealcenteroperationsobj.GetDealSubRole();
 		System.out.println(dealsubrole);																// get deal sub role 
 		
 		String deal_info = deal_name + "_" + dealrole + "_" + dealsubrole;
 		System.out.println(deal_info);
 		
 		return deal_info; 
	}

	public String AddDealasLawyer_Issuer() throws InterruptedException {
		
		String Local_ticker = "01448RAB4" ; 
		int deal_role = 3;
 		int deal_sub_role = 8;
 		String deal_xpath = this.dealCenterWebElementObj.getXPATH_ALESCO_M2_01448RAB4();
 		String edit_link_xpath = this.dealCenterWebElementObj.getEdit_link_xpath_ALESCO_M2_01448RAB4();
 		
 		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
 		this.dealcenteroperationsobj.AddDealwithSubRole(deal_role, deal_sub_role);
 		Thread.sleep(3000);
 		this.dealcenteroperationsobj.ExpandSeries(this.dealCenterWebElementObj.getEXPAND_ALESCO_SERIES());
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		System.out.println(deal_name);
		Thread.sleep(3000);
		this.dealcenteroperationsobj.EditDealRole(edit_link_xpath);     // click on edit link 
		
		String dealrole = this.dealcenteroperationsobj.GetDealRole();
 		System.out.println(dealrole);																// get deal role 
 		
 		String dealsubrole = this.dealcenteroperationsobj.GetDealSubRole();
 		System.out.println(dealsubrole);																// get deal sub role 
 		
 		String deal_info = deal_name + "_" + dealrole + "_" + dealsubrole;
 		System.out.println(deal_info);
 		
 		return deal_info; 
	}

	public String AddDealasLawyer_Underwriter() throws InterruptedException 
	{
		String Local_ticker = "01448RAC2" ; 
		int deal_role = 3;
 		int deal_sub_role = 9;
 		String deal_xpath = this.dealCenterWebElementObj.getXPATH_ALESCO_M3_01448RAC2();
 		String edit_link_xpath = this.dealCenterWebElementObj.getEdit_link_xpath_ALESCO_M3_01448RAC2();
 		
 		this.dealcenteroperationsobj.SearchDeal(Local_ticker);
 		this.dealcenteroperationsobj.AddDealwithSubRole(deal_role, deal_sub_role);
 		Thread.sleep(3000);
 		this.dealcenteroperationsobj.ExpandSeries(this.dealCenterWebElementObj.getEXPAND_ALESCO_SERIES());
		String deal_name = this.dealcenteroperationsobj.GetDealName(deal_xpath);
		System.out.println(deal_name);
		Thread.sleep(3000);
		this.dealcenteroperationsobj.EditDealRole(edit_link_xpath);     // click on edit link 
		
		String dealrole = this.dealcenteroperationsobj.GetDealRole();
 		System.out.println(dealrole);																// get deal role 
 		
 		String dealsubrole = this.dealcenteroperationsobj.GetDealSubRole();
 		System.out.println(dealsubrole);																// get deal sub role 
 		
 		String deal_info = deal_name + "_" + dealrole + "_" + dealsubrole;
 		System.out.println(deal_info);
 		
 		return deal_info; 
		
	}

	public static void goTOOverviewPage() {
		// TODO Auto-generated method stub
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/header/div/div/div/div[1]/ul/li[1]/a/span");
		SeleniumHelper.Navigate(BasePageObject.baseurl +"/overview");
	}

	public void gotoUserAccount(String username , String password) {
		// TODO Auto-generated method stub
		WebDriver webdriver = SeleniumWebDriver.Instance();
		System.out.println("************************************************************************************************");
		System.out.println("Login to Add Deal User's Account " + username);
		webdriver.get("http://test.dealvector.com/");
		SeleniumHelper.WaitForPresenceOfElementById(this.LoginWebElementObj.user_name_textbox);
		webdriver.findElement(By.xpath(LoginWebElementObj.user_name_textbox)).sendKeys(username);
		SeleniumHelper.WaitForPresenceOfElementById(this.LoginWebElementObj.password_textbox);
		webdriver.findElement(By.xpath(LoginWebElementObj.password_textbox)).sendKeys(password);
		SeleniumHelper.WaitForPresenceOfElementByXPath(LoginWebElementObj.login_button);
		webdriver.findElement(By.xpath(LoginWebElementObj.login_button)).click();
		
		AssertJUnit.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector account" + username);
	}
    
	
     

	
	
	
}














