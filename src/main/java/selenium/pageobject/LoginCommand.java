package selenium.pageobject;

import selenium.utils.SeleniumHelper;

public class LoginCommand {
	private String userName;
	private String password;

	public LoginCommand(String userName){
		this.userName = userName;
	}
	
	public LoginCommand WithPassword(String password){
		this.password = password;
		return this;
	}
	
	public void Login(){
		SeleniumHelper.InputText("login_email_id").Value(this.userName);
		SeleniumHelper.InputText("login_password").Value(this.password);
		
		SeleniumHelper.Button("login_submit").Click();
		
	}
}