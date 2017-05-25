package WebElement;

public class DealCenterWebElement {
	
	private final String USERNAME = "abc17@capital.com";
	private final String PASSWORD = "aaa.111"; 
	
	private final String SEARCH_DEALS_BUTTON = "//*[@id='add_deal_link']/b";
	private final String ADDDEAL_SEARCH_BOX = ".//*[@id='fund_name']";
	private final String SEARCH_BUTTON = "//*[@id='newDealLookup']/div/button";
	private final String SELECT_DEAL_CHKBOX = "//*[@id='dealmatchajax_details']/div/table[1]/tbody/tr[1]/td[2]/label";;  //*[@id="dealmatchajax_details"]/div/table[1]/tbody/tr[1]/td[2]/input
	//*[@id="deal_container_347976"]/tbody/tr/td[2]/label
	private final String SUBMIT_BUTTON = "//*[@id='searchedDealSubmit']";
	private final String SELECT_DEAL_ROLE = "//*[@id='dealmatchajax_details']/div/table[1]/tbody/tr[1]/td[6]/table/tbody/tr[1]/td[1]/div/select";
	private final String SELECT_DEAL_SUB_ROLE = "//*[@id='dealmatchajax_details']/div/table[1]/tbody/tr[1]/td[6]/table/tbody/tr[2]/td[1]/div/select";
	
	private final String EDIT_DEAL_ROLE = "//*[@id='role_select']";						
	private final String EDIT_DEAL_SUB_ROLE = "//*[@id='sub_role_1']";
	
	private final String EXPAND_ALESCO_SERIES = "//*[@id='dealcenter_content_wrapper']/div[2]/table/tbody/tr[1]/td[1]/a";
	
	private final String XPATH_InstInv_Deal = ".//*[@id='deal_detail_347976']";
	private final String XPATH_IndInv_Deal = ".//*[@id='deal_detail_347977']";
	private final String XPATH_Advisor_Deal = "//*[@id='deal_detail_347974']";
	private final String XPATH_Broker_Deal = "//*[@id='deal_detail_347973']";
	private final String XPATH_Trustee_Deal = "//*[@id='deal_detail_347972']";
	private final String XPATH_Issuer_Deal = "//*[@id='deal_detail_347971']";
	private final String XPATH_Underwriter_Deal = "//*[@id='deal_detail_347970']";
	private final String XPATH_Custodian_Deal = "//*[@id='deal_detail_347969']";
	private final String XPATH_Other_Deal = "//*[@id='deal_detail_347968']";
	private final String XPATH_Following_Deal = "//*[@id='deal_detail_347967']";
	private final String XPATH_ALESCO_A1_01448QAA8 = "//*[@id='deal_detail_185345']"; 
	private final String XPATH_ALESCO_A2_01448QAB6 = "//*[@id='deal_detail_185346']";
	private final String XPATH_ALESCO_A3_01448QAC4 = "//*[@id='deal_detail_189023']";
	private final String XPATH_ALESCO_B1_01448QAD2 = "//*[@id='deal_detail_185347']";
	private final String XPATH_ALESCO_B2_01448QAE0 = "//*[@id='deal_detail_1575']";
	private final String XPATH_ALESCO_B3_01448QAF7 = "//*[@id='deal_detail_1576']";
	private final String XPATH_ALESCO_M1_01448RAA6 = "//*[@id='deal_detail_304260']";
	private final String XPATH_ALESCO_M2_01448RAB4 = "//*[@id='deal_detail_304261']";
	private final String XPATH_ALESCO_M3_01448RAC2 = "//*[@id='deal_detail_304262']";
	
