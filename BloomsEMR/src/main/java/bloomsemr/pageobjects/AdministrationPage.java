package bloomsemr.pageobjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import bloomsemr.AbstractComponents.AbstractComponent;
import bloomsemr.excelDataReader.ClinicDataReader;
import bloomsemr.excelDataReader.UserDataReader;

public class AdministrationPage extends AbstractComponent{
	
	public AdministrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	public void addUser() throws InterruptedException
	{
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();
	}
	
	@FindBy(xpath = "//select[@class='form-control cForm-control ng-valid ng-dirty ng-touched']")
	WebElement userstype;
	
	@FindBy(css = "input[placeholder='Email Address']")
	WebElement emailAddress;
	
	@FindBy(xpath = "//input[@placeholder='Enter National Id']")
	WebElement nationalID;
	
	@FindBy(xpath = "//input[@placeholder='License number']")
	WebElement liscenceNumber;
	
	@FindBy(xpath = "//ng-select[@placeholder='Please select speciality']")
	WebElement doctorspeciality;
	
	@FindBy(xpath = "//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']")
	WebElement clinicName;
	
	@FindBy(xpath = "//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']")
	WebElement patientaddress;
	
	@FindBy(xpath = "(//input[@placeholder='Enter Name'])[1]")
	WebElement firstName;
	
	@FindBy(xpath = "//input[@formcontrolname='last_name']")
	WebElement lastName;
	
	@FindBy(css = "input[placeholder='dd/mm/yyyy']")
	WebElement DOB;
	
	@FindBy(xpath = "//select[@formcontrolname='gender']")
	WebElement genderoftype;
	
	@FindBy(css = "input[placeholder='Enter Number']")
	WebElement phonenumber;
	
	@FindBy(xpath = "//textarea[@placeholder='Enter Address']")
	WebElement address;
	
	//input[@class='fileuploads']
	@FindBy(xpath = "//input[@title='Update profile picture']")
	WebElement fileupload;
	
