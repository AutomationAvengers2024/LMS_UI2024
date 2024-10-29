package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Login_Page;
import pages.Class_Page;

public class Steps_Classpage_Validation1 {
	

	@Given("Admin is logged on the Dashboard page")
	public void admin_is_logged_on_the_dashboard_page() {
		
		Class_Page.getInstance().DashBoardPage();
	    
	}

	@When("Admin clicks the Class Navigation bar in the Header")
	public void admin_clicks_the_class_navigation_bar_in_the_header() { 
		
		Class_Page.getInstance().ClassPageBtn();
	    
	}

	@Then("Admin should land on the Manage class page")
	public void admin_should_land_on_the_manage_class_page() {
		
		Class_Page.getInstance().ManageClassPage();
	}

	@Given("Admin is on the dashboard page after login")
	public void admin_is_on_the_dashboard_page_after_login() {
		
		Class_Page.getInstance().DashBoardPage();
	   
	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String string) {
		
		Login_Page.getInstance().checkTitleOfPage("LMS-Learning Management System");
	   
	}

	@Then("Admin should see the {string} Header")
	public void admin_should_see_the_header(String string) {
		
		Class_Page.getInstance().ManageClass_HeadingVerification("Manage Class");
	    
	}

	@Then("Admin should see the Searchbar in Manage class page")
	public void admin_should_see_the_searchbar_in_manage_class_page() {
		
		Class_Page.getInstance().ManageClass_Searchbarverification();
	    
	}

	@Then("Admin should see the datatable heading like Batchname, class topic, class description, status, class Date, staff name, Edit\\/Delete")
	public void admin_should_see_the_datatable_heading_like_batchname_class_topic_class_description_status_class_date_staff_name_edit_delete() {
		
		Class_Page.getInstance().ManageClass_DataTableHeaders();
	   
	}

	@Then("Admin should see {string} and enabled pagination controls under the data table")
	public void admin_should_see_and_enabled_pagination_controls_under_the_data_table(String string) {
		
		Class_Page.getInstance().PaginationText_and_Control();
	    
	}

	@Then("Admin should see the Sort icon of all the fields in the datatable")
	public void admin_should_see_the_sort_icon_of_all_the_fields_in_the_datatable() {
		
	   Class_Page.getInstance().ManageClass_SortIconcheck();
		
	}

	@Then("Admin should see the Delete button under the Manage class page header")
	public void admin_should_see_the_delete_button_under_the_manage_class_page_header() {
		
		Class_Page.getInstance().ManageClass_Under_DeleteIcon();
	    
	}

	@Then("Admin should see Total number of classes below the data table")
	public void admin_should_see_total_number_of_classes_below_the_data_table() {
		
		Class_Page.getInstance().ManageClass_TotalClassPresentCountMsg();
	    
	}


	
}
