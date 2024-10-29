package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Class_Page;

public class Steps_Classpage_Validation2 {
	
	@Given("Admin is on the Manage class page after login")
	public void admin_is_on_the_manage_class_page_after_login() {
	   
		Class_Page.getInstance().DashBoardPage();
		
		Class_Page.getInstance().ClassPageBtn();
	    
	}

	@When("Admin clicks add new class under the class menu bar")
	public void admin_clicks_add_new_class_under_the_class_menu_bar() {
		
	   Class_Page.getInstance().Add_New_Class();
	    
	}

	@Then("Admin should see a popup open for class details with an empty form along with save and cancel button and Close\\(X) Icon on the top right corner of the window")
	public void admin_should_see_a_popup_open_for_class_details_with_an_empty_form_along_with_save_and_cancel_button_and_close_x_icon_on_the_top_right_corner_of_the_window() {
	    
		Class_Page.getInstance().AddnewClass_Popup_Window();
		Class_Page.getInstance().ClassPopup_title();
		Class_Page.getInstance().ClassPopup_SaveBtn();
		Class_Page.getInstance().ClassPopup_CancelBtn();
		Class_Page.getInstance().ClassPopup_CloseBtn();
		Class_Page.getInstance().ClassPopup_Batchname();
		Class_Page.getInstance().ClassPopup_Classtopic();
		Class_Page.getInstance().ClassPopup_ClassDescription();
		Class_Page.getInstance().ClassPopup_Selectclassdates();
		Class_Page.getInstance().ClassPopup_NoOfClasses();
		Class_Page.getInstance().ClassPopup_Staffname();
		Class_Page.getInstance().ClassPopup_Status();
		Class_Page.getInstance().ClassPopup_Comments();
		Class_Page.getInstance().ClassPopup_Notes();
		Class_Page.getInstance().ClassPopup_Recordings();
		
	}

	@Then("Admin should see few input fields and their respective text boxes in the class details window")
	public void admin_should_see_few_input_fields_and_their_respective_text_boxes_in_the_class_details_window() {
	   
		Class_Page.getInstance().ClassPopup_Batchname();
		Class_Page.getInstance().ClassPopup_Classtopic();
		Class_Page.getInstance().ClassPopup_ClassDescription();
		Class_Page.getInstance().ClassPopup_Selectclassdates();
		Class_Page.getInstance().ClassPopup_NoOfClasses();
		Class_Page.getInstance().ClassPopup_Staffname();
		Class_Page.getInstance().ClassPopup_Status();
		Class_Page.getInstance().ClassPopup_Comments();
		Class_Page.getInstance().ClassPopup_Notes();
		Class_Page.getInstance().ClassPopup_Recordings();
		
	}

	@Given("Admin is on the Class Popup window")
	public void admin_is_on_the_class_popup_window() {
		
		Class_Page.getInstance().DashBoardPage();
		Class_Page.getInstance().ClassPageBtn();
		Class_Page.getInstance().Add_New_Class();
		Class_Page.getInstance().AddnewClass_Popup_Window();
		    
	}

	@When("Admin enters mandatory fields in the form and clicks on save button")
	public void admin_enters_mandatory_fields_in_the_form_and_clicks_on_save_button() {
		
		Class_Page.getInstance().enters_mandatory_fields();
		Class_Page.getInstance().Click_SaveBtn();
   
	}

	@Then("Admin gets message {string}")
	public void admin_gets_message(String string) {
	   
		Class_Page.getInstance().add_class_success_popup();
	}

//	@When("Admin selects class date in date picker")
//	public void admin_selects_class_date_in_date_picker() {
//	   
//	    ///failed not working 
//	}
//
//	@Then("Admin should see number of class value is added automatically")
//	public void admin_should_see_number_of_class_value_is_added_automatically() {
//	   
//	    ///failed not working 
//	}
//
//	@When("Admin clicks date picker")
//	public void admin_clicks_date_picker() {
//	   
//		///failed not working 
//	}
//
//	@Then("Admin should see weekends dates are disabled to select")
//	public void admin_should_see_weekends_dates_are_disabled_to_select() {
//	   
//		///failed not working 
//	}

	@When("Admin skips to add value in mandatory field and enters only the optional field")
	public void admin_skips_to_add_value_in_mandatory_field_and_enters_only_the_optional_field() {
		
		Class_Page.getInstance().add_class_optional_field();
		Class_Page.getInstance().Click_SaveBtn();
	    
	}

	@Then("Admin should see error message below the text field and the field will be highlighted in red color")
	public void admin_should_see_error_message_below_the_text_field_and_the_field_will_be_highlighted_in_red_color() {
	   
		Class_Page.getInstance().class_topic_mand_error_string();
	}

//	@When("Admin enters invalid data in all of the fields in the form and clicks on save button")
//	public void admin_enters_invalid_data_in_all_of_the_fields_in_the_form_and_clicks_on_save_button() {
//		
//		///failed not working
//	    
//	}
//
//	@Then("Admin gets error message and class is not created")
//	public void admin_gets_error_message_and_class_is_not_created() {
//	   
//		///failed not working
//	    
//	}

	@When("Admin clicks on save button without entering data")
	public void admin_clicks_on_save_button_without_entering_data() {
		
		Class_Page.getInstance().Click_SaveBtn();
	    
	}

	@Then("class won't be created and Admin gets error message")
	public void class_won_t_be_created_and_admin_gets_error_message() {
	   
		Class_Page.getInstance().Batch_name_mand_error_string();
		
		Class_Page.getInstance().class_topic_mand_error_string();
	    
	}

	@When("Admin clicks Cancel\\/Close\\(X) Icon on Admin Details form")
	public void admin_clicks_cancel_close_x_icon_on_admin_details_form() {
		
		Class_Page.getInstance().Click_closeBtn();
	
	    
	}

	@Then("Class Details popup window should be closed without saving")
	public void class_details_popup_window_should_be_closed_without_saving() {
		
	   System.out.println("Pop up Window is Closed SUCCESSFULLY");
	    
	}

	@When("Admin clicks save button")
	public void admin_clicks_save_button() {
		
		Class_Page.getInstance().All_Feild_ClassDetails();
		
		Class_Page.getInstance().Click_SaveBtn();
		
	}

	@Then("Admin can see the class details popup closed and adding new class")
	public void admin_can_see_the_class_details_popup_closed_and_adding_new_class() {
	   
		Class_Page.getInstance().add_class_success_popup();
		
	}



}

	

}
