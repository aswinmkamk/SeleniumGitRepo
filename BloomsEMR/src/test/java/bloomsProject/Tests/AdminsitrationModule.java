package bloomsProject.Tests;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

import bloomsProject.TestComponents.BaseTest;
import bloomsemr.pageobjects.AdministrationPage;
import bloomsemr.pageobjects.ClinicPage;

public class AdminsitrationModule extends BaseTest{
	
	@Test
	public void AddDoctor() throws InterruptedException, IOException {
		
	    AdministrationPage administrationpage = new AdministrationPage(driver);

	    administrationpage.goToAdministration();
	    administrationpage.goToDoctor();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(".modal-body")).click();
	    Thread.sleep(5000);
	    administrationpage.doctordetailfetch();

	}
	
	@Test
	public void AddNurse() throws InterruptedException, IOException
	{
	    AdministrationPage administrationpage = new AdministrationPage(driver);

	    administrationpage.goToAdministration();
	    administrationpage.goToNurse();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(".modal-body")).click();
	    Thread.sleep(5000);
	    administrationpage.nursedetailfetch();
	    Thread.sleep(5000);

	}
	
	@Test
	public void AddPatient() throws InterruptedException, IOException
	{
	    AdministrationPage administrationpage = new AdministrationPage(driver);

	    administrationpage.goToAdministration();
	    administrationpage.goToPatient();
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(".modal-body")).click();
	    Thread.sleep(5000);
	    administrationpage.patientdetailfetch();

	}
	
	@Test
	public void AddReceptionist() throws InterruptedException, IOException
	{
	    AdministrationPage administrationpage = new AdministrationPage(driver);

	    administrationpage.goToAdministration();
	    administrationpage.goToReceptionist();;
	    Thread.sleep(5000);
	    driver.findElement(By.cssSelector(".modal-body")).click();
	    Thread.sleep(5000);
	    administrationpage.receptionistdetailfetch();
	}
	
	@Test
	public void editUser() throws InterruptedException
	{
	    AdministrationPage administrationpage = new AdministrationPage(driver);

	    administrationpage.goToAdministration();
	    Thread.sleep(4000);
	    administrationpage.editandSubmit();
	}
	
	@Test
	public void searchUser() throws InterruptedException, IOException
	{
	    AdministrationPage administrationpage = new AdministrationPage(driver);

	    administrationpage.goToAdministration();
	    Thread.sleep(2000);
	    administrationpage.searchUserName();
	}
	
	//Negative testcase
	@Test
	public void searchWithInvalidKeyword() throws InterruptedException, IOException
	{
	    AdministrationPage administrationpage = new AdministrationPage(driver);

	    administrationpage.goToAdministration();
	    Thread.sleep(2000);
	    driver.findElement(By.xpath("//input[@placeholder='Search for Names, Emails']")).sendKeys("Nonexist");
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("//*[contains(text(),' No Data Available ')]")).isDisplayed();
	    
	    
	}
	


}
