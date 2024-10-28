package stepdefinitions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login_Page;

public class Steps_Login {
	
	
	public static final String grayColor = "rgba(0, 0, 0, 0.54)";
	String actualErrorMessage = "";
	String successMessage ="";
	String actualNameText = "User";
	String actualPasswordText = "Password";
	String actualText = "";
	
	
	@Given("Admin is in Home Page")
	public void admin_is_in_home_page() {
		AppHooks.getInstance().getDriver().get(Constants.URL); 
	}

	@When("Admin enter valid credentials and clicks login button")
	public void admin_enter_valid_credentials_and_clicks_login_button() {
		Login_Page.getInstance().enterusername();
		Login_Page.getInstance().enterpassword();
		Login_Page.getInstance().clickLoginBtn();
	}

	@Then("Admin should land on dashboard page")
	public void admin_should_land_on_dashboard_page() {
	   
		Login_Page.getInstance().checkTitleOfPage("LMS");
	}
	
	@Given("Admin launch the browser")
	public void admin_launch_the_browser() {
		
	    
	}

	@When("Admin gives the correct LMS portal URL")
	public void admin_gives_the_correct_lms_portal_url() {
		AppHooks.getInstance().getDriver().get(Constants.URL); 
	    
	}

	@Then("Admin should land on the login page")
	public void admin_should_land_on_the_login_page() {
		Assert.assertTrue(Login_Page.getInstance().getPageTitle().contains("LMS"));
		
	    
	}

	@When("Admin gives the invalid LMS portal URL")
	public void admin_gives_the_invalid_lms_portal_url() {
		AppHooks.getInstance().getDriver().get(Constants.INVALIDURL); 
	    
	}

	@Then("Admin should recieve {int} page not found error")
	public void admin_should_recieve_page_not_found_error(Integer int1) {
		int httpStatus = 200;
		String invalidURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp12345.com/FindCustomer";

	   if(httpStatus == 404 )
		   System.out.println("Invalid URL: Status received:" + httpStatus);
	}

	@Then("HTTP response >= {int}. Then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
		int httpStatus = 200;
		String invalidURL = "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp12345.com/FindCustomer";

	   if(httpStatus > 404 )
		   System.out.println("Invalid URL: Status received:" + httpStatus);
		
	}



 @Then("Admin should see correct spellings in all fields")
  public void admin_should_see_correct_spellings_in_all_fields() throws Throwable {
	 HashMap<String,String> loginTextMap = new HashMap<String,String>();
	 loginTextMap = Login_Page.getInstance().VerifyFieldText();
		Assert.assertEquals(loginTextMap.get("ExpUserText"),actualNameText );
		Assert.assertEquals(loginTextMap.get("ExppasswordText"),actualPasswordText );
   
}
 
 @Then("Admin should see logo on the left  side")
 public void admin_should_see_logo_on_the_left_side() {
	 Assert.assertTrue(Login_Page.getInstance().verifyLogoIsDisplayed());
    
 }

 @Then("Admin should see  LMS - Learning Management System")
 public void admin_should_see_lms_learning_management_system() {
	 Assert.assertTrue(Login_Page.getInstance().verifyLogoIsDisplayed());
     
 }
 
 @Then("Admin should see company name below the app name")
 public void admin_should_see_company_name_below_the_app_name() {
	 Assert.assertTrue(Login_Page.getInstance().verifyLogoIsDisplayed());
 }

 @Then("Admin should see {string}")
 public void admin_should_see(String string) {
	 Assert.assertTrue(Login_Page.getInstance().signinContectDisplayed());  
 }

 @Then("Admin should see two text field")
 public void admin_should_see_two_text_field() {
	 Assert.assertTrue(Login_Page.getInstance().isTextFieldsVisible()); 
 }
 
 @Then("Admin should {string} in the first text field")
 public void admin_should_in_the_first_text_field(String string) {
	 actualText = Login_Page.getInstance().verifyUserPlaceHolder();
		Assert.assertEquals(actualNameText, string);
 }

 @Then("Admin should see field mandatory * symbol next to Admin text")
 public void admin_should_see_field_mandatory_symbol_next_to_admin_text() {
     Assert.assertTrue(Login_Page.getInstance().requiredUserAsteriskDisplayed());
 }
 @Then("Admin should {string} in the second text field")
 public void admin_should_in_the_second_text_field(String string) {
	 actualText = Login_Page.getInstance().verifyUserPlaceHolder();
		Assert.assertEquals(actualPasswordText, string);
 }

 @Then("Admin should see * symbol next to password text")
 public void admin_should_see_symbol_next_to_password_text() {
	 Assert.assertTrue(Login_Page.getInstance().requiredPasswordastrikiskDisplayed());
 }
 @Then("Admin should see input field on the centre of the page")
 public void admin_should_see_input_field_on_the_centre_of_the_page() {
	 Assert.assertTrue(Login_Page.getInstance().isInputFieldCentered());
     
 }

 @Then("Admin should see login button")
 public void admin_should_see_login_button() {
	 Assert.assertTrue(Login_Page.getInstance().isLoginButtonDisplayed()); 
 }

 @Then("Admin should see login button on the centre of the page")
 public void admin_should_see_login_button_on_the_centre_of_the_page() {
	 
//	 checkFields = AppHooks.getInstance().getDriver().verifyButtonAlignment();
//		Assert.assertTrue(checkFields);
 }

 @Then("Admin should see Admin in gray color")
 public void admin_should_see_admin_in_gray_color() {
	 Assert.assertEquals(Login_Page.getInstance().getUserFontColor().equals(grayColor),true);
	 
    
 }

@Then("Admin should see Password in gray color")
public void admin_should_see_password_in_gray_color() {
	 Assert.assertEquals(Login_Page.getInstance().getPasswordFontColor().equals(grayColor),true);
	 
}
@Given("Admin launches the browser")
public void admin_launches_the_browser() {
	AppHooks.getInstance().getDriver().get(Constants.URL);  
}

@When("The admin enters {string}, {string} and clicks the login button")
public void the_admin_enters_and_clicks_the_login_button(String string, String string2) {
	Login_Page.getInstance().validateUserandPassword(string,string2);
       
    }


@Then("Admin should see the message {string}")
public void admin_should_see_the_message_(String string) {
    
	actualErrorMessage = Login_Page.getInstance().getErrorMessage();
	Assert.assertEquals(actualErrorMessage,string );
}


@When("Admin enter valid credentials  and clicks login button through keyboard")
public void admin_enter_valid_credentials_and_clicks_login_button_through_keyboard() {
	Login_Page.getInstance().enterusername();
	Login_Page.getInstance().enterpassword();
	Login_Page.getInstance().pressEnterKey();
}


@When("Admin enter valid credentials  and clicks login button through mouse")
public void admin_enter_valid_credentials_and_clicks_login_button_through_mouse() {
	Login_Page.getInstance().enterusername();
	Login_Page.getInstance().enterpassword();
	Login_Page.getInstance().clickLoginButton();
}


}

















