package testcases;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import base.BasePage;
import baseTest.BaseTest;
import pages.AudiCarsPage;
import pages.BMWCarsPage;
import pages.HomePage;
import pages.HyundaiCarsPage;
import pages.MahindraCarsPage;
import pages.NewCarsPage;
import pages.TataCarsPage;
import pages.ToyotaCarsPage;
import utility.DataUtils;

public class FindCarPrices extends BaseTest{

	@Test(dataProviderClass = DataUtils.class,dataProvider = "data")
	public void findCarModelPriceTest(String browserName,String runMode,String carBrand)
	{
		if(runMode.equals("n")) {
			throw new SkipException("Skipped the testcase as the run mode is n");
		}
		
		setUp(browserName);
		HomePage home = new HomePage(driver);
		NewCarsPage newCars = home.goToNewCarsPage();
		if(carBrand.equals("bmw")) {
			BMWCarsPage bmw = newCars.goToBMW();
		}
		
		else if(carBrand.equals("mahindra")) {
			MahindraCarsPage mahindra = newCars.goToMahindra();
		}
		
		else if(carBrand.equals("toyota")) {
			ToyotaCarsPage toyota = newCars.goToToyota();
		}
		
		else if(carBrand.equals("audi")) {
			AudiCarsPage audi = newCars.goToAudi();
		}
		
		else if(carBrand.equals("hyundai")) {
			HyundaiCarsPage hyundai = newCars.goToHyundai();
		}
		
		else if(carBrand.equals("tata")) {
			TataCarsPage tata = newCars.goToTata();
		}
		
		//Assert.assertEquals(BasePage.carbase.verifyTitle(), carTitle,"Invalid car Title");
		BasePage.carbase.getCarModelAndPrice();
		
	}
	
}
