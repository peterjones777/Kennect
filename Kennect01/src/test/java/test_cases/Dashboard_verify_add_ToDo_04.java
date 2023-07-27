package test_cases;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Dashboard_page;
import settings.Browser;
import settings.Users;

public class Dashboard_verify_add_ToDo_04 {

	WebDriver driver;
	Dashboard_page todo;

	Dashboard_verify_add_ToDo_04() {
		driver = Browser.Assign_properties("chrome");//Assign Browser chrome or firefox
		Users.user1(driver);                          //Assign users
		todo = new Dashboard_page(driver);
	}

	@Test
	public void Todo_Add_button() {
		// TestData
		String Expected_added_Todo_message = "Todo added successfully!";
		String Todo_list_name = "Keep learning";

		// Test
		todo.Add_ToDo(Todo_list_name);

		// verify
		String Actual_added_Todo_message = todo.Added_Todo_alert_message();
		Assert.assertEquals(Actual_added_Todo_message, Expected_added_Todo_message);
	}

	@Test
	public void Todo_Completed_checkbox() {
		// TestData
		String Expected_completed_Todo_message = "Todo completed successfully.";
		String Todo_list_name = "Keep learning";

		// Test
		todo.Completed_ToDo(Todo_list_name);

		// verify
		String Actual_completed_Todo_message = todo.Completed_Todo_alert_message();
		Assert.assertEquals(Actual_completed_Todo_message, Expected_completed_Todo_message);
	}

}
