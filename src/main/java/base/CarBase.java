package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarBase {
	
	WebDriver driver;
	
	public CarBase(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//h1")
	WebElement title;
	public String verifyTitle() {
		//WebElement title=driver.findElement(By.xpath("//h1"));
		return title.getText();
	}
}
