package base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CarBase {
	
	WebDriver driver;
	
	public CarBase(WebDriver driver) {
		this.driver=driver;
	}
	
	
	
	public void verifyTitle() {
		WebElement title=driver.findElement(By.xpath("//h1"));
		System.out.println(title.getText());
	}
}
