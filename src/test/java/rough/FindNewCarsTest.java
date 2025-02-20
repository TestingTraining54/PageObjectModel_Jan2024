package rough;

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
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.carwale.com/");

		HomePage home = new HomePage(driver);
		NewCarsPage newCars = home.goToNewCarsPage();
		ToyotaCarsPage toyota = newCars.goToToyota();

		System.out.println("Title of the cars page: " + BasePage.carbase.verifyTitle());
	}
}
