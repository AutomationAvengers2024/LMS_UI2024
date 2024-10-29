package stepdefinitions;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchBarProgram_Page;
import pages.SortingProgram_Page;
import utilities.LoggerLoad;

public class Steps_SearchBarProgram {
	
	@When("Admin is on click program menubar and then clickadd program button")
	public void admin_is_on_click_program_menubar_and_then_clickadd_program_button() throws InterruptedException {
		 SortingProgram_Page.getInstance().programBtn();
         SortingProgram_Page.getInstance().addButtonClick();
         SortingProgram_Page.getInstance().addProgramClickCancel();
	}
	

	@When("Admin enter the program to search By program name")
	public void admin_enter_the_program_to_search_by_program_name() {
		
		SearchBarProgram_Page.getInstance().searchOnProgramName();
	}

	@Then("Admin should able to see Program name, description, and status for searched program name")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_name() {
	    LoggerLoad.info("Admin should see the program name,program description and status for searched program name");
	}


	@When("Admin enter the program to search By program description")
	public void admin_enter_the_program_to_search_by_program_description() {
		SearchBarProgram_Page.getInstance().searchOnProgramDescription();
	}

	@Then("Admin should able to see Program name, description, and status for searched program description")
	public void admin_should_able_to_see_program_name_description_and_status_for_searched_program_description() {
	  LoggerLoad.info("Admin should able to see Program name, description, and status for searched program description");
	}

	@When("Admin enter the program to search By program name that does not exist")
	public void admin_enter_the_program_to_search_by_program_name_that_does_not_exist() {
		SearchBarProgram_Page.getInstance().searchNoProgram();
	}

	@Then("There should be zero result.")
	public void there_should_be_zero_result() {
	LoggerLoad.info("Admin should see Zero Results");
	}

	@When("Admin enter the program to search By partial name of program")
	public void admin_enter_the_program_to_search_by_partial_name_of_program() {
		SearchBarProgram_Page.getInstance().searchOnPartialProgram();
	}



}
