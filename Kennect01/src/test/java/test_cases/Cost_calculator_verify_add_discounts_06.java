package test_cases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard_page;
import settings.Browser;
import settings.Users;

public class Cost_calculator_verify_add_discounts_06 {
	WebDriver driver;
	Dashboard_page CostCal;

	Cost_calculator_verify_add_discounts_06() {
		
		driver = Browser.Assign_properties("chrome");
		Users.user1(driver);
		CostCal = new Dashboard_page(driver);
	}

	@Test
	public void Add_discount_test() throws InterruptedException {

		CostCal.Add_Tests(3); // Add atleast two tests for testcase.Adding Test of index 2,which means the 3rd
								// test on the list will be added.Index can be changed.
		CostCal.Add_Tests(5);
//test
		int sub_total = CostCal.Subtotal();
		double Expected_total = 0;
		int index_of_percentage = 1;// 0-None 1-For 5% 2-For 10% 3-15% 4-20%

		CostCal.Add_Discount(index_of_percentage);

		if (index_of_percentage == 1) {
			Expected_total = sub_total - (0.05 * sub_total);
		} else if (index_of_percentage == 2) {
			Expected_total = sub_total - (0.1 * sub_total);
		} else if (index_of_percentage == 3) {
			Expected_total = sub_total - (0.15 * sub_total);

		} else if (index_of_percentage == 2) {
			Expected_total = sub_total - (0.2 * sub_total);
		} else {
			Expected_total = sub_total;
		}

		int Actual_total = CostCal.Actual_total();
		// verify
		Assert.assertEquals(Actual_total, Expected_total);

	}
}
