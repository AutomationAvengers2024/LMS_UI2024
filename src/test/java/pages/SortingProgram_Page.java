package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.google.protobuf.Duration;

import app_hooks.AppHooks;
import constants.Constants;
import pages.SortingProgram_Page;
import utilities.LoggerLoad;
public class SortingProgram_Page {
	private static  SortingProgram_Page sortingPageObjects;
	private  SortingProgram_Page() {};
	public static SortingProgram_Page getInstance() {
		if(sortingPageObjects==null) {
			sortingPageObjects= new  SortingProgram_Page();
		}
		return sortingPageObjects;
	}
By programBtn=By.xpath("//button[@id='program']");
By addBtn=By.xpath("//button[normalize-space()='Add New Program']");
By cancelBtn=By.xpath("//button[@class='p-button-rounded p-button-danger p-button p-component ng-star-inserted']");
By programNameAscOrder=By.xpath("//p-sorticon[@field='programName']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
By programNameDescOrder=By.xpath("//i[@class='p-sortable-column-icon pi pi-fw pi-sort-amount-down']");
By programdescriptionAscOrder=By.xpath("//p-sorticon[@field='description']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
By programStatusOrder=By.xpath("//p-sorticon[@field='status']//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
public void programNameArrowClick() {
	
	AppHooks.getInstance().getDriver().findElement(programNameAscOrder).click();
}
public void programDescriptionArrowClick() {
	AppHooks.getInstance().getDriver().findElement(programdescriptionAscOrder).click();
	}
public void programStatusClick() {
	AppHooks.getInstance().getDriver().findElement(programStatusOrder).click();
}
public void programBtn() throws InterruptedException {
	Thread.sleep(1000);
	AppHooks.getInstance().getDriver().findElement(programBtn).click();
}
public void addButtonClick() {
	AppHooks.getInstance().getDriver().findElement(addBtn).click();
}
public void addProgramClickCancel() {
	AppHooks.getInstance().getDriver().findElement(cancelBtn).click();
}
}

