package localhost.testing;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BasicNavigation {

	WebDriver driver;

	@BeforeTest
	public void setup(){

		try {
			System.setProperty("webdriver.chrome.driver", "Selenium/chromedriver.exe");
			  driver = new ChromeDriver();
			  driver.manage().deleteAllCookies();
			  driver.manage().window().maximize();
			  driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			  driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			  
			  driver.get("http://localhost:3000");
			  
			  
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 0)
	public void statusLinks() {
		driver.findElement(By.linkText("Configuration")).click();
		driver.findElement(By.linkText("Status")).click();
		driver.findElement(By.linkText("Override/Scene Edit")).click();
		driver.findElement(By.linkText("Status")).click();
		driver.findElement(By.linkText("Schedule")).click();
		driver.findElement(By.linkText("Status")).click();
		driver.findElement(By.linkText("Groups")).click();
		driver.findElement(By.linkText("Status")).click();
		driver.findElement(By.linkText("Scene Lists")).click();
		driver.findElement(By.linkText("Status")).click();
		driver.findElement(By.linkText("History")).click();
		driver.findElement(By.linkText("Status")).click();
	}
	
	@Test(priority = 1)
	public void configurationLinks() {
		driver.findElement(By.linkText("Configuration")).click();
		driver.findElement(By.linkText("Override/Scene Edit")).click();
		driver.findElement(By.linkText("Configuration")).click();
		driver.findElement(By.linkText("Schedule")).click();
		driver.findElement(By.linkText("Configuration")).click();
		driver.findElement(By.linkText("Groups")).click();
		driver.findElement(By.linkText("Configuration")).click();
		driver.findElement(By.linkText("Scene Lists")).click();
		driver.findElement(By.linkText("Configuration")).click();
		driver.findElement(By.linkText("History")).click();
		driver.findElement(By.linkText("Configuration")).click();
	}
	
	@Test(priority = 2)
	public void overrideLinks() {
		driver.findElement(By.linkText("Override/Scene Edit")).click();
		driver.findElement(By.linkText("Schedule")).click();
		driver.findElement(By.linkText("Override/Scene Edit")).click();
		driver.findElement(By.linkText("Groups")).click();
		driver.findElement(By.linkText("Override/Scene Edit")).click();
		driver.findElement(By.linkText("Scene Lists")).click();
		driver.findElement(By.linkText("Override/Scene Edit")).click();
		driver.findElement(By.linkText("History")).click();
		driver.findElement(By.linkText("Override/Scene Edit")).click();
	}
	
	@Test(priority = 3)
	public void scheduleLinks() {
		driver.findElement(By.linkText("Schedule")).click();
		driver.findElement(By.linkText("Groups")).click();
		driver.findElement(By.linkText("Schedule")).click();
		driver.findElement(By.linkText("Scene Lists")).click();
		driver.findElement(By.linkText("Schedule")).click();
		driver.findElement(By.linkText("History")).click();
		driver.findElement(By.linkText("Schedule")).click();
	}
	
	@Test(priority = 4)
	public void groupsLinks() {
		driver.findElement(By.linkText("Groups")).click();
		driver.findElement(By.linkText("Scene Lists")).click();
		driver.findElement(By.linkText("Groups")).click();
		driver.findElement(By.linkText("History")).click();
		driver.findElement(By.linkText("Groups")).click();
	}
	
	@Test(priority = 5)
	public void scenelistsLinks() {
		driver.findElement(By.linkText("Scene Lists")).click();
		driver.findElement(By.linkText("History")).click();
		driver.findElement(By.linkText("Scene Lists")).click();
	}
	
	@AfterTest
	public void closeBrowser(){
		driver.quit();
	}

}
