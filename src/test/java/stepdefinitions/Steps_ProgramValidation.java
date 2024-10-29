package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProgramPage;

public class Steps_ProgramValidation {

	
	
	@Given("Admin is on dashboard page after Login")
	public void admin_is_on_dashboard_page_after_login() {
	   
		ProgramPage.getInstance().DashboardPageVerification();	
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
	   
		 ProgramPage.getInstance().clickProgramLink();	
	}

	@Then("Admin should see URL")
	public void admin_should_see_url() throws InterruptedException {
	    
		ProgramPage.getInstance().verifyProgramURL();	
	}

	@Then("Admin should see a heading with text {string} on the page")
	public void admin_should_see_a_heading_with_text_on_the_page(String PageHeading) {
	    
		ProgramPage.getInstance().ManageProgram_HeadingVerification(PageHeading); 	
	}

	@Then("Admin should see the text as {string} along with Pagination icon below the table.")
	public void admin_should_see_the_text_as_along_with_pagination_icon_below_the_table(String string) {
	    
		 ProgramPage.getInstance().paginationMessageVerification();	
	}

	@Then("Admin should see the footer as {string} z- Total number of records")
	public void admin_should_see_the_footer_as_z_total_number_of_records(String string) {
	    
		 ProgramPage.getInstance().ProgramFooter_MessageVerification();	
	}

	@Then("Admin should see a Delete button on the top left hand side as Disabled")
	public void admin_should_see_a_delete_button_on_the_top_left_hand_side_as_disabled() {
	    
		ProgramPage.getInstance().Program_CheckDeleteBtn();	
	}

	@Then("Admin should see a {string} button on the program page above the data table")
	public void admin_should_see_a_button_on_the_program_page_above_the_data_table(String string) {
	    
		ProgramPage.getInstance().Program_CheckAddProgramBtn();	
	}

	@Then("Admin should see the number of records \\(rows of data in the table) displayed on the page are {int}")
	public void admin_should_see_the_number_of_records_rows_of_data_in_the_table_displayed_on_the_page_are(Integer int1) {
	   
		ProgramPage.getInstance().Validate_ProgramTableRows();	
	}
	


	@Then("Admin should see the sort arrow icon beside to each column header except Edit and Delete")
	public void admin_should_see_the_sort_arrow_icon_beside_to_each_column_header_except_edit_and_delete() {
	    
		ProgramPage.getInstance().Validate_ProgramTable_SortIcon();	
	}

	@Then("Admin should see check box on the left side in all rows of the data table")
	public void admin_should_see_check_box_on_the_left_side_in_all_rows_of_the_data_table() {
	    
		ProgramPage.getInstance().ValidateCheckbox_ProgramTable();
	}

	@Then("Admin should see the Edit and Delete buttons on each row of the data table")
	public void admin_should_see_the_edit_and_delete_buttons_on_each_row_of_the_data_table() {
	   
		ProgramPage.getInstance().ValidateEditDeleteButton_ProgramTable();
	}

	@Then("Admin should see Search bar with text as {string}")
	public void admin_should_see_search_bar_with_text_as(String string) {
	   
		ProgramPage.getInstance().ValidateSearchBar();
	}



}
