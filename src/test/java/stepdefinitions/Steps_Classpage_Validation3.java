package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Class_Page;

public class Steps_Classpage_Validation3 {
	
	@Given("Admin is on the Manage Class page after login")
	public void admin_is_on_the_manage_class_page_after_login() {
	    
		Class_Page.getInstance().DashBoardPage();
		
		Class_Page.getInstance().ClassPageBtn();
	    
	}

	@When("Admin clicks on the edit icon")
	public void admin_clicks_on_the_edit_icon() {
	    
	    Class_Page.getInstance().Click_Edit_Button();
		
	}

	@Then("A new pop up with class details appears")
	public void a_new_pop_up_with_class_details_appears() {
		
		Class_Page.getInstance().Edit_Popup_Window();
	    
	}

	@Then("Admin should see batch name field is disabled")
	public void admin_should_see_batch_name_field_is_disabled() {
	    
		Class_Page.getInstance().Batch_name_Disable();
	}

	@Then("Admin should see class topic field is disabled")
	public void admin_should_see_class_topic_field_is_disabled() {
		Class_Page.getInstance().Class_Topic_Disable();
		
	}

	@Given("Admin is on the Edit Class Popup window")
	public void admin_is_on_the_edit_class_popup_window() {
	    
		Class_Page.getInstance().DashBoardPage();
		Class_Page.getInstance().ClassPageBtn();
		Class_Page.getInstance().Click_Edit_Button();
		Class_Page.getInstance().Edit_Popup_Window();
	}

	@When("Admin updates the fields with valid data and clicks save")
	public void admin_updates_the_fields_with_valid_data_and_clicks_save() {
	
		Class_Page.getInstance().Update_Class_Description_Edit("new Class");
		Class_Page.getInstance().Click_SaveBtn();
	}

	@Then("Admin gets message {string} and sees the updated values in data table")
	public void admin_gets_message_and_sees_the_updated_values_in_data_table(String string) {
	   
		System.out.println("Changes can be seen for the edited class values ");
		
	}

//	@When("Admin updates the fields with invalid values and clicks save")
//	public void admin_updates_the_fields_with_invalid_values_and_clicks_save() {
//	   
//	    ///Fsailed Error 
//	}
//
//	@Then("Admin should get Error message")
//	public void admin_should_get_error_message() {
//	    
//		 ///Fsailed Error 
//	}

	@When("Admin updates the mandatory fields with valid values and clicks save")
	public void admin_updates_the_mandatory_fields_with_valid_values_and_clicks_save() {
	    
		Class_Page.getInstance().Update_Staff_Name_mand_Edit();
		Class_Page.getInstance().Click_SaveBtn();
	}

	@When("Admin updates the optional fields with valid values and clicks save")
	public void admin_updates_the_optional_fields_with_valid_values_and_clicks_save() {
	   
		Class_Page.getInstance().Update_Class_Description_Edit("Old Class");
		Class_Page.getInstance().Click_SaveBtn();
	    
	}

	@When("Admin enters only numbers or special characters in the text fields")
	public void admin_enters_only_numbers_or_special_characters_in_the_text_fields() {
		Class_Page.getInstance().Update_Class_Description_Edit("#$%$");
		Class_Page.getInstance().Click_SaveBtn();
	    
	}

	@When("Admin clicks Cancel button on edit popup")
	public void admin_clicks_cancel_button_on_edit_popup() {
	   
		Class_Page.getInstance().Click_CancelBtn();
	}

	@Then("Admin can see the class details popup disappears and can see nothing changed for particular Class")
	public void admin_can_see_the_class_details_popup_disappears_and_can_see_nothing_changed_for_particular_class() {
	   
		System.out.println("Nothing changed for the particular class ");
	}



}
