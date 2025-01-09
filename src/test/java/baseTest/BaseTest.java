package baseTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import extentlisteners.ExtentListeners;
import utility.ExcelReader;

public class BaseTest {
	

	public WebDriver driver;
	public ExcelReader excel = new ExcelReader("./src/test/resources/excelData/fbData.xlsx");
	public WebDriverWait wait;
	public FileInputStream fis;
	public Properties config = new Properties();
	//public Properties or = new Properties();
	public Logger log = Logger.getLogger(BaseTest.class);

	
	public void setUp(String browserName) {
		try {
			fis = new FileInputStream("./src/test/resources/properties/log4j.properties");
		} catch (FileNotFoundException e) {
			log.info("log4j configuration file is not loaded");
		}
		PropertyConfigurator.configure(fis);
		log.info("Test case execution started");

		try {
			fis = new FileInputStream("./src/test/resources/properties/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			config.load(fis);
			log.info("config properties file has been loaded");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			log.info("Chrome browser has been launched");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			log.info("Firefox browser has been launched");
		}
		else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			log.info("Edge browser has been launched");
		}
		driver.manage().window().maximize();
		log.info("Browser is maximized");
		wait = new WebDriverWait(driver, Duration.ofSeconds(Integer.parseInt(config.getProperty("explicitWait"))));
		driver.manage().timeouts()
				.implicitlyWait(Duration.ofSeconds(Integer.parseInt(config.getProperty("implicitWait"))));
		driver.get(config.getProperty("testsiteurl"));
	}

	
	 @AfterMethod 
	 public void tearDown() {
		 driver.close();
		 }
	
	

}
