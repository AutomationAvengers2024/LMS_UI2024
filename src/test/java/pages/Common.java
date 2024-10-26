package pages;

import org.openqa.selenium.By;
import org.testng.Assert;

import app_hooks.AppHooks;
import utilities.LoggerLoad;

public class Common {
	
	By LMSDashboardTitle = By.xpath("//span[normalize-space()='LMS - Learning Management System']");
	
	
	public void verifyDashboardPage()
	{
		boolean verifyDashboard =AppHooks.getInstance().getDriver().findElement(LMSDashboardTitle).isDisplayed();
		if(verifyDashboard)
			LoggerLoad.info("Admin is on dashboard page after Login...");
		else
			LoggerLoad.error("Admin is not on dashboard page after Login...");

		Assert.assertTrue(verifyDashboard);

	}

	 
	public void CheckPageHeading(String PageHeading)
	{
		boolean headingPresent =AppHooks.getInstance().getDriver().findElement(By.xpath("//div[normalize-space()='"+PageHeading+"']")).isDisplayed();
		Assert.assertTrue(headingPresent);

		if(headingPresent)
			LoggerLoad.info(PageHeading +" is present as expected...");

		
		else
			LoggerLoad.error(PageHeading +" is not present as expected...");

			
	}

	/**To check Pagination Message (Eg.Showing 1 to 5 of 54 entries)
	 * 
	 * @param PaginationElement (Pass the pagination web element  eg.PaginatorMessage)
	 * 	By paginatorMessage = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");

	 */
	
	public void checkPaginationMessage(By PaginationElement)
	{
		boolean PaginationMessageMatch=false;
		String PaginationMessage = AppHooks.getInstance().getDriver().findElement(PaginationElement).getText();
				
		String[] splitArr =PaginationMessage.split("of");
		String totEnt = (splitArr[1]);
	
		String[] splitArr2 = totEnt.split(" ");
		String TotalEntries = splitArr2[1];

		int intTotalEntries = Integer.parseInt(TotalEntries);

		
		if(intTotalEntries<10)
		{	
			PaginationMessageMatch = PaginationMessage.matches("Showing [0-9] to [0-9] of [0-9] entries");
		
		}
		else if (intTotalEntries>=10 && intTotalEntries<100)
		{
			PaginationMessageMatch = PaginationMessage.matches("Showing [0-9] to [0-9] of [0-9][0-9] entries");
		}
		else if (intTotalEntries>=100 && intTotalEntries<1000)
		{
			PaginationMessageMatch = PaginationMessage.matches("Showing [0-9] to [0-9] of [0-9][0-9][0-9] entries");
		}
		if(PaginationMessageMatch)
			LoggerLoad.info("Pagination text is present as expected... "+PaginationMessage );
		else
			LoggerLoad.error("Pagination text is not present as expected... "+PaginationMessage );

		Assert.assertTrue(PaginationMessageMatch);
		
	}
	
	// Module should be either programs/batches/class
	public void checkFooterMessage(By FooterElement,String Module)
	{
		boolean FooterMessageMatch=false;
		String FooterMessage = AppHooks.getInstance().getDriver().findElement(FooterElement).getText();
		System.out.println(FooterMessage);		
		String[] splitArr =FooterMessage.split("are");
		String totEnt = (splitArr[1]);
	
		String[] splitArr2 = totEnt.split(" ");
		String TotalEntries = splitArr2[1];

		int intTotalEntries = Integer.parseInt(TotalEntries);

		
		if(intTotalEntries<10)
		{	
			FooterMessageMatch = FooterMessage.matches("In total there are [0-9] "+Module+".");
		
		}
		else if (intTotalEntries>=10 && intTotalEntries<100)
		{
			FooterMessageMatch = FooterMessage.matches("In total there are [0-9][0-9] "+Module+".");
		}
		else if (intTotalEntries>=100 && intTotalEntries<1000)
		{
			FooterMessageMatch = FooterMessage.matches("In total there are [0-9][0-9][0-9] "+Module+".");
		}
		if(FooterMessageMatch)
			LoggerLoad.info("Footer text is present as expected... "+FooterMessage );
		else
			LoggerLoad.error("Footer text is not present as expected... "+FooterMessage );

		Assert.assertTrue(FooterMessageMatch);
		
	}
	//Status is disabled
	public void CheckButton_DisableStatus(By ButtonElement,String ButtonName) 
	{
		boolean buttonStatus = AppHooks.getInstance().getDriver().findElement(ButtonElement).isEnabled();
		if(!buttonStatus)
			LoggerLoad.info("The button "+ButtonName+" is disabled as expected....");
		else
			LoggerLoad.error("The button "+ButtonName+" is enabled - Not as expected");
		Assert.assertFalse(buttonStatus);;
	}
	
