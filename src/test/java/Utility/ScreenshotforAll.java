package Utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotforAll {
	public static WebDriver driver;
	
	public ScreenshotforAll(WebDriver driver)
	{
		this.driver=driver;
	}
	
	  public static void passScreenCapture() throws IOException
	    {
	        Date d = new Date();
    System.out.println(d.toString());

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");         // Your each screenshot will be taken as this format "Year-Month-Date-Hours-Minutes-Seconds"
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    FileUtils.copyFile(scrFile,  new File(".\\screenshots\\"+sdf.format(d)+".png"));      //your screenshot path and convert date string to SimpleDateFormat because windows can't capture screenshot with(:)
}

public static void failScreenCapture() throws IOException
{
    Date d = new Date();
    System.out.println(d.toString());

    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HHmmss");   
    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
    // Now you can do whatever you need to do with it, for example copy somewhere
    FileUtils.copyFile(scrFile, new File(".\\screenshots\\"+sdf.format(d)+".png"));

}

}
