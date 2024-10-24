package stepdefinitions;

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

}
