package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.RegistrationPageObjects;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ValidateRegistration {
	
	WebDriver driver;
	
	@BeforeTest
	public void launchApp() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demoqa.com/automation-practice-form");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	}
	
	
	@Test
	public void registrationForm() throws InterruptedException
	{
		RegistrationPageObjects rpo=new RegistrationPageObjects(driver);
		Thread.sleep(2000);
		rpo.registrationFormwithvalidation();
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}

}
