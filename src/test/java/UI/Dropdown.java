package UI;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dropdown {

	public static void main(String[] args) throws InterruptedException
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.opencart.com/index.php?route=cms/feature");
		
		driver.manage().window().maximize();
		Thread.sleep(2000);
		
		// initally clicking the 'Resource " on the header page 
		driver.findElement(By.xpath("//*[@id=\"navbar-collapse-header\"]/ul/li[6]/a")).click();
		
		// then storing all the list of options in a variable
		
		List<WebElement> listofalloptions=driver.findElements(By.xpath("//ul[@class=\"dropdown-menu\"]/li"));
		
		System.out.println("size of all options"+listofalloptions.size());
		
		for(WebElement singleoption:listofalloptions)
		{
			//here from the list trying to choose one option 
			if(singleoption.getText().equalsIgnoreCase("developer"))
			{
				singleoption.click();
				break;
			}
		}
		
		System.out.println(driver.getTitle());
		
	}
}
