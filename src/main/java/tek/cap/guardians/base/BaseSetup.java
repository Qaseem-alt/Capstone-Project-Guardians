package tek.cap.guardians.base;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;


import tek.cap.guardians.config.Browser;
import tek.cap.guardians.config.ChromeBrowser;
import tek.cap.guardians.config.ChromeHeadless;
import tek.cap.guardians.config.EdgeBrowser;
import tek.cap.guardians.config.FireFoxBrowser;
import tek.cap.guardians.utilities.ReadYamlFiles;


public class BaseSetup {

	private static WebDriver webDriver;
	private final ReadYamlFiles environmentVariables;
	public static Logger logger;
	
	public BaseSetup() {
		String filePath = System.getProperty("user.dir") + "/src/main/resources/env_config.yml";
		String log4Jpath = System.getProperty("user.dir") +"/src/main/resources/log4j.properties";
		try {
			environmentVariables = ReadYamlFiles.getInstance(filePath);
		}catch(FileNotFoundException e) {
			System.out.println("Failed for Load enviroment context. Check possible file path errors");
			throw new RuntimeException("Faild for load environment context with massage" + e.getMessage());
		}
		logger = logger.getLogger("logger_File");
		// at above syntext first i used logger inter face therefore the getLogger method was not working
		// make user that you call class not interface 
		PropertyConfigurator.configure(log4Jpath);
	}
	public WebDriver getDriver() {
		return webDriver;
	}
	public void setupBrowser() {
		HashMap uiProperties = environmentVariables.getYamlProperty("ui");
		System.out.println(uiProperties);
		String url = uiProperties.get("url").toString().toLowerCase();
		Browser browser;
		switch (uiProperties.get("browser").toString().toLowerCase()) {
		case "chrome":
			if ((boolean) uiProperties.get("headless")) {
				browser = new ChromeHeadless();
				
			}else {
				browser = new ChromeBrowser();
			}
			webDriver = browser.openBrowser(url);
			break;
		case "firefox":
			browser = new FireFoxBrowser();
			webDriver = browser.openBrowser(url);
			break;
		case "edge":
			browser = new EdgeBrowser();
			webDriver = browser.openBrowser(url);
			break;
			default: 
				throw new RuntimeException("Unknow Browser check enviroment properties");
		}
		 webDriver.manage().window().maximize();
		 webDriver.manage().timeouts().implicitlyWait(Duration.of(20, ChronoUnit.SECONDS));
		 webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
			
		}
		
	public void quitBrowser() {
		if(webDriver !=null)
			webDriver.quit();
	}
		
		
		
		
	}
	
