package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class RegistrationPageObjects {

	WebDriver driver;
	public RegistrationPageObjects(WebDriver rdriver)
	{
		this.driver=rdriver;
		PageFactory.initElements(driver,this);
	}
	
	
	
	public @FindBy(xpath="//input[@id='firstName']")
	WebElement firstname;
	public @FindBy(xpath="//input[@id='lastName']")
	WebElement lastname;
	public @FindBy(xpath="//input[@id='userEmail']")
	WebElement email;
	public @FindBy(xpath="//input[@id=\"gender-radio-1\"]")
	WebElement radioFirstoption;
	public @FindBy(xpath="//input[@id='userNumber']")
	WebElement mobNumber;
	public @FindBy(xpath="//div[@class='react-datepicker-wrapper']")
	WebElement dobfield;
	//public @FindBy(xpath="//div[@class='subjects-auto-complete__value-container subjects-auto-complete__value-container--is-multi css-1hwfws3']")
	//WebElement subject;
	public @FindBy(xpath="//label[@for='hobbies-checkbox-3']")
	WebElement chkbx3;////label[@for='hobbies-checkbox-3']
	public @FindBy(xpath="//input[@id='uploadPicture']")
	WebElement pic;
	public @FindBy(xpath="//textarea[@id='currentAddress']")
	WebElement address;
	public @FindBy(xpath="//*[@id=\"state\"]/div/div[1]/div[1]")
	WebElement statedropdownbtn;
	public @FindBy(xpath="//div[@id='react-select-3-option-1']")
	WebElement statename;//
	public @FindBy(xpath="//*[@id=\"city\"]/div/div[1]")
	WebElement citydropdownbtn;
	public @FindBy(xpath="//*[@id=\"react-select-4-option-1\"]")
	WebElement cityname;
	public @FindBy(xpath="//button[@id='submit']")
	WebElement submitBtn;

	public void registrationFormwithvalidation() throws InterruptedException
	{
		firstname.clear();
		Boolean val=firstname.isEnabled();
		if(val==true)
		{
			firstname.sendKeys("practise");
		}
		lastname.clear();
		Boolean val1=lastname.isEnabled();
		if(val1==true)
		{
			lastname.sendKeys("queries");
		}
		
		email.clear();
		Boolean val2=email.isEnabled();
		if(val2==true)
		{
			email.sendKeys("queries@mail.com");
		}
//		
//		Boolean val3=radioFirstoption.isSelected();
//			Thread.sleep(2000);
//			System.out.println("boolean vlaue for radio button "+val3);
//			radioFirstoption.click();
//		
		mobNumber.clear();
		mobNumber.sendKeys("1234567890");
		dobfield.click();
		WebElement mnth=driver.findElement(By.xpath("//select[@class='react-datepicker__month-select']"));
		mnth.click();
		Select month=new Select(mnth);
		month.selectByVisibleText("March");
		WebElement year=driver.findElement(By.xpath(("//*[@id=\"dateOfBirth\"]/div[2]/div[2]/div/div/div[2]/div[1]/div[2]/div[2]/select")));
		Select yearoption=new Select(year);
		yearoption.selectByVisibleText("2023");
		WebElement day=driver.findElement(By.xpath("//div[@aria-label='Choose Wednesday, March 1st, 2023']"));
		day.click();////div[@aria-label='Choose Wednesday, March 1st, 2023']
		Thread.sleep(2000);
		//subject.sendKeys("Maths,English");
		//Boolean val4=chkbx3.isSelected();
		//if(val4==true)
		
			Thread.sleep(2000);
			chkbx3.click();
				address.clear();
		Boolean val5=address.isDisplayed();
		if(val5==true)
		{
			address.sendKeys("1,streetlane,Allstate.");
		}
		Boolean val6=statedropdownbtn.isEnabled();
		if(val6==true)
		{
			statedropdownbtn.click();
			Thread.sleep(2000);
			statename.click();			
		}
		
		Boolean val7=citydropdownbtn.isEnabled();
		if(val7==true)
		{
			citydropdownbtn.click();
			Thread.sleep(2000);
			cityname.click();			
		}
		
		Boolean val8=submitBtn.isEnabled();
		if(val8==true)
		{
			submitBtn.click();
					
		}
		System.out.println("Validated registration form");
	}
	
}
