package bloomsemr.pageobjects;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bloomsemr.AbstractComponents.AbstractComponent;
import bloomsemr.excelDataReader.ClinicDataReader;
import bloomsemr.excelDataReader.ConsultationDataReader;

public class ConsultationPage extends AbstractComponent{

	public ConsultationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void goTocalender() throws InterruptedException
	{
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='fa fa-calendar-days']")).click();
	}
	
	
	@FindBy(xpath = "//div[@class='angular-editor-textarea']")
	WebElement subjectiveTextArea;
	
	
	public void subjectiveDataAddition(String subjective)
	{
		subjectiveTextArea.sendKeys(subjective);
		
	}
	
	public void subjectiveDetailFetch() throws IOException
	{
		ConsultationDataReader d = new ConsultationDataReader();
		ArrayList<String> data = d.getConsultationData("Patient1");
		ConsultationPage consultationPage = new ConsultationPage(driver);

		consultationPage.subjectiveDataAddition(data.get(1));
	}
	
	public void systemReviewAddition() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='mat-checkbox-1-input']//span[@class='mat-checkbox-inner-container']")).click();
		
		driver.findElement(By.xpath("//label[@for='mat-checkbox-8-input']//span[@class='mat-checkbox-inner-container']")).click();
		
		driver.findElement(By.xpath("//label[@for='mat-checkbox-26-input']//span[@class='mat-checkbox-inner-container']")).click();
		
		
	}
	
	public void vitalDataAddition()
	{
		driver.findElement(By.xpath("//div[@mattooltip='Add Vitals']")).click();
		driver.findElement(By.xpath("//input[@id='formly_5_input_Temperature_0']")).sendKeys("98.6°F (37°C)");
		driver.findElement(By.xpath("//input[@id='formly_5_input_BP_1']")).sendKeys("120/80 mmHg");
		driver.findElement(By.xpath("//input[@id='formly_5_input_HR_2']")).sendKeys("85");
		driver.findElement(By.xpath("//input[@id='formly_5_input_Respiratory Rate_3']")).sendKeys("240");
		driver.findElement(By.xpath("//input[@id='formly_5_input_Oxygen Saturation_4']")).sendKeys("98%");
		driver.findElement(By.xpath("//input[@id='formly_8_input_Weight_0']")).sendKeys("73");
		driver.findElement(By.xpath("//input[@id='formly_8_input_Height_1']")).sendKeys("174");
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();
		
	}

	public void goToNext() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='Continue']")).click();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//div[@class='angular-editor-textarea']")
	WebElement objectiveTextArea;
	
	
	public void objectiveDataAddition(String objective)
	{
		subjectiveTextArea.clear();
		subjectiveTextArea.sendKeys(objective);
		
	}
	
	
	
	public void objectiveDetailFetch() throws IOException
	{
		ConsultationDataReader d = new ConsultationDataReader();
		ArrayList<String> data = d.getConsultationData("Patient1");
		ConsultationPage consultationPage = new ConsultationPage(driver);

		consultationPage.objectiveDataAddition(data.get(2));
	}
	
	public void diagnosisAddition()
	{
		driver.findElement(By.xpath("//div[@mattooltip='Add Diagnosis']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Search or Enter Diagnosis']")).sendKeys("A01.1,Paratyphoid fever A");
		driver.findElement(By.xpath("(//span[@class='mat-radio-label-content'])[1]")).click();
		
		driver.findElement(By.xpath("//div[@class='input-group']//input")).sendKeys("03/05/2023");
		
		driver.findElement(By.xpath("(//span[@class='mat-radio-label-content'])[3]")).click();
		
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your notes']")).sendKeys("Sample note");
		
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

	}
	
	@FindBy(xpath = "//div[@class='angular-editor-textarea']")
	WebElement planTextArea;
	
	public void planDataAddition(String plan) throws InterruptedException
	{
		Thread.sleep(5000);
		planTextArea.clear();
		planTextArea.sendKeys(plan);
		
	}
	
	public void planDetailFetch() throws IOException, InterruptedException
	{
		ConsultationDataReader d = new ConsultationDataReader();
		ArrayList<String> data = d.getConsultationData("Patient1");
		ConsultationPage consultationPage = new ConsultationPage(driver);

		consultationPage.planDataAddition(data.get(5));
	}
	
	public void medicationAddition() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@mattooltip='Add Medication']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@placeholder='Search or Enter Medication']")).sendKeys("Ciprofloxacin");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='mat-option-text']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Enter Quantity']")).sendKeys("3");
		driver.findElement(By.xpath("//input[@placeholder='Enter Dosage']")).sendKeys("250");
		//Select unit
		driver.findElement(By.xpath("//ng-select[@placeholder='Please select Units']//span[@class='ng-arrow-wrapper']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Dose']")).click();
		driver.findElement(By.xpath("//ng-select[@placeholder='Please select Route']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[normalize-space()='Oral(PO)']")).click();
		driver.findElement(By.xpath("//ng-select[@formcontrolname='frequency']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='mat-tooltip-trigger'][normalize-space()='Once a day PRN']")).click();
		driver.findElement(By.xpath("//input[@formcontrolname='body_weight']")).sendKeys("73");
		driver.findElement(By.xpath("(//input[@formcontrolname='start_date'])[1]")).sendKeys("03/05/2023");
		
		driver.findElement(By.xpath("(//input[@formcontrolname='end_date'])[1]")).sendKeys("06/05/2023");
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Days']")).sendKeys("3");
		
		driver.findElement(By.xpath("//textarea[@placeholder='Enter your notes']")).sendKeys("Sampel suggestion");
		
		driver.findElement(By.xpath("//button[normalize-space()='Save']")).click();

	}
	
	public void endConsultation() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='End Consultation and View Summary']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[normalize-space()='End']")).click();
	}
	
	public void addadvice() throws InterruptedException
	{
		// Scroll to the bottom of the page
		Thread.sleep(4000);
		
		// Find the WebElement for the element to scroll to
		WebElement elementToScrollTo = driver.findElement(By.xpath("//div[@class='angular-editor-textarea']"));
        
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", elementToScrollTo);
		driver.findElement(By.xpath("//div[@class='angular-editor-textarea']")).sendKeys("Sample plan");
	}
	
	public void eSign()
	{
		driver.findElement(By.xpath("//button[normalize-space()='E-Sign']")).click();
		
		driver.findElement(By.xpath("//button[normalize-space()='End']")).click();
	}
	
	public void signatureAdd() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@title='Add Image']")).sendKeys("/home/cubet/Desktop/WorldAutomation/InputFiles/download (3).png");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='End Consultation']")).click();
		
		driver.findElement(By.xpath("//button[normalize-space()='End']")).click();
	}
	
	public void selectDayforAppointment() throws InterruptedException
	{
		Thread.sleep(4000);
		
		driver.findElement(By.xpath("//mwl-calendar-month-cell[@class='cal-cell cal-day-cell cal-today cal-in-month ng-star-inserted']//div[@class='cal-cell-top ng-star-inserted']")).click();
	}
	
	public void assignPatienttotheSlot() throws InterruptedException
	{
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//mwl-calendar-month-cell[@class='cal-cell cal-day-cell cal-today cal-in-month ng-star-inserted cal-has-events']//div[contains(text(),'06:00 PM - 07:00 PM')]")).click();
		
		driver.findElement(By.xpath("//div[@class='ng-select-container']")).click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//ng-dropdown-panel[@class='ng-dropdown-panel custom-ng-select ng-star-inserted ng-select-bottom']/div/div/div[2]")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//button[@class='btn btn-primary cButton']")).click();
		
		Thread.sleep(8000);
		
	}
}
