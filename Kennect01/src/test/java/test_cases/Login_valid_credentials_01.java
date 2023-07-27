package test_cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Login_page;
import settings.Browser;
import settings.Users;
import settings.Wait;

public class Login_valid_credentials_01 {
	Login_page user;
	WebDriver driver;

	// Assigning Browser properties
	Login_valid_credentials_01() {

		driver = Browser.Assign_properties("chrome");

		user = new Login_page(driver);

	}

	By user_field = By.xpath("//*[@name='email' ]");
	By add_todo_btn = By.xpath("//*[contains(text(),'Add')]//ancestor::a");

	@Test
	public void login_valid_creds() {
		// Test Data
		String username = "test@kennect.io";
		String password = "Qwerty@1234";

//Begin Test
		Browser.website();
		Wait.toLoad(driver, user_field);
		user.login(username, password);

//Verifying Test with assertions
		String expected = "https://gor-pathology.web.app/dashboard";
		Wait.toLoad(driver, add_todo_btn);
		String actual = driver.getCurrentUrl();
		Assert.assertEquals(actual, expected);

	}
}
