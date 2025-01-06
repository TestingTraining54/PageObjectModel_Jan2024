package base;

import org.openqa.selenium.WebDriver;

public class BasePage {
	public WebDriver driver;
	public static CarBase carbase;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		carbase = new CarBase(driver);
	}
}
