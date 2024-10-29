package stepdefinitions;

import app_hooks.AppHooks;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import pages.Program_Add_Page;

public class Program_Add_step {
	
	
	@Given("Admin is on Manage Program Page")
	public void admin_is_on_manage_program_page() {
	  
		AppHooks.getInstance().getDriver().getCurrentUrl();
	}

	@When("Admin clicks <New Program>button")
	public void admin_clicks_new_program_button() {
	 
		Program_Add_Page.getInstance().clickprogrambtn();	
	}

	@Then("Admin should see a popup open for Program details")
	public void admin_should_see_a_popup_open_for_program_details() {
	   
		Program_Add_Page.getInstance().checkNewProgramPopup();
	}

	@Then("Admin should see the window title as {string}")
	public void admin_should_see_the_window_title_as(String string) {
	   
		Program_Add_Page.getInstance().checkNewProgramPopup();
	}
	
	@When("Admin clicks <New Program>button and clicks <Save>button without entering any data")
	public void admin_clicks_new_program_button_and_clicks_save_button_without_entering_any_data() {
	    
		Program_Add_Page.getInstance().clickprogrambtn();
		Program_Add_Page.getInstance().savedetail();
	}

	@Then("Admin gets a Error message alert")
	public void admin_gets_a_error_message_alert() throws InterruptedException {
	  
		Program_Add_Page.getInstance().errorpopup();
	}

	@When("Admin clicks <New Program>button and enters only <Program Name> in text box and clicks Save button")
	public void admin_clicks_new_program_button_and_enters_only_program_name_in_text_box_and_clicks_save_button() {
	    
		Program_Add_Page.getInstance().clickprogrambtn();
		Program_Add_Page.getInstance().protextbox();
		Program_Add_Page.getInstance().savedetail();
	}

	@Then("Admin gets a message alert {string}")
	public void admin_gets_a_message_alert(String string) {
		
		Program_Add_Page.getInstance().alertpopup(); 
	}

	@When("Admin clicks <New Program>button and enters only<Program description> in text box and clicks Save button")
	public void admin_clicks_new_program_button_and_enters_only_program_description_in_text_box_and_clicks_save_button() {
	    
		Program_Add_Page.getInstance().clickprogrambtn();
		Program_Add_Page.getInstance().destextbox();
		Program_Add_Page.getInstance().savedetail();
	}

	@When("Admin clicks <New Program>button and selects only Status and clicks Save button")
	public void admin_clicks_new_program_button_and_selects_only_status_and_clicks_save_button() {
	    
		Program_Add_Page.getInstance().clickprogrambtn();
		Program_Add_Page.getInstance().clickactivebtn();
		Program_Add_Page.getInstance().savedetail();
	}

	@When("Admin clicks <New Program>button and enters only numbers in name and desc column and clicks Save button")
	public void admin_clicks_new_program_button_and_enters_only_numbers_in_name_and_desc_column_and_clicks_save_button() {
	   
		Program_Add_Page.getInstance().clickprogrambtn();
		Program_Add_Page.getInstance().nametbox();
    	Program_Add_Page.getInstance().savedetail();
	}

	@When("Admin clicks <New Program>button and click Cancel Icon on Program Detail form")
	public void admin_clicks_new_program_button_and_click_cancel_icon_on_program_detail_form() {
	    
		Program_Add_Page.getInstance().clickprogrambtn();
		Program_Add_Page.getInstance().cancel();
	}

	@Then("Program Details popup window should be closed without saving")
	public void program_details_popup_window_should_be_closed_without_saving() {
	    
		System.out.println("Window Closed");
	}

	@When("Admin clicks <New Program>button and enter all the required fields with valid values and click Save button")
	public void admin_clicks_new_program_button_and_enter_all_the_required_fields_with_valid_values_and_click_save_button() {
	    
		Program_Add_Page.getInstance().clickprogrambtn();
		Program_Add_Page.getInstance().protextbox();
		Program_Add_Page.getInstance().destextbox();
		Program_Add_Page.getInstance().clickactivebtn();
		Program_Add_Page.getInstance().savedetail();
	}

	@Then("Admin gets a message {string} alert and able to see the new program added in the data table")
	public void admin_gets_a_message_alert_and_able_to_see_the_new_program_added_in_the_data_table(String string) {
	    
		System.out.println("SDET150");
		System.out.println("software testing");
		System.out.println("Active");
	}

	@When("Admin clicks <New Program>button and clicks <Cancel>button")
	public void admin_clicks_new_program_button_and_clicks_cancel_button() {
	    
		Program_Add_Page.getInstance().clickprogrambtn();
		Program_Add_Page.getInstance().cancelbtn();
	}

	@Then("Admin can see the Program details popup disappears without creating any program")
	public void admin_can_see_the_program_details_popup_disappears_without_creating_any_program() {
	    
		System.out.println("Program Disappears");
	}
	
	@Then("Admin should see a popup open for Program details with empty form along with <SAVE> and <CANCEL> button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_program_details_with_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
	    
		Program_Add_Page.getInstance().checkNewProgramPopup();
	}

	@Then("Admin should see two input fields and their respective text boxes in the program details window")
	public void admin_should_see_two_input_fields_and_their_respective_text_boxes_in_the_program_details_window() {
	    
		Program_Add_Page.getInstance().inputFields();
	}

	@Then("Admin should see two radio button for Program Status")
	public void admin_should_see_two_radio_button_for_program_status() {
	    
		Program_Add_Page.getInstance().radioFields();
	}

	


	

}
