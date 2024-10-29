package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard_Page;
import utilities.LoggerLoad;


import org.testng.Assert;

import app_hooks.AppHooks;
import constants.Constants;



public class Steps_Dashboard {
	
	@Given("Admin is in Login Page")
	public void admin_is_in_login_page() {
	
		AppHooks.getInstance().getDriver().get(Constants.URL); 
	}

	@When("Admin enter valid {string} with {string} and clicks login button")
	
	public void admin_enter_valid_credentials_and_clicks_login_button() throws Throwable {
		
		Dashboard_Page.getInstance().enterValidCredentials();
		Dashboard_Page.getInstance().clickLogin();
	    
	}
	@Then("Admin should see Dashboard")
	public void admin_should_see_dashboard() throws InterruptedException {
		AppHooks.getInstance().getDriver().get(Constants.URL); 
		LoggerLoad.info("Admin should see Dashboard Page");
	}

	@Then("Maximum navigation time in milliseconds,defaults to {int} seconds")
	public void maximum_navigation_time_in_milliseconds_defaults_to_seconds(Integer int1) throws InterruptedException {
		Dashboard_Page.getInstance().navigationTime();
	    LoggerLoad.info("Maximum navigation time in milliseconds,defaults to"+int1+ "seconds");
	}

	@Then("Http response >= {int}.then the link is broken")
	public void http_response_then_the_link_is_broken(Integer int1) {
		
          Dashboard_Page.getInstance().verifyBrokenLink();
	}

	@Then("Admin should see LMS Learning Management System as title")
	public void admin_should_see_lms_learning_management_system_as_title() {
	Dashboard_Page.getInstance().checkTitleOfPage("LMS Learning Management System as title");
	}

	@Then("LMS title should be on the top left corner of page")
	public void lms_title_should_be_on_the_top_left_corner_of_page() {
	Dashboard_Page.getInstance().isTitleLeftCorner();
	}

	@Then("Admin should see correct spelling in navigation bar text")
	public void admin_should_see_correct_spelling_in_navigation_bar_text() {
    Dashboard_Page.getInstance().correctSpelling();
	}

	@Then("Admin should see correct spelling and space in LMS title")
	public void admin_should_see_correct_spelling_and_space_in_lms_title() {
		 Dashboard_Page.getInstance().spellSpaceCheck();
	}

	@Then("Admin should see navigation bar text on the top right side")
	public void admin_should_see_navigation_bar_text_on_the_top_right_side() {
	  Dashboard_Page.getInstance().navigationBarRightTop();
	}

	@Then("Admin should see Home is in 1st place")
	public void admin_should_see_home_is_in_1st_place() {
	   LoggerLoad.info("Admin should not see Home menu bar");
	}

	@Then("Admin should see Program is in 2nd place")
	public void admin_should_see_program_is_in_2nd_place() {
	 Dashboard_Page.getInstance().ValidateProgram();
	}

	@Then("Admin should see batch is in 3rd place")
	public void admin_should_see_batch_is_in_3rd_place() {
	Dashboard_Page.getInstance().validBatch();
	}

	@Then("Admin should see class is in 4th place")
	public void admin_should_see_class_is_in_4th_place() {
	  Dashboard_Page.getInstance().validCLass();
	}

	@Then("Admin should see Home is in 5th place")
	public void admin_should_see_home_is_in_5th_place() {
	  Dashboard_Page.getInstance().validLogout();
	}

}
