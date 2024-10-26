package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import app_hooks.AppHooks;

public class Logout_Page {
	

	private static Logout_Page logoutPageObjects;

	
	private WebDriver driver;
	
	private Logout_Page() {
        this.driver = AppHooks.getInstance().getDriver();
    }
	 

	public static Logout_Page getInstance() {

	if(logoutPageObjects==null) {
		logoutPageObjects= new Logout_Page();
	}
	return logoutPageObjects;

	}
	
	By logoutBtn = By.xpath("//span[text()='Logout']");
	
	public void clickLogoutBtn() {
		AppHooks.getInstance().getDriver().findElement(logoutBtn).click();
	}
	
	public String getPageTitle() {
		
		return driver.getTitle();
	}
	
	
	

}
