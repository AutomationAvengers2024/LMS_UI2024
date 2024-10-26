package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;

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
	By userNameLabel = By.xpath("//span[@class='ng-tns-c78-37 ng-star-inserted']");
	By passwordLabel = By.xpath("//span[@class=ng-tns-c78-38 ng-star-inserted']");
	By logo = By.xpath("//*[@src='assets/img/LMS-logo.jpg']");
	By signInContect = By.xpath("//p[text()='Please login to LMS application']");
	By requiredserastrik  =By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']");
	By requiredPasswordastrik  =By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted']");
	By login=By.xpath("//span[text()='Login']");

	
	public boolean requiredUserAsteriskDisplayed() {
	    return AppHooks.getInstance().getDriver()
	            .findElement(By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']"))
	            .isDisplayed();
	}
	
	public boolean requiredPasswordastrikiskDisplayed() {
		return AppHooks.getInstance().getDriver()
				.findElement(By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted']"))
						.isDisplayed();
	}
	
	public boolean signinContectDisplayed() {
		return AppHooks.getInstance().getDriver().findElement(By.xpath("//p[text()='Please login to LMS application']")).isDisplayed();
		
	}
	public boolean isTextFieldsVisible() {
		return AppHooks.getInstance().getDriver().findElement(usernameTxt).isDisplayed() && AppHooks.getInstance().getDriver().findElement(passwordTxt).isDisplayed();
	}
	public boolean logoisDisplyed() {
		return AppHooks.getInstance().getDriver().findElement(By.xpath("logo")).isDisplayed();
		
	}
	
	public boolean UsernameLabelDisplayed() {
        return AppHooks.getInstance().getDriver().findElement(By.id("usernameLabel")).isDisplayed(); 
    }
	
	public boolean passwordLabelDisplayed() {
        return AppHooks.getInstance().getDriver().findElement(By.id("passwordLabel")).isDisplayed(); 
    }
	public String getUsernameLabel() {
        return AppHooks.getInstance().getDriver().findElement(By.id("usernameLabel")).getText(); 
    }
	
	

    public String getPasswordLabel() {
        return AppHooks.getInstance().getDriver().findElement(By.id("passwordLabel")).getText(); 
    }
	 
	
	public void enterusername() {
		AppHooks.getInstance().getDriver().findElement(usernameTxt).sendKeys(Constants.USER);
	}
		public void enterpassword() {
			AppHooks.getInstance().getDriver().findElement(passwordTxt).sendKeys(Constants.PASSWORD);
		
	}
		public void clickLoginBtn() {
			AppHooks.getInstance().getDriver().findElement(loginBtn).click();
		}
			
			public boolean isLoginButtonDisplayed() {
				return AppHooks.getInstance().getDriver().findElement(login).isDisplayed();
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
		
		public String getPageTitle() {
			System.out.println(AppHooks.getInstance().getDriver().getTitle());
			return AppHooks.getInstance().getDriver().getTitle();
		}
		
		public int getHttpStatusCode(String url) {
	        try {
	        	AppHooks.getInstance().getDriver().get(url);
	            
	            return 200; 
	        } catch (WebDriverException e) {
	            System.out.println("Error retrieving status code: " + e.getMessage());
	            return 404; 
	        }
	    }

		public String getPageNotFound(String url) {
	        int httpStatus = getHttpStatusCode(url);
	        
	        if (httpStatus == 404) {
	            System.out.println("Invalid URL: Status received: " + httpStatus);
	            return "The requested page could not be found."; 
	        } else {
	            System.out.println("Status received: " + httpStatus);
	            return "Page found"; 
	        }
	    }
	    
}
