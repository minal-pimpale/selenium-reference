package selenium.pageobject;

import selenium.utils.SeleniumHelper;

public class RegisterUserPage extends BasePageObject {

	public static void Goto(){
		SeleniumHelper.Navigate(baseurl +"register");
		SeleniumHelper.WaitForPageLoad(5000);
	} 
	
	public static RegisterUserCommand RegisterAs(String email){
		RegisterUserCommand registeruserCmd = new RegisterUserCommand(email);
		return registeruserCmd;
	}
	
	public static boolean IsRegisterationSuccessful(){
		String title =  RegisterUserCommand.GetStartedPageTitle();
		SeleniumHelper.WaitForPageLoad(5000);
		if (!title.isEmpty())
			return true;
		return false;
	}
	
	public static String FailureMessage(){
		String error = RegisterUserCommand.GetErrorMessage();
		return error;
	}
}
