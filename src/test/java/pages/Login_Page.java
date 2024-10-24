package pages;

import org.openqa.selenium.By;


import app_hooks.AppHooks;
import constants.Constants;
import pages.Login_Page;
import utilities.LoggerLoad;


public class Login_Page {

	
	
	private static Login_Page loginPageObjects;

	private Login_Page() {};

	public static Login_Page getInstance() {

		if(loginPageObjects==null) {
			loginPageObjects= new Login_Page();
		}
		return loginPageObjects;

	}

	By usernameTxt = By.xpath("//input[@id = 'username']");
	By passwordTxt = By.xpath("//input[@id = 'password']");
	By loginBtn = By.xpath("//button[@id = 'login']");
	
	public void enterusername() {
		AppHooks.getInstance().getDriver().findElement(usernameTxt).sendKeys(Constants.USER);
	}
		public void enterpassword() {
			AppHooks.getInstance().getDriver().findElement(passwordTxt).sendKeys(Constants.PASSWORD);
		
	}
		public void clickLoginBtn() {
			AppHooks.getInstance().getDriver().findElement(loginBtn).click();
		
		
	}
		public void checkTitleOfPage(String title)
		{
			String actTitle = AppHooks.getInstance().getDriver().getTitle();
			LoggerLoad.info(actTitle);
			if(title.contains( actTitle))
				LoggerLoad.info("Title is "+actTitle+" as expected");
			else
				LoggerLoad.error("Title is "+actTitle+" - Not as expected");
			
		}
	
			}


