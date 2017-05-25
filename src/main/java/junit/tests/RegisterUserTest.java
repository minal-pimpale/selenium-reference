package junit.tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import selenium.pageobject.RegisterUserPage;

/* Total 3 test cases*/

public class RegisterUserTest extends BaseTest {

//	 @Test
	public void test_register_user_to_dealvector() {
		System.out.println("Register user to Deal vector");
		RegisterUserPage.Goto();

				
		RegisterUserPage.RegisterAs("autouser@talentica.com").WithPassword("auto123!@#")
						.WithFirstName("automation").WithLastName("user")
						.WithCompany("talentica").WithPhoneNumber("677046004000")
						.WithRole("Advisor").Register();
		
		Assert.assertTrue(RegisterUserPage.IsRegisterationSuccessful());
		System.out.println("User Registered to Deal vector");
		
	}

	//@Test
	public void test_register_user_already_registered_to_dealvector() {
		System.out.println("Register user to Deal vector");
		RegisterUserPage.Goto();

				
		RegisterUserPage.RegisterAs("arunav@talentica.com").WithPassword("arunav123!@#")
						.WithFirstName("arunav").WithLastName("verma")
						.WithCompany("talentica").WithPhoneNumber("912046004000")
						.WithRole("Advisor").Register();
		
		Assert.assertTrue(!RegisterUserPage.IsRegisterationSuccessful());
		Assert.assertTrue(RegisterUserPage.FailureMessage().equals("This email address is already registered."));
		System.out.println("User Registeration failed in Deal vector");
		
	}
	
	//@Test
	public void delete_already_registered_user_to_dealvector() {
		try{
			String userId = get_user_id_of_the_registered_user("arunav@talentica.com");
			if (!userId.isEmpty())
				delete_user_registration(userId);
			Assert.assertTrue(true);
		}
		catch(Exception e){
			System.out.println("User Registeration deletion failed in Deal vector");
		}
	}
	
	//private helper method to get user by email id
	private String get_user_id_of_the_registered_user(String emailId){
		System.out.println("geting user id for user : " + emailId);
		String userId = "";
		String url = baseServiceurl +"users/search/findIdByEmailId?emailId=" + emailId;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet request = new HttpGet(url);
		try {
			CloseableHttpResponse response = httpclient.execute(request);
				try {
				    HttpEntity entity = response.getEntity();
				    if (entity != null) {
				    	BufferedReader br = new BufferedReader(
		                         new InputStreamReader((response.getEntity().getContent())));
		 
						String output;
						if ((output = br.readLine()) != null) {							
							userId = output;
						}
				   }
				} finally {
				    response.close();
				}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
		}
		return userId;
		
	}
	//private helper method to delete registered user
	private void delete_user_registration(String userid){
		System.out.println("Deleting user registered : " + userid);
		String url = baseServiceurl + "users/" + userid;
		 
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpDelete request = new HttpDelete(url);
		try {
			httpclient.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
		}

	}
	
}

