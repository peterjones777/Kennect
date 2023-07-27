package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import settings.Wait;

public class Patients_page {
	WebDriver driver;

	By add_button = By
			.xpath("//*[@class='title' and contains(text(),'Patients')]//following-sibling::a[@href='/patients/add']");
	By fill_name = By.xpath("//input[@name='name']");
	By fill_email = By.xpath("//input[@name='email']");
	By fill_phone = By.xpath("//input[@name='phone']");
	By fill_height = By.xpath("//input[@name='height']");
	By fill_weight = By.xpath("//input[@name='weight']");
	By fill_age = By.xpath("//input[@name='age']");
	By fill_bp_sys = By.xpath("//input[@name='systolic']");
	By fill_bp_dia = By.xpath("//input[@name='diastolic']");
	By fill_gender = By.xpath("//*[@id='mui-component-select-gender']");
	By gender_list = By.xpath("//*[@id='menu-gender']//following::li");
	By add_tests_btn = By.xpath("//*[contains(text(),'Add Tests')]//parent::button//span[2]");
	By back_btn = By.xpath("//*[contains(text(),'back')]//parent::button");
	By add_test = By.xpath("//*[contains(@id,'patient-test-option')]");
	By add_test_field = By.xpath("//*[@id='patient-test']");
	By discount_field = By.xpath("//label[text()='Discount']//following-sibling::div");
	By discounts = By.xpath("//*[@id='menu-']//following::li");
	By discount_15 = By.xpath("//li[@data-value='15']");
	By add_equipment = By.xpath("//button[@title='Add equipment']/span");
	By choose_equipment_field = By.xpath("//*[@aria-label='Eqipment Name']");
	By all_equipments = By.xpath("//*[@id='menu-']//following::li");
	By equipment_name = By.xpath("//*[@aria-label='Eqipment Name']");
	By delete_equip = By.xpath("//*[text()='delete_outline']");
	By general_detail_btn = By.xpath("//*[contains(text(),'General')]//parent::button");
	By accept_check = By.xpath("//*[text()='check']");
	By edit_equip = By.xpath("//*[text()='edit']");
	By add_patient = By.xpath("//*[contains(text(),'Add Patient')]//parent::button");
	By add_patient2 = By.xpath("//*[contains(text(),'Add Patient')]//parent::button/span");
	By cancel_equip = By.xpath("//*[text()='clear']");
	By lab_field = By.xpath("//*[@id='patient-tests-labs']");
	By labs = By.xpath("//*[@id='patient-tests-labs-popup']/li/descendant::div");
	By labs2= By.xpath("//*[@id='patient-tests-labs-popup']/li");

	public Patients_page(WebDriver driver) {
		this.driver = driver;
	}

	public void Create_patient_button() {
		Wait.toLoad(driver, add_button);
		driver.findElement(add_button).click();
	}

	public void Primary_details(String name, String email, String phone_num) {
		Wait.toLoad(driver, fill_name);
		driver.findElement(fill_name).sendKeys(name);
		driver.findElement(fill_email).sendKeys(email);
		driver.findElement(fill_phone).sendKeys(phone_num);
	}

	public void Cancel_button() {
		Actions a = new Actions(driver);
		a.keyDown(Keys.PAGE_DOWN).build().perform();
		driver.findElement(By.xpath("//*[contains(text(),'cancel')]//parent::button")).click();
	}

	public void General_details_button() {
		driver.findElement(general_detail_btn).click();
		Wait.toLoad(driver, add_tests_btn);

	}

	public void Secondary_details(String height, String weight, String age, String gender, String bp_sys,
			String bp_dia) {
		Wait.toLoad(driver, fill_height);
		driver.findElement(fill_height).sendKeys(height);
		driver.findElement(fill_weight).sendKeys(weight);
		driver.findElement(fill_age).sendKeys(age);
		driver.findElement(fill_bp_sys).sendKeys(bp_sys);
		driver.findElement(fill_bp_dia).sendKeys(bp_dia);

		driver.findElement(fill_gender).click();
		List<WebElement> li = driver.findElements(gender_list);

		if (gender.equalsIgnoreCase("male")) {
			li.get(1).click();
		} else {
			li.get(2).click();
		}
	}

	public void Back_button() {
		;
		driver.findElement(back_btn).click();
	}

	public void Add_tests_button() throws InterruptedException {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(add_tests_btn));
		Wait.toLoad(driver, add_tests_btn);
		try {
			driver.findElement(add_tests_btn).click();
		} catch (Exception e) {
			try {

				driver.findElement(By.xpath("//*[contains(text(),'Add Tests')]//parent::button")).click();
			}

			catch (Exception d) {
				System.out.println("not clicking");
			}
		}
	}

	public void Add_Tests(int n) {
try {
		driver.findElement(add_test_field).sendKeys(" ");
		Thread.sleep(2000);;
		List<WebElement> li = driver.findElements(add_test);

		li.get(n).click();
}
catch(Exception e) {
	System.out.println("Test not added");
}
	}

	public void Add_Discount(int n) {
		driver.findElement(discount_field).click();
		Wait.toLoad(driver, discount_15);
		List<WebElement> li = driver.findElements(discounts);
		li.get(n).click();

	}

	public void Add_lab(int n)  {
		driver.findElement(lab_field).click();
		
try {
	Thread.sleep(3000);
		List<WebElement> li = driver.findElements(labs);
		li.get(n).click();
}
catch(Exception e) {
	try {
		Thread.sleep(3000);
		List<WebElement> li = driver.findElements(labs2);
		li.get(n).click();
	}
	catch(Exception d) {
		System.out.println("failed to select lab");
	}
}
	}

	public void Choose_Equipment(int n) {
		
		try {
			Actions a = new Actions(driver);
		a.keyDown(driver.findElement(back_btn),Keys.PAGE_DOWN).build().perform();;
		Thread.sleep(2000);

		}
		catch(Exception e) {
			try {
				Actions a = new Actions(driver);
				a.keyDown(driver.findElement(add_patient),Keys.PAGE_DOWN).build().perform();;
			
			
			}
			catch(Exception d) {
				try{
					Actions a = new Actions(driver);
					a.keyDown(driver.findElement(add_equipment),Keys.PAGE_DOWN).build().perform();;
					Thread.sleep(2000);
				}
				catch(Exception f) {
					System.out.println("move to Add equipment failed");
				}
			}
		}

		
Wait.toLoad(driver, add_equipment);
		driver.findElement(add_equipment).click();
		driver.findElement(choose_equipment_field).click();
		Wait.toLoad(driver, all_equipments);
		List<WebElement> li = driver.findElements(all_equipments);
		li.get(n).click();
		Wait.toLoad(driver, equipment_name);

	}

	public void Accept() {
		driver.findElement(accept_check).click();
	}

	public void Cancel_Equipment() {
		driver.findElement(cancel_equip).click();
	}

	public void Delete_Equipment() {
		Wait.toLoad(driver, delete_equip);
		driver.findElement(delete_equip).click();
	}

	public void Edit_Equipment() {
		driver.findElement(edit_equip).click();
	}

	public void Add_Patient_button() {

		driver.findElement(add_patient).click();

	}
}
