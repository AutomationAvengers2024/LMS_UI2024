package stepdefinitions;

import org.testng.Assert;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login_Page;
import pages.Logout_Page;

public class Steps_Logout {

	@Given("Admin is in dashboard page")
	public void admin_is_in_dashboard_page() {
		AppHooks.getInstance().getDriver().get(Constants.URL); 
	    
	}

	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		Login_Page.getInstance().enterusername();
		Login_Page.getInstance().enterpassword();
		Login_Page.getInstance().clickLoginBtn();
		Logout_Page.getInstance().clickLogoutBtn();
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		Assert.assertTrue(Logout_Page.getInstance().getPageTitle().contains("LMS"));
		
	}

	@Given("Admin is in login page")
	public void admin_is_in_login_page() {
		Logout_Page.getInstance().clickLogoutBtn(); 
	}

	@When("Admin clicks  browser back button")
	public void admin_clicks_browser_back_button() {
		AppHooks.getInstance().getDriver().navigate().back();
	}

	@Then("Admin should receive error message")
	public void admin_should_receive_error_message() {
		Assert.assertTrue(Logout_Page.getInstance().toString().contains("error message"));
	}
}


