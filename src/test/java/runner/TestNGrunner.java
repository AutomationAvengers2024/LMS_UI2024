package runner;
import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

	@CucumberOptions(
			
			features = {"src/test/resources/features"},
			
			plugin = {"pretty", "html:target/result.html",
					
					"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
			glue= {"stepdefinitions","pages","app_hooks",},
			dryRun = false
			)
	public class TestNGrunner extends AbstractTestNGCucumberTests{

		
		@Override
		@DataProvider(parallel = false) public Object[][] scenarios() {

			return super.scenarios(); }

	}


