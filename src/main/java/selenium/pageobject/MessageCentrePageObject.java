package selenium.pageobject;


import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import WebElement.MessageCenterWebElement;
import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;

public class MessageCentrePageObject {

	public static void goToUserMessageCentre(){
		System.out.println("Login to Deal vector");
		LoginPage.Goto();
		LoginPage.LoginAs(MessageCenterWebElement.USERNAME).WithPassword(MessageCenterWebElement.PASSWORD).Login();
//		Assert.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector");
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_MESSAGECENTER_TAB);
		SeleniumHelper.Navigate(BasePageObject.baseurl +"/messagecenter");								// Going to Message Centre page

	}
	
	public static boolean containStr(String str1 , String str2) {
		String container = str1;
		String content = str2;
		boolean containerContainsContent = StringUtils.containsIgnoreCase(container, content);
		return containerContainsContent;
	}
	
	public static boolean retTrue() {
		boolean status = true;
		return status;
	}

	public static void createNewMessage(String messageType) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/div/div/div/div[2]/div/a");
		webdriver.findElement(By.xpath("/html/body/div/div/div/div[2]/div/a")).click();					// Click on new message 
		System.out.println("Creating New Message");
		if(messageType == "ByGroup"){
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.BYGROUP_RADIO);
			webdriver.findElement(By.xpath(MessageCenterWebElement.BYGROUP_RADIO)).click();	
			
		}
	}
	
	public static void selectMyDeal(String dealName) throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='selectDeals']");						// click on deal
		webdriver.findElement(By.xpath("//*[@id='selectDeals']")).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.MY_DEAL_INPUT_BOX);									// deal name in input box
		webdriver.findElement(By.xpath(MessageCenterWebElement.MY_DEAL_INPUT_BOX)).click();
		webdriver.findElement(By.xpath(MessageCenterWebElement.MY_DEAL_INPUT_BOX)).sendKeys(dealName);
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-3']");
		webdriver.findElement(By.xpath("//*[@id='ui-id-3']")).click();									// -- Click on auto-suggest results
		webdriver.findElement(By.id("myDealSubmit")).click();
		System.out.println("Deal Selected");
		Thread.sleep(2000);
	}
