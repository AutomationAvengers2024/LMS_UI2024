package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import app_hooks.AppHooks;
import constants.Constants;
import utilities.LoggerLoad;

public class Program_Edit_Page {
	
	private WebDriver driver;
	private WebDriverWait wait;
	private WebElement element;
	Common commonFunctions = new Common(); //Added by Ishu

	private static Program_Edit_Page EditprogramPageObjects;

	private Program_Edit_Page() {};

	public static Program_Edit_Page getInstance() {

		if(EditprogramPageObjects==null) {
			EditprogramPageObjects= new Program_Edit_Page ();
		}
		return EditprogramPageObjects;

	}

	//By editbutton = By.xpath("//button[@id='editProgram']");
	//By editbutton = By.xpath("//button[@icon ='pi pi-pencil']");
	By editbutton = By.xpath("//div[@class='cdk-overlay-backdrop cdk-overlay-transparent-backdrop cdk-overlay-backdrop-showing']");
	//By editprogramDetail = By.xpath("//span[text() = 'Program Details']");
	//By editprogramDetail = By.xpath("//span[@id='pr_id_16-label']");
	By editprogramDetail = By.xpath("//tbody/tr[2]/td[5]/div[1]/span[1]/button[1]");
	By savebtn = By.xpath("//span[text()='Save']");
	By programname = By.xpath("//input[@id = 'programName']");
	By sucessmsg = By.xpath("//div[text() = 'Program Created Successfully']");
	By destext = By.xpath("//input[@id='programDescription']");
	By inactive = By.xpath("//div[@class = 'p-radiobutton-box']");
	By cancelbutton = By.xpath("//button[@icon = 'pi pi-times']");
	By programtextbox = By.xpath("//input[@id = 'programName']");
	By desfieldbox = By.xpath("//input[@id='programDescription']");
	By errormsg = By.xpath("//small[@class = 'p-invalid ng-star-inserted']");




	public void editbutton() throws InterruptedException {
         Thread.sleep(2000);
		AppHooks.getInstance().getDriver().findElement(editbutton).click();
        // commonFunctions.CheckTable_EditBtn(editbutton);
	}
	
	//General Function to Click Button
			public void ClickBtn(String Xpath) {
				AppHooks aphk = new AppHooks();
				aphk.getDriver().manage().window().maximize();
				aphk.getDriver().manage().window().fullscreen();
							
					
				try {
					Thread.sleep(4000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				By ClickBtn=By.xpath(Xpath);
				
				this.driver = AppHooks.getInstance().getDriver();
				this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				
				WebElement element = driver.findElement(ClickBtn);
	            Actions action = new Actions(driver);
	            action.doubleClick(element).build().perform();		
				
			}
			

	public boolean checkeditdetailPopup() throws InterruptedException {

		boolean programDetailpopupvisible;

		programDetailpopupvisible = AppHooks.getInstance().getDriver().findElement(editprogramDetail).isDisplayed();
        Thread.sleep(2000);
		if(programDetailpopupvisible)
			programDetailpopupvisible = true;

		else
			programDetailpopupvisible = false;
		return programDetailpopupvisible ;


	}

	public void Edit() {

		AppHooks.getInstance().getDriver().findElement(programname).sendKeys("numpy");
		AppHooks.getInstance().getDriver().findElement(savebtn).click();
	}


	public boolean sucessmsg() {

		boolean sucessvisible;

		sucessvisible = AppHooks.getInstance().getDriver().findElement(sucessmsg).isDisplayed();

		if(sucessvisible)
			sucessvisible = true;

		else
			sucessvisible = false;
		return sucessvisible ;
	}


	public void descEdit() {

		AppHooks.getInstance().getDriver().findElement(destext).sendKeys("150");
		AppHooks.getInstance().getDriver().findElement(savebtn).click();
	}



	public boolean descsucessmsg () {

		boolean popup = AppHooks.getInstance().getDriver().findElement(sucessmsg).isDisplayed();
		if (popup)
		{
			LoggerLoad.info("ProgramDetail is displayed");
		}

		else
		{
			LoggerLoad.info("ProgramDetail is not displayed");
		}
		return popup;
	}


	public void changestatus() {

		AppHooks.getInstance().getDriver().findElement(inactive).click();

	}

	public void cancelwithoutchange() {

		AppHooks.getInstance().getDriver().findElement(cancelbutton).click();

	}


	public void detailsave() {


		AppHooks.getInstance().getDriver().findElement(savebtn).click();

	}
	
	public void invalidfiels() {

		AppHooks.getInstance().getDriver().findElement(programtextbox).sendKeys("12345");
		AppHooks.getInstance().getDriver().findElement(desfieldbox).sendKeys("=[-=");
		AppHooks.getInstance().getDriver().findElement(savebtn).click();
		AppHooks.getInstance().getDriver().findElement(errormsg).isDisplayed();
		
	}


}


