package bloomsemr.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import bloomsemr.AbstractComponents.AbstractComponent;

public class BookSlotPage extends AbstractComponent{
	
	// Initialize the variable driver which doesn't have life
	WebDriver driver;

	public BookSlotPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	
	public void goToBookSlot() throws InterruptedException
	{
		Thread.sleep(6000);
		driver.findElement(By.xpath("//span[@class='fa-calendar-plus fa-solid']")).click();
	}
	
	public void createaSlot() throws InterruptedException
	{
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@value='Add Slot']")).click();
		
		Thread.sleep(30000);
		
		
		driver.findElement(By.xpath("//input[@name='startTime']")).sendKeys("06:00 PM");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='time-slots border mb-4']")).click();
		
		driver.findElement(By.xpath("//input[@value='Add Slot']")).click();
		
		driver.findElement(By.xpath("//input[@name='endTime']")).sendKeys("07:00 PM");
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//strong[normalize-space()='No slot Added!']")).click();
		
		driver.findElement(By.xpath("//input[@value='Add Slot']")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@value='Submit']")).click();

	}
	
	
	
	

}
