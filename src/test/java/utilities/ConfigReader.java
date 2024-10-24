package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties properties;
	private final static String propertyFilePath = "./src/test/resources/config.properties";

	public static void loadConfig() throws Throwable {

		try {
			FileInputStream fis; 
			fis = new FileInputStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(fis);
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("config.properties not found at config file path " + propertyFilePath);
		}
	}

	private static String browserType=null;
	
	public static void setBrowserType(String browser) {
		browserType=browser;
	}
	
	public static String getBrowserType() {
		 browserType = properties.getProperty("browser");
		 System.out.print(browserType);
		if (browserType != null)
			return browserType;
		else
			throw new RuntimeException("browser not specified in the testng.xml");
	}
	
//	public static String getBrowserType()throws Throwable {
//        String browser = properties.getProperty("browser");
//        LoggerLoad.info("Get property BrowserType");
//		if (browser != null)
//			return browser;
//		else
//			throw new RuntimeException("browser not specified in the config.properties file.");
//	}
	
	public static String getExcelFilepPath() {
		String path=properties.getProperty("excelpath");
	//	LoggerLoad.info("Get property BrowserType");
		if (path != null)
			return path;
		else
			throw new RuntimeException("Excel path not specified in the config.properties file.");
	}
	
	public static String getUrl() {
		String url=properties.getProperty("url");
				if (url != null)
					return url;
				else
					throw new RuntimeException("URL not specified in the config.properties file.");	
	}
	
}


