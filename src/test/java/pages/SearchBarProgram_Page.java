package pages;
import org.openqa.selenium.By;

import app_hooks.AppHooks;
import pages.SearchBarProgram_Page;
import utilities.LoggerLoad;
public class SearchBarProgram_Page {
		private static SearchBarProgram_Page searchPageObjects;
		private SearchBarProgram_Page() {};
		public static SearchBarProgram_Page getInstance() {
			if(searchPageObjects==null) {
				searchPageObjects= new SearchBarProgram_Page();
			}
			return searchPageObjects;

		}
	By searchBtn=By.xpath("//input[@id='filterGlobal']");
	By programName=By.xpath("//th[normalize-space()='Program Name']");
	By programDescription=By.xpath("//th[normalize-space()='Program Description']");

	public void searchOnProgramName() {
		AppHooks.getInstance().getDriver().findElement(searchBtn).click();
		AppHooks.getInstance().getDriver().findElement(searchBtn).sendKeys("Selenium");
	}
	public void searchOnProgramDescription() {
		AppHooks.getInstance().getDriver().findElement(searchBtn).click();
		AppHooks.getInstance().getDriver().findElement(searchBtn).sendKeys("Java");
	}
	public void searchNoProgram() {
		AppHooks.getInstance().getDriver().findElement(searchBtn).click();
		AppHooks.getInstance().getDriver().findElement(searchBtn).sendKeys("123");
	}
	public void searchOnPartialProgram() {
		AppHooks.getInstance().getDriver().findElement(searchBtn).click();
		AppHooks.getInstance().getDriver().findElement(searchBtn).sendKeys("Se");
		
	}
	}


