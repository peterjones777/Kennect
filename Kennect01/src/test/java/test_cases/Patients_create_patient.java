package test_cases;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.Test;
import pages.Dashboard_page;
import pages.Patients_page;
import settings.Browser;
import settings.Users;

public class Patients_create_patient {
	WebDriver driver;
	Patients_page patients;
	Dashboard_page dashboard;

	Patients_create_patient() {
		driver = Browser.Assign_properties("chrome");
		Users.user1(driver);
		patients = new Patients_page(driver);
		dashboard = new Dashboard_page(driver);
	}

	@Test
	public void Generate_detail() throws InterruptedException {

		// test-data
		String name = "Racko";
		String email = "hello@123.com";
		String phone_num = "9854632558";
		String height = "150";
		String weight = "80";
		String gender = "male"; // male or female
		String age = "23";
		String bp_sys = "120";
		String bp_dia = "60";

		// test
		dashboard.Patients();
		patients.Create_patient_button();
		patients.Primary_details(name, email, phone_num);
		patients.General_details_button();
		patients.Secondary_details(height, weight, age, gender, bp_sys, bp_dia);
		patients.Add_tests_button();
		patients.Add_Tests(2);
		patients.Add_Tests(5);
		patients.Add_Discount(2);
		patients.Add_lab(0);
		Thread.sleep(2000);
		patients.Choose_Equipment(0);
		patients.Add_Patient_button();

	}

}