	public void goToDoctor() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Doctors']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();
	}
	
	public void goToNurse() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Nurses']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();
	}
	
	public void goToPatient() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Patients']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();
	}
	
	public void goToReceptionist() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[normalize-space()='Receptionists']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[normalize-space()='Add New']")).click();
	}
	
	public void editandSubmit() throws InterruptedException
	{
	    Thread.sleep(4000);
	    driver.findElement(By.xpath("//body[1]/app-root[1]/div[1]/app-pages[1]/app-headersidnav[1]/div[1]/div[2]/div[1]/app-user-list-container[1]/div[1]/mat-tab-group[1]/div[1]/mat-tab-body[1]/div[1]/app-user-list-table-filter[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[4]/div[1]/table[1]/tr[1]/td[1]/div[1]")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	}
	
	
	public void doctorAddition(String typeofuser, String email, String lcnnumber, String speciality, String nameofclinic, String firstname, String lastname, String  Stringidno, String dob, String gender, String number) throws InterruptedException
	{
		
		emailAddress.sendKeys(email);
		liscenceNumber.sendKeys(lcnnumber);
		
//		Select speciality name
		if (driver.findElements(By.cssSelector("ng-select[placeholder='Please select speciality']")).size() > 0 && driver.findElement(By.cssSelector("ng-select[placeholder='Please select speciality']")).isDisplayed())
		{
		driver.findElement(By.cssSelector("ng-select[placeholder='Please select speciality']")).click(); 
		
		Thread.sleep(2000);
		String specialities = "\"" + speciality + "\"";
		String ROM = "//span[normalize-space()=" + specialities+"]" + "";
		driver.findElement(By.xpath(ROM)).click(); 
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='ng-select-container ng-has-value']//span[@class='ng-arrow-wrapper']")).click(); 
		}
		
//		Select clinic name
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']")).size() > 0 && driver.findElement(By.xpath("//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']")).isDisplayed()) 
		{
		driver.findElement(By.xpath("//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']")).click(); 
		Thread.sleep(5000);
		String clinics = "\"" + nameofclinic + "\"";
		//span[normalize-space()='Lissa Hospital']
		String ROM = "//span[normalize-space()="+ clinics+"]" + "";
		driver.findElement(By.xpath(ROM)).click(); 
		}
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		DOB.sendKeys(dob);
		Thread.sleep(2000);
		Select gendertype= new Select(genderoftype);
		gendertype.selectByVisibleText(gender);
		phonenumber.sendKeys(number);
 
		fileupload.sendKeys("/home/cubet/Desktop/WorldAutomation/InputFiles/logoimage.jpeg");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	public void nurseAddition(String typeofuser, String email, String lcnnumber, String speciality, String nameofclinic, String firstname, String lastname, String  Stringidno, String dob, String gender, String number) throws InterruptedException
	{
		
		emailAddress.sendKeys(email);
		
//		Select clinic name
		Thread.sleep(3000);
		if (driver.findElements(By.xpath("//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']")).size() > 0 && driver.findElement(By.xpath("//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']")).isDisplayed()) 
		{
		driver.findElement(By.xpath("//ng-select[@placeholder='Please select clinic name']//div[@class='ng-select-container']")).click(); 
		Thread.sleep(5000);
		String clinics = "\"" + nameofclinic + "\"";
		String ROM = "//span[normalize-space()="+ clinics+"]" + "";
		driver.findElement(By.xpath(ROM)).click(); 
		}
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		DOB.sendKeys(dob);
		Thread.sleep(2000);
		Select gendertype= new Select(genderoftype);
		gendertype.selectByVisibleText(gender);
		phonenumber.sendKeys(number);
 
		fileupload.sendKeys("/home/cubet/Desktop/WorldAutomation/InputFiles/logoimage.jpeg");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	public void patientAddition(String email,String idno, String firstname, String lastname, String dob, String gender, String number, String patientAddress) throws InterruptedException
	{
		
		emailAddress.sendKeys(email);
		
		nationalID.sendKeys(idno);
		
		
		firstName.sendKeys(firstname);
		lastName.sendKeys(lastname);
		DOB.sendKeys(dob);
		Thread.sleep(2000);
		Select gendertype= new Select(genderoftype);
		gendertype.selectByVisibleText(gender);
		phonenumber.sendKeys(number);
		address.sendKeys(patientAddress);
 
		fileupload.sendKeys("/home/cubet/Desktop/WorldAutomation/InputFiles/logoimage.jpeg");
		
		driver.findElement(By.cssSelector("button[type='submit']")).click();
	}
	
	
	
	
	
	
	public void doctordetailfetch() throws IOException, InterruptedException 
	{

		UserDataReader d = new UserDataReader();
		ArrayList<String> data = d.getPharmacyData("Doctor");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);

		adminsitrationpage.doctorAddition(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7), data.get(8), data.get(9), data.get(10));
	}
	
	public void nursedetailfetch() throws IOException, InterruptedException
	{
		UserDataReader d = new UserDataReader();
		ArrayList<String> data = d.getPharmacyData("Nurse");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);

		adminsitrationpage.nurseAddition(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7), data.get(8), data.get(9), data.get(10));
	}
	
	public void patientdetailfetch() throws IOException, InterruptedException
	{
		UserDataReader d = new UserDataReader();
		ArrayList<String> data = d.getPharmacyData("Patient");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);

		adminsitrationpage.patientAddition(data.get(1), data.get(7), data.get(5), data.get(6), data.get(8), data.get(9), data.get(10),data.get(11));
	}
	
	public void receptionistdetailfetch() throws IOException, InterruptedException
	{
		UserDataReader d = new UserDataReader();
		ArrayList<String> data = d.getPharmacyData("Receptionist");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);

		adminsitrationpage.nurseAddition(data.get(0), data.get(1), data.get(2), data.get(3), data.get(4), data.get(5), data.get(6), data.get(7), data.get(8), data.get(9), data.get(10));
	}
	
	public void usernameFetch() throws IOException, InterruptedException
	{
		UserDataReader d = new UserDataReader();
		ArrayList<String> data = d.getPharmacyData("Doctor");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);

//		adminsitrationpage.searchUserName(data.get(5));
	
	}
	
	public void searchUserName() throws IOException, InterruptedException
	{
		UserDataReader d = new UserDataReader();
		ArrayList<String> data = d.getPharmacyData("Doctor");
		AdministrationPage adminsitrationpage = new AdministrationPage(driver);
		Thread.sleep(5000);
		adminsitrationpage.usernameFetch();
		driver.findElement(By.xpath("//input[@placeholder='Search for Names, Emails']")).sendKeys(data.get(5));
		
	}
}
