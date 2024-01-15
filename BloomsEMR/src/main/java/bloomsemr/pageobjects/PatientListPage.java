package bloomsemr.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import bloomsemr.AbstractComponents.AbstractComponent;

public class PatientListPage extends AbstractComponent{
	
	WebDriver driver;

	public PatientListPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goToPatientList() throws InterruptedException
	{
		Thread.sleep(8000);
		driver.findElement(By.xpath("//span[@class='fa fa-chalkboard-user']")).click();
		
	}
	
	public void viewPatientDetails() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[1]/td[1]")));
		driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).click();
		
	}
	
	public void refermyPatient() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[@class='p-ripple p-element p-button-outlined p-button-sm prime-sm-btn p-button p-component']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ng-select-container']")).click();
		Thread.sleep(6000);
		driver.findElement(By.xpath("//div[@class='ng-option ng-star-inserted'][1]")).click();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void addInsurance() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(text(),'Add Insurance')]")).click();
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Insurance Details']")).clear();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//textarea[@placeholder='Enter Insurance Details']")).sendKeys("Sample Insurance");
//		Thread.sleep(2000);
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	public void swapTabs() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[contains(text(),'Patient Documents')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[contains(text(),'Wearable Info')]")).click();
		
	}
	
	public void editInsurance() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@mattooltip='Edit Insurance Details']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

}