	public void CheckButton_IsDisplayed(By ButtonElement,String ButtonName)
	{
		boolean buttonStatus = AppHooks.getInstance().getDriver().findElement(ButtonElement).isDisplayed();
		if(buttonStatus)
			LoggerLoad.info("The button "+ButtonName+" is displayed as expected....");
		else
			LoggerLoad.error("The button "+ButtonName+" is not displayed - Not as expected");
		Assert.assertTrue(buttonStatus);;
	}
	
	public void CheckTable_NoOfRows(By TableElement,int NoOfRows)
	{
		
		int totRows = AppHooks.getInstance().getDriver().findElements(TableElement).size();
		System.out.println(totRows);
		if (totRows==5)
			LoggerLoad.info("Total Number of records displayed is "+totRows+" - As expected");
		else
			LoggerLoad.error("Total Number of records displayed is "+totRows+" - Not As expected");
		Assert.assertEquals(totRows, 5);
		
	}
	
	//Using xpath as locator
		public void CheckTable_CheckBox(By TableElement)
		{
			int totRows = AppHooks.getInstance().getDriver().findElements(TableElement).size();
			//By.xpath: //table//tbody[@class='p-datatable-tbody']//tr
				//table//tbody[@class='p-datatable-tbody']//tr[2]//div[@role='checkbox']

			System.out.println((TableElement));
			String[] TblEle = TableElement.toString().split("By.xpath: ");
			for (int row=1;row<=totRows;row++)
				
			{
				boolean checkBoxStatus = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//div[@role='checkbox']")).isDisplayed();
				if (checkBoxStatus)
					LoggerLoad.info("Check Box is present in Row Number:"+row+" - As expected");
				else
					LoggerLoad.error("Check Box is not present in Row Number:"+row+" - Not As expected");
				Assert.assertTrue(checkBoxStatus);
			}
		}
		public void CheckTable_EditBtn(By TableElement)
		{
			int totRows = AppHooks.getInstance().getDriver().findElements(TableElement).size();
			//table//tbody[@class='p-datatable-tbody']//tr[2]//button[@id='editProgram']
			//table//tbody[@class='p-datatable-tbody']//tr[2]//button[@id='deleteProgram']
			String[] TblEle = TableElement.toString().split("By.xpath: ");
			for (int row=1;row<=totRows;row++)
				
			{
				boolean editBtnStatus = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//button[@id='editProgram']")).isDisplayed();
				 boolean editBtnEnabled = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//button[@id='editProgram']")).isEnabled();
				if (editBtnStatus)
					LoggerLoad.info("Edit Button is present in Row Number:"+row+" - As expected");
				else
					LoggerLoad.error("Edit Button is not present in Row Number:"+row+" - Not As expected");
				if (editBtnEnabled)
					LoggerLoad.info("Edit Button is enabled in Row Number:"+row+" - As expected");
				else
					LoggerLoad.error("Edit Button is not enabled in Row Number:"+row+" - Not As expected");
				Assert.assertTrue(editBtnStatus);
				Assert.assertTrue(editBtnEnabled);
				
			}
			
		}
		public void CheckTable_DeleteBtn(By TableElement)
		{
			int totRows = AppHooks.getInstance().getDriver().findElements(TableElement).size();
			//table//tbody[@class='p-datatable-tbody']//tr[2]//button[@id='deleteProgram']
			String[] TblEle = TableElement.toString().split("By.xpath: ");
			for (int row=1;row<=totRows;row++)
				
			{
				boolean deleteBtnStatus = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//button[@id='deleteProgram']")).isDisplayed();
				boolean deleteBtnEnabled = AppHooks.getInstance().getDriver().findElement(By.xpath(TblEle[1]+"["+row+"]//button[@id='deleteProgram']")).isEnabled();

				if (deleteBtnStatus)
					LoggerLoad.info("Delete Button is present in Row Number:"+row+" - As expected");
				else
					LoggerLoad.error("Delete Button is not present in Row Number:"+row+" - Not As expected");
				if (deleteBtnEnabled)
					LoggerLoad.info("Delete Button is enabled in Row Number:"+row+" - As expected");
				else
					LoggerLoad.error("Delete Button is not enabled in Row Number:"+row+" - Not As expected");
				Assert.assertTrue(deleteBtnStatus);
				Assert.assertTrue(deleteBtnEnabled);
			}
			
		}
		
		public void checkSearchBar_WithSearch(By SearchElement)
		{
			boolean searchBarDisplayed = AppHooks.getInstance().getDriver().findElement(SearchElement).isDisplayed();
			if (searchBarDisplayed)
				LoggerLoad.info("Search Bar is displayed - As expected");
			else
				LoggerLoad.error("Search Bar is not displayed - Not As expected");
			String searchText =AppHooks.getInstance().getDriver().findElement(SearchElement).getAttribute("placeholder");
			if(searchText.equals("Search..."))
				LoggerLoad.info("Search Text Search... is displayed - As expected");
			else
				LoggerLoad.error("Search Text Search... is not displayed - As expected");


		}	

}
