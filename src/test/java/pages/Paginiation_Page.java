package pages;


	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.WebDriverWait;

	import com.google.protobuf.Duration;

	import app_hooks.AppHooks;
	import constants.Constants;
	import pages.Paginiation_Page;
	import utilities.LoggerLoad;
	public class Paginiation_Page {
		private static  Paginiation_Page paginationPageObjects;
		private   Paginiation_Page() {};
		public static  Paginiation_Page getInstance() {
			if(paginationPageObjects==null) {
				paginationPageObjects= new Paginiation_Page();
			}
			return paginationPageObjects;
		}
		
	By pageNextClick=By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	By pageLastClick=By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']");
	By pageFirstClick=By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");
	By pagePreviousClick=By.xpath(" //span[@class='p-paginator-icon pi pi-angle-double-left']");
	
	public void nextPageLink() {
		AppHooks.getInstance().getDriver().findElement(pageNextClick).click();
	}
	public void lastPageLink() {
		AppHooks.getInstance().getDriver().findElement(pageLastClick).click();
	}
	public void firstPageLink() {
		AppHooks.getInstance().getDriver().findElement(pageNextClick).click();
		AppHooks.getInstance().getDriver().findElement(pageFirstClick).click();
	}
	public void previousPageLink() {
		AppHooks.getInstance().getDriver().findElement(pageLastClick).click();
		AppHooks.getInstance().getDriver().findElement(pagePreviousClick).click();
	}
}
	
