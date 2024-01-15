package bloomsProject.Tests;

import org.testng.annotations.Test;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.ListDocument.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import bloomsProject.TestComponents.BaseTest;
import bloomsemr.pageobjects.BookSlotPage;
import bloomsemr.pageobjects.ConsultationPage;

public class ConsultationModule extends BaseTest{
	
	
   @Test
    public void createAppointment() throws InterruptedException {
        ConsultationPage consultationPage = new ConsultationPage(driver);
        BookSlotPage bookslotPage = new BookSlotPage(driver);

        consultationPage.goTocalender();;

        if (isElementPresent(driver, By.xpath("//mwl-calendar-month-cell[@class='cal-cell cal-day-cell cal-today cal-in-month ng-star-inserted cal-has-events']//div[contains(text(),'06:00 PM - 07:00 PM')]"))) {
            // If the element is present, close the browser
            System.out.println("Slot found. Closing the browser.");

        } else {
            // If the element is not present, proceed with the steps
            consultationPage.selectDayforAppointment();
            bookslotPage.createaSlot();
            consultationPage.goTocalender();
        }
    }

    private boolean isElementPresent(WebDriver driver, By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

	
   @Test
    public void patientAppointmentAllocation() throws InterruptedException {
        ConsultationPage consultationPage = new ConsultationPage(driver);

        consultationPage.goTocalender();

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
            WebElement slot = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//strong[normalize-space()='Slot Available']")));

            consultationPage.assignPatienttotheSlot();
        } catch (Exception e) {
            System.out.println("Slot not available");
            // You can handle the case where the slot is not available, for example, throw an exception or log a message.
        }
    }



	
	@Test
	public void startConsultation() throws InterruptedException, IOException
	{
		
		ConsultationPage consultationPage = new ConsultationPage(driver);
		consultationPage.goTocalender();
		
//		TO START CONSULTATION WITH AVAILABLE DATE
		Thread.sleep(6000);
		driver.findElement(By.xpath("//mwl-calendar-month-cell[@class='cal-cell cal-day-cell cal-today cal-in-month ng-star-inserted cal-has-events']//div[@class='d-flex justify-content-between align-items-center']")).click();
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[@id='btnSubmit']")).click();
		
		driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();
		
		Thread.sleep(4000);
		
		consultationPage.subjectiveDetailFetch();
		
		consultationPage.systemReviewAddition();
		
		consultationPage.vitalDataAddition();
		
		consultationPage.goToNext();
		
		consultationPage.objectiveDetailFetch();
		
		consultationPage.goToNext();
		
		consultationPage.diagnosisAddition();
		
		consultationPage.planDetailFetch();
		
		consultationPage.goToNext();
		
		consultationPage.medicationAddition();
		
		consultationPage.endConsultation();
			
		consultationPage.addadvice();
		
		consultationPage.eSign();
		
		consultationPage.signatureAdd();
		
	}
}
