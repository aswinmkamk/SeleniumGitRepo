package bloomsProject.Tests;


import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.util.RetryAnalyzerCount;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.AssertJUnit;
import org.testng.IRetryAnalyzer;

import java.io.FileInputStream;
import bloomsemr.AbstractComponents.*;
import java.io.IOException;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Element;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;


import bloomsProject.TestComponents.BaseTest;
import bloomsProject.TestComponents.Retry;
import bloomsemr.AbstractComponents.AbstractComponent;
import bloomsemr.pageobjects.ClinicPage;
import bloomsemr.AbstractComponents.*;
import bloomsemr.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ClinicModule extends BaseTest{
	ExtentReports extent;
		
	
	
	@Test(retryAnalyzer = Retry.class)
	public void addClinic() throws IOException, InterruptedException
	{
		

		ClinicPage clinicPage = new ClinicPage(driver);
		clinicPage.goToAdministration();

		clinicPage.clinicRedirection();
		
		driver.findElement(By.xpath("//button[normalize-space()='Add New Clinic']")).click();
		
		System.out.println("ABC");

		clinicPage.clinicdetailfetch();

		clinicPage.cropandSubmit();
		
	}
	
	@Test(retryAnalyzer = Retry.class)
	public void editClinic() throws InterruptedException
	{
		ClinicPage clinicPage = new ClinicPage(driver);
		
		clinicPage.goToAdministration();
		
		clinicPage.clinicRedirection();
		
		clinicPage.editClinicPage();
		
		
	}
	
	@Test(retryAnalyzer = Retry.class)
	public void searchClinic() throws InterruptedException, IOException
	{
		ClinicPage clinicPage = new ClinicPage(driver);
		
		clinicPage.goToAdministration();
		
		clinicPage.clinicRedirection();
		
		clinicPage.searchName();
		
		
		}
	
	
	
}
