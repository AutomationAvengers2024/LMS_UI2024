package app_hooks;

import java.time.Duration;

import org.openqa.selenium.WebDriver;

import constants.Constants;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import utilities.Common_utils;

public class AppHooks {
	
	private static AppHooks appHooks;
	private static final ThreadLocal<WebDriver> drivers = new ThreadLocal<>();

	public static AppHooks getInstance() {
		if(appHooks==null) {
			appHooks= new AppHooks();
		}
		return appHooks;

	}

	public WebDriver getDriver() {
		return drivers.get();
	}

	@Before
	public void setUp(Scenario scenario) {
		WebDriver driver = DriverManager.getInstance().createDriver(Constants.BROWSER);
		drivers.set(driver);
		System.out.println("This is the scenario name "+scenario.getName().toLowerCase());
		driver.manage().window().maximize();	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		
		
	}

	@After
	public void tearDown() {
		getDriver().quit();
		drivers.remove();
	}

	@BeforeAll
	public static void beforeAll() {
		Common_utils.getInstance().loadProperties();

	}



}


