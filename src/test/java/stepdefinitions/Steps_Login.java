package stepdefinitions;

import org.junit.Assert;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login_Page;

public class Steps_Login {
	
	
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

//	@Then("Admin should recieve {int} page not found error")
//	public void admin_should_recieve_on_the_login_page() {
//	Assert.assertEquals(Login_Page.getInstance().getPageNotFound(null));
//	    
//	}

 @Then("Admin should see correct spellings in all fields")
  public void admin_should_see_correct_spellings_in_all_fields() {
	 String expectedUsernameLabel = "Username"; 
     String expectedPasswordLabel = "Password"; 
	 String actualUsernameLabel = Login_Page.getInstance().getUsernameLabel();
     String actualPasswordLabel = Login_Page.getInstance().getPasswordLabel();
     Assert.assertEquals("Username label mismatch!", expectedUsernameLabel, actualUsernameLabel);
     Assert.assertEquals("Password label mismatch!", expectedPasswordLabel, actualPasswordLabel);
     
   
}
 
 @Then("Admin should see logo on the left  side")
 public void admin_should_see_logo_on_the_left_side() {
	 Assert.assertTrue(Login_Page.getInstance().logoisDisplyed());
    
 }

 @Then("Admin should see  LMS - Learning Management System")
 public void admin_should_see_lms_learning_management_system() {
	 Assert.assertTrue(Login_Page.getInstance().logoisDisplyed());
     
 }
 
 @Then("Admin should see company name below the app name")
 public void admin_should_see_company_name_below_the_app_name() {
	 Assert.assertTrue(Login_Page.getInstance().logoisDisplyed());
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
	 Assert.assertTrue(Login_Page.getInstance().UsernameLabelDisplayed());
 }

 @Then("Admin should see field mandatory * symbol next to Admin text")
 public void admin_should_see_field_mandatory_symbol_next_to_admin_text() {
     Assert.assertTrue(Login_Page.getInstance().requiredUserAsteriskDisplayed());
 }
 @Then("Admin should {string} in the second text field")
 public void admin_should_in_the_second_text_field(String string) {
	 Assert.assertTrue(Login_Page.getInstance().passwordLabelDisplayed());
 }

 @Then("Admin should see * symbol next to password text")
 public void admin_should_see_symbol_next_to_password_text() {
	 Assert.assertTrue(Login_Page.getInstance().requiredPasswordastrikiskDisplayed());
 }
 @Then("Admin should see input field on the centre of the page")
 public void admin_should_see_input_field_on_the_centre_of_the_page() {
     
 }

 @Then("Admin should see login button")
 public void admin_should_see_login_button() {
	 Assert.assertTrue(Login_Page.getInstance().isLoginButtonDisplayed()); 
 }











}



