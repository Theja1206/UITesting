package UI;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigatetoWebsite {
	
	public static void main(String args[]) throws InterruptedException {
		// set the browser

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		// launching the browser and webapplication
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println("title"+driver.getTitle());
		Thread.sleep(1000);
	//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		// navigating to google page
		driver.navigate().to("https://www.google.com/");
		// validating title of the navigated link
		String title = driver.getTitle();
		Assert.assertEquals("Google", title);
		System.out.println("Title of the page "+title);
		// find the element to click on a gmail link
		driver.findElement(By.xpath("//a[@class='gb_H'][1]")).click();
		// closing all the browser windows
		driver.quit();

	}

}
