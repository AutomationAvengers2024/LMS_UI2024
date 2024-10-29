package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Assert;

import app_hooks.AppHooks;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Batch_Page {
	private WebDriver driver;
	private WebDriverWait wait;

	// Locators
	private By btnBatch = By.xpath("//span[text() = 'Batch']");
	private By manageBatchHeadingLocator = By.xpath("//*[@class='mat-card mat-focus-indicator']/mat-card-title/div[1]");
	private By deleteIconLocator = By.cssSelector(".p-button-icon.pi.pi-trash");
	private By paginationControlsLocator = By.xpath("//div[contains(@class, 'p-paginator')]");
	private By editIconLocator = By.xpath(".//span[contains(@class, 'p-button-icon pi pi-pencil')]");
	private By checkboxLocator = By.xpath(".//div[contains(@class, 'p-checkbox-box p-component')]");
	private By tableHeaderLocator = By.className("p-datatable-thead");
	private By headerCheckboxLocator = By.xpath("(//*[@class = 'p-checkbox p-component'])[1]");
	private By sortIconLocator = By.xpath(".//*[contains(@class, 'p-sortable-column-icon')]");
	private By popUpLocator = By.xpath("//*[contains(text(),'Batch Details')]");
	private By programNameLocator = By.xpath("//*[@id=\"programName\"]/div/input");
	private By batchProgramLocator = By.xpath("//*[@id=\"batchProg\"]");
	private By batchProgramNameLocator = By.xpath("(//*[@id=\"batchName\"])[1]");
	private By descriptionLocator = By.xpath("//*[@id=\"batchDescription\"]");
	private By statusRadioLocator = By.xpath("//*[@id=\"batchStatus\"]/div/div[2]");
	private By numberOfClassesLocator = By.xpath("//*[@id=\"batchNoOfClasses\"]");
	private By batchMenu = By.xpath("//span[text() = 'Batch']");
	private By addNewBatchSubmenu = By.xpath("//*[contains(text(),'Add New Batch')]");
	private By batchDetailsPopUp = By.xpath("//*[contains(text(), 'Batch Details')]");
	private By dropdownButtonLocator = By.xpath("//*[@id=\"programName\"]/div/div[2]");
	private By dropdownOptionLocator = By.xpath("//*[@id=\"programName\"]/div/div[3]/div/ul/p-dropdownitem[4]/li");
	private By errorMessageLocator = By.xpath("//*[@id=\"text-danger\"]");
	private By saveButtonLocator = By.xpath("//*[contains(text(),'Save')]");
	private By toastMessageLocator = By.xpath("//*[contains(text(), 'Successful')]");
	private By programNameDropdownBtn = By.xpath("//*[@id=\"programName\"]/div/div[2]");
	private By programDropdownOption = By.xpath("//*[@id=\"programName\"]/div/div[3]/div/ul/p-dropdownitem[4]/li");
	private By activeRadioButtonLocator = By.xpath("//*[@id=\"batchStatus\"]/div/div[2]");
	private By cancelButtonLocator = By.xpath("//*[contains(text(),'Cancel')]");
	private By closeIconLocator = By.className("p-dialog-header-close-icon");

	public Batch_Page() {
		this.driver = AppHooks.getInstance().getDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void checkTitleOfPage(String expectedTitle) {
		// Implementation for checking page title
		Assert.assertEquals("Page title does not match", expectedTitle, driver.getTitle());
	}

	public void clickBatchMenuOpt() {
		driver.findElement(btnBatch).click();
	}

	public String getManageBatchHeading() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(manageBatchHeadingLocator)).getText();
	}

	public void verifyDeleteIconIsDisabled() {
		WebElement deleteIcon = driver.findElement(deleteIconLocator);
		Assert.assertTrue("Delete icon should be visible", deleteIcon.isDisplayed());
		boolean isClickable;
		try {
			deleteIcon.click();
			isClickable = true;
		} catch (Exception e) {
			isClickable = false;
		}
		Assert.assertFalse("Delete icon should be disabled (not clickable)", isClickable);
	}

	public void verifyPaginationControlsAreEnabled() {
		WebElement paginationControls = driver.findElement(paginationControlsLocator);
		Assert.assertTrue("Pagination controls should be visible", paginationControls.isDisplayed());

		WebElement nextButton = paginationControls
				.findElement(By.xpath("//*[contains(@class, 'p-paginator-icon pi pi-angle-right')]"));
		WebElement previousButton = paginationControls
				.findElement(By.xpath("//*[contains(@class, 'p-paginator-icon pi pi-angle-left')]"));

		Assert.assertTrue("Next button should be enabled", nextButton.isEnabled());
		Assert.assertTrue("Previous button should be enabled", previousButton.isEnabled());
	}

	public void verifyEditIconsInEachRow() {
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : rows) {
			WebElement editIcon = row.findElement(editIconLocator);
			Assert.assertTrue("Edit icon should be visible in row: " + rows.indexOf(row), editIcon.isDisplayed());
		}
	}

	public void verifyDeleteIconsInEachRow() {
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : rows) {
			WebElement deleteIcon = row.findElement(deleteIconLocator);
			Assert.assertTrue("Delete icon should be visible in row: " + rows.indexOf(row), deleteIcon.isDisplayed());
		}
	}

	public void verifyCheckboxesInEachRow() {
		List<WebElement> rows = driver.findElements(By.xpath("//table/tbody/tr"));
		for (WebElement row : rows) {
			WebElement checkbox = row.findElement(checkboxLocator);
			Assert.assertTrue("Checkbox should be visible in row: " + rows.indexOf(row), checkbox.isDisplayed());
		}
		System.out.println("Checked checkbox visibility in " + rows.size() + " rows.");
	}

	public void verifyDataTableHeaders(List<String> expectedHeaders) {
		WebElement tableHeader = driver.findElement(tableHeaderLocator);
		List<WebElement> headerCells = tableHeader.findElements(By.xpath(".//th"));
		List<String> actualHeaders = new ArrayList<>();

		for (WebElement cell : headerCells) {
			String headerText = cell.getText().trim();
			if (!headerText.isEmpty()) {
				actualHeaders.add(headerText);
			}
		}
		Assert.assertEquals("The datatable headers do not match.", expectedHeaders, actualHeaders);
	}

	public void verifyHeaderCheckboxIsDisplayed() {
		WebElement checkboxHeader = driver.findElement(headerCheckboxLocator);
		Assert.assertTrue("Checkbox in the header row should be displayed", checkboxHeader.isDisplayed());
	}

	public void verifySortIconsInAllHeaders() {
		List<WebElement> headerCells = driver.findElements(By.xpath("//th"));
		Assert.assertFalse("No header cells found in the datatable.", headerCells.isEmpty());

		for (WebElement headerCell : headerCells) {
			String headerText = headerCell.getText().trim();
			if ("Edit / Delete".equalsIgnoreCase(headerText)) {
				continue; // Skip this iteration
			}
			if (!headerText.isEmpty()) {
				List<WebElement> sortIcons = headerCell.findElements(sortIconLocator);
				Assert.assertTrue("Sort icon should be present in the header: " + headerText, sortIcons.size() > 0);
			} else {
				System.out.println("Skipping empty header cell.");
			}
		}
	}

	public void clickOnNavigationBar(String menuItem) {
		By btn_batch = By.xpath("//span[text() = '" + menuItem + "']");
		driver.findElement(btn_batch).click();
	}

	public void verifySubMenuIsDisplayed(String submenuItem) {
		By submenuLocator = By.xpath("//*[contains(text(),'" + submenuItem + "')]");
		WebElement submenuElement = driver.findElement(submenuLocator);
		Assert.assertTrue("Submenu item '" + submenuItem + "' should be displayed", submenuElement.isDisplayed());
	}

	public void clickOnSubMenu(String submenuItem, String menuItem) {
		clickOnNavigationBar(menuItem);
		By submenuLocator = By.xpath("//*[contains(text(),'" + submenuItem + "')]");
		WebElement submenuElement = driver.findElement(submenuLocator);
		submenuElement.click(); // Click on the submenu item
	}

	// Method to check if the pop-up is visible
	public void verifyPopUpIsVisible() {
		WebElement popUpElement = wait.until(ExpectedConditions.visibilityOfElementLocated(popUpLocator));
		Assert.assertTrue("Batch Details pop-up should be visible", popUpElement.isDisplayed());
	}

	// Method to check if fields are enabled
	public void verifyAllFieldsAreEnabled() {
		Assert.assertTrue("Program Name dropdown should be enabled",
				driver.findElement(programNameLocator).isEnabled());
		Assert.assertTrue("Batch Program field should be enabled", driver.findElement(batchProgramLocator).isEnabled());
		Assert.assertTrue("Batch Name field should be enabled",
				driver.findElement(batchProgramNameLocator).isEnabled());
		Assert.assertTrue("Description field should be enabled", driver.findElement(descriptionLocator).isEnabled());
		Assert.assertTrue("Status radio button should be enabled", driver.findElement(statusRadioLocator).isEnabled());
		Assert.assertTrue("Number of Classes field should be enabled",
				driver.findElement(numberOfClassesLocator).isEnabled());
	}

	// Method to validate field types
	public void validateFieldTypes() {
		Assert.assertEquals("Program Name should be a dropdown", "select",
				driver.findElement(programNameLocator).getTagName());
		Assert.assertEquals("Batch Name should be a text box", "text",
				driver.findElement(batchProgramNameLocator).getAttribute("type"));
		Assert.assertEquals("Number of Classes should be a number box", "number",
				driver.findElement(numberOfClassesLocator).getAttribute("type"));
		Assert.assertEquals("Description should be a text box", "text",
				driver.findElement(descriptionLocator).getAttribute("type"));
	}

	public void clickBatchMenu() {
		driver.findElement(batchMenu).click();
	}

	public void clickAddNewBatchSubmenu() {
		driver.findElement(addNewBatchSubmenu).click();
	}

	public void verifyBatchDetailsPopUp() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(batchDetailsPopUp));
		Assert.assertTrue("Batch Details pop-up is not displayed", driver.findElement(batchDetailsPopUp).isDisplayed());
	}

	public void validateBatchDetailsFields() {
		try {
			WebElement programNameDropdown = driver.findElement(programNameLocator);
			WebElement batchNameField1 = driver.findElement(batchProgramLocator);
			WebElement batchNameField2 = driver.findElement(batchProgramNameLocator);
			WebElement descriptionField = driver.findElement(descriptionLocator);
			WebElement statusRadioButton = driver.findElement(statusRadioLocator);
			WebElement numberOfClassesField = driver.findElement(numberOfClassesLocator);

			Assert.assertEquals("Batch Name should be a text box", "text", batchNameField1.getAttribute("type"));
			Assert.assertEquals("Batch Name should be a text box", "text", batchNameField2.getAttribute("type"));
			Assert.assertEquals("Number of Classes should be a number box", "number",
					numberOfClassesField.getAttribute("type"));
			Assert.assertEquals("Description should be a text box", "text", descriptionField.getAttribute("type"));

			// Check if Program Name is a dropdown
			String role = programNameDropdown.getAttribute("role");
			if (role != null) {
				Assert.assertEquals("Program Name should be a dropdown", "combobox", role);
			}

			// Check if Status is a radio button
			String statusType = statusRadioButton.getAttribute("type");
			if (statusType != null) {
				Assert.assertEquals("Status should be a radio button", "radio", statusType);
			}

		} catch (Exception e) {
			Assert.fail("Exception occurred while validating the fields: " + e.getMessage());
		}
	}

	private String selectedProgramName;

	// Method to select a program name in the dropdown
	public void selectProgramName() {
		WebElement dropdown = driver.findElement(programNameLocator);
		dropdown.click();

		WebElement dropdownButton = driver.findElement(dropdownButtonLocator);
		dropdownButton.click();

		WebElement optionToSelect = driver.findElement(dropdownOptionLocator);
		selectedProgramName = optionToSelect.getText(); // Store selected option text
		optionToSelect.click();
	}

	// Method to validate that the program name matches the batch name prefix
	public void validateBatchNamePrefixMatchesProgramName() {
		WebElement batchNamePrefixElement = driver.findElement(batchProgramLocator);
		String batchNamePrefixValue = batchNamePrefixElement.getAttribute("ng-reflect-model");

		// Fallback to visible text if the attribute is not set
		if (batchNamePrefixValue == null || batchNamePrefixValue.isEmpty()) {
			batchNamePrefixValue = batchNamePrefixElement.getText();
		}

		// Compare stored program name with the batch name prefix
		Assert.assertEquals("Batch name prefix should match the selected program name", selectedProgramName,
				batchNamePrefixValue);
	}

	// Method to enter alphabets in batch name suffix box
	public void enterBatchNameSuffix(String suffix) {
		WebElement batchNameSuffixElement = driver.findElement(batchProgramNameLocator);
		batchNameSuffixElement.clear();
		batchNameSuffixElement.sendKeys(suffix);
	}

	// Method to validate the error message below the batch name suffix box
	public void validateErrorMessage(String expectedErrorMessage) {
		WebElement errorMessageElement = driver.findElement(errorMessageLocator);
		String actualErrorMessage = errorMessageElement.getText();
		Assert.assertEquals("Error message should be displayed for invalid input", expectedErrorMessage,
				actualErrorMessage);
	}

	// Method to enter alphabets in Batch Name prefix box and validate if it's empty
	public void enterAlphabetsInBatchNamePrefix() {
		WebElement batchProgramElement = driver.findElement(batchProgramLocator);
		if (isFieldEditable(batchProgramElement)) {
			batchProgramElement.sendKeys("abc");
			String value = batchProgramElement.getAttribute("value");
			Assert.assertTrue("Batch Name prefix box should be empty after entering alphabets", value.isEmpty());
		}
	}

	public boolean isBatchNamePrefixBoxEmpty() {
		WebElement batchProgramElement = driver.findElement(batchProgramLocator);
		return batchProgramElement.getAttribute("value").isEmpty();
	}

	// Method to enter data in mandatory fields and click save
	public void enterDataInMandatoryFieldsAndSave() {
		selectProgramName();
		enterBatchName();
		enterDescription();
		selectActiveRadioButton();
		enterNumberOfClasses();
		driver.findElement(saveButtonLocator).click();
	}

	private void enterBatchName() {
		WebElement batchNameField = driver.findElement(batchProgramNameLocator);
		if (isFieldMandatory(batchNameField)) {
			batchNameField.sendKeys("112" + generateUniqueNumericSuffix());
		}
	}

	private void enterDescription() {
		WebElement descriptionField = driver.findElement(descriptionLocator);
		if (isFieldMandatory(descriptionField)) {
			descriptionField.sendKeys("New batch");
		}
	}

	private void selectActiveRadioButton() {
		WebElement radio = driver.findElement(activeRadioButtonLocator);
		wait.until(ExpectedConditions.visibilityOf(radio));
		if (radio.isDisplayed() && radio.isEnabled()) {
			radio.click();
		}
	}

	private void enterNumberOfClasses() {
		WebElement numberOfClassesField = driver.findElement(numberOfClassesLocator);
		if (isFieldMandatory(numberOfClassesField)) {
			numberOfClassesField.sendKeys("5");
		}
	}

	// Method to generate a unique numeric suffix
	private String generateUniqueNumericSuffix() {
		return String.valueOf(System.currentTimeMillis());
	}

	// method to check if a field is editable
	private boolean isFieldEditable(WebElement field) {
		return field.getAttribute("readonly") == null && field.getAttribute("disabled") == null;
	}

	// method to check if a field is mandatory
	private boolean isFieldMandatory(WebElement field) {
		return field.getAttribute("required") != null;
	}

	// Method to verify the successful save message
	public boolean isSaveSuccessful() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessageLocator));
		String actualMessage = driver.findElement(toastMessageLocator).getText();
		return "Successful".equals(actualMessage);
	}

	public void enterBatchName(String batchName) {
		driver.findElement(batchProgramNameLocator).sendKeys(batchName);
	}

	public void enterDescription(String description) {
		driver.findElement(descriptionLocator).sendKeys(description);
	}

	public void enterNumberOfClasses(String number) {
		driver.findElement(numberOfClassesLocator).sendKeys(number);
	}

	public void clickSave() {
		driver.findElement(saveButtonLocator).click();
	}

	public void clickCancel() {
		driver.findElement(cancelButtonLocator).click();
	}

	public void clickCloseIcon() {
		wait.until(ExpectedConditions.elementToBeClickable(closeIconLocator)).click();
	}

	public boolean isPopUpClosed() {
		return wait.until(ExpectedConditions.invisibilityOfElementLocated(popUpLocator));
	}

	public WebElement getErrorMessage() {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
	}

	// Method to select radio button
	public void selectRadio() {
		By activeRadioButtonLocator = By.xpath("//*[@id='batchStatus']/div/div[2]");
		WebDriverWait wait = new WebDriverWait(AppHooks.getInstance().getDriver(), Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeRadioButtonLocator));

		WebElement radio = AppHooks.getInstance().getDriver().findElement(activeRadioButtonLocator);
		if (radio.isDisplayed() && radio.isEnabled()) {
			radio.click(); // Click the ACTIVE radio button
		}
	}

	public boolean isFieldMandatory(By locator) {
		WebElement field = AppHooks.getInstance().getDriver().findElement(locator);
		return field.getAttribute("required") != null;
	}

	// Method to fill the batch name field
	public void enterBatchNameIfMandatory() {
		WebElement batchNameField = driver.findElement(batchProgramNameLocator);
		if (isFieldMandatory(batchNameField)) {
			String uniqueSuffix = generateUniqueNumericSuffix();
			batchNameField.sendKeys("112" + uniqueSuffix);
		}
	}

	// Method to fill the description field
	public void enterDescriptionIfMandatory() {
		WebElement descriptionField = driver.findElement(descriptionLocator);
		if (isFieldMandatory(descriptionField)) {
			descriptionField.sendKeys("New batch");
		}
	}

	// Method to select the active radio button
	public void selectActiveRadio() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(activeRadioButtonLocator));
		WebElement radio = driver.findElement(activeRadioButtonLocator);
		if (radio.isDisplayed() && radio.isEnabled()) {
			radio.click(); // Click the ACTIVE radio button
		}
	}

	// Method to fill the number of classes field
	public void enterNumberOfClassesIfMandatory() {
		WebElement numberOfClassesField = driver.findElement(numberOfClassesLocator);
		if (isFieldMandatory(numberOfClassesField)) {
			numberOfClassesField.sendKeys("5"); // Example number of classes
		}
	}

	private String expectedErrorMessage;

	// Method to track which field was left blank
	public void trackBlankField(boolean batchNameMandatory, boolean descriptionMandatory,
			boolean numberOfClassesMandatory) {
		if (batchNameMandatory && !isFieldFilled(batchProgramNameLocator)) {
			expectedErrorMessage = "Program Name is required.";
		} else if (descriptionMandatory && !isFieldFilled(descriptionLocator)) {
			expectedErrorMessage = "Description is required."; // Adjust message as necessary
		} else if (numberOfClassesMandatory && !isFieldFilled(numberOfClassesLocator)) {
			expectedErrorMessage = "Number of classes is required."; // Adjust message as necessary
		}
	}

	// Check if a field is filled
	private boolean isFieldFilled(By locator) {
		WebElement field = driver.findElement(locator);
		return !field.getAttribute("value").isEmpty();
	}

	// Method to get the expected error message
	public String getExpectedErrorMessage() {
		return expectedErrorMessage;
	}

	// Getters for locators
	public By getBatchProgramNameLocator() {
		return batchProgramNameLocator;
	}

	public By getDescriptionLocator() {
		return descriptionLocator;
	}

	public By getNumberOfClassesLocator() {
		return numberOfClassesLocator;
	}

	// Reset expected error message
	public void resetExpectedErrorMessage() {
		expectedErrorMessage = null; // Reset to null before starting
	}

}
