package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageElementsforLogin {
	WebDriver driver;
	
	public PageElementsforLogin(WebDriver rdriver)
	{
		driver = rdriver;
		PageFactory.initElements(driver, this); //'this' to optimize our code instead of specifying each and every page
	}

	//  login page elements
	
	public @FindBy(xpath ="//input[@name='username']")
	WebElement Username;
	
	public @FindBy(xpath="//input[@name='password']")
	WebElement Password;
	
	public @FindBy(xpath="//button[@type='submit']")
	WebElement loginbutton;
	
	public void logincredentials()
	{
		Username.clear();
		Username.sendKeys("Admin");
		Password.clear();
		Password.sendKeys("admin123");
		loginbutton.click();
	}
	
	
}
