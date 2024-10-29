package pages;

import org.openqa.selenium.By;



import app_hooks.AppHooks;
import utilities.LoggerLoad;



public class Program_Add_Page {
	
	private static Program_Add_Page AddprogramPageObjects;

	private Program_Add_Page() {};

	public static  Program_Add_Page getInstance() {

		if(AddprogramPageObjects==null) {
			AddprogramPageObjects= new Program_Add_Page ();
		}
		return AddprogramPageObjects;

	}
	
	By newprogramBtn = By.xpath("//button[text()='Add New Program']");;
	By programDetail = By.xpath("//span[text() = 'Program Details']");
	By savebtn = By.xpath("//button[@id ='saveProgram']");
	By error = By.xpath("//small[@class = 'p-invalid ng-star-inserted']");
	By programname = By.xpath("//input[@id = 'programName']");
	By DesAlert = By.xpath("//small[@class = 'p-invalid ng-star-inserted']");
	By destextbox = By.xpath("//input[@id='programDescription']");
	By pronamealert = By.xpath("//small[text() ='Program name is required.']");
	By statusbtn = By.xpath("//p-radiobutton[@id = 'category']");
	By cancelicon =By.xpath("//button[@tabindex='-1']");
	By sucesspopup = By.xpath("//div[text() = 'Program Created Successfully']");
	By cancelbtn = By.xpath("//button[@icon = 'pi pi-times']");
	By programName = By.xpath("//input[@id='programName']");
	By programDes = By.xpath("//input[@id='programDescription']");
	By programradiobtn = By.xpath("//div[@class = 'radio ng-star-inserted']");
	By editbtn = By.xpath("//button[@id ='editProgram']");
	By editprogram = By.xpath("//span[text() ='Program Details']");
	By deletebtn = By.xpath("//button[@id = 'deleteProgram']");
	
	public void clickprogrambtn() {

		AppHooks.getInstance().getDriver().findElement(newprogramBtn).click();
	}


	public boolean checkNewProgramPopup() {

		boolean popup = AppHooks.getInstance().getDriver().findElement(programDetail).isDisplayed();
		if (popup)
		{
			LoggerLoad.info("NewPopup is displayed");
		}

		else
		{
			LoggerLoad.info("NewPopup is not displayed");
		}
		return popup;
	}
	
	public void savedetail() {

		AppHooks.getInstance().getDriver().findElement(savebtn).click();
		
	}



    
	public boolean errorpopup() throws InterruptedException {
        Thread.sleep(10000);
		boolean popup = AppHooks.getInstance().getDriver().findElement(error).isDisplayed();
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
   
	public void protextbox() {
    	
    	AppHooks.getInstance().getDriver().findElement(programname).sendKeys("SDET150");
    	
     }
    
    
    public boolean alertpopup() {
    	boolean errorvisible;
    	
    	errorvisible = AppHooks.getInstance().getDriver().findElement(DesAlert).isDisplayed();
    	
    	if(errorvisible)
    		errorvisible = true;
    		
    		else
    			errorvisible = false;
    	return errorvisible;
    }

     public void destextbox() {
    	
    	AppHooks.getInstance().getDriver().findElement(destextbox).sendKeys("Software Testing");
    	
     }
    

     public void clickactivebtn() {

 		AppHooks.getInstance().getDriver().findElement(statusbtn).click();
 	}

     public void nametbox() {
     	
     	AppHooks.getInstance().getDriver().findElement(programname).sendKeys("1234");
     	AppHooks.getInstance().getDriver().findElement(destextbox).sendKeys("1234");
     	
     	
     }
     public void cancel() {

 		AppHooks.getInstance().getDriver().findElement(cancelicon).click();
 	}
     
     public void fields() {
    	 
    	 AppHooks.getInstance().getDriver().findElement(programname).sendKeys("SDET150");
    	 AppHooks.getInstance().getDriver().findElement(destextbox).sendKeys("Software Testing");
    	 AppHooks.getInstance().getDriver().findElement(statusbtn).click();
    	 AppHooks.getInstance().getDriver().findElement(savebtn).click();
    	 
    	 
     }
     
     
     public boolean sucessPopup() {

 		boolean popup = AppHooks.getInstance().getDriver().findElement(sucesspopup).isDisplayed();
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
     
     

     public void cancelbtn() {

 		AppHooks.getInstance().getDriver().findElement(cancelbtn).click();
 	}
     
     public boolean inputFields() {

 		boolean popup = AppHooks.getInstance().getDriver().findElement(programName).isDisplayed();
 		if (popup)
 		{
 			LoggerLoad.info("NewPopup is displayed");
 		}

 		else
 		{
 			LoggerLoad.info("NewPopup is not displayed");
 		}
 		return popup;
 	}

 	public boolean radioFields() {

 		boolean popup = AppHooks.getInstance().getDriver().findElement(programradiobtn).isDisplayed();
 		if (popup)
 		{
 			LoggerLoad.info("NewPopup is displayed");
 		}

 		else
 		{
 			LoggerLoad.info("NewPopup is not displayed");
 		}
 		return popup;
 	}


 	public void editbutton() {

 		AppHooks.getInstance().getDriver().findElement(editbtn).click();

 	}


 	public boolean usereditdetail() {

 		boolean popup = AppHooks.getInstance().getDriver().findElement(editprogram).isDisplayed();
 		if (popup)
 		{
 			LoggerLoad.info("NewPopup is displayed");
 		}

 		else
 		{
 			LoggerLoad.info("NewPopup is not displayed");
 		}
 		return popup;
 	}



 	public void clickdelete(){


 		AppHooks.getInstance().getDriver().findElement(deletebtn).click();

 	}
 
		
		
	}


