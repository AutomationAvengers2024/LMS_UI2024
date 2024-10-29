package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Paginiation_Page;
import utilities.LoggerLoad;

public class Steps_Paginiation {


	@Given("Admin is on Program module")
	public void admin_is_on_program_module() {
	 
	}

	@When("Admin clicks Next page link on the program table")
	public void admin_clicks_next_page_link_on_the_program_table() {
	Paginiation_Page.getInstance().nextPageLink();
	}

	@Then("Admin should see the Pagination has {string} active link")
	public void admin_should_see_the_pagination_has_active_link(String string) {
        LoggerLoad.info("Admin should see the pagination has " +string+ "active Link");
	}

	@When("Admin clicks Last page link")
	public void admin_clicks_last_page_link() {
		Paginiation_Page.getInstance().lastPageLink();
	}

	@Then("Admin should see the last page record on the table with Next page link are disabled")
	public void admin_should_see_the_last_page_record_on_the_table_with_next_page_link_are_disabled() {
	LoggerLoad.info("Admin should see the last page record on the table with Next page link are disabled");
	}

	@Given("Admin is on last page of Program module table")
	public void admin_is_on_last_page_of_program_module_table() {
	 
	}

	@When("Admin clicks Previous page link")
	public void admin_clicks_previous_page_link() {
		Paginiation_Page.getInstance().previousPageLink();
	}

	@Then("Admin should see the previous page record on the table with pagination has previous page link")
	public void admin_should_see_the_previous_page_record_on_the_table_with_pagination_has_previous_page_link() {
      LoggerLoad.info("Admin can see previous page");
	}

	@Given("Admin is on Previous Program page")
	public void admin_is_on_previous_program_page() {
	  
	}

	@When("Admin clicks First page link")
	public void admin_clicks_first_page_link() {
		Paginiation_Page.getInstance().firstPageLink();
	}

	@Then("Admin should see the very first page record on the table with Previous page link are disabled")
	public void admin_should_see_the_very_first_page_record_on_the_table_with_previous_page_link_are_disabled() {
      LoggerLoad.info("Admin should see the very first page record on the table with Previous page link are disabled");
	}

}
