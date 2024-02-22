package UI;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObject.PageElementsforLogin;
import Utility.ScreenshotforAll;
import Utility.XLutility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginwithValidandInvalid {
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
		
		@Test(dataProvider="excel data")
		void login(String user,String pwd,String exp) throws InterruptedException, IOException
		{
			
			PageElementsforLogin pageobjects=new PageElementsforLogin(driver);
			Thread.sleep(1000);
			//pageelements method
			pageobjects.Username.sendKeys(user);
			pageobjects.Password.sendKeys(pwd);
			pageobjects.loginbutton.click();
			
			String exp_title="";
			String act_title=driver.getTitle();
			if(exp.equals("valid"))
			{
				if(exp_title.equals(act_title)) {
					
					ScreenshotforAll.passScreenCapture();
					driver.navigate().back();
					Assert.assertTrue(true);
				}
				else
				{
					ScreenshotforAll.failScreenCapture();
					Assert.assertTrue(false);
				}
			}
			else if(exp.equals("invalid"))
			{
				if(exp_title.equals(act_title))
				{
					ScreenshotforAll.passScreenCapture();
					driver.navigate().back();
					Assert.assertTrue(true);
				}
				else
				{
					ScreenshotforAll.failScreenCapture();
					Assert.assertTrue(false);	
				}
			}
			
			
		}
		
		@DataProvider(name="excel data")
		public String[][] multipledata() throws IOException
		{
			String path=".\\src\\test\\resources\\exceldata\\Logindata.xlsx";
			XLutility xlutil=new XLutility(path);
			int totalrow=xlutil.getRowCount("Sheet1");
			int totalcol=xlutil.getCellCount("Sheet1",1);
			String logindata[][]=new String[totalrow][totalcol];
			
			for(int i=1;i<=totalrow;i++)
			{
				for(int j=0;j<totalcol;j++)
				{
					logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
				}
			}
			
			
			return logindata;
			
		}
		@AfterTest
		public void teardown()
		{
			driver.quit();
		}
		

			
			
}
