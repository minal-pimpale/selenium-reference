package selenium.pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
import WebElement.MessageCenterWebElement;

public class MessageCenterOperations {

	public static void applyPSTTimeZone() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_TIME_ZONE_DROPDOWN);
		webdriver.findElement(By.xpath(MessageCenterWebElement.XPATH_TO_TIME_ZONE_DROPDOWN)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_PST_TIME_ZONE);
		webdriver.findElement(By.xpath(MessageCenterWebElement.XPATH_TO_PST_TIME_ZONE)).click();
		System.out.println("Applying PST Time Zone ");
		Thread.sleep(9000);
		
	}

	public static void applyESTTimeZone() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_TIME_ZONE_DROPDOWN);
		webdriver.findElement(By.xpath(MessageCenterWebElement.XPATH_TO_TIME_ZONE_DROPDOWN)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_EST_TIME_ZONE);
		webdriver.findElement(By.xpath(MessageCenterWebElement.XPATH_TO_EST_TIME_ZONE)).click();
		System.out.println("Applying EST Time Zone ");
		Thread.sleep(9000);
		
	}
	
	public static void applyGMTTimeZone() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_TIME_ZONE_DROPDOWN);
		webdriver.findElement(By.xpath(MessageCenterWebElement.XPATH_TO_TIME_ZONE_DROPDOWN)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_GMT_TIME_ZONE);
		webdriver.findElement(By.xpath(MessageCenterWebElement.XPATH_TO_GMT_TIME_ZONE)).click();
		System.out.println("Applying GMT Time Zone ");
		Thread.sleep(9000);
		
	}
	
	public static String getMessageThreadTimeStamp() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_ALPHA_THREAD_MESSAGE_TIME);
		String messageTimeStamp = webdriver.findElement(By.xpath(MessageCenterWebElement.XPATH_TO_ALPHA_THREAD_MESSAGE_TIME)).getText();
		System.out.println("Showing message time stamp is =  " +  messageTimeStamp);
		return messageTimeStamp;
				
	}

	public static String getMessageInboxTimeStamp() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.XPATH_TO_ALPHA_THREAD_INBOX_MESSAGE_TIME);
		String messageTimeStamp = webdriver.findElement(By.xpath(MessageCenterWebElement.XPATH_TO_ALPHA_THREAD_INBOX_MESSAGE_TIME)).getText();
		System.out.println("Showing message time stamp is =  " +  messageTimeStamp);
		return messageTimeStamp;
	}

	public static void approveMessageThreads(Integer a) throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.SUPPRESSION_APPROVE_LINK);
		webdriver.findElement(By.xpath(MessageCenterWebElement.SUPPRESSION_APPROVE_LINK)).click();
		Thread.sleep(3000);
		Assert.assertEquals("DV 5505 abc18 user abc18@capital.com", webdriver.findElement(By.xpath(MessageCenterWebElement.VERIFY_SENDER)).getText());
		if(a == 1){
			Assert.assertEquals("Group Message to BuysideBank Debt List", webdriver.findElement(By.xpath(MessageCenterWebElement.VERIFY_SUBJECT)).getText());
		}
		else{
			Assert.assertEquals("Group Message with private loan deal (NON-MEMBER) to BuysideBank Debt List", webdriver.findElement(By.xpath(MessageCenterWebElement.VERIFY_SUBJECT)).getText());
		}
		Assert.assertEquals("Body of an Automated message is here. Lorem ipsum dolor sit amet, consectetuer adipiscing elit.", webdriver.findElement(By.xpath(MessageCenterWebElement.VERIFY_BODY)).getText());
		Assert.assertEquals("Buyside bank debt list", webdriver.findElement(By.xpath(MessageCenterWebElement.VERIFY_GROUP)).getText());
		Assert.assertEquals("Suppressdomain.com", webdriver.findElement(By.xpath(MessageCenterWebElement.VERIFY_SUPPRESSED_DOMAIN)).getText());
		webdriver.findElement(By.xpath(MessageCenterWebElement.APPROVE_QUERY_BUTTON)).click();
		
	}

	public static void goToMessageThread(int a) throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		switch(a) {
		case 1:
		{
			System.out.println("Verifying details of thread 1 \n"
					+ "-------------------------------------------------");
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.THREAD_1);
			webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_1)).click();
			break;
		}
		case 2:
		{
			System.out.println("Verifying details of thread 2 \n"
					+ "-------------------------------------------------");
			privateLoanTextVerificationBeforeConfirmation27();
			loanStatusOnThread27();
			break;
		}
		case 3:
		{
			System.out.println("Verifying details of thread 3 \n"
					+ "-------------------------------------------------");
			publicLoanTextVerificationBeforeConfirmation26();
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.THREAD_3);
			webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_3)).click();
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.PUBLIC_LAON_STATUS_COMFIRMATION_TEXT);
			Assert.assertEquals("This message has been directed by the sender toward members who are public on this "
					+ "deal. By clicking \"View\", you are affirming that you treat all postings to this message "
					+ "thread as public, and will not reveal any MNPI in your possession in the event that you are "
					+ "private on this deal. You will also know that all other members viewing this message have made a similar affirmation "
					+ "to refrain from posting MNPI on this message thread. If you do not agree to these "
					+ "terms, click \"Discard\".", webdriver.findElement(By.xpath(MessageCenterWebElement.PUBLIC_LAON_STATUS_COMFIRMATION_TEXT)).getText());
			webdriver.findElement(By.xpath(MessageCenterWebElement.LOAN_VIEW_BUTTON_THREAD_26)).click();
			break;
		}
		case 4:
		{
			System.out.println("Verifying details of thread 4 \n"
					+ "-------------------------------------------------");
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.THREAD_4);
			webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_4)).click();
			break;
		}
		case 5:
		{
			System.out.println("Verifying details of thread 5 \n"
					+ "-------------------------------------------------");
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.THREAD_5);
			webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_5)).click();
			break;
		}
		case 6:
		{
			System.out.println("Verifying details of thread 6 \n"
					+ "-------------------------------------------------");
			publicLoanTextVerificationBeforeConfirmation23();
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.THREAD_6);
			webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_6)).click();
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.PUBLIC_LAON_STATUS_COMFIRMATION_TEXT);
			Assert.assertEquals("This message has been directed by the sender toward members who are public on this "
					+ "deal. By clicking \"View\", you are affirming that you treat all postings to this message "
					+ "thread as public, and will not reveal any MNPI in your possession in the event that you are "
					+ "private on this deal. You will also know that all other members viewing this message have made a similar affirmation "
					+ "to refrain from posting MNPI on this message thread. If you do not agree to these "
					+ "terms, click \"Discard\".", webdriver.findElement(By.xpath(MessageCenterWebElement.PUBLIC_LAON_STATUS_COMFIRMATION_TEXT)).getText());
			webdriver.findElement(By.xpath(MessageCenterWebElement.LOAN_VIEW_BUTTON_THREAD_23)).click();
			break;
		}
		case 7:
		{
			System.out.println("Verifying details of thread 7 \n"
					+ "-------------------------------------------------");
			privateLoanTextVerificationBeforeConfirmation22();
			loanStatusOnThread22();
			break;
		}
		case 8:
		{System.out.println("Verifying details of thread 8 \n"
				+ "-------------------------------------------------");
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.THREAD_8);
			webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_8)).click();
			break;
		}
		case 9:
		{System.out.println("Verifying details of thread 9 \n"
				+ "-------------------------------------------------");
			SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.THREAD_9);
			webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_9)).click();
			break;
		}
	  }
		
	}

	private static void loanStatusOnThread22() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.xpath(MessageCenterWebElement.LOAN_VIEW_22)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.PRIVATE_LAON_STATUS_COMFIRMATION_TEXT);
		Assert.assertEquals("This message has been directed by the sender toward members who are private on this deal. By clicking \"View\", "
				+ "you are affirming that you are an insider on this deal, and authorized to receive material non-public information. "
				+ "You will also know that all other members viewing this message and any subsequent replies have made a similar affirmation. "
				+ "If you are not private on this deal, click \"Discard\".", webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LAON_STATUS_COMFIRMATION_TEXT)).getText());
		
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LAON_STATUS_COMFIRMATION_TEXT)).getText());
		webdriver.findElement(By.xpath(MessageCenterWebElement.LOAN_VIEW_BUTTON_THREAD_22)).click();
		
		
	}

	private static void privateLoanTextVerificationBeforeConfirmation22() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.DEAL_NAME_BEFORE_CONFIRMATION_THREAD_22);
		Assert.assertEquals("BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.DEAL_NAME_BEFORE_CONFIRMATION_THREAD_22)).getText());
		Assert.assertEquals("Private Message", webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_BEFORE_CONFIRMATION_THREAD_22)).getText());
		webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_ICON_22)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT);
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT)).getText());
		Assert.assertEquals("This message has been designated as private by the sender. To view the message, you need to affirm your private status. "
				+ "If you are not private, click discard and it will be removed from your message center.", webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT)).getText());
		webdriver.findElement(By.xpath(MessageCenterWebElement.CLOSE_POPUP_22)).click();
		
	}

	private static void publicLoanTextVerificationBeforeConfirmation23() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.DEAL_NAME_BEFORE_CONFIRMATION_THREAD_23);
		Assert.assertEquals("BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.DEAL_NAME_BEFORE_CONFIRMATION_THREAD_23)).getText());
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_BEFORE_CONFIRMATION_THREAD_23)).getText());
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_BEFORE_CONFIRMATION_THREAD_23)).getText(),
				"Automation Loan Public Test Subject"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_BEFORE_CONFIRMATION_THREAD_23)).getText(),
				"Public Message"));
		
	}

	private static void loanStatusOnThread27() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		webdriver.findElement(By.xpath(MessageCenterWebElement.LOAN_VIEW_27)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.PRIVATE_LAON_STATUS_COMFIRMATION_TEXT);
		Assert.assertEquals("This message has been directed by the sender toward members who are private on this deal. By clicking \"View\", "
				+ "you are affirming that you are an insider on this deal, and authorized to receive material non-public information. "
				+ "You will also know that all other members viewing this message and any subsequent replies have made a similar affirmation. "
				+ "If you are not private on this deal, click \"Discard\".", webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LAON_STATUS_COMFIRMATION_TEXT)).getText());
		
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LAON_STATUS_COMFIRMATION_TEXT)).getText());
		webdriver.findElement(By.xpath(MessageCenterWebElement.LOAN_VIEW_BUTTON_THREAD_27)).click();
					
	}
	
	private static void publicLoanTextVerificationBeforeConfirmation26() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.DEAL_NAME_BEFORE_CONFIRMATION_THREAD_26);
		Assert.assertEquals("BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.DEAL_NAME_BEFORE_CONFIRMATION_THREAD_26)).getText());
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_BEFORE_CONFIRMATION_THREAD_26)).getText());
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_BEFORE_CONFIRMATION_THREAD_26)).getText(),
				"Group Message with public loan deal to BuysideBank Debt List"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_BEFORE_CONFIRMATION_THREAD_26)).getText(),
				"Public Message"));
	}

	private static void privateLoanTextVerificationBeforeConfirmation27() throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.DEAL_NAME_BEFORE_CONFIRMATION_THREAD_27);
		Assert.assertEquals("BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.DEAL_NAME_BEFORE_CONFIRMATION_THREAD_27)).getText());
		Assert.assertEquals("Private Message", webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_BEFORE_CONFIRMATION_THREAD_27)).getText());
		webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_ICON_27)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT);
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT)).getText());
		Assert.assertEquals("This message has been designated as private by the sender. To view the message, you need to affirm your private status. "
				+ "If you are not private, click discard and it will be removed from your message center.", webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT)).getText());
		webdriver.findElement(By.xpath(MessageCenterWebElement.CLOSE_POPUP_27)).click();
		
	}

	public static void verifyThreadDetailsRecipients(Integer a) throws InterruptedException {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.THREAD_SUBJECT);
		switch (a){
		case 1:
		{
			Assert.assertEquals("Group Message with deal to BuysideBank Debt "
					+ "List- Exclude NOn-Member", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_SUBJECT)).getText());
			Assert.assertEquals("Deals: PLMRS 2014-1A D", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
			System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
			Assert.assertEquals("Groups: Buyside bank debt list", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP_NAME_AT2)).getText());
			System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP_NAME_AT2)).getText());
			Assert.assertEquals("(You are receiving this because you are in the following group: Buyside bank debt list)", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_POPULATING_REASON)).getText());
			System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_POPULATING_REASON)).getText());
			MessageCentrePageObject.goToMessageCenterTab();
			break;
		}
		case 2:
		{
			Assert.assertEquals("Group Message with private loan deal (NON-MEMBER)"
					+ " to BuysideBank Debt List", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_SUBJECT)).getText());
			Assert.assertEquals("Deals: BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_ROLES)).getText());
			Assert.assertEquals("Status: Private", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_STATUS)).getText());
			Assert.assertEquals("Groups: Buyside bank debt list", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP)).getText());
			Assert.assertEquals("(You are receiving this because you are in the following group: Buyside bank debt list)", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_POPULATING_REASON)).getText());
			MessageCentrePageObject.goToMessageCenterTab();
			privateLoanTextVerificationAfterConfirmation27();
			break;
		}
		case 3:
		{
			Assert.assertEquals("Group Message with public loan deal to BuysideBank Debt List", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_SUBJECT)).getText());
			Assert.assertEquals("Deals: BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_ROLES)).getText());
			Assert.assertEquals("Status: Public", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_STATUS)).getText());
			Assert.assertEquals("Groups: Buyside bank debt list", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP)).getText());
			Assert.assertEquals("(You are receiving this because you are in the following group: Buyside bank debt list)", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_POPULATING_REASON)).getText());
			MessageCentrePageObject.goToMessageCenterTab();
			break;
		}
		case 4:
		{
			Assert.assertEquals("Group Message with deal to BuysideBank Debt List", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_SUBJECT)).getText());
			Assert.assertEquals("Deals: PLMRS 2014-1A D", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_ROLES)).getText());
			Assert.assertEquals("Groups: Buyside bank debt list", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP_NAME_AT3)).getText());
			Assert.assertEquals("(You are receiving this because you are in the following group: Buyside bank debt list)", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_POPULATING_REASON)).getText());
			MessageCentrePageObject.goToMessageCenterTab();
			break;
		}
		case 5:
		{
			Assert.assertEquals("Group Message to BuysideBank Debt List", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_SUBJECT)).getText());
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP_ROLES_AT1)).getText());
			Assert.assertEquals("Groups: Buyside bank debt list", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_GROUP_NAME_AT2)).getText());
			Assert.assertEquals("(You are receiving this because you are in the following group: Buyside bank debt list)", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_POPULATING_REASON)).getText());
			MessageCentrePageObject.goToMessageCenterTab();
			break;
		}
		case 6:
		{
			Assert.assertEquals("Automation Loan Public Test Subject", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_SUBJECT)).getText());
			Assert.assertEquals("Deals: BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_ROLES)).getText());
			Assert.assertEquals("Status: Public", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_STATUS)).getText());
			MessageCentrePageObject.goToMessageCenterTab();
			break;
		}
		case 7:
		{
			Assert.assertEquals("Automation Loan Private Test Subject", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_SUBJECT)).getText());
			Assert.assertEquals("Deals: BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_ROLES)).getText());
			Assert.assertEquals("Status: Private", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_STATUS)).getText());
			MessageCentrePageObject.goToMessageCenterTab();
			privateLoanTextVerificationAfterConfirmation22();
			break;
		}
		case 8:
		{
			Assert.assertEquals("Automation Test Subject", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_SUBJECT)).getText());
			Assert.assertEquals("Deals: PLMRS 2014-1A D", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_ROLES)).getText());
			MessageCentrePageObject.goToMessageCenterTab();
			break;
		}
		case 9:
		{
			Assert.assertEquals("Deals: Alphabet 2015-2 CL A2 (63939GAB4)", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_DEALS)).getText());
			Assert.assertEquals("Roles: Investor", webdriver.findElement(By.xpath(MessageCenterWebElement.THREAD_DETAILS_ROLES)).getText());
			MessageCentrePageObject.goToMessageCenterTab();
			break;
		}
		
	  }
	}

	private static void privateLoanTextVerificationAfterConfirmation22() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.DEAL_NAME_AFTER_CONFIRMATION_THREAD_22);
		Assert.assertEquals("BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.DEAL_NAME_AFTER_CONFIRMATION_THREAD_22)).getText());
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_AFTER_CONFIRMATION_THREAD_22)).getText());
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_AFTER_CONFIRMATION_THREAD_22)).getText(),
				"Automation Loan Private Test Subject"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_AFTER_CONFIRMATION_THREAD_22)).getText(),
				"Private Message"));
		webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_ICON_AFTER_VIEW)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_AFTER_VIEW);
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_AFTER_VIEW)).getText());
		Assert.assertEquals("This message has been designated as private by the sender and you have affirmed your private status"
				+ " on this.", webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_AFTER_VIEW)).getText());
		webdriver.findElement(By.xpath(MessageCenterWebElement.CLOSE_POPUP_22)).click();
		
	}

	private static void privateLoanTextVerificationAfterConfirmation27() {
		WebDriver webdriver = SeleniumWebDriver.Instance();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.DEAL_NAME_AFTER_CONFIRMATION_THREAD_27);
		Assert.assertEquals("BURGER KING", webdriver.findElement(By.xpath(MessageCenterWebElement.DEAL_NAME_AFTER_CONFIRMATION_THREAD_27)).getText());
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_AFTER_CONFIRMATION_THREAD_27)).getText());
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_AFTER_CONFIRMATION_THREAD_27)).getText(),
				"Group Message with private loan deal (NON-MEMBER) to BuysideBank Debt List"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(webdriver.findElement(By.xpath(MessageCenterWebElement.SUBJECT_AFTER_CONFIRMATION_THREAD_27)).getText(),
				"Private Message"));
		webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_ICON_AFTER_VIEW)).click();
		SeleniumHelper.WaitForPresenceOfElementByXPath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_AFTER_VIEW);
		System.out.println(webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_AFTER_VIEW)).getText());
		Assert.assertEquals("This message has been designated as private by the sender and you have affirmed your private status"
				+ " on this.", webdriver.findElement(By.xpath(MessageCenterWebElement.PRIVATE_LOAN_EXPLAINATORY_TEXT_AFTER_VIEW)).getText());
		webdriver.findElement(By.xpath(MessageCenterWebElement.CLOSE_POPUP_27)).click();
		
	}


}