//	
//	public static void selectMyLoanDeal() throws InterruptedException {
//		WebDriver webdriver = SeleniumWebDriver.Instance();
//		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='selectDeals']");						// click on deal
//		webdriver.findElement(By.xpath("//*[@id='selectDeals']")).click();
//		SeleniumHelper.WaitForPresenceOfElementById("input_select");									// Loan deal name in input box
//		webdriver.findElement(By.id("input_select")).sendKeys("BURGER KING");
//		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='ui-id-3']");
//		webdriver.findElement(By.xpath("//*[@id='ui-id-3']")).click();									// Click on auto-suggest results
//		webdriver.findElement(By.id("myDealSubmit")).click();
//		System.out.println("Loan Deal Selected");
//		Thread.sleep(2000);
//	}
	
	public static void selectPrivateLoanRadio() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='message_type_container']/span/label[2]");						// click on Private radio
		webdriver.findElement(By.xpath("//*[@id='message_type_container']/span/label[2]")).click();
		
	}
	
	public static void selectPublicLoanRadio() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='message_type_container']/span/label[1]");						// click on Public radio
		webdriver.findElement(By.xpath("//*[@id='message_type_container']/span/label[1]")).click();
		
	}
	
	public static void loanMessagePopup() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='selectDeals']");						// click on (?) for popup
		webdriver.findElement(By.xpath("//*[@id='selectDeals']")).click();
		
	}
	
		
	public static void selectMyRole() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='selectRoles']");						// click on Roles
		webdriver.findElement(By.xpath("//*[@id='selectRoles']")).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='roleSelection']/table/tbody/tr[2]/td[1]/label");
		webdriver.findElement(By.xpath("//*[@id='roleSelection']/table/tbody/tr[2]/td[1]/label")).click();
		webdriver.findElement(By.id("SelectRoleSubmit")).click();
		System.out.println("Role Selected");
		Thread.sleep(2000);
	}
	
	public static void enterSubjectAndMessage(String Subject) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementById("query_subject");	
		webdriver.findElement(By.id("query_subject")).sendKeys(Subject);			// Enter Subject
		System.out.println("Subject Entered");
		webdriver.findElement(By.id("query_message")).sendKeys("Body of an Automated message is here. "
				+ "Lorem ipsum dolor sit amet, consectetuer adipiscing elit.");					// Enter Body
		System.out.println("Body Entered");
		webdriver.findElement(By.xpath("//*[@id='newQueryForm']/div[4]/label")).click();						// check Contact Escrow
		System.out.println("ContactEscrow Selected");
		webdriver.findElement(By.id("query_post_trigger")).click();						// submit Query
		System.out.println("Query Submitted Successfully");
	}
	
	public static String confirmQuerySubmission() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='newQuery']/div/form[2]/section[1]/span[2]");
		String ConfirmedSubject = webdriver.findElement(By.xpath("//*[@id='newQuery']/div/form[2]/section[1]/span[2]")).getText();
		System.out.println("Confirmed subject is " + ConfirmedSubject);
		webdriver.findElement(By.xpath("//*[@id='newQuery']/p/a")).click();							// Click on "Back To Inbox"
		return ConfirmedSubject;
	}
	
	public static String confirmQueryOnMessageCentreDashboard() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='inbox']/div[2]/div[2]/table/tbody/tr[1]/td[1]/div");     // Checking for subject of thread  
		String ActiveDashBoardSubject = webdriver.findElement(By.xpath("//*[@id='inbox']/div[2]/div[2]/table/tbody/tr[1]/td[1]/div")).getText();
		System.out.println("Active DashBoard subject is " + ActiveDashBoardSubject);
		webdriver.findElement(By.xpath("//*[@id='inbox']/div[2]/div[2]/table/tbody/tr[1]/td[1]/div")).click();
		return ActiveDashBoardSubject;
	}

	public static void archiveMessageThread() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("/*[@id='inbox']/div[2]/div[2]/table/tbody/tr/td[4]/a");
		webdriver.findElement(By.xpath("//*[@id='inbox']/div[2]/div[2]/table/tbody/tr[1]/td[4]/a")).click();		// Click on Archive icon
		Thread.sleep(1500);             //*[@id="inbox"]/div[2]/div[2]/table/tbody/tr/td[4]/a 
	}
	
	public static void unarchiveMessageThread() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.xpath("//*[@id='inbox']/div[2]/div[2]/table/tbody/tr[1]/td[4]/a")).click();		// Click on UnArchive icon
		Thread.sleep(1500);
	}

	public static void goToArchivedMessageTab() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/div/div/div/div[3]/div[1]/ul/li[2]/a/span[2]");
		webdriver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/ul/li[2]/a/span[2]")).click();         // Clicking on "Archived" Tab
		System.out.println("In Archived Message Tab");
	}
	
	public static String confirmQueryOnArchivedMessageCentreDashboard() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("//*[@id='inbox']/div[2]/div[2]/table/tbody/tr[1]/td[1]/div");     // Checking for subject of thread in Archived Tab 
		String ArchivedDashBoardSubject = webdriver.findElement(By.xpath("//*[@id='inbox']/div[2]/div[2]/table/tbody/tr[1]/td[1]/div")).getText();
		System.out.println("Archived DashBoard subject is " + ArchivedDashBoardSubject);
		return ArchivedDashBoardSubject;
	}

	public static void goToActiveMessageTab() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath("/html/body/div/div/div/div[3]/div[1]/ul/li[2]/a/span[2]");
		webdriver.findElement(By.xpath("/html/body/div/div/div/div[3]/div[1]/ul/li[2]/a/span[2]")).click();
		System.out.println("In Archived Message Tab");
		
	}

	public static void goToAlphabetMessageThread() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_ALPHABET_MESSAGE_THREAD);
		webdriver.findElement(By.xpath(MessageCenterWebElement.XPATH_TO_ALPHABET_MESSAGE_THREAD)).click();
		System.out.println("In Alphabet Message Thread Message ");
		Thread.sleep(1500);
		
	}

	public static String verifyThreadPSTTimezone() throws InterruptedException {
		MessageCenterOperations.applyPSTTimeZone();
		String messageTimeStamp = MessageCenterOperations.getMessageThreadTimeStamp();
		System.out.println("Showing message time stamp is 1 =  " +  messageTimeStamp);
		return messageTimeStamp;
	}

	public static String verifyThreadESTTimezone() throws InterruptedException {
		MessageCenterOperations.applyESTTimeZone();
		String messageTimeStamp = MessageCenterOperations.getMessageThreadTimeStamp();
		System.out.println("Showing message time stamp is 1 =  " +  messageTimeStamp);
		return messageTimeStamp;
	}

	public static String verifyThreadGMTTimezone() throws InterruptedException {
		MessageCenterOperations.applyGMTTimeZone();
		String messageTimeStamp = MessageCenterOperations.getMessageThreadTimeStamp();
		System.out.println("Showing message time stamp is 1 =  " +  messageTimeStamp);
		return messageTimeStamp;
	}
	
	public static String verifyInboxPSTTimezone() throws InterruptedException {
		MessageCenterOperations.applyPSTTimeZone();
		String messageTimeStamp = MessageCenterOperations.getMessageInboxTimeStamp();
		System.out.println("Showing message time stamp is 1 =  " +  messageTimeStamp);
		return messageTimeStamp;
	}

	public static String verifyInboxESTTimezone() throws InterruptedException {
		MessageCenterOperations.applyESTTimeZone();
		String messageTimeStamp = MessageCenterOperations.getMessageInboxTimeStamp();
		System.out.println("Showing message time stamp is 1 =  " +  messageTimeStamp);
		return messageTimeStamp;
	}

	public static String verifyInboxGMTTimezone() throws InterruptedException {
		MessageCenterOperations.applyGMTTimeZone();
		String messageTimeStamp = MessageCenterOperations.getMessageInboxTimeStamp();
		System.out.println("Showing message time stamp is 1 =  " +  messageTimeStamp);
		return messageTimeStamp;
	}

	public static void selectGroup() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.GROUP_CHECKBOX);
		webdriver.findElement(By.xpath(MessageCenterWebElement.GROUP_CHECKBOX)).click();
		
	}

	public static void suppressDomain() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementById(MessageCenterWebElement.DOMAIN_SUPPRESSION);	
		webdriver.findElement(By.id(MessageCenterWebElement.DOMAIN_SUPPRESSION)).sendKeys("Suppressdomain.com");
		
	}

	public static void verifyNonMemberStatus(Integer nonMemberRecipients) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementById(MessageCenterWebElement.NON_MEMBER_STATUS);	
		webdriver.findElement(By.xpath(MessageCenterWebElement.NON_MEMBER_STATUS)).getText();
		Assert.assertEquals("Also send to investors who hold this asset(s) but have not joined this group. (Recommended: expands your audience.)", 
				webdriver.findElement(By.xpath(MessageCenterWebElement.NON_MEMBER_STATUS)).getText());
		if(nonMemberRecipients == 0){
		webdriver.findElement(By.xpath(MessageCenterWebElement.NON_MEMBER_STATUS)).click();    // Do not include Non-members as recipient
		System.out.println("Non Member recipients are EXCLUDED.");
		}
		else{
			System.out.println("Non Member recipients are INCLUDED.");
		}
	}

	public static void verifyThreadDetails(Integer threadType) {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementById(MessageCenterWebElement.THREAD_DETAILS_DEALS);	
		
		//DEAL NAME
		if(threadType == 1 || threadType == 5 || threadType == 8 ){
			Assert.assertEquals("Deals: PLMRS 2014-1A D", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
		}
		else if(threadType == 2 || threadType == 3 || threadType == 6 || threadType == 7){
			Assert.assertEquals("Deals: BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
		}
		
		//ROLES
		if(threadType == 4){
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP_ROLES_AT1)).getText());
		}
		else if(threadType == 1 || threadType == 2 || threadType == 3 || threadType == 5 || threadType == 6 || threadType == 7){
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_ROLES)).getText());
		}
		
		// LOAN STATUS
		if(threadType == 2 || threadType == 7){
			Assert.assertEquals("Status: Private", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_STATUS)).getText());
		}
		else if(threadType == 3 || threadType == 6){
			Assert.assertEquals("Status: Public", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_STATUS)).getText());
		}
	
		// GROUP NAME
		if(threadType == 4 || threadType == 8){
			Assert.assertEquals("Groups: Buyside bank debt list", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP_NAME_AT2)).getText());
		}
		else if(threadType == 5){
			Assert.assertEquals("Groups: Buyside bank debt list", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP_NAME_AT3)).getText());
		}
		else if(threadType == 6 || threadType == 7){
			Assert.assertEquals("Groups: Buyside bank debt list", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP)).getText());
		}
	}

	public static void runMessageQuery() throws InterruptedException {
		SeleniumHelper.Navigate(BasePageObject.baseurl +"/cron/message_query");
		Thread.sleep(2000);
			
	}

	public static void runNewComplianceChecks() throws InterruptedException {
		SeleniumHelper.Navigate(BasePageObject.baseurl +"/cron/new_compliance_checks");
		Thread.sleep(2000);
	}

	public static void scanMailLogs() throws InterruptedException {
		SeleniumHelper.Navigate(BasePageObject.baseurl +"/cron/scan_mail_log");
		Thread.sleep(2000);
		
	}

	public static void goToMessageCenterTab() throws InterruptedException {
		SeleniumHelper.Navigate(BasePageObject.baseurl +"/messagecenter");
		Thread.sleep(3000);
		
	}

	public static void verifydomainSuppressedQuery(Integer a) throws InterruptedException {
		MessageCenterOperations.approveMessageThreads(a);
		
	}
	
	public static void goToAdminAccount(){
		System.out.println("Login to Deal vector");
		LoginPage.Goto();
		LoginPage.LoginAs(MessageCenterWebElement.ADMIN_USERNAME).WithPassword(MessageCenterWebElement.PASSWORD).Login();
//		Assert.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Deal vector Admin Account");
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.DOMAIN_SUPPRESSION_LINK);
		webdriver.findElement(By.xpath(MessageCenterWebElement.DOMAIN_SUPPRESSION_LINK)).click();								// Going to Message Centre page

	}

	public static void goToRecipientsAccount() {
		System.out.println("Login to Deal vector");
		LoginPage.Goto();
		LoginPage.LoginAs(MessageCenterWebElement.RECIPIENT_USERNAME).WithPassword(MessageCenterWebElement.PASSWORD).Login();
//		Assert.assertTrue(LoginPage.IsLoginSuccessful());
		System.out.println("Logged on to Recipients Account ");
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_MESSAGECENTER_TAB);
		SeleniumHelper.Navigate(BasePageObject.baseurl + "/messagecenter");								// Going to Message Centre page
		
	}

	public static void verifyRecipientsThreadDetails(Integer a) throws InterruptedException {
		MessageCenterOperations.goToMessageThread(a);
		MessageCenterOperations.verifyThreadDetailsRecipients(a);
		
	}

	public static String countOfMessageCenter() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.COUNT_OF_MESSAGECENTER);
		String messageCount = webdriver.findElement(By.xpath(MessageCenterWebElement.COUNT_OF_MESSAGECENTER)).getText();
		return messageCount;
	}

}



