package pages;

import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;

public class Pmenu_page {
	
	Common commonFunctions = new Common(); //Added by Ishu
		private static Pmenu_page MenuprogramPageObjects;

		private Pmenu_page() {};

		public static  Pmenu_page getInstance() {

			if(MenuprogramPageObjects==null) {
				MenuprogramPageObjects= new Pmenu_page();
			}
			return MenuprogramPageObjects;

		}
	
	By usernameTxt = By.xpath("//input[@id = 'username']");
	By passwordTxt = By.xpath("//input[@id = 'password']");
	By loginBtn = By.xpath("//button[@id = 'login']");

	
	
	public void Brokenlinkverify()
	{
		class LinkValidator {
		    public boolean validateLink(String urlString) {
		        try {
		            URL url = new URL(urlString);
		            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		            connection.setRequestMethod("HEAD");
		            connection.connect();
		            return connection.getResponseCode() == 200; // Link is valid
		        } catch (Exception e) {
		            return false; // Link is broken
		        }
		    }

		    public void main(String[] args) {
		        String url = "http://example.com";
		        System.out.println(validateLink(url) ? "The link is valid." : "The link is broken.");
		    }
	}

	}
}
