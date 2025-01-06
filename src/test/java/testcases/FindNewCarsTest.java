package testcases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import base.BasePage;
import pages.AudiCarsPage;
import pages.HomePage;
import pages.MarutiCarsPage;
import pages.NewCarsPage;
import pages.ToyotaCarsPage;

public class FindNewCarsTest {
	
	public static WebDriver driver;
public static void main(String[] args) {
	driver= new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.carwale.com/");
	HomePage home = new HomePage(driver);
	home.goToNewCarsPage();
	
	
	NewCarsPage newCars = new NewCarsPage(driver);
	newCars.goToToyota();
	
	ToyotaCarsPage audi = new ToyotaCarsPage(driver);
	BasePage.carbase.verifyTitle();
}
}
