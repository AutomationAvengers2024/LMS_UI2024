package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Class_Page;

public class Steps_Classpage_Validation4 {
	
	@Given("Admin is on the Manage Class page after logingin")
	public void admin_is_on_the_manage_class_page_after_logingin() {
	    
		Class_Page.getInstance().DashBoardPage();
		
		Class_Page.getInstance().ClassPageBtn();
		
	}
	
	@When("Admin clicks on the Batchname sort icon")
	public void admin_clicks_on_the_batchname_sort_icon() {
		
		Class_Page.getInstance().Batchname_Sorticon();
		 
	}

	@Then("Admin should see Class details are sorted by Batch Name")
	public void admin_should_see_class_details_are_sorted_by_batch_name() {
		
		Class_Page.getInstance().Batchname_Sort();
	      
	}

	@When("Admin clicks on the Class topic sort icon")
	public void admin_clicks_on_the_class_topic_sort_icon() {
		
		Class_Page.getInstance().Classtopic_Sorticon();
	    
	}

	@Then("Admin should see Class details are sorted by Class Topic")
	public void admin_should_see_class_details_are_sorted_by_class_topic() {
	    
		Class_Page.getInstance().Classtopic_Sort();
	}

	@When("Admin clicks on the Class description sort icon")
	public void admin_clicks_on_the_class_description_sort_icon() {
	    
		Class_Page.getInstance().ClassDescription_Sorticon();
	    
	}

	@Then("Admin should see Class details are sorted by Class Description")
	public void admin_should_see_class_details_are_sorted_by_class_description() {
	    
		Class_Page.getInstance().ClassDescription_Sort();
	    
	}

	@When("Admin clicks on the Status sort icon")
	public void admin_clicks_on_the_status_sort_icon() {
		
		Class_Page.getInstance().Status_Sorticon();
	    
	}

	@Then("Admin should see Class details are sorted by Status")
	public void admin_should_see_class_details_are_sorted_by_status() {
	    
		Class_Page.getInstance().Status_Sort();
	    
	}

	@When("Admin clicks on the Class Date sort icon")
	public void admin_clicks_on_the_class_date_sort_icon() {
	    
		Class_Page.getInstance().ClassDate_Sorticon();
	    
	}

	@Then("Admin should see Class details are sorted by Class Date")
	public void admin_should_see_class_details_are_sorted_by_class_date() {
	    
		Class_Page.getInstance().ClassDate_Sort();
	    
	}

	@When("Admin clicks on the Staff Name sort icon")
	public void admin_clicks_on_the_staff_name_sort_icon() {
	    
		Class_Page.getInstance().StaffName_Sorticon();
	    
	}

	@Then("Admin should see Class details are sorted by Staff name")
	public void admin_should_see_class_details_are_sorted_by_staff_name() {
	    
		Class_Page.getInstance().StaffName_Sort();
	    
	}


	

}
