package pages;



import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import app_hooks.AppHooks;
import constants.Constants;
import pages.DeleteMultipleProgram_Page;
import utilities.LoggerLoad;

public class DeleteMultipleProgram_Page {
	private static DeleteMultipleProgram_Page multipledPageObjects;
	private DeleteMultipleProgram_Page() {};
	Common commonFunctions = new Common();
	public static DeleteMultipleProgram_Page getInstance() {
		if(multipledPageObjects==null) {
			multipledPageObjects= new DeleteMultipleProgram_Page();
		}
		return multipledPageObjects;

	}
	By programTextBar=By.xpath("//button[@id='program']");
	By addProgramBtn=By.xpath("//button[text()='Add New Program']");
	By selectAllCheckBox=By.xpath("//span[@class='p-checkbox-icon pi pi-check'])[1]");
	By checkBox1=By.xpath(".//div[contains(@class, 'p-checkbox-box p-component')]");
	By popupDelete=By.xpath("//*[contains(text(),'Confirm')]");
	By checkBox2=By.xpath("//div[@role='checkbox'])[3]");
    By deleteBtn=By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
    By confirmPopup=By.xpath("//span[@class='p-confirm-dialog-message ng-tns-c204-40']");
    By dialogAccept=By.xpath("//span[normalize-space()='Yes']");
    By dialogReject=By.xpath("//span[normalize-space()='No']");
    By searchBox=By.xpath("//input[@id='filterGlobal']");
    By confirmXBtn=By.xpath("//span[@class='pi pi-times ng-tns-c204-40']");
    By sizeCheckBox=By.cssSelector("div[role='checkbox']");
    By closeXBtn=By.xpath("//button[@class='ng-tns-c204-7 p-dialog-header-icon p-dialog-header-close p-link ng-star-inserted']");
    public void programBtnClick() throws InterruptedException {
    	Thread.sleep(1000);
    	AppHooks.getInstance().getDriver().findElement(programTextBar).click();
    	LoggerLoad.info("Clicks on Program Button in navigation bar");
    }
    public void DashboardPage() throws InterruptedException
	{
    	Thread.sleep(1000);
		commonFunctions.verifyDashboardPage();
	}
public void clickManyCheckBox() throws InterruptedException {
	Thread.sleep(2000);
	JavascriptExecutor js=(JavascriptExecutor) AppHooks.getInstance().getDriver();
	js.executeScript("document.body.click();");
	AppHooks.getInstance().getDriver().findElement(checkBox1).click();
	System.out.println(AppHooks.getInstance().getDriver().findElement(checkBox1).isSelected());
	Thread.sleep(3000);
	//AppHooks.getInstance().getDriver().findElement(checkBox2).click();
	System.out.println(AppHooks.getInstance().getDriver().findElements(checkBox1).size());
}
public void confirmationPage() {
	AppHooks.getInstance().getDriver().findElement(deleteBtn).click();
	AppHooks.getInstance().getDriver().findElement(confirmPopup).isDisplayed();
}
public void alertPopupYes() {

	AppHooks.getInstance().getDriver().findElement(dialogAccept).click();
}
public void alertPopupNo() {
	
	AppHooks.getInstance().getDriver().findElement(dialogReject).click();
}
public void closeWindow() 
{
	
	AppHooks.getInstance().getDriver().findElement(closeXBtn).click();
}
public void clickDeleteBtn() {
	AppHooks.getInstance().getDriver().findElement(deleteBtn).click();
}
public void alertPopup() {
	
	AppHooks.getInstance().getDriver().findElement(confirmPopup).click();
}
public void searchBoxClick() {
	AppHooks.getInstance().getDriver().findElement(searchBox).click();
	AppHooks.getInstance().getDriver().findElement(searchBox).sendKeys("Deleted Program names");
}
public void popup() {
	AppHooks.getInstance().getDriver().findElement(popupDelete).click();
}
}

