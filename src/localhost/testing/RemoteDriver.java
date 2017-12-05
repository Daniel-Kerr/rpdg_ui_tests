package localhost.testing;

import java.util.concurrent.TimeUnit;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class RemoteDriver {

	@Parameters("browser")
	@BeforeClass
	
	public static WebDriver buildDriver() {

		try {
			System.setProperty("webdriver.chrome.driver", "Selenium/chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			
			//System.setProperty("webdriver.gecko.driver", "Selenium//geckodriver.exe");
			//WebDriver driver = new FirefoxDriver();
			
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);

			driver.get("http://localhost:3000");
			driver.findElement(By.id("username")).clear();
			driver.findElement(By.id("username")).sendKeys("dan.kerr@rvlti.com");
			driver.findElement(By.id("password")).clear();
			driver.findElement(By.id("password")).sendKeys("litemeup");
			driver.findElement(By.id("loginuser")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//input[@value='rvlt_lv_18']")).click();
			Thread.sleep(1000);
			driver.switchTo().frame(0);
			
			return driver;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Failed due to an unhandled Exception");
			return null;
		}
	}
}
