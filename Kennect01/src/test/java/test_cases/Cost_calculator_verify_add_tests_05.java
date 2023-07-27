package test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard_page;
import settings.Browser;
import settings.Users;

public class Cost_calculator_verify_add_tests_05 {
	WebDriver driver;
	Dashboard_page CostCal;
	
	Cost_calculator_verify_add_tests_05(){
		driver = Browser.Assign_properties("chrome");
		Users.user1(driver);
		CostCal = new Dashboard_page(driver);
	}
	@Test
	public void Patient_Tests() throws InterruptedException  {
		//Test
		CostCal.Add_Tests(3);//Add atleast two tests for test.Adding Test of index 2,which means the 3rd test on the list will be added.Index can be changed.
		CostCal.Add_Tests(5);
		
		int Expected_total_without_discount =CostCal.Subtotal();
		int Actual_total_without_discount=CostCal.Actual_subtotal();
		
		//verify
		Assert.assertEquals(Actual_total_without_discount, Expected_total_without_discount);
	}

}
