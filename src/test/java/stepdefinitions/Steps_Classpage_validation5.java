package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Class_Page;

public class Steps_Classpage_Validation5 {

	@Given("Admin is on the Manage Class page after login.")
	public void admin_is_on_the_manage_class_page_after_login() {
		
		Class_Page.getInstance().DashBoardPage();
		
		Class_Page.getInstance().ClassPageBtn();
	    
	}

	@When("Admin clicks the delete icon,")
	public void admin_clicks_the_delete_icon() {
		
	    Class_Page.getInstance().Click_Table_Deletebtn();
	    
	}

	@Then("Admin should see an alert open with the heading {string} along with a button for deletion.")
	public void admin_should_see_an_alert_open_with_the_heading_along_with_a_button_for_deletion(String string) {
	    
		Class_Page.getInstance().delete_popup_window();
	    
	}

	@Given("Admin is on the Confirm Deletion alert,")
	public void admin_is_on_the_confirm_deletion_alert() {
	    
	    
	}

	@When("Admin clicks the yes option,")
	public void admin_clicks_the_yes_option() {
	    
	    
	}

	@Then("Admin gets a message {string} alert and does not see that Class in the data table.")
	public void admin_gets_a_message_alert_and_does_not_see_that_class_in_the_data_table(String string) {
	    
	    
	}

	@When("Admin clicks the no option,")
	public void admin_clicks_the_no_option() {
	    
	    
	}

	@Then("Admin can see the deletion alert disappears without deleting.")
	public void admin_can_see_the_deletion_alert_disappears_without_deleting() {
	    
	    
	}

	@When("Admin clicks on the close button,")
	public void admin_clicks_on_the_close_button() {
	    
	    
	}

	@Then("Admin can see the deletion alert disappears without any changes.")
	public void admin_can_see_the_deletion_alert_disappears_without_any_changes() {
	    
	    
	}

	@When("Admin clicks any checkbox in the data table,")
	public void admin_clicks_any_checkbox_in_the_data_table() {
	    
	    
	}

	@Then("Admin should see the common delete option enabled under the header Manage Class.")
	public void admin_should_see_the_common_delete_option_enabled_under_the_header_manage_class() {
	    
	    
	}

	@When("Admin clicks the button on the alert,")
	public void admin_clicks_the_button_on_the_alert() {
	    
	    
	}

	@Then("Admin should land on the Manage Class page and can see the selected class is deleted from the data table.")
	public void admin_should_land_on_the_manage_class_page_and_can_see_the_selected_class_is_deleted_from_the_data_table() {
	    
	    
	}

	@Then("Admin should land on the Manage Class page and can see the selected classes are deleted from the data table.")
	public void admin_should_land_on_the_manage_class_page_and_can_see_the_selected_classes_are_deleted_from_the_data_table() {
	    
	    
	}


	
}
