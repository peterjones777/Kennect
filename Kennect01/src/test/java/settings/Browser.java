package settings;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser {
	static WebDriver driver;

	public static WebDriver Assign_properties(String Browser) {
		
		if (Browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			driver = new ChromeDriver(options);

		} else if (Browser.equalsIgnoreCase("Firefox")) {
			FirefoxOptions options = new FirefoxOptions();

			WebDriverManager.firefoxdriver().setup();

			driver = new FirefoxDriver(options);

		}
		driver.manage().window().maximize();
		return driver;

	}

	public static void website() {
		String website = "https://gor-pathology.web.app/";
		driver.get(website);
	}
}
