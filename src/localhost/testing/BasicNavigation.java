//Created by Daniel Kerr 5/30/17
package localhost.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class BasicNavigation {

	WebDriver driver;

	@BeforeTest
	public void setup() {

		driver = Driver.buildDriver();
		//driver = RemoteDriver.buildDriver();
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
	public void closeBrowser() {
		driver.quit();
	}
}
