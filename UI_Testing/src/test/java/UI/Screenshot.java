package UI;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot {

	public static void main(String[] args) throws InterruptedException, IOException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// launching the browser and webapplication
		Thread.sleep(1000);
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		TakesScreenshot ts=(TakesScreenshot)driver;
		// screenshot image is saved in memory
		File src=ts.getScreenshotAs(OutputType.FILE);
		//now saving the screenshot image in particular location where path can be customizable
		File target=new File(".\\screenshots\\homepage.png");
		FileUtils.copyFile(src, target);
		driver.close();
			
	}
}
