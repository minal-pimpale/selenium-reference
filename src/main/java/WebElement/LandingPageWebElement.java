package WebElement;

public class LandingPageWebElement {

	public final String UsernameTextbox = "//*[@id='email']";
	public final String PasswordTextbox = "//*[@id='password']";
	public final String RegisterButton = "//*[@id='email_campaign_form']";
	//*[@id="email_campaign_form"]/button
	//*[@id="email_campaign_form"]/input[7]
	
	public static final String header_text = "/html/body/div[2]/div/div[1]/h1";
	public static final String landing_page_text = "/html/body/div[2]/div/div[1]/div/b";
	 
	public static String complete_profile_text = "//*[@id='appRoot']/div/div[1]/div/div[1]/div[1]/span"; 

	public static final String registration_success_text = "//*[@id='join-confirmation']/div[1]";
	public static final String registered_user_email_address = "//*[@id='join-confirmation']/div[3]/p/span";
	
	public static final String qib_screen_text_1 = "//*[@id='qibEligibilityContainer']/div/h3";
	public static final String qib_screen_text_2 = "//*[@id='locationWrapper']/span"; 
	
	public static final String qib_usa_loaction = "//*[@id='locationWrapper']/div[1]/label";
	public static final String usa_location_condition_1 = "//*[@id='usConfirmations']/div[1]/label"; 
	public static final String usa_location_condition_2 = "//*[@id='usConfirmations']/div[2]/label"; 
	public static final String usa_location_condition_3 = "//*[@id='usConfirmations']/div[3]/label"; 
	public static final String qib_next_button = "//*[@id='qibForm']/button"; 
	
	// Follow clo manager xpaths 
	
	public final String manager = "//*[@id='manager_table']/tbody/tr[4]/td[3]";
	public static final String Follow_CLO_header_text = "/html/body/div/div/div/div/div/div/h3";
    public final String Follow_CLO_RegisterButton = "//*[@id='submit_top']";
    
    // scan_mail_log xpath 
    public static String email_validation_mail = "/html/body/table/tbody/tr[2]/td[2]";
    public static String email_validation_link = "/html/body/*/div[2]/table/tbody/tr[1]/td[2]/div/table[2]/tbody/tr/td/div/div/a";
    
   // public static String email_validation_link = "//a[text()='Confirm Ownership']";
    
    // profile tab xpaths 
    public static String dv_id_link = "//*[@id='anchorPopUp']";
    public static String profile_tab_link = "//*[@id='accountDropDown']/li[1]/a";
    public static String profile_status = "//*[@id='account_status']/div/h3[1]";
	public static String approve_user = "//*[@id='approve_28']";
	public static String Logout = "//*[@id='accountDropDown']/li[3]/a";
	
	public static String login_successful_text = "//*[@id='wizardContainer']/div/div[1]/div/div[1]/div[3]/span";
	
	
	//complete profile xpath 
	public static String full_name_text_box = "//*[@id='full_name']"; 
	public static String company = "//*[@id='company_name']"; 
	public static String role_dropdown = "//*[@id='user_role']"; 
	public static String phone_number = "//*[@id='phone_number']"; 
	public static String next_button = "//*[@id='appRoot']/div/div[1]/div/div[1]/div[4]/div/a"; 
}
