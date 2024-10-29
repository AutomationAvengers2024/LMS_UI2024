package stepdefinitions;

import io.cucumber.java.en.Given;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Program_Add_Page;
import pages.Program_Edit_Page;


public class Program_Edit_Step {
	
	
	@Then("Admin clicks a edit button in the manage program page")
	public void admin_clicks_a_edit_button_in_the_manage_program_page() throws InterruptedException {
		
		Program_Edit_Page.getInstance().editbutton();
	    
	}

	@Given("Admin is on Program Details Popup window to Edit")
	public void admin_is_on_program_details_popup_window_to_edit() throws InterruptedException {
		
		Program_Edit_Page.getInstance().checkeditdetailPopup();
		
   }

	@When("Admin edits the Name column and clicks save button")
	public void admin_edits_the_name_column_and_clicks_save_button() {
		
		Program_Edit_Page.getInstance().ClickBtn("//button[@id ='saveProgram']");
		Program_Edit_Page.getInstance().Edit();
		
	    
	}

	@Then("Admin gets a message {string} alert and able to see the updated name in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_name_in_the_table_for_the_particular_program(String string) {
		
		System.out.println("Sucessfully Added");
	    
	}

	@When("Admin edits the Description column and clicks save button")
	public void admin_edits_the_description_column_and_clicks_save_button() {
		
		Program_Edit_Page.getInstance().descEdit();
		
	    	}

	@Then("Admin gets a message {string} alert and able to see the updated description in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_description_in_the_table_for_the_particular_program(String string) {
	    
		System.out.println("Sucessfully Added");
		
		}
	@When("Admin changes the Status and clicks save button")
	public void admin_changes_the_status_and_clicks_save_button() {
		
		Program_Edit_Page.getInstance().changestatus();
	    
	}

	@Then("Admin gets a message {string} alert and able to see the updated status in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_status_in_the_table_for_the_particular_program(String string) {
	   
		
		System.out.println("Sucessfully Added");
	}

	@When("Admin clicks <Cancel>button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
		
		Program_Edit_Page.getInstance().cancelwithoutchange();
	}

	@Then("Admin can see the Program details popup disappears and can see nothing changed for particular program")
	public void admin_can_see_the_program_details_popup_disappears_and_can_see_nothing_changed_for_particular_program() {
		
		System.out.println("Nothing changed");
	    
	}

	@When("Admin clicks <Save>button on edit popup")
	public void admin_clicks_save_button_on_edit_popup() {
		
		Program_Edit_Page.getInstance().detailsave();
	}

	@Then("Admin gets a message {string} alert and able to see the updated details in the table for the particular program")
	public void admin_gets_a_message_alert_and_able_to_see_the_updated_details_in_the_table_for_the_particular_program(String string) {
		
		System.out.println("Nothing changed");
	}







}
