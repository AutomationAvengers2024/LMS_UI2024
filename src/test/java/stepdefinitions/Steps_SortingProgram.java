package stepdefinitions;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Dashboard_Page;
import pages.SortingProgram_Page;
import utilities.LoggerLoad;

public class Steps_SortingProgram      {
	@Given("Admin is in HomePage")
	public void admin_is_in_home_page() {
		AppHooks.getInstance().getDriver().get(Constants.URL); 
	}

	@When("Admin enter valid credentials lms and clicks login button")
	public void admin_enter_valid_credentials_lms_and_clicks_login_button() {
		Dashboard_Page.getInstance().enterValidCredentials();
		Dashboard_Page.getInstance().clickLogin();
		
	}

	@And("Admin is on click program on module after reaching dashboard")
	public void admin_is_on_click_program_on_module_after_reaching_dashboard() throws InterruptedException {
		 SortingProgram_Page.getInstance().programBtn();
         SortingProgram_Page.getInstance().addButtonClick();
         SortingProgram_Page.getInstance().addProgramClickCancel();

	}

	@When("Admin clicks on Arrow next to program Name")
	public void admin_clicks_on_arrow_next_to_program_name() {
	SortingProgram_Page.getInstance().programNameArrowClick();
	}

	@Then("Admin See the Program Name is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_name_is_sorted_in_ascending_order_descending_order() {
	 LoggerLoad.info("Admin see the program name is sorted in ascending order or descending order");
	}

	@When("Admin clicks on Arrow next to ProgramDescription")
	public void admin_clicks_on_arrow_next_to_program_description() {
	 SortingProgram_Page.getInstance().programDescriptionArrowClick();
	}

	@Then("Admin See the program Description is sorted in Ascending order\\/Descending order")
	public void admin_see_the_program_description_is_sorted_in_ascending_order_descending_order() {
	  LoggerLoad.info("Admin see program description is sorted in ascending order or descending order");
	}
	

	@When("Admin clicks on Arrow next to Program status")
	public void admin_clicks_on_arrow_next_to_program_status() {
	SortingProgram_Page.getInstance().programStatusClick();
	}

	@Then("Use See the  Program Status is sorted in Ascending order\\/Descending order")
	public void use_see_the_program_status_is_sorted_in_ascending_order_descending_order() {
	LoggerLoad.info("Admin see the program status is sorted in ascending order or descending order");
	}



}
