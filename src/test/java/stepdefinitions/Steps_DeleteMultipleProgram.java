package stepdefinitions;

import app_hooks.AppHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DeleteMultipleProgram_Page;
import utilities.LoggerLoad;

public class Steps_DeleteMultipleProgram {
	
	@Given("Admin is on Program module a1")
	public void admin_is_on_program_module() throws InterruptedException {
		LoggerLoad.info("Admin is Program module");
	}

	@When("Admin selects more than one program by clicking on the checkbox")
	public void admin_selects_more_than_one_program_by_clicking_on_the_checkbox() throws InterruptedException {
	    DeleteMultipleProgram_Page.getInstance().clickManyCheckBox();
	}

	@Then("Programs get selected")
	public void programs_get_selected() {
	   LoggerLoad.info("Programs get selected");
	}

	@Given("Admin is on again Program module a2")
	public void admin_is_on_again_program_module() throws InterruptedException {
		LoggerLoad.info("Admin is Program module again");
	}

	@When("Admin clicks on the delete button on the left top of the program page")
	public void admin_clicks_on_the_delete_button_on_the_left_top_of_the_program_page() {
          DeleteMultipleProgram_Page.getInstance().clickDeleteBtn();
	}

	@Then("Admin lands on Confirmation form")
	public void admin_lands_on_confirmation_form() {
        LoggerLoad.info("Admin lands on Confirmation Form");
	}

	@Given("Admin is  Confirmation form")
	public void admin_is_confirmation_form() throws InterruptedException {
		DeleteMultipleProgram_Page.getInstance().clickManyCheckBox();
		 DeleteMultipleProgram_Page.getInstance().clickDeleteBtn();
         DeleteMultipleProgram_Page.getInstance().popup();
	}

@When("Admin clicks on <Yes> button")
public void admin_clicks_on_yes_button() {
  DeleteMultipleProgram_Page.getInstance().alertPopupYes();
}


	@Then("Admin can see {string} message")
	public void admin_can_see_message(String string) {
LoggerLoad.info(string);
	}

	@Given("Admin is Program module a3")
	public void admin_is_program_module() throws InterruptedException {
	
	}

	@When("Admin Searches for {string}")
	public void admin_searches_for(String string) {
		DeleteMultipleProgram_Page.getInstance().searchBoxClick();
	}

	@Then("There should be zero results.")
	public void there_should_be_zero_results() {
LoggerLoad.info("There should be Zero results in deleted program");
	}

	@Given("Admin is on Confirmation form")
	public void admin_is_on_confirmation_form() throws InterruptedException {
		DeleteMultipleProgram_Page.getInstance().clickManyCheckBox();
		 DeleteMultipleProgram_Page.getInstance().clickDeleteBtn();
		 DeleteMultipleProgram_Page.getInstance().popup();
	}

   @When("Admin clicks on <No> button")
   public void admin_clicks_on_no_button() {
	   DeleteMultipleProgram_Page.getInstance().alertPopupNo();
    }

	@Then("Admin can see Programs are still selected and not deleted")
	public void admin_can_see_programs_are_still_selected_and_not_deleted() {
	LoggerLoad.info("Admin can see programs are still selected but not deleted");
	}

	@Given("Admin is on Program Confirm Deletion Page after selecting a program to delete")
	public void admin_is_on_program_confirm_deletion_page_after_selecting_a_program_to_delete() throws InterruptedException {
		DeleteMultipleProgram_Page.getInstance().clickManyCheckBox();
		 DeleteMultipleProgram_Page.getInstance().clickDeleteBtn();
		 DeleteMultipleProgram_Page.getInstance().popup();
	}

	@When("Admin Click on <X> button") 
	public void admin_click_on_button()  {
DeleteMultipleProgram_Page.getInstance().closeWindow();
	}

	@Then("Admin can see Confirm Deletion form disappear")
	public void admin_can_see_confirm_deletion_form_disappear() {
		
LoggerLoad.info("Admin can see confirm deletion disappear");
	}



}