	private final String Edit_link_xpath_ALESCO_A1_01448QAA8 ="//*[@id='edit_185345']/b";
	private final String Edit_link_xpath_ALESCO_A2_01448QAB6 = "//*[@id='edit_185346']/b";
	private final String Edit_link_xpath_ALESCO_A3_01448QAC4 = "//*[@id='edit_189023']/b";
	private final String Edit_link_xpath_ALESCO_B1_01448QAD2 = "//*[@id='edit_185347']/b";
	private final String Edit_link_xpath_ALESCO_B2_01448QAE0 = "//*[@id='edit_1575']/b";
	private final String Edit_link_xpath_ALESCO_B3_01448QAF7 = "//*[@id='edit_1576']/b";
	private final String Edit_link_xpath_ALESCO_M1_01448RAA6 = "//*[@id='edit_304260']/b";
	private final String Edit_link_xpath_ALESCO_M2_01448RAB4 = "//*[@id='edit_304261']/b";
	private final String Edit_link_xpath_ALESCO_M3_01448RAC2 = "//*[@id='edit_304262']/b";
	
	private final String XPATH_DEAL_ROLE_Inst_INVESTOR = "//*[@id='dealcenter_content_wrapper']/div[2]/table/tbody/tr/td[5]/span";
	private final String XPATH_DEAL_ROLE_Ind_INVESTOR ="//*[@id='dealcenter_content_wrapper']/div[2]/table/tbody/tr[2]/td[5]/span";
	private final String XPATH_Deal_ROLE_OTHER = "//*[@id='dealcenter_content_wrapper']/div[2]/table/tbody/tr[1]/td[5]/span";
	public String getUSERNAME() {
		return USERNAME;
	}
	
	public String getPASSWORD() {
		return PASSWORD;
	}
	
	public String getSearch_Deals_BUTTON() {
		return SEARCH_DEALS_BUTTON;
	}
	
	
	public String getADDDEAL_SEARCH_BOX() {
		return ADDDEAL_SEARCH_BOX;
	}
	
	
	public String getSEARCH_BUTTON() {
		return SEARCH_BUTTON;
	}

	public String getSELECT_DEAL_CHKBOX() {
		return SELECT_DEAL_CHKBOX;
	}

	public String getSUBMIT_BUTTON() {
		return SUBMIT_BUTTON;
	}

	public String getSELECT_DEAL_ROLE() {
		return SELECT_DEAL_ROLE;
	}

	public String getSELECT_DEAL_SUB_ROLE() {
		return SELECT_DEAL_SUB_ROLE;
	}

	public String getEDIT_DEAL_ROLE() {
		return EDIT_DEAL_ROLE;
	}

	public String getEDIT_DEAL_SUB_ROLE() {
		return EDIT_DEAL_SUB_ROLE;
	}

	public String getEXPAND_ALESCO_SERIES() {
		return EXPAND_ALESCO_SERIES;
	}

	public String getXPATH_ALESCO_A1_01448QAA8() {
		return XPATH_ALESCO_A1_01448QAA8;
	}

	public String getXPATH_ALESCO_B2_01448QAE0() {
		return XPATH_ALESCO_B2_01448QAE0;
	}

	public String getEdit_link_xpath_ALESCO_A1_01448QAA8() {
		return Edit_link_xpath_ALESCO_A1_01448QAA8;
	}

	public String getEdit_link_xpath_ALESCO_B2_01448QAE0() {
		return Edit_link_xpath_ALESCO_B2_01448QAE0;
	}

	public String getXPATH_ALESCO_A2_01448QAB6() {
		return XPATH_ALESCO_A2_01448QAB6;
	}

	public String getEdit_link_xpath_ALESCO_A2_01448QAB6() {
		return Edit_link_xpath_ALESCO_A2_01448QAB6;
	}

	public String getXPATH_ALESCO_A3_01448QAC4() {
		return XPATH_ALESCO_A3_01448QAC4;
	}

	public String getEdit_link_xpath_ALESCO_A3_01448QAC4() {
		return Edit_link_xpath_ALESCO_A3_01448QAC4;
	}

	public String getEdit_link_xpath_ALESCO_B1_01448QAD2() {
		return Edit_link_xpath_ALESCO_B1_01448QAD2;
	}

	public String getXPATH_ALESCO_B1_01448QAD2() {
		return XPATH_ALESCO_B1_01448QAD2;
	}

	public String getXPATH_ALESCO_B3_01448QAF7() {
		return XPATH_ALESCO_B3_01448QAF7;
	}

