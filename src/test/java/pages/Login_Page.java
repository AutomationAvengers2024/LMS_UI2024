package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

import app_hooks.AppHooks;
import constants.Constants;
import pages.Login_Page;
import utilities.LoggerLoad;


public class Login_Page {

	
	
	private static Login_Page loginPageObjects;
	

	
	private WebDriver driver;
	
	private Login_Page() {
        this.driver = AppHooks.getInstance().getDriver();
    }
	
	 

	public static Login_Page getInstance() {

		if(loginPageObjects==null) {
			loginPageObjects= new Login_Page();
		}
		return loginPageObjects;

	}
	String successPage = "";
	String errorMessage="";
	String successMessage="";
	
	
    int respCode = 200;
    String actualNameText = "User";
	String actualPasswordText = "Password";

	By usernameTxt = By.xpath("//input[@id = 'username']");
	By passwordTxt = By.xpath("//input[@id = 'password']");
	By loginBtn = By.xpath("//button[@id = 'login']");
	By userNameLabel = By.xpath("//span[@class='ng-tns-c78-0 ng-star-inserted']");
	By passwordLabel = By.xpath("//span[@class='ng-tns-c78-1 ng-star-inserted']");
	By logo = By.xpath("//*[@src='assets/img/LMS-logo.jpg']");
	By signInContect = By.xpath("//p[text()='Please login to LMS application']");
	By requiredserastrik  =By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-0 ng-star-inserted']");
	By requiredPasswordastrik  =By.xpath("//span[@class='mat-placeholder-required mat-form-field-required-marker ng-tns-c78-1 ng-star-inserted']");
	By login=By.xpath("//span[text()='Login']");
    By inputField = By.xpath("//*[@class='mat-card mat-focus-indicator']");
    By loginErrorMessage = By.xpath("//*[@id='errormessage'])");
   
	
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
		
		public boolean verifyButtonAlignment()
		{
			
			String script = "arguments[0].style.textAlign='center';";
		       boolean loginButtonAlignment = (boolean) ((JavascriptExecutor)driver).executeScript(script, loginBtn);
		       return loginButtonAlignment;
		
		}
    public boolean isInputFieldCentered() {
	        
	        int windowWidth = AppHooks.getInstance().getDriver().manage().window().getSize().getWidth();
	        int fieldXPosition = AppHooks.getInstance().getDriver().findElement(inputField).getLocation().getX();
	        int fieldWidth = AppHooks.getInstance().getDriver().findElement(inputField).getSize().getWidth();
	        
	        return (fieldXPosition + fieldWidth / 2) == (windowWidth / 2);
	    }
		
		
	
		
		public String getPageTitle() {
			System.out.println(AppHooks.getInstance().getDriver().getTitle());
			return AppHooks.getInstance().getDriver().getTitle();
		}
		
		
		
		public String getUserFontColor() {
			return AppHooks.getInstance().getDriver().findElement(userNameLabel).getCssValue("color");
		}
		
		public String getPasswordFontColor() {
			return AppHooks.getInstance().getDriver().findElement(passwordLabel).getCssValue("color");
		}
		
		
		 public void pressEnterKey() {
		        Actions actions = new Actions(AppHooks.getInstance().getDriver());
		        actions.sendKeys(Keys.RETURN).perform(); 
		    }
		 public void clickLoginButton() {
		        Actions actions = new Actions(AppHooks.getInstance().getDriver());
		        actions.moveToElement((AppHooks.getInstance().getDriver()).findElement(loginBtn)).click().perform();
		    }
		 
		
		 
		 public HashMap<String,String> VerifyFieldText()
			{
			 WebDriver driver = AppHooks.getInstance().getDriver();

				HashMap<String,String> textMap = new HashMap<String,String>();
				WebElement userNameLabel = driver.findElement(By.xpath("//span[@class='ng-tns-c78-0 ng-star-inserted']"));
			    WebElement passwordLabel = driver.findElement(By.xpath("//span[@class='ng-tns-c78-1 ng-star-inserted']"));

				String ExpectedUserText = userNameLabel.getText();
				String ExpectedPasswordText = passwordLabel.getText();
				textMap.put("ExpUserText", ExpectedUserText);
				textMap.put("ExppasswordText", ExpectedPasswordText);
				return textMap;
				
			}
		 
		 public void validateUserandPassword(String userName, String password) {
			    WebDriver driver = AppHooks.getInstance().getDriver();

			    
			    WebElement usernameTxt = driver.findElement(By.xpath("//input[@id = 'username']")); 
			    usernameTxt.sendKeys(userName);

			    
			    WebElement passwordTxt = driver.findElement(By.xpath("//input[@id = 'password']"));
			    passwordTxt.sendKeys(password);

			    
			    WebElement loginBtn = driver.findElement(By.xpath("//button[@id = 'login']")); 
			    loginBtn.click();
			}

		 public String getErrorMessage() {
			    
			    WebElement alertMsg = AppHooks.getInstance().getDriver().findElement(By.xpath("//*[@id='errormessage']"));
			    return alertMsg.getText();
			}
		 public boolean verifyLogoIsDisplayed() {
			    WebDriver driver = AppHooks.getInstance().getDriver();
			    
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    
			    WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@src='assets/img/LMS-logo.jpg']"))); 
				return true;
	    
			    
			}
		 public String verifyUserPlaceHolder() {
			    		    
			    WebElement userNameLabel =AppHooks.getInstance().getDriver().findElement(By.xpath("//span[@class='ng-tns-c78-0 ng-star-inserted']"));
			    
			    return userNameLabel.getAttribute("placeholder"); 
			}
		 public String  verifyPasswordPlaceHolder()
			{
			 WebElement passwordLabel = driver.findElement(By.xpath("//span[@class='ng-tns-c78-1 ng-star-inserted']"));
				
				return passwordLabel.getAttribute("placeholder"); 
			}
}

		
	    
	    

