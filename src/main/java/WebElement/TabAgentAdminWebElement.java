package WebElement;

public class TabAgentAdminWebElement {
	
	
	private final String company_button = "/html/body/div[2]/div/div/div[1]/div/div/div[2]/div/button[1]";
	private final String company_input_box = "//*[@id='new_company']";
	private final String company_add_button = "//*[@id='add_new_company_form']/input";
	
	private final String company_account_button = "/html/body/div[2]/div/div/div[1]/div/div/div[2]/div/button[2]";
	private final String company_account_input_box = "//*[@id='new_company_account']";
	private final String company_dropdown = "//*[@id='add_ac_company']";
	private final String company_account_add_button = "//*[@id='add_new_company_account_form']/input";
	
	private final String tabulation_agent_button = "/html/body/div[2]/div/div/div[1]/div/div/div[2]/div/button[3]";
	private final String company_account_dropdown = "//*[@id='ta_company_account']";
	private final String user_dropdown = "//*[@id='user']";
	private final String tabulation_agent_add_button = "//*[@id='add_new_tabulation_agent_form']/input";
	
	private final String election_button = "/html/body/div[2]/div/div/div[1]/div/div/div[2]/div/button[5]";
	private final String election_name_textbox = "//*[@id='election_name']";
	private final String election_company_account_dropdown = "//*[@id='ele_company_account']";
	private final String election_issuer_dropdown = "//*[@id='election_issuer']";
	private final String election_deadline = "//*[@id='election_deadline']";
	private final String election_add_button = "//*[@id='add_new_election_form']/input";

	public String getCompany_button() {
		return company_button;
	}

	public String getCompany_input_box() {
		return company_input_box;
	}

	public String getCompany_add_button() {
		return company_add_button;
	}

	public String getCompany_account_button() {
		return company_account_button;
	}

	public String getCompany_account_input_box() {
		return company_account_input_box;
	}

	public String getCompany_dropdown() {
		return company_dropdown;
	}

	public String getCompany_account_add_button() {
		return company_account_add_button;
	}

	public String getCompany_account_dropdown() {
		return company_account_dropdown;
	}

	public String getUser_dropdown() {
		return user_dropdown;
	}

	public String getTabulation_agent_add_button() {
		return tabulation_agent_add_button;
	}

	public String getElection_name_textbox() {
		return election_name_textbox;
	}

	public String getElection_company_account_dropdown() {
		return election_company_account_dropdown;
	}

	public String getElection_issuer_dropdown() {
		return election_issuer_dropdown;
	}

	public String getElection_deadline() {
		return election_deadline;
	}

	public String getElection_add_button() {
		return election_add_button;
	}

	public String getTabulation_agent_button() {
		return tabulation_agent_button;
	}

	public String getElection_button() {
		return election_button;
	}

	
}
