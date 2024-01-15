package bloomsProject.TestComponents;

import org.testng.annotations.AfterMethod;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import bloomsemr.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public LandingPage landingPage;
	
	public WebDriver initializeDriver() throws IOException
	{
	//Properties class
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//src//main//java//bloomsemr//Resources//GlobalData.properties");
	prop.load(fis);
	String browserName = prop.getProperty("browser");
	
	
	if(browserName.equalsIgnoreCase("chrome"))
	{
	// Handling expired SSL Certificate
	ChromeOptions options = new ChromeOptions();
	options.setAcceptInsecureCerts(true);
	
	
//Download the webdriver based on the chrome version automatically
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver(options);

}
	else if(browserName.equalsIgnoreCase("firefox"))
	{
		//firefox
	}
	else {
        throw new IllegalArgumentException("Unsupported browser: " + browserName);
    }
	driver.manage().window().maximize();
	driver.manage().deleteAllCookies();
	return driver;
}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "/reports/" + testCaseName + ".png");
		FileUtils.copyFile(source, file);
		return System.getProperty("user.dir") + "/reports/" + testCaseName + ".png";
	}

@BeforeMethod
public LandingPage launchApplication() throws IOException
{
	driver = initializeDriver();
	landingPage = new LandingPage(driver);	
	landingPage.goTo();
	landingPage.credentials();
	return landingPage;

	
}

//@AfterMethod
@AfterMethod
public void tearDown()
{
//	driver.close();
}
	
}
