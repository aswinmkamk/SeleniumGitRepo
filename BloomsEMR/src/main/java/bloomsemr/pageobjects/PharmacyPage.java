package bloomsemr.pageobjects;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bloomsemr.AbstractComponents.AbstractComponent;
import bloomsemr.excelDataReader.ClinicDataReader;
import bloomsemr.excelDataReader.PharmacyDataReader;

public class PharmacyPage extends AbstractComponent{
	
	WebDriver driver;

	public PharmacyPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	driver.findElement(By.cssSelector("input[formcontrolname='pharmacy_name']")).sendKeys("New Pharmacy");
	@FindBy(css = "input[formcontrolname='pharmacy_name']")
	WebElement pharmacyName;

//	driver.findElement(By.cssSelector("input[formcontrolname='pharmacy_email']")).sendKeys("newpharmacy@yopmail.com");
	@FindBy(css = "input[formcontrolname='pharmacy_email']")
	WebElement pharmacyEmail;

//	driver.findElement(By.cssSelector("input[formcontrolname='pharmacy_phone_number']")).sendKeys("7845258963");
	@FindBy(css = "input[formcontrolname='pharmacy_phone_number']")
	WebElement pharmaNumber;

//	driver.findElement(By.cssSelector("textarea[placeholder='Enter Address']")).sendKeys("Sample Address1");
	@FindBy(css = "textarea[placeholder='Enter Address']")
	WebElement pharmaAddress;

//	driver.findElement(By.cssSelector("button[type='submit']")).click();
//	@FindBy(css = "button[type='submit']" )
//	WebElement submit ;
	
	public void goToPharmacy() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Pharmacy']")));
		driver.findElement(By.xpath("//span[normalize-space()='Pharmacy']")).click();
		Thread.sleep(4000);
		
	}
	public void pharamacyAdd()
	{
		driver.findElement(By.cssSelector("button[class='btn btn-sm btn-primary cButton']")).click();
	}

	public void pharmacyDetailAddition(String name, String email, String number, String address) {
		pharmacyName.sendKeys(name);
		pharmacyEmail.sendKeys(email);
		pharmaNumber.sendKeys(number);
		pharmaAddress.sendKeys(address);

	}
	
	public void pharmacydetailfetch() throws IOException {

		PharmacyDataReader d = new PharmacyDataReader();
		ArrayList<String> pharmData = d.getPharmacyData("Pharmacy 1");
		PharmacyPage pharmacyPage = new PharmacyPage(driver);

		pharmacyPage.pharmacyDetailAddition(pharmData.get(1), pharmData.get(2), pharmData.get(3), pharmData.get(4));
	}
	
	public void pharmacySubmit()
	{
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	public void pharmacyUpdate() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//body[1]/app-root[1]/div[1]/app-pages[1]/app-headersidnav[1]/div[1]/div[2]/div[1]/app-user-list-container[1]/div[1]/mat-tab-group[1]/div[1]/mat-tab-body[7]/div[1]/app-pharmacy-view-table[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[3]/div[1]/div[1]/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void searchPharmacyName() throws IOException, InterruptedException
	{
		Thread.sleep(4000);
		PharmacyDataReader d = new PharmacyDataReader();
		ArrayList<String> pharmdata = d.getPharmacyData("Pharmacy 1");
		ClinicPage clinicPage = new ClinicPage(driver);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@placeholder='Search for Pharmacy']")).sendKeys(pharmdata.get(1));
		Thread.sleep(2000);
		WebElement item = driver.findElement(By.xpath("//input[@placeholder='Search for Pharmacy']"));
		item.isDisplayed();
		Thread.sleep(2000);
	}
	

}
