package selenium.pageobject;

import selenium.utils.SeleniumHelper;

public class RegisterUserCommand {
	
	private String email;
	private String password;
	private String firstname;
	private String lastname;
	private String role;
	private String company;
	private String phone;

	public RegisterUserCommand(String email){
		this.email = email;
	}
	
	public RegisterUserCommand WithPassword(String password){
		this.password = password;
		return this;
	}
	
	public RegisterUserCommand WithFirstName(String firstname){
		this.firstname = firstname;
		return this;
	}
	
	public RegisterUserCommand WithLastName(String lastname){
		this.lastname = lastname;
		return this;
	}
	
	public RegisterUserCommand WithRole(String role){
		this.role = role;
		return this;
	}
	
	public RegisterUserCommand WithCompany(String company){
		this.company = company;
		return this;
	}
	
	public RegisterUserCommand WithPhoneNumber(String phone){
		this.phone = phone;
		return this;
	}
	
	public void Register(){
		SeleniumHelper.InputText("first_name").Value(this.firstname);
		SeleniumHelper.InputText("last_name").Value(this.lastname);
		SeleniumHelper.DropDown("role").Value(this.role);
		SeleniumHelper.InputText("company").Value(this.company);
		SeleniumHelper.InputText("phone").Value(this.phone);
		SeleniumHelper.InputText("email").Value(this.email);
		SeleniumHelper.InputText("password").Value(this.password);
		SeleniumHelper.Button("home_ftm_1").Click();
	}
	
	public static String GetErrorMessage(){
		SeleniumHelper.WaitForPresenceOfElementByXPath("//div[@class='new_error_text']");
		String errormsg = SeleniumHelper.Div("//div[@class='new_error_text']").Text();
		return errormsg;
	}
	
	public static String GetStartedPageTitle(){
		//SeleniumHelper.WaitForPresenceOfElementByXPath("//div[@class='reg_field_holder new_error_head hide']");
		SeleniumHelper.WaitForPageLoad(7000);
		String title = SeleniumHelper.Div("//div[@class='page-content-heading big_header pt0']").Text();
		System.out.println("--------------------"+title);
		//title =  "yes" ;
		return title;
	}
}
