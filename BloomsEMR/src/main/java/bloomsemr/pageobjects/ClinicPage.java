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
import bloomsemr.excelDataReader.CredentialReader;

public class ClinicPage extends AbstractComponent {

	// Initialize the variable driver which doesn't have life
	WebDriver driver;

	// Create constructor for give the life to the driver
	public ClinicPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[normalize-space()='Clinic']")
	WebElement clinicHeader;

//	@FindBy(css = "button[class='btn btn-sm btn-primary cButton']")
//	WebElement clinicAddButton;


	public void clinicRedirection() throws InterruptedException {


		//Calling the visibility element from abtract class
		By headerBy = By.xpath("//span[normalize-space()='Clinic']");
		
		waitForElementToAppear(headerBy);
		
		clinicHeader.click();

//		Thread.sleep(3000);

//		clinicAddButton.click();

		Thread.sleep(3000);
	}

//	driver.findElement(By.cssSelector("input[placeholder='Enter Name']")).sendKeys(clinicname);
	@FindBy(css = "input[placeholder='Enter Name']")
	WebElement clinicName;

	@FindBy(css = "textarea[placeholder='Enter Address']")
	WebElement clinicAddress;
	// upload file
	@FindBy(xpath = "//input[@type='file']")
	WebElement uploadFile;

	public void clinicAddition(String name, String address) {
		clinicName.sendKeys(name);
		clinicAddress.sendKeys(address);
		uploadFile.sendKeys("/home/cubet/Desktop/WorldAutomation/InputFiles/logoimage.jpeg");
	}

	public void clinicdetailfetch() throws IOException {

		ClinicDataReader d = new ClinicDataReader();
		ArrayList<String> data = d.getData("Clinic 1");
		ClinicPage clinicPage = new ClinicPage(driver);

		clinicPage.clinicAddition(data.get(1), data.get(2));
	}

	@FindBy(xpath = "//em[@class='fa-regular fa-circle-check fa-xl']")
	WebElement cropSave;

	@FindBy(xpath = "//button[normalize-space()='Save']")
	WebElement clinicSubmit;

	public void cropandSubmit() {
		cropSave.click();

		clinicSubmit.click();
	}
	
	@FindBy(xpath = "(//div[@class='cursor'][normalize-space()='Edit'])[1]")
	WebElement editButton;
	
	@FindBy(xpath = "//button[@type='submit']")
	WebElement editUpdate;
	
	By editLocator = By.xpath("(//div[@class='cursor'][normalize-space()='Edit'])[1]");
	
	public void editClinicPage() throws InterruptedException
	{
		Thread.sleep(3000);
		
		AbstractComponent abstractComponent = new AbstractComponent(driver);
		
		abstractComponent.waitForElementToAppear(editLocator);
		
		editButton.click();
		
		editUpdate.click();
	}
	
	public void searchName() throws IOException, InterruptedException
	{
		Thread.sleep(3000);
		ClinicDataReader d = new ClinicDataReader();
		ArrayList<String> data = d.getData("Clinic 1");
		ClinicPage clinicPage = new ClinicPage(driver);
		driver.findElement(By.xpath("//input[@placeholder='Search for Clinic']")).sendKeys(data.get(1));
		Thread.sleep(2000);
		WebElement item = driver.findElement(By.xpath("//tbody/tr[3]/td[1]/div[1]/div[1]/div[1]"));
		item.isDisplayed();
		Thread.sleep(2000);
	}

	public List<String> paginationSelector() throws InterruptedException
	{
		int paginationSize = driver.findElements(By.cssSelector("li[class='page-item ng-star-inserted']")).size();
		
		List<String> names = new ArrayList<String>();
		
		for(int i = 1; i<=paginationSize; i++)
		{
			Thread.sleep(5000);
			
			String paginationSelector = "(//a[@class='page-link ng-star-inserted'])["+i+"]";
			
			
			WebElement selector =  driver.findElement(By.xpath(paginationSelector));
			
			selector.click();
			
			List<WebElement> nameElements = driver.findElements(By.xpath("//td[@class='mat-cell cdk-cell cdk-column-clinicname mat-column-clinicname ng-star-inserted']"));
			
			for(WebElement namesElement : nameElements)
			{
				names.add(namesElement.getText());
			}
//			for print the name
			for (String name : names)
			{
				System.out.println(names);
			}
		}
		return names;
	
	}

	
}
