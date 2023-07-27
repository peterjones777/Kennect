package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import settings.Wait;

public class Dashboard_page {
	WebDriver driver;
By add_todo_button=By.xpath("//*[contains(text(),'Add')]//ancestor::a");
By add_todo_name=By.xpath("//*[@id='outlined-add-todo-input']");
By add_todo_save_button=By.xpath("//*[contains(text(),'Save')]//parent::button");
By added_todo_alert=By.xpath("//*[@role='alert']/*[contains(@class,'message')]");
By completed_todo_alert=By.xpath("//*[@role='alert']/*[contains(@class,'message')]");

By cost_calc_add_test=By.xpath("//*[@id='patient-test']");
By list_tests=By.xpath("//*[contains(@id,'patient-test-option')]");
By list_selected_tests=By.xpath("//*[@id='patient-test-label']/following::*[@role='button']");
By actual_subtotal=By.xpath("//*[contains(text(),'Subtotal')]//following-sibling::*");
By actual_total=By.xpath("//*[contains(text(),'Total')]//following-sibling::*");
By discount_field=By.xpath("(//label[contains(text(),'Discount')]//following::div)[1]");
By discounts=By.xpath("//*[@id='menu-']//following::li");
By discount_15=By.xpath("//li[@data-value='15']");
By delete_test=By.xpath("//*[contains(text(),'Delete')]//parent::button");

By dashboard=By.xpath("//*[contains(text(),'Dashboard')]//ancestor::a");
By tests=By.xpath("//*[text()='Tests']//ancestor::a");
By inventory=By.xpath("//*[contains(text(),'Inventory')]//ancestor::a");
By patients=By.xpath("//*[contains(text(),'Patients')]//ancestor::a");
By labs=By.xpath("//*[contains(text(),'Labs')]//ancestor::a");
By doctors=By.xpath("//*[contains(text(),'Doctors')]//ancestor::a");
By accounting=By.xpath("//*[contains(text(),'Accounting')]//ancestor::a");

	public Dashboard_page(WebDriver driver) {
		this.driver = driver;
	}

	public void Add_ToDo(String name) {

		driver.findElement(add_todo_button).click();
		driver.findElement(add_todo_name).sendKeys(name);
		driver.findElement(add_todo_save_button).click();

	}

	public String Added_Todo_alert_message() {
		Wait.toLoad(driver, added_todo_alert);
		return driver.findElement(added_todo_alert).getText();
	}

	public void Completed_ToDo(String name) {
		driver.navigate().to("https://gor-pathology.web.app/dashboard");
		Wait.toLoad(driver, add_todo_button);
		String s = "(//li/following::*[contains(text(),'todo')]//following::input)[1]//parent::*";
		s = s.replace("todo", name);
		driver.findElement(By.xpath(s)).click();
	}

	public String Completed_Todo_alert_message() {
		Wait.toLoad(driver, completed_todo_alert);
		return driver.findElement(completed_todo_alert).getText();
	}

	public void Add_Tests(int n) throws InterruptedException {
		Wait.toLoad(driver, add_todo_button);
		Actions a = new Actions(driver);
		a.keyDown(Keys.PAGE_DOWN).build().perform();

		driver.findElement(cost_calc_add_test).sendKeys(" ");
		Thread.sleep(3000);
		List<WebElement> li = driver.findElements(list_tests);
		li.get(n).click();

	}

	public int Subtotal() {
		int sum = 0;
		List<WebElement> li = driver.findElements(list_selected_tests);
		
		for (int i = li.size() - 2; i >= 0; i--) {

			String d = li.get(i).getText();
			String[] e = d.split("-");
			e[1] = e[1].trim();
			String[] h = e[1].split("[^0-9]");

			int n = Integer.parseInt(h[0]);
			sum = sum + n;

		}
		return sum;
	}
	public int Actual_subtotal() {
		int sub_tot;
		String sub=driver.findElement(actual_subtotal).getText();
		String[] a=sub.split("[^0-9]");
		sub_tot=Integer.parseInt(a[0]);
		return sub_tot;
	}
	public void Add_Discount(int n)  {
		driver.findElement(discount_field).click();
		Wait.toLoad(driver, discount_15);
		List<WebElement> li = driver.findElements(discounts);
		li.get(n).click();

	}
	public int Actual_total() {
		int tot;
		String sub=driver.findElement(actual_total).getText();
		String[] a=sub.split("[^0-9]");
		tot=Integer.parseInt(a[0]);
		return tot;
	}

	public void Delete_Active_Test(String name) {
		String s = "//li/following::*[contains(text(),'jacob')]/following::*[contains(text(),'view')]";
		s = s.replace("jacob", name);
		driver.findElement(By.xpath(s)).click();
		driver.findElement(delete_test).click();

	}

	public void Dashboard() {

		driver.findElement(dashboard).click();
	}

	public void Tests() {

		driver.findElement(tests).click();
	}

	public void Inventory() {

		driver.findElement(inventory).click();
	}

	public void Patients() {

		driver.findElement(patients).click();
	}

	public void Labs() {

		driver.findElement(labs).click();
	}

	public void Doctors() {

		driver.findElement(doctors).click();
	}

	public void Accounting() {

		driver.findElement(accounting).click();
	}
}
