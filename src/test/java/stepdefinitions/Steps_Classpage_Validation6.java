package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Class_Page;

public class Steps_Classpage_Validation6 {
	
	
	@Given("Admin is on the Manage Class page after Valid Login")
	public void admin_is_on_the_manage_class_page_after_valid_login() {
	    
		Class_Page.getInstance().DashBoardPage();
		
		Class_Page.getInstance().ClassPageBtn();
		
	}
	
	@When("Admin enters the Batch Name in the search textbox")
	public void admin_enters_the_batch_name_in_the_search_textbox() {
	    
		Class_Page.getInstance().batch_Name_search();
	}

	@Then("Admin should see Class details are searched by Batch Name")
	public void admin_should_see_class_details_are_searched_by_batch_name() {
	    
	    Class_Page.getInstance().batch_Name_Searchvalidation();
		
	}

	@When("Admin enters the Class topic in the search textbox")
	public void admin_enters_the_class_topic_in_the_search_textbox() {
	    
		 Class_Page.getInstance().Class_Topic_search();
	}

	@Then("Admin should see Class details are searched by Class topic")
	public void admin_should_see_class_details_are_searched_by_class_topic() {
		 Class_Page.getInstance().Class_Topic_Searchvalidation();
	    
	}

	@When("Admin enters the Staff Name in the search textbox")
	public void admin_enters_the_staff_name_in_the_search_textbox() {
		 Class_Page.getInstance().Staff_Name_search();
	    
	}

	@Then("Admin should see Class details are searched by Staff Name")
	public void admin_should_see_class_details_are_searched_by_staff_name() {
		 Class_Page.getInstance().Staff_Name_Searchvalidation();
	    
	}

	@When("Admin clicks Next page link on the class table")
	public void admin_clicks_next_page_link_on_the_class_table() {
	    
		
		Class_Page.getInstance().Click_ClassNxtPageBtn();
	    
	}

	@Then("Admin should see the next page record on the table with Pagination has next active link enabled")
	public void admin_should_see_the_next_page_record_on_the_table_with_pagination_has_next_active_link_enabled() {
	    
		Class_Page.getInstance().admin_clicks_next_page();
	    
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
	    
		Class_Page.getInstance().Click_ClassLastPageBtn();
	}

	@Then("Admin should see the last page record on the table with Next page link disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_disabled() {
		Class_Page.getInstance().check_next_class_button_status();
		
	}

	@Given("Admin is on the last page of the class table")
	public void admin_is_on_the_last_page_of_the_class_table() {
	    
		Class_Page.getInstance().check_last_class_button_status();
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
	    
		Class_Page.getInstance().Click_ClassFirstPageBtn();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link enabled")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link_enabled() {
	    
		Class_Page.getInstance().check_back_class_button_status();
	}

	@Given("Admin is on a previous class page")
	public void admin_is_on_a_previous_class_page() {
	    
	    
	}

	@When("Admin clicks Start page link")
	public void admin_clicks_start_page_link() {
	    
	    
	}

	@Then("Admin should see the very first page record on the table with Previous page link disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_disabled() {
	    
	    
	}

	@Given("Admin is on the dashboard page after login and clicks Class on the navigation bar")
	public void admin_is_on_the_dashboard_page_after_login_and_clicks_class_on_the_navigation_bar() {
	    
	    
	}

	@When("Admin clicks on Class link on Manage Class page")
	public void admin_clicks_on_class_link_on_manage_class_page() {
	    
	    
	}

	@Then("Admin is re-directed to the class page")
	public void admin_is_re_directed_to_the_class_page() {
	    
	    
	}

	@When("Admin clicks on any module link on Manage Class page")
	public void admin_clicks_on_any_module_link_on_manage_class_page() {
	    
	    
	}

	@Then("Admin is re-directed to the module link they clicked")
	public void admin_is_re_directed_to_the_module_link_they_clicked() {
	    
	    
	}

	@When("Admin clicks on Logout link on Manage Class page")
	public void admin_clicks_on_logout_link_on_manage_class_page() {
	    
	    
	}

	@Then("Admin is re-directed to the Login page")
	public void admin_is_re_directed_to_the_login_page() {
	    
	    
	}



}