	public String getEdit_link_xpath_ALESCO_B3_01448QAF7() {
		return Edit_link_xpath_ALESCO_B3_01448QAF7;
	}

	public String getXPATH_ALESCO_M1_01448RAA6() {
		return XPATH_ALESCO_M1_01448RAA6;
	}

	/**
	 * @return the edit_link_xpath_ALESCO_M1_01448RAA6
	 */
	public String getEdit_link_xpath_ALESCO_M1_01448RAA6() {
		return Edit_link_xpath_ALESCO_M1_01448RAA6;
	}

	/**
	 * @return the xPATH_ALESCO_M2_01448RAB4
	 */
	public String getXPATH_ALESCO_M2_01448RAB4() {
		return XPATH_ALESCO_M2_01448RAB4;
	}

	/**
	 * @return the edit_link_xpath_ALESCO_M2_01448RAB4
	 */
	public String getEdit_link_xpath_ALESCO_M2_01448RAB4() {
		return Edit_link_xpath_ALESCO_M2_01448RAB4;
	}

	/**
	 * @return the xPATH_ALESCO_M3_01448RAC2
	 */
	public String getXPATH_ALESCO_M3_01448RAC2() {
		return XPATH_ALESCO_M3_01448RAC2;
	}

	/**
	 * @return the edit_link_xpath_ALESCO_M3_01448RAC2
	 */
	public String getEdit_link_xpath_ALESCO_M3_01448RAC2() {
		return Edit_link_xpath_ALESCO_M3_01448RAC2;
	}

	/**
	 * @return the xPATH_DEAL_ROLE_INVESTOR
	 */
	
	/**
	 * @return the xPATH_InstInv_Deal
	 */
	public String getXPATH_InstInv_Deal() {
		return XPATH_InstInv_Deal;
	}

	/**
	 * @return the xPATH_IndInv_Deal
	 */
	public String getXPATH_IndInv_Deal() {
		return XPATH_IndInv_Deal;
	}

	/**
	 * @return the xPATH_Deal_ROLE_OTHER
	 */
	public String getXPATH_Deal_ROLE_OTHER() {
		return XPATH_Deal_ROLE_OTHER;
	}

	/**
	 * @return the xPATH_Advisor_Deal
	 */
	public String getXPATH_Advisor_Deal() {
		return XPATH_Advisor_Deal;
	}

	/**
	 * @return the xPATH_Broker_Deal
	 */
	public String getXPATH_Broker_Deal() {
		return XPATH_Broker_Deal;
	}

	/**
	 * @return the xPATH_Trustee_Deal
	 */
	public String getXPATH_Trustee_Deal() {
		return XPATH_Trustee_Deal;
	}

	/**
	 * @return the xPATH_Issuer_Deal
	 */
	public String getXPATH_Issuer_Deal() {
		return XPATH_Issuer_Deal;
	}

	/**
	 * @return the xPATH_Underwriter_Deal
	 */
	public String getXPATH_Underwriter_Deal() {
		return XPATH_Underwriter_Deal;
	}

	/**
	 * @return the xPATH_Custodian_Deal
	 */
	public String getXPATH_Custodian_Deal() {
		return XPATH_Custodian_Deal;
	}

	/**
	 * @return the xPATH_Other_Deal
	 */
	public String getXPATH_Other_Deal() {
		return XPATH_Other_Deal;
	}

	/**
	 * @return the xPATH_Following_Deal
	 */
	public String getXPATH_Following_Deal() {
		return XPATH_Following_Deal;
	}

	/**
	 * @return the xPATH_DEAL_ROLE_Inst_INVESTOR
	 */
	public String getXPATH_DEAL_ROLE_Inst_INVESTOR() {
		return XPATH_DEAL_ROLE_Inst_INVESTOR;
	}

	/**
	 * @return the xPATH_DEAL_ROLE_Ind_INVESTOR
	 */
	public String getXPATH_DEAL_ROLE_Ind_INVESTOR() {
		return XPATH_DEAL_ROLE_Ind_INVESTOR;
	}

	
	
	
	
	
	
	
	
	
}
