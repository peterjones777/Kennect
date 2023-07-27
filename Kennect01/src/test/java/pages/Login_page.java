package pages;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class Login_page {
	WebDriver driver;

	By email = By.xpath("//*[@name='email' ]");
	By pass = By.xpath("//*[@name='password' ]");
	By login_btn = By.xpath("(//*[@type='submit' ])[1]");

	public Login_page(WebDriver driver) {
		this.driver = driver;
	}

	@Test
	public void login(String username, String password) {

		driver.findElement(email).sendKeys(username);
		driver.findElement(pass).sendKeys(password);
		driver.findElement(login_btn).click();
	}

	@Test
	public void loginThroughGoogle() throws InterruptedException {

		driver.findElement(By.xpath("(//*[@type='submit' ])[2]")).click();
		Thread.sleep(10000);
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			String window = it.next();
			driver.switchTo().window(window);
			if (driver.getTitle().contentEquals("Sign in - Google Accounts")) {
				break;
			} else {
				driver.switchTo().defaultContent();
			}
		}

	}

}
