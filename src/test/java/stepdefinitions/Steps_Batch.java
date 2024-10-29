package stepdefinitions;

import app_hooks.AppHooks;
import constants.Constants;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Batch_Page;
import pages.Login_Page;
import pages.Logout_Page;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class Steps_Batch {

	private Batch_Page batchPage = new Batch_Page();

	@Given("Admin is on the Dashboard Page after login")
	public void admin_is_on_the_dashboard_page_after_login() {
		AppHooks.getInstance().getDriver().get(Constants.URL);
		Login_Page.getInstance().enterusername();
		Login_Page.getInstance().enterpassword();
		Login_Page.getInstance().clickLoginBtn();
		Login_Page.getInstance().checkTitleOfPage("LMS");
	}

	@Given("Admin is on the Batch Details Pop Up Window")
	public void admin_is_on_the_batch_details_pop_up_window() {
		// Call the existing login function to go to the dashboard
		admin_is_on_the_dashboard_page_after_login();
		// Navigate to Batch details pop-up after login
		batchPage.clickBatchMenuOpt();
		batchPage.clickAddNewBatchSubmenu();
		batchPage.verifyBatchDetailsPopUp();
	}

	@When("Admin clicks on the Batch menu from the header")
	public void admin_clicks_on_the_batch_menu_from_the_header() {
		batchPage.clickBatchMenu();
	}

	@Then("Admin should be on the Manage Batch Page")
	public void admin_should_be_on_the_manage_batch_page() {
		String actualText = batchPage.getManageBatchHeading();
		String expectedText = "Manage Batch";
		Assert.assertEquals("Text does not match", expectedText, actualText);
	}

	@Then("Admin should see the {string} Title")
	public void admin_should_see_the_title(String expectedTitle) {
		// Assuming there is a method in Login_Page to check the title; otherwise, you
		// can create a method in BatchPage for this
		batchPage.checkTitleOfPage(expectedTitle); // Create a method in BatchPage for title check if necessary
	}

	@Then("Admin should see the {string} Heading")
	public void admin_should_see_the_heading(String expectedHeading) {
		String actualHeading = batchPage.getManageBatchHeading(); // Use getManageBatchHeading() for comparison
		Assert.assertEquals("Heading does not match", expectedHeading, actualHeading);
	}

	@Then("Admin should see the disabled Delete Icon under the header")
	public void admin_should_see_the_disabled_delete_icon_under_the_header() {
		batchPage.verifyDeleteIconIsDisabled();
	}

	@Then("Admin should see the enabled pagination controls under the data table")
	public void admin_should_see_the_enabled_pagination_controls_under_the_data_table() {
		batchPage.verifyPaginationControlsAreEnabled();
	}

	@Then("Admin should see the edit icon in each row")
	public void admin_should_see_the_edit_icon_in_each_row() {
		batchPage.verifyEditIconsInEachRow();
	}

	@Then("Admin should see the delete icon in each row")
	public void admin_should_see_the_delete_icon_in_each_row() {
		batchPage.verifyDeleteIconsInEachRow();
	}

	@Then("Admin should see the checkbox in each row")
	public void admin_should_see_the_checkbox_in_each_row() {
		batchPage.verifyCheckboxesInEachRow();
	}

	@Then("Admin should see the datatable headers:")
	public void admin_should_see_the_datatable_headers(DataTable expectedHeadersTable) {
		List<String> expectedHeaders = expectedHeadersTable.asList(String.class);
		batchPage.verifyDataTableHeaders(expectedHeaders);
	}

	@Then("Admin should see the checkbox in the datatable header row")
	public void admin_should_see_the_checkbox_in_the_datatable_header_row() {
		batchPage.verifyHeaderCheckboxIsDisplayed();
	}

	@Then("Admin should see the sort icon next to all Datatable headers")
	public void admin_should_see_the_sort_icon_next_to_all_datatable_headers() {
		batchPage.verifySortIconsInAllHeaders();
	}

	@When("Admin clicks {string} on the navigation bar")
	public void admin_clicks_on_the_navigation_bar(String string) {
		batchPage.clickOnNavigationBar(string);
	}

	@Then("Admin should see sub menu in menu bar as {string}")
	public void admin_should_see_sub_menu_in_menu_bar_as(String submenuItem) {
		batchPage.verifySubMenuIsDisplayed(submenuItem);
	}

	@When("Admin clicks on {string} under the {string} menu bar")
	public void admin_clicks_on_under_the_menu_bar(String submenuItem, String menuItem) {
		batchPage.clickOnSubMenu(submenuItem, menuItem);
	}

	@Then("Admin should see the Batch Details pop-up window")
	public void admin_should_see_the_batch_details_pop_up_window() {
		batchPage.verifyPopUpIsVisible();
	}

	@When("Admin checks all the fields are enabled")
	public void admin_checks_all_the_fields_are_enabled() {
		batchPage.verifyAllFieldsAreEnabled();
	}

	@Then("the pop-up should include the fields Batch Name Number of classes and Description as text box Program Name as drop down and Status as radio button")
	public void the_pop_up_should_include_the_fields_batch_name_number_of_classes_and_description_as_text_box_program_name_as_drop_down_and_status_as_radio_button() {
		batchPage.validateBatchDetailsFields();
	}

	@When("Admin selects program name present in the dropdown")
	public void admin_selects_program_name_present_in_the_dropdown() {
		batchPage.selectProgramName();
	}

	@Then("Admin should see selected program name in the batch name prefix box")
	public void admin_should_see_selected_program_name_in_the_batch_name_prefix_box() {
		batchPage.validateBatchNamePrefixMatchesProgramName();
	}

	@When("Admin enters alphabets in the batch name suffix box")
	public void admin_enters_alphabets_in_the_batch_name_suffix_box() {
		batchPage.enterBatchNameSuffix("abc123");
	}

	@Then("Admin should get an error message below the text box of the respective field")
	public void admin_should_get_an_error_message_below_the_text_box_of_the_respective_field() {
		String expectedErrorMessage = "This field accept only numbers and max 5 count.";
		batchPage.validateErrorMessage(expectedErrorMessage);
	}

	@When("Admin enters alphabets in the batch name prefix box")
	public void admin_enters_alphabets_in_the_batch_name_prefix_box() {
		batchPage.enterAlphabetsInBatchNamePrefix();
	}

	@Then("Admin should see an empty text box")
	public void admin_should_see_an_empty_text_box() {
		Assert.assertTrue("Batch Name prefix box should be empty after entering alphabets",
				batchPage.isBatchNamePrefixBoxEmpty());
	}

	@When("Admin enters data only in the mandatory fields and clicks the save button")
	public void admin_enters_data_only_in_the_mandatory_fields_and_clicks_the_save_button() {
		batchPage.enterDataInMandatoryFieldsAndSave();
	}

	@Then("Admin should get a successful message")
	public void admin_should_get_a_successful_message() {
		Assert.assertTrue("Admin should see a success message", batchPage.isSaveSuccessful());
	}

	@When("Admin leaves blank one of the mandatory fields")
	public void admin_leaves_blank_one_of_the_mandatory_fields() {
		// Initialize expected error message
		batchPage.resetExpectedErrorMessage(); // Reset before action

		// Attempt to enter valid data into the batch name field if it's mandatory
		boolean batchNameMandatory = batchPage.isFieldMandatory(batchPage.getBatchProgramNameLocator());
		if (batchNameMandatory) {
			// Generate a numeric batch name
			String numericBatchName = generateNumericBatchName();
			batchPage.enterBatchName(numericBatchName);
		}

		// Attempt to fill the description field if it's mandatory
		boolean descriptionMandatory = batchPage.isFieldMandatory(batchPage.getDescriptionLocator());
		if (descriptionMandatory) {
			batchPage.enterDescription("New batch");
		}

		// Select Active Radio Option
		batchPage.selectActiveRadio(); // Click the radio button

		// Attempt to enter valid data into the number of classes field if it's
		// mandatory
		boolean numberOfClassesMandatory = batchPage.isFieldMandatory(batchPage.getNumberOfClassesLocator());
		if (numberOfClassesMandatory) {
			// Leaving it blank to trigger error
		}

		// Click the Save button
		batchPage.clickSave();

		// Track which field was left blank
		batchPage.trackBlankField(batchNameMandatory, descriptionMandatory, numberOfClassesMandatory);
	}

	// Method to generate a numeric batch name limited to 5 digits
	private String generateNumericBatchName() {
		int randomNumber = (int) (Math.random() * 100000);
		return String.format("%05d", randomNumber); // Format to ensure it is 5 digits
	}

	@Then("Admin should get an error message on the respective mandatory field")
	public void admin_should_get_an_error_message_on_the_respective_mandatory_field() {
		WebElement errorMessageElement = batchPage.getErrorMessage();
		String actualMessage = errorMessageElement.getText();

		// Determine the expected error message based on the last action or context
		String expectedMessage = batchPage.getExpectedErrorMessage();

		// Ensure expected message is not null
		if (expectedMessage == null) {
			expectedMessage = "Some field is required.";
		}

		Assert.assertEquals(expectedMessage, actualMessage);
	}

	@When("Admin enters valid data in all the mandatory fields and clicks the save button")
	public void admin_enters_valid_data_and_clicks_save() {

		batchPage.selectProgramName();
		// Enter valid data into the batch name field
		batchPage.enterBatchName(generateNumericBatchName());

		// Fill in the description field
		batchPage.enterDescription("Valid batch description");

		// Select the active radio option
		batchPage.selectActiveRadio();

		// Enter valid data into the number of classes field
		batchPage.enterNumberOfClasses("5");

		// Click the Save button
		batchPage.clickSave();
	}

	@When("Admin enters valid data in all the mandatory fields and clicks the cancel button")
	public void admin_enters_valid_data_in_all_the_mandatory_fields_and_clicks_the_cancel_button() {
		batchPage.selectProgramName();
		batchPage.enterBatchName("Batch_" + System.currentTimeMillis());
		batchPage.enterDescription("Sample Description");
		batchPage.selectRadio();
		batchPage.enterNumberOfClasses("5");
		batchPage.clickCancel();
	}

	@Then("Admin can see the Batch Details pop-up closes without creating any batch")
	public void admin_can_see_the_batch_details_popup_closes_without_creating_any_batch() {
		Assert.assertTrue("The Batch Details pop-up did not close.", batchPage.isPopUpClosed());
	}

	@When("Admin clicks on the close icon")
	public void admin_clicks_on_the_close_icon() {
		batchPage.clickCloseIcon();
	}

	@Then("Batch Details pop-up closes")
	public void batch_details_pop_up_closes() {
		Assert.assertTrue("Batch Details pop-up is still displayed", batchPage.isPopUpClosed());
	}
	
	@When("Admin clicks on the logout in the menu bar")
	public void admin_clicks_on_the_logout_in_the_menu_bar() {
		Logout_Page.getInstance().clickLogoutBtn(); 
	}

	@Then("Admin should be redirected to login page")
	public void admin_should_be_redirected_to_login_page() {
		Login_Page.getInstance().checkTitleOfPage("LMS");
	}
}
