package junit.tests;

//import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import WebElement.MessageCenterWebElement;
import selenium.pageobject.LoginPage;
import selenium.pageobject.MessageCentrePageObject;
import selenium.utils.SeleniumHelper;
import selenium.utils.SeleniumWebDriver;
/* Total 8+3+4+9+9=33 test cases*/
public class MessageCentre {
	
	@Test(priority=1)
	public void messageCenterTestSuite() throws InterruptedException {
		MessageCentrePageObject.goToUserMessageCentre();
		
	/* ***************************messageThreadArchive*************************************** */		
	 	
		
//		String ActiveDashBoardSubject = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
//		MessageCentrePageObject.archiveMessageThread();
//		MessageCentrePageObject.goToArchivedMessageTab();
//		String ArchivedDashBoardSubject = MessageCentrePageObject.confirmQueryOnArchivedMessageCentreDashboard();
//		Assert.assertEquals(ActiveDashBoardSubject, ArchivedDashBoardSubject);
//		MessageCentrePageObject.goToMessageCenterTab();
		

	/* ***************************messageThreadUnArchive*************************************** */	
	
		
//		MessageCentrePageObject.goToArchivedMessageTab();
//		String ArchivedDashBoardSubject1 = MessageCentrePageObject.confirmQueryOnArchivedMessageCentreDashboard();
//		MessageCentrePageObject.unarchiveMessageThread();
//		String ActiveDashBoardSubject1 = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
//		Assert.assertEquals(ActiveDashBoardSubject1, ArchivedDashBoardSubject1);

		
	/* ***************************newMessage*************************************** */	
	
	
		MessageCentrePageObject.createNewMessage("ByDeal");
		MessageCentrePageObject.selectMyDeal("PLMRS 2014-1A D");
		MessageCentrePageObject.selectMyRole();
		MessageCentrePageObject.enterSubjectAndMessage("Automation Test Subject");
		Assert.assertEquals("Automation Test Subject", MessageCentrePageObject.confirmQuerySubmission());
		String ConfirmedSubject = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject,"Automation Test Subject"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject,"PLMRS 2014-1A D"));
		MessageCentrePageObject.verifyThreadDetails(1);
		MessageCentrePageObject.goToMessageCenterTab();

	
	/* ***************************newPrivateLoanMessage*************************************** */
	
	
		MessageCentrePageObject.createNewMessage("ByDeal");
		MessageCentrePageObject.selectMyDeal("BURGER KING");
		MessageCentrePageObject.selectPrivateLoanRadio();
		MessageCentrePageObject.selectMyRole();
		MessageCentrePageObject.enterSubjectAndMessage("Automation Loan Private Test Subject");
		Assert.assertEquals("Automation Loan Private Test Subject", MessageCentrePageObject.confirmQuerySubmission());
		String ConfirmedSubject1 = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject1,"Automation Loan Private Test Subject"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject1,"BURGER KING"));
		MessageCentrePageObject.verifyThreadDetails(2);
		MessageCentrePageObject.goToMessageCenterTab();

		
	/* ***************************newPublicLoanMessage*************************************** */	
	
	
		MessageCentrePageObject.createNewMessage("ByDeal");
		MessageCentrePageObject.selectMyDeal("BURGER KING");
		MessageCentrePageObject.selectPublicLoanRadio();
		MessageCentrePageObject.selectMyRole();
		MessageCentrePageObject.enterSubjectAndMessage("Automation Loan Public Test Subject");
		Assert.assertEquals("Automation Loan Public Test Subject", MessageCentrePageObject.confirmQuerySubmission());
		String ConfirmedSubject2 = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject2,"Automation Loan Public Test Subject"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject2,"BURGER KING"));
		MessageCentrePageObject.verifyThreadDetails(3);
		MessageCentrePageObject.goToMessageCenterTab();

	
	/* ***************************messageCentreThreadTimeZone*************************************** */	
	
	
		MessageCentrePageObject.goToAlphabetMessageThread();
		Assert.assertEquals("05/27/2016 2:19 AM", MessageCentrePageObject.verifyThreadPSTTimezone());
		Assert.assertEquals("05/27/2016 5:19 AM", MessageCentrePageObject.verifyThreadESTTimezone());
		Assert.assertEquals("05/27/2016 9:19 AM", MessageCentrePageObject.verifyThreadGMTTimezone());
		MessageCentrePageObject.goToMessageCenterTab();

		
	/* ***************************messageCentreInboxTimeZone*************************************** */	
	
		
		Assert.assertEquals("05/27/16 2:19 AM", MessageCentrePageObject.verifyInboxPSTTimezone());
		Assert.assertEquals("05/27/16 5:19 AM", MessageCentrePageObject.verifyInboxESTTimezone());
		Assert.assertEquals("05/27/16 9:19 AM", MessageCentrePageObject.verifyInboxGMTTimezone());

		
	/* ***************************groupMessage*************************************** */	
	
		
		MessageCentrePageObject.createNewMessage("ByGroup");
		MessageCentrePageObject.selectGroup();
		MessageCentrePageObject.suppressDomain();
		MessageCentrePageObject.enterSubjectAndMessage("Group Message to BuysideBank Debt List");
		Assert.assertEquals("Group Message to BuysideBank Debt List", MessageCentrePageObject.confirmQuerySubmission());
		String ConfirmedSubject3 = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject3,"Group Message to BuysideBank Debt List"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject3,"Buyside bank debt list"));
		MessageCentrePageObject.verifyThreadDetails(4);
		MessageCentrePageObject.goToMessageCenterTab();

		
	/* ***************************groupMessageWithDeal*************************************** */
	
	
		MessageCentrePageObject.createNewMessage("ByGroup");
		MessageCentrePageObject.selectGroup();
		MessageCentrePageObject.selectMyDeal("PLMRS 2014-1A D");
		MessageCentrePageObject.enterSubjectAndMessage("Group Message with deal to BuysideBank Debt List");
		Assert.assertEquals("Group Message with deal to BuysideBank Debt List", MessageCentrePageObject.confirmQuerySubmission());
		String ConfirmedSubject4 = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject4,"Group Message with deal to BuysideBank Debt List"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject4,"PLMRS 2014-1A D"));
		MessageCentrePageObject.verifyThreadDetails(5);
		MessageCentrePageObject.goToMessageCenterTab();

		
	/* ***************************groupMessageWithPublicLoanDeal*************************************** */	
	
		
		MessageCentrePageObject.createNewMessage("ByGroup");
		MessageCentrePageObject.selectGroup();
		MessageCentrePageObject.selectMyDeal("BURGER KING");
		MessageCentrePageObject.selectPublicLoanRadio();
		MessageCentrePageObject.enterSubjectAndMessage("Group Message with public loan deal to BuysideBank Debt List");
		Assert.assertEquals("Group Message with public loan deal to BuysideBank Debt List", MessageCentrePageObject.confirmQuerySubmission());
		String ConfirmedSubject5 = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject5,"Group Message with public loan deal to BuysideBank Debt List"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject5,"BURGER KING"));
		MessageCentrePageObject.verifyThreadDetails(6);
		MessageCentrePageObject.goToMessageCenterTab();

	
	/* ***************************groupMessageWithPrivateLoanDeal*************************************** */	
	
			
		MessageCentrePageObject.createNewMessage("ByGroup");
		MessageCentrePageObject.selectGroup();
		MessageCentrePageObject.selectMyDeal("BURGER KING");
		MessageCentrePageObject.verifyNonMemberStatus(1);            // Non-Member Recipients Included
		MessageCentrePageObject.selectPrivateLoanRadio();
		MessageCentrePageObject.suppressDomain();
		MessageCentrePageObject.enterSubjectAndMessage("Group Message with private loan deal (NON-MEMBER) to BuysideBank Debt List");
		Assert.assertEquals("Group Message with private loan deal (NON-MEMBER) to BuysideBank Debt List", MessageCentrePageObject.confirmQuerySubmission());
		String ConfirmedSubject6 = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject6,"Group Message with private loan deal (NON-MEMBER) to BuysideBank Debt List"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject6,"BURGER KING"));
		MessageCentrePageObject.verifyThreadDetails(7);
		MessageCentrePageObject.goToMessageCenterTab();

		
    /* ***************************groupMessageWithOutNonMember*************************************** */	
	
		
		MessageCentrePageObject.createNewMessage("ByGroup");
		MessageCentrePageObject.selectGroup();
		MessageCentrePageObject.selectMyDeal("PLMRS 2014-1A D");
		MessageCentrePageObject.verifyNonMemberStatus(0);				// Non-Member  Recipients Included
		MessageCentrePageObject.enterSubjectAndMessage("Group Message with deal to BuysideBank Debt List- Exclude NOn-Member");
		Assert.assertEquals("Group Message with deal to BuysideBank Debt List- Exclude NOn-Member", MessageCentrePageObject.confirmQuerySubmission());
		String ConfirmedSubject7 = MessageCentrePageObject.confirmQueryOnMessageCentreDashboard();
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject7,"Group Message with deal to BuysideBank Debt List- Exclude NOn-Member"));
		Assert.assertEquals(MessageCentrePageObject.retTrue(), MessageCentrePageObject.containStr(ConfirmedSubject7,"PLMRS 2014-1A D"));
		MessageCentrePageObject.verifyThreadDetails(8);
		MessageCentrePageObject.goToMessageCenterTab();
		MessageCentrePageObject.runMessageQuery();
		MessageCentrePageObject.runNewComplianceChecks();
		SeleniumWebDriver.CloseDriver();

		
	/* ***************************releaseDomainSuppressedQueries*************************************** */
		
		MessageCentrePageObject.goToAdminAccount();
		MessageCentrePageObject.verifydomainSuppressedQuery(1);
		MessageCentrePageObject.verifydomainSuppressedQuery(2);
		
		
	/* ***************************runMessageCenterCrons*************************************** */
		
		MessageCentrePageObject.runMessageQuery();
		MessageCentrePageObject.runNewComplianceChecks();
		MessageCentrePageObject.scanMailLogs();
		SeleniumWebDriver.CloseDriver();
		
		
}
	
	
	@Test(priority=2)
	public void verifyRecievedMessageThreads() throws InterruptedException{
		
		MessageCentrePageObject.goToRecipientsAccount();
		Assert.assertEquals("8", MessageCentrePageObject.countOfMessageCenter());
		MessageCentrePageObject.verifyRecipientsThreadDetails(1);
		MessageCentrePageObject.verifyRecipientsThreadDetails(2);
		MessageCentrePageObject.verifyRecipientsThreadDetails(3);
		MessageCentrePageObject.verifyRecipientsThreadDetails(4);
		MessageCentrePageObject.verifyRecipientsThreadDetails(5);
		MessageCentrePageObject.verifyRecipientsThreadDetails(6);
		MessageCentrePageObject.verifyRecipientsThreadDetails(7);
		MessageCentrePageObject.verifyRecipientsThreadDetails(8);
		MessageCentrePageObject.verifyRecipientsThreadDetails(9);
		SeleniumWebDriver.CloseDriver();
		
	}
	
}

















