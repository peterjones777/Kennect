package test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard_page;

import settings.Browser;
import settings.Users;
import settings.Wait;

public class Dashboard_verify_sidepanel_tiles_function_03 {
	WebDriver driver;
	Dashboard_page tiles;

	Dashboard_verify_sidepanel_tiles_function_03() {
		driver = Browser.Assign_properties("chrome");
		Users.user1(driver);
		tiles = new Dashboard_page(driver);

	}

	By manage_test_btn = By.xpath("//*[contains(text(),'Manage Tests')]");
	By add_equipment_btn = By.xpath("//*[contains(text(),'Add Equipment')]");
	By add_patient_btn = By.xpath("//*[contains(text(),'Add Patient')]");
	By add_lab_btn = By.xpath("//*[contains(text(),'Add Lab')]");
	By add_doctor_btn = By.xpath("//*[contains(text(),'Add Doctor')]");
	By accounting_element = By.xpath("//*[contains(text(),'Transactions')]");

	// Assigning Browser properties

	@Test
	public void checktiles() throws InterruptedException {

		// Check 'Tests' Tile
		tiles.Tests();
		String Expected_Url = "https://gor-pathology.web.app/tests";
		Wait.toLoad(driver, manage_test_btn);
		String Actual_Url = driver.getCurrentUrl();
		Assert.assertEquals(Actual_Url, Expected_Url);
		Thread.sleep(2000);

		// Check 'Inventory' Tile
		tiles.Inventory();
		Expected_Url = "https://gor-pathology.web.app/inventory";
		Wait.toLoad(driver, add_equipment_btn);
		Actual_Url = driver.getCurrentUrl();
		Assert.assertEquals(Actual_Url, Expected_Url);
		Thread.sleep(2000);

		// Check 'Patients' Tile
		tiles.Patients();
		Expected_Url = "https://gor-pathology.web.app/patients";
		Wait.toLoad(driver, add_patient_btn);
		Actual_Url = driver.getCurrentUrl();
		Assert.assertEquals(Actual_Url, Expected_Url);
		Thread.sleep(2000);

		// Check 'Labs' Tile
		tiles.Labs();
		Expected_Url = "https://gor-pathology.web.app/labs";
		Wait.toLoad(driver, add_lab_btn);
		Actual_Url = driver.getCurrentUrl();
		Assert.assertEquals(Actual_Url, Expected_Url);
		Thread.sleep(2000);

		// Check 'Doctors' Tile
		tiles.Doctors();
		Expected_Url = "https://gor-pathology.web.app/doctors";
		Wait.toLoad(driver, add_doctor_btn);
		Actual_Url = driver.getCurrentUrl();
		Assert.assertEquals(Actual_Url, Expected_Url);
		Thread.sleep(2000);

		// Check 'Accounting' Tile
		tiles.Accounting();
		Expected_Url = "https://gor-pathology.web.app/accounting";
		Wait.toLoad(driver, accounting_element);
		Actual_Url = driver.getCurrentUrl();
		Assert.assertEquals(Actual_Url, Expected_Url);
		Thread.sleep(2000);
	}
}
