package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	public WebDriver driver;
	public static CarBase carbase;
	

	public BasePage(WebDriver driver) {
		this.driver = driver;
		carbase = new CarBase(driver);
		PageFactory.initElements(driver, this);
	}
	
}
