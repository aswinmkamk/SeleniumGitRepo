package bloomsProject.Tests;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


import bloomsProject.TestComponents.BaseTest;
import bloomsProject.TestComponents.Retry;
import bloomsemr.pageobjects.ClinicPage;
import bloomsemr.pageobjects.PharmacyPage;

public class pharmacyModule extends BaseTest{
	
	@Test(retryAnalyzer = Retry.class)
	public void AddPharmacy() throws InterruptedException, IOException
	{
		PharmacyPage pharmacyPage = new PharmacyPage(driver);
		pharmacyPage.goToAdministration();
		pharmacyPage.goToPharmacy();
		pharmacyPage.pharamacyAdd();
		pharmacyPage.pharmacydetailfetch();
		pharmacyPage.pharmacySubmit();
		
	}
	
	
	@Test(retryAnalyzer = Retry.class)
	public void searchPharmacy() throws InterruptedException, IOException
	{
		PharmacyPage pharmacyPage = new PharmacyPage(driver);
		pharmacyPage.goToAdministration();
		pharmacyPage.goToPharmacy();
		pharmacyPage.searchPharmacyName();
	}
	
	

}
