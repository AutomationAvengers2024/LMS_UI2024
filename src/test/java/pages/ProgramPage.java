package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import app_hooks.AppHooks;
import constants.Constants;
import utilities.LoggerLoad;

public class ProgramPage {
	
private static ProgramPage programPageObjects;

	
	private ProgramPage() {};

	Common commonFunctions = new Common(); //Added by Ishu

	public static ProgramPage getInstance() {

		if(programPageObjects==null) {
			programPageObjects= new ProgramPage();
		}
		return programPageObjects;

	}

	By programBtn = By.xpath("//button[@id='program']");
	By deleteBtn = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	By addProgramBtn=By.xpath("//button[text()='Add New Program']");
	By manageProgramHeading = By.xpath("//div[normalize-space()='Manage Program']");
	
	By paginatorMessage = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	By footerMessage = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");

	By newProgramBtn = By.xpath("//button[@id='new']");
	By searchBtn = By.xpath("//input[@id='filterGlobal']");

	By headerTable = By.xpath("//table//thead[@class='p-datatable-thead']//th");
	
	By contentTable = By.xpath("//table//tbody[@class='p-datatable-tbody']//tr");

	By sortIconTable_programName = By.xpath("//p-sorticon[@field='programName']");
	By sortIconTable_description = By.xpath("//p-sorticon[@field='description']");
	By sortIconTable_status = By.xpath("//p-sorticon[@field='status']");

	
	
	public void DashboardPageVerification()
	{
		commonFunctions.verifyDashboardPage();
	}
	
	public void clickProgramLink() {
		AppHooks.getInstance().getDriver().findElement(programBtn).click();
		LoggerLoad.info("Clicked on Program Button on navigation bar....");
	}
	
	public void verifyProgramURL() throws InterruptedException
	{
		Thread.sleep(1000);
		String programURL = AppHooks.getInstance().getDriver().getCurrentUrl();
		//Assert.assertEquals(programURL, "https://lms-frontend-api-hackathon-apr-326235f3973d.herokuapp.com/");
		Thread.sleep(1000);
		Assert.assertEquals(programURL, Constants.PROGRAMPAGEURL);
	    Thread.sleep(1000);
		if(programURL.equals("[https://lms-frontend-hackathon-oct24-173fe394c071.herokuapp.com/program]"))
			LoggerLoad.info("Admin is able to see URL in Manage Program" );
		else
			LoggerLoad.error("Admin is not able to see URL in Manage Program" );
	
	}
	public void ManageProgram_HeadingVerification(String PageHeading)
	{
		commonFunctions.CheckPageHeading(PageHeading);
	
	}
	
	public void paginationMessageVerification()
	{
		commonFunctions.checkPaginationMessage(paginatorMessage);
	}
	
	public void ProgramFooter_MessageVerification() 
	{
		commonFunctions.checkFooterMessage(footerMessage, "programs");
		
	}
	public void Program_CheckDeleteBtn() 
	{
		commonFunctions.CheckButton_DisableStatus(deleteBtn,"Delete Button");
	}
	
	public void Program_CheckAddProgramBtn()
	{
		commonFunctions.CheckButton_IsDisplayed(addProgramBtn,"Add Program Button");
	}
	
	public void Validate_ProgramTableRows()
	{
		commonFunctions.CheckTable_NoOfRows(contentTable, 5);
	}
	
	
	public void Validate_ProgramTable_SortIcon()
	{
		boolean status_sortIconTable_programName = AppHooks.getInstance().getDriver().findElement(sortIconTable_programName).isDisplayed();
		boolean status_sortIconTable_description = AppHooks.getInstance().getDriver().findElement(sortIconTable_description).isDisplayed();
		boolean status_sortIconTable_status = AppHooks.getInstance().getDriver().findElement(sortIconTable_status).isDisplayed();
		if(status_sortIconTable_programName)
			LoggerLoad.info("Sort arrow icon is present in Program Name Header ");
		else
			LoggerLoad.warn("Sort arrow icon is not present in Program Name Header ");
		if(status_sortIconTable_description)
			LoggerLoad.info("Sort arrow icon is present in Program Description Header ");
		else
			LoggerLoad.warn("Sort arrow icon is not present in Program Description Header ");
		if(status_sortIconTable_status)
			LoggerLoad.info("Sort arrow icon is present in Program Status Header ");
		else
			LoggerLoad.warn("Sort arrow icon is not present in Program status Header ");
		Assert.assertTrue(status_sortIconTable_programName);
		Assert.assertTrue(status_sortIconTable_description);
		Assert.assertTrue(status_sortIconTable_status);

	}
public void ValidateCheckbox_ProgramTable()
{
	
	commonFunctions.CheckTable_CheckBox(contentTable);

}
public void ValidateEditDeleteButton_ProgramTable()
{
	commonFunctions.CheckTable_EditBtn(contentTable);
	
	commonFunctions.CheckTable_DeleteBtn(contentTable);

}

public void ValidateSearchBar()
{
	commonFunctions.checkSearchBar_WithSearch(searchBtn);
}
	
	
	
	
	
	
	
	
}
