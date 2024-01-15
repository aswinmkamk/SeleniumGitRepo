package bloomsemr.pageobjects;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import bloomsemr.AbstractComponents.AbstractComponent;
import bloomsemr.excelDataReader.CredentialReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LandingPage extends AbstractComponent {
	// Initialize the variable driver which doesn't have life
	WebDriver driver;

	// Create constructor for give the life to the driver
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

//	WebElement userEmail = driver.findElement(By.cssSelector("input[placeholder='Email id']"));
	@FindBy(css = "input[placeholder='Email id']")
	WebElement userEmail;

//	WebElement passwordEle = driver.findElement(By.cssSelector("input[placeholder='Password']"));
	@FindBy(css = "input[placeholder='Password']")
	WebElement passwordEle;

//	WebElement loginSubmit = driver.findElement(By.xpath("//button[normalize-space()='Sign in']"));
	@FindBy(xpath = "//button[normalize-space()='Sign in']")
	WebElement loginSubmit;

	public void loginApplication(String email, String password) {

		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		loginSubmit.click();
	}

	public void credentials() throws IOException {

		CredentialReader d = new CredentialReader();
		ArrayList<String> data = d.getData("Credentials");
		LandingPage landingPage = new LandingPage(driver);

		landingPage.loginApplication(data.get(1), data.get(2));
	}

	public void goTo() {
		driver.get("https://bloomsemr.cubettech.in/");
		driver.manage().window().maximize();
	}

}
