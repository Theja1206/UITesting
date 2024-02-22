package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObject.PageElementsforLogin;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginPage {
	WebDriver driver;
//crerating object for pagelements  class to access variables and methods  
	
	@BeforeTest
	public void launch() throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	// launching the browser and webapplication
	Thread.sleep(1000);
	driver.manage().window().maximize();
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
	}
	
	@Test
	void login() throws InterruptedException
	{
		
		PageElementsforLogin pageobjects=new PageElementsforLogin(driver);
		Thread.sleep(1000);
		//pageelements method
		pageobjects.logincredentials();
		System.out.println("user successfully loggedin");
		
		driver.close();
	}
	
	@AfterTest
	public void teardown()
	{
		driver.quit();
	}
	

		
		
		
	
}
