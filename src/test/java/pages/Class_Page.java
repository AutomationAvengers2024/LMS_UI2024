package pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import app_hooks.AppHooks;
import constants.Constants;
import utilities.LoggerLoad;
import pages.Common;

public class Class_Page 
{
	
	
private static Class_Page Classpageobjects;
private WebDriver driver;
private WebDriverWait wait;
private WebElement element;

Common commonFunctions = new Common(); //Added by Ishu
AppHooks aphk = new AppHooks();


	public Class_Page() {
	

	
	}
		

	public static Class_Page getInstance() {

		if(Classpageobjects==null) {
			Classpageobjects= new Class_Page();
		}
		return Classpageobjects;

	}
	
	//General Function to Click Button
			public void ClickBtn(String Xpath) {
				
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
			
			//General Function to Enter values
			public void EnterValue(String value,String Xpath) {
				By boxvalue=By.xpath(Xpath);
				//Entering the values in the boxes
				AppHooks.getInstance().getDriver().findElement(boxvalue).sendKeys(value);
			}
			
			//General Function to Get Values 
			public String GetValue(String Xpath) {
				By textvalue=By.xpath(Xpath);
				String outputdata=AppHooks.getInstance().getDriver().findElement(textvalue).getText();
				return outputdata;
			}
			 
			//Function to Logged on the Dashboard Page
			public void DashBoardPage() {
				
				AppHooks.getInstance().getDriver().get(Constants.URL);
				Login_Page.getInstance().enterusername();
				Login_Page.getInstance().enterpassword();
				Login_Page.getInstance().clickLoginBtn();
				
				Login_Page.getInstance().checkTitleOfPage("LMS");
				
			}
			
			//Function to click ClassPage Button from Header
			public void ClassPageBtn() {
				
				ClickBtn("/html/body/app-root/app-header/mat-toolbar/div/button[3]");
				
			}
			
			//Function to land on Manage Class Page
			public void ManageClassPage() {
				
				String tempClassPageURL =AppHooks.getInstance().getDriver().getCurrentUrl();
						
				if (tempClassPageURL.equals(Constants.CLASSPAGEURL))
				{
					System.out.println("Admin sucessfully landed on Manage Class Page");
				}
				else
				{
					System.out.println("Current URL does not match with Manage Class Page");
				}
				
			}
			
			//Function to check Manage Class Heading
			public void ManageClass_HeadingVerification(String PageHeading){
				
				commonFunctions.CheckPageHeading(PageHeading);
			
			}
			
			//Function to check Search bar with Search button
			public void ManageClass_Searchbarverification() {
				
				By Search_txtbox = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/i");
				boolean searchBarDisplayed = AppHooks.getInstance().getDriver().findElement(Search_txtbox).isDisplayed();
				if (searchBarDisplayed)
					LoggerLoad.info("Search Bar is displayed - As expected");
				else
					LoggerLoad.error("Search Bar is not displayed - Not As expected");
				
				By Search_Text = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input");
				String searchText =AppHooks.getInstance().getDriver().findElement(Search_Text).getAttribute("placeholder");
				if(searchText.equals("Search..."))
					LoggerLoad.info("Search Text Search... is displayed - As expected");
				else
					LoggerLoad.error("Search Text Search... is not displayed - As expected");
				
			}
			
			//General Function to Find the value by Xpath
			public String FindLocators(String locator_value) {
				
				return String.valueOf(AppHooks.getInstance().getDriver().findElement(By.xpath(locator_value)).isDisplayed());
							
			}
			
			//Function to Verify Data Table Headers
			public void ManageClass_DataTableHeaders() {
				
				String Batch_name = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]");
				String Class_Topic = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]");
				String Class_Description = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]");
				String Status = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[5]");
				String Class_Date = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[6]");
				String Staff_name = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[7]");
				String Edit_Delete = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[8]");

					if (Batch_name == "False") { 
						System.out.println("Batch Name not present");
					}
					else if(Class_Topic == "False") {
						System.out.println("Class Topic not present"); 
					}
					else if(Class_Description == "False") {
						System.out.println("Class Descriptionc not present"); 
					}
					else if(Status == "False") {
						System.out.println("Status not present"); 
					}
					else if(Class_Date == "False") {
						System.out.println("Class Date not present"); 
					}
					else if(Staff_name == "False") {
						System.out.println("Staff name not present"); 
					}
					else if(Edit_Delete == "False") {
						System.out.println("Edit/Delete not present"); 
					}
					else  {
						System.out.println("All expected headers are present"); 
					}
	 
			}
			
			//Function for Pagination text and control
			public void PaginationText_and_Control() {
				
				String pagination_info = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div");
				
				if (pagination_info == "False") {
					System.out.println("No Information is present");
				}
				else  {
					System.out.println("showing x to y of z entries"); 
				}
						
			}
			
			//Function to check Sort icons with Data Table Header
			public void ManageClass_SortIconcheck() {
				
				String Batch_name_SortIcon = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]/p-sorticon");
				String Class_Topic_SortIcon = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]/p-sorticon");
				String Class_Description_SortIcon = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]/p-sorticon");
				String Status_SortIcon = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[5]/p-sorticon");
				String Class_Date_SortIcon = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[6]/p-sorticon");
				String Staff_name_SortIcon = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[7]/p-sorticon");

					if (Batch_name_SortIcon == "False") { 
						System.out.println("Sort_Icon is not present");
					}
					else if(Class_Topic_SortIcon == "False") {
						System.out.println("Sort_Icon is not present"); 
					}
					else if(Class_Description_SortIcon == "False") {
						System.out.println("Sort_Icon is not present"); 
					}
					else if(Status_SortIcon == "False") {
						System.out.println("Sort_Icon is not present"); 
					}
					else if(Class_Date_SortIcon == "False") {
						System.out.println("Sort_Icon is not present"); 
					}
					else if(Staff_name_SortIcon == "False") {
						System.out.println("Sort_Icon is not present"); 
					}
					else  {
						System.out.println("All expected Header_Sort_Icons are present"); 
					}
				
			}
			
			//Function to check Delete Icon under Manage Class Heading
			public void ManageClass_Under_DeleteIcon() {
				
				String Common_DeleteIcon = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[1]");
				
				if (Common_DeleteIcon == "False") {
					System.out.println("Delete Icon under Manage Class Tittle is Absent");
				}
				else {
					System.out.println("Delete Icon under Manage Class Tittle is Present");
				}
				
			}
			
			// Clicking Delete Icon 
			public void Click_Table_Deletebtn() {
												
				
				ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[1]/td[8]/div/span/button[2]");
				
				System.out.println("Delete Button Click");
				
					
					
					By TableElement = By.xpath("//table//tbody[@class='p-datatable-tbody']//tr");
					
									
					String[] TblEle = TableElement.toString().split("By.xpath: ");
					for (int row=1;row<=1;row++)
						
					{
						ClickBtn(TblEle[1]+"["+row+"]//button[@id='deleteProgram']");
						
						System.out.println("Delete Button is present in Row Number:"+row+" - As expected");
						
					}
					
			}
			
			
			
			public void delete_popup_window ()
			{
				
				String Delete_popup = FindLocators("/html/body/app-root/app-session/p-confirmdialog/div/div");
				String Delete_popup_Yes = FindLocators("/html/body/app-root/app-session/p-confirmdialog/div/div/div[3]/button[2]");
				String Delete_popup_No = FindLocators("/html/body/app-root/app-session/p-confirmdialog/div/div/div[3]/button[1]");
				String Delete_popup_X = FindLocators("/html/body/app-root/app-session/p-confirmdialog/div/div/div[1]/div/button");
								
				if (Delete_popup == "False") { 
					System.out.println("Delete popup is not present");
				}
				else if(Delete_popup_Yes == "False") {
					System.out.println("Delete popup Yes button is not present"); 
				}
				else if(Delete_popup_No == "False") {
					System.out.println("Delete popup No button is not present");
				}
				else if(Delete_popup_X == "False") {
					System.out.println("Delete popup X icon is not present");
				}
				
				else  {
					System.out.println("All expected Delete popup Icons are present"); 
				}
				
				
				
				/// Checking Confirm text on popup
				By Delete_Confirm_Text = By.xpath("/html/body/app-root/app-session/p-confirmdialog/div/div/div[1]/span");
				String searchText =AppHooks.getInstance().getDriver().findElement(Delete_Confirm_Text).getAttribute("placeholder");
				if(searchText.equals("Confirm"))
					LoggerLoad.info("Delete Text Confirm is displayed - As expected");
				else
					LoggerLoad.error("Delete Text Confirm is not displayed - As expected");		
				
				
			}
			
			
			
			//Function to check Total number of classes below the Data Table
			public void ManageClass_TotalClassPresentCountMsg() {
				
				String TotalClassCountMsg = FindLocators("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[2]");
				
				if (TotalClassCountMsg == "False") {
					System.out.println("Message is not displayed");
				}
				else {
					System.out.println("In Total there are Z Classes.");
				}
				
			}
			
			//Add New Class
			public void Add_New_Class() {
				
				ClickBtn("/html/body/div/div[2]/div/div/div/button");
				
			}
			
			//Verification of Pop Up Window
			public void AddnewClass_Popup_Window() {
				
				String Class_Pop_Window = FindLocators("/html/body/app-root/app-session/p-dialog/div/div");
				
				if (Class_Pop_Window == "False") {
					System.out.println("Popup Window is Absent");
				}
				else {
					System.out.println("Popup Window is Present");
				}
				
			}
			
			//Verification of Class Details Title on Pop up Window
			public void ClassPopup_title() {
				String Class_Details_Title = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[1]/span");
				if (Class_Details_Title == "False") {
					System.out.println("Popup Window is Absent");
				}
				else {
					System.out.println("Popup Window is Present");
				}
				
			}
			
			//Verification of Close(X) on Pop up Window
			public void ClassPopup_CloseBtn() {
				String Close_X_Btn = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[1]/div/button");
				if (Close_X_Btn == "False") {
					System.out.println("Close(X) Button is not present");
				}
				else {
					System.out.println("Close(X) Button is present");
				}
			}
			
			//Click Close(X) Button
			public void Click_closeBtn() {
				
				ClickBtn("/html/body/app-root/app-session/p-dialog/div/div/div[1]/div/button");
			}
			
			//Verification of SaveBtn Title on Pop up Window
			public void ClassPopup_SaveBtn() {	
				String Save_Btn = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[3]/button[2]");
				if (Save_Btn == "False") {
					System.out.println("Save Button is not present");
				}
				else {
					System.out.println("Save Button is Present");
				}
			}
			
			//Click Save Button
			public void Click_SaveBtn() {
				
				try {
					Thread.sleep(9000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				ClickBtn("/html/body/app-root/app-session/p-dialog/div/div/div[3]/button[2]");
				
			
				try {
					Thread.sleep(9000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				

				
			}
			
			
			//Verification of CancelBtn Title on Pop up Window
			public void ClassPopup_CancelBtn() {
				String Cancel_Btn = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[3]/button[1]");
				if (Cancel_Btn == "False") {
					System.out.println("Cancel Button is not present");
				}
				else {
					System.out.println("Cancel Button is present");
				}
		
			}
			
			//Click Cancel Button
			public void Click_CancelBtn() {
				
				ClickBtn("/html/body/app-root/app-session/p-dialog/div/div/div[3]/button[1]");
			}
				
			//Verification of Different labels and there Inputs
			
			//for batch name
			public void ClassPopup_Batchname() {
				
				String batchnamelabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/label"); 
								
			
				
				if (batchnamelabel == "True")
					System.out.println("Batch Name is displayed - As expected");
				else
					System.out.println("Batch Name is not displayed - Not As expected");
				
				By batchnametext = By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/p-dropdown");
				String batchnametextdisplay =AppHooks.getInstance().getDriver().findElement(batchnametext).getAttribute("placeholder");
				if(batchnametextdisplay.equals("Select a Batch Name"))
					System.out.println("Text Select a batch name is present in the dropdown - As expected");
				else
					System.out.println("Text Select a batch name is not present in the dropdown - As expected");
				
			}
			
			//for class topic
			public void ClassPopup_Classtopic() {
				
				String classtopiclabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[2]/label");
				if (classtopiclabel == "True")
					System.out.println("Class Topic is displayed - As expected");
				else
					System.out.println("Class Topic is not displayed - Not As expected");
				
				By classtopictext = By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[2]/input");
				String classtopictextdisplay = AppHooks.getInstance().getDriver().findElement(classtopictext).getAttribute("value");
				if(classtopictextdisplay.equals("null"))
					System.out.println("Nothing is displayed - As expected");
				else
					System.out.println("Text is displayed - As expected");
				
			}
			
			//for class description
			public void ClassPopup_ClassDescription() {
				
				String classdescriptionlabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[3]/label");
				if (classdescriptionlabel == "True")
					System.out.println("Class Description is displayed - As expected");
				else
					System.out.println("Class Description is not displayed - Not As expected");
				
				By classdescriptiontext = By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[3]/input");
				String classdescriptiontextdisplay = AppHooks.getInstance().getDriver().findElement(classdescriptiontext).getAttribute("value");
				if(classdescriptiontextdisplay.equals("null"))
					System.out.println("Nothing is displayed - As expected");
				else
					System.out.println("Text is displayed - As expected");
				
				
			}
			
			//for select class dates
			public void ClassPopup_Selectclassdates() {
				
				String selectclassdateslabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[4]/label");
				if (selectclassdateslabel == "True")
					System.out.println("CSelect class dates is displayed - As expected");
				else
					System.out.println("Select class dates is not displayed - Not As expected");
				
				By selectclassdatestext = By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[4]/p-calendar/span");
				String selectclassdatestextdisplay = AppHooks.getInstance().getDriver().findElement(selectclassdatestext).getAttribute("value");
				if(selectclassdatestextdisplay == "")
					System.out.println("Nothing is displayed - As expected");
				else
					System.out.println("Text is displayed - As expected");
				
				
				//String selectclassdatescalendar = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[4]/p-calendar/span/button");
				//String selectclassdatesdisplay = AppHooks.getInstance().getDriver().findElement(selectclassdatescalendar).getAttribute("value");
				//if (selectclassdatesdisplay.isEmpty())
					//LoggerLoad.info("No dates to show");
				//else
					//LoggerLoad.error("Dates are present");
			}
			
			//for no. of classes
			public void ClassPopup_NoOfClasses() {
					
					String NoOfclasseslabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[5]/label");
					if (NoOfclasseslabel == "True")
						System.out.println("No Of Classes is displayed - As expected");
					else
						System.out.println("No Of Classes is not displayed - Not As expected");
					
					By NoOfclassestext = By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[5]/input");
					String NoOfclassestextdisplay = AppHooks.getInstance().getDriver().findElement(NoOfclassestext).getAttribute("value");
					if(NoOfclassestextdisplay == "")
						System.out.println("Nothing is displayed - As expected");
					else
						System.out.println("Text is displayed - As expected");
				
			}
			
			//for staff name
			public void ClassPopup_Staffname() {
					
					String staffnamelabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/label");
					if (staffnamelabel == "True")
						System.out.println("Staff name is displayed - As expected");
					else
						System.out.println("Staff name is not displayed - Not As expected");
					
					By staffnametext = By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown");
					String staffnametextdisplay = AppHooks.getInstance().getDriver().findElement(staffnametext).getAttribute("placeholder");
					if(staffnametextdisplay == "")
						System.out.println("Select a Staff Name is displayed - As expected");
					else
						System.out.println("Select a Staff Name is displayed - As expected");
			}
				
		
			
			
			public void enters_mandatory_fields()
			{
				
				this.driver = AppHooks.getInstance().getDriver();
				this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 
								
				WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/p-dropdown"));
				dropdown.click();

				WebElement dropdownButton = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/p-dropdown/div/div[2]"));
				dropdownButton.click();

				WebElement optionToSelect = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]"));
				String batchName = optionToSelect.getText(); // Store selected option text
				optionToSelect.click();
				
							
				//Class Topic INput
				EnterValue("ETT","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[2]/input");
						
								
				
				//No of classes Input
				EnterValue("10/30/2024","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[4]/p-calendar/span/input");
				
				//ClickBtn("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[4]/p-calendar/span/button");
				
				AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[3]/input")).sendKeys("");
				
				
				try {
					Thread.sleep(9000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				//Staff Name
				this.driver = AppHooks.getInstance().getDriver();
				this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 				
				
				WebElement Staff_dropdown = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown"));
				Staff_dropdown.click();

				
				WebElement staff_dropdownButton = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown/div/div[2]"));
				staff_dropdownButton.click();
					
				
				WebElement Staff_optionToSelect = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]"));
				String StaffName = Staff_optionToSelect.getText(); // Store selected option text
				Staff_optionToSelect.click();
				
						
				
				
				//Status Select 
				AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[7]/div[2]/p-radiobutton")).click();
				
				
				try {
					Thread.sleep(9000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
			}
			
			public void Batch_name_mand_error_string()
			{
				
				try {
					Thread.sleep(2000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				System.out.println("Errror popout is shown " + String.valueOf(AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/small"))));
				
				
			}
			
			public void class_topic_mand_error_string()
			{
				
				try {
					Thread.sleep(2000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				System.out.println("Errror popout is shown " + String.valueOf(AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[2]/small"))));
				
				
			}
			
			
			
			
			public void add_class_optional_field()
			{
				
							
							
				//Class Description INput
				EnterValue("abc","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[3]/input");
						
								
				//Comments input
				EnterValue("efg","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[8]/input");
				
				//recording
				EnterValue("hij","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[10]/input");
				
				//notes
				EnterValue("klm","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[9]/input");
				
				
				try {
					Thread.sleep(9000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
			}
			
			//All Valid Fields in Classpopup
			public void All_Feild_ClassDetails()
			{
				this.driver = AppHooks.getInstance().getDriver();
				this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 
								
				WebElement dropdown = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/p-dropdown"));
				dropdown.click();

				WebElement dropdownButton = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/p-dropdown/div/div[2]"));
				dropdownButton.click();

				WebElement optionToSelect = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]"));
				String batchName = optionToSelect.getText(); // Store selected option text
				optionToSelect.click();
				
							
				//Class Topic INput
				EnterValue("ETT","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[2]/input");
						
				//Class Description INput
				EnterValue("abc","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[3]/input");			
				
				//Class Dates Input
				EnterValue("10/30/2024","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[4]/p-calendar/span/input");
				
				//ClickBtn("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[4]/p-calendar/span/button");
				
				AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[3]/input")).sendKeys("");
				
				
				try {
					Thread.sleep(9000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				// no of class
					//Automatically updated
				
				//Staff Name
				this.driver = AppHooks.getInstance().getDriver();
				this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 				
				
				WebElement Staff_dropdown = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown"));
				Staff_dropdown.click();

				
				WebElement staff_dropdownButton = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown/div/div[2]"));
				staff_dropdownButton.click();
					
				
				WebElement Staff_optionToSelect = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[1]"));
				String StaffName = Staff_optionToSelect.getText(); // Store selected option text
				Staff_optionToSelect.click();
		
				
				//Status Select 
				AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[7]/div[2]/p-radiobutton")).click();
				
				
				try {
					Thread.sleep(9000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
								
				//Comments input
				EnterValue("efg","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[8]/input");
				
				//recording
				EnterValue("hij","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[10]/input");
				
				//notes
				EnterValue("klm","/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[9]/input");
				
				
				try {
					Thread.sleep(9000);
					} catch (InterruptedException e) {
				// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
				
				
			}
			
			
			
			public void add_class_success_popup ()
			{
				
				String class_add_popup_message_status = String.valueOf(AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-confirmdialog")).isEnabled()); 
				
				if (class_add_popup_message_status == "true")
				{
					System.out.println("Popup mesage is received successfully" );	
				}
				else
				{
					System.out.println("Popup mesage is not received ");
				}
				
				
			}
			
			
			
			//for status
			public void ClassPopup_Status() {
				
				String Statuslabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[7]/div[1]");
				if (Statuslabel == "True")
					System.out.println("Status is displayed - As expected");
				else
					System.out.println("Status is not displayed - Not As expected");
				
				
				String Active_Btn_Status =   String.valueOf(AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[7]/div[2]/p-radiobutton/div")).isSelected());
				
				String Inactive_Btn_Status =  String.valueOf(AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[7]/div[3]/p-radiobutton/div")).isSelected());
				
								
				if(Active_Btn_Status == "True")				
				{
					System.out.println("Active Radio button is selected");
				}
				else
				{
					System.out.println("Active Radio button is not selected");
				}

				if(Inactive_Btn_Status == "True")				
				{
					System.out.println("Inactive Radio button is selected");
				}
				else
				{
					System.out.println("Inactive Radio button is not selected");
				}
								
				
			}
			
			//for comments
			public void ClassPopup_Comments() {
					
					String commentslabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[8]/label");
					if (commentslabel == "True")
						System.out.println("Comments is displayed - As expected");
					else
						System.out.println("Comments is not displayed - Not As expected");
					
					By commentstext = By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[8]/input");
					String commentstextdisplay = AppHooks.getInstance().getDriver().findElement(commentstext).getAttribute("value");
					if(commentstextdisplay == "")
						System.out.println("Nothing is displayed - As expected");
					else
						System.out.println("Text is displayed - As expected");
			}
				
		
			
			//for notes
			public void ClassPopup_Notes() {

					
					String noteslabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[9]/label");
					if (noteslabel == "True")
						System.out.println("Notes is displayed - As expected");
					else
						System.out.println("Notes is not displayed - Not As expected");
					
					By notestext = By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[9]/input");
					String notestextdisplay = AppHooks.getInstance().getDriver().findElement(notestext).getAttribute("value");
					if(notestextdisplay == "")
						System.out.println("Nothing is displayed - As expected");
					else
						System.out.println("Text is displayed - As expected");
			}
				
	
			
			//for recording
			public void ClassPopup_Recordings() {
					
					String recordinglabel  = FindLocators("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[10]/label");
					if (recordinglabel == "True")
						System.out.println("Recordings is displayed - As expected");
					else
						System.out.println("Recordings is not displayed - Not As expected");
					
					By recordingtext = By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[10]/input");
					String recordingtextdisplay = AppHooks.getInstance().getDriver().findElement(recordingtext).getAttribute("value");
					if(recordingtextdisplay == "")
						System.out.println("Nothing is displayed - As expected");
					else
						System.out.println("Text is displayed - As expected");
			}
			
			
			//Verifying Sort In Class Page Module
			
			
			//For clicking Batch Name sort Icon
			public void Batchname_Sorticon() {
				
				//AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]/p-sorticon")).click();
				
				ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]/p-sorticon");
				
			}
		
			//Verifying Sort by batch Name
			public boolean Batchname_Sort() {
				
				By batchnamesorting = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[2]/p-sorticon/i");
				WebElement[] rows = AppHooks.getInstance().getDriver().findElements(batchnamesorting).toArray(new WebElement[0]);
				 String[] batchNames = new String[rows.length];

				    for (int i = 0; i < rows.length; i++) {
				        batchNames[i] = rows[i].getText(); 
				    }

				    return isSortedBN(batchNames);
				}

				private boolean isSortedBN(String[] array) {
				    String[] sortedArray = array.clone();
				    Arrays.sort(sortedArray);
				    return Arrays.equals(array, sortedArray);
				}
				
				
				//For clicking Class Topic sort Icon
				public void Classtopic_Sorticon() {
					
					ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]/p-sorticon");
					
				}
				
				//Verifying Sort by Class Topic
				public boolean Classtopic_Sort() {
					
					By classtopicsorting = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[3]/p-sorticon");
					WebElement[] rows = AppHooks.getInstance().getDriver().findElements(classtopicsorting).toArray(new WebElement[0]);
					 String[] classTopic = new String[rows.length];

					    for (int i = 0; i < rows.length; i++) {
					    	classTopic[i] = rows[i].getText(); 
					    }

					    return isSortedCT(classTopic);
					}

					private boolean isSortedCT(String[] array) {
					    String[] sortedArray = array.clone();
					    Arrays.sort(sortedArray);
					    return Arrays.equals(array, sortedArray);
					}
					
					
					//For clicking ClassDescription sort Icon
					public void ClassDescription_Sorticon() {
						
						ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]/p-sorticon");
						
					}
					
					//Verifying Sort by ClassDescription
					public boolean ClassDescription_Sort() {
						
						By classDescriptionsorting = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[4]/p-sorticon");
						WebElement[] rows = AppHooks.getInstance().getDriver().findElements(classDescriptionsorting).toArray(new WebElement[0]);
						 String[] classDescription = new String[rows.length];

						    for (int i = 0; i < rows.length; i++) {
						    	classDescription[i] = rows[i].getText(); 
						    }

						    return isSortedCD(classDescription);
						}

						private boolean isSortedCD(String[] array) {
						    String[] sortedArray = array.clone();
						    Arrays.sort(sortedArray);
						    return Arrays.equals(array, sortedArray);
						}
						
						//For clicking Status sort Icon
						public void Status_Sorticon() {
							
							ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[5]/p-sorticon");
							
						}
						
						//Verifying Sort by Status
						public boolean Status_Sort() {
							
							By Statussorting = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[5]/p-sorticon");
							WebElement[] rows = AppHooks.getInstance().getDriver().findElements(Statussorting).toArray(new WebElement[0]);
							 String[] Status = new String[rows.length];

							    for (int i = 0; i < rows.length; i++) {
							    	Status[i] = rows[i].getText(); 
							    }

							    return isSortedStatus(Status);
							}

							private boolean isSortedStatus(String[] array) {
							    String[] sortedArray = array.clone();
							    Arrays.sort(sortedArray);
							    return Arrays.equals(array, sortedArray);
							}
							
							
							//For clicking ClassDate sort Icon
							public void ClassDate_Sorticon() {
								
								ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[6]/p-sorticon");
								
							}
							
							//Verifying Sort by ClassDate
							public boolean ClassDate_Sort() {
								
								By classdatesorting = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[6]/p-sorticon");
								WebElement[] rows = AppHooks.getInstance().getDriver().findElements(classdatesorting).toArray(new WebElement[0]);
								 String[] classDate = new String[rows.length];

								    for (int i = 0; i < rows.length; i++) {
								    	classDate[i] = rows[i].getText(); 
								    }

								    return isSortedCDS(classDate);
								}

								private boolean isSortedCDS(String[] array) {
								    String[] sortedArray = array.clone();
								    Arrays.sort(sortedArray);
								    return Arrays.equals(array, sortedArray);
								}
								
								
								//For clicking Staff Name sort Icon
								public void StaffName_Sorticon() {
									
									ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[7]/p-sorticon");
									
								}
								
								//Verifying Sort by Staff Name
								public boolean StaffName_Sort() {
									
									By staffnamesorting = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/thead/tr/th[7]/p-sorticon");
									WebElement[] rows = AppHooks.getInstance().getDriver().findElements(staffnamesorting).toArray(new WebElement[0]);
									 String[] staffname = new String[rows.length];

									    for (int i = 0; i < rows.length; i++) {
									    	staffname[i] = rows[i].getText(); 
									    }

									    return isSortedSN(staffname);
									}

									private boolean isSortedSN(String[] array) {
									    String[] sortedArray = array.clone();
									    Arrays.sort(sortedArray);
									    return Arrays.equals(array, sortedArray);
									}
									

								
								
							   ///Validation 6
								
									//Search with Batch Name
									public void batch_Name_search()
									{
										
										try {
											Thread.sleep(6000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
										
					
										
										
										try {
											Thread.sleep(6000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
																				
										By Search_txtbox = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input");
										boolean searchBarDisplayed = AppHooks.getInstance().getDriver().findElement(Search_txtbox).isDisplayed();
										if (searchBarDisplayed)
											System.out.println("Search Bar is displayed - As expected");
										else
											System.out.println("Search Bar is not displayed - Not As expected");
										
										AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input")).clear();
										
										AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input")).sendKeys("Micro service -03");
										
										try {
											Thread.sleep(6000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										} 						
										
									}
									
									public void batch_Name_Searchvalidation() {
									
									    int totbatchRowsSearch = 0;
									    totbatchRowsSearch = AppHooks.getInstance().getDriver().findElements(By.xpath("//table//tbody[@class='p-datatable-tbody']//tr")).size();
										System.out.println(totbatchRowsSearch);
										if (totbatchRowsSearch>=1)
										{
											System.out.println("Search worked for batch Name as records displayed is "+totbatchRowsSearch+" - As expected");
										}
										else
										{
											System.out.println("Search not worked for batch Name as records displayed is "+totbatchRowsSearch+" - Not As expected");
										}
										
																												
										
																			
										
									}
									
									
									//Search with Class Topic
									public void Class_Topic_search()
									{
										
										
										By Search_txtbox = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input");
										
										
										boolean searchBarDisplayed = AppHooks.getInstance().getDriver().findElement(Search_txtbox).isDisplayed();
										if (searchBarDisplayed)
											System.out.println("Search Bar is displayed - As expected");
										else
											System.out.println("Search Bar is not displayed - Not As expected");
										
										AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input")).clear();
										
										AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input")).sendKeys("Halloween");
										
																				
										try {
											Thread.sleep(6000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									
									public void Class_Topic_Searchvalidation() {
									
									    int tottopicRowsSearch = 0;
									    tottopicRowsSearch = AppHooks.getInstance().getDriver().findElements(By.xpath("//table//tbody[@class='p-datatable-tbody']//tr")).size();
										System.out.println(tottopicRowsSearch);
										if (tottopicRowsSearch>=1)
										{
											System.out.println("Search worked for Class Topic as records displayed is "+tottopicRowsSearch+" - As expected");
										}
										else
										{
											System.out.println("Search not worked for Class Topic as records displayed is "+tottopicRowsSearch+" - Not As expected");
										}
										
																			
										
									}
									
									
									//Search with Staff Name
								
									public void Staff_Name_search()
									{
										
										By Search_txtbox = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input");
										boolean searchBarDisplayed = AppHooks.getInstance().getDriver().findElement(Search_txtbox).isDisplayed();
										if (searchBarDisplayed)
											System.out.println("Search Bar is displayed - As expected");
										else
											System.out.println("Search Bar is not displayed - Not As expected");
										
										AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input")).clear();
										
										AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input")).sendKeys("Urmila Rao");
										
																			
										
										try {
											Thread.sleep(6000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
									}
									
									public void Staff_Name_Searchvalidation() {
									
									    int totstaffRowsSearch = 0;
									    totstaffRowsSearch = AppHooks.getInstance().getDriver().findElements(By.xpath("//table//tbody[@class='p-datatable-tbody']//tr")).size();
										System.out.println(totstaffRowsSearch);
										if (totstaffRowsSearch>=1)
										{
											System.out.println("Search worked for Staff Name as records displayed is "+totstaffRowsSearch+" - As expected");
										}
										else
										{
											System.out.println("Search not worked for  Staff Name as records displayed is "+totstaffRowsSearch+" - Not As expected");
										}
										
										
									}
									
									
									
									public void clicks_next_page_link_validation() {
										
										try {
											Thread.sleep(6000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
										
										String First_Page_XPath = "/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[1]";
										
										String Last_Page_XPath = "/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[4]";
																				
										String Back_Page_Xpath = "/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[2]";
										
										String Next_Page_Xpath = "/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]";
										
										
										System.out.println("Value for the First Page Button is " +  AppHooks.getInstance().getDriver().findElement(By.xpath(First_Page_XPath)).isEnabled());
										System.out.println("Value for the Last Page Button is " +  AppHooks.getInstance().getDriver().findElement(By.xpath(Last_Page_XPath)).isEnabled());
										System.out.println("Value for the Back Page Button is " +  AppHooks.getInstance().getDriver().findElement(By.xpath(Back_Page_Xpath)).isEnabled());
										System.out.println("Value for the Next Page Button is " +  AppHooks.getInstance().getDriver().findElement(By.xpath(Next_Page_Xpath)).isEnabled());
															
																
									}
									
									
									
															
									
									
									
									
									public void Click_ClassNxtPageBtn() {
										
										aphk.getDriver().manage().window().maximize();
										aphk.getDriver().manage().window().fullscreen();
										
										
										  JavascriptExecutor js = (JavascriptExecutor) aphk.getDriver();
										  
									       //get the height of the webpage and scroll to the end
									       js.executeScript("window.scrollTo(0, 1000)","");
									      
									       WebDriverWait wait = new WebDriverWait(aphk.getDriver(), Duration.ofSeconds(10));
									       wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("cdk-overlay-backdrop")));
									       
									       
									       ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[4]");
									       
										//ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]/span");
									}
									
									public void Click_ClassLastPageBtn() {
										
										ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[4]");
									}
									
									public void Click_ClassbackPageBtn() {
										
										ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[2]");
									}

									public void Click_ClassFirstPageBtn() {
	
										ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[1]");
									}										
									
									
									public int find_page_number_pagenation ()
									{
										
										int page_entry_size=5;
										String PaginationMessage = AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/span[1]")).getText();
												
																				
										String[] splitArr =PaginationMessage.split("to");
										String totEnt = (splitArr[1]);
										
										
									
										String[] splitArr2 = totEnt.split("of");
										String PageEndEntry_txt = (splitArr2[0]).strip();
										
										int PageEndEntryvalue = Integer.parseInt(PageEndEntry_txt);
																				
										int current_page = (PageEndEntryvalue / page_entry_size);
										
										return current_page;								
										
									}
									
									
									
									public void admin_clicks_next_page ()
									{
										
										int current_class_page_number = 1;
										
										
										int next_class_page_number = find_page_number_pagenation();
										
										System.out.println("The current page user is on is " + next_class_page_number);
										
										if (next_class_page_number > current_class_page_number)
										{
											System.out.println("The user is on the next page (" + next_class_page_number + ")");
										}
										
										else
										{
											System.out.println("The user is on the next page (" + current_class_page_number + ")");
										}
										
									}
									
									
									public void check_next_class_button_status()
									{
										
																				
										By Next_page_Btn_Element = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[3]");
										commonFunctions.CheckButton_DisableStatus(Next_page_Btn_Element, "Next Page Class Btn");
										
									}
									
									
									
									public void check_last_class_button_status()
									{
										
										By Last_page_Btn_Element = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[4]");
										commonFunctions.CheckButton_DisableStatus(Last_page_Btn_Element, "Last Page Class Btn");
										
									}
							


									public void check_back_class_button_status()
										{
	
										By back_page_Btn_Element = By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/p-paginator/div/button[2]");
										commonFunctions.CheckButton_DisableStatus(back_page_Btn_Element, "Previous Page Class Btn");
	
										}
									
		//Class Edit Validations
				
				//Clicking Edit Icon
					public void Click_Edit_Button() {
						
						try {
							Thread.sleep(8000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
						aphk.getDriver().manage().window().maximize();
						aphk.getDriver().manage().window().fullscreen();
						
										      
						
						
						ClickBtn("/html/body/app-root/app-session/div/mat-card/mat-card-content/p-table/div/div[1]/table/tbody/tr[2]/td[8]/div/span/button[1]");
						
						

						try {
							Thread.sleep(8000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						
					}
								
				//Edit_Window_popup
					public void Edit_Popup_Window() {
						
						try {
							Thread.sleep(6000);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
						String Edit_Pop_Window = FindLocators("/html/body/app-root/app-session/p-dialog/div/div");
						
						if (Edit_Pop_Window == "False") {
							System.out.println("Popup Window is Absent");
						}
						else {
							System.out.println("Popup Window is Present");
						}
						
					}
			
				//Batch Name is Blocked
					public void Batch_name_Disable() {
						
						boolean BoxStatus = AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[1]/p-dropdown")).isEnabled();
						if(!BoxStatus)
							System.out.println("Batch name text box is disabled as expected....");
						else
							System.out.println("Batch name text box is enabled - Not as expected");

						
					}
					
						
					
					//Class Topic is Blocked
					public void Class_Topic_Disable() {
						
						boolean ClassTopicStatus = AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/div/mat-card/mat-card-title/div[2]/div[2]/span/input")).isEnabled();
						if(!ClassTopicStatus)
							System.out.println("Class Topic text box is disabled as expected....");
						else
							System.out.println("Class Topic text box is enabled - Not as expected");

						
					}
					

					
					public void Update_Class_Description_Edit(String Text_edit) {
						
						
						AppHooks.getInstance().getDriver().findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[3]/input")).clear();
						
						EnterValue(Text_edit,"/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[3]/input");			
							
						
						
					}
					
					
					
					public void Update_Staff_Name_mand_Edit() {
						
						
						this.driver = AppHooks.getInstance().getDriver();
						this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
						 				
						
						WebElement Staff_dropdown = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown"));
						Staff_dropdown.click();

						
						WebElement staff_dropdownButton = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown/div/div[2]"));
						staff_dropdownButton.click();
							
						
						WebElement Staff_optionToSelect = driver.findElement(By.xpath("/html/body/app-root/app-session/p-dialog/div/div/div[2]/div[6]/p-dropdown/div/div[3]/div/ul/p-dropdownitem[3]"));
						String StaffName = Staff_optionToSelect.getText(); // Store selected option text
						Staff_optionToSelect.click();
						
						
						
					}
					
					
					
					
					
					
									
}



