package pages;
import java.io.IOException;
import java.util.List;

import org.languagetool.JLanguageTool;
import org.languagetool.language.AmericanEnglish;
import org.languagetool.rules.RuleMatch;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import app_hooks.AppHooks;
import constants.Constants;
import pages.Dashboard_Page;
import utilities.LoggerLoad;
import java.lang.*;

public class Dashboard_Page {
	private static Dashboard_Page dashboardPageObjects;
	private Dashboard_Page() {};
	public static Dashboard_Page getInstance() {

		if(dashboardPageObjects==null) {
			dashboardPageObjects= new Dashboard_Page();
		}
		return dashboardPageObjects;

	}

	 By user=By.xpath("//input[@id='username']");
     By pwd=By.xpath("//input[@id='password']");
	 By title=By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	 By navigationMenuBar=By.xpath("//div[@class='ng-star-inserted']");
	 By loginbtn=By.xpath("//button[@id='login']");
	 By validateProgram=By.xpath("//*[@id='program']");
	 By validateBatch=By.xpath("//span[normalize-space()='Batch']");
	 By validateClass=By.xpath("//span[normalize-space()='Class']");
	 By validateLogout=By.xpath("//button[@id='logout']");
	 By brokenLink=By.tagName("link");
	 
	  
	public void login_page() {
	
	}
	public void enterValidCredentials()
{
		AppHooks.getInstance().getDriver().findElement(user).sendKeys(Constants.USER);
		AppHooks.getInstance().getDriver().findElement(pwd).sendKeys(Constants.PASSWORD);	
		
		}
	public void clickLogin() {
		AppHooks.getInstance().getDriver().findElement(loginbtn).click();
	}
	public boolean navigationTime() throws InterruptedException {
	    long start = System.currentTimeMillis();
	    AppHooks.getInstance().getDriver().findElement(loginbtn).click();
		Thread.sleep(2000);
	    long timeToLoad= (System.currentTimeMillis()-start);
	    if (timeToLoad<30) 
	    	return true;      
	    else 
	    	return false;

	}
	public boolean verifyBrokenLink() {
		return false;
		/*String errorcode=AppHooks.getInstance().getDriver().findElement(brokenLink).getText().split(" ")[0].trim();
		int code=Integer.parseInt(errorcode);
		if(code>=400) {
			LoggerLoad.info("Link is broken");
		}
		return true;*/

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
	public boolean isTitleLeftCorner() {
		int titleX =AppHooks.getInstance().getDriver().findElement(title).getLocation().getX();
        int titleY =AppHooks.getInstance().getDriver().findElement(title).getLocation().getY();
        return titleX == 0 && titleY == 0;

	}
	public boolean navigationBarRightTop() {
	boolean checkMenuBar= AppHooks.getInstance().getDriver().findElement(navigationMenuBar).getCssValue("vertical-align")=="top" &&AppHooks.getInstance().getDriver().findElement(navigationMenuBar).getCssValue("horizontal-align")=="right";
			LoggerLoad.info("Navigationbar right top aligned");
		return checkMenuBar;			
	}

	public void correctSpelling() {
		String pageText=AppHooks.getInstance().getDriver().findElement(navigationMenuBar).getText();
		LoggerLoad.info(pageText);
		JLanguageTool languagetool=new JLanguageTool(new AmericanEnglish());
		try
		{
			List<RuleMatch> errors=languagetool.check(pageText);
			if(errors.isEmpty()) {
				LoggerLoad.info("No Spelling mistakes found");
				
			}
			else
			{
		   LoggerLoad.error("Spelling mistakes found");
		   for(RuleMatch error:errors) {
			   LoggerLoad.info("Potential type at line"+error.getLine()+ ",column"+error.getColumn()+":"+error.getMessage());
		       LoggerLoad.info("Context:"+error.getShortMessage());
		       LoggerLoad.info("Suggested Correction:"+error.getSuggestedReplacements());
		   
		   } }
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
			
	}
	public void spellSpaceCheck() {
		AppHooks.getInstance().getDriver().findElement(title).getText();
		String pageText=AppHooks.getInstance().getDriver().findElement(title).getText();
		System.out.println(pageText);
		JLanguageTool languagetool=new JLanguageTool(new AmericanEnglish());
		try
		{
			List<RuleMatch> errors=languagetool.check(pageText);
			if(errors.isEmpty()) {
				LoggerLoad.info("No Spelling  and Space mistakes found");
				
			}
			else
			{
		   LoggerLoad.error("Spelling and Space mistakes found");
		   for(RuleMatch error:errors) {
			   LoggerLoad.info("Potential type at line"+error.getLine()+ ",column"+error.getColumn()+":"+error.getMessage());
		       LoggerLoad.info("Context:"+error.getShortMessage());
		       LoggerLoad.info("Suggested Correction:"+error.getSuggestedReplacements());
		   
		   } }
			
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void   ValidateProgram() {
		 boolean programValidate =AppHooks.getInstance().getDriver().findElement(validateProgram).isDisplayed();
		if(programValidate) {
			LoggerLoad.info("Program is Displayed");
		}
			else {
				LoggerLoad.error("Program is not displayed");
			}
		}
	public void  validBatch() {
		 boolean batchValidate =AppHooks.getInstance().getDriver().findElement(validateBatch).isDisplayed();
		if(batchValidate) {
			LoggerLoad.info("Batch is Displayed");
		}
			else {
				LoggerLoad.error("Batch is not displayed");
			}
		}
	public void  validCLass() {
		 boolean classValidate =AppHooks.getInstance().getDriver().findElement(validateClass).isDisplayed();
		if(classValidate) {
			LoggerLoad.info("Class is Displayed");
		}
			else {
				LoggerLoad.error("Class is not displayed");
			}
		}
	public void  validLogout() {
		 boolean logoutValidate =AppHooks.getInstance().getDriver().findElement(validateLogout).isDisplayed();
		if(logoutValidate) {
			LoggerLoad.info("Logout is Displayed");
		}
			else {
				LoggerLoad.error("Logout is not displayed");
			}
		}
	
	}
	

