package bloomsProject.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import bloomsProject.TestComponents.BaseTest;
import bloomsemr.pageobjects.PatientListPage;

public class PatientLIstModule extends BaseTest{
	
	@Test
	public void patientListView() throws InterruptedException
	{
		PatientListPage patientlistPage = new PatientListPage(driver);
		patientlistPage.goToPatientList();
		patientlistPage.viewPatientDetails();
		patientlistPage.refermyPatient();
		
	}
	
	@Test
	public void insuranceAddition() throws InterruptedException
	{
		PatientListPage patientlistPage = new PatientListPage(driver);
		patientlistPage.goToPatientList();
		patientlistPage.viewPatientDetails();
		WebElement button = driver.findElement(By.xpath("//span[contains(text(),'Add Insurance')]"));
		if (button.isDisplayed())
		{
		patientlistPage.addInsurance();
		}
		else
		{
		patientlistPage.editInsurance();
		}
	}
	
	@Test
	public void swapthePages() throws InterruptedException
	{
		PatientListPage patientlistPage = new PatientListPage(driver);
		patientlistPage.goToPatientList();
		patientlistPage.viewPatientDetails();
		patientlistPage.swapTabs();
	}

}
