package pages;

import org.openqa.selenium.By;

import app_hooks.AppHooks;

public class Class_Page {
	
	//General Function to Click Button
			public void ClickBtn(String Xpath) {
			By ClickBtn=By.xpath(Xpath);
			AppHooks.getInstance().getDriver().findElement(ClickBtn).click();
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
			

}
