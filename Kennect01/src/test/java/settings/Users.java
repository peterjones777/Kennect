package settings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.Login_page;

public class Users {
static By user_field=By.xpath("//*[@name='email' ]");
static By load_complete=By.xpath("//*[contains(text(),'Add')]//ancestor::a");
	public static void user1(WebDriver driver) {
		//Test Data
				String username = "test@kennect.io";
				String password = "Qwerty@1234";


				Login_page user = new Login_page(driver);
			//Login
					Browser.website();
					Wait.toLoad(driver,user_field );
					user.login(username, password);
					Wait.toLoad(driver, load_complete);
		
	}

}
